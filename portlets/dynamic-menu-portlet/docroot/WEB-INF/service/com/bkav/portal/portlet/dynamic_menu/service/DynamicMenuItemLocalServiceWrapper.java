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
 * This class is a wrapper for {@link DynamicMenuItemLocalService}.
 * </p>
 *
 * @author    hungdx
 * @see       DynamicMenuItemLocalService
 * @generated
 */
public class DynamicMenuItemLocalServiceWrapper
	implements DynamicMenuItemLocalService,
		ServiceWrapper<DynamicMenuItemLocalService> {
	public DynamicMenuItemLocalServiceWrapper(
		DynamicMenuItemLocalService dynamicMenuItemLocalService) {
		_dynamicMenuItemLocalService = dynamicMenuItemLocalService;
	}

	/**
	* Adds the dynamic menu item to the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @return the dynamic menu item that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem addDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.addDynamicMenuItem(dynamicMenuItem);
	}

	/**
	* Creates a new dynamic menu item with the primary key. Does not add the dynamic menu item to the database.
	*
	* @param itemId the primary key for the new dynamic menu item
	* @return the new dynamic menu item
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem createDynamicMenuItem(
		long itemId) {
		return _dynamicMenuItemLocalService.createDynamicMenuItem(itemId);
	}

	/**
	* Deletes the dynamic menu item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item that was removed
	* @throws PortalException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem deleteDynamicMenuItem(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.deleteDynamicMenuItem(itemId);
	}

	/**
	* Deletes the dynamic menu item from the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @return the dynamic menu item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem deleteDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.deleteDynamicMenuItem(dynamicMenuItem);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dynamicMenuItemLocalService.dynamicQuery();
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
		return _dynamicMenuItemLocalService.dynamicQuery(dynamicQuery);
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
		return _dynamicMenuItemLocalService.dynamicQuery(dynamicQuery, start,
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
		return _dynamicMenuItemLocalService.dynamicQuery(dynamicQuery, start,
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
		return _dynamicMenuItemLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchDynamicMenuItem(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.fetchDynamicMenuItem(itemId);
	}

	/**
	* Returns the dynamic menu item with the primary key.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item
	* @throws PortalException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem getDynamicMenuItem(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.getDynamicMenuItem(itemId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dynamic menu items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> getDynamicMenuItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.getDynamicMenuItems(start, end);
	}

	/**
	* Returns the number of dynamic menu items.
	*
	* @return the number of dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public int getDynamicMenuItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.getDynamicMenuItemsCount();
	}

	/**
	* Updates the dynamic menu item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @return the dynamic menu item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.updateDynamicMenuItem(dynamicMenuItem);
	}

	/**
	* Updates the dynamic menu item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @param merge whether to merge the dynamic menu item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dynamic menu item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.updateDynamicMenuItem(dynamicMenuItem,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dynamicMenuItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dynamicMenuItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dynamicMenuItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.findByGroup(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.findByParent(groupId, parentId);
	}

	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.findByMenu(groupId, menuId);
	}

	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.findByG_M_P(groupId, menuId,
			parentId);
	}

	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterMenuItemList(
		long groupId, long filterItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.filterMenuItemList(groupId,
			filterItemId);
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem addItem(
		long companyId, long groupId, long userId, java.lang.String userName,
		long menuId, long parentId, java.lang.String name,
		java.lang.String url, java.lang.String urlType, int position,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.addItem(companyId, groupId, userId,
			userName, menuId, parentId, name, url, urlType, position,
			serviceContext);
	}

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateItem(
		long companyId, long groupId, long userId, java.lang.String userName,
		long itemId, long menuId, long parentId, java.lang.String name,
		java.lang.String url, java.lang.String urlType, int position,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dynamicMenuItemLocalService.updateItem(companyId, groupId,
			userId, userName, itemId, menuId, parentId, name, url, urlType,
			position, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DynamicMenuItemLocalService getWrappedDynamicMenuItemLocalService() {
		return _dynamicMenuItemLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDynamicMenuItemLocalService(
		DynamicMenuItemLocalService dynamicMenuItemLocalService) {
		_dynamicMenuItemLocalService = dynamicMenuItemLocalService;
	}

	public DynamicMenuItemLocalService getWrappedService() {
		return _dynamicMenuItemLocalService;
	}

	public void setWrappedService(
		DynamicMenuItemLocalService dynamicMenuItemLocalService) {
		_dynamicMenuItemLocalService = dynamicMenuItemLocalService;
	}

	private DynamicMenuItemLocalService _dynamicMenuItemLocalService;
}