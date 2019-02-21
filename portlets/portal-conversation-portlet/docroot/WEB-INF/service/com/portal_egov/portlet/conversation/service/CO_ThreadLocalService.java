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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the c o_ thread local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see CO_ThreadLocalServiceUtil
 * @see com.portal_egov.portlet.conversation.service.base.CO_ThreadLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.impl.CO_ThreadLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CO_ThreadLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CO_ThreadLocalServiceUtil} to access the c o_ thread local service. Add custom service methods to {@link com.portal_egov.portlet.conversation.service.impl.CO_ThreadLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the c o_ thread to the database. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread addCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new c o_ thread with the primary key. Does not add the c o_ thread to the database.
	*
	* @param threadId the primary key for the new c o_ thread
	* @return the new c o_ thread
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread createCO_Thread(
		long threadId);

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
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the c o_ thread from the database. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread deleteCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ thread with the primary key.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread
	* @throws PortalException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.conversation.model.CO_Thread getCO_Thread(
		long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> getCO_Threads(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads.
	*
	* @return the number of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCO_ThreadsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the c o_ thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Thread the c o_ thread
	* @return the c o_ thread that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread updateCO_Thread(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int coutByStatusAndCompany(int threadStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByStatusAndGroup(int threadStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int coutByParentThreadAndCompany(long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByParentThreadAndGroup(long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByParentThreadAndCompanyAndStatus(long parentThreadId,
		long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int coutByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCategoryAndGroupAndStatus(long categoryId, long groupId,
		int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int threadStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int threadStatus, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int threadStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int threadStatus, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int threadStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int threadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int threadStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByKeywordAndStatus(
		long companyId, java.lang.String keyword, int threadStatus);

	public com.portal_egov.portlet.conversation.model.CO_Thread addCOThread(
		long companyId, long groupId, long userId, long parentThreadId,
		long categoryId, java.lang.String threadName,
		java.lang.String threadDesc, java.lang.String departmentName,
		java.lang.String participants, java.util.Date startDate,
		java.util.Date endDate, int threadStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.conversation.model.CO_Thread updateCOThread(
		long threadId, long companyId, long groupId, long userId,
		long parentThreadId, long categoryId, java.lang.String threadName,
		java.lang.String threadDesc, java.lang.String departmentName,
		java.lang.String participants, java.util.Date startDate,
		java.util.Date endDate, int threadStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.conversation.model.CO_Thread incrementThreadViewCounter(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void incrementConversationViewCounter(long threadId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.conversation.model.CO_Thread updateThreadStatus(
		long threadId, long userId, int newThreadStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteCOThread(long threadId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}