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

package com.portal_egov.portlet.vbpq.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the v b p q_ dl file entries local service. This utility wraps {@link com.portal_egov.portlet.vbpq.service.impl.VBPQ_DlFileEntriesLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see VBPQ_DlFileEntriesLocalService
 * @see com.portal_egov.portlet.vbpq.service.base.VBPQ_DlFileEntriesLocalServiceBaseImpl
 * @see com.portal_egov.portlet.vbpq.service.impl.VBPQ_DlFileEntriesLocalServiceImpl
 * @generated
 */
public class VBPQ_DlFileEntriesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.vbpq.service.impl.VBPQ_DlFileEntriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v b p q_ dl file entries to the database. Also notifies the appropriate model listeners.
	*
	* @param vbpq_DlFileEntries the v b p q_ dl file entries
	* @return the v b p q_ dl file entries that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries addVBPQ_DlFileEntries(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVBPQ_DlFileEntries(vbpq_DlFileEntries);
	}

	/**
	* Creates a new v b p q_ dl file entries with the primary key. Does not add the v b p q_ dl file entries to the database.
	*
	* @param id the primary key for the new v b p q_ dl file entries
	* @return the new v b p q_ dl file entries
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries createVBPQ_DlFileEntries(
		long id) {
		return getService().createVBPQ_DlFileEntries(id);
	}

	/**
	* Deletes the v b p q_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v b p q_ dl file entries
	* @return the v b p q_ dl file entries that was removed
	* @throws PortalException if a v b p q_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries deleteVBPQ_DlFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVBPQ_DlFileEntries(id);
	}

	/**
	* Deletes the v b p q_ dl file entries from the database. Also notifies the appropriate model listeners.
	*
	* @param vbpq_DlFileEntries the v b p q_ dl file entries
	* @return the v b p q_ dl file entries that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries deleteVBPQ_DlFileEntries(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVBPQ_DlFileEntries(vbpq_DlFileEntries);
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

	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries fetchVBPQ_DlFileEntries(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVBPQ_DlFileEntries(id);
	}

	/**
	* Returns the v b p q_ dl file entries with the primary key.
	*
	* @param id the primary key of the v b p q_ dl file entries
	* @return the v b p q_ dl file entries
	* @throws PortalException if a v b p q_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries getVBPQ_DlFileEntries(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVBPQ_DlFileEntries(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v b p q_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ dl file entrieses
	* @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	* @return the range of v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> getVBPQ_DlFileEntrieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVBPQ_DlFileEntrieses(start, end);
	}

	/**
	* Returns the number of v b p q_ dl file entrieses.
	*
	* @return the number of v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int getVBPQ_DlFileEntriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVBPQ_DlFileEntriesesCount();
	}

	/**
	* Updates the v b p q_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vbpq_DlFileEntries the v b p q_ dl file entries
	* @return the v b p q_ dl file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries updateVBPQ_DlFileEntries(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVBPQ_DlFileEntries(vbpq_DlFileEntries);
	}

	/**
	* Updates the v b p q_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vbpq_DlFileEntries the v b p q_ dl file entries
	* @param merge whether to merge the v b p q_ dl file entries with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the v b p q_ dl file entries that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries updateVBPQ_DlFileEntries(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVBPQ_DlFileEntries(vbpq_DlFileEntries, merge);
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

	public static int countByVBPQEntry(long vbpqEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByVBPQEntry(vbpqEntryId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByVBPQEntry(
		long vbpqEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByVBPQEntry(vbpqEntryId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByDLFileEntry(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDLFileEntry(fileEntryId);
	}

	public static void updateMapping(long entryId, long vbpqEntryId,
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateMapping(entryId, vbpqEntryId, fileEntryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VBPQ_DlFileEntriesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VBPQ_DlFileEntriesLocalService.class.getName());

			if (invokableLocalService instanceof VBPQ_DlFileEntriesLocalService) {
				_service = (VBPQ_DlFileEntriesLocalService)invokableLocalService;
			}
			else {
				_service = new VBPQ_DlFileEntriesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VBPQ_DlFileEntriesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(VBPQ_DlFileEntriesLocalService service) {
	}

	private static VBPQ_DlFileEntriesLocalService _service;
}