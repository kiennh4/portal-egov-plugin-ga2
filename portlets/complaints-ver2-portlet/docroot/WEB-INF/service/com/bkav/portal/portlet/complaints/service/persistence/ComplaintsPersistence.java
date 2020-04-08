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

package com.bkav.portal.portlet.complaints.service.persistence;

import com.bkav.portal.portlet.complaints.model.Complaints;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the complaints service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see ComplaintsPersistenceImpl
 * @see ComplaintsUtil
 * @generated
 */
public interface ComplaintsPersistence extends BasePersistence<Complaints> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ComplaintsUtil} to access the complaints persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the complaints in the entity cache if it is enabled.
	*
	* @param complaints the complaints
	*/
	public void cacheResult(
		com.bkav.portal.portlet.complaints.model.Complaints complaints);

	/**
	* Caches the complaintses in the entity cache if it is enabled.
	*
	* @param complaintses the complaintses
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> complaintses);

	/**
	* Creates a new complaints with the primary key. Does not add the complaints to the database.
	*
	* @param complaintId the primary key for the new complaints
	* @return the new complaints
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints create(
		long complaintId);

	/**
	* Removes the complaints with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param complaintId the primary key of the complaints
	* @return the complaints that was removed
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints remove(
		long complaintId)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.complaints.model.Complaints updateImpl(
		com.bkav.portal.portlet.complaints.model.Complaints complaints,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaints with the primary key or throws a {@link com.bkav.portal.portlet.complaints.NoSuchComplaintsException} if it could not be found.
	*
	* @param complaintId the primary key of the complaints
	* @return the complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints findByPrimaryKey(
		long complaintId)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaints with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param complaintId the primary key of the complaints
	* @return the complaints, or <code>null</code> if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints fetchByPrimaryKey(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaintses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaintses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @return the range of matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaintses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints, or <code>null</code> if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints, or <code>null</code> if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaintses before and after the current complaints in the ordered set where groupId = &#63;.
	*
	* @param complaintId the primary key of the current complaints
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints[] findByGroupId_PrevAndNext(
		long complaintId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaintses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching complaintses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaintses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @return the range of matching complaintses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaintses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaintses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaintses before and after the current complaints in the ordered set of complaintses that the user has permission to view where groupId = &#63;.
	*
	* @param complaintId the primary key of the current complaints
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints[] filterFindByGroupId_PrevAndNext(
		long complaintId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaintses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaintses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @return the range of matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaintses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints, or <code>null</code> if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints, or <code>null</code> if a matching complaints could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaintses before and after the current complaints in the ordered set where companyId = &#63;.
	*
	* @param complaintId the primary key of the current complaints
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaints
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints[] findByCompanyId_PrevAndNext(
		long complaintId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaintsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaintses.
	*
	* @return the complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaintses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @return the range of complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaintses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of complaintses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaintses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaintses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaintses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaintses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaintses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching complaintses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaintses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching complaintses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaintses.
	*
	* @return the number of complaintses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}