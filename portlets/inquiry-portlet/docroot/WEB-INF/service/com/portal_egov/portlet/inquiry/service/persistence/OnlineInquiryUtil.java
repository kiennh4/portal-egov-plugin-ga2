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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.inquiry.model.OnlineInquiry;

import java.util.List;

/**
 * The persistence utility for the online inquiry service. This utility wraps {@link OnlineInquiryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see OnlineInquiryPersistence
 * @see OnlineInquiryPersistenceImpl
 * @generated
 */
public class OnlineInquiryUtil {
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
	public static void clearCache(OnlineInquiry onlineInquiry) {
		getPersistence().clearCache(onlineInquiry);
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
	public static List<OnlineInquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OnlineInquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OnlineInquiry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static OnlineInquiry update(OnlineInquiry onlineInquiry,
		boolean merge) throws SystemException {
		return getPersistence().update(onlineInquiry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static OnlineInquiry update(OnlineInquiry onlineInquiry,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(onlineInquiry, merge, serviceContext);
	}

	/**
	* Caches the online inquiry in the entity cache if it is enabled.
	*
	* @param onlineInquiry the online inquiry
	*/
	public static void cacheResult(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry) {
		getPersistence().cacheResult(onlineInquiry);
	}

	/**
	* Caches the online inquiries in the entity cache if it is enabled.
	*
	* @param onlineInquiries the online inquiries
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> onlineInquiries) {
		getPersistence().cacheResult(onlineInquiries);
	}

	/**
	* Creates a new online inquiry with the primary key. Does not add the online inquiry to the database.
	*
	* @param inquiryId the primary key for the new online inquiry
	* @return the new online inquiry
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry create(
		long inquiryId) {
		return getPersistence().create(inquiryId);
	}

	/**
	* Removes the online inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry that was removed
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry remove(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence().remove(inquiryId);
	}

	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry updateImpl(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(onlineInquiry, merge);
	}

	/**
	* Returns the online inquiry with the primary key or throws a {@link com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException} if it could not be found.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry findByPrimaryKey(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence().findByPrimaryKey(inquiryId);
	}

	/**
	* Returns the online inquiry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry, or <code>null</code> if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByPrimaryKey(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(inquiryId);
	}

	/**
	* Returns all the online inquiries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last online inquiry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry[] findByCompany_PrevAndNext(
		long inquiryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(inquiryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the online inquiries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry
	* @throws com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last online inquiry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching online inquiry, or <code>null</code> if a matching online inquiry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry[] findByGroup_PrevAndNext(
		long inquiryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(inquiryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the online inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching online inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry[] filterFindByGroup_PrevAndNext(
		long inquiryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.inquiry.NoSuchOnlineInquiryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(inquiryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the online inquiries.
	*
	* @return the online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the online inquiries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the online inquiries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the online inquiries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of online inquiries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of online inquiries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of online inquiries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching online inquiries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of online inquiries.
	*
	* @return the number of online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OnlineInquiryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OnlineInquiryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.inquiry.service.ClpSerializer.getServletContextName(),
					OnlineInquiryPersistence.class.getName());

			ReferenceRegistry.registerReference(OnlineInquiryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OnlineInquiryPersistence persistence) {
	}

	private static OnlineInquiryPersistence _persistence;
}