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

package com.portal_egov.portlet.tthc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the t t h c_ entry local service. This utility wraps {@link com.portal_egov.portlet.tthc.service.impl.TTHC_EntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see TTHC_EntryLocalService
 * @see com.portal_egov.portlet.tthc.service.base.TTHC_EntryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.tthc.service.impl.TTHC_EntryLocalServiceImpl
 * @generated
 */
public class TTHC_EntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.tthc.service.impl.TTHC_EntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the t t h c_ entry to the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @return the t t h c_ entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry addTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTTHC_Entry(tthc_Entry);
	}

	/**
	* Creates a new t t h c_ entry with the primary key. Does not add the t t h c_ entry to the database.
	*
	* @param entryId the primary key for the new t t h c_ entry
	* @return the new t t h c_ entry
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry createTTHC_Entry(
		long entryId) {
		return getService().createTTHC_Entry(entryId);
	}

	/**
	* Deletes the t t h c_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry that was removed
	* @throws PortalException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry deleteTTHC_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTTHC_Entry(entryId);
	}

	/**
	* Deletes the t t h c_ entry from the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @return the t t h c_ entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry deleteTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTTHC_Entry(tthc_Entry);
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

	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchTTHC_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTTHC_Entry(entryId);
	}

	/**
	* Returns the t t h c_ entry with the primary key.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry
	* @throws PortalException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry getTTHC_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTTHC_Entry(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t t h c_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> getTTHC_Entries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTTHC_Entries(start, end);
	}

	/**
	* Returns the number of t t h c_ entries.
	*
	* @return the number of t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getTTHC_EntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTTHC_EntriesCount();
	}

	/**
	* Updates the t t h c_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @return the t t h c_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry updateTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTTHC_Entry(tthc_Entry);
	}

	/**
	* Updates the t t h c_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @param merge whether to merge the t t h c_ entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the t t h c_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry updateTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTTHC_Entry(tthc_Entry, merge);
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

	public static int countByLevelAndCompany(long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByLevelAndCompany(levelId, companyId);
	}

	public static int countByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByLevelAndGroup(levelId, groupId);
	}

	public static int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryAndCompany(categoryId, companyId);
	}

	public static int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryAndGroup(categoryId, groupId);
	}

	public static int countByDepartment(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDepartment(departmentId, groupId);
	}

	public static int countByAudience(long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByAudience(audienceId, groupId);
	}

	public static int countByResultType(long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByResultType(resultTypeId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLevelAndCompany(levelId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLevelAndCompany(levelId, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLevelAndGroup(levelId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLevelAndGroup(levelId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDepartmentAndCompany(departmentId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDepartmentAndCompany(departmentId, companyId, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDepartmentAndGroup(departmentId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByDepartmentAndGroup(departmentId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndCompany(categoryId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndCompany(categoryId, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndGroup(categoryId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndGroup(categoryId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByAudienceAndCompany(audienceId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByAudienceAndCompany(audienceId, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByAudienceAndGroup(audienceId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByAudienceAndGroup(audienceId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByResultTypeAndCompany(resultTypeId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByResultTypeAndCompany(resultTypeId, companyId, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByResultTypeAndGroup(resultTypeId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByResultTypeAndGroup(resultTypeId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getService().findByKeyword(groupId, keyword, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long levelId,
		long departmentId, long categoryId, long audienceId, long resultTypeId,
		int start, int end) {
		return getService()
				   .findByMultiCondition(groupId, keyword, levelId,
			departmentId, categoryId, audienceId, resultTypeId, start, end);
	}

	public static com.portal_egov.portlet.tthc.model.TTHC_Entry getTTHCEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTTHCEntry(entryId);
	}

	public static com.portal_egov.portlet.tthc.model.TTHC_Entry addTTHCEntry(
		long companyId, long groupId, long userId, long levelId,
		long departmentId, long categoryId, long audienceId, long resultTypeId,
		java.lang.String entryCode, java.lang.String entryName,
		java.lang.String entryDesc, java.lang.String processType,
		java.lang.String processGuide, java.lang.String processTime,
		java.lang.String processFee, java.lang.String processRequirement,
		java.lang.String processFoundationDocument,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTTHCEntry(companyId, groupId, userId, levelId,
			departmentId, categoryId, audienceId, resultTypeId, entryCode,
			entryName, entryDesc, processType, processGuide, processTime,
			processFee, processRequirement, processFoundationDocument,
			serviceContext);
	}

	public static com.portal_egov.portlet.tthc.model.TTHC_Entry updateTTHCEntry(
		long entryId, long companyId, long groupId, long userId, long levelId,
		long departmentId, long categoryId, long audienceId, long resultTypeId,
		java.lang.String entryCode, java.lang.String entryName,
		java.lang.String entryDesc, java.lang.String processGuide,
		java.lang.String processType, java.lang.String processTime,
		java.lang.String processFee, java.lang.String processRequirement,
		java.lang.String processFoundationDocument)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTTHCEntry(entryId, companyId, groupId, userId,
			levelId, departmentId, categoryId, audienceId, resultTypeId,
			entryCode, entryName, entryDesc, processGuide, processType,
			processTime, processFee, processRequirement,
			processFoundationDocument);
	}

	public static void deleteTTHCEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTTHCEntry(entryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TTHC_EntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TTHC_EntryLocalService.class.getName());

			if (invokableLocalService instanceof TTHC_EntryLocalService) {
				_service = (TTHC_EntryLocalService)invokableLocalService;
			}
			else {
				_service = new TTHC_EntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TTHC_EntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TTHC_EntryLocalService service) {
	}

	private static TTHC_EntryLocalService _service;
}