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

package com.portal_egov.portlet.compaints.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.compaints.model.Complaint;

import java.util.List;

/**
 * The persistence utility for the complaint service. This utility wraps {@link ComplaintPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see ComplaintPersistence
 * @see ComplaintPersistenceImpl
 * @generated
 */
public class ComplaintUtil {
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
	public static void clearCache(Complaint complaint) {
		getPersistence().clearCache(complaint);
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
	public static List<Complaint> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Complaint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Complaint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Complaint update(Complaint complaint, boolean merge)
		throws SystemException {
		return getPersistence().update(complaint, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Complaint update(Complaint complaint, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(complaint, merge, serviceContext);
	}

	/**
	* Caches the complaint in the entity cache if it is enabled.
	*
	* @param complaint the complaint
	*/
	public static void cacheResult(
		com.portal_egov.portlet.compaints.model.Complaint complaint) {
		getPersistence().cacheResult(complaint);
	}

	/**
	* Caches the complaints in the entity cache if it is enabled.
	*
	* @param complaints the complaints
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.compaints.model.Complaint> complaints) {
		getPersistence().cacheResult(complaints);
	}

	/**
	* Creates a new complaint with the primary key. Does not add the complaint to the database.
	*
	* @param complaintId the primary key for the new complaint
	* @return the new complaint
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint create(
		long complaintId) {
		return getPersistence().create(complaintId);
	}

	/**
	* Removes the complaint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param complaintId the primary key of the complaint
	* @return the complaint that was removed
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint remove(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence().remove(complaintId);
	}

	public static com.portal_egov.portlet.compaints.model.Complaint updateImpl(
		com.portal_egov.portlet.compaints.model.Complaint complaint,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(complaint, merge);
	}

	/**
	* Returns the complaint with the primary key or throws a {@link com.portal_egov.portlet.compaints.NoSuchComplaintException} if it could not be found.
	*
	* @param complaintId the primary key of the complaint
	* @return the complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint findByPrimaryKey(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence().findByPrimaryKey(complaintId);
	}

	/**
	* Returns the complaint with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param complaintId the primary key of the complaint
	* @return the complaint, or <code>null</code> if a complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint fetchByPrimaryKey(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(complaintId);
	}

	/**
	* Returns all the complaints where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the complaints where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @return the range of matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the complaints where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first complaint in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first complaint in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint, or <code>null</code> if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last complaint in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last complaint in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint, or <code>null</code> if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the complaints before and after the current complaint in the ordered set where companyId = &#63;.
	*
	* @param complaintId the primary key of the current complaint
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint[] findByCompany_PrevAndNext(
		long complaintId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence()
				   .findByCompany_PrevAndNext(complaintId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the complaints where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the complaints where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @return the range of matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the complaints where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first complaint in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first complaint in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint, or <code>null</code> if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last complaint in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last complaint in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint, or <code>null</code> if a matching complaint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the complaints before and after the current complaint in the ordered set where groupId = &#63;.
	*
	* @param complaintId the primary key of the current complaint
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint[] findByGroup_PrevAndNext(
		long complaintId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence()
				   .findByGroup_PrevAndNext(complaintId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the complaints that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching complaints that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the complaints that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @return the range of matching complaints that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the complaints that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaints that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the complaints before and after the current complaint in the ordered set of complaints that the user has permission to view where groupId = &#63;.
	*
	* @param complaintId the primary key of the current complaint
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaint
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaintException if a complaint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint[] filterFindByGroup_PrevAndNext(
		long complaintId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaintException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(complaintId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the complaints.
	*
	* @return the complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the complaints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @return the range of complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the complaints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaints
	* @param end the upper bound of the range of complaints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of complaints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the complaints where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the complaints where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the complaints from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of complaints where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of complaints where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching complaints
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of complaints that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching complaints that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of complaints.
	*
	* @return the number of complaints
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ComplaintPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ComplaintPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.compaints.service.ClpSerializer.getServletContextName(),
					ComplaintPersistence.class.getName());

			ReferenceRegistry.registerReference(ComplaintUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ComplaintPersistence persistence) {
	}

	private static ComplaintPersistence _persistence;
}