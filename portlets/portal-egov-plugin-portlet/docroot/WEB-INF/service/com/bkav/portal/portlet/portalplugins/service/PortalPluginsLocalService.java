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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the portal plugins local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhBDb
 * @see PortalPluginsLocalServiceUtil
 * @see com.bkav.portal.portlet.portalplugins.service.base.PortalPluginsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.portalplugins.service.impl.PortalPluginsLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PortalPluginsLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortalPluginsLocalServiceUtil} to access the portal plugins local service. Add custom service methods to {@link com.bkav.portal.portlet.portalplugins.service.impl.PortalPluginsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the portal plugins to the database. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @return the portal plugins that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins addPortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new portal plugins with the primary key. Does not add the portal plugins to the database.
	*
	* @param pluginId the primary key for the new portal plugins
	* @return the new portal plugins
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins createPortalPlugins(
		long pluginId);

	/**
	* Deletes the portal plugins with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins that was removed
	* @throws PortalException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins deletePortalPlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the portal plugins from the database. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @return the portal plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins deletePortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchPortalPlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins with the primary key.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins
	* @throws PortalException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins getPortalPlugins(
		long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> getPortalPluginses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses.
	*
	* @return the number of portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPortalPluginsesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the portal plugins in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @return the portal plugins that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins updatePortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the portal plugins in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portalPlugins the portal plugins
	* @param merge whether to merge the portal plugins with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portal plugins that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins updatePortalPlugins(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByEportalId(
		long ePortalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPluginCodeAndVersion(
		long groupId, java.lang.String pluginCode, long pluginVersion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findPortalPluginsByFilter(
		long groupId, java.lang.String pluginName, java.lang.String pluginCode,
		int pluginType, long ePortalId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void addPortalPlugin(long groupId, long companyId, long userId,
		java.lang.String userName, java.lang.String pluginName,
		java.lang.String pluginCode, double pluginVersion, int pluginType,
		long ePortalId, int isImportant, java.lang.String pluginDescription,
		java.lang.String pluginUpdateInfo, double pluginSize, long warFileId,
		long signFileId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updatePortalPlugin(long pluginId, java.lang.String pluginName,
		java.lang.String pluginCode, double pluginVersion, int pluginType,
		long ePortalId, int isImportant, java.lang.String pluginDescription,
		java.lang.String pluginUpdateInfo, double pluginSize, long warFileId,
		long signFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deletePortalPlugin(long pluginId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}