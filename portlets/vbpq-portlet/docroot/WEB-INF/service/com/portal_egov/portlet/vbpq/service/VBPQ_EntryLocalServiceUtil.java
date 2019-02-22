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
 * The utility for the v b p q_ entry local service. This utility wraps {@link com.portal_egov.portlet.vbpq.service.impl.VBPQ_EntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see VBPQ_EntryLocalService
 * @see com.portal_egov.portlet.vbpq.service.base.VBPQ_EntryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.vbpq.service.impl.VBPQ_EntryLocalServiceImpl
 * @generated
 */
public class VBPQ_EntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.vbpq.service.impl.VBPQ_EntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the v b p q_ entry to the database. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @return the v b p q_ entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry addVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVBPQ_Entry(vbpq_Entry);
	}

	/**
	* Creates a new v b p q_ entry with the primary key. Does not add the v b p q_ entry to the database.
	*
	* @param entryId the primary key for the new v b p q_ entry
	* @return the new v b p q_ entry
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry createVBPQ_Entry(
		long entryId) {
		return getService().createVBPQ_Entry(entryId);
	}

	/**
	* Deletes the v b p q_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry that was removed
	* @throws PortalException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry deleteVBPQ_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVBPQ_Entry(entryId);
	}

	/**
	* Deletes the v b p q_ entry from the database. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @return the v b p q_ entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry deleteVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVBPQ_Entry(vbpq_Entry);
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

	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchVBPQ_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVBPQ_Entry(entryId);
	}

	/**
	* Returns the v b p q_ entry with the primary key.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry
	* @throws PortalException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry getVBPQ_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVBPQ_Entry(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the v b p q_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> getVBPQ_Entries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVBPQ_Entries(start, end);
	}

	/**
	* Returns the number of v b p q_ entries.
	*
	* @return the number of v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getVBPQ_EntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVBPQ_EntriesCount();
	}

	/**
	* Updates the v b p q_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @return the v b p q_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVBPQ_Entry(vbpq_Entry);
	}

	/**
	* Updates the v b p q_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @param merge whether to merge the v b p q_ entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the v b p q_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVBPQ_Entry(vbpq_Entry, merge);
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
		throws com.liferay.portal.kernel.exception.NestableException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int countByCategoryAndCompany(long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryAndCompany(companyId, categoryId);
	}

	public static int countByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryAndGroup(groupId, categoryId);
	}

	public static int countByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDepartmentAndGroup(groupId, departmentId);
	}

	public static int countByDocTypeAndGroup(long groupId, long docTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDocTypeAndGroup(groupId, docTypeId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDepartmentAndCompany(departmentId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDepartmentAndCompany(departmentId, companyId, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDepartmentAndGroup(departmentId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDepartmentAndGroup(departmentId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndCompany(categoryId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndCompany(categoryId, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndGroup(categoryId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndGroup(categoryId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDocTypeAndCompany(docTypeId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDocTypeAndCompany(docTypeId, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDocTypeAndGroup(docTypeId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDocTypeAndGroup(docTypeId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		long companyId, boolean expiration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByExpirationAndCompany(companyId, expiration);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		long groupId, boolean expiration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByExpirationAndGroup(groupId, expiration);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByActiveStatusAndCompany(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByActiveStatusAndCompany(companyId, active);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByActiveStatusAndGroup(
		long groupId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByActiveStatusAndGroup(groupId, active);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByKeyword(
		java.lang.String keyword, long groupId, int start, int end) {
		return getService().findByKeyword(keyword, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long departmentId,
		long categoryId, long docTypeId, java.lang.String startDate,
		java.lang.String endDate, int expirationStatus, int start, int end) {
		return getService()
				   .findByMultiCondition(groupId, keyword, departmentId,
			categoryId, docTypeId, startDate, endDate, expirationStatus, start,
			end);
	}

	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry addVBPQEntry(
		long companyId, long groupId, long userId, long departmentId,
		long categoryId, long docTypeId, java.lang.String entryName,
		java.lang.String entryCode, java.lang.String entryDesc,
		java.lang.String publicatorName, java.util.Date publishDate,
		java.util.Date executeDate, java.util.Date expirationDate,
		boolean neverExpired,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVBPQEntry(companyId, groupId, userId, departmentId,
			categoryId, docTypeId, entryName, entryCode, entryDesc,
			publicatorName, publishDate, executeDate, expirationDate,
			neverExpired, serviceContext);
	}

	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateVBPQEntry(
		long entryId, long companyId, long groupId, long userId,
		long departmentId, long categoryId, long docTypeId,
		java.lang.String entryName, java.lang.String entryCode,
		java.lang.String entryDesc, java.lang.String publicatorName,
		java.util.Date publishDate, java.lang.String vbpqFileAttachmentURL,
		java.util.Date executeDate, java.util.Date expirationDate,
		boolean neverExpired,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVBPQEntry(entryId, companyId, groupId, userId,
			departmentId, categoryId, docTypeId, entryName, entryCode,
			entryDesc, publicatorName, publishDate, vbpqFileAttachmentURL,
			executeDate, expirationDate, neverExpired, serviceContext);
	}

	/**
	* Deactive
	*
	* @param entryId
	* @throws SystemException
	*/
	public static void deactiveVBPQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deactiveVBPQEntry(entryId);
	}

	/**
	* Xoa VBPQ
	*
	* @param entryId
	* @throws SystemException
	* @throws PortalException
	*/
	public static void deleteVBPQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVBPQEntry(entryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VBPQ_EntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VBPQ_EntryLocalService.class.getName());

			if (invokableLocalService instanceof VBPQ_EntryLocalService) {
				_service = (VBPQ_EntryLocalService)invokableLocalService;
			}
			else {
				_service = new VBPQ_EntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VBPQ_EntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(VBPQ_EntryLocalService service) {
	}

	private static VBPQ_EntryLocalService _service;
}