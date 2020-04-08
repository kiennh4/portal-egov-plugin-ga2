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

package com.portal_egov.portlet.tthc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TTHC_CategoryLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_CategoryLocalService
 * @generated
 */
public class TTHC_CategoryLocalServiceWrapper
	implements TTHC_CategoryLocalService,
		ServiceWrapper<TTHC_CategoryLocalService> {
	public TTHC_CategoryLocalServiceWrapper(
		TTHC_CategoryLocalService tthc_CategoryLocalService) {
		_tthc_CategoryLocalService = tthc_CategoryLocalService;
	}

	/**
	* Adds the t t h c_ category to the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Category the t t h c_ category
	* @return the t t h c_ category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category addTTHC_Category(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.addTTHC_Category(tthc_Category);
	}

	/**
	* Creates a new t t h c_ category with the primary key. Does not add the t t h c_ category to the database.
	*
	* @param categoryId the primary key for the new t t h c_ category
	* @return the new t t h c_ category
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category createTTHC_Category(
		long categoryId) {
		return _tthc_CategoryLocalService.createTTHC_Category(categoryId);
	}

	/**
	* Deletes the t t h c_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the t t h c_ category
	* @return the t t h c_ category that was removed
	* @throws PortalException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category deleteTTHC_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.deleteTTHC_Category(categoryId);
	}

	/**
	* Deletes the t t h c_ category from the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Category the t t h c_ category
	* @return the t t h c_ category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category deleteTTHC_Category(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.deleteTTHC_Category(tthc_Category);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tthc_CategoryLocalService.dynamicQuery();
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
		return _tthc_CategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _tthc_CategoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _tthc_CategoryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _tthc_CategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchTTHC_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.fetchTTHC_Category(categoryId);
	}

	/**
	* Returns the t t h c_ category with the primary key.
	*
	* @param categoryId the primary key of the t t h c_ category
	* @return the t t h c_ category
	* @throws PortalException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category getTTHC_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.getTTHC_Category(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t t h c_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> getTTHC_Categories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.getTTHC_Categories(start, end);
	}

	/**
	* Returns the number of t t h c_ categories.
	*
	* @return the number of t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int getTTHC_CategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.getTTHC_CategoriesCount();
	}

	/**
	* Updates the t t h c_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Category the t t h c_ category
	* @return the t t h c_ category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category updateTTHC_Category(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.updateTTHC_Category(tthc_Category);
	}

	/**
	* Updates the t t h c_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Category the t t h c_ category
	* @param merge whether to merge the t t h c_ category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the t t h c_ category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category updateTTHC_Category(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.updateTTHC_Category(tthc_Category,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tthc_CategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tthc_CategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tthc_CategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.countByGroup(groupId);
	}

	public int countByParentAndCompany(long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.countByParentAndCompany(parentId,
			companyId);
	}

	public int countByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.countByParentAndGroup(parentId,
			groupId);
	}

	public int countByTypeAndCompany(int categoryTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.countByTypeAndCompany(categoryTypeId,
			companyId);
	}

	public int countByTypeAndGroup(int categoryTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.countByTypeAndGroup(categoryTypeId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndCompany(
		long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByParentAndCompany(parentId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndCompany(
		long parentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByParentAndCompany(parentId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndGroup(
		long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByParentAndGroup(parentId, groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndGroup(
		long parentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByParentAndGroup(parentId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndCompany(
		int categoryTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByTypeAndCompany(categoryTypeId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndCompany(
		int categoryTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByTypeAndCompany(categoryTypeId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndGroup(
		int categoryTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByTypeAndGroup(categoryTypeId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndGroup(
		int categoryTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.findByTypeAndGroup(categoryTypeId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByKeyword(
		long groupId, int categoryTypeId, java.lang.String keyword, int start,
		int end) {
		return _tthc_CategoryLocalService.findByKeyword(groupId,
			categoryTypeId, keyword, start, end);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Category addTTHCCategory(
		long companyId, long groupId, long userId, long parentId,
		int categoryTypeId, java.lang.String categoryName,
		java.lang.String categoryDesc, int displayPriority,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.addTTHCCategory(companyId, groupId,
			userId, parentId, categoryTypeId, categoryName, categoryDesc,
			displayPriority, serviceContext);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Category updateTTHCCategory(
		long categoryId, long companyId, long groupId, long userId,
		long parentId, int categoryTypeId, java.lang.String categoryName,
		java.lang.String categoryDesc, int displayPriority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_CategoryLocalService.updateTTHCCategory(categoryId,
			companyId, groupId, userId, parentId, categoryTypeId, categoryName,
			categoryDesc, displayPriority);
	}

	public void deleteTTHCCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tthc_CategoryLocalService.deleteTTHCCategory(categoryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TTHC_CategoryLocalService getWrappedTTHC_CategoryLocalService() {
		return _tthc_CategoryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTTHC_CategoryLocalService(
		TTHC_CategoryLocalService tthc_CategoryLocalService) {
		_tthc_CategoryLocalService = tthc_CategoryLocalService;
	}

	public TTHC_CategoryLocalService getWrappedService() {
		return _tthc_CategoryLocalService;
	}

	public void setWrappedService(
		TTHC_CategoryLocalService tthc_CategoryLocalService) {
		_tthc_CategoryLocalService = tthc_CategoryLocalService;
	}

	private TTHC_CategoryLocalService _tthc_CategoryLocalService;
}