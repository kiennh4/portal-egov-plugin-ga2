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

package com.portal_egov.portlet.inquiry.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.inquiry.model.OnlineInquiry;

/**
 * The persistence interface for the online inquiry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see OnlineInquiryPersistenceImpl
 * @see OnlineInquiryUtil
 * @generated
 */
public interface OnlineInquiryPersistence extends BasePersistence<OnlineInquiry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OnlineInquiryUtil} to access the online inquiry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the online inquiry in the entity cache if it is enabled.
	*
	* @param onlineInquiry the online inquiry
	*/
	public void cacheResult(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry);

	/**
	* Caches the online inquiries in the entity cache if it is enabled.
	*
	* @param onlineInquiries the online inquiries
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> onlineInquiries);

	/**
	* Creates a new online inquiry with the primary key. Does not add the online inquiry to the database.
	*
	* @param inquiryId the primary key for the new online inquiry
	* @return the new online inquiry
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry create(
		long inquiryId);

	/**
	* Removes the online inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry that was removed
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry remove(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	public com.portal_egov.portlet.inquiry.model.OnlineInquiry updateImpl(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the online inquiry with the primary key or throws a {@link com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException} if it could not be found.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry findByPrimaryKey(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns the online inquiry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry, or <code>null</code> if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByPrimaryKey(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the online inquiries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the online inquiries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @return the range of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the online inquiries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns the first online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns the last online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the online inquiries before and after the current online inquiry in the ordered set where companyId = &#63;.
	*
	* @param inquiryId the primary key of the current online inquiry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry[] findByCompany_PrevAndNext(
		long inquiryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns all the online inquiries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the online inquiries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @return the range of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the online inquiries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns the first online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns the last online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the online inquiries before and after the current online inquiry in the ordered set where groupId = &#63;.
	*
	* @param inquiryId the primary key of the current online inquiry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry[] findByGroup_PrevAndNext(
		long inquiryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns all the online inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching online inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the online inquiries that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @return the range of matching online inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the online inquiries that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching online inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the online inquiries before and after the current online inquiry in the ordered set of online inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param inquiryId the primary key of the current online inquiry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry[] filterFindByGroup_PrevAndNext(
		long inquiryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException;

	/**
	* Returns all the online inquiries.
	*
	* @return the online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the online inquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @return the range of online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the online inquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the online inquiries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the online inquiries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the online inquiries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of online inquiries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of online inquiries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of online inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching online inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of online inquiries.
	*
	* @return the number of online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}