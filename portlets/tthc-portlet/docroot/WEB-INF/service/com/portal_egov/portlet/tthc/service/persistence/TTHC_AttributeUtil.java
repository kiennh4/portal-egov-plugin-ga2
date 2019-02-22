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

package com.portal_egov.portlet.tthc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.tthc.model.TTHC_Attribute;

import java.util.List;

/**
 * The persistence utility for the t t h c_ attribute service. This utility wraps {@link TTHC_AttributePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TTHC_AttributePersistence
 * @see TTHC_AttributePersistenceImpl
 * @generated
 */
public class TTHC_AttributeUtil {
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
	public static void clearCache(TTHC_Attribute tthc_Attribute) {
		getPersistence().clearCache(tthc_Attribute);
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
	public static List<TTHC_Attribute> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTHC_Attribute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTHC_Attribute> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TTHC_Attribute update(TTHC_Attribute tthc_Attribute,
		boolean merge) throws SystemException {
		return getPersistence().update(tthc_Attribute, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TTHC_Attribute update(TTHC_Attribute tthc_Attribute,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tthc_Attribute, merge, serviceContext);
	}

	/**
	* Caches the t t h c_ attribute in the entity cache if it is enabled.
	*
	* @param tthc_Attribute the t t h c_ attribute
	*/
	public static void cacheResult(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute) {
		getPersistence().cacheResult(tthc_Attribute);
	}

	/**
	* Caches the t t h c_ attributes in the entity cache if it is enabled.
	*
	* @param tthc_Attributes the t t h c_ attributes
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> tthc_Attributes) {
		getPersistence().cacheResult(tthc_Attributes);
	}

	/**
	* Creates a new t t h c_ attribute with the primary key. Does not add the t t h c_ attribute to the database.
	*
	* @param attributeId the primary key for the new t t h c_ attribute
	* @return the new t t h c_ attribute
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute create(
		long attributeId) {
		return getPersistence().create(attributeId);
	}

	/**
	* Removes the t t h c_ attribute with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attributeId the primary key of the t t h c_ attribute
	* @return the t t h c_ attribute that was removed
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute remove(
		long attributeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence().remove(attributeId);
	}

	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute updateImpl(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tthc_Attribute, merge);
	}

	/**
	* Returns the t t h c_ attribute with the primary key or throws a {@link com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException} if it could not be found.
	*
	* @param attributeId the primary key of the t t h c_ attribute
	* @return the t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByPrimaryKey(
		long attributeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence().findByPrimaryKey(attributeId);
	}

	/**
	* Returns the t t h c_ attribute with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attributeId the primary key of the t t h c_ attribute
	* @return the t t h c_ attribute, or <code>null</code> if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByPrimaryKey(
		long attributeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(attributeId);
	}

	/**
	* Returns all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @return the matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndCompany(
		long companyId, long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTTHCEntryAndCompany(companyId, tthcEntryId);
	}

	/**
	* Returns a range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndCompany(
		long companyId, long tthcEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndCompany(companyId, tthcEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndCompany(
		long companyId, long tthcEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndCompany(companyId, tthcEntryId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndCompany_First(
		long companyId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndCompany_First(companyId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndCompany_First(
		long companyId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndCompany_First(companyId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndCompany_Last(
		long companyId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndCompany_Last(companyId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndCompany_Last(
		long companyId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndCompany_Last(companyId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63;.
	*
	* @param attributeId the primary key of the current t t h c_ attribute
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute[] findByTTHCEntryAndCompany_PrevAndNext(
		long attributeId, long companyId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndCompany_PrevAndNext(attributeId,
			companyId, tthcEntryId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @return the matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndGroup(
		long groupId, long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTTHCEntryAndGroup(groupId, tthcEntryId);
	}

	/**
	* Returns a range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndGroup(
		long groupId, long tthcEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndGroup(groupId, tthcEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndGroup(
		long groupId, long tthcEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndGroup(groupId, tthcEntryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndGroup_First(
		long groupId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndGroup_First(groupId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndGroup_First(
		long groupId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndGroup_First(groupId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndGroup_Last(
		long groupId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndGroup_Last(groupId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndGroup_Last(
		long groupId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndGroup_Last(groupId, tthcEntryId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param attributeId the primary key of the current t t h c_ attribute
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute[] findByTTHCEntryAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndGroup_PrevAndNext(attributeId, groupId,
			tthcEntryId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @return the matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> filterFindByTTHCEntryAndGroup(
		long groupId, long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTTHCEntryAndGroup(groupId, tthcEntryId);
	}

	/**
	* Returns a range of all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> filterFindByTTHCEntryAndGroup(
		long groupId, long tthcEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTTHCEntryAndGroup(groupId, tthcEntryId, start,
			end);
	}

	/**
	* Returns an ordered range of all the t t h c_ attributes that the user has permissions to view where groupId = &#63; and tthcEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> filterFindByTTHCEntryAndGroup(
		long groupId, long tthcEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTTHCEntryAndGroup(groupId, tthcEntryId, start,
			end, orderByComparator);
	}

	/**
	* Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param attributeId the primary key of the current t t h c_ attribute
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute[] filterFindByTTHCEntryAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .filterFindByTTHCEntryAndGroup_PrevAndNext(attributeId,
			groupId, tthcEntryId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @return the matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId);
	}

	/**
	* Returns a range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndAttributeTypeAndCompany_First(
		long companyId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndCompany_First(companyId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndCompany_First(
		long companyId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndAttributeTypeAndCompany_First(companyId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndAttributeTypeAndCompany_Last(
		long companyId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndCompany_Last(companyId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndCompany_Last(
		long companyId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndAttributeTypeAndCompany_Last(companyId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param attributeId the primary key of the current t t h c_ attribute
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute[] findByTTHCEntryAndAttributeTypeAndCompany_PrevAndNext(
		long attributeId, long companyId, long tthcEntryId,
		int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndCompany_PrevAndNext(attributeId,
			companyId, tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @return the matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId);
	}

	/**
	* Returns a range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndAttributeTypeAndGroup_First(
		long groupId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndGroup_First(groupId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the first t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndGroup_First(
		long groupId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndAttributeTypeAndGroup_First(groupId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute findByTTHCEntryAndAttributeTypeAndGroup_Last(
		long groupId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndGroup_Last(groupId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ attribute, or <code>null</code> if a matching t t h c_ attribute could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchByTTHCEntryAndAttributeTypeAndGroup_Last(
		long groupId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTTHCEntryAndAttributeTypeAndGroup_Last(groupId,
			tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param attributeId the primary key of the current t t h c_ attribute
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute[] findByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .findByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(attributeId,
			groupId, tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @return the matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> filterFindByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId);
	}

	/**
	* Returns a range of all the t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> filterFindByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ attributes that the user has permissions to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> filterFindByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the t t h c_ attributes before and after the current t t h c_ attribute in the ordered set of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param attributeId the primary key of the current t t h c_ attribute
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ attribute
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Attribute[] filterFindByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(
		long attributeId, long groupId, long tthcEntryId, int attributeTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_AttributeException {
		return getPersistence()
				   .filterFindByTTHCEntryAndAttributeTypeAndGroup_PrevAndNext(attributeId,
			groupId, tthcEntryId, attributeTypeId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ attributes.
	*
	* @return the t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t t h c_ attributes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ attributes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTTHCEntryAndCompany(long companyId,
		long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTTHCEntryAndCompany(companyId, tthcEntryId);
	}

	/**
	* Removes all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTTHCEntryAndGroup(long groupId, long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTTHCEntryAndGroup(groupId, tthcEntryId);
	}

	/**
	* Removes all the t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTTHCEntryAndAttributeTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId);
	}

	/**
	* Removes all the t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTTHCEntryAndAttributeTypeAndGroup(long groupId,
		long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTTHCEntryAndAttributeTypeAndGroup(groupId, tthcEntryId,
			attributeTypeId);
	}

	/**
	* Removes all the t t h c_ attributes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @return the number of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTTHCEntryAndCompany(long companyId,
		long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTTHCEntryAndCompany(companyId, tthcEntryId);
	}

	/**
	* Returns the number of t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @return the number of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTTHCEntryAndGroup(long groupId, long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTTHCEntryAndGroup(groupId, tthcEntryId);
	}

	/**
	* Returns the number of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @return the number of matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByTTHCEntryAndGroup(long groupId,
		long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByTTHCEntryAndGroup(groupId, tthcEntryId);
	}

	/**
	* Returns the number of t t h c_ attributes where companyId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @return the number of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTTHCEntryAndAttributeTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTTHCEntryAndAttributeTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId);
	}

	/**
	* Returns the number of t t h c_ attributes where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @return the number of matching t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTTHCEntryAndAttributeTypeAndGroup(long groupId,
		long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId);
	}

	/**
	* Returns the number of t t h c_ attributes that the user has permission to view where groupId = &#63; and tthcEntryId = &#63; and attributeTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param tthcEntryId the tthc entry ID
	* @param attributeTypeId the attribute type ID
	* @return the number of matching t t h c_ attributes that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByTTHCEntryAndAttributeTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByTTHCEntryAndAttributeTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId);
	}

	/**
	* Returns the number of t t h c_ attributes.
	*
	* @return the number of t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TTHC_AttributePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TTHC_AttributePersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.tthc.service.ClpSerializer.getServletContextName(),
					TTHC_AttributePersistence.class.getName());

			ReferenceRegistry.registerReference(TTHC_AttributeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TTHC_AttributePersistence persistence) {
	}

	private static TTHC_AttributePersistence _persistence;
}