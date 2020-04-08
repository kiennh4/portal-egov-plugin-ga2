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

import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;

import java.util.List;

/**
 * The persistence utility for the proposition feedback service. This utility wraps {@link PropositionFeedbackPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionFeedbackPersistence
 * @see PropositionFeedbackPersistenceImpl
 * @generated
 */
public class PropositionFeedbackUtil {
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
	public static void clearCache(PropositionFeedback propositionFeedback) {
		getPersistence().clearCache(propositionFeedback);
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
	public static List<PropositionFeedback> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PropositionFeedback> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PropositionFeedback> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PropositionFeedback update(
		PropositionFeedback propositionFeedback, boolean merge)
		throws SystemException {
		return getPersistence().update(propositionFeedback, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PropositionFeedback update(
		PropositionFeedback propositionFeedback, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(propositionFeedback, merge, serviceContext);
	}

	/**
	* Caches the proposition feedback in the entity cache if it is enabled.
	*
	* @param propositionFeedback the proposition feedback
	*/
	public static void cacheResult(
		com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback propositionFeedback) {
		getPersistence().cacheResult(propositionFeedback);
	}

	/**
	* Caches the proposition feedbacks in the entity cache if it is enabled.
	*
	* @param propositionFeedbacks the proposition feedbacks
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> propositionFeedbacks) {
		getPersistence().cacheResult(propositionFeedbacks);
	}

	/**
	* Creates a new proposition feedback with the primary key. Does not add the proposition feedback to the database.
	*
	* @param feedbackId the primary key for the new proposition feedback
	* @return the new proposition feedback
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback create(
		long feedbackId) {
		return getPersistence().create(feedbackId);
	}

	/**
	* Removes the proposition feedback with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the proposition feedback
	* @return the proposition feedback that was removed
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback remove(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence().remove(feedbackId);
	}

	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback propositionFeedback,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(propositionFeedback, merge);
	}

	/**
	* Returns the proposition feedback with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException} if it could not be found.
	*
	* @param feedbackId the primary key of the proposition feedback
	* @return the proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPrimaryKey(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence().findByPrimaryKey(feedbackId);
	}

	/**
	* Returns the proposition feedback with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param feedbackId the primary key of the proposition feedback
	* @return the proposition feedback, or <code>null</code> if a proposition feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPrimaryKey(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(feedbackId);
	}

	/**
	* Returns all the proposition feedbacks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByCompany_PrevAndNext(
		long feedbackId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByCompany_PrevAndNext(feedbackId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByGroup_PrevAndNext(
		long feedbackId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByGroup_PrevAndNext(feedbackId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByGroup_PrevAndNext(
		long feedbackId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(feedbackId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndCompany(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndCompany(companyId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndCompany(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(companyId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndCompany(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(companyId, status, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByStatusAndCompany_First(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndCompany_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_First(companyId, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByStatusAndCompany_Last(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndCompany_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_Last(companyId, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByStatusAndCompany_PrevAndNext(
		long feedbackId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByStatusAndCompany_PrevAndNext(feedbackId, companyId,
			status, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(groupId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(groupId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(groupId, status, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByStatusAndGroup_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndGroup_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_First(groupId, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByStatusAndGroup_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByStatusAndGroup_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_Last(groupId, status,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByStatusAndGroup_PrevAndNext(feedbackId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatusAndGroup(groupId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(groupId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByStatusAndGroup(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(groupId, status, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .filterFindByStatusAndGroup_PrevAndNext(feedbackId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndCompany(companyId, propositionId);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndCompany(companyId, propositionId,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndCompany(
		long companyId, long propositionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndCompany(companyId, propositionId,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndCompany_First(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndCompany_First(companyId, propositionId,
			orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndCompany_First(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndCompany_First(companyId,
			propositionId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndCompany_Last(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndCompany_Last(companyId, propositionId,
			orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndCompany_Last(
		long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndCompany_Last(companyId, propositionId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndCompany_PrevAndNext(
		long feedbackId, long companyId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndCompany_PrevAndNext(feedbackId,
			companyId, propositionId, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndGroup(
		long groupId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPropositionAndGroup(groupId, propositionId);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndGroup(
		long groupId, long propositionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndGroup(groupId, propositionId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndGroup(
		long groupId, long propositionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndGroup(groupId, propositionId, start,
			end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndGroup_First(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndGroup_First(groupId, propositionId,
			orderByComparator);
	}

	/**
	* Returns the first proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndGroup_First(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndGroup_First(groupId, propositionId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndGroup_Last(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndGroup_Last(groupId, propositionId,
			orderByComparator);
	}

	/**
	* Returns the last proposition feedback in the ordered set where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition feedback, or <code>null</code> if a matching proposition feedback could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndGroup_Last(
		long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndGroup_Last(groupId, propositionId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndGroup_PrevAndNext(feedbackId, groupId,
			propositionId, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPropositionAndGroup(groupId, propositionId);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPropositionAndGroup(groupId, propositionId,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndGroup(
		long groupId, long propositionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPropositionAndGroup(groupId, propositionId,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByPropositionAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .filterFindByPropositionAndGroup_PrevAndNext(feedbackId,
			groupId, propositionId, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndStatusAndCompany(companyId,
			propositionId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndStatusAndCompany(companyId,
			propositionId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndCompany(
		long companyId, long propositionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndStatusAndCompany(companyId,
			propositionId, status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndCompany_First(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndStatusAndCompany_First(companyId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndCompany_First(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndStatusAndCompany_First(companyId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndCompany_Last(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndStatusAndCompany_Last(companyId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndCompany_Last(
		long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndStatusAndCompany_Last(companyId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndStatusAndCompany_PrevAndNext(
		long feedbackId, long companyId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndStatusAndCompany_PrevAndNext(feedbackId,
			companyId, propositionId, status, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndStatusAndGroup(groupId, propositionId,
			status);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndStatusAndGroup(groupId, propositionId,
			status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPropositionAndStatusAndGroup(groupId, propositionId,
			status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndGroup_First(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndStatusAndGroup_First(groupId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndGroup_First(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndStatusAndGroup_First(groupId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback findByPropositionAndStatusAndGroup_Last(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndStatusAndGroup_Last(groupId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback fetchByPropositionAndStatusAndGroup_Last(
		long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPropositionAndStatusAndGroup_Last(groupId,
			propositionId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] findByPropositionAndStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .findByPropositionAndStatusAndGroup_PrevAndNext(feedbackId,
			groupId, propositionId, status, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPropositionAndStatusAndGroup(groupId,
			propositionId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPropositionAndStatusAndGroup(groupId,
			propositionId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> filterFindByPropositionAndStatusAndGroup(
		long groupId, long propositionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByPropositionAndStatusAndGroup(groupId,
			propositionId, status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback[] filterFindByPropositionAndStatusAndGroup_PrevAndNext(
		long feedbackId, long groupId, long propositionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionFeedbackException {
		return getPersistence()
				   .filterFindByPropositionAndStatusAndGroup_PrevAndNext(feedbackId,
			groupId, propositionId, status, orderByComparator);
	}

	/**
	* Returns all the proposition feedbacks.
	*
	* @return the proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the proposition feedbacks where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the proposition feedbacks where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the proposition feedbacks where companyId = &#63; and status = &#63; from the database.
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
	* Removes all the proposition feedbacks where groupId = &#63; and status = &#63; from the database.
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
	* Removes all the proposition feedbacks where companyId = &#63; and propositionId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPropositionAndCompany(long companyId,
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPropositionAndCompany(companyId, propositionId);
	}

	/**
	* Removes all the proposition feedbacks where groupId = &#63; and propositionId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPropositionAndGroup(long groupId,
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPropositionAndGroup(groupId, propositionId);
	}

	/**
	* Removes all the proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPropositionAndStatusAndCompany(long companyId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPropositionAndStatusAndCompany(companyId, propositionId,
			status);
	}

	/**
	* Removes all the proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPropositionAndStatusAndGroup(groupId, propositionId, status);
	}

	/**
	* Removes all the proposition feedbacks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of proposition feedbacks where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of proposition feedbacks where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of proposition feedbacks where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndCompany(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndCompany(companyId, status);
	}

	/**
	* Returns the number of proposition feedbacks where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndGroup(groupId, status);
	}

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusAndGroup(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatusAndGroup(groupId, status);
	}

	/**
	* Returns the number of proposition feedbacks where companyId = &#63; and propositionId = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPropositionAndCompany(long companyId,
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPropositionAndCompany(companyId, propositionId);
	}

	/**
	* Returns the number of proposition feedbacks where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPropositionAndGroup(long groupId,
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPropositionAndGroup(groupId, propositionId);
	}

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByPropositionAndGroup(long groupId,
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByPropositionAndGroup(groupId, propositionId);
	}

	/**
	* Returns the number of proposition feedbacks where companyId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPropositionAndStatusAndCompany(long companyId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPropositionAndStatusAndCompany(companyId,
			propositionId, status);
	}

	/**
	* Returns the number of proposition feedbacks where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the number of matching proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPropositionAndStatusAndGroup(groupId, propositionId,
			status);
	}

	/**
	* Returns the number of proposition feedbacks that the user has permission to view where groupId = &#63; and propositionId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param propositionId the proposition ID
	* @param status the status
	* @return the number of matching proposition feedbacks that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByPropositionAndStatusAndGroup(long groupId,
		long propositionId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByPropositionAndStatusAndGroup(groupId,
			propositionId, status);
	}

	/**
	* Returns the number of proposition feedbacks.
	*
	* @return the number of proposition feedbacks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PropositionFeedbackPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PropositionFeedbackPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.proposition_feedback.service.ClpSerializer.getServletContextName(),
					PropositionFeedbackPersistence.class.getName());

			ReferenceRegistry.registerReference(PropositionFeedbackUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PropositionFeedbackPersistence persistence) {
	}

	private static PropositionFeedbackPersistence _persistence;
}