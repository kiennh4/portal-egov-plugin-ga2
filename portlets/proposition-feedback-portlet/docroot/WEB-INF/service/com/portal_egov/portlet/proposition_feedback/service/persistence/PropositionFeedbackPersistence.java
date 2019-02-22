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

import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;

/**
 * The persistence interface for the proposition feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionFeedbackPersistenceImpl
 * @see PropositionFeedbackUtil
 * @generated
 */
public interface PropositionFeedbackPersistence extends BasePersistence<PropositionFeedback> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PropositionFeedbackUtil} to access the proposition feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the proposition feedback in the entity cache if it is enabled.
	*
	* @param propositionFeedback the proposition feedback
	*/
	public void cacheResult(
		com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback propositionFeedback);

	/**
	* Caches the proposition feedbacks in the entity cache if it is enabled.
	*
	* @param propositionFeedbacks the proposition feedbacks
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> propositionFeedbacks);

	/**
	* Creates a new proposition feedback with the primary key. Does not add the proposition feedback to the database.
	*
	* @param feedbackId the primary key for the new proposition feedback
	* @return the new proposition feedback
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback create(
		long feedbackId);

	/**
	* Removes the proposition feedback with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the proposition feedback
	* @return the proposition feedback that was removed
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback remove(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback propositionFeedback,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedback with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException} if it could not be found.
	*
	* @param feedbackId the primary key of the proposition feedback
	* @return the proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPrimaryKey(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the proposition feedback with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param feedbackId the primary key of the proposition feedback
	* @return the proposition feedback, or <code>null</code> if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPrimaryKey(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the proposition feedbacks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByCompany_PrevAndNext(
		long feedbackId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByGroup_PrevAndNext(
		long feedbackId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByGroup_PrevAndNext(
		long feedbackId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndCompany(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndCompany(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndCompany(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByStatusAndCompany_PrevAndNext(
		long feedbackId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndCompany_First(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndCompany_First(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndCompany_Last(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndCompany_Last(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndCompany_PrevAndNext(
		long feedbackId, long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndGroup(
		long groupId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndGroup(
		long groupId, long propositionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndGroup(
		long groupId, long propositionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndGroup_First(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndGroup_First(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndGroup_Last(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndGroup_Last(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63; and propositionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByPropositionAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndCompany_First(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndCompany_First(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndCompany_Last(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndCompany_Last(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndStatusAndCompany_PrevAndNext(
		long feedbackId, long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndGroup_First(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndGroup_First(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndGroup_Last(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndGroup_Last(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks that the user has permissions to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition feedbacks before and after the current proposition feedback in the ordered set of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param feedbackId the primary key of the current proposition feedback
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByPropositionAndStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException;

	/**
	* Returns all the proposition feedbacks.
	*
	* @return the proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the proposition feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @return the range of proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the proposition feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of proposition feedbacks
	* @param end the upper bound of the range of proposition feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndCompany(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where companyId = &#63; and propositionId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPropositionAndCompany(long companyId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where groupId = &#63; and propositionId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPropositionAndGroup(long groupId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPropositionAndStatusAndCompany(long companyId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition feedbacks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndCompany(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByPropositionAndCompany(long companyId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByPropositionAndGroup(long groupId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByPropositionAndGroup(long groupId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByPropositionAndStatusAndCompany(long companyId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition feedbacks.
	*
	* @return the number of proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}