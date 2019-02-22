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

package com.bkav.portal.portlet.autoupdate.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the update plugins local service. This utility wraps {@link com.bkav.portal.portlet.autoupdate.service.impl.UpdatePluginsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see UpdatePluginsLocalService
 * @see com.bkav.portal.portlet.autoupdate.service.base.UpdatePluginsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.autoupdate.service.impl.UpdatePluginsLocalServiceImpl
 * @generated
 */
public class UpdatePluginsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.autoupdate.service.impl.UpdatePluginsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the update plugins to the database. Also notifies the appropriate model listeners.
	*
	* @param updatePlugins the update plugins
	* @return the update plugins that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins addUpdatePlugins(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUpdatePlugins(updatePlugins);
	}

	/**
	* Creates a new update plugins with the primary key. Does not add the update plugins to the database.
	*
	* @param pluginId the primary key for the new update plugins
	* @return the new update plugins
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins createUpdatePlugins(
		long pluginId) {
		return getService().createUpdatePlugins(pluginId);
	}

	/**
	* Deletes the update plugins with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins that was removed
	* @throws PortalException if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins deleteUpdatePlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUpdatePlugins(pluginId);
	}

	/**
	* Deletes the update plugins from the database. Also notifies the appropriate model listeners.
	*
	* @param updatePlugins the update plugins
	* @return the update plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins deleteUpdatePlugins(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUpdatePlugins(updatePlugins);
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

	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchUpdatePlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUpdatePlugins(pluginId);
	}

	/**
	* Returns the update plugins with the primary key.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins
	* @throws PortalException if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins getUpdatePlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUpdatePlugins(pluginId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the update pluginses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update pluginses
	* @param end the upper bound of the range of update pluginses (not inclusive)
	* @return the range of update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> getUpdatePluginses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUpdatePluginses(start, end);
	}

	/**
	* Returns the number of update pluginses.
	*
	* @return the number of update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int getUpdatePluginsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUpdatePluginsesCount();
	}

	/**
	* Updates the update plugins in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param updatePlugins the update plugins
	* @return the update plugins that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updateUpdatePlugins(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUpdatePlugins(updatePlugins);
	}

	/**
	* Updates the update plugins in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param updatePlugins the update plugins
	* @param merge whether to merge the update plugins with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the update plugins that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updateUpdatePlugins(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUpdatePlugins(updatePlugins, merge);
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

	public static java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> findAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPluginCode(pluginCode);
	}

	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByPluginCode(pluginCode);
	}

	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPluginCodeAndVersion(
		java.lang.String pluginCode, double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPluginCodeAndVersion(pluginCode, version);
	}

	public static void addPlugin(java.lang.String pluginName,
		java.lang.String pluginCode, long serverCompanyId,
		double currentVersion, double currentSize, int pluginType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addPlugin(pluginName, pluginCode, serverCompanyId, currentVersion,
			currentSize, pluginType);
	}

	public static void updatePlugin(long pluginId, java.lang.String pluginName,
		long serverCompanyId, double currentVersion, double currentSize,
		int pluginType, java.lang.String pluginCode,
		java.lang.String previousVersions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updatePlugin(pluginId, pluginName, serverCompanyId,
			currentVersion, currentSize, pluginType, pluginCode,
			previousVersions);
	}

	public static void updateVersioPlugin(long pluginId, double currentVerion,
		java.lang.String previousVerion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateVersioPlugin(pluginId, currentVerion, previousVerion);
	}

	public static void clearService() {
		_service = null;
	}

	public static UpdatePluginsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UpdatePluginsLocalService.class.getName());

			if (invokableLocalService instanceof UpdatePluginsLocalService) {
				_service = (UpdatePluginsLocalService)invokableLocalService;
			}
			else {
				_service = new UpdatePluginsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UpdatePluginsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(UpdatePluginsLocalService service) {
	}

	private static UpdatePluginsLocalService _service;
}