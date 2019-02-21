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

package com.portal_egov.portlet.proposition_feedback.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.proposition_feedback.model.Proposition;

import java.util.List;

/**
 * The persistence utility for the proposition service. This utility wraps {@link PropositionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionPersistence
 * @see PropositionPersistenceImpl
 * @generated
 */
public class PropositionUtil {
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
	public static void clearCache(Proposition proposition) {
		getPersistence().clearCache(proposition);
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
	public static List<Proposition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Proposition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Proposition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Proposition update(Proposition proposition, boolean merge)
		throws SystemException {
		return getPersistence().update(proposition, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Proposition update(Proposition proposition, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(proposition, merge, serviceContext);
	}

	/**
	* Caches the proposition in the entity cache if it is enabled.
	*
	* @param proposition the proposition
	*/
	public static void cacheResult(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition) {
		getPersistence().cacheResult(proposition);
	}

	/**
	* Caches the propositions in the entity cache if it is enabled.
	*
	* @param propositions the propositions
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> propositions) {
		getPersistence().cacheResult(propositions);
	}

	/**
	* Creates a new proposition with the primary key. Does not add the proposition to the database.
	*
	* @param propositionId the primary key for the new proposition
	* @return the new proposition
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition create(
		long propositionId) {
		return getPersistence().create(propositionId);
	}

	/**
	* Removes the proposition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition that was removed
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition remove(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence().remove(propositionId);
	}

	public static com.portal_egov.portlet.proposition_feedback.model.Proposition updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(proposition, merge);
	}

	/**
	* Returns the proposition with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException} if it could not be found.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByPrimaryKey(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence().findByPrimaryKey(propositionId);
	}

	/**
	* Returns the proposition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition, or <code>null</code> if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByPrimaryKey(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(propositionId);
	}

	/**
	* Returns all the propositions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the propositions where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where companyId = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCompany_PrevAndNext(
		long propositionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCompany_PrevAndNext(propositionId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the propositions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the propositions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where groupId = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByGroup_PrevAndNext(
		long propositionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByGroup_PrevAndNext(propositionId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the propositions that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByGroup_PrevAndNext(
		long propositionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(propositionId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the propositions where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndCompany(companyId, categoryId);
	}

	/**
	* Returns a range of all the propositions where companyId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(companyId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where companyId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(companyId, categoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndCompany_First(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndCompany_First(companyId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndCompany_First(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_First(companyId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndCompany_Last(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndCompany_Last(companyId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndCompany_Last(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_Last(companyId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndCompany_PrevAndNext(
		long propositionId, long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndCompany_PrevAndNext(propositionId,
			companyId, categoryId, orderByComparator);
	}

	/**
	* Returns all the propositions where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndGroup(groupId, categoryId);
	}

	/**
	* Returns a range of all the propositions where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(groupId, categoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndGroup_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndGroup_First(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndGroup_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_First(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndGroup_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndGroup_Last(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndGroup_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_Last(groupId, categoryId,
			orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndGroup_PrevAndNext(propositionId, groupId,
			categoryId, orderByComparator);
	}

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndGroup(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCategoryAndGroup(groupId, categoryId);
	}

	/**
	* Returns a range of all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndGroup(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(groupId, categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndGroup(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(groupId, categoryId, start,
			end, orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByCategoryAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .filterFindByCategoryAndGroup_PrevAndNext(propositionId,
			groupId, categoryId, orderByComparator);
	}

	/**
	* Returns all the propositions where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndCompany(companyId, status);
	}

	/**
	* Returns a range of all the propositions where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(companyId, status, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(companyId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByStatusAndCompany_First(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_First(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByStatusAndCompany_Last(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_Last(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByStatusAndCompany_PrevAndNext(
		long propositionId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByStatusAndCompany_PrevAndNext(propositionId,
			companyId, status, orderByComparator);
	}

	/**
	* Returns all the propositions where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(groupId, status);
	}

	/**
	* Returns a range of all the propositions where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByStatusAndGroup_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByStatusAndGroup_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_Last(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByStatusAndGroup_PrevAndNext(propositionId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatusAndGroup(groupId, status);
	}

	/**
	* Returns a range of all the propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .filterFindByStatusAndGroup_PrevAndNext(propositionId,
			groupId, status, orderByComparator);
	}

	/**
	* Returns all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatusAndCompany(companyId, categoryId,
			status);
	}

	/**
	* Returns a range of all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatusAndCompany(companyId, categoryId,
			status, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatusAndCompany(companyId, categoryId,
			status, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndCompany_First(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndStatusAndCompany_First(companyId,
			categoryId, status, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndCompany_First(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndStatusAndCompany_First(companyId,
			categoryId, status, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndCompany_Last(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndStatusAndCompany_Last(companyId,
			categoryId, status, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndCompany_Last(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndStatusAndCompany_Last(companyId,
			categoryId, status, orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndStatusAndCompany_PrevAndNext(
		long propositionId, long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndStatusAndCompany_PrevAndNext(propositionId,
			companyId, categoryId, status, orderByComparator);
	}

	/**
	* Returns all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatusAndGroup(groupId, categoryId, status);
	}

	/**
	* Returns a range of all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatusAndGroup(groupId, categoryId,
			status, start, end);
	}

	/**
	* Returns an ordered range of all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndStatusAndGroup(groupId, categoryId,
			status, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndGroup_First(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndStatusAndGroup_First(groupId, categoryId,
			status, orderByComparator);
	}

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndGroup_First(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndStatusAndGroup_First(groupId, categoryId,
			status, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndGroup_Last(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndStatusAndGroup_Last(groupId, categoryId,
			status, orderByComparator);
	}

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndGroup_Last(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndStatusAndGroup_Last(groupId, categoryId,
			status, orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .findByCategoryAndStatusAndGroup_PrevAndNext(propositionId,
			groupId, categoryId, status, orderByComparator);
	}

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndStatusAndGroup(groupId, categoryId,
			status);
	}

	/**
	* Returns a range of all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndStatusAndGroup(groupId, categoryId,
			status, start, end);
	}

	/**
	* Returns an ordered range of all the propositions that the user has permissions to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndStatusAndGroup(groupId, categoryId,
			status, start, end, orderByComparator);
	}

	/**
	* Returns the propositions before and after the current proposition in the ordered set of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param propositionId the primary key of the current proposition
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByCategoryAndStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException {
		return getPersistence()
				   .filterFindByCategoryAndStatusAndGroup_PrevAndNext(propositionId,
			groupId, categoryId, status, orderByComparator);
	}

	/**
	* Returns all the propositions.
	*
	* @return the propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the propositions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @return the range of propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the propositions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of propositions
	* @param end the upper bound of the range of propositions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of propositions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the propositions where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the propositions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the propositions where companyId = &#63; and categoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndCompany(long companyId,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAndCompany(companyId, categoryId);
	}

	/**
	* Removes all the propositions where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAndGroup(groupId, categoryId);
	}

	/**
	* Removes all the propositions where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndCompany(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndCompany(companyId, status);
	}

	/**
	* Removes all the propositions where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndGroup(groupId, status);
	}

	/**
	* Removes all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCategoryAndStatusAndCompany(companyId, categoryId, status);
	}

	/**
	* Removes all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCategoryAndStatusAndGroup(groupId, categoryId, status);
	}

	/**
	* Removes all the propositions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of propositions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of propositions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of propositions where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndCompany(long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndCompany(companyId, categoryId);
	}

	/**
	* Returns the number of propositions where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndGroup(groupId, categoryId);
	}

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryAndGroup(long groupId,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryAndGroup(groupId, categoryId);
	}

	/**
	* Returns the number of propositions where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndCompany(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndCompany(companyId, status);
	}

	/**
	* Returns the number of propositions where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndGroup(groupId, status);
	}

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatusAndGroup(groupId, status);
	}

	/**
	* Returns the number of propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCategoryAndStatusAndCompany(companyId, categoryId,
			status);
	}

	/**
	* Returns the number of propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCategoryAndStatusAndGroup(groupId, categoryId, status);
	}

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryAndStatusAndGroup(groupId, categoryId,
			status);
	}

	/**
	* Returns the number of propositions.
	*
	* @return the number of propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PropositionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PropositionPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.proposition_feedback.service.ClpSerializer.getServletContextName(),
					PropositionPersistence.class.getName());

			ReferenceRegistry.registerReference(PropositionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PropositionPersistence persistence) {
	}

	private static PropositionPersistence _persistence;
}