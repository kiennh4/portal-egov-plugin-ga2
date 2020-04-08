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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.proposition_feedback.model.Proposition;

/**
 * The persistence interface for the proposition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionPersistenceImpl
 * @see PropositionUtil
 * @generated
 */
public interface PropositionPersistence extends BasePersistence<Proposition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PropositionUtil} to access the proposition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the proposition in the entity cache if it is enabled.
	*
	* @param proposition the proposition
	*/
	public void cacheResult(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition);

	/**
	* Caches the propositions in the entity cache if it is enabled.
	*
	* @param propositions the propositions
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> propositions);

	/**
	* Creates a new proposition with the primary key. Does not add the proposition to the database.
	*
	* @param propositionId the primary key for the new proposition
	* @return the new proposition
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition create(
		long propositionId);

	/**
	* Removes the proposition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition that was removed
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition remove(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	public com.portal_egov.portlet.proposition_feedback.model.Proposition updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException} if it could not be found.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByPrimaryKey(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the proposition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition, or <code>null</code> if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByPrimaryKey(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the propositions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the first proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the last proposition in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCompany_PrevAndNext(
		long propositionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the first proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the last proposition in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByGroup_PrevAndNext(
		long propositionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByGroup_PrevAndNext(
		long propositionId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndCompany_First(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndCompany_First(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndCompany_Last(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndCompany_Last(
		long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndCompany_PrevAndNext(
		long propositionId, long companyId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndGroup_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndGroup_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndGroup_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndGroup_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndGroup(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndGroup(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndGroup(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByCategoryAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the first proposition in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the last proposition in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByStatusAndCompany_PrevAndNext(
		long propositionId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the first proposition in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns the last proposition in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition, or <code>null</code> if a matching proposition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndCompany_First(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndCompany_First(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndCompany_Last(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndCompany_Last(
		long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndStatusAndCompany_PrevAndNext(
		long propositionId, long companyId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndGroup_First(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndGroup_First(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition findByCategoryAndStatusAndGroup_Last(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchByCategoryAndStatusAndGroup_Last(
		long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] findByCategoryAndStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> filterFindByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.Proposition[] filterFindByCategoryAndStatusAndGroup_PrevAndNext(
		long propositionId, long groupId, long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionException;

	/**
	* Returns all the propositions.
	*
	* @return the propositions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where companyId = &#63; and categoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndCompany(long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndCompany(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where companyId = &#63; and categoryId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions where groupId = &#63; and categoryId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the propositions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where companyId = &#63; and categoryId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndCompany(long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndCompany(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where companyId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndStatusAndGroup(long groupId, long categoryId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions that the user has permission to view where groupId = &#63; and categoryId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param status the status
	* @return the number of matching propositions that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of propositions.
	*
	* @return the number of propositions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}