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
 * The utility for the y k c t_ dl file entries local service. This utility wraps {@link com.portal_egov.portlet.ykct.service.impl.YKCT_DlFileEntriesLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see YKCT_DlFileEntriesLocalService
 * @see com.portal_egov.portlet.ykct.service.base.YKCT_DlFileEntriesLocalServiceBaseImpl
 * @see com.portal_egov.portlet.ykct.service.impl.YKCT_DlFileEntriesLocalServiceImpl
 * @generated
 */
public class YKCT_DlFileEntriesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.ykct.service.impl.YKCT_DlFileEntriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the y k c t_ dl file entries to the database. Also notifies the appropriate model listeners.
	*
	* @param ykct_DlFileEntries the y k c t_ dl file entries
	* @return the y k c t_ dl file entries that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries addYKCT_DlFileEntries(
		com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries ykct_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addYKCT_DlFileEntries(ykct_DlFileEntries);
	}

	/**
	* Creates a new y k c t_ dl file entries with the primary key. Does not add the y k c t_ dl file entries to the database.
	*
	* @param id the primary key for the new y k c t_ dl file entries
	* @return the new y k c t_ dl file entries
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries createYKCT_DlFileEntries(
		long id) {
		return getService().createYKCT_DlFileEntries(id);
	}

	/**
	* Deletes the y k c t_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the y k c t_ dl file entries
	* @return the y k c t_ dl file entries that was removed
	* @throws PortalException if a y k c t_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries deleteYKCT_DlFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteYKCT_DlFileEntries(id);
	}

	/**
	* Deletes the y k c t_ dl file entries from the database. Also notifies the appropriate model listeners.
	*
	* @param ykct_DlFileEntries the y k c t_ dl file entries
	* @return the y k c t_ dl file entries that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries deleteYKCT_DlFileEntries(
		com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries ykct_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteYKCT_DlFileEntries(ykct_DlFileEntries);
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

	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries fetchYKCT_DlFileEntries(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchYKCT_DlFileEntries(id);
	}

	/**
	* Returns the y k c t_ dl file entries with the primary key.
	*
	* @param id the primary key of the y k c t_ dl file entries
	* @return the y k c t_ dl file entries
	* @throws PortalException if a y k c t_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries getYKCT_DlFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKCT_DlFileEntries(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the y k c t_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ dl file entrieses
	* @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	* @return the range of y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> getYKCT_DlFileEntrieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKCT_DlFileEntrieses(start, end);
	}

	/**
	* Returns the number of y k c t_ dl file entrieses.
	*
	* @return the number of y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int getYKCT_DlFileEntriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getYKCT_DlFileEntriesesCount();
	}

	/**
	* Updates the y k c t_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ykct_DlFileEntries the y k c t_ dl file entries
	* @return the y k c t_ dl file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries updateYKCT_DlFileEntries(
		com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries ykct_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateYKCT_DlFileEntries(ykct_DlFileEntries);
	}

	/**
	* Updates the y k c t_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ykct_DlFileEntries the y k c t_ dl file entries
	* @param merge whether to merge the y k c t_ dl file entries with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the y k c t_ dl file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries updateYKCT_DlFileEntries(
		com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries ykct_DlFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateYKCT_DlFileEntries(ykct_DlFileEntries, merge);
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

	public static int countByVBPQEntry(long ykctEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByVBPQEntry(ykctEntryId);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByYKCTEntry(
		long ykctEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByYKCTEntry(ykctEntryId);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByDLFileEntry(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDLFileEntry(fileEntryId);
	}

	public static void updateMapping(long entryId, long ykctEntryId,
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateMapping(entryId, ykctEntryId, fileEntryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static YKCT_DlFileEntriesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					YKCT_DlFileEntriesLocalService.class.getName());

			if (invokableLocalService instanceof YKCT_DlFileEntriesLocalService) {
				_service = (YKCT_DlFileEntriesLocalService)invokableLocalService;
			}
			else {
				_service = new YKCT_DlFileEntriesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(YKCT_DlFileEntriesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(YKCT_DlFileEntriesLocalService service) {
	}

	private static YKCT_DlFileEntriesLocalService _service;
}