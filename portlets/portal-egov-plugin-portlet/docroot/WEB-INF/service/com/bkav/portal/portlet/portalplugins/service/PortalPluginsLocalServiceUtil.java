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

package com.bkav.portal.portlet.portalplugins.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the portal plugins local service. This utility wraps {@link com.bkav.portal.portlet.portalplugins.service.impl.PortalPluginsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhBDb
 * @see PortalPluginsLocalService
 * @see com.bkav.portal.portlet.portalplugins.service.base.PortalPluginsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.portalplugins.service.impl.PortalPluginsLocalServiceImpl
 * @generated
 */
public class PortalPluginsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.portalplugins.service.impl.PortalPluginsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the portal plugins to the database. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @return the portal plugins that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins addPortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPortalPlugins(portalPlugins);
	}

	/**
	* Creates a new portal plugins with the primary key. Does not add the portal plugins to the database.
	*
	* @param pluginId the primary key for the new portal plugins
	* @return the new portal plugins
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins createPortalPlugins(
		long pluginId) {
		return getService().createPortalPlugins(pluginId);
	}

	/**
	* Deletes the portal plugins with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins that was removed
	* @throws PortalException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins deletePortalPlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortalPlugins(pluginId);
	}

	/**
	* Deletes the portal plugins from the database. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @return the portal plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins deletePortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortalPlugins(portalPlugins);
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

	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchPortalPlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPortalPlugins(pluginId);
	}

	/**
	* Returns the portal plugins with the primary key.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins
	* @throws PortalException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins getPortalPlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortalPlugins(pluginId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the portal pluginses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @return the range of portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> getPortalPluginses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortalPluginses(start, end);
	}

	/**
	* Returns the number of portal pluginses.
	*
	* @return the number of portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int getPortalPluginsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortalPluginsesCount();
	}

	/**
	* Updates the portal plugins in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @return the portal plugins that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins updatePortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortalPlugins(portalPlugins);
	}

	/**
	* Updates the portal plugins in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @param merge whether to merge the portal plugins with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portal plugins that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins updatePortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortalPlugins(portalPlugins, merge);
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

	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId);
	}

	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPluginCode(pluginCode);
	}

	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByEportalId(
		long ePortalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEportalId(ePortalId);
	}

	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPluginCodeAndVersion(
		long groupId, java.lang.String pluginCode, long pluginVersion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByPluginCodeAndVersion(groupId, pluginCode,
			pluginVersion);
	}

	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findPortalPluginsByFilter(
		long groupId, java.lang.String pluginName, java.lang.String pluginCode,
		int pluginType, long ePortalId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findPortalPluginsByFilter(groupId, pluginName, pluginCode,
			pluginType, ePortalId, start, end);
	}

	public static void addPortalPlugin(long groupId, long companyId,
		long userId, java.lang.String userName, java.lang.String pluginName,
		java.lang.String pluginCode, double pluginVersion, int pluginType,
		long ePortalId, int isImportant, java.lang.String pluginDescription,
		java.lang.String pluginUpdateInfo, double pluginSize, long warFileId,
		long signFileId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addPortalPlugin(groupId, companyId, userId, userName, pluginName,
			pluginCode, pluginVersion, pluginType, ePortalId, isImportant,
			pluginDescription, pluginUpdateInfo, pluginSize, warFileId,
			signFileId, serviceContext);
	}

	public static void updatePortalPlugin(long pluginId,
		java.lang.String pluginName, java.lang.String pluginCode,
		double pluginVersion, int pluginType, long ePortalId, int isImportant,
		java.lang.String pluginDescription, java.lang.String pluginUpdateInfo,
		double pluginSize, long warFileId, long signFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updatePortalPlugin(pluginId, pluginName, pluginCode,
			pluginVersion, pluginType, ePortalId, isImportant,
			pluginDescription, pluginUpdateInfo, pluginSize, warFileId,
			signFileId);
	}

	public static void deletePortalPlugin(long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deletePortalPlugin(pluginId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PortalPluginsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PortalPluginsLocalService.class.getName());

			if (invokableLocalService instanceof PortalPluginsLocalService) {
				_service = (PortalPluginsLocalService)invokableLocalService;
			}
			else {
				_service = new PortalPluginsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PortalPluginsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PortalPluginsLocalService service) {
	}

	private static PortalPluginsLocalService _service;
}