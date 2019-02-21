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

package com.portal_egov.portlet.weblinks.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.weblinks.model.Weblink;

import java.util.List;

/**
 * The persistence utility for the weblink service. This utility wraps {@link WeblinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see WeblinkPersistence
 * @see WeblinkPersistenceImpl
 * @generated
 */
public class WeblinkUtil {
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
	public static void clearCache(Weblink weblink) {
		getPersistence().clearCache(weblink);
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
	public static List<Weblink> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Weblink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Weblink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Weblink update(Weblink weblink, boolean merge)
		throws SystemException {
		return getPersistence().update(weblink, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Weblink update(Weblink weblink, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(weblink, merge, serviceContext);
	}

	/**
	* Caches the weblink in the entity cache if it is enabled.
	*
	* @param weblink the weblink
	*/
	public static void cacheResult(
		com.portal_egov.portlet.weblinks.model.Weblink weblink) {
		getPersistence().cacheResult(weblink);
	}

	/**
	* Caches the weblinks in the entity cache if it is enabled.
	*
	* @param weblinks the weblinks
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> weblinks) {
		getPersistence().cacheResult(weblinks);
	}

	/**
	* Creates a new weblink with the primary key. Does not add the weblink to the database.
	*
	* @param weblinkId the primary key for the new weblink
	* @return the new weblink
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink create(
		long weblinkId) {
		return getPersistence().create(weblinkId);
	}

	/**
	* Removes the weblink with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink that was removed
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink remove(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence().remove(weblinkId);
	}

	public static com.portal_egov.portlet.weblinks.model.Weblink updateImpl(
		com.portal_egov.portlet.weblinks.model.Weblink weblink, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(weblink, merge);
	}

	/**
	* Returns the weblink with the primary key or throws a {@link com.portal_egov.portlet.weblinks.NoSuchWeblinkException} if it could not be found.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink findByPrimaryKey(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence().findByPrimaryKey(weblinkId);
	}

	/**
	* Returns the weblink with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink, or <code>null</code> if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink fetchByPrimaryKey(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(weblinkId);
	}

	/**
	* Returns all the weblinks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the weblinks where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @return the range of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the weblinks where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the weblinks before and after the current weblink in the ordered set where companyId = &#63;.
	*
	* @param weblinkId the primary key of the current weblink
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink[] findByCompany_PrevAndNext(
		long weblinkId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence()
				   .findByCompany_PrevAndNext(weblinkId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the weblinks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the weblinks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @return the range of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the weblinks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the weblinks before and after the current weblink in the ordered set where groupId = &#63;.
	*
	* @param weblinkId the primary key of the current weblink
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink[] findByGroup_PrevAndNext(
		long weblinkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence()
				   .findByGroup_PrevAndNext(weblinkId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the weblinks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching weblinks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the weblinks that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @return the range of matching weblinks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the weblinks that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching weblinks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the weblinks before and after the current weblink in the ordered set of weblinks that the user has permission to view where groupId = &#63;.
	*
	* @param weblinkId the primary key of the current weblink
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink[] filterFindByGroup_PrevAndNext(
		long weblinkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(weblinkId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the weblinks where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @return the matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long weblinkCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(weblinkCategoryId);
	}

	/**
	* Returns a range of all the weblinks where weblinkCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param weblinkCategoryId the weblink category ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @return the range of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long weblinkCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(weblinkCategoryId, start, end);
	}

	/**
	* Returns an ordered range of all the weblinks where weblinkCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param weblinkCategoryId the weblink category ID
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long weblinkCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(weblinkCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink findByCategory_First(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence()
				   .findByCategory_First(weblinkCategoryId, orderByComparator);
	}

	/**
	* Returns the first weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink fetchByCategory_First(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(weblinkCategoryId, orderByComparator);
	}

	/**
	* Returns the last weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink findByCategory_Last(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence()
				   .findByCategory_Last(weblinkCategoryId, orderByComparator);
	}

	/**
	* Returns the last weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink fetchByCategory_Last(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(weblinkCategoryId, orderByComparator);
	}

	/**
	* Returns the weblinks before and after the current weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkId the primary key of the current weblink
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink[] findByCategory_PrevAndNext(
		long weblinkId, long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException {
		return getPersistence()
				   .findByCategory_PrevAndNext(weblinkId, weblinkCategoryId,
			orderByComparator);
	}

	/**
	* Returns all the weblinks.
	*
	* @return the weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the weblinks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @return the range of weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the weblinks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the weblinks where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the weblinks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the weblinks where weblinkCategoryId = &#63; from the database.
	*
	* @param weblinkCategoryId the weblink category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long weblinkCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(weblinkCategoryId);
	}

	/**
	* Removes all the weblinks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of weblinks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of weblinks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of weblinks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching weblinks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of weblinks where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @return the number of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long weblinkCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(weblinkCategoryId);
	}

	/**
	* Returns the number of weblinks.
	*
	* @return the number of weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WeblinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WeblinkPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.weblinks.service.ClpSerializer.getServletContextName(),
					WeblinkPersistence.class.getName());

			ReferenceRegistry.registerReference(WeblinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(WeblinkPersistence persistence) {
	}

	private static WeblinkPersistence _persistence;
}