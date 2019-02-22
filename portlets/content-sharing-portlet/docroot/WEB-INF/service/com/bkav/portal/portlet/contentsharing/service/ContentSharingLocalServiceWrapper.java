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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ContentSharingLocalService}.
 * </p>
 *
 * @author    anhbdb
 * @see       ContentSharingLocalService
 * @generated
 */
public class ContentSharingLocalServiceWrapper
	implements ContentSharingLocalService,
		ServiceWrapper<ContentSharingLocalService> {
	public ContentSharingLocalServiceWrapper(
		ContentSharingLocalService contentSharingLocalService) {
		_contentSharingLocalService = contentSharingLocalService;
	}

	/**
	* Adds the content sharing to the database. Also notifies the appropriate model listeners.
	*
	* @param contentSharing the content sharing
	* @return the content sharing that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing addContentSharing(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.addContentSharing(contentSharing);
	}

	/**
	* Creates a new content sharing with the primary key. Does not add the content sharing to the database.
	*
	* @param contentId the primary key for the new content sharing
	* @return the new content sharing
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing createContentSharing(
		long contentId) {
		return _contentSharingLocalService.createContentSharing(contentId);
	}

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
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.deleteContentSharing(contentId);
	}

	/**
	* Deletes the content sharing from the database. Also notifies the appropriate model listeners.
	*
	* @param contentSharing the content sharing
	* @return the content sharing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing deleteContentSharing(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.deleteContentSharing(contentSharing);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentSharingLocalService.dynamicQuery();
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing fetchContentSharing(
		long contentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.fetchContentSharing(contentId);
	}

	/**
	* Returns the content sharing with the primary key.
	*
	* @param contentId the primary key of the content sharing
	* @return the content sharing
	* @throws PortalException if a content sharing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing getContentSharing(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.getContentSharing(contentId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> getContentSharings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.getContentSharings(start, end);
	}

	/**
	* Returns the number of content sharings.
	*
	* @return the number of content sharings
	* @throws SystemException if a system exception occurred
	*/
	public int getContentSharingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.getContentSharingsCount();
	}

	/**
	* Updates the content sharing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contentSharing the content sharing
	* @return the content sharing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.contentsharing.model.ContentSharing updateContentSharing(
		com.bkav.portal.portlet.contentsharing.model.ContentSharing contentSharing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.updateContentSharing(contentSharing);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.updateContentSharing(contentSharing,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _contentSharingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentSharingLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentSharingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> findAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.findAll();
	}

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing findByCompanyAndGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.findByCompanyAndGroup(companyId,
			groupId);
	}

	public java.lang.String getContentSharingByCompanyExceptRoot(long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.getContentSharingByCompanyExceptRoot(companyId);
	}

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing addRootContentSharing(
		long companyId, long groupId, long userId, java.lang.String content,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.addRootContentSharing(companyId,
			groupId, userId, content, serviceContext);
	}

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing addContentSharing(
		long companyId, long groupId, long userId, java.lang.String content,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.addContentSharing(companyId,
			groupId, userId, content, serviceContext);
	}

	public com.bkav.portal.portlet.contentsharing.model.ContentSharing updateContentSharing(
		long contentId, long companyId, long groupId, long userId,
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentSharingLocalService.updateContentSharing(contentId,
			companyId, groupId, userId, content);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ContentSharingLocalService getWrappedContentSharingLocalService() {
		return _contentSharingLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedContentSharingLocalService(
		ContentSharingLocalService contentSharingLocalService) {
		_contentSharingLocalService = contentSharingLocalService;
	}

	public ContentSharingLocalService getWrappedService() {
		return _contentSharingLocalService;
	}

	public void setWrappedService(
		ContentSharingLocalService contentSharingLocalService) {
		_contentSharingLocalService = contentSharingLocalService;
	}

	private ContentSharingLocalService _contentSharingLocalService;
}