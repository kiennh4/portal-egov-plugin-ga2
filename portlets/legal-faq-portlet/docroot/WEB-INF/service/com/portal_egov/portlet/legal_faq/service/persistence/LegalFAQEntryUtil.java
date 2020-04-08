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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;

import java.util.List;

/**
 * The persistence utility for the legal f a q entry service. This utility wraps {@link LegalFAQEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LegalFAQEntryPersistence
 * @see LegalFAQEntryPersistenceImpl
 * @generated
 */
public class LegalFAQEntryUtil {
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
	public static void clearCache(LegalFAQEntry legalFAQEntry) {
		getPersistence().clearCache(legalFAQEntry);
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
	public static List<LegalFAQEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalFAQEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalFAQEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LegalFAQEntry update(LegalFAQEntry legalFAQEntry,
		boolean merge) throws SystemException {
		return getPersistence().update(legalFAQEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LegalFAQEntry update(LegalFAQEntry legalFAQEntry,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(legalFAQEntry, merge, serviceContext);
	}

	/**
	* Caches the legal f a q entry in the entity cache if it is enabled.
	*
	* @param legalFAQEntry the legal f a q entry
	*/
	public static void cacheResult(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry) {
		getPersistence().cacheResult(legalFAQEntry);
	}

	/**
	* Caches the legal f a q entries in the entity cache if it is enabled.
	*
	* @param legalFAQEntries the legal f a q entries
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> legalFAQEntries) {
		getPersistence().cacheResult(legalFAQEntries);
	}

	/**
	* Creates a new legal f a q entry with the primary key. Does not add the legal f a q entry to the database.
	*
	* @param entryId the primary key for the new legal f a q entry
	* @return the new legal f a q entry
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the legal f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry that was removed
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry remove(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence().remove(entryId);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateImpl(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legalFAQEntry, merge);
	}

	/**
	* Returns the legal f a q entry with the primary key or throws a {@link com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException} if it could not be found.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the legal f a q entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry, or <code>null</code> if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the legal f a q entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(entryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the legal f a q entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
	}

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(entryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the legal f a q entries where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(groupId, categoryId);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(groupId, categoryId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(groupId, categoryId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategory_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCategory_First(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategory_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(groupId, categoryId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategory_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCategory_Last(groupId, categoryId, orderByComparator);
	}

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategory_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(groupId, categoryId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCategory_PrevAndNext(
		long entryId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCategory_PrevAndNext(entryId, groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategory(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCategory(groupId, categoryId);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategory(groupId, categoryId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategory(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategory(groupId, categoryId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByCategory_PrevAndNext(
		long entryId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .filterFindByCategory_PrevAndNext(entryId, groupId,
			categoryId, orderByComparator);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatus(groupId, categoryId, publishStatus,
			status);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatus(groupId, categoryId, publishStatus,
			status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatus(groupId, categoryId, publishStatus,
			status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategoryAndStatus_First(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCategoryAndStatus_First(groupId, categoryId,
			publishStatus, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategoryAndStatus_First(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndStatus_First(groupId, categoryId,
			publishStatus, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCategoryAndStatus_Last(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCategoryAndStatus_Last(groupId, categoryId,
			publishStatus, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCategoryAndStatus_Last(
		long groupId, long categoryId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndStatus_Last(groupId, categoryId,
			publishStatus, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCategoryAndStatus_PrevAndNext(
		long entryId, long groupId, long categoryId, int publishStatus,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCategoryAndStatus_PrevAndNext(entryId, groupId,
			categoryId, publishStatus, status, orderByComparator);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndStatus(groupId, categoryId,
			publishStatus, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndStatus(groupId, categoryId,
			publishStatus, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByCategoryAndStatus(
		long groupId, long categoryId, int publishStatus, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndStatus(groupId, categoryId,
			publishStatus, status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByCategoryAndStatus_PrevAndNext(
		long entryId, long groupId, long categoryId, int publishStatus,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .filterFindByCategoryAndStatus_PrevAndNext(entryId, groupId,
			categoryId, publishStatus, status, orderByComparator);
	}

	/**
	* Returns all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, publishStatus, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int publishStatus, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, publishStatus, status,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int publishStatus, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, publishStatus, status,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompanyAndStatus_First(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCompanyAndStatus_First(companyId, publishStatus,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompanyAndStatus_First(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_First(companyId, publishStatus,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByCompanyAndStatus_Last(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCompanyAndStatus_Last(companyId, publishStatus,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByCompanyAndStatus_Last(
		long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_Last(companyId, publishStatus,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByCompanyAndStatus_PrevAndNext(
		long entryId, long companyId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByCompanyAndStatus_PrevAndNext(entryId, companyId,
			publishStatus, status, orderByComparator);
	}

	/**
	* Returns all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, publishStatus, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, publishStatus, status, start,
			end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, publishStatus, status, start,
			end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroupAndStatus_First(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByGroupAndStatus_First(groupId, publishStatus, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroupAndStatus_First(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_First(groupId, publishStatus, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByGroupAndStatus_Last(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByGroupAndStatus_Last(groupId, publishStatus, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByGroupAndStatus_Last(
		long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_Last(groupId, publishStatus, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByGroupAndStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByGroupAndStatus_PrevAndNext(entryId, groupId,
			publishStatus, status, orderByComparator);
	}

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroupAndStatus(
		long groupId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndStatus(groupId, publishStatus, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndStatus(groupId, publishStatus, status,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByGroupAndStatus(
		long groupId, int publishStatus, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupAndStatus(groupId, publishStatus, status,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByGroupAndStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .filterFindByGroupAndStatus_PrevAndNext(entryId, groupId,
			publishStatus, status, orderByComparator);
	}

	/**
	* Returns all the legal f a q entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(companyId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(companyId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(companyId, status, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByStatus_First(companyId, status, orderByComparator);
	}

	/**
	* Returns the first legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatus_First(companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByStatus_Last(companyId, status, orderByComparator);
	}

	/**
	* Returns the last legal f a q entry in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatus_Last(companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByStatus_PrevAndNext(
		long entryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByStatus_PrevAndNext(entryId, companyId, status,
			orderByComparator);
	}

	/**
	* Returns all the legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishStatus(groupId, publishStatus);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long groupId, int publishStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishStatus(groupId, publishStatus, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long groupId, int publishStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishStatus(groupId, publishStatus, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByPublishStatus_First(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByPublishStatus_First(groupId, publishStatus,
			orderByComparator);
	}

	/**
	* Returns the first legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByPublishStatus_First(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishStatus_First(groupId, publishStatus,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry findByPublishStatus_Last(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByPublishStatus_Last(groupId, publishStatus,
			orderByComparator);
	}

	/**
	* Returns the last legal f a q entry in the ordered set where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q entry, or <code>null</code> if a matching legal f a q entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchByPublishStatus_Last(
		long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishStatus_Last(groupId, publishStatus,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] findByPublishStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .findByPublishStatus_PrevAndNext(entryId, groupId,
			publishStatus, orderByComparator);
	}

	/**
	* Returns all the legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByPublishStatus(
		long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByPublishStatus(groupId, publishStatus);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByPublishStatus(
		long groupId, int publishStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPublishStatus(groupId, publishStatus, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> filterFindByPublishStatus(
		long groupId, int publishStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPublishStatus(groupId, publishStatus, start,
			end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry[] filterFindByPublishStatus_PrevAndNext(
		long entryId, long groupId, int publishStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQEntryException {
		return getPersistence()
				   .filterFindByPublishStatus_PrevAndNext(entryId, groupId,
			publishStatus, orderByComparator);
	}

	/**
	* Returns all the legal f a q entries.
	*
	* @return the legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legal f a q entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the legal f a q entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the legal f a q entries where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(groupId, categoryId);
	}

	/**
	* Removes all the legal f a q entries where groupId = &#63; and categoryId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param publishStatus the publish status
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCategoryAndStatus(groupId, categoryId, publishStatus,
			status);
	}

	/**
	* Removes all the legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyAndStatus(long companyId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCompanyAndStatus(companyId, publishStatus, status);
	}

	/**
	* Removes all the legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndStatus(long groupId, int publishStatus,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndStatus(groupId, publishStatus, status);
	}

	/**
	* Removes all the legal f a q entries where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(companyId, status);
	}

	/**
	* Removes all the legal f a q entries where groupId = &#63; and publishStatus = &#63; from the database.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishStatus(long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishStatus(groupId, publishStatus);
	}

	/**
	* Removes all the legal f a q entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legal f a q entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of legal f a q entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of legal f a q entries where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(groupId, categoryId);
	}

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCategory(groupId, categoryId);
	}

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
	public static int countByCategoryAndStatus(long groupId, long categoryId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCategoryAndStatus(groupId, categoryId,
			publishStatus, status);
	}

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
	public static int filterCountByCategoryAndStatus(long groupId,
		long categoryId, int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryAndStatus(groupId, categoryId,
			publishStatus, status);
	}

	/**
	* Returns the number of legal f a q entries where companyId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyAndStatus(long companyId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompanyAndStatus(companyId, publishStatus, status);
	}

	/**
	* Returns the number of legal f a q entries where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndStatus(long groupId, int publishStatus,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupAndStatus(groupId, publishStatus, status);
	}

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @param status the status
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupAndStatus(long groupId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByGroupAndStatus(groupId, publishStatus, status);
	}

	/**
	* Returns the number of legal f a q entries where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(companyId, status);
	}

	/**
	* Returns the number of legal f a q entries where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the number of matching legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishStatus(long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishStatus(groupId, publishStatus);
	}

	/**
	* Returns the number of legal f a q entries that the user has permission to view where groupId = &#63; and publishStatus = &#63;.
	*
	* @param groupId the group ID
	* @param publishStatus the publish status
	* @return the number of matching legal f a q entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByPublishStatus(long groupId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByPublishStatus(groupId, publishStatus);
	}

	/**
	* Returns the number of legal f a q entries.
	*
	* @return the number of legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegalFAQEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegalFAQEntryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.legal_faq.service.ClpSerializer.getServletContextName(),
					LegalFAQEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(LegalFAQEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LegalFAQEntryPersistence persistence) {
	}

	private static LegalFAQEntryPersistence _persistence;
}