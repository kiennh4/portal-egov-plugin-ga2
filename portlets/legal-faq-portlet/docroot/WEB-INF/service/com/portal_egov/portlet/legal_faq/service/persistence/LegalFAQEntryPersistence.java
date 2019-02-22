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

package com.portal_egov.portlet.legal_faq.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;

/**
 * The persistence interface for the legal f a q entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LegalFAQEntryPersistenceImpl
 * @see LegalFAQEntryUtil
 * @generated
 */
public interface LegalFAQEntryPersistence extends BasePersistence<LegalFAQEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalFAQEntryUtil} to access the legal f a q entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legal f a q entry in the entity cache if it is enabled.
	*
	* @param legalFAQEntry the legal f a q entry
	*/
	public void cacheResult(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry);

	/**
	* Caches the legal f a q entries in the entity cache if it is enabled.
	*
	* @param legalFAQEntries the legal f a q entries
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> legalFAQEntries);

	/**
	* Creates a new legal f a q entry with the primary key. Does not add the legal f a q entry to the database.
	*
	* @param entryId the primary key for the new legal f a q entry
	* @return the new legal f a q entry
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry create(
		long entryId);

	/**
	* Removes the legal f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry that was removed
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry remove(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateImpl(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entry with the primary key or throws a {@link com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException} if it could not be found.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the legal f a q entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry, or <code>null</code> if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal f a q entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategory_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategory_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategory_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategory_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCategory_PrevAndNext(
		long entryId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategory(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategory(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByCategory_PrevAndNext(
		long entryId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategoryAndStatus_First(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategoryAndStatus_First(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategoryAndStatus_Last(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategoryAndStatus_Last(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCategoryAndStatus_PrevAndNext(
		long entryId, long groupId, long categoryId, int publishStatus,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByCategoryAndStatus_PrevAndNext(
		long entryId, long groupId, long categoryId, int publishStatus,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int publishStatus, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int publishStatus, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompanyAndStatus_First(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompanyAndStatus_First(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompanyAndStatus_Last(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompanyAndStatus_Last(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCompanyAndStatus_PrevAndNext(
		long entryId, long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroupAndStatus_First(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroupAndStatus_First(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroupAndStatus_Last(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroupAndStatus_Last(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByGroupAndStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroupAndStatus(
		long groupId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByGroupAndStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByStatus_PrevAndNext(
		long entryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long groupId, int publishStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long groupId, int publishStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByPublishStatus_First(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByPublishStatus_First(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByPublishStatus_Last(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByPublishStatus_Last(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByPublishStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByPublishStatus(
		long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByPublishStatus(
		long groupId, int publishStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries that the user has permissions to view where groupId = &#63; and publishStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByPublishStatus(
		long groupId, int publishStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q entries before and after the current legal f a q entry in the ordered set of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	*
	* @param entryId the primary key of the current legal f a q entry
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByPublishStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException;

	/**
	* Returns all the legal f a q entries.
	*
	* @return the legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyAndStatus(long companyId, int publishStatus,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndStatus(long groupId, int publishStatus,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries where groupId = &#63; and publishStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishStatus(long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyAndStatus(long companyId, int publishStatus,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndStatus(long groupId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupAndStatus(long groupId, int publishStatus,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishStatus(long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByPublishStatus(long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q entries.
	*
	* @return the number of legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}