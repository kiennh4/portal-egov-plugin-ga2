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

package com.bkav.portal.portlet.contentsharing.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the content sharing local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see ContentSharingLocalServiceUtil
 * @see com.bkav.portal.portlet.contentsharing.service.base.ContentSharingLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.contentsharing.service.impl.ContentSharingLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ContentSharingLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentSharingLocalServiceUtil} to access the content sharing local service. Add custom service methods to {@link com.bkav.portal.portlet.contentsharing.service.impl.ContentSharingLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the content sharing to the database. Also notifies the appropriate model listeners.
	*
	* @param contentSharing the content sharing
	* @return the content sharing that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing addContentSharing(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new content sharing with the primary key. Does not add the content sharing to the database.
	*
	* @param contentId the primary key for the new content sharing
	* @return the new content sharing
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing createContentSharing(
		long contentId);

	/**
	* Deletes the content sharing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing that was removed
	* @throws PortalException if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing deleteContentSharing(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the content sharing from the database. Also notifies the appropriate model listeners.
	*
	* @param contentSharing the content sharing
	* @return the content sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing deleteContentSharing(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing)
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
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchContentSharing(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content sharing with the primary key.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing
	* @throws PortalException if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing getContentSharing(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the content sharings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of content sharings
	* @param end the upper bound of the range of content sharings (not inclusive)
	* @return the range of content sharings
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> getContentSharings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of content sharings.
	*
	* @return the number of content sharings
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getContentSharingsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the content sharing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contentSharing the content sharing
	* @return the content sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing updateContentSharing(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the content sharing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contentSharing the content sharing
	* @param merge whether to merge the content sharing with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the content sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing updateContentSharing(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing,
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

	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing findByCompanyAndGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getContentSharingByCompanyExceptRoot(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing addRootContentSharing(
		long companyId, long groupId, long userId, java.lang.String content,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing addContentSharing(
		long companyId, long groupId, long userId, java.lang.String content,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing updateContentSharing(
		long contentId, long companyId, long groupId, long userId,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}