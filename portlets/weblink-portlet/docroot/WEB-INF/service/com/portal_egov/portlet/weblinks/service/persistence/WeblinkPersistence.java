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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.weblinks.model.Weblink;

/**
 * The persistence interface for the weblink service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see WeblinkPersistenceImpl
 * @see WeblinkUtil
 * @generated
 */
public interface WeblinkPersistence extends BasePersistence<Weblink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WeblinkUtil} to access the weblink persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the weblink in the entity cache if it is enabled.
	*
	* @param weblink the weblink
	*/
	public void cacheResult(
		com.portal_egov.portlet.weblinks.model.Weblink weblink);

	/**
	* Caches the weblinks in the entity cache if it is enabled.
	*
	* @param weblinks the weblinks
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> weblinks);

	/**
	* Creates a new weblink with the primary key. Does not add the weblink to the database.
	*
	* @param weblinkId the primary key for the new weblink
	* @return the new weblink
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink create(long weblinkId);

	/**
	* Removes the weblink with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink that was removed
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink remove(long weblinkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	public com.portal_egov.portlet.weblinks.model.Weblink updateImpl(
		com.portal_egov.portlet.weblinks.model.Weblink weblink, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the weblink with the primary key or throws a {@link com.portal_egov.portlet.weblinks.NoSuchWeblinkException} if it could not be found.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink findByPrimaryKey(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns the weblink with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink, or <code>null</code> if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink fetchByPrimaryKey(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the weblinks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns the first weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns the last weblink in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.weblinks.model.Weblink[] findByCompany_PrevAndNext(
		long weblinkId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns all the weblinks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns the first weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns the last weblink in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.weblinks.model.Weblink[] findByGroup_PrevAndNext(
		long weblinkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns all the weblinks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching weblinks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.weblinks.model.Weblink[] filterFindByGroup_PrevAndNext(
		long weblinkId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns all the weblinks where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @return the matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long weblinkCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long weblinkCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long weblinkCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink findByCategory_First(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns the first weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink fetchByCategory_First(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkException if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink findByCategory_Last(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns the last weblink in the ordered set where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink, or <code>null</code> if a matching weblink could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.Weblink fetchByCategory_Last(
		long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.weblinks.model.Weblink[] findByCategory_PrevAndNext(
		long weblinkId, long weblinkCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkException;

	/**
	* Returns all the weblinks.
	*
	* @return the weblinks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the weblinks where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the weblinks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the weblinks where weblinkCategoryId = &#63; from the database.
	*
	* @param weblinkCategoryId the weblink category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long weblinkCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the weblinks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblinks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblinks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblinks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching weblinks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblinks where weblinkCategoryId = &#63;.
	*
	* @param weblinkCategoryId the weblink category ID
	* @return the number of matching weblinks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long weblinkCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblinks.
	*
	* @return the number of weblinks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}