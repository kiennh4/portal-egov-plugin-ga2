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

package com.portal_egov.portlet.legal_faq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LegalFAQEntryLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       LegalFAQEntryLocalService
 * @generated
 */
public class LegalFAQEntryLocalServiceWrapper
	implements LegalFAQEntryLocalService,
		ServiceWrapper<LegalFAQEntryLocalService> {
	public LegalFAQEntryLocalServiceWrapper(
		LegalFAQEntryLocalService legalFAQEntryLocalService) {
		_legalFAQEntryLocalService = legalFAQEntryLocalService;
	}

	/**
	* Adds the legal f a q entry to the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @return the legal f a q entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry addLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.addLegalFAQEntry(legalFAQEntry);
	}

	/**
	* Creates a new legal f a q entry with the primary key. Does not add the legal f a q entry to the database.
	*
	* @param entryId the primary key for the new legal f a q entry
	* @return the new legal f a q entry
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry createLegalFAQEntry(
		long entryId) {
		return _legalFAQEntryLocalService.createLegalFAQEntry(entryId);
	}

	/**
	* Deletes the legal f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry that was removed
	* @throws PortalException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry deleteLegalFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.deleteLegalFAQEntry(entryId);
	}

	/**
	* Deletes the legal f a q entry from the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @return the legal f a q entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry deleteLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.deleteLegalFAQEntry(legalFAQEntry);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalFAQEntryLocalService.dynamicQuery();
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
		return _legalFAQEntryLocalService.dynamicQuery(dynamicQuery);
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
		return _legalFAQEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _legalFAQEntryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _legalFAQEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchLegalFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.fetchLegalFAQEntry(entryId);
	}

	/**
	* Returns the legal f a q entry with the primary key.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry
	* @throws PortalException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry getLegalFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.getLegalFAQEntry(entryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the legal f a q entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of legal f a q entries
	* @param end the upper bound of the range of legal f a q entries (not inclusive)
	* @return the range of legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> getLegalFAQEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.getLegalFAQEntries(start, end);
	}

	/**
	* Returns the number of legal f a q entries.
	*
	* @return the number of legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public int getLegalFAQEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.getLegalFAQEntriesCount();
	}

	/**
	* Updates the legal f a q entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @return the legal f a q entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.updateLegalFAQEntry(legalFAQEntry);
	}

	/**
	* Updates the legal f a q entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @param merge whether to merge the legal f a q entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the legal f a q entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.updateLegalFAQEntry(legalFAQEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _legalFAQEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_legalFAQEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _legalFAQEntryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.countByGroup(groupId);
	}

	public int countByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.countByCategory(groupId, categoryId);
	}

	public int countByCategory(long groupId, long categoryId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.countByCategory(groupId, categoryId,
			publishStatus, status);
	}

	public int countByStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.countByStatus(companyId, status);
	}

	public int countByPublishStatus(long companyId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.countByPublishStatus(companyId,
			publishStatus);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCategory(companyId, categoryId);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCategory(groupId, categoryId,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByStatus(companyId, status);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByStatus(companyId, status,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long companyId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByPublishStatus(companyId,
			publishStatus);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long companyId, int publishStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByPublishStatus(companyId,
			publishStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return _legalFAQEntryLocalService.findByKeyword(groupId, categoryId,
			keyword, start, end, obc);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByKeywordAndStatus(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end) {
		return _legalFAQEntryLocalService.findByKeywordAndStatus(groupId,
			categoryId, keyword, start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByViewCount(
		long groupId, long categoryId, int start, int end) {
		return _legalFAQEntryLocalService.findByViewCount(groupId, categoryId,
			start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long groupId, int entryPublishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCompanyAndStatus(groupId,
			entryPublishStatus, entryStatus);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int entryPublishStatus, int entryStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCompanyAndStatus(companyId,
			entryPublishStatus, entryStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int entryPublishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByGroupAndStatus(groupId,
			entryPublishStatus, entryStatus);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int entryPublishStatus, int entryStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByGroupAndStatus(groupId,
			entryPublishStatus, entryStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long companyId, long categoryId, int entryPublishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCategoryAndStatus(companyId,
			categoryId, entryPublishStatus, entryStatus);
	}

	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long companyId, long categoryId, int entryPublishStatus,
		int entryStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.findByCategoryAndStatus(companyId,
			categoryId, entryPublishStatus, entryStatus, start, end);
	}

	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry getEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.getEntry(entryId);
	}

	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry addFAQEntry(
		long companyId, long groupId, long userId, long categoryId,
		java.lang.String citizenName, java.lang.String citizenPhone,
		java.lang.String citizenEmail, java.lang.String citizenAddress,
		java.util.Date askDate, java.lang.String askTitle,
		java.lang.String askContent, java.util.Date answerDate,
		java.lang.String answerContent, int publishStatus, int entryStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.addFAQEntry(companyId, groupId,
			userId, categoryId, citizenName, citizenPhone, citizenEmail,
			citizenAddress, askDate, askTitle, askContent, answerDate,
			answerContent, publishStatus, entryStatus, serviceContext);
	}

	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateFAQEntry(
		long entryId, long companyId, long groupId, long userId,
		long categoryId, java.lang.String citizenName,
		java.lang.String citizenPhone, java.lang.String citizenEmail,
		java.util.Date askDate, java.lang.String askTitle,
		java.lang.String askContent, java.util.Date answerDate,
		java.lang.String answerContent, int publishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntryLocalService.updateFAQEntry(entryId, companyId,
			groupId, userId, categoryId, citizenName, citizenPhone,
			citizenEmail, askDate, askTitle, askContent, answerDate,
			answerContent, publishStatus, entryStatus);
	}

	/**
	* @todo CAP NHAT CAU TRA LOI
	* @author HungDX
	* @date Jul 7, 2012
	* @return LegalFAQEntry
	* @param entryId
	* @param answerContent
	* @return
	* @throws SystemException
	*/
	public void updateAnswerContent(long entryId, java.util.Date answerDate,
		java.lang.String answerContent, boolean publishEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_legalFAQEntryLocalService.updateAnswerContent(entryId, answerDate,
			answerContent, publishEntry);
	}

	/**
	* @todo PUBLISH FAQ ENTRY
	* @author HungDX
	* @date Jul 7, 2012
	* @return void
	* @param entryId
	* @throws SystemException
	*/
	public void publishFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_legalFAQEntryLocalService.publishFAQEntry(entryId);
	}

	/**
	* @todo TODO
	* @author HungDX
	* @date Jul 7, 2012
	* @return void
	* @param entryId
	* @throws SystemException
	*/
	public void unPublishFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_legalFAQEntryLocalService.unPublishFAQEntry(entryId);
	}

	public void deleteFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_legalFAQEntryLocalService.deleteFAQEntry(entryId);
	}

	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry incrementViewCounter(
		long legalFAQEntryId) {
		return _legalFAQEntryLocalService.incrementViewCounter(legalFAQEntryId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LegalFAQEntryLocalService getWrappedLegalFAQEntryLocalService() {
		return _legalFAQEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLegalFAQEntryLocalService(
		LegalFAQEntryLocalService legalFAQEntryLocalService) {
		_legalFAQEntryLocalService = legalFAQEntryLocalService;
	}

	public LegalFAQEntryLocalService getWrappedService() {
		return _legalFAQEntryLocalService;
	}

	public void setWrappedService(
		LegalFAQEntryLocalService legalFAQEntryLocalService) {
		_legalFAQEntryLocalService = legalFAQEntryLocalService;
	}

	private LegalFAQEntryLocalService _legalFAQEntryLocalService;
}