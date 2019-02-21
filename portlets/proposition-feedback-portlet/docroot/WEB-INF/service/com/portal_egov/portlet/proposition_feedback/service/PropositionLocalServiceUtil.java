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

package com.portal_egov.portlet.proposition_feedback.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the proposition local service. This utility wraps {@link com.portal_egov.portlet.proposition_feedback.service.impl.PropositionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see PropositionLocalService
 * @see com.portal_egov.portlet.proposition_feedback.service.base.PropositionLocalServiceBaseImpl
 * @see com.portal_egov.portlet.proposition_feedback.service.impl.PropositionLocalServiceImpl
 * @generated
 */
public class PropositionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.proposition_feedback.service.impl.PropositionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the proposition to the database. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @return the proposition that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition addProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProposition(proposition);
	}

	/**
	* Creates a new proposition with the primary key. Does not add the proposition to the database.
	*
	* @param propositionId the primary key for the new proposition
	* @return the new proposition
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition createProposition(
		long propositionId) {
		return getService().createProposition(propositionId);
	}

	/**
	* Deletes the proposition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition that was removed
	* @throws PortalException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition deleteProposition(
		long propositionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProposition(propositionId);
	}

	/**
	* Deletes the proposition from the database. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @return the proposition that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition deleteProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProposition(proposition);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.portal_egov.portlet.proposition_feedback.model.Proposition fetchProposition(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProposition(propositionId);
	}

	/**
	* Returns the proposition with the primary key.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition
	* @throws PortalException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition getProposition(
		long propositionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProposition(propositionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> getPropositions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPropositions(start, end);
	}

	/**
	* Returns the number of propositions.
	*
	* @return the number of propositions
	* @throws SystemException if a system exception occurred
	*/
	public static int getPropositionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPropositionsCount();
	}

	/**
	* Updates the proposition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @return the proposition that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition updateProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProposition(proposition);
	}

	/**
	* Updates the proposition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @param merge whether to merge the proposition with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the proposition that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.Proposition updateProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProposition(proposition, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int countByCategoryAndCompany(long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryAndCompany(companyId, categoryId);
	}

	public static int countByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryAndGroup(groupId, categoryId);
	}

	public static int countByStatusAndCompany(long companyId,
		int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatusAndCompany(companyId, propositionStatus);
	}

	public static int countByStatusAndGroup(long groupId, int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatusAndGroup(groupId, propositionStatus);
	}

	public static int countByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCategoryAndStatusAndCompany(companyId, categoryId,
			propositionStatus);
	}

	public static int countByCategoryAndStatusAndGroup(long groupId,
		long categoryId, int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCategoryAndStatusAndGroup(groupId, categoryId,
			propositionStatus);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndCompany(companyId, categoryId);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndCompany(companyId, categoryId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndGroup(groupId, categoryId);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndGroup(groupId, categoryId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndCompany(companyId, status);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndCompany(companyId, status, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndGroup(groupId, status);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndGroup(groupId, status, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndStatusAndCompany(companyId, categoryId,
			status);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndStatusAndCompany(companyId, categoryId,
			status, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndStatusAndGroup(groupId, categoryId, status);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndStatusAndGroup(groupId, categoryId,
			status, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByMultiCondition(
		long groupId, long categoryId, long compilationDepartmentId,
		long verificationDepartmentId, java.lang.String keyword,
		int propositionStatus, int start, int end) {
		return getService()
				   .findByMultiCondition(groupId, categoryId,
			compilationDepartmentId, verificationDepartmentId, keyword,
			propositionStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByMultiCondition(
		long groupId, long categoryId, long compilationDepartmentId,
		long verificationDepartmentId, java.lang.String keyword,
		int propositionStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .findByMultiCondition(groupId, categoryId,
			compilationDepartmentId, verificationDepartmentId, keyword,
			propositionStatus, start, end, obc);
	}

	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByPropositionStatus(
		long groupId, int propositionStatus, java.lang.String orderByColumn,
		java.lang.String orderByType, int start, int end) {
		return getService()
				   .findByPropositionStatus(groupId, propositionStatus,
			orderByColumn, orderByType, start, end);
	}

	public static com.portal_egov.portlet.proposition_feedback.model.Proposition addProposition(
		long companyId, long groupId, long userId, long categoryId,
		long compilationDepartmentId, long verificationDepartmentId,
		java.lang.String propositionName, java.lang.String propositionDesc,
		java.lang.String propositionContent, long documentFileId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addProposition(companyId, groupId, userId, categoryId,
			compilationDepartmentId, verificationDepartmentId, propositionName,
			propositionDesc, propositionContent, documentFileId, status,
			serviceContext);
	}

	public static com.portal_egov.portlet.proposition_feedback.model.Proposition updateProposition(
		long propositionId, long companyId, long groupId, long userId,
		long categoryId, long compilationDepartmentId,
		long verificationDepartmentId, java.lang.String propositionName,
		java.lang.String propositionDesc, java.lang.String propositionContent,
		long documentFileId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateProposition(propositionId, companyId, groupId,
			userId, categoryId, compilationDepartmentId,
			verificationDepartmentId, propositionName, propositionDesc,
			propositionContent, documentFileId, status);
	}

	public static com.portal_egov.portlet.proposition_feedback.model.Proposition incrementViewCounter(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().incrementViewCounter(propositionId);
	}

	public static void incrementFeedbackCounter(long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().incrementFeedbackCounter(propositionId);
	}

	public static void descrementFeedbackCounter(long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().descrementFeedbackCounter(propositionId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PropositionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PropositionLocalService.class.getName());

			if (invokableLocalService instanceof PropositionLocalService) {
				_service = (PropositionLocalService)invokableLocalService;
			}
			else {
				_service = new PropositionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PropositionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PropositionLocalService service) {
	}

	private static PropositionLocalService _service;
}