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

package com.portal_egov.portlet.conversation.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the c o_ thread local service. This utility wraps {@link com.portal_egov.portlet.conversation.service.impl.CO_ThreadLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see CO_ThreadLocalService
 * @see com.portal_egov.portlet.conversation.service.base.CO_ThreadLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.impl.CO_ThreadLocalServiceImpl
 * @generated
 */
public class CO_ThreadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.conversation.service.impl.CO_ThreadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the c o_ thread to the database. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread addCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCO_Thread(co_Thread);
	}

	/**
	* Creates a new c o_ thread with the primary key. Does not add the c o_ thread to the database.
	*
	* @param threadId the primary key for the new c o_ thread
	* @return the new c o_ thread
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread createCO_Thread(
		long threadId) {
		return getService().createCO_Thread(threadId);
	}

	/**
	* Deletes the c o_ thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread that was removed
	* @throws PortalException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread deleteCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCO_Thread(threadId);
	}

	/**
	* Deletes the c o_ thread from the database. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread deleteCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCO_Thread(co_Thread);
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

	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCO_Thread(threadId);
	}

	/**
	* Returns the c o_ thread with the primary key.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread
	* @throws PortalException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread getCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_Thread(threadId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the c o_ threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> getCO_Threads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_Threads(start, end);
	}

	/**
	* Returns the number of c o_ threads.
	*
	* @return the number of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int getCO_ThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_ThreadsCount();
	}

	/**
	* Updates the c o_ thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread updateCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCO_Thread(co_Thread);
	}

	/**
	* Updates the c o_ thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @param merge whether to merge the c o_ thread with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c o_ thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread updateCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCO_Thread(co_Thread, merge);
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

	public static int coutByStatusAndCompany(int threadStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().coutByStatusAndCompany(threadStatus, companyId);
	}

	public static int countByStatusAndGroup(int threadStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatusAndGroup(threadStatus, groupId);
	}

	public static int coutByParentThreadAndCompany(long parentThreadId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .coutByParentThreadAndCompany(parentThreadId, companyId);
	}

	public static int countByParentThreadAndGroup(long parentThreadId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByParentThreadAndGroup(parentThreadId, groupId);
	}

	public static int countByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, threadStatus);
	}

	public static int countByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, threadStatus);
	}

	public static int coutByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().coutByCategoryAndCompany(categoryId, companyId);
	}

	public static int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryAndGroup(categoryId, groupId);
	}

	public static int countByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCategoryAndCompanyAndStatus(categoryId, companyId,
			threadStatus);
	}

	public static int countByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByCategoryAndGroupAndStatus(categoryId, groupId,
			threadStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int threadStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndCompany(threadStatus, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int threadStatus, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByStatusAndCompany(threadStatus, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int threadStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndGroup(threadStatus, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int threadStatus, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByStatusAndGroup(threadStatus, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentThreadAndCompany(parentThreadId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentThreadAndCompany(parentThreadId, companyId,
			start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParentThreadAndGroup(parentThreadId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentThreadAndGroup(parentThreadId, groupId, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, threadStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int threadStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, threadStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, threadStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, threadStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndCompany(categoryId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndCompany(categoryId, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryAndGroup(categoryId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndGroup(categoryId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndCompanyAndStatus(categoryId, companyId,
			threadStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndCompanyAndStatus(categoryId, companyId,
			threadStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndGroupAndStatus(categoryId, groupId,
			threadStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByCategoryAndGroupAndStatus(categoryId, groupId,
			threadStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByKeywordAndStatus(
		long companyId, java.lang.String keyword, int threadStatus) {
		return getService()
				   .findByKeywordAndStatus(companyId, keyword, threadStatus);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Thread addCOThread(
		long companyId, long groupId, long userId, long parentThreadId,
		long categoryId, java.lang.String threadName,
		java.lang.String threadDesc, java.lang.String departmentName,
		java.lang.String participants, java.util.Date startDate,
		java.util.Date endDate, int threadStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCOThread(companyId, groupId, userId, parentThreadId,
			categoryId, threadName, threadDesc, departmentName, participants,
			startDate, endDate, threadStatus, serviceContext);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Thread updateCOThread(
		long threadId, long companyId, long groupId, long userId,
		long parentThreadId, long categoryId, java.lang.String threadName,
		java.lang.String threadDesc, java.lang.String departmentName,
		java.lang.String participants, java.util.Date startDate,
		java.util.Date endDate, int threadStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCOThread(threadId, companyId, groupId, userId,
			parentThreadId, categoryId, threadName, threadDesc, departmentName,
			participants, startDate, endDate, threadStatus);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Thread incrementThreadViewCounter(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().incrementThreadViewCounter(threadId);
	}

	public static void incrementConversationViewCounter(long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().incrementConversationViewCounter(threadId);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Thread updateThreadStatus(
		long threadId, long userId, int newThreadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateThreadStatus(threadId, userId, newThreadStatus);
	}

	public static void deleteCOThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCOThread(threadId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CO_ThreadLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CO_ThreadLocalService.class.getName());

			if (invokableLocalService instanceof CO_ThreadLocalService) {
				_service = (CO_ThreadLocalService)invokableLocalService;
			}
			else {
				_service = new CO_ThreadLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CO_ThreadLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CO_ThreadLocalService service) {
	}

	private static CO_ThreadLocalService _service;
}