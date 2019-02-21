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

import com.portal_egov.portlet.contacts.model.ContactsProperty;

import java.util.List;

/**
 * The persistence utility for the contacts property service. This utility wraps {@link ContactsPropertyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsPropertyPersistence
 * @see ContactsPropertyPersistenceImpl
 * @generated
 */
public class ContactsPropertyUtil {
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
	public static void clearCache(ContactsProperty contactsProperty) {
		getPersistence().clearCache(contactsProperty);
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
	public static List<ContactsProperty> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactsProperty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactsProperty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ContactsProperty update(ContactsProperty contactsProperty,
		boolean merge) throws SystemException {
		return getPersistence().update(contactsProperty, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ContactsProperty update(ContactsProperty contactsProperty,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contactsProperty, merge, serviceContext);
	}

	/**
	* Caches the contacts property in the entity cache if it is enabled.
	*
	* @param contactsProperty the contacts property
	*/
	public static void cacheResult(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty) {
		getPersistence().cacheResult(contactsProperty);
	}

	/**
	* Caches the contacts properties in the entity cache if it is enabled.
	*
	* @param contactsProperties the contacts properties
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> contactsProperties) {
		getPersistence().cacheResult(contactsProperties);
	}

	/**
	* Creates a new contacts property with the primary key. Does not add the contacts property to the database.
	*
	* @param propertyId the primary key for the new contacts property
	* @return the new contacts property
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty create(
		long propertyId) {
		return getPersistence().create(propertyId);
	}

	/**
	* Removes the contacts property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propertyId the primary key of the contacts property
	* @return the contacts property that was removed
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty remove(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().remove(propertyId);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsProperty updateImpl(
		com.portal_egov.portlet.contacts.model.ContactsProperty contactsProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactsProperty, merge);
	}

	/**
	* Returns the contacts property with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsPropertyException} if it could not be found.
	*
	* @param propertyId the primary key of the contacts property
	* @return the contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().findByPrimaryKey(propertyId);
	}

	/**
	* Returns the contacts property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propertyId the primary key of the contacts property
	* @return the contacts property, or <code>null</code> if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByPrimaryKey(
		long propertyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(propertyId);
	}

	/**
	* Returns all the contacts properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the contacts properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @return the range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the contacts properties where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the contacts properties before and after the current contacts property in the ordered set where companyId = &#63;.
	*
	* @param propertyId the primary key of the current contacts property
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty[] findByCompany_PrevAndNext(
		long propertyId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence()
				   .findByCompany_PrevAndNext(propertyId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the contacts properties where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the contacts properties where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @return the range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the contacts properties where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the contacts properties before and after the current contacts property in the ordered set where groupId = &#63;.
	*
	* @param propertyId the primary key of the current contacts property
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty[] findByGroup_PrevAndNext(
		long propertyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence()
				   .findByGroup_PrevAndNext(propertyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contacts properties that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contacts properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the contacts properties that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @return the range of matching contacts properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the contacts properties that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the contacts properties before and after the current contacts property in the ordered set of contacts properties that the user has permission to view where groupId = &#63;.
	*
	* @param propertyId the primary key of the current contacts property
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty[] filterFindByGroup_PrevAndNext(
		long propertyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(propertyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contacts properties where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContact(contactId);
	}

	/**
	* Returns a range of all the contacts properties where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @return the range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContact(
		long contactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContact(contactId, start, end);
	}

	/**
	* Returns an ordered range of all the contacts properties where contactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContact(
		long contactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContact(contactId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().findByContact_First(contactId, orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByContact_First(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContact_First(contactId, orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence().findByContact_Last(contactId, orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByContact_Last(
		long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByContact_Last(contactId, orderByComparator);
	}

	/**
	* Returns the contacts properties before and after the current contacts property in the ordered set where contactId = &#63;.
	*
	* @param propertyId the primary key of the current contacts property
	* @param contactId the contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty[] findByContact_PrevAndNext(
		long propertyId, long contactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence()
				   .findByContact_PrevAndNext(propertyId, contactId,
			orderByComparator);
	}

	/**
	* Returns all the contacts properties where contactId = &#63; and propertyKey = &#63;.
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @return the matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContactAndPropertyKey(
		long contactId, java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndPropertyKey(contactId, propertyKey);
	}

	/**
	* Returns a range of all the contacts properties where contactId = &#63; and propertyKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @return the range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContactAndPropertyKey(
		long contactId, java.lang.String propertyKey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndPropertyKey(contactId, propertyKey, start,
			end);
	}

	/**
	* Returns an ordered range of all the contacts properties where contactId = &#63; and propertyKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByContactAndPropertyKey(
		long contactId, java.lang.String propertyKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactAndPropertyKey(contactId, propertyKey, start,
			end, orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByContactAndPropertyKey_First(
		long contactId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence()
				   .findByContactAndPropertyKey_First(contactId, propertyKey,
			orderByComparator);
	}

	/**
	* Returns the first contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByContactAndPropertyKey_First(
		long contactId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactAndPropertyKey_First(contactId, propertyKey,
			orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty findByContactAndPropertyKey_Last(
		long contactId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence()
				   .findByContactAndPropertyKey_Last(contactId, propertyKey,
			orderByComparator);
	}

	/**
	* Returns the last contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts property, or <code>null</code> if a matching contacts property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty fetchByContactAndPropertyKey_Last(
		long contactId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactAndPropertyKey_Last(contactId, propertyKey,
			orderByComparator);
	}

	/**
	* Returns the contacts properties before and after the current contacts property in the ordered set where contactId = &#63; and propertyKey = &#63;.
	*
	* @param propertyId the primary key of the current contacts property
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts property
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsPropertyException if a contacts property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.ContactsProperty[] findByContactAndPropertyKey_PrevAndNext(
		long propertyId, long contactId, java.lang.String propertyKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsPropertyException {
		return getPersistence()
				   .findByContactAndPropertyKey_PrevAndNext(propertyId,
			contactId, propertyKey, orderByComparator);
	}

	/**
	* Returns all the contacts properties.
	*
	* @return the contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the contacts properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contacts properties
	* @param end the upper bound of the range of contacts properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contacts properties where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the contacts properties where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the contacts properties where contactId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContact(contactId);
	}

	/**
	* Removes all the contacts properties where contactId = &#63; and propertyKey = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactAndPropertyKey(long contactId,
		java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContactAndPropertyKey(contactId, propertyKey);
	}

	/**
	* Removes all the contacts properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contacts properties where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of contacts properties where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of contacts properties that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contacts properties that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of contacts properties where contactId = &#63;.
	*
	* @param contactId the contact ID
	* @return the number of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContact(contactId);
	}

	/**
	* Returns the number of contacts properties where contactId = &#63; and propertyKey = &#63;.
	*
	* @param contactId the contact ID
	* @param propertyKey the property key
	* @return the number of matching contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactAndPropertyKey(long contactId,
		java.lang.String propertyKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByContactAndPropertyKey(contactId, propertyKey);
	}

	/**
	* Returns the number of contacts properties.
	*
	* @return the number of contacts properties
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactsPropertyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactsPropertyPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.contacts.service.ClpSerializer.getServletContextName(),
					ContactsPropertyPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactsPropertyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ContactsPropertyPersistence persistence) {
	}

	private static ContactsPropertyPersistence _persistence;
}