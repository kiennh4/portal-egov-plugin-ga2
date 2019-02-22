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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the dynamic menu item local service. This utility wraps {@link com.bkav.portal.portlet.dynamic_menu.service.impl.DynamicMenuItemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuItemLocalService
 * @see com.bkav.portal.portlet.dynamic_menu.service.base.DynamicMenuItemLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.dynamic_menu.service.impl.DynamicMenuItemLocalServiceImpl
 * @generated
 */
public class DynamicMenuItemLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.dynamic_menu.service.impl.DynamicMenuItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dynamic menu item to the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @return the dynamic menu item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem addDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDynamicMenuItem(dynamicMenuItem);
	}

	/**
	* Creates a new dynamic menu item with the primary key. Does not add the dynamic menu item to the database.
	*
	* @param itemId the primary key for the new dynamic menu item
	* @return the new dynamic menu item
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem createDynamicMenuItem(
		long itemId) {
		return getService().createDynamicMenuItem(itemId);
	}

	/**
	* Deletes the dynamic menu item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item that was removed
	* @throws PortalException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem deleteDynamicMenuItem(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDynamicMenuItem(itemId);
	}

	/**
	* Deletes the dynamic menu item from the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @return the dynamic menu item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem deleteDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDynamicMenuItem(dynamicMenuItem);
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

	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchDynamicMenuItem(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDynamicMenuItem(itemId);
	}

	/**
	* Returns the dynamic menu item with the primary key.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item
	* @throws PortalException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem getDynamicMenuItem(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDynamicMenuItem(itemId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> getDynamicMenuItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDynamicMenuItems(start, end);
	}

	/**
	* Returns the number of dynamic menu items.
	*
	* @return the number of dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static int getDynamicMenuItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDynamicMenuItemsCount();
	}

	/**
	* Updates the dynamic menu item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @return the dynamic menu item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDynamicMenuItem(dynamicMenuItem);
	}

	/**
	* Updates the dynamic menu item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicMenuItem the dynamic menu item
	* @param merge whether to merge the dynamic menu item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dynamic menu item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateDynamicMenuItem(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDynamicMenuItem(dynamicMenuItem, merge);
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

	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParent(groupId, parentId);
	}

	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByMenu(groupId, menuId);
	}

	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByG_M_P(groupId, menuId, parentId);
	}

	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterMenuItemList(
		long groupId, long filterItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().filterMenuItemList(groupId, filterItemId);
	}

	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem addItem(
		long companyId, long groupId, long userId, java.lang.String userName,
		long menuId, long parentId, java.lang.String name,
		java.lang.String url, java.lang.String urlType, int position,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addItem(companyId, groupId, userId, userName, menuId,
			parentId, name, url, urlType, position, serviceContext);
	}

	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateItem(
		long companyId, long groupId, long userId, java.lang.String userName,
		long itemId, long menuId, long parentId, java.lang.String name,
		java.lang.String url, java.lang.String urlType, int position,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateItem(companyId, groupId, userId, userName, itemId,
			menuId, parentId, name, url, urlType, position, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static DynamicMenuItemLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DynamicMenuItemLocalService.class.getName());

			if (invokableLocalService instanceof DynamicMenuItemLocalService) {
				_service = (DynamicMenuItemLocalService)invokableLocalService;
			}
			else {
				_service = new DynamicMenuItemLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DynamicMenuItemLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(DynamicMenuItemLocalService service) {
	}

	private static DynamicMenuItemLocalService _service;
}