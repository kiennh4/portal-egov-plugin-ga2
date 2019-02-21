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

package com.portal_egov.portlet.weblinks.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WeblinkCategoryLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       WeblinkCategoryLocalService
 * @generated
 */
public class WeblinkCategoryLocalServiceWrapper
	implements WeblinkCategoryLocalService,
		ServiceWrapper<WeblinkCategoryLocalService> {
	public WeblinkCategoryLocalServiceWrapper(
		WeblinkCategoryLocalService weblinkCategoryLocalService) {
		_weblinkCategoryLocalService = weblinkCategoryLocalService;
	}

	/**
	* Adds the weblink category to the database. Also notifies the appropriate model listeners.
	*
	* @param weblinkCategory the weblink category
	* @return the weblink category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory addWeblinkCategory(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.addWeblinkCategory(weblinkCategory);
	}

	/**
	* Creates a new weblink category with the primary key. Does not add the weblink category to the database.
	*
	* @param categoryId the primary key for the new weblink category
	* @return the new weblink category
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory createWeblinkCategory(
		long categoryId) {
		return _weblinkCategoryLocalService.createWeblinkCategory(categoryId);
	}

	/**
	* Deletes the weblink category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the weblink category
	* @return the weblink category that was removed
	* @throws PortalException if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory deleteWeblinkCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.deleteWeblinkCategory(categoryId);
	}

	/**
	* Deletes the weblink category from the database. Also notifies the appropriate model listeners.
	*
	* @param weblinkCategory the weblink category
	* @return the weblink category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory deleteWeblinkCategory(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.deleteWeblinkCategory(weblinkCategory);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _weblinkCategoryLocalService.dynamicQuery();
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
		return _weblinkCategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _weblinkCategoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _weblinkCategoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _weblinkCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.weblinks.model.WeblinkCategory fetchWeblinkCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.fetchWeblinkCategory(categoryId);
	}

	/**
	* Returns the weblink category with the primary key.
	*
	* @param categoryId the primary key of the weblink category
	* @return the weblink category
	* @throws PortalException if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory getWeblinkCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.getWeblinkCategory(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the weblink categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @return the range of weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> getWeblinkCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.getWeblinkCategories(start, end);
	}

	/**
	* Returns the number of weblink categories.
	*
	* @return the number of weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public int getWeblinkCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.getWeblinkCategoriesCount();
	}

	/**
	* Updates the weblink category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param weblinkCategory the weblink category
	* @return the weblink category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory updateWeblinkCategory(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.updateWeblinkCategory(weblinkCategory);
	}

	/**
	* Updates the weblink category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param weblinkCategory the weblink category
	* @param merge whether to merge the weblink category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the weblink category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory updateWeblinkCategory(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.updateWeblinkCategory(weblinkCategory,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _weblinkCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_weblinkCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _weblinkCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.countByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return _weblinkCategoryLocalService.findByKeyword(groupId, keyword,
			start, end);
	}

	public com.portal_egov.portlet.weblinks.model.WeblinkCategory addCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, java.lang.String categoryDesc,
		long categoryIconId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.addCategory(companyId, groupId,
			userId, userName, categoryName, categoryDesc, categoryIconId,
			serviceContext);
	}

	public com.portal_egov.portlet.weblinks.model.WeblinkCategory updateCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		long categoryId, java.lang.String categoryName,
		java.lang.String categoryDesc, long categoryIconId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategoryLocalService.updateCategory(companyId, groupId,
			userId, userName, categoryId, categoryName, categoryDesc,
			categoryIconId);
	}

	public void deleteCategory(long categoryId, boolean deleteWeblinks)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_weblinkCategoryLocalService.deleteCategory(categoryId, deleteWeblinks);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WeblinkCategoryLocalService getWrappedWeblinkCategoryLocalService() {
		return _weblinkCategoryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWeblinkCategoryLocalService(
		WeblinkCategoryLocalService weblinkCategoryLocalService) {
		_weblinkCategoryLocalService = weblinkCategoryLocalService;
	}

	public WeblinkCategoryLocalService getWrappedService() {
		return _weblinkCategoryLocalService;
	}

	public void setWrappedService(
		WeblinkCategoryLocalService weblinkCategoryLocalService) {
		_weblinkCategoryLocalService = weblinkCategoryLocalService;
	}

	private WeblinkCategoryLocalService _weblinkCategoryLocalService;
}