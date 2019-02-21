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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the legal f a q entry local service. This utility wraps {@link com.portal_egov.portlet.legal_faq.service.impl.LegalFAQEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see LegalFAQEntryLocalService
 * @see com.portal_egov.portlet.legal_faq.service.base.LegalFAQEntryLocalServiceBaseImpl
 * @see com.portal_egov.portlet.legal_faq.service.impl.LegalFAQEntryLocalServiceImpl
 * @generated
 */
public class LegalFAQEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.legal_faq.service.impl.LegalFAQEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the legal f a q entry to the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @return the legal f a q entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry addLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLegalFAQEntry(legalFAQEntry);
	}

	/**
	* Creates a new legal f a q entry with the primary key. Does not add the legal f a q entry to the database.
	*
	* @param entryId the primary key for the new legal f a q entry
	* @return the new legal f a q entry
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry createLegalFAQEntry(
		long entryId) {
		return getService().createLegalFAQEntry(entryId);
	}

	/**
	* Deletes the legal f a q entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry that was removed
	* @throws PortalException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry deleteLegalFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegalFAQEntry(entryId);
	}

	/**
	* Deletes the legal f a q entry from the database. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @return the legal f a q entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry deleteLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLegalFAQEntry(legalFAQEntry);
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

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry fetchLegalFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLegalFAQEntry(entryId);
	}

	/**
	* Returns the legal f a q entry with the primary key.
	*
	* @param entryId the primary key of the legal f a q entry
	* @return the legal f a q entry
	* @throws PortalException if a legal f a q entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry getLegalFAQEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegalFAQEntry(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> getLegalFAQEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegalFAQEntries(start, end);
	}

	/**
	* Returns the number of legal f a q entries.
	*
	* @return the number of legal f a q entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getLegalFAQEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLegalFAQEntriesCount();
	}

	/**
	* Updates the legal f a q entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @return the legal f a q entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLegalFAQEntry(legalFAQEntry);
	}

	/**
	* Updates the legal f a q entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param legalFAQEntry the legal f a q entry
	* @param merge whether to merge the legal f a q entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the legal f a q entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateLegalFAQEntry(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLegalFAQEntry(legalFAQEntry, merge);
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

	public static int countByCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategory(groupId, categoryId);
	}

	public static int countByCategory(long groupId, long categoryId,
		int publishStatus, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCategory(groupId, categoryId, publishStatus, status);
	}

	public static int countByStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatus(companyId, status);
	}

	public static int countByPublishStatus(long companyId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByPublishStatus(companyId, publishStatus);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long companyId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(companyId, categoryId);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategory(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategory(groupId, categoryId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus(companyId, status);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByStatus(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus(companyId, status, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long companyId, int publishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPublishStatus(companyId, publishStatus);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByPublishStatus(
		long companyId, int publishStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByPublishStatus(companyId, publishStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByKeywordAndStatus(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end) {
		return getService()
				   .findByKeywordAndStatus(groupId, categoryId, keyword, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByViewCount(
		long groupId, long categoryId, int start, int end) {
		return getService().findByViewCount(groupId, categoryId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long groupId, int entryPublishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCompanyAndStatus(groupId, entryPublishStatus,
			entryStatus);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCompanyAndStatus(
		long companyId, int entryPublishStatus, int entryStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCompanyAndStatus(companyId, entryPublishStatus,
			entryStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int entryPublishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupAndStatus(groupId, entryPublishStatus,
			entryStatus);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByGroupAndStatus(
		long groupId, int entryPublishStatus, int entryStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByGroupAndStatus(groupId, entryPublishStatus,
			entryStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long companyId, long categoryId, int entryPublishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndStatus(companyId, categoryId,
			entryPublishStatus, entryStatus);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByCategoryAndStatus(
		long companyId, long categoryId, int entryPublishStatus,
		int entryStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndStatus(companyId, categoryId,
			entryPublishStatus, entryStatus, start, end);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry getEntry(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEntry(entryId);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry addFAQEntry(
		long companyId, long groupId, long userId, long categoryId,
		java.lang.String citizenName, java.lang.String citizenPhone,
		java.lang.String citizenEmail, java.lang.String citizenAddress,
		java.util.Date askDate, java.lang.String askTitle,
		java.lang.String askContent, java.util.Date answerDate,
		java.lang.String answerContent, int publishStatus, int entryStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFAQEntry(companyId, groupId, userId, categoryId,
			citizenName, citizenPhone, citizenEmail, citizenAddress, askDate,
			askTitle, askContent, answerDate, answerContent, publishStatus,
			entryStatus, serviceContext);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry updateFAQEntry(
		long entryId, long companyId, long groupId, long userId,
		long categoryId, java.lang.String citizenName,
		java.lang.String citizenPhone, java.lang.String citizenEmail,
		java.util.Date askDate, java.lang.String askTitle,
		java.lang.String askContent, java.util.Date answerDate,
		java.lang.String answerContent, int publishStatus, int entryStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFAQEntry(entryId, companyId, groupId, userId,
			categoryId, citizenName, citizenPhone, citizenEmail, askDate,
			askTitle, askContent, answerDate, answerContent, publishStatus,
			entryStatus);
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
	public static void updateAnswerContent(long entryId,
		java.util.Date answerDate, java.lang.String answerContent,
		boolean publishEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAnswerContent(entryId, answerDate, answerContent,
			publishEntry);
	}

	/**
	* @todo PUBLISH FAQ ENTRY
	* @author HungDX
	* @date Jul 7, 2012
	* @return void
	* @param entryId
	* @throws SystemException
	*/
	public static void publishFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().publishFAQEntry(entryId);
	}

	/**
	* @todo TODO
	* @author HungDX
	* @date Jul 7, 2012
	* @return void
	* @param entryId
	* @throws SystemException
	*/
	public static void unPublishFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().unPublishFAQEntry(entryId);
	}

	public static void deleteFAQEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFAQEntry(entryId);
	}

	public static com.portal_egov.portlet.legal_faq.model.LegalFAQEntry incrementViewCounter(
		long legalFAQEntryId) {
		return getService().incrementViewCounter(legalFAQEntryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LegalFAQEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LegalFAQEntryLocalService.class.getName());

			if (invokableLocalService instanceof LegalFAQEntryLocalService) {
				_service = (LegalFAQEntryLocalService)invokableLocalService;
			}
			else {
				_service = new LegalFAQEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LegalFAQEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LegalFAQEntryLocalService service) {
	}

	private static LegalFAQEntryLocalService _service;
}