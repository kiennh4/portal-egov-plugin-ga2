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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the online inquiry local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see OnlineInquiryLocalServiceUtil
 * @see com.portal_egov.portlet.inquiry.service.base.OnlineInquiryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface OnlineInquiryLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OnlineInquiryLocalServiceUtil} to access the online inquiry local service. Add custom service methods to {@link com.portal_egov.portlet.inquiry.service.impl.OnlineInquiryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the online inquiry to the database. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @return the online inquiry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry addOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new online inquiry with the primary key. Does not add the online inquiry to the database.
	*
	* @param inquiryId the primary key for the new online inquiry
	* @return the new online inquiry
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry createOnlineInquiry(
		long inquiryId);

	/**
	* Deletes the online inquiry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry that was removed
	* @throws PortalException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry deleteOnlineInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the online inquiry from the database. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @return the online inquiry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry deleteOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry)
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
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry fetchOnlineInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the online inquiry with the primary key.
	*
	* @param inquiryId the primary key of the online inquiry
	* @return the online inquiry
	* @throws PortalException if a online inquiry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry getOnlineInquiry(
		long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> getOnlineInquiries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of online inquiries.
	*
	* @return the number of online inquiries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOnlineInquiriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the online inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @return the online inquiry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry updateOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the online inquiry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param onlineInquiry the online inquiry
	* @param merge whether to merge the online inquiry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the online inquiry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.inquiry.model.OnlineInquiry updateOnlineInquiry(
		com.portal_egov.portlet.inquiry.model.OnlineInquiry onlineInquiry,
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

	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc);

	public void addInquiry(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String fullName,
		java.lang.String phoneNumbers, java.lang.String emailAddress,
		java.lang.String inquiryContent,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updateInquiry(long inquiryId, long companyId, long groupId,
		long userId, java.lang.String userName, java.lang.String fullName,
		java.lang.String phoneNumbers, java.lang.String emailAddress,
		java.lang.String inquiryContent,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteInquiry(long inquiryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}