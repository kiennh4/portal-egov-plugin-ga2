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

package com.bkav.portal.portlet.complaints.service.base;

import com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries;
import com.bkav.portal.portlet.complaints.service.ComplaintsLocalService;
import com.bkav.portal.portlet.complaints.service.ComplaintsService;
import com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesLocalService;
import com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesService;
import com.bkav.portal.portlet.complaints.service.persistence.ComplaintsFinder;
import com.bkav.portal.portlet.complaints.service.persistence.ComplaintsPersistence;
import com.bkav.portal.portlet.complaints.service.persistence.Complaints_DLFileEntriesPersistence;

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

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the complaints_ d l file entries local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bkav.portal.portlet.complaints.service.impl.Complaints_DLFileEntriesLocalServiceImpl}.
 * </p>
 *
 * @author AnhBDb
 * @see com.bkav.portal.portlet.complaints.service.impl.Complaints_DLFileEntriesLocalServiceImpl
 * @see com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesLocalServiceUtil
 * @generated
 */
public abstract class Complaints_DLFileEntriesLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements Complaints_DLFileEntriesLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bkav.portal.portlet.complaints.service.Complaints_DLFileEntriesLocalServiceUtil} to access the complaints_ d l file entries local service.
	 */

	/**
	 * Adds the complaints_ d l file entries to the database. Also notifies the appropriate model listeners.
	 *
	 * @param complaints_DLFileEntries the complaints_ d l file entries
	 * @return the complaints_ d l file entries that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Complaints_DLFileEntries addComplaints_DLFileEntries(
		Complaints_DLFileEntries complaints_DLFileEntries)
		throws SystemException {
		complaints_DLFileEntries.setNew(true);

		return complaints_DLFileEntriesPersistence.update(complaints_DLFileEntries,
			false);
	}

	/**
	 * Creates a new complaints_ d l file entries with the primary key. Does not add the complaints_ d l file entries to the database.
	 *
	 * @param id the primary key for the new complaints_ d l file entries
	 * @return the new complaints_ d l file entries
	 */
	public Complaints_DLFileEntries createComplaints_DLFileEntries(long id) {
		return complaints_DLFileEntriesPersistence.create(id);
	}

	/**
	 * Deletes the complaints_ d l file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries that was removed
	 * @throws PortalException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Complaints_DLFileEntries deleteComplaints_DLFileEntries(long id)
		throws PortalException, SystemException {
		return complaints_DLFileEntriesPersistence.remove(id);
	}

	/**
	 * Deletes the complaints_ d l file entries from the database. Also notifies the appropriate model listeners.
	 *
	 * @param complaints_DLFileEntries the complaints_ d l file entries
	 * @return the complaints_ d l file entries that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Complaints_DLFileEntries deleteComplaints_DLFileEntries(
		Complaints_DLFileEntries complaints_DLFileEntries)
		throws SystemException {
		return complaints_DLFileEntriesPersistence.remove(complaints_DLFileEntries);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Complaints_DLFileEntries.class,
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
		return complaints_DLFileEntriesPersistence.findWithDynamicQuery(dynamicQuery);
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
		return complaints_DLFileEntriesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
		return complaints_DLFileEntriesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return complaints_DLFileEntriesPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Complaints_DLFileEntries fetchComplaints_DLFileEntries(long id)
		throws SystemException {
		return complaints_DLFileEntriesPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the complaints_ d l file entries with the primary key.
	 *
	 * @param id the primary key of the complaints_ d l file entries
	 * @return the complaints_ d l file entries
	 * @throws PortalException if a complaints_ d l file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaints_DLFileEntries getComplaints_DLFileEntries(long id)
		throws PortalException, SystemException {
		return complaints_DLFileEntriesPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return complaints_DLFileEntriesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the complaints_ d l file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaints_ d l file entrieses
	 * @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	 * @return the range of complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaints_DLFileEntries> getComplaints_DLFileEntrieses(
		int start, int end) throws SystemException {
		return complaints_DLFileEntriesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of complaints_ d l file entrieses.
	 *
	 * @return the number of complaints_ d l file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int getComplaints_DLFileEntriesesCount() throws SystemException {
		return complaints_DLFileEntriesPersistence.countAll();
	}

	/**
	 * Updates the complaints_ d l file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param complaints_DLFileEntries the complaints_ d l file entries
	 * @return the complaints_ d l file entries that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Complaints_DLFileEntries updateComplaints_DLFileEntries(
		Complaints_DLFileEntries complaints_DLFileEntries)
		throws SystemException {
		return updateComplaints_DLFileEntries(complaints_DLFileEntries, true);
	}

	/**
	 * Updates the complaints_ d l file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param complaints_DLFileEntries the complaints_ d l file entries
	 * @param merge whether to merge the complaints_ d l file entries with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the complaints_ d l file entries that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Complaints_DLFileEntries updateComplaints_DLFileEntries(
		Complaints_DLFileEntries complaints_DLFileEntries, boolean merge)
		throws SystemException {
		complaints_DLFileEntries.setNew(false);

		return complaints_DLFileEntriesPersistence.update(complaints_DLFileEntries,
			merge);
	}

	/**
	 * Returns the complaints local service.
	 *
	 * @return the complaints local service
	 */
	public ComplaintsLocalService getComplaintsLocalService() {
		return complaintsLocalService;
	}

	/**
	 * Sets the complaints local service.
	 *
	 * @param complaintsLocalService the complaints local service
	 */
	public void setComplaintsLocalService(
		ComplaintsLocalService complaintsLocalService) {
		this.complaintsLocalService = complaintsLocalService;
	}

	/**
	 * Returns the complaints remote service.
	 *
	 * @return the complaints remote service
	 */
	public ComplaintsService getComplaintsService() {
		return complaintsService;
	}

	/**
	 * Sets the complaints remote service.
	 *
	 * @param complaintsService the complaints remote service
	 */
	public void setComplaintsService(ComplaintsService complaintsService) {
		this.complaintsService = complaintsService;
	}

	/**
	 * Returns the complaints persistence.
	 *
	 * @return the complaints persistence
	 */
	public ComplaintsPersistence getComplaintsPersistence() {
		return complaintsPersistence;
	}

	/**
	 * Sets the complaints persistence.
	 *
	 * @param complaintsPersistence the complaints persistence
	 */
	public void setComplaintsPersistence(
		ComplaintsPersistence complaintsPersistence) {
		this.complaintsPersistence = complaintsPersistence;
	}

	/**
	 * Returns the complaints finder.
	 *
	 * @return the complaints finder
	 */
	public ComplaintsFinder getComplaintsFinder() {
		return complaintsFinder;
	}

	/**
	 * Sets the complaints finder.
	 *
	 * @param complaintsFinder the complaints finder
	 */
	public void setComplaintsFinder(ComplaintsFinder complaintsFinder) {
		this.complaintsFinder = complaintsFinder;
	}

	/**
	 * Returns the complaints_ d l file entries local service.
	 *
	 * @return the complaints_ d l file entries local service
	 */
	public Complaints_DLFileEntriesLocalService getComplaints_DLFileEntriesLocalService() {
		return complaints_DLFileEntriesLocalService;
	}

	/**
	 * Sets the complaints_ d l file entries local service.
	 *
	 * @param complaints_DLFileEntriesLocalService the complaints_ d l file entries local service
	 */
	public void setComplaints_DLFileEntriesLocalService(
		Complaints_DLFileEntriesLocalService complaints_DLFileEntriesLocalService) {
		this.complaints_DLFileEntriesLocalService = complaints_DLFileEntriesLocalService;
	}

	/**
	 * Returns the complaints_ d l file entries remote service.
	 *
	 * @return the complaints_ d l file entries remote service
	 */
	public Complaints_DLFileEntriesService getComplaints_DLFileEntriesService() {
		return complaints_DLFileEntriesService;
	}

	/**
	 * Sets the complaints_ d l file entries remote service.
	 *
	 * @param complaints_DLFileEntriesService the complaints_ d l file entries remote service
	 */
	public void setComplaints_DLFileEntriesService(
		Complaints_DLFileEntriesService complaints_DLFileEntriesService) {
		this.complaints_DLFileEntriesService = complaints_DLFileEntriesService;
	}

	/**
	 * Returns the complaints_ d l file entries persistence.
	 *
	 * @return the complaints_ d l file entries persistence
	 */
	public Complaints_DLFileEntriesPersistence getComplaints_DLFileEntriesPersistence() {
		return complaints_DLFileEntriesPersistence;
	}

	/**
	 * Sets the complaints_ d l file entries persistence.
	 *
	 * @param complaints_DLFileEntriesPersistence the complaints_ d l file entries persistence
	 */
	public void setComplaints_DLFileEntriesPersistence(
		Complaints_DLFileEntriesPersistence complaints_DLFileEntriesPersistence) {
		this.complaints_DLFileEntriesPersistence = complaints_DLFileEntriesPersistence;
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
		PersistedModelLocalServiceRegistryUtil.register("com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries",
			complaints_DLFileEntriesLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries");
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
		return Complaints_DLFileEntries.class;
	}

	protected String getModelClassName() {
		return Complaints_DLFileEntries.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = complaints_DLFileEntriesPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ComplaintsLocalService.class)
	protected ComplaintsLocalService complaintsLocalService;
	@BeanReference(type = ComplaintsService.class)
	protected ComplaintsService complaintsService;
	@BeanReference(type = ComplaintsPersistence.class)
	protected ComplaintsPersistence complaintsPersistence;
	@BeanReference(type = ComplaintsFinder.class)
	protected ComplaintsFinder complaintsFinder;
	@BeanReference(type = Complaints_DLFileEntriesLocalService.class)
	protected Complaints_DLFileEntriesLocalService complaints_DLFileEntriesLocalService;
	@BeanReference(type = Complaints_DLFileEntriesService.class)
	protected Complaints_DLFileEntriesService complaints_DLFileEntriesService;
	@BeanReference(type = Complaints_DLFileEntriesPersistence.class)
	protected Complaints_DLFileEntriesPersistence complaints_DLFileEntriesPersistence;
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
	private Complaints_DLFileEntriesLocalServiceClpInvoker _clpInvoker = new Complaints_DLFileEntriesLocalServiceClpInvoker();
}