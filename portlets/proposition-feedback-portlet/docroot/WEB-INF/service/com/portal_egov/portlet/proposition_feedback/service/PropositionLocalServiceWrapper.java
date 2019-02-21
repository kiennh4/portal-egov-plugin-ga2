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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PropositionLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       PropositionLocalService
 * @generated
 */
public class PropositionLocalServiceWrapper implements PropositionLocalService,
	ServiceWrapper<PropositionLocalService> {
	public PropositionLocalServiceWrapper(
		PropositionLocalService propositionLocalService) {
		_propositionLocalService = propositionLocalService;
	}

	/**
	* Adds the proposition to the database. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @return the proposition that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition addProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.addProposition(proposition);
	}

	/**
	* Creates a new proposition with the primary key. Does not add the proposition to the database.
	*
	* @param propositionId the primary key for the new proposition
	* @return the new proposition
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition createProposition(
		long propositionId) {
		return _propositionLocalService.createProposition(propositionId);
	}

	/**
	* Deletes the proposition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition that was removed
	* @throws PortalException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition deleteProposition(
		long propositionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.deleteProposition(propositionId);
	}

	/**
	* Deletes the proposition from the database. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @return the proposition that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition deleteProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.deleteProposition(proposition);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _propositionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.proposition_feedback.model.Proposition fetchProposition(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.fetchProposition(propositionId);
	}

	/**
	* Returns the proposition with the primary key.
	*
	* @param propositionId the primary key of the proposition
	* @return the proposition
	* @throws PortalException if a proposition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition getProposition(
		long propositionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.getProposition(propositionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> getPropositions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.getPropositions(start, end);
	}

	/**
	* Returns the number of propositions.
	*
	* @return the number of propositions
	* @throws SystemException if a system exception occurred
	*/
	public int getPropositionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.getPropositionsCount();
	}

	/**
	* Updates the proposition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @return the proposition that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition updateProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.updateProposition(proposition);
	}

	/**
	* Updates the proposition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param proposition the proposition
	* @param merge whether to merge the proposition with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the proposition that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.Proposition updateProposition(
		com.portal_egov.portlet.proposition_feedback.model.Proposition proposition,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.updateProposition(proposition, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _propositionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_propositionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _propositionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByGroup(groupId);
	}

	public int countByCategoryAndCompany(long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByCategoryAndCompany(companyId,
			categoryId);
	}

	public int countByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByCategoryAndGroup(groupId,
			categoryId);
	}

	public int countByStatusAndCompany(long companyId, int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByStatusAndCompany(companyId,
			propositionStatus);
	}

	public int countByStatusAndGroup(long groupId, int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByStatusAndGroup(groupId,
			propositionStatus);
	}

	public int countByCategoryAndStatusAndCompany(long companyId,
		long categoryId, int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByCategoryAndStatusAndCompany(companyId,
			categoryId, propositionStatus);
	}

	public int countByCategoryAndStatusAndGroup(long groupId, long categoryId,
		int propositionStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.countByCategoryAndStatusAndGroup(groupId,
			categoryId, propositionStatus);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndCompany(companyId,
			categoryId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndCompany(
		long companyId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndCompany(companyId,
			categoryId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndGroup(groupId,
			categoryId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndGroup(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndGroup(groupId,
			categoryId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByStatusAndCompany(companyId, status);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndCompany(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByStatusAndCompany(companyId,
			status, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByStatusAndGroup(groupId, status);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByStatusAndGroup(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByStatusAndGroup(groupId, status,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndStatusAndCompany(companyId,
			categoryId, status);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndCompany(
		long companyId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndStatusAndCompany(companyId,
			categoryId, status, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndStatusAndGroup(groupId,
			categoryId, status);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByCategoryAndStatusAndGroup(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.findByCategoryAndStatusAndGroup(groupId,
			categoryId, status, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByMultiCondition(
		long groupId, long categoryId, long compilationDepartmentId,
		long verificationDepartmentId, java.lang.String keyword,
		int propositionStatus, int start, int end) {
		return _propositionLocalService.findByMultiCondition(groupId,
			categoryId, compilationDepartmentId, verificationDepartmentId,
			keyword, propositionStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByMultiCondition(
		long groupId, long categoryId, long compilationDepartmentId,
		long verificationDepartmentId, java.lang.String keyword,
		int propositionStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _propositionLocalService.findByMultiCondition(groupId,
			categoryId, compilationDepartmentId, verificationDepartmentId,
			keyword, propositionStatus, start, end, obc);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.Proposition> findByPropositionStatus(
		long groupId, int propositionStatus, java.lang.String orderByColumn,
		java.lang.String orderByType, int start, int end) {
		return _propositionLocalService.findByPropositionStatus(groupId,
			propositionStatus, orderByColumn, orderByType, start, end);
	}

	public com.portal_egov.portlet.proposition_feedback.model.Proposition addProposition(
		long companyId, long groupId, long userId, long categoryId,
		long compilationDepartmentId, long verificationDepartmentId,
		java.lang.String propositionName, java.lang.String propositionDesc,
		java.lang.String propositionContent, long documentFileId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.addProposition(companyId, groupId,
			userId, categoryId, compilationDepartmentId,
			verificationDepartmentId, propositionName, propositionDesc,
			propositionContent, documentFileId, status, serviceContext);
	}

	public com.portal_egov.portlet.proposition_feedback.model.Proposition updateProposition(
		long propositionId, long companyId, long groupId, long userId,
		long categoryId, long compilationDepartmentId,
		long verificationDepartmentId, java.lang.String propositionName,
		java.lang.String propositionDesc, java.lang.String propositionContent,
		long documentFileId, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.updateProposition(propositionId,
			companyId, groupId, userId, categoryId, compilationDepartmentId,
			verificationDepartmentId, propositionName, propositionDesc,
			propositionContent, documentFileId, status);
	}

	public com.portal_egov.portlet.proposition_feedback.model.Proposition incrementViewCounter(
		long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionLocalService.incrementViewCounter(propositionId);
	}

	public void incrementFeedbackCounter(long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_propositionLocalService.incrementFeedbackCounter(propositionId);
	}

	public void descrementFeedbackCounter(long propositionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_propositionLocalService.descrementFeedbackCounter(propositionId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PropositionLocalService getWrappedPropositionLocalService() {
		return _propositionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPropositionLocalService(
		PropositionLocalService propositionLocalService) {
		_propositionLocalService = propositionLocalService;
	}

	public PropositionLocalService getWrappedService() {
		return _propositionLocalService;
	}

	public void setWrappedService(
		PropositionLocalService propositionLocalService) {
		_propositionLocalService = propositionLocalService;
	}

	private PropositionLocalService _propositionLocalService;
}