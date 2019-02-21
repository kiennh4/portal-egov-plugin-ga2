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

package com.portal_egov.portlet.banner.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the banner local service. This utility wraps {@link com.portal_egov.portlet.banner.service.impl.BannerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see BannerLocalService
 * @see com.portal_egov.portlet.banner.service.base.BannerLocalServiceBaseImpl
 * @see com.portal_egov.portlet.banner.service.impl.BannerLocalServiceImpl
 * @generated
 */
public class BannerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.banner.service.impl.BannerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the banner to the database. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @return the banner that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner addBanner(
		com.portal_egov.portlet.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBanner(banner);
	}

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param bannerId the primary key for the new banner
	* @return the new banner
	*/
	public static com.portal_egov.portlet.banner.model.Banner createBanner(
		long bannerId) {
		return getService().createBanner(bannerId);
	}

	/**
	* Deletes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerId the primary key of the banner
	* @return the banner that was removed
	* @throws PortalException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner deleteBanner(
		long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBanner(bannerId);
	}

	/**
	* Deletes the banner from the database. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @return the banner that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner deleteBanner(
		com.portal_egov.portlet.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBanner(banner);
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

	public static com.portal_egov.portlet.banner.model.Banner fetchBanner(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBanner(bannerId);
	}

	/**
	* Returns the banner with the primary key.
	*
	* @param bannerId the primary key of the banner
	* @return the banner
	* @throws PortalException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner getBanner(
		long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBanner(bannerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> getBanners(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBanners(start, end);
	}

	/**
	* Returns the number of banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public static int getBannersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBannersCount();
	}

	/**
	* Updates the banner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @return the banner that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner updateBanner(
		com.portal_egov.portlet.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBanner(banner);
	}

	/**
	* Updates the banner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @param merge whether to merge the banner with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the banner that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner updateBanner(
		com.portal_egov.portlet.banner.model.Banner banner, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBanner(banner, merge);
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

	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByBannerGroup(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBannerGroup(bannerGroupId);
	}

	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByTitle(
		long groupId, long bannerGroupId, java.lang.String bannerTitle,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .findByTitle(groupId, bannerGroupId, bannerTitle, start,
			end, obc);
	}

	public static com.portal_egov.portlet.banner.model.Banner getBannerCounter(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBannerCounter(bannerId);
	}

	public static com.portal_egov.portlet.banner.model.Banner addBanner(
		long companyId, long groupId, long userId, java.lang.String userName,
		long bannerGroupId, java.lang.String bannerTitle,
		java.lang.String bannerLink, long bannerImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBanner(companyId, groupId, userId, userName,
			bannerGroupId, bannerTitle, bannerLink, bannerImageId,
			serviceContext);
	}

	public static com.portal_egov.portlet.banner.model.Banner updateBanner(
		long bannerId, long bannerGroupId, java.lang.String bannerTitle,
		java.lang.String bannerLink, long bannerImageId, int bannerStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBanner(bannerId, bannerGroupId, bannerTitle,
			bannerLink, bannerImageId, bannerStatus);
	}

	public static void updateBannerStatus(long bannerId, int bannerStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateBannerStatus(bannerId, bannerStatus);
	}

	public static void clearService() {
		_service = null;
	}

	public static BannerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BannerLocalService.class.getName());

			if (invokableLocalService instanceof BannerLocalService) {
				_service = (BannerLocalService)invokableLocalService;
			}
			else {
				_service = new BannerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BannerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(BannerLocalService service) {
	}

	private static BannerLocalService _service;
}