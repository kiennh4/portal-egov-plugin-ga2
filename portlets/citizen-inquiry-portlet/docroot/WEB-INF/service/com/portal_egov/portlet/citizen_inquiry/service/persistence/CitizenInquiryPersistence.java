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

package com.portal_egov.portlet.citizen_inquiry.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;

/**
 * The persistence interface for the citizen inquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CitizenInquiryPersistenceImpl
 * @see CitizenInquiryUtil
 * @generated
 */
public interface CitizenInquiryPersistence extends BasePersistence<CitizenInquiry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CitizenInquiryUtil} to access the citizen inquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the citizen inquiry in the entity cache if it is enabled.
	*
	* @param citizenInquiry the citizen inquiry
	*/
	public void cacheResult(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry);

	/**
	* Caches the citizen inquiries in the entity cache if it is enabled.
	*
	* @param citizenInquiries the citizen inquiries
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> citizenInquiries);

	/**
	* Creates a new citizen inquiry with the primary key. Does not add the citizen inquiry to the database.
	*
	* @param inquiryId the primary key for the new citizen inquiry
	* @return the new citizen inquiry
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry create(
		long inquiryId);

	/**
	* Removes the citizen inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inquiryId the primary key of the citizen inquiry
	* @return the citizen inquiry that was removed
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry remove(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry updateImpl(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry citizenInquiry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiry with the primary key or throws a {@link com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException} if it could not be found.
	*
	* @param inquiryId the primary key of the citizen inquiry
	* @return the citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry findByPrimaryKey(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns the citizen inquiry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inquiryId the primary key of the citizen inquiry
	* @return the citizen inquiry, or <code>null</code> if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchByPrimaryKey(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the citizen inquiries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @return the range of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first citizen inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns the first citizen inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last citizen inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns the last citizen inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiries before and after the current citizen inquiry in the ordered set where companyId = &#63;.
	*
	* @param inquiryId the primary key of the current citizen inquiry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry[] findByCompany_PrevAndNext(
		long inquiryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns all the citizen inquiries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @return the range of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first citizen inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns the first citizen inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last citizen inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns the last citizen inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiries before and after the current citizen inquiry in the ordered set where groupId = &#63;.
	*
	* @param inquiryId the primary key of the current citizen inquiry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry[] findByGroup_PrevAndNext(
		long inquiryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns all the citizen inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizen inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiries that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @return the range of matching citizen inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiries that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizen inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiries before and after the current citizen inquiry in the ordered set of citizen inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param inquiryId the primary key of the current citizen inquiry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry[] filterFindByGroup_PrevAndNext(
		long inquiryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns all the citizen inquiries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @return the range of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first citizen inquiry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns the first citizen inquiry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last citizen inquiry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns the last citizen inquiry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry, or <code>null</code> if a matching citizen inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiries before and after the current citizen inquiry in the ordered set where categoryId = &#63;.
	*
	* @param inquiryId the primary key of the current citizen inquiry
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen inquiry
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException if a citizen inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry[] findByCategory_PrevAndNext(
		long inquiryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryException;

	/**
	* Returns all the citizen inquiries.
	*
	* @return the citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @return the range of citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of citizen inquiries
	* @param end the upper bound of the range of citizen inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the citizen inquiries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the citizen inquiries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the citizen inquiries where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the citizen inquiries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizen inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiries.
	*
	* @return the number of citizen inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}