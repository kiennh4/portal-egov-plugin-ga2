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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TTHC_EntryLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_EntryLocalService
 * @generated
 */
public class TTHC_EntryLocalServiceWrapper implements TTHC_EntryLocalService,
	ServiceWrapper<TTHC_EntryLocalService> {
	public TTHC_EntryLocalServiceWrapper(
		TTHC_EntryLocalService tthc_EntryLocalService) {
		_tthc_EntryLocalService = tthc_EntryLocalService;
	}

	/**
	* Adds the t t h c_ entry to the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @return the t t h c_ entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry addTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.addTTHC_Entry(tthc_Entry);
	}

	/**
	* Creates a new t t h c_ entry with the primary key. Does not add the t t h c_ entry to the database.
	*
	* @param entryId the primary key for the new t t h c_ entry
	* @return the new t t h c_ entry
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry createTTHC_Entry(
		long entryId) {
		return _tthc_EntryLocalService.createTTHC_Entry(entryId);
	}

	/**
	* Deletes the t t h c_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry that was removed
	* @throws PortalException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry deleteTTHC_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.deleteTTHC_Entry(entryId);
	}

	/**
	* Deletes the t t h c_ entry from the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @return the t t h c_ entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry deleteTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.deleteTTHC_Entry(tthc_Entry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tthc_EntryLocalService.dynamicQuery();
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
		return _tthc_EntryLocalService.dynamicQuery(dynamicQuery);
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
		return _tthc_EntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _tthc_EntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _tthc_EntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchTTHC_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.fetchTTHC_Entry(entryId);
	}

	/**
	* Returns the t t h c_ entry with the primary key.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry
	* @throws PortalException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry getTTHC_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.getTTHC_Entry(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> getTTHC_Entries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.getTTHC_Entries(start, end);
	}

	/**
	* Returns the number of t t h c_ entries.
	*
	* @return the number of t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int getTTHC_EntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.getTTHC_EntriesCount();
	}

	/**
	* Updates the t t h c_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @return the t t h c_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry updateTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.updateTTHC_Entry(tthc_Entry);
	}

	/**
	* Updates the t t h c_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Entry the t t h c_ entry
	* @param merge whether to merge the t t h c_ entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the t t h c_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry updateTTHC_Entry(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.updateTTHC_Entry(tthc_Entry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tthc_EntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tthc_EntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tthc_EntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByGroup(groupId);
	}

	public int countByLevelAndCompany(long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByLevelAndCompany(levelId, companyId);
	}

	public int countByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByLevelAndGroup(levelId, groupId);
	}

	public int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByCategoryAndCompany(categoryId,
			companyId);
	}

	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByCategoryAndGroup(categoryId,
			groupId);
	}

	public int countByDepartment(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByDepartment(departmentId, groupId);
	}

	public int countByAudience(long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByAudience(audienceId, groupId);
	}

	public int countByResultType(long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.countByResultType(resultTypeId, groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByLevelAndCompany(levelId, companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByLevelAndCompany(levelId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByLevelAndGroup(levelId, groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByLevelAndGroup(levelId, groupId,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByDepartmentAndCompany(departmentId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByDepartmentAndCompany(departmentId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByDepartmentAndGroup(departmentId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByDepartmentAndGroup(departmentId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByCategoryAndCompany(categoryId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByCategoryAndCompany(categoryId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByCategoryAndGroup(categoryId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByCategoryAndGroup(categoryId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByAudienceAndCompany(audienceId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByAudienceAndCompany(audienceId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByAudienceAndGroup(audienceId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByAudienceAndGroup(audienceId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByResultTypeAndCompany(resultTypeId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByResultTypeAndCompany(resultTypeId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByResultTypeAndGroup(resultTypeId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.findByResultTypeAndGroup(resultTypeId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return _tthc_EntryLocalService.findByKeyword(groupId, keyword, start,
			end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long levelId,
		long departmentId, long categoryId, long audienceId, long resultTypeId,
		int start, int end) {
		return _tthc_EntryLocalService.findByMultiCondition(groupId, keyword,
			levelId, departmentId, categoryId, audienceId, resultTypeId, start,
			end);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Entry getTTHCEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.getTTHCEntry(entryId);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Entry addTTHCEntry(
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
		return _tthc_EntryLocalService.addTTHCEntry(companyId, groupId, userId,
			levelId, departmentId, categoryId, audienceId, resultTypeId,
			entryCode, entryName, entryDesc, processType, processGuide,
			processTime, processFee, processRequirement,
			processFoundationDocument, serviceContext);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Entry updateTTHCEntry(
		long entryId, long companyId, long groupId, long userId, long levelId,
		long departmentId, long categoryId, long audienceId, long resultTypeId,
		java.lang.String entryCode, java.lang.String entryName,
		java.lang.String entryDesc, java.lang.String processGuide,
		java.lang.String processType, java.lang.String processTime,
		java.lang.String processFee, java.lang.String processRequirement,
		java.lang.String processFoundationDocument)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_EntryLocalService.updateTTHCEntry(entryId, companyId,
			groupId, userId, levelId, departmentId, categoryId, audienceId,
			resultTypeId, entryCode, entryName, entryDesc, processGuide,
			processType, processTime, processFee, processRequirement,
			processFoundationDocument);
	}

	public void deleteTTHCEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tthc_EntryLocalService.deleteTTHCEntry(entryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TTHC_EntryLocalService getWrappedTTHC_EntryLocalService() {
		return _tthc_EntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTTHC_EntryLocalService(
		TTHC_EntryLocalService tthc_EntryLocalService) {
		_tthc_EntryLocalService = tthc_EntryLocalService;
	}

	public TTHC_EntryLocalService getWrappedService() {
		return _tthc_EntryLocalService;
	}

	public void setWrappedService(TTHC_EntryLocalService tthc_EntryLocalService) {
		_tthc_EntryLocalService = tthc_EntryLocalService;
	}

	private TTHC_EntryLocalService _tthc_EntryLocalService;
}