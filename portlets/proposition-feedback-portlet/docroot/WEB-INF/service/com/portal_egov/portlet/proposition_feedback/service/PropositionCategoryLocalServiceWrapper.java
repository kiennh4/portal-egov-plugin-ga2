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
 * This class is a wrapper for {@link PropositionCategoryLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       PropositionCategoryLocalService
 * @generated
 */
public class PropositionCategoryLocalServiceWrapper
	implements PropositionCategoryLocalService,
		ServiceWrapper<PropositionCategoryLocalService> {
	public PropositionCategoryLocalServiceWrapper(
		PropositionCategoryLocalService propositionCategoryLocalService) {
		_propositionCategoryLocalService = propositionCategoryLocalService;
	}

	/**
	* Adds the proposition category to the database. Also notifies the appropriate model listeners.
	*
	* @param propositionCategory the proposition category
	* @return the proposition category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory addPropositionCategory(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.addPropositionCategory(propositionCategory);
	}

	/**
	* Creates a new proposition category with the primary key. Does not add the proposition category to the database.
	*
	* @param categoryId the primary key for the new proposition category
	* @return the new proposition category
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory createPropositionCategory(
		long categoryId) {
		return _propositionCategoryLocalService.createPropositionCategory(categoryId);
	}

	/**
	* Deletes the proposition category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category that was removed
	* @throws PortalException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory deletePropositionCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.deletePropositionCategory(categoryId);
	}

	/**
	* Deletes the proposition category from the database. Also notifies the appropriate model listeners.
	*
	* @param propositionCategory the proposition category
	* @return the proposition category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory deletePropositionCategory(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.deletePropositionCategory(propositionCategory);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _propositionCategoryLocalService.dynamicQuery();
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
		return _propositionCategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _propositionCategoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _propositionCategoryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _propositionCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchPropositionCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.fetchPropositionCategory(categoryId);
	}

	/**
	* Returns the proposition category with the primary key.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category
	* @throws PortalException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory getPropositionCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.getPropositionCategory(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the proposition categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> getPropositionCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.getPropositionCategories(start,
			end);
	}

	/**
	* Returns the number of proposition categories.
	*
	* @return the number of proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int getPropositionCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.getPropositionCategoriesCount();
	}

	/**
	* Updates the proposition category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param propositionCategory the proposition category
	* @return the proposition category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory updatePropositionCategory(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.updatePropositionCategory(propositionCategory);
	}

	/**
	* Updates the proposition category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param propositionCategory the proposition category
	* @param merge whether to merge the proposition category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the proposition category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory updatePropositionCategory(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.updatePropositionCategory(propositionCategory,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _propositionCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_propositionCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _propositionCategoryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.countByGroup(groupId);
	}

	public int countByTypeAndCompany(long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.countByTypeAndCompany(companyId,
			categoryTypeId);
	}

	public int countByTypeAndGroup(long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.countByTypeAndGroup(groupId,
			categoryTypeId);
	}

	public int countByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.countByParentAndCompany(companyId,
			parentId);
	}

	public int countByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.countByParentAndGroup(groupId,
			parentId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByCompany(companyId, start,
			end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByTypeAndCompany(companyId,
			categoryTypeId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByTypeAndCompany(companyId,
			categoryTypeId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByTypeAndGroup(groupId,
			categoryTypeId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByTypeAndGroup(groupId,
			categoryTypeId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByParentAndCompany(companyId,
			parentId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByParentAndCompany(companyId,
			parentId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByParentAndGroup(groupId,
			parentId);
	}

	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.findByParentAndGroup(groupId,
			parentId, start, end);
	}

	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory addCategory(
		long companyId, long groupId, long userId, int categoryTypeId,
		long parentId, java.lang.String categoryName,
		java.lang.String categoryDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.addCategory(companyId, groupId,
			userId, categoryTypeId, parentId, categoryName, categoryDesc,
			serviceContext);
	}

	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory updateCategory(
		long categoryId, long companyId, long groupId, long userId,
		int categoryTypeId, long parentId, java.lang.String categoryName,
		java.lang.String categoryDesc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategoryLocalService.updateCategory(categoryId,
			companyId, groupId, userId, categoryTypeId, parentId, categoryName,
			categoryDesc);
	}

	public void incrementPropositionCounter(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_propositionCategoryLocalService.incrementPropositionCounter(categoryId);
	}

	public void descrementPropositionCounter(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_propositionCategoryLocalService.descrementPropositionCounter(categoryId);
	}

	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_propositionCategoryLocalService.deleteCategory(categoryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PropositionCategoryLocalService getWrappedPropositionCategoryLocalService() {
		return _propositionCategoryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPropositionCategoryLocalService(
		PropositionCategoryLocalService propositionCategoryLocalService) {
		_propositionCategoryLocalService = propositionCategoryLocalService;
	}

	public PropositionCategoryLocalService getWrappedService() {
		return _propositionCategoryLocalService;
	}

	public void setWrappedService(
		PropositionCategoryLocalService propositionCategoryLocalService) {
		_propositionCategoryLocalService = propositionCategoryLocalService;
	}

	private PropositionCategoryLocalService _propositionCategoryLocalService;
}