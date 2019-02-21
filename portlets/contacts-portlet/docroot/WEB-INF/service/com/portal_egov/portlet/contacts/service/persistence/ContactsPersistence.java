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

import com.portal_egov.portlet.contacts.model.Contacts;

/**
 * The persistence interface for the contacts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ContactsPersistenceImpl
 * @see ContactsUtil
 * @generated
 */
public interface ContactsPersistence extends BasePersistence<Contacts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactsUtil} to access the contacts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contacts in the entity cache if it is enabled.
	*
	* @param contacts the contacts
	*/
	public void cacheResult(
		com.portal_egov.portlet.contacts.model.Contacts contacts);

	/**
	* Caches the contactses in the entity cache if it is enabled.
	*
	* @param contactses the contactses
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.contacts.model.Contacts> contactses);

	/**
	* Creates a new contacts with the primary key. Does not add the contacts to the database.
	*
	* @param contactId the primary key for the new contacts
	* @return the new contacts
	*/
	public com.portal_egov.portlet.contacts.model.Contacts create(
		long contactId);

	/**
	* Removes the contacts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts that was removed
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts remove(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	public com.portal_egov.portlet.contacts.model.Contacts updateImpl(
		com.portal_egov.portlet.contacts.model.Contacts contacts, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts with the primary key or throws a {@link com.portal_egov.portlet.contacts.NoSuchContactsException} if it could not be found.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts findByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the contacts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts, or <code>null</code> if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contactses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the first contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the last contacts in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByCompany_PrevAndNext(
		long contactId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the first contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts
	* @throws com.portal_egov.portlet.contacts.NoSuchContactsException if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the last contacts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByGroup_PrevAndNext(
		long contactId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] filterFindByGroup_PrevAndNext(
		long contactId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndStatus(
		long companyId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndStatus(
		long companyId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndStatus(
		long companyId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndStatus_First(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndStatus_First(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndStatus_Last(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndStatus_Last(
		long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByCompanyAndStatus_PrevAndNext(
		long contactId, long companyId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndStatus(
		long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndStatus(
		long groupId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndStatus(
		long groupId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByGroupAndStatus_First(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndStatus_First(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByGroupAndStatus_Last(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndStatus_Last(
		long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByGroupAndStatus_PrevAndNext(
		long contactId, long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndStatus(
		long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndStatus(
		long groupId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndStatus(
		long groupId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] filterFindByGroupAndStatus_PrevAndNext(
		long contactId, long groupId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndCompany_First(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the first contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndCompany_First(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndCompany_Last(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the last contacts in the ordered set where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndCompany_Last(
		long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByDepartmentAndCompany_PrevAndNext(
		long contactId, long companyId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndGroup_First(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the first contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndGroup_First(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByDepartmentAndGroup_Last(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns the last contacts in the ordered set where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contacts, or <code>null</code> if a matching contacts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts fetchByDepartmentAndGroup_Last(
		long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByDepartmentAndGroup_PrevAndNext(
		long contactId, long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByDepartmentAndGroup(
		long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] filterFindByDepartmentAndGroup_PrevAndNext(
		long contactId, long groupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndDepartmentAndStatus_First(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

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
	public com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndDepartmentAndStatus_First(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByCompanyAndDepartmentAndStatus_Last(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

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
	public com.portal_egov.portlet.contacts.model.Contacts fetchByCompanyAndDepartmentAndStatus_Last(
		long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByCompanyAndDepartmentAndStatus_PrevAndNext(
		long contactId, long companyId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByGroupAndDepartmentAndStatus_First(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

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
	public com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndDepartmentAndStatus_First(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts findByGroupAndDepartmentAndStatus_Last(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

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
	public com.portal_egov.portlet.contacts.model.Contacts fetchByGroupAndDepartmentAndStatus_Last(
		long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] findByGroupAndDepartmentAndStatus_PrevAndNext(
		long contactId, long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> filterFindByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.contacts.model.Contacts[] filterFindByGroupAndDepartmentAndStatus_PrevAndNext(
		long contactId, long groupId, long departmentId, int contactStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;

	/**
	* Returns all the contactses.
	*
	* @return the contactses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where companyId = &#63; and contactStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyAndStatus(long companyId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where groupId = &#63; and contactStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndStatus(long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where companyId = &#63; and departmentId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentAndCompany(long companyId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where groupId = &#63; and departmentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63; from the database.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contactses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where companyId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyAndStatus(long companyId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndStatus(long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param contactStatus the contact status
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupAndStatus(long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where companyId = &#63; and departmentId = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentAndCompany(long companyId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where companyId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param companyId the company ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the number of matching contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses that the user has permission to view where groupId = &#63; and departmentId = &#63; and contactStatus = &#63;.
	*
	* @param groupId the group ID
	* @param departmentId the department ID
	* @param contactStatus the contact status
	* @return the number of matching contactses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses.
	*
	* @return the number of contactses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}