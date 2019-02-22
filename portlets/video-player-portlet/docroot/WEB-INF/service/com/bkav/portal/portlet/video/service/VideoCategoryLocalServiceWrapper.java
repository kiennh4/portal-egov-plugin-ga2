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

package com.bkav.portal.portlet.video.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VideoCategoryLocalService}.
 * </p>
 *
 * @author    hungdx
 * @see       VideoCategoryLocalService
 * @generated
 */
public class VideoCategoryLocalServiceWrapper
	implements VideoCategoryLocalService,
		ServiceWrapper<VideoCategoryLocalService> {
	public VideoCategoryLocalServiceWrapper(
		VideoCategoryLocalService videoCategoryLocalService) {
		_videoCategoryLocalService = videoCategoryLocalService;
	}

	/**
	* Adds the video category to the database. Also notifies the appropriate model listeners.
	*
	* @param videoCategory the video category
	* @return the video category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory addVideoCategory(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.addVideoCategory(videoCategory);
	}

	/**
	* Creates a new video category with the primary key. Does not add the video category to the database.
	*
	* @param categoryId the primary key for the new video category
	* @return the new video category
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory createVideoCategory(
		long categoryId) {
		return _videoCategoryLocalService.createVideoCategory(categoryId);
	}

	/**
	* Deletes the video category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the video category
	* @return the video category that was removed
	* @throws PortalException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory deleteVideoCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.deleteVideoCategory(categoryId);
	}

	/**
	* Deletes the video category from the database. Also notifies the appropriate model listeners.
	*
	* @param videoCategory the video category
	* @return the video category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory deleteVideoCategory(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.deleteVideoCategory(videoCategory);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _videoCategoryLocalService.dynamicQuery();
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
		return _videoCategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _videoCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _videoCategoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _videoCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.video.model.VideoCategory fetchVideoCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.fetchVideoCategory(categoryId);
	}

	/**
	* Returns the video category with the primary key.
	*
	* @param categoryId the primary key of the video category
	* @return the video category
	* @throws PortalException if a video category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory getVideoCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getVideoCategory(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video categories
	* @param end the upper bound of the range of video categories (not inclusive)
	* @return the range of video categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> getVideoCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getVideoCategories(start, end);
	}

	/**
	* Returns the number of video categories.
	*
	* @return the number of video categories
	* @throws SystemException if a system exception occurred
	*/
	public int getVideoCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.getVideoCategoriesCount();
	}

	/**
	* Updates the video category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoCategory the video category
	* @return the video category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory updateVideoCategory(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.updateVideoCategory(videoCategory);
	}

	/**
	* Updates the video category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoCategory the video category
	* @param merge whether to merge the video category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.video.model.VideoCategory updateVideoCategory(
		com.bkav.portal.portlet.video.model.VideoCategory videoCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.updateVideoCategory(videoCategory,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _videoCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_videoCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _videoCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.video.model.VideoCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.findByGroup(groupId, start, end);
	}

	public com.bkav.portal.portlet.video.model.VideoCategory addVideoCategory(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String categoryName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.addVideoCategory(companyId, groupId,
			userId, userName, categoryName, serviceContext);
	}

	public com.bkav.portal.portlet.video.model.VideoCategory updateVideoCategory(
		long categoryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String categoryName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoCategoryLocalService.updateVideoCategory(categoryId,
			companyId, groupId, userId, userName, categoryName, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VideoCategoryLocalService getWrappedVideoCategoryLocalService() {
		return _videoCategoryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVideoCategoryLocalService(
		VideoCategoryLocalService videoCategoryLocalService) {
		_videoCategoryLocalService = videoCategoryLocalService;
	}

	public VideoCategoryLocalService getWrappedService() {
		return _videoCategoryLocalService;
	}

	public void setWrappedService(
		VideoCategoryLocalService videoCategoryLocalService) {
		_videoCategoryLocalService = videoCategoryLocalService;
	}

	private VideoCategoryLocalService _videoCategoryLocalService;
}