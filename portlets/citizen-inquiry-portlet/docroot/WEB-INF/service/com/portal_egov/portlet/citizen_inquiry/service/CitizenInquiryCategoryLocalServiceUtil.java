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

package com.portal_egov.portlet.citizen_inquiry.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the citizen inquiry category local service. This utility wraps {@link com.portal_egov.portlet.citizen_inquiry.service.impl.CitizenInquiryCategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see CitizenInquiryCategoryLocalService
 * @see com.portal_egov.portlet.citizen_inquiry.service.base.CitizenInquiryCategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.citizen_inquiry.service.impl.CitizenInquiryCategoryLocalServiceImpl
 * @generated
 */
public class CitizenInquiryCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.citizen_inquiry.service.impl.CitizenInquiryCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the citizen inquiry category to the database. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiryCategory the citizen inquiry category
	* @return the citizen inquiry category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory addCitizenInquiryCategory(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCitizenInquiryCategory(citizenInquiryCategory);
	}

	/**
	* Creates a new citizen inquiry category with the primary key. Does not add the citizen inquiry category to the database.
	*
	* @param categoryId the primary key for the new citizen inquiry category
	* @return the new citizen inquiry category
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory createCitizenInquiryCategory(
		long categoryId) {
		return getService().createCitizenInquiryCategory(categoryId);
	}

	/**
	* Deletes the citizen inquiry category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category that was removed
	* @throws PortalException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory deleteCitizenInquiryCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCitizenInquiryCategory(categoryId);
	}

	/**
	* Deletes the citizen inquiry category from the database. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiryCategory the citizen inquiry category
	* @return the citizen inquiry category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory deleteCitizenInquiryCategory(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCitizenInquiryCategory(citizenInquiryCategory);
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

	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchCitizenInquiryCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCitizenInquiryCategory(categoryId);
	}

	/**
	* Returns the citizen inquiry category with the primary key.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category
	* @throws PortalException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory getCitizenInquiryCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCitizenInquiryCategory(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the citizen inquiry categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @return the range of citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> getCitizenInquiryCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCitizenInquiryCategories(start, end);
	}

	/**
	* Returns the number of citizen inquiry categories.
	*
	* @return the number of citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getCitizenInquiryCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCitizenInquiryCategoriesCount();
	}

	/**
	* Updates the citizen inquiry category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiryCategory the citizen inquiry category
	* @return the citizen inquiry category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory updateCitizenInquiryCategory(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCitizenInquiryCategory(citizenInquiryCategory);
	}

	/**
	* Updates the citizen inquiry category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param citizenInquiryCategory the citizen inquiry category
	* @param merge whether to merge the citizen inquiry category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the citizen inquiry category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory updateCitizenInquiryCategory(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCitizenInquiryCategory(citizenInquiryCategory, merge);
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

	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> getGroupCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupCategories(groupId);
	}

	public static void addInquiryCategory(long companyId, long groupId,
		long userId, java.lang.String userName, java.lang.String categoryName,
		java.lang.String categoryDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addInquiryCategory(companyId, groupId, userId, userName,
			categoryName, categoryDesc, serviceContext);
	}

	public static void updateInquiryCategory(long categoryId, long companyId,
		long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName, java.lang.String categoryDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateInquiryCategory(categoryId, companyId, groupId, userId,
			userName, categoryName, categoryDesc, serviceContext);
	}

	public static void deleteInquiryCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteInquiryCategory(categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CitizenInquiryCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CitizenInquiryCategoryLocalService.class.getName());

			if (invokableLocalService instanceof CitizenInquiryCategoryLocalService) {
				_service = (CitizenInquiryCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new CitizenInquiryCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CitizenInquiryCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CitizenInquiryCategoryLocalService service) {
	}

	private static CitizenInquiryCategoryLocalService _service;
}