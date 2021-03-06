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

package com.portal_egov.portlet.compaints.service.base;

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

import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;
import com.portal_egov.portlet.compaints.service.ComplaintLocalService;
import com.portal_egov.portlet.compaints.service.ComplaintService;
import com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalService;
import com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesService;
import com.portal_egov.portlet.compaints.service.persistence.ComplaintFinder;
import com.portal_egov.portlet.compaints.service.persistence.ComplaintPersistence;
import com.portal_egov.portlet.compaints.service.persistence.Complaint_DlFileEntriesPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the complaint_ dl file entries local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.compaints.service.impl.Complaint_DlFileEntriesLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.compaints.service.impl.Complaint_DlFileEntriesLocalServiceImpl
 * @see com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalServiceUtil
 * @generated
 */
public abstract class Complaint_DlFileEntriesLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements Complaint_DlFileEntriesLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalServiceUtil} to access the complaint_ dl file entries local service.
	 */

	/**
	 * Adds the complaint_ dl file entries to the database. Also notifies the appropriate model listeners.
	 *
	 * @param complaint_DlFileEntries the complaint_ dl file entries
	 * @return the complaint_ dl file entries that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Complaint_DlFileEntries addComplaint_DlFileEntries(
		Complaint_DlFileEntries complaint_DlFileEntries)
		throws SystemException {
		complaint_DlFileEntries.setNew(true);

		return complaint_DlFileEntriesPersistence.update(complaint_DlFileEntries,
			false);
	}

	/**
	 * Creates a new complaint_ dl file entries with the primary key. Does not add the complaint_ dl file entries to the database.
	 *
	 * @param id the primary key for the new complaint_ dl file entries
	 * @return the new complaint_ dl file entries
	 */
	public Complaint_DlFileEntries createComplaint_DlFileEntries(long id) {
		return complaint_DlFileEntriesPersistence.create(id);
	}

	/**
	 * Deletes the complaint_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries that was removed
	 * @throws PortalException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Complaint_DlFileEntries deleteComplaint_DlFileEntries(long id)
		throws PortalException, SystemException {
		return complaint_DlFileEntriesPersistence.remove(id);
	}

	/**
	 * Deletes the complaint_ dl file entries from the database. Also notifies the appropriate model listeners.
	 *
	 * @param complaint_DlFileEntries the complaint_ dl file entries
	 * @return the complaint_ dl file entries that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Complaint_DlFileEntries deleteComplaint_DlFileEntries(
		Complaint_DlFileEntries complaint_DlFileEntries)
		throws SystemException {
		return complaint_DlFileEntriesPersistence.remove(complaint_DlFileEntries);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Complaint_DlFileEntries.class,
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
		return complaint_DlFileEntriesPersistence.findWithDynamicQuery(dynamicQuery);
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
		return complaint_DlFileEntriesPersistence.findWithDynamicQuery(dynamicQuery,
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
		return complaint_DlFileEntriesPersistence.findWithDynamicQuery(dynamicQuery,
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
		return complaint_DlFileEntriesPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Complaint_DlFileEntries fetchComplaint_DlFileEntries(long id)
		throws SystemException {
		return complaint_DlFileEntriesPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the complaint_ dl file entries with the primary key.
	 *
	 * @param id the primary key of the complaint_ dl file entries
	 * @return the complaint_ dl file entries
	 * @throws PortalException if a complaint_ dl file entries with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Complaint_DlFileEntries getComplaint_DlFileEntries(long id)
		throws PortalException, SystemException {
		return complaint_DlFileEntriesPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return complaint_DlFileEntriesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the complaint_ dl file entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint_ dl file entrieses
	 * @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	 * @return the range of complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Complaint_DlFileEntries> getComplaint_DlFileEntrieses(
		int start, int end) throws SystemException {
		return complaint_DlFileEntriesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of complaint_ dl file entrieses.
	 *
	 * @return the number of complaint_ dl file entrieses
	 * @throws SystemException if a system exception occurred
	 */
	public int getComplaint_DlFileEntriesesCount() throws SystemException {
		return complaint_DlFileEntriesPersistence.countAll();
	}

	/**
	 * Updates the complaint_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param complaint_DlFileEntries the complaint_ dl file entries
	 * @return the complaint_ dl file entries that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Complaint_DlFileEntries updateComplaint_DlFileEntries(
		Complaint_DlFileEntries complaint_DlFileEntries)
		throws SystemException {
		return updateComplaint_DlFileEntries(complaint_DlFileEntries, true);
	}

	/**
	 * Updates the complaint_ dl file entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param complaint_DlFileEntries the complaint_ dl file entries
	 * @param merge whether to merge the complaint_ dl file entries with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the complaint_ dl file entries that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Complaint_DlFileEntries updateComplaint_DlFileEntries(
		Complaint_DlFileEntries complaint_DlFileEntries, boolean merge)
		throws SystemException {
		complaint_DlFileEntries.setNew(false);

		return complaint_DlFileEntriesPersistence.update(complaint_DlFileEntries,
			merge);
	}

	/**
	 * Returns the complaint local service.
	 *
	 * @return the complaint local service
	 */
	public ComplaintLocalService getComplaintLocalService() {
		return complaintLocalService;
	}

	/**
	 * Sets the complaint local service.
	 *
	 * @param complaintLocalService the complaint local service
	 */
	public void setComplaintLocalService(
		ComplaintLocalService complaintLocalService) {
		this.complaintLocalService = complaintLocalService;
	}

	/**
	 * Returns the complaint remote service.
	 *
	 * @return the complaint remote service
	 */
	public ComplaintService getComplaintService() {
		return complaintService;
	}

	/**
	 * Sets the complaint remote service.
	 *
	 * @param complaintService the complaint remote service
	 */
	public void setComplaintService(ComplaintService complaintService) {
		this.complaintService = complaintService;
	}

	/**
	 * Returns the complaint persistence.
	 *
	 * @return the complaint persistence
	 */
	public ComplaintPersistence getComplaintPersistence() {
		return complaintPersistence;
	}

	/**
	 * Sets the complaint persistence.
	 *
	 * @param complaintPersistence the complaint persistence
	 */
	public void setComplaintPersistence(
		ComplaintPersistence complaintPersistence) {
		this.complaintPersistence = complaintPersistence;
	}

	/**
	 * Returns the complaint finder.
	 *
	 * @return the complaint finder
	 */
	public ComplaintFinder getComplaintFinder() {
		return complaintFinder;
	}

	/**
	 * Sets the complaint finder.
	 *
	 * @param complaintFinder the complaint finder
	 */
	public void setComplaintFinder(ComplaintFinder complaintFinder) {
		this.complaintFinder = complaintFinder;
	}

	/**
	 * Returns the complaint_ dl file entries local service.
	 *
	 * @return the complaint_ dl file entries local service
	 */
	public Complaint_DlFileEntriesLocalService getComplaint_DlFileEntriesLocalService() {
		return complaint_DlFileEntriesLocalService;
	}

	/**
	 * Sets the complaint_ dl file entries local service.
	 *
	 * @param complaint_DlFileEntriesLocalService the complaint_ dl file entries local service
	 */
	public void setComplaint_DlFileEntriesLocalService(
		Complaint_DlFileEntriesLocalService complaint_DlFileEntriesLocalService) {
		this.complaint_DlFileEntriesLocalService = complaint_DlFileEntriesLocalService;
	}

	/**
	 * Returns the complaint_ dl file entries remote service.
	 *
	 * @return the complaint_ dl file entries remote service
	 */
	public Complaint_DlFileEntriesService getComplaint_DlFileEntriesService() {
		return complaint_DlFileEntriesService;
	}

	/**
	 * Sets the complaint_ dl file entries remote service.
	 *
	 * @param complaint_DlFileEntriesService the complaint_ dl file entries remote service
	 */
	public void setComplaint_DlFileEntriesService(
		Complaint_DlFileEntriesService complaint_DlFileEntriesService) {
		this.complaint_DlFileEntriesService = complaint_DlFileEntriesService;
	}

	/**
	 * Returns the complaint_ dl file entries persistence.
	 *
	 * @return the complaint_ dl file entries persistence
	 */
	public Complaint_DlFileEntriesPersistence getComplaint_DlFileEntriesPersistence() {
		return complaint_DlFileEntriesPersistence;
	}

	/**
	 * Sets the complaint_ dl file entries persistence.
	 *
	 * @param complaint_DlFileEntriesPersistence the complaint_ dl file entries persistence
	 */
	public void setComplaint_DlFileEntriesPersistence(
		Complaint_DlFileEntriesPersistence complaint_DlFileEntriesPersistence) {
		this.complaint_DlFileEntriesPersistence = complaint_DlFileEntriesPersistence;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries",
			complaint_DlFileEntriesLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries");
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
		return Complaint_DlFileEntries.class;
	}

	protected String getModelClassName() {
		return Complaint_DlFileEntries.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = complaint_DlFileEntriesPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ComplaintLocalService.class)
	protected ComplaintLocalService complaintLocalService;
	@BeanReference(type = ComplaintService.class)
	protected ComplaintService complaintService;
	@BeanReference(type = ComplaintPersistence.class)
	protected ComplaintPersistence complaintPersistence;
	@BeanReference(type = ComplaintFinder.class)
	protected ComplaintFinder complaintFinder;
	@BeanReference(type = Complaint_DlFileEntriesLocalService.class)
	protected Complaint_DlFileEntriesLocalService complaint_DlFileEntriesLocalService;
	@BeanReference(type = Complaint_DlFileEntriesService.class)
	protected Complaint_DlFileEntriesService complaint_DlFileEntriesService;
	@BeanReference(type = Complaint_DlFileEntriesPersistence.class)
	protected Complaint_DlFileEntriesPersistence complaint_DlFileEntriesPersistence;
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
	private Complaint_DlFileEntriesLocalServiceClpInvoker _clpInvoker = new Complaint_DlFileEntriesLocalServiceClpInvoker();
}