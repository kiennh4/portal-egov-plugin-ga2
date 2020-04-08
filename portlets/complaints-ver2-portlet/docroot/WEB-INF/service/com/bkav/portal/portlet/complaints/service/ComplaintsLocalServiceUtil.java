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

package com.bkav.portal.portlet.complaints.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the complaints local service. This utility wraps {@link com.bkav.portal.portlet.complaints.service.impl.ComplaintsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author AnhBDb
 * @see ComplaintsLocalService
 * @see com.bkav.portal.portlet.complaints.service.base.ComplaintsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.complaints.service.impl.ComplaintsLocalServiceImpl
 * @generated
 */
public class ComplaintsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.complaints.service.impl.ComplaintsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the complaints to the database. Also notifies the appropriate model listeners.
	*
	* @param complaints the complaints
	* @return the complaints that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.complaints.model.Complaints addComplaints(
		com.bkav.portal.portlet.complaints.model.Complaints complaints)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addComplaints(complaints);
	}

	/**
	* Creates a new complaints with the primary key. Does not add the complaints to the database.
	*
	* @param complaintId the primary key for the new complaints
	* @return the new complaints
	*/
	public static com.bkav.portal.portlet.complaints.model.Complaints createComplaints(
		long complaintId) {
		return getService().createComplaints(complaintId);
	}

	/**
	* Deletes the complaints with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param complaintId the primary key of the complaints
	* @return the complaints that was removed
	* @throws PortalException if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.complaints.model.Complaints deleteComplaints(
		long complaintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteComplaints(complaintId);
	}

	/**
	* Deletes the complaints from the database. Also notifies the appropriate model listeners.
	*
	* @param complaints the complaints
	* @return the complaints that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.complaints.model.Complaints deleteComplaints(
		com.bkav.portal.portlet.complaints.model.Complaints complaints)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteComplaints(complaints);
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

	public static com.bkav.portal.portlet.complaints.model.Complaints fetchComplaints(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchComplaints(complaintId);
	}

	/**
	* Returns the complaints with the primary key.
	*
	* @param complaintId the primary key of the complaints
	* @return the complaints
	* @throws PortalException if a complaints with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.complaints.model.Complaints getComplaints(
		long complaintId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getComplaints(complaintId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the complaintses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaintses
	* @param end the upper bound of the range of complaintses (not inclusive)
	* @return the range of complaintses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> getComplaintses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getComplaintses(start, end);
	}

	/**
	* Returns the number of complaintses.
	*
	* @return the number of complaintses
	* @throws SystemException if a system exception occurred
	*/
	public static int getComplaintsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getComplaintsesCount();
	}

	/**
	* Updates the complaints in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param complaints the complaints
	* @return the complaints that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.complaints.model.Complaints updateComplaints(
		com.bkav.portal.portlet.complaints.model.Complaints complaints)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateComplaints(complaints);
	}

	/**
	* Updates the complaints in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param complaints the complaints
	* @param merge whether to merge the complaints with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the complaints that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.complaints.model.Complaints updateComplaints(
		com.bkav.portal.portlet.complaints.model.Complaints complaints,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateComplaints(complaints, merge);
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

	public static java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByKeyWord(
		long groupId, java.lang.String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByKeyWord(groupId, keyword, start, end, obc);
	}

	public static java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId);
	}

	public static java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompanyId(companyId);
	}

	public static com.bkav.portal.portlet.complaints.model.Complaints addComplaint(
		long groupId, long companyId, long userId,
		java.lang.String complaintNumber, java.lang.String complaintName,
		java.lang.String complaintDesc, java.lang.String complaintContent,
		java.util.Date signingDate, java.lang.String replyDocument,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addComplaint(groupId, companyId, userId, complaintNumber,
			complaintName, complaintDesc, complaintContent, signingDate,
			replyDocument, serviceContext);
	}

	public static com.bkav.portal.portlet.complaints.model.Complaints updateComplaint(
		long complaintId, java.lang.String complaintNumber,
		java.lang.String complaintName, java.lang.String complaintDesc,
		java.lang.String complaintContent, java.util.Date signingDate,
		java.lang.String replyDocument,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateComplaint(complaintId, complaintNumber,
			complaintName, complaintDesc, complaintContent, signingDate,
			replyDocument, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ComplaintsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ComplaintsLocalService.class.getName());

			if (invokableLocalService instanceof ComplaintsLocalService) {
				_service = (ComplaintsLocalService)invokableLocalService;
			}
			else {
				_service = new ComplaintsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ComplaintsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ComplaintsLocalService service) {
	}

	private static ComplaintsLocalService _service;
}