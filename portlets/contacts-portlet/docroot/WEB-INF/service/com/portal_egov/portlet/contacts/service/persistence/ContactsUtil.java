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

import com.portal_egov.portlet.contacts.model.Contacts;

import java.util.List;

/**
 * The persistence utility for the contacts service. This utility wraps {@link ContactsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsPersistence
 * @see ContactsPersistenceImpl
 * @generated
 */
public class ContactsUtil {
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
	public static void clearCache(Contacts contacts) {
		getPersistence().clearCache(contacts);
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
	public static List<Contacts> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Contacts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Contacts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Contacts update(Contacts contacts, boolean merge)
		throws SystemException {
		return getPersistence().update(contacts, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Contacts update(Contacts contacts, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contacts, merge, serviceContext);
	}

	/**
	* Caches the contacts in the entity cache if it is enabled.
	*
	* @param contacts the contacts
	*/
	public static void cacheResult(
		com.portal_egov.portlet.contacts.model.Contacts contacts) {
		getPersistence().cacheResult(contacts);
	}

	/**
	* Caches the contactses in the entity cache if it is enabled.
	*
	* @param contactses the contactses
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.contacts.model.Contacts> contactses) {
		getPersistence().cacheResult(contactses);
	}

	/**
	* Creates a new contacts with the primary key. Does not add the contacts to the database.
	*
	* @param contactId the primary key for the new contacts
	* @return the new contacts
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts create(
		long contactId) {
		return getPersistence().create(contactId);
	}

	/**
	* Removes the contacts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts that was removed
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts remove(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence().remove(contactId);
	}

	public static com.portal_egov.portlet.contacts.model.Contacts updateImpl(
		com.portal_egov.portlet.contacts.model.Contacts contacts, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contacts, merge);
	}

	/**
	* Returns the contacts with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsException} if it could not be found.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence().findByPrimaryKey(contactId);
	}

	/**
	* Returns the contacts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts, or <code>null</code> if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactId);
	}

	/**
	* Returns all the contactses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the contactses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the contactses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where companyId = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByCompany_PrevAndNext(
		long contactId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByCompany_PrevAndNext(contactId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the contactses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the contactses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the contactses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where groupId = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByGroup_PrevAndNext(
		long contactId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByGroup_PrevAndNext(contactId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the contactses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] filterFindByGroup_PrevAndNext(
		long contactId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(contactId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the contactses where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndStatus(
		long companyId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyAndStatus(companyId, contactStatus);
	}

	/**
	* Returns a range of all the contactses where companyId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndStatus(
		long companyId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, contactStatus, start, end);
	}

	/**
	* Returns an ordered range of all the contactses where companyId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndStatus(
		long companyId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, contactStatus, start,
			end, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndStatus_First(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByCompanyAndStatus_First(companyId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndStatus_First(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_First(companyId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndStatus_Last(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByCompanyAndStatus_Last(companyId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndStatus_Last(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_Last(companyId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByCompanyAndStatus_PrevAndNext(
		long contactId, long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByCompanyAndStatus_PrevAndNext(contactId, companyId,
			contactStatus, orderByComparator);
	}

	/**
	* Returns all the contactses where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndStatus(
		long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, contactStatus);
	}

	/**
	* Returns a range of all the contactses where groupId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndStatus(
		long groupId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, contactStatus, start, end);
	}

	/**
	* Returns an ordered range of all the contactses where groupId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndStatus(
		long groupId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, contactStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByGroupAndStatus_First(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByGroupAndStatus_First(groupId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndStatus_First(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_First(groupId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByGroupAndStatus_Last(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByGroupAndStatus_Last(groupId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndStatus_Last(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_Last(groupId, contactStatus,
			orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByGroupAndStatus_PrevAndNext(
		long contactId, long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByGroupAndStatus_PrevAndNext(contactId, groupId,
			contactStatus, orderByComparator);
	}

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndStatus(
		long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndStatus(groupId, contactStatus);
	}

	/**
	* Returns a range of all the contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndStatus(
		long groupId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndStatus(groupId, contactStatus, start,
			end);
	}

	/**
	* Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndStatus(
		long groupId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndStatus(groupId, contactStatus, start,
			end, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] filterFindByGroupAndStatus_PrevAndNext(
		long contactId, long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .filterFindByGroupAndStatus_PrevAndNext(contactId, groupId,
			contactStatus, orderByComparator);
	}

	/**
	* Returns all the contactses where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(companyId, departmentId);
	}

	/**
	* Returns a range of all the contactses where companyId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(companyId, departmentId, start,
			end);
	}

	/**
	* Returns an ordered range of all the contactses where companyId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(companyId, departmentId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndCompany_First(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByDepartmentAndCompany_First(companyId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndCompany_First(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndCompany_First(companyId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndCompany_Last(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByDepartmentAndCompany_Last(companyId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndCompany_Last(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndCompany_Last(companyId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByDepartmentAndCompany_PrevAndNext(
		long contactId, long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByDepartmentAndCompany_PrevAndNext(contactId,
			companyId, departmentId, orderByComparator);
	}

	/**
	* Returns all the contactses where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentAndGroup(groupId, departmentId);
	}

	/**
	* Returns a range of all the contactses where groupId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndGroup(groupId, departmentId, start, end);
	}

	/**
	* Returns an ordered range of all the contactses where groupId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndGroup(groupId, departmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndGroup_First(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByDepartmentAndGroup_First(groupId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndGroup_First(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndGroup_First(groupId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndGroup_Last(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByDepartmentAndGroup_Last(groupId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndGroup_Last(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndGroup_Last(groupId, departmentId,
			orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByDepartmentAndGroup_PrevAndNext(
		long contactId, long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByDepartmentAndGroup_PrevAndNext(contactId, groupId,
			departmentId, orderByComparator);
	}

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByDepartmentAndGroup(
		long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(groupId, departmentId);
	}

	/**
	* Returns a range of all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(groupId, departmentId,
			start, end);
	}

	/**
	* Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63; and departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(groupId, departmentId,
			start, end, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] filterFindByDepartmentAndGroup_PrevAndNext(
		long contactId, long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup_PrevAndNext(contactId,
			groupId, departmentId, orderByComparator);
	}

	/**
	* Returns all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndDepartmentAndStatus(companyId,
			departmentId, contactStatus);
	}

	/**
	* Returns a range of all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndDepartmentAndStatus(companyId,
			departmentId, contactStatus, start, end);
	}

	/**
	* Returns an ordered range of all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndDepartmentAndStatus(companyId,
			departmentId, contactStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndDepartmentAndStatus_First(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByCompanyAndDepartmentAndStatus_First(companyId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndDepartmentAndStatus_First(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndDepartmentAndStatus_First(companyId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndDepartmentAndStatus_Last(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByCompanyAndDepartmentAndStatus_Last(companyId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndDepartmentAndStatus_Last(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndDepartmentAndStatus_Last(companyId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByCompanyAndDepartmentAndStatus_PrevAndNext(
		long contactId, long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByCompanyAndDepartmentAndStatus_PrevAndNext(contactId,
			companyId, departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus);
	}

	/**
	* Returns a range of all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus, start, end);
	}

	/**
	* Returns an ordered range of all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByGroupAndDepartmentAndStatus_First(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByGroupAndDepartmentAndStatus_First(groupId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndDepartmentAndStatus_First(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndDepartmentAndStatus_First(groupId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts findByGroupAndDepartmentAndStatus_Last(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByGroupAndDepartmentAndStatus_Last(groupId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndDepartmentAndStatus_Last(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndDepartmentAndStatus_Last(groupId,
			departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] findByGroupAndDepartmentAndStatus_PrevAndNext(
		long contactId, long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .findByGroupAndDepartmentAndStatus_PrevAndNext(contactId,
			groupId, departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndDepartmentAndStatus(groupId,
			departmentId, contactStatus);
	}

	/**
	* Returns a range of all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndDepartmentAndStatus(groupId,
			departmentId, contactStatus, start, end);
	}

	/**
	* Returns an ordered range of all the contactses that the user has permissions to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndDepartmentAndStatus(groupId,
			departmentId, contactStatus, start, end, orderByComparator);
	}

	/**
	* Returns the contactses before and after the current contacts in the ordered set of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param contactId the primary key of the current contacts
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.contacts.model.Contacts[] filterFindByGroupAndDepartmentAndStatus_PrevAndNext(
		long contactId, long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException {
		return getPersistence()
				   .filterFindByGroupAndDepartmentAndStatus_PrevAndNext(contactId,
			groupId, departmentId, contactStatus, orderByComparator);
	}

	/**
	* Returns all the contactses.
	*
	* @return the contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the contactses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the contactses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contactses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contactses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the contactses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the contactses where companyId = &#63; and contactStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyAndStatus(long companyId,
		int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyAndStatus(companyId, contactStatus);
	}

	/**
	* Removes all the contactses where groupId = &#63; and contactStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndStatus(long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndStatus(groupId, contactStatus);
	}

	/**
	* Removes all the contactses where companyId = &#63; and departmentId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentAndCompany(long companyId,
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentAndCompany(companyId, departmentId);
	}

	/**
	* Removes all the contactses where groupId = &#63; and departmentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentAndGroup(long groupId,
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentAndGroup(groupId, departmentId);
	}

	/**
	* Removes all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCompanyAndDepartmentAndStatus(companyId, departmentId,
			contactStatus);
	}

	/**
	* Removes all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus);
	}

	/**
	* Removes all the contactses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contactses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of contactses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of contactses where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyAndStatus(long companyId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyAndStatus(companyId, contactStatus);
	}

	/**
	* Returns the number of contactses where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndStatus(long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndStatus(groupId, contactStatus);
	}

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupAndStatus(long groupId,
		int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByGroupAndStatus(groupId, contactStatus);
	}

	/**
	* Returns the number of contactses where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentAndCompany(long companyId,
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentAndCompany(companyId, departmentId);
	}

	/**
	* Returns the number of contactses where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartmentAndGroup(groupId, departmentId);
	}

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByDepartmentAndGroup(long groupId,
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByDepartmentAndGroup(groupId, departmentId);
	}

	/**
	* Returns the number of contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompanyAndDepartmentAndStatus(companyId,
			departmentId, contactStatus);
	}

	/**
	* Returns the number of contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupAndDepartmentAndStatus(groupId, departmentId,
			contactStatus);
	}

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByGroupAndDepartmentAndStatus(groupId,
			departmentId, contactStatus);
	}

	/**
	* Returns the number of contactses.
	*
	* @return the number of contactses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactsPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.contacts.service.ClpSerializer.getServletContextName(),
					ContactsPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ContactsPersistence persistence) {
	}

	private static ContactsPersistence _persistence;
}