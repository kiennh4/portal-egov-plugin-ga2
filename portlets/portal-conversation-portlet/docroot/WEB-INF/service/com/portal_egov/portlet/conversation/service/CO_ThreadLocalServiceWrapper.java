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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CO_ThreadLocalService}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_ThreadLocalService
 * @generated
 */
public class CO_ThreadLocalServiceWrapper implements CO_ThreadLocalService,
	ServiceWrapper<CO_ThreadLocalService> {
	public CO_ThreadLocalServiceWrapper(
		CO_ThreadLocalService co_ThreadLocalService) {
		_co_ThreadLocalService = co_ThreadLocalService;
	}

	/**
	* Adds the c o_ thread to the database. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread addCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.addCO_Thread(co_Thread);
	}

	/**
	* Creates a new c o_ thread with the primary key. Does not add the c o_ thread to the database.
	*
	* @param threadId the primary key for the new c o_ thread
	* @return the new c o_ thread
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread createCO_Thread(
		long threadId) {
		return _co_ThreadLocalService.createCO_Thread(threadId);
	}

	/**
	* Deletes the c o_ thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread that was removed
	* @throws PortalException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread deleteCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.deleteCO_Thread(threadId);
	}

	/**
	* Deletes the c o_ thread from the database. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread deleteCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.deleteCO_Thread(co_Thread);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _co_ThreadLocalService.dynamicQuery();
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
		return _co_ThreadLocalService.dynamicQuery(dynamicQuery);
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
		return _co_ThreadLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _co_ThreadLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _co_ThreadLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.conversation.model.CO_Thread fetchCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.fetchCO_Thread(threadId);
	}

	/**
	* Returns the c o_ thread with the primary key.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread
	* @throws PortalException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread getCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.getCO_Thread(threadId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> getCO_Threads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.getCO_Threads(start, end);
	}

	/**
	* Returns the number of c o_ threads.
	*
	* @return the number of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int getCO_ThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.getCO_ThreadsCount();
	}

	/**
	* Updates the c o_ thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread updateCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.updateCO_Thread(co_Thread);
	}

	/**
	* Updates the c o_ thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @param merge whether to merge the c o_ thread with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c o_ thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread updateCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.updateCO_Thread(co_Thread, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _co_ThreadLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_co_ThreadLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _co_ThreadLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByGroup(groupId);
	}

	public int coutByStatusAndCompany(int threadStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.coutByStatusAndCompany(threadStatus,
			companyId);
	}

	public int countByStatusAndGroup(int threadStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByStatusAndGroup(threadStatus,
			groupId);
	}

	public int coutByParentThreadAndCompany(long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.coutByParentThreadAndCompany(parentThreadId,
			companyId);
	}

	public int countByParentThreadAndGroup(long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByParentThreadAndGroup(parentThreadId,
			groupId);
	}

	public int countByParentThreadAndCompanyAndStatus(long parentThreadId,
		long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, threadStatus);
	}

	public int countByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, threadStatus);
	}

	public int coutByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.coutByCategoryAndCompany(categoryId,
			companyId);
	}

	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByCategoryAndGroup(categoryId,
			groupId);
	}

	public int countByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByCategoryAndCompanyAndStatus(categoryId,
			companyId, threadStatus);
	}

	public int countByCategoryAndGroupAndStatus(long categoryId, long groupId,
		int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.countByCategoryAndGroupAndStatus(categoryId,
			groupId, threadStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findAll();
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int threadStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByStatusAndCompany(threadStatus,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int threadStatus, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByStatusAndCompany(threadStatus,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int threadStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByStatusAndGroup(threadStatus, groupId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int threadStatus, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByStatusAndGroup(threadStatus,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndCompany(parentThreadId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndCompany(parentThreadId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndGroup(parentThreadId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndGroup(parentThreadId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, threadStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int threadStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, threadStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, threadStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, threadStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndCompany(categoryId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndCompany(categoryId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndGroup(categoryId, groupId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndGroup(categoryId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndCompanyAndStatus(categoryId,
			companyId, threadStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndCompanyAndStatus(categoryId,
			companyId, threadStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndGroupAndStatus(categoryId,
			groupId, threadStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.findByCategoryAndGroupAndStatus(categoryId,
			groupId, threadStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByKeywordAndStatus(
		long companyId, java.lang.String keyword, int threadStatus) {
		return _co_ThreadLocalService.findByKeywordAndStatus(companyId,
			keyword, threadStatus);
	}

	public com.portal_egov.portlet.conversation.model.CO_Thread addCOThread(
		long companyId, long groupId, long userId, long parentThreadId,
		long categoryId, java.lang.String threadName,
		java.lang.String threadDesc, java.lang.String departmentName,
		java.lang.String participants, java.util.Date startDate,
		java.util.Date endDate, int threadStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.addCOThread(companyId, groupId, userId,
			parentThreadId, categoryId, threadName, threadDesc, departmentName,
			participants, startDate, endDate, threadStatus, serviceContext);
	}

	public com.portal_egov.portlet.conversation.model.CO_Thread updateCOThread(
		long threadId, long companyId, long groupId, long userId,
		long parentThreadId, long categoryId, java.lang.String threadName,
		java.lang.String threadDesc, java.lang.String departmentName,
		java.lang.String participants, java.util.Date startDate,
		java.util.Date endDate, int threadStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.updateCOThread(threadId, companyId,
			groupId, userId, parentThreadId, categoryId, threadName,
			threadDesc, departmentName, participants, startDate, endDate,
			threadStatus);
	}

	public com.portal_egov.portlet.conversation.model.CO_Thread incrementThreadViewCounter(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.incrementThreadViewCounter(threadId);
	}

	public void incrementConversationViewCounter(long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_co_ThreadLocalService.incrementConversationViewCounter(threadId);
	}

	public com.portal_egov.portlet.conversation.model.CO_Thread updateThreadStatus(
		long threadId, long userId, int newThreadStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ThreadLocalService.updateThreadStatus(threadId, userId,
			newThreadStatus);
	}

	public void deleteCOThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_co_ThreadLocalService.deleteCOThread(threadId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CO_ThreadLocalService getWrappedCO_ThreadLocalService() {
		return _co_ThreadLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCO_ThreadLocalService(
		CO_ThreadLocalService co_ThreadLocalService) {
		_co_ThreadLocalService = co_ThreadLocalService;
	}

	public CO_ThreadLocalService getWrappedService() {
		return _co_ThreadLocalService;
	}

	public void setWrappedService(CO_ThreadLocalService co_ThreadLocalService) {
		_co_ThreadLocalService = co_ThreadLocalService;
	}

	private CO_ThreadLocalService _co_ThreadLocalService;
}