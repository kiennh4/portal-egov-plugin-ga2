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

package com.portal_egov.portlet.ykct.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the y k c t_ entry local service. This utility wraps {@link com.portal_egov.portlet.ykct.service.impl.YKCT_EntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see YKCT_EntryLocalService
 * @see com.portal_egov.portlet.ykct.service.base.YKCT_EntryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.ykct.service.impl.YKCT_EntryLocalServiceImpl
 * @generated
 */
public class YKCT_EntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.ykct.service.impl.YKCT_EntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the y k c t_ entry to the database. Also notifies the appropriate model listeners.
	*
	* @param ykct_Entry the y k c t_ entry
	* @return the y k c t_ entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry addYKCT_Entry(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addYKCT_Entry(ykct_Entry);
	}

	/**
	* Creates a new y k c t_ entry with the primary key. Does not add the y k c t_ entry to the database.
	*
	* @param entryId the primary key for the new y k c t_ entry
	* @return the new y k c t_ entry
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry createYKCT_Entry(
		long entryId) {
		return getService().createYKCT_Entry(entryId);
	}

	/**
	* Deletes the y k c t_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry that was removed
	* @throws PortalException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry deleteYKCT_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteYKCT_Entry(entryId);
	}

	/**
	* Deletes the y k c t_ entry from the database. Also notifies the appropriate model listeners.
	*
	* @param ykct_Entry the y k c t_ entry
	* @return the y k c t_ entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry deleteYKCT_Entry(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteYKCT_Entry(ykct_Entry);
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

	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchYKCT_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchYKCT_Entry(entryId);
	}

	/**
	* Returns the y k c t_ entry with the primary key.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry
	* @throws PortalException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry getYKCT_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKCT_Entry(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the y k c t_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @return the range of y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> getYKCT_Entries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKCT_Entries(start, end);
	}

	/**
	* Returns the number of y k c t_ entries.
	*
	* @return the number of y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getYKCT_EntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKCT_EntriesCount();
	}

	/**
	* Updates the y k c t_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ykct_Entry the y k c t_ entry
	* @return the y k c t_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry updateYKCT_Entry(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateYKCT_Entry(ykct_Entry);
	}

	/**
	* Updates the y k c t_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ykct_Entry the y k c t_ entry
	* @param merge whether to merge the y k c t_ entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the y k c t_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry updateYKCT_Entry(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateYKCT_Entry(ykct_Entry, merge);
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

	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategory(categoryId);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(categoryId);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(categoryId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getService().findByKeyword(groupId, keyword, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long categoryId, int start,
		int end) {
		return getService()
				   .findByMultiCondition(groupId, keyword, categoryId, start,
			end);
	}

	public static com.portal_egov.portlet.ykct.model.YKCT_Entry addYKCTEntry(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String entryName, long categoryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addYKCTEntry(companyId, groupId, userId, userName,
			entryName, categoryId, serviceContext);
	}

	public static com.portal_egov.portlet.ykct.model.YKCT_Entry updateYKCTEntry(
		long companyId, long groupId, long userId, java.lang.String userName,
		long entryId, java.lang.String entryName, long categoryId,
		java.lang.String fileAttachmentURL)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateYKCTEntry(companyId, groupId, userId, userName,
			entryId, entryName, categoryId, fileAttachmentURL);
	}

	public static void deleteYKCTEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteYKCTEntry(entryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static YKCT_EntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					YKCT_EntryLocalService.class.getName());

			if (invokableLocalService instanceof YKCT_EntryLocalService) {
				_service = (YKCT_EntryLocalService)invokableLocalService;
			}
			else {
				_service = new YKCT_EntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(YKCT_EntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(YKCT_EntryLocalService service) {
	}

	private static YKCT_EntryLocalService _service;
}