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

import com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty;

/**
 * The persistence interface for the contacts department property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentPropertyPersistenceImpl
 * @see ContactsDepartmentPropertyUtil
 * @generated
 */
public interface ContactsDepartmentPropertyPersistence extends BasePersistence<ContactsDepartmentProperty> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactsDepartmentPropertyUtil} to access the contacts department property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contacts department property in the entity cache if it is enabled.
	*
	* @param contactsDepartmentProperty the contacts department property
	*/
	public void cacheResult(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty);

	/**
	* Caches the contacts department properties in the entity cache if it is enabled.
	*
	* @param contactsDepartmentProperties the contacts department properties
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> contactsDepartmentProperties);

	/**
	* Creates a new contacts department property with the primary key. Does not add the contacts department property to the database.
	*
	* @param propertyId the primary key for the new contacts department property
	* @return the new contacts department property
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty create(
		long propertyId);

	/**
	* Removes the contacts department property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property that was removed
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty remove(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department property with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException} if it could not be found.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the contacts department property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property, or <code>null</code> if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contacts department properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts department properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @return the range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts department properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the first contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the last contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department properties before and after the current contacts department property in the ordered set where companyId = &#63;.
	*
	* @param propertyId the primary key of the current contacts department property
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByCompany_PrevAndNext(
		long propertyId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns all the contacts department properties where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts department properties where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @return the range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts department properties where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the first contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the last contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department properties before and after the current contacts department property in the ordered set where groupId = &#63;.
	*
	* @param propertyId the primary key of the current contacts department property
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByGroup_PrevAndNext(
		long propertyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns all the contacts department properties that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts department properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts department properties that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @return the range of matching contacts department properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts department properties that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts department properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department properties before and after the current contacts department property in the ordered set of contacts department properties that the user has permission to view where groupId = &#63;.
	*
	* @param propertyId the primary key of the current contacts department property
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] filterFindByGroup_PrevAndNext(
		long propertyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns all the contacts department properties where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts department properties where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @return the range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts department properties where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the first contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the last contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department properties before and after the current contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param propertyId the primary key of the current contacts department property
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByContactsDepartment_PrevAndNext(
		long propertyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns all the contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @return the range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, java.lang.String propertyKey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, java.lang.String propertyKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartmentAndKey_First(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the first contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartmentAndKey_First(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartmentAndKey_Last(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns the last contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartmentAndKey_Last(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts department properties before and after the current contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param propertyId the primary key of the current contacts department property
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByContactsDepartmentAndKey_PrevAndNext(
		long propertyId, long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException;

	/**
	* Returns all the contacts department properties.
	*
	* @return the contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contacts department properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contacts department properties
	* @param end the upper bound of the range of contacts department properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts department properties where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts department properties where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts department properties where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactsDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts department properties where departmentId = &#63; and propertyKey = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactsDepartmentAndKey(long departmentId,
		java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contacts department properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts department properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts department properties where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts department properties that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts department properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts department properties where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactsDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactsDepartmentAndKey(long departmentId,
		java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contacts department properties.
	*
	* @return the number of contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}