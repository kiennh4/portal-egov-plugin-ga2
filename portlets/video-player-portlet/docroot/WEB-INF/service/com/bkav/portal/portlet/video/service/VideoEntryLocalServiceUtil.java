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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the video entry local service. This utility wraps {@link com.bkav.portal.portlet.video.service.impl.VideoEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hungdx
 * @see VideoEntryLocalService
 * @see com.bkav.portal.portlet.video.service.base.VideoEntryLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.video.service.impl.VideoEntryLocalServiceImpl
 * @generated
 */
public class VideoEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.video.service.impl.VideoEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the video entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoEntry the video entry
	* @return the video entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoEntry addVideoEntry(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVideoEntry(videoEntry);
	}

	/**
	* Creates a new video entry with the primary key. Does not add the video entry to the database.
	*
	* @param entryId the primary key for the new video entry
	* @return the new video entry
	*/
	public static com.bkav.portal.portlet.video.model.VideoEntry createVideoEntry(
		long entryId) {
		return getService().createVideoEntry(entryId);
	}

	/**
	* Deletes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the video entry
	* @return the video entry that was removed
	* @throws PortalException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoEntry deleteVideoEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVideoEntry(entryId);
	}

	/**
	* Deletes the video entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoEntry the video entry
	* @return the video entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoEntry deleteVideoEntry(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVideoEntry(videoEntry);
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

	public static com.bkav.portal.portlet.video.model.VideoEntry fetchVideoEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVideoEntry(entryId);
	}

	/**
	* Returns the video entry with the primary key.
	*
	* @param entryId the primary key of the video entry
	* @return the video entry
	* @throws PortalException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoEntry getVideoEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoEntry(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> getVideoEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoEntries(start, end);
	}

	/**
	* Returns the number of video entries.
	*
	* @return the number of video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getVideoEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoEntriesCount();
	}

	/**
	* Updates the video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoEntry the video entry
	* @return the video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoEntry updateVideoEntry(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVideoEntry(videoEntry);
	}

	/**
	* Updates the video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoEntry the video entry
	* @param merge whether to merge the video entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.video.model.VideoEntry updateVideoEntry(
		com.bkav.portal.portlet.video.model.VideoEntry videoEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVideoEntry(videoEntry, merge);
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

	public static java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByKeyword(groupId, keyword, start, end);
	}

	public static java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByCategoryId(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryId(groupId, categoryId, start, end);
	}

	public static com.bkav.portal.portlet.video.model.VideoEntry addVideo(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String name, java.lang.String description,
		java.lang.String videoType, java.lang.String videoUrl,
		long videoFileId, boolean thumbnailImage, long thumbnailImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVideo(companyId, groupId, userId, userName, name,
			description, videoType, videoUrl, videoFileId, thumbnailImage,
			thumbnailImageId, serviceContext);
	}

	public static com.bkav.portal.portlet.video.model.VideoEntry updateVideo(
		long entryId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String name,
		java.lang.String description, java.lang.String videoType,
		java.lang.String videoUrl, long videoFileId, boolean thumbnailImage,
		long thumbnailImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVideo(entryId, companyId, groupId, userId, userName,
			name, description, videoType, videoUrl, videoFileId,
			thumbnailImage, thumbnailImageId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static VideoEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VideoEntryLocalService.class.getName());

			if (invokableLocalService instanceof VideoEntryLocalService) {
				_service = (VideoEntryLocalService)invokableLocalService;
			}
			else {
				_service = new VideoEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VideoEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(VideoEntryLocalService service) {
	}

	private static VideoEntryLocalService _service;
}