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

package com.portal_egov.portlet.legal_faq.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the legal f a q category local service. This utility wraps {@link com.portal_egov.portlet.legal_faq.service.impl.LegalFAQCategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see LegalFAQCategoryLocalService
 * @see com.portal_egov.portlet.legal_faq.service.base.LegalFAQCategoryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.legal_faq.service.impl.LegalFAQCategoryLocalServiceImpl
 * @generated
 */
public class LegalFAQCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.legal_faq.service.impl.LegalFAQCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the legal f a q category to the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQCategory the legal f a q category
	* @return the legal f a q category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory addLegalFAQCategory(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLegalFAQCategory(legalFAQCategory);
	}

	/**
	* Creates a new legal f a q category with the primary key. Does not add the legal f a q category to the database.
	*
	* @param categoryId the primary key for the new legal f a q category
	* @return the new legal f a q category
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory createLegalFAQCategory(
		long categoryId) {
		return getService().createLegalFAQCategory(categoryId);
	}

	/**
	* Deletes the legal f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the legal f a q category
	* @return the legal f a q category that was removed
	* @throws PortalException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory deleteLegalFAQCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegalFAQCategory(categoryId);
	}

	/**
	* Deletes the legal f a q category from the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQCategory the legal f a q category
	* @return the legal f a q category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory deleteLegalFAQCategory(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegalFAQCategory(legalFAQCategory);
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

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchLegalFAQCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLegalFAQCategory(categoryId);
	}

	/**
	* Returns the legal f a q category with the primary key.
	*
	* @param categoryId the primary key of the legal f a q category
	* @return the legal f a q category
	* @throws PortalException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory getLegalFAQCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegalFAQCategory(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legal f a q categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @return the range of legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> getLegalFAQCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegalFAQCategories(start, end);
	}

	/**
	* Returns the number of legal f a q categories.
	*
	* @return the number of legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getLegalFAQCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegalFAQCategoriesCount();
	}

	/**
	* Updates the legal f a q category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalFAQCategory the legal f a q category
	* @return the legal f a q category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory updateLegalFAQCategory(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLegalFAQCategory(legalFAQCategory);
	}

	/**
	* Updates the legal f a q category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalFAQCategory the legal f a q category
	* @param merge whether to merge the legal f a q category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the legal f a q category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory updateLegalFAQCategory(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLegalFAQCategory(legalFAQCategory, merge);
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

	public static int countByParent(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByParent(companyId, parentId);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByParent(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParent(companyId, parentId);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByParent(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParent(companyId, parentId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByKeyword(groupId, keyword, start, end);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategory(categoryId);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory addCategory(
		long companyId, long groupId, long userId, long parentId,
		java.lang.String categoryName, java.lang.String categoryDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCategory(companyId, groupId, userId, parentId,
			categoryName, categoryDesc, serviceContext);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQCategory updateCategory(
		long categoryId, long companyId, long groupId, long userId,
		long parentId, java.lang.String categoryName,
		java.lang.String categoryDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCategory(categoryId, companyId, groupId, userId,
			parentId, categoryName, categoryDesc);
	}

	public static void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCategory(categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LegalFAQCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LegalFAQCategoryLocalService.class.getName());

			if (invokableLocalService instanceof LegalFAQCategoryLocalService) {
				_service = (LegalFAQCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new LegalFAQCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LegalFAQCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LegalFAQCategoryLocalService service) {
	}

	private static LegalFAQCategoryLocalService _service;
}