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

package com.portal_egov.portlet.conversation.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.portal_egov.portlet.conversation.model.CO_Thread;
import com.portal_egov.portlet.conversation.service.CO_CategoryLocalService;
import com.portal_egov.portlet.conversation.service.CO_CategoryService;
import com.portal_egov.portlet.conversation.service.CO_ConversationLocalService;
import com.portal_egov.portlet.conversation.service.CO_ConversationService;
import com.portal_egov.portlet.conversation.service.CO_ThreadLocalService;
import com.portal_egov.portlet.conversation.service.CO_ThreadService;
import com.portal_egov.portlet.conversation.service.persistence.CO_CategoryPersistence;
import com.portal_egov.portlet.conversation.service.persistence.CO_ConversationFinder;
import com.portal_egov.portlet.conversation.service.persistence.CO_ConversationPersistence;
import com.portal_egov.portlet.conversation.service.persistence.CO_ThreadFinder;
import com.portal_egov.portlet.conversation.service.persistence.CO_ThreadPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the c o_ thread local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.conversation.service.impl.CO_ThreadLocalServiceImpl}.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.conversation.service.impl.CO_ThreadLocalServiceImpl
 * @see com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil
 * @generated
 */
public abstract class CO_ThreadLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CO_ThreadLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil} to access the c o_ thread local service.
	 */

	/**
	 * Adds the c o_ thread to the database. Also notifies the appropriate model listeners.
	 *
	 * @param co_Thread the c o_ thread
	 * @return the c o_ thread that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CO_Thread addCO_Thread(CO_Thread co_Thread)
		throws SystemException {
		co_Thread.setNew(true);

		return co_ThreadPersistence.update(co_Thread, false);
	}

	/**
	 * Creates a new c o_ thread with the primary key. Does not add the c o_ thread to the database.
	 *
	 * @param threadId the primary key for the new c o_ thread
	 * @return the new c o_ thread
	 */
	public CO_Thread createCO_Thread(long threadId) {
		return co_ThreadPersistence.create(threadId);
	}

	/**
	 * Deletes the c o_ thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param threadId the primary key of the c o_ thread
	 * @return the c o_ thread that was removed
	 * @throws PortalException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CO_Thread deleteCO_Thread(long threadId)
		throws PortalException, SystemException {
		return co_ThreadPersistence.remove(threadId);
	}

	/**
	 * Deletes the c o_ thread from the database. Also notifies the appropriate model listeners.
	 *
	 * @param co_Thread the c o_ thread
	 * @return the c o_ thread that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public CO_Thread deleteCO_Thread(CO_Thread co_Thread)
		throws SystemException {
		return co_ThreadPersistence.remove(co_Thread);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CO_Thread.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return co_ThreadPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return co_ThreadPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return co_ThreadPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return co_ThreadPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public CO_Thread fetchCO_Thread(long threadId) throws SystemException {
		return co_ThreadPersistence.fetchByPrimaryKey(threadId);
	}

	/**
	 * Returns the c o_ thread with the primary key.
	 *
	 * @param threadId the primary key of the c o_ thread
	 * @return the c o_ thread
	 * @throws PortalException if a c o_ thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CO_Thread getCO_Thread(long threadId)
		throws PortalException, SystemException {
		return co_ThreadPersistence.findByPrimaryKey(threadId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return co_ThreadPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<CO_Thread> getCO_Threads(int start, int end)
		throws SystemException {
		return co_ThreadPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of c o_ threads.
	 *
	 * @return the number of c o_ threads
	 * @throws SystemException if a system exception occurred
	 */
	public int getCO_ThreadsCount() throws SystemException {
		return co_ThreadPersistence.countAll();
	}

	/**
	 * Updates the c o_ thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param co_Thread the c o_ thread
	 * @return the c o_ thread that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CO_Thread updateCO_Thread(CO_Thread co_Thread)
		throws SystemException {
		return updateCO_Thread(co_Thread, true);
	}

	/**
	 * Updates the c o_ thread in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param co_Thread the c o_ thread
	 * @param merge whether to merge the c o_ thread with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the c o_ thread that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CO_Thread updateCO_Thread(CO_Thread co_Thread, boolean merge)
		throws SystemException {
		co_Thread.setNew(false);

		return co_ThreadPersistence.update(co_Thread, merge);
	}

	/**
	 * Returns the c o_ category local service.
	 *
	 * @return the c o_ category local service
	 */
	public CO_CategoryLocalService getCO_CategoryLocalService() {
		return co_CategoryLocalService;
	}

	/**
	 * Sets the c o_ category local service.
	 *
	 * @param co_CategoryLocalService the c o_ category local service
	 */
	public void setCO_CategoryLocalService(
		CO_CategoryLocalService co_CategoryLocalService) {
		this.co_CategoryLocalService = co_CategoryLocalService;
	}

	/**
	 * Returns the c o_ category remote service.
	 *
	 * @return the c o_ category remote service
	 */
	public CO_CategoryService getCO_CategoryService() {
		return co_CategoryService;
	}

	/**
	 * Sets the c o_ category remote service.
	 *
	 * @param co_CategoryService the c o_ category remote service
	 */
	public void setCO_CategoryService(CO_CategoryService co_CategoryService) {
		this.co_CategoryService = co_CategoryService;
	}

	/**
	 * Returns the c o_ category persistence.
	 *
	 * @return the c o_ category persistence
	 */
	public CO_CategoryPersistence getCO_CategoryPersistence() {
		return co_CategoryPersistence;
	}

	/**
	 * Sets the c o_ category persistence.
	 *
	 * @param co_CategoryPersistence the c o_ category persistence
	 */
	public void setCO_CategoryPersistence(
		CO_CategoryPersistence co_CategoryPersistence) {
		this.co_CategoryPersistence = co_CategoryPersistence;
	}

	/**
	 * Returns the c o_ conversation local service.
	 *
	 * @return the c o_ conversation local service
	 */
	public CO_ConversationLocalService getCO_ConversationLocalService() {
		return co_ConversationLocalService;
	}

	/**
	 * Sets the c o_ conversation local service.
	 *
	 * @param co_ConversationLocalService the c o_ conversation local service
	 */
	public void setCO_ConversationLocalService(
		CO_ConversationLocalService co_ConversationLocalService) {
		this.co_ConversationLocalService = co_ConversationLocalService;
	}

	/**
	 * Returns the c o_ conversation remote service.
	 *
	 * @return the c o_ conversation remote service
	 */
	public CO_ConversationService getCO_ConversationService() {
		return co_ConversationService;
	}

	/**
	 * Sets the c o_ conversation remote service.
	 *
	 * @param co_ConversationService the c o_ conversation remote service
	 */
	public void setCO_ConversationService(
		CO_ConversationService co_ConversationService) {
		this.co_ConversationService = co_ConversationService;
	}

	/**
	 * Returns the c o_ conversation persistence.
	 *
	 * @return the c o_ conversation persistence
	 */
	public CO_ConversationPersistence getCO_ConversationPersistence() {
		return co_ConversationPersistence;
	}

	/**
	 * Sets the c o_ conversation persistence.
	 *
	 * @param co_ConversationPersistence the c o_ conversation persistence
	 */
	public void setCO_ConversationPersistence(
		CO_ConversationPersistence co_ConversationPersistence) {
		this.co_ConversationPersistence = co_ConversationPersistence;
	}

	/**
	 * Returns the c o_ conversation finder.
	 *
	 * @return the c o_ conversation finder
	 */
	public CO_ConversationFinder getCO_ConversationFinder() {
		return co_ConversationFinder;
	}

	/**
	 * Sets the c o_ conversation finder.
	 *
	 * @param co_ConversationFinder the c o_ conversation finder
	 */
	public void setCO_ConversationFinder(
		CO_ConversationFinder co_ConversationFinder) {
		this.co_ConversationFinder = co_ConversationFinder;
	}

	/**
	 * Returns the c o_ thread local service.
	 *
	 * @return the c o_ thread local service
	 */
	public CO_ThreadLocalService getCO_ThreadLocalService() {
		return co_ThreadLocalService;
	}

	/**
	 * Sets the c o_ thread local service.
	 *
	 * @param co_ThreadLocalService the c o_ thread local service
	 */
	public void setCO_ThreadLocalService(
		CO_ThreadLocalService co_ThreadLocalService) {
		this.co_ThreadLocalService = co_ThreadLocalService;
	}

	/**
	 * Returns the c o_ thread remote service.
	 *
	 * @return the c o_ thread remote service
	 */
	public CO_ThreadService getCO_ThreadService() {
		return co_ThreadService;
	}

	/**
	 * Sets the c o_ thread remote service.
	 *
	 * @param co_ThreadService the c o_ thread remote service
	 */
	public void setCO_ThreadService(CO_ThreadService co_ThreadService) {
		this.co_ThreadService = co_ThreadService;
	}

	/**
	 * Returns the c o_ thread persistence.
	 *
	 * @return the c o_ thread persistence
	 */
	public CO_ThreadPersistence getCO_ThreadPersistence() {
		return co_ThreadPersistence;
	}

	/**
	 * Sets the c o_ thread persistence.
	 *
	 * @param co_ThreadPersistence the c o_ thread persistence
	 */
	public void setCO_ThreadPersistence(
		CO_ThreadPersistence co_ThreadPersistence) {
		this.co_ThreadPersistence = co_ThreadPersistence;
	}

	/**
	 * Returns the c o_ thread finder.
	 *
	 * @return the c o_ thread finder
	 */
	public CO_ThreadFinder getCO_ThreadFinder() {
		return co_ThreadFinder;
	}

	/**
	 * Sets the c o_ thread finder.
	 *
	 * @param co_ThreadFinder the c o_ thread finder
	 */
	public void setCO_ThreadFinder(CO_ThreadFinder co_ThreadFinder) {
		this.co_ThreadFinder = co_ThreadFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.conversation.model.CO_Thread",
			co_ThreadLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.conversation.model.CO_Thread");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return CO_Thread.class;
	}

	protected String getModelClassName() {
		return CO_Thread.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = co_ThreadPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CO_CategoryLocalService.class)
	protected CO_CategoryLocalService co_CategoryLocalService;
	@BeanReference(type = CO_CategoryService.class)
	protected CO_CategoryService co_CategoryService;
	@BeanReference(type = CO_CategoryPersistence.class)
	protected CO_CategoryPersistence co_CategoryPersistence;
	@BeanReference(type = CO_ConversationLocalService.class)
	protected CO_ConversationLocalService co_ConversationLocalService;
	@BeanReference(type = CO_ConversationService.class)
	protected CO_ConversationService co_ConversationService;
	@BeanReference(type = CO_ConversationPersistence.class)
	protected CO_ConversationPersistence co_ConversationPersistence;
	@BeanReference(type = CO_ConversationFinder.class)
	protected CO_ConversationFinder co_ConversationFinder;
	@BeanReference(type = CO_ThreadLocalService.class)
	protected CO_ThreadLocalService co_ThreadLocalService;
	@BeanReference(type = CO_ThreadService.class)
	protected CO_ThreadService co_ThreadService;
	@BeanReference(type = CO_ThreadPersistence.class)
	protected CO_ThreadPersistence co_ThreadPersistence;
	@BeanReference(type = CO_ThreadFinder.class)
	protected CO_ThreadFinder co_ThreadFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private CO_ThreadLocalServiceClpInvoker _clpInvoker = new CO_ThreadLocalServiceClpInvoker();
}