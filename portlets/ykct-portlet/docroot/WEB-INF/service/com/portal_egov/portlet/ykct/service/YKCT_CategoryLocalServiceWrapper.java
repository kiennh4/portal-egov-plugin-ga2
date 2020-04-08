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

package com.portal_egov.portlet.ykct.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link YKCT_CategoryLocalService}.
 * </p>
 *
 * @author    DucDVd
 * @see       YKCT_CategoryLocalService
 * @generated
 */
public class YKCT_CategoryLocalServiceWrapper
	implements YKCT_CategoryLocalService,
		ServiceWrapper<YKCT_CategoryLocalService> {
	public YKCT_CategoryLocalServiceWrapper(
		YKCT_CategoryLocalService ykct_CategoryLocalService) {
		_ykct_CategoryLocalService = ykct_CategoryLocalService;
	}

	/**
	* Adds the y k c t_ category to the database. Also notifies the appropriate model listeners.
	*
	* @param ykct_Category the y k c t_ category
	* @return the y k c t_ category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category addYKCT_Category(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.addYKCT_Category(ykct_Category);
	}

	/**
	* Creates a new y k c t_ category with the primary key. Does not add the y k c t_ category to the database.
	*
	* @param categoryId the primary key for the new y k c t_ category
	* @return the new y k c t_ category
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category createYKCT_Category(
		long categoryId) {
		return _ykct_CategoryLocalService.createYKCT_Category(categoryId);
	}

	/**
	* Deletes the y k c t_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category that was removed
	* @throws PortalException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category deleteYKCT_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.deleteYKCT_Category(categoryId);
	}

	/**
	* Deletes the y k c t_ category from the database. Also notifies the appropriate model listeners.
	*
	* @param ykct_Category the y k c t_ category
	* @return the y k c t_ category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category deleteYKCT_Category(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.deleteYKCT_Category(ykct_Category);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ykct_CategoryLocalService.dynamicQuery();
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
		return _ykct_CategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _ykct_CategoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _ykct_CategoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _ykct_CategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.ykct.model.YKCT_Category fetchYKCT_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.fetchYKCT_Category(categoryId);
	}

	/**
	* Returns the y k c t_ category with the primary key.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category
	* @throws PortalException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category getYKCT_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.getYKCT_Category(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the y k c t_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ categories
	* @param end the upper bound of the range of y k c t_ categories (not inclusive)
	* @return the range of y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> getYKCT_Categories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.getYKCT_Categories(start, end);
	}

	/**
	* Returns the number of y k c t_ categories.
	*
	* @return the number of y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int getYKCT_CategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.getYKCT_CategoriesCount();
	}

	/**
	* Updates the y k c t_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ykct_Category the y k c t_ category
	* @return the y k c t_ category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category updateYKCT_Category(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.updateYKCT_Category(ykct_Category);
	}

	/**
	* Updates the y k c t_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ykct_Category the y k c t_ category
	* @param merge whether to merge the y k c t_ category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the y k c t_ category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category updateYKCT_Category(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.updateYKCT_Category(ykct_Category,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ykct_CategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ykct_CategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ykct_CategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.countByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return _ykct_CategoryLocalService.findByKeyword(groupId, keyword,
			start, end);
	}

	public com.portal_egov.portlet.ykct.model.YKCT_Category addCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, java.lang.String categoryDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.addCategory(companyId, groupId,
			userId, userName, categoryName, categoryDesc, serviceContext);
	}

	public com.portal_egov.portlet.ykct.model.YKCT_Category updateCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		long categoryId, java.lang.String categoryName,
		java.lang.String categoryDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ykct_CategoryLocalService.updateCategory(companyId, groupId,
			userId, userName, categoryId, categoryName, categoryDesc);
	}

	public void deleteCategory(long categoryId, boolean deleteYKCTEntrys)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ykct_CategoryLocalService.deleteCategory(categoryId, deleteYKCTEntrys);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public YKCT_CategoryLocalService getWrappedYKCT_CategoryLocalService() {
		return _ykct_CategoryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedYKCT_CategoryLocalService(
		YKCT_CategoryLocalService ykct_CategoryLocalService) {
		_ykct_CategoryLocalService = ykct_CategoryLocalService;
	}

	public YKCT_CategoryLocalService getWrappedService() {
		return _ykct_CategoryLocalService;
	}

	public void setWrappedService(
		YKCT_CategoryLocalService ykct_CategoryLocalService) {
		_ykct_CategoryLocalService = ykct_CategoryLocalService;
	}

	private YKCT_CategoryLocalService _ykct_CategoryLocalService;
}