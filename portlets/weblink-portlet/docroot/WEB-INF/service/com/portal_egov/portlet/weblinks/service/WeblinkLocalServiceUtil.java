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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the weblink local service. This utility wraps {@link com.portal_egov.portlet.weblinks.service.impl.WeblinkLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see WeblinkLocalService
 * @see com.portal_egov.portlet.weblinks.service.base.WeblinkLocalServiceBaseImpl
 * @see com.portal_egov.portlet.weblinks.service.impl.WeblinkLocalServiceImpl
 * @generated
 */
public class WeblinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.weblinks.service.impl.WeblinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the weblink to the database. Also notifies the appropriate model listeners.
	*
	* @param weblink the weblink
	* @return the weblink that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink addWeblink(
		com.portal_egov.portlet.weblinks.model.Weblink weblink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWeblink(weblink);
	}

	/**
	* Creates a new weblink with the primary key. Does not add the weblink to the database.
	*
	* @param weblinkId the primary key for the new weblink
	* @return the new weblink
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink createWeblink(
		long weblinkId) {
		return getService().createWeblink(weblinkId);
	}

	/**
	* Deletes the weblink with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink that was removed
	* @throws PortalException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink deleteWeblink(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWeblink(weblinkId);
	}

	/**
	* Deletes the weblink from the database. Also notifies the appropriate model listeners.
	*
	* @param weblink the weblink
	* @return the weblink that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink deleteWeblink(
		com.portal_egov.portlet.weblinks.model.Weblink weblink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWeblink(weblink);
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

	public static com.portal_egov.portlet.weblinks.model.Weblink fetchWeblink(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWeblink(weblinkId);
	}

	/**
	* Returns the weblink with the primary key.
	*
	* @param weblinkId the primary key of the weblink
	* @return the weblink
	* @throws PortalException if a weblink with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink getWeblink(
		long weblinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWeblink(weblinkId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the weblinks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of weblinks
	* @param end the upper bound of the range of weblinks (not inclusive)
	* @return the range of weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> getWeblinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWeblinks(start, end);
	}

	/**
	* Returns the number of weblinks.
	*
	* @return the number of weblinks
	* @throws SystemException if a system exception occurred
	*/
	public static int getWeblinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWeblinksCount();
	}

	/**
	* Updates the weblink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param weblink the weblink
	* @return the weblink that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink updateWeblink(
		com.portal_egov.portlet.weblinks.model.Weblink weblink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWeblink(weblink);
	}

	/**
	* Updates the weblink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param weblink the weblink
	* @param merge whether to merge the weblink with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the weblink that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.weblinks.model.Weblink updateWeblink(
		com.portal_egov.portlet.weblinks.model.Weblink weblink, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWeblink(weblink, merge);
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

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategory(categoryId);
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(categoryId);
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(categoryId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}

	public static com.portal_egov.portlet.weblinks.model.Weblink addWeblink(
		long companyId, long groupId, long userId, java.lang.String userName,
		long weblinkCategoryId, java.lang.String weblinkName,
		java.lang.String weblinkDesc, java.lang.String weblinkURL,
		long weblinkIconId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addWeblink(companyId, groupId, userId, userName,
			weblinkCategoryId, weblinkName, weblinkDesc, weblinkURL,
			weblinkIconId, serviceContext);
	}

	public static com.portal_egov.portlet.weblinks.model.Weblink updateWeblink(
		long companyId, long groupId, long userId, java.lang.String userName,
		long weblinkId, long weblinkCategoryId, java.lang.String weblinkName,
		java.lang.String weblinkDesc, java.lang.String weblinkURL,
		long weblinkIconId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateWeblink(companyId, groupId, userId, userName,
			weblinkId, weblinkCategoryId, weblinkName, weblinkDesc, weblinkURL,
			weblinkIconId);
	}

	public static void clearService() {
		_service = null;
	}

	public static WeblinkLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WeblinkLocalService.class.getName());

			if (invokableLocalService instanceof WeblinkLocalService) {
				_service = (WeblinkLocalService)invokableLocalService;
			}
			else {
				_service = new WeblinkLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WeblinkLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(WeblinkLocalService service) {
	}

	private static WeblinkLocalService _service;
}