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

package com.portal_egov.portlet.inquiry.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the online inquiry local service. This utility wraps {@link com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see OnlineInquiryLocalService
 * @see com.portal_egov.portlet.inquiry.service.base.OnlineInquiryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryLocalServiceImpl
 * @generated
 */
public class OnlineInquiryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the online inquiry to the database. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @return the online inquiry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry addOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOnlineInquiry(onlineInquiry);
	}

	/**
	* Creates a new online inquiry with the primary key. Does not add the online inquiry to the database.
	*
	* @param inquiryId the primary key for the new online inquiry
	* @return the new online inquiry
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry createOnlineInquiry(
		long inquiryId) {
		return getService().createOnlineInquiry(inquiryId);
	}

	/**
	* Deletes the online inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry that was removed
	* @throws PortalException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry deleteOnlineInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOnlineInquiry(inquiryId);
	}

	/**
	* Deletes the online inquiry from the database. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @return the online inquiry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry deleteOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOnlineInquiry(onlineInquiry);
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

	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchOnlineInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOnlineInquiry(inquiryId);
	}

	/**
	* Returns the online inquiry with the primary key.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry
	* @throws PortalException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry getOnlineInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOnlineInquiry(inquiryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the online inquiries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of online inquiries
	* @param end the upper bound of the range of online inquiries (not inclusive)
	* @return the range of online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> getOnlineInquiries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOnlineInquiries(start, end);
	}

	/**
	* Returns the number of online inquiries.
	*
	* @return the number of online inquiries
	* @throws SystemException if a system exception occurred
	*/
	public static int getOnlineInquiriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOnlineInquiriesCount();
	}

	/**
	* Updates the online inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @return the online inquiry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry updateOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOnlineInquiry(onlineInquiry);
	}

	/**
	* Updates the online inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @param merge whether to merge the online inquiry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the online inquiry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.inquiry.model.OnlineInquiry updateOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOnlineInquiry(onlineInquiry, merge);
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

	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService().findByKeyword(groupId, keyword, start, end, obc);
	}

	public static void addInquiry(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String fullName,
		java.lang.String phoneNumbers, java.lang.String emailAddress,
		java.lang.String inquiryContent,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addInquiry(companyId, groupId, userId, userName, fullName,
			phoneNumbers, emailAddress, inquiryContent, serviceContext);
	}

	public static void updateInquiry(long inquiryId, long companyId,
		long groupId, long userId, java.lang.String userName,
		java.lang.String fullName, java.lang.String phoneNumbers,
		java.lang.String emailAddress, java.lang.String inquiryContent,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateInquiry(inquiryId, companyId, groupId, userId, userName,
			fullName, phoneNumbers, emailAddress, inquiryContent, serviceContext);
	}

	public static void deleteInquiry(long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteInquiry(inquiryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static OnlineInquiryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OnlineInquiryLocalService.class.getName());

			if (invokableLocalService instanceof OnlineInquiryLocalService) {
				_service = (OnlineInquiryLocalService)invokableLocalService;
			}
			else {
				_service = new OnlineInquiryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OnlineInquiryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(OnlineInquiryLocalService service) {
	}

	private static OnlineInquiryLocalService _service;
}