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

package com.portal_egov.portlet.weblinks.service.base;

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

import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalService;
import com.portal_egov.portlet.weblinks.service.WeblinkCategoryService;
import com.portal_egov.portlet.weblinks.service.WeblinkLocalService;
import com.portal_egov.portlet.weblinks.service.WeblinkService;
import com.portal_egov.portlet.weblinks.service.persistence.WeblinkCategoryFinder;
import com.portal_egov.portlet.weblinks.service.persistence.WeblinkCategoryPersistence;
import com.portal_egov.portlet.weblinks.service.persistence.WeblinkFinder;
import com.portal_egov.portlet.weblinks.service.persistence.WeblinkPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the weblink local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.weblinks.service.impl.WeblinkLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.weblinks.service.impl.WeblinkLocalServiceImpl
 * @see com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil
 * @generated
 */
public abstract class WeblinkLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements WeblinkLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil} to access the weblink local service.
	 */

	/**
	 * Adds the weblink to the database. Also notifies the appropriate model listeners.
	 *
	 * @param weblink the weblink
	 * @return the weblink that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Weblink addWeblink(Weblink weblink) throws SystemException {
		weblink.setNew(true);

		return weblinkPersistence.update(weblink, false);
	}

	/**
	 * Creates a new weblink with the primary key. Does not add the weblink to the database.
	 *
	 * @param weblinkId the primary key for the new weblink
	 * @return the new weblink
	 */
	public Weblink createWeblink(long weblinkId) {
		return weblinkPersistence.create(weblinkId);
	}

	/**
	 * Deletes the weblink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param weblinkId the primary key of the weblink
	 * @return the weblink that was removed
	 * @throws PortalException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Weblink deleteWeblink(long weblinkId)
		throws PortalException, SystemException {
		return weblinkPersistence.remove(weblinkId);
	}

	/**
	 * Deletes the weblink from the database. Also notifies the appropriate model listeners.
	 *
	 * @param weblink the weblink
	 * @return the weblink that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Weblink deleteWeblink(Weblink weblink) throws SystemException {
		return weblinkPersistence.remove(weblink);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Weblink.class,
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
		return weblinkPersistence.findWithDynamicQuery(dynamicQuery);
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
		return weblinkPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
		return weblinkPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return weblinkPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Weblink fetchWeblink(long weblinkId) throws SystemException {
		return weblinkPersistence.fetchByPrimaryKey(weblinkId);
	}

	/**
	 * Returns the weblink with the primary key.
	 *
	 * @param weblinkId the primary key of the weblink
	 * @return the weblink
	 * @throws PortalException if a weblink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Weblink getWeblink(long weblinkId)
		throws PortalException, SystemException {
		return weblinkPersistence.findByPrimaryKey(weblinkId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return weblinkPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the weblinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of weblinks
	 * @param end the upper bound of the range of weblinks (not inclusive)
	 * @return the range of weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Weblink> getWeblinks(int start, int end)
		throws SystemException {
		return weblinkPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of weblinks.
	 *
	 * @return the number of weblinks
	 * @throws SystemException if a system exception occurred
	 */
	public int getWeblinksCount() throws SystemException {
		return weblinkPersistence.countAll();
	}

	/**
	 * Updates the weblink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param weblink the weblink
	 * @return the weblink that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Weblink updateWeblink(Weblink weblink) throws SystemException {
		return updateWeblink(weblink, true);
	}

	/**
	 * Updates the weblink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param weblink the weblink
	 * @param merge whether to merge the weblink with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the weblink that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Weblink updateWeblink(Weblink weblink, boolean merge)
		throws SystemException {
		weblink.setNew(false);

		return weblinkPersistence.update(weblink, merge);
	}

	/**
	 * Returns the weblink local service.
	 *
	 * @return the weblink local service
	 */
	public WeblinkLocalService getWeblinkLocalService() {
		return weblinkLocalService;
	}

	/**
	 * Sets the weblink local service.
	 *
	 * @param weblinkLocalService the weblink local service
	 */
	public void setWeblinkLocalService(WeblinkLocalService weblinkLocalService) {
		this.weblinkLocalService = weblinkLocalService;
	}

	/**
	 * Returns the weblink remote service.
	 *
	 * @return the weblink remote service
	 */
	public WeblinkService getWeblinkService() {
		return weblinkService;
	}

	/**
	 * Sets the weblink remote service.
	 *
	 * @param weblinkService the weblink remote service
	 */
	public void setWeblinkService(WeblinkService weblinkService) {
		this.weblinkService = weblinkService;
	}

	/**
	 * Returns the weblink persistence.
	 *
	 * @return the weblink persistence
	 */
	public WeblinkPersistence getWeblinkPersistence() {
		return weblinkPersistence;
	}

	/**
	 * Sets the weblink persistence.
	 *
	 * @param weblinkPersistence the weblink persistence
	 */
	public void setWeblinkPersistence(WeblinkPersistence weblinkPersistence) {
		this.weblinkPersistence = weblinkPersistence;
	}

	/**
	 * Returns the weblink finder.
	 *
	 * @return the weblink finder
	 */
	public WeblinkFinder getWeblinkFinder() {
		return weblinkFinder;
	}

	/**
	 * Sets the weblink finder.
	 *
	 * @param weblinkFinder the weblink finder
	 */
	public void setWeblinkFinder(WeblinkFinder weblinkFinder) {
		this.weblinkFinder = weblinkFinder;
	}

	/**
	 * Returns the weblink category local service.
	 *
	 * @return the weblink category local service
	 */
	public WeblinkCategoryLocalService getWeblinkCategoryLocalService() {
		return weblinkCategoryLocalService;
	}

	/**
	 * Sets the weblink category local service.
	 *
	 * @param weblinkCategoryLocalService the weblink category local service
	 */
	public void setWeblinkCategoryLocalService(
		WeblinkCategoryLocalService weblinkCategoryLocalService) {
		this.weblinkCategoryLocalService = weblinkCategoryLocalService;
	}

	/**
	 * Returns the weblink category remote service.
	 *
	 * @return the weblink category remote service
	 */
	public WeblinkCategoryService getWeblinkCategoryService() {
		return weblinkCategoryService;
	}

	/**
	 * Sets the weblink category remote service.
	 *
	 * @param weblinkCategoryService the weblink category remote service
	 */
	public void setWeblinkCategoryService(
		WeblinkCategoryService weblinkCategoryService) {
		this.weblinkCategoryService = weblinkCategoryService;
	}

	/**
	 * Returns the weblink category persistence.
	 *
	 * @return the weblink category persistence
	 */
	public WeblinkCategoryPersistence getWeblinkCategoryPersistence() {
		return weblinkCategoryPersistence;
	}

	/**
	 * Sets the weblink category persistence.
	 *
	 * @param weblinkCategoryPersistence the weblink category persistence
	 */
	public void setWeblinkCategoryPersistence(
		WeblinkCategoryPersistence weblinkCategoryPersistence) {
		this.weblinkCategoryPersistence = weblinkCategoryPersistence;
	}

	/**
	 * Returns the weblink category finder.
	 *
	 * @return the weblink category finder
	 */
	public WeblinkCategoryFinder getWeblinkCategoryFinder() {
		return weblinkCategoryFinder;
	}

	/**
	 * Sets the weblink category finder.
	 *
	 * @param weblinkCategoryFinder the weblink category finder
	 */
	public void setWeblinkCategoryFinder(
		WeblinkCategoryFinder weblinkCategoryFinder) {
		this.weblinkCategoryFinder = weblinkCategoryFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.weblinks.model.Weblink",
			weblinkLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.weblinks.model.Weblink");
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
		return Weblink.class;
	}

	protected String getModelClassName() {
		return Weblink.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = weblinkPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = WeblinkLocalService.class)
	protected WeblinkLocalService weblinkLocalService;
	@BeanReference(type = WeblinkService.class)
	protected WeblinkService weblinkService;
	@BeanReference(type = WeblinkPersistence.class)
	protected WeblinkPersistence weblinkPersistence;
	@BeanReference(type = WeblinkFinder.class)
	protected WeblinkFinder weblinkFinder;
	@BeanReference(type = WeblinkCategoryLocalService.class)
	protected WeblinkCategoryLocalService weblinkCategoryLocalService;
	@BeanReference(type = WeblinkCategoryService.class)
	protected WeblinkCategoryService weblinkCategoryService;
	@BeanReference(type = WeblinkCategoryPersistence.class)
	protected WeblinkCategoryPersistence weblinkCategoryPersistence;
	@BeanReference(type = WeblinkCategoryFinder.class)
	protected WeblinkCategoryFinder weblinkCategoryFinder;
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
	private WeblinkLocalServiceClpInvoker _clpInvoker = new WeblinkLocalServiceClpInvoker();
}