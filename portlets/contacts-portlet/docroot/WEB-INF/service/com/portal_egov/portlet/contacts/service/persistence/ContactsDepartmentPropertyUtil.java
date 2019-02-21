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

import com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty;

import java.util.List;

/**
 * The persistence utility for the contacts department property service. This utility wraps {@link ContactsDepartmentPropertyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentPropertyPersistence
 * @see ContactsDepartmentPropertyPersistenceImpl
 * @generated
 */
public class ContactsDepartmentPropertyUtil {
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
	public static void clearCache(
		ContactsDepartmentProperty contactsDepartmentProperty) {
		getPersistence().clearCache(contactsDepartmentProperty);
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
	public static List<ContactsDepartmentProperty> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactsDepartmentProperty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactsDepartmentProperty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ContactsDepartmentProperty update(
		ContactsDepartmentProperty contactsDepartmentProperty, boolean merge)
		throws SystemException {
		return getPersistence().update(contactsDepartmentProperty, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ContactsDepartmentProperty update(
		ContactsDepartmentProperty contactsDepartmentProperty, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(contactsDepartmentProperty, merge, serviceContext);
	}

	/**
	* Caches the contacts department property in the entity cache if it is enabled.
	*
	* @param contactsDepartmentProperty the contacts department property
	*/
	public static void cacheResult(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty) {
		getPersistence().cacheResult(contactsDepartmentProperty);
	}

	/**
	* Caches the contacts department properties in the entity cache if it is enabled.
	*
	* @param contactsDepartmentProperties the contacts department properties
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> contactsDepartmentProperties) {
		getPersistence().cacheResult(contactsDepartmentProperties);
	}

	/**
	* Creates a new contacts department property with the primary key. Does not add the contacts department property to the database.
	*
	* @param propertyId the primary key for the new contacts department property
	* @return the new contacts department property
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty create(
		long propertyId) {
		return getPersistence().create(propertyId);
	}

	/**
	* Removes the contacts department property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property that was removed
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty remove(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence().remove(propertyId);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty contactsDepartmentProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactsDepartmentProperty, merge);
	}

	/**
	* Returns the contacts department property with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException} if it could not be found.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence().findByPrimaryKey(propertyId);
	}

	/**
	* Returns the contacts department property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertyId the primary key of the contacts department property
	* @return the contacts department property, or <code>null</code> if a contacts department property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(propertyId);
	}

	/**
	* Returns all the contacts department properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts department property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByCompany_PrevAndNext(
		long propertyId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByCompany_PrevAndNext(propertyId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the contacts department properties where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts department property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByGroup_PrevAndNext(
		long propertyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByGroup_PrevAndNext(propertyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contacts department properties that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts department properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] filterFindByGroup_PrevAndNext(
		long propertyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(propertyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contacts department properties where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContactsDepartment(departmentId);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactsDepartment(departmentId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartment(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactsDepartment(departmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByContactsDepartment_First(departmentId,
			orderByComparator);
	}

	/**
	* Returns the first contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactsDepartment_First(departmentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByContactsDepartment_Last(departmentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts department property in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactsDepartment_Last(departmentId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByContactsDepartment_PrevAndNext(
		long propertyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByContactsDepartment_PrevAndNext(propertyId,
			departmentId, orderByComparator);
	}

	/**
	* Returns all the contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @return the matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactsDepartmentAndKey(departmentId, propertyKey);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, java.lang.String propertyKey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactsDepartmentAndKey(departmentId, propertyKey,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByContactsDepartmentAndKey(
		long departmentId, java.lang.String propertyKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactsDepartmentAndKey(departmentId, propertyKey,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartmentAndKey_First(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByContactsDepartmentAndKey_First(departmentId,
			propertyKey, orderByComparator);
	}

	/**
	* Returns the first contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartmentAndKey_First(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactsDepartmentAndKey_First(departmentId,
			propertyKey, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty findByContactsDepartmentAndKey_Last(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByContactsDepartmentAndKey_Last(departmentId,
			propertyKey, orderByComparator);
	}

	/**
	* Returns the last contacts department property in the ordered set where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts department property, or <code>null</code> if a matching contacts department property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty fetchByContactsDepartmentAndKey_Last(
		long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactsDepartmentAndKey_Last(departmentId,
			propertyKey, orderByComparator);
	}

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
	public static com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty[] findByContactsDepartmentAndKey_PrevAndNext(
		long propertyId, long departmentId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsDepartmentPropertyException {
		return getPersistence()
				   .findByContactsDepartmentAndKey_PrevAndNext(propertyId,
			departmentId, propertyKey, orderByComparator);
	}

	/**
	* Returns all the contacts department properties.
	*
	* @return the contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contacts department properties where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the contacts department properties where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the contacts department properties where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactsDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContactsDepartment(departmentId);
	}

	/**
	* Removes all the contacts department properties where departmentId = &#63; and propertyKey = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactsDepartmentAndKey(long departmentId,
		java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByContactsDepartmentAndKey(departmentId, propertyKey);
	}

	/**
	* Removes all the contacts department properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contacts department properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of contacts department properties where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of contacts department properties that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts department properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of contacts department properties where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactsDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContactsDepartment(departmentId);
	}

	/**
	* Returns the number of contacts department properties where departmentId = &#63; and propertyKey = &#63;.
	*
	* @param departmentId the department ID
	* @param propertyKey the property key
	* @return the number of matching contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactsDepartmentAndKey(long departmentId,
		java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByContactsDepartmentAndKey(departmentId, propertyKey);
	}

	/**
	* Returns the number of contacts department properties.
	*
	* @return the number of contacts department properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactsDepartmentPropertyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactsDepartmentPropertyPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.contacts.service.ClpSerializer.getServletContextName(),
					ContactsDepartmentPropertyPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactsDepartmentPropertyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(
		ContactsDepartmentPropertyPersistence persistence) {
	}

	private static ContactsDepartmentPropertyPersistence _persistence;
}