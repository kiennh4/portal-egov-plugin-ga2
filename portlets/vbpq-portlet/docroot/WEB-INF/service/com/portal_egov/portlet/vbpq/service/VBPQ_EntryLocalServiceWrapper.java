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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VBPQ_EntryLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       VBPQ_EntryLocalService
 * @generated
 */
public class VBPQ_EntryLocalServiceWrapper implements VBPQ_EntryLocalService,
	ServiceWrapper<VBPQ_EntryLocalService> {
	public VBPQ_EntryLocalServiceWrapper(
		VBPQ_EntryLocalService vbpq_EntryLocalService) {
		_vbpq_EntryLocalService = vbpq_EntryLocalService;
	}

	/**
	* Adds the v b p q_ entry to the database. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @return the v b p q_ entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry addVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.addVBPQ_Entry(vbpq_Entry);
	}

	/**
	* Creates a new v b p q_ entry with the primary key. Does not add the v b p q_ entry to the database.
	*
	* @param entryId the primary key for the new v b p q_ entry
	* @return the new v b p q_ entry
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry createVBPQ_Entry(
		long entryId) {
		return _vbpq_EntryLocalService.createVBPQ_Entry(entryId);
	}

	/**
	* Deletes the v b p q_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry that was removed
	* @throws PortalException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry deleteVBPQ_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.deleteVBPQ_Entry(entryId);
	}

	/**
	* Deletes the v b p q_ entry from the database. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @return the v b p q_ entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry deleteVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.deleteVBPQ_Entry(vbpq_Entry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vbpq_EntryLocalService.dynamicQuery();
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
		return _vbpq_EntryLocalService.dynamicQuery(dynamicQuery);
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
		return _vbpq_EntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _vbpq_EntryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _vbpq_EntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchVBPQ_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.fetchVBPQ_Entry(entryId);
	}

	/**
	* Returns the v b p q_ entry with the primary key.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry
	* @throws PortalException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry getVBPQ_Entry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.getVBPQ_Entry(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> getVBPQ_Entries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.getVBPQ_Entries(start, end);
	}

	/**
	* Returns the number of v b p q_ entries.
	*
	* @return the number of v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int getVBPQ_EntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.getVBPQ_EntriesCount();
	}

	/**
	* Updates the v b p q_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @return the v b p q_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.updateVBPQ_Entry(vbpq_Entry);
	}

	/**
	* Updates the v b p q_ entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vbpq_Entry the v b p q_ entry
	* @param merge whether to merge the v b p q_ entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the v b p q_ entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateVBPQ_Entry(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.updateVBPQ_Entry(vbpq_Entry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vbpq_EntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vbpq_EntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vbpq_EntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.NestableException {
		return _vbpq_EntryLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.countByGroup(groupId);
	}

	public int countByCategoryAndCompany(long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.countByCategoryAndCompany(companyId,
			categoryId);
	}

	public int countByCategoryAndGroup(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.countByCategoryAndGroup(groupId,
			categoryId);
	}

	public int countByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.countByDepartmentAndGroup(groupId,
			departmentId);
	}

	public int countByDocTypeAndGroup(long groupId, long docTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.countByDocTypeAndGroup(groupId, docTypeId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDepartmentAndCompany(departmentId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDepartmentAndCompany(departmentId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDepartmentAndGroup(departmentId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDepartmentAndGroup(departmentId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByCategoryAndCompany(categoryId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByCategoryAndCompany(categoryId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByCategoryAndGroup(categoryId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByCategoryAndGroup(categoryId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDocTypeAndCompany(docTypeId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDocTypeAndCompany(docTypeId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDocTypeAndGroup(docTypeId, groupId);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByDocTypeAndGroup(docTypeId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		long companyId, boolean expiration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByExpirationAndCompany(companyId,
			expiration);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		long groupId, boolean expiration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByExpirationAndGroup(groupId,
			expiration);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByActiveStatusAndCompany(
		long companyId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByActiveStatusAndCompany(companyId,
			active);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByActiveStatusAndGroup(
		long groupId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.findByActiveStatusAndGroup(groupId,
			active);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByKeyword(
		java.lang.String keyword, long groupId, int start, int end) {
		return _vbpq_EntryLocalService.findByKeyword(keyword, groupId, start,
			end);
	}

	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long departmentId,
		long categoryId, long docTypeId, java.lang.String startDate,
		java.lang.String endDate, int expirationStatus, int start, int end) {
		return _vbpq_EntryLocalService.findByMultiCondition(groupId, keyword,
			departmentId, categoryId, docTypeId, startDate, endDate,
			expirationStatus, start, end);
	}

	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry addVBPQEntry(
		long companyId, long groupId, long userId, long departmentId,
		long categoryId, long docTypeId, java.lang.String entryName,
		java.lang.String entryCode, java.lang.String entryDesc,
		java.lang.String publicatorName, java.util.Date publishDate,
		java.util.Date executeDate, java.util.Date expirationDate,
		boolean neverExpired,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_EntryLocalService.addVBPQEntry(companyId, groupId, userId,
			departmentId, categoryId, docTypeId, entryName, entryCode,
			entryDesc, publicatorName, publishDate, executeDate,
			expirationDate, neverExpired, serviceContext);
	}

	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateVBPQEntry(
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
		return _vbpq_EntryLocalService.updateVBPQEntry(entryId, companyId,
			groupId, userId, departmentId, categoryId, docTypeId, entryName,
			entryCode, entryDesc, publicatorName, publishDate,
			vbpqFileAttachmentURL, executeDate, expirationDate, neverExpired,
			serviceContext);
	}

	/**
	* Deactive
	*
	* @param entryId
	* @throws SystemException
	*/
	public void deactiveVBPQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vbpq_EntryLocalService.deactiveVBPQEntry(entryId);
	}

	/**
	* Xoa VBPQ
	*
	* @param entryId
	* @throws SystemException
	* @throws PortalException
	*/
	public void deleteVBPQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vbpq_EntryLocalService.deleteVBPQEntry(entryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VBPQ_EntryLocalService getWrappedVBPQ_EntryLocalService() {
		return _vbpq_EntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVBPQ_EntryLocalService(
		VBPQ_EntryLocalService vbpq_EntryLocalService) {
		_vbpq_EntryLocalService = vbpq_EntryLocalService;
	}

	public VBPQ_EntryLocalService getWrappedService() {
		return _vbpq_EntryLocalService;
	}

	public void setWrappedService(VBPQ_EntryLocalService vbpq_EntryLocalService) {
		_vbpq_EntryLocalService = vbpq_EntryLocalService;
	}

	private VBPQ_EntryLocalService _vbpq_EntryLocalService;
}