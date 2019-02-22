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

package com.portal_egov.portlet.conversation.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the c o_ category local service. This utility wraps {@link com.portal_egov.portlet.conversation.service.impl.CO_CategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see CO_CategoryLocalService
 * @see com.portal_egov.portlet.conversation.service.base.CO_CategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.impl.CO_CategoryLocalServiceImpl
 * @generated
 */
public class CO_CategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.conversation.service.impl.CO_CategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the c o_ category to the database. Also notifies the appropriate model listeners.
	*
	* @param co_Category the c o_ category
	* @return the c o_ category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category addCO_Category(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCO_Category(co_Category);
	}

	/**
	* Creates a new c o_ category with the primary key. Does not add the c o_ category to the database.
	*
	* @param categoryId the primary key for the new c o_ category
	* @return the new c o_ category
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category createCO_Category(
		long categoryId) {
		return getService().createCO_Category(categoryId);
	}

	/**
	* Deletes the c o_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category that was removed
	* @throws PortalException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category deleteCO_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCO_Category(categoryId);
	}

	/**
	* Deletes the c o_ category from the database. Also notifies the appropriate model listeners.
	*
	* @param co_Category the c o_ category
	* @return the c o_ category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category deleteCO_Category(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCO_Category(co_Category);
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

	public static com.portal_egov.portlet.conversation.model.CO_Category fetchCO_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCO_Category(categoryId);
	}

	/**
	* Returns the c o_ category with the primary key.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category
	* @throws PortalException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category getCO_Category(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_Category(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the c o_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> getCO_Categories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_Categories(start, end);
	}

	/**
	* Returns the number of c o_ categories.
	*
	* @return the number of c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getCO_CategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_CategoriesCount();
	}

	/**
	* Updates the c o_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Category the c o_ category
	* @return the c o_ category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category updateCO_Category(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCO_Category(co_Category);
	}

	/**
	* Updates the c o_ category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Category the c o_ category
	* @param merge whether to merge the c o_ category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c o_ category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category updateCO_Category(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCO_Category(co_Category, merge);
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

	public static int countByParentAndCompany(long companyId,
		long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByParentAndCompany(companyId, parentCategoryId);
	}

	public static int countByParentAndGroup(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByParentAndGroup(groupId, parentCategoryId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParentAndCompany(companyId, parentCategoryId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentAndCompany(companyId, parentCategoryId, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParentAndGroup(groupId, parentCategoryId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentAndGroup(groupId, parentCategoryId, start, end);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Category addCOCategory(
		long companyId, long groupId, long userId, long parentCategoryId,
		java.lang.String categoryName, java.lang.String categoryDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCOCategory(companyId, groupId, userId, parentCategoryId,
			categoryName, categoryDesc, serviceContext);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Category updateCOCategory(
		long categoryId, long companyId, long groupId, long userId,
		long parentCategoryId, java.lang.String categoryName,
		java.lang.String categoryDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCOCategory(categoryId, companyId, groupId, userId,
			parentCategoryId, categoryName, categoryDesc);
	}

	public static void deleteCOCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCOCategory(categoryId);
	}

	public static void incrementThreadCount(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().incrementThreadCount(categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CO_CategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CO_CategoryLocalService.class.getName());

			if (invokableLocalService instanceof CO_CategoryLocalService) {
				_service = (CO_CategoryLocalService)invokableLocalService;
			}
			else {
				_service = new CO_CategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CO_CategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CO_CategoryLocalService service) {
	}

	private static CO_CategoryLocalService _service;
}