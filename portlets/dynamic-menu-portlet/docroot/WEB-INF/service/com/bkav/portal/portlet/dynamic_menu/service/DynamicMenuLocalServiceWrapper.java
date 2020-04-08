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

package com.bkav.portal.portlet.dynamic_menu.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DynamicMenuLocalService}.
 * </p>
 *
 * @author    hungdx
 * @see       DynamicMenuLocalService
 * @generated
 */
public class DynamicMenuLocalServiceWrapper implements DynamicMenuLocalService,
	ServiceWrapper<DynamicMenuLocalService> {
	public DynamicMenuLocalServiceWrapper(
		DynamicMenuLocalService dynamicMenuLocalService) {
		_dynamicMenuLocalService = dynamicMenuLocalService;
	}

	/**
	* Adds the dynamic menu to the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenu the dynamic menu
	* @return the dynamic menu that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu addDynamicMenu(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.addDynamicMenu(dynamicMenu);
	}

	/**
	* Creates a new dynamic menu with the primary key. Does not add the dynamic menu to the database.
	*
	* @param menuId the primary key for the new dynamic menu
	* @return the new dynamic menu
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu createDynamicMenu(
		long menuId) {
		return _dynamicMenuLocalService.createDynamicMenu(menuId);
	}

	/**
	* Deletes the dynamic menu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu that was removed
	* @throws PortalException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu deleteDynamicMenu(
		long menuId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.deleteDynamicMenu(menuId);
	}

	/**
	* Deletes the dynamic menu from the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenu the dynamic menu
	* @return the dynamic menu that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu deleteDynamicMenu(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.deleteDynamicMenu(dynamicMenu);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dynamicMenuLocalService.dynamicQuery();
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
		return _dynamicMenuLocalService.dynamicQuery(dynamicQuery);
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
		return _dynamicMenuLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _dynamicMenuLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dynamicMenuLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu fetchDynamicMenu(
		long menuId) throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.fetchDynamicMenu(menuId);
	}

	/**
	* Returns the dynamic menu with the primary key.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu
	* @throws PortalException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu getDynamicMenu(
		long menuId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.getDynamicMenu(menuId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dynamic menus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dynamic menus
	* @param end the upper bound of the range of dynamic menus (not inclusive)
	* @return the range of dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> getDynamicMenus(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.getDynamicMenus(start, end);
	}

	/**
	* Returns the number of dynamic menus.
	*
	* @return the number of dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public int getDynamicMenusCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.getDynamicMenusCount();
	}

	/**
	* Updates the dynamic menu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenu the dynamic menu
	* @return the dynamic menu that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu updateDynamicMenu(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.updateDynamicMenu(dynamicMenu);
	}

	/**
	* Updates the dynamic menu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenu the dynamic menu
	* @param merge whether to merge the dynamic menu with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dynamic menu that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu updateDynamicMenu(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.updateDynamicMenu(dynamicMenu, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dynamicMenuLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dynamicMenuLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dynamicMenuLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.findByGroup(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.findByKeyword(groupId, keyword, start,
			end);
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu addMenu(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.addMenu(companyId, groupId, userId,
			userName, name, description, serviceContext);
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu updateMenu(
		long companyId, long groupId, long userId, java.lang.String userName,
		long menuId, java.lang.String name, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuLocalService.updateMenu(companyId, groupId, userId,
			userName, menuId, name, description, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DynamicMenuLocalService getWrappedDynamicMenuLocalService() {
		return _dynamicMenuLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDynamicMenuLocalService(
		DynamicMenuLocalService dynamicMenuLocalService) {
		_dynamicMenuLocalService = dynamicMenuLocalService;
	}

	public DynamicMenuLocalService getWrappedService() {
		return _dynamicMenuLocalService;
	}

	public void setWrappedService(
		DynamicMenuLocalService dynamicMenuLocalService) {
		_dynamicMenuLocalService = dynamicMenuLocalService;
	}

	private DynamicMenuLocalService _dynamicMenuLocalService;
}