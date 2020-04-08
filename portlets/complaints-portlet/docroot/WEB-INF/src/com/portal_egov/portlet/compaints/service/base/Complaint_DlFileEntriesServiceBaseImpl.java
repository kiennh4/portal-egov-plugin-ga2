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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
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

import javax.sql.DataSource;

/**
 * The base implementation of the complaint_ dl file entries remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.compaints.service.impl.Complaint_DlFileEntriesServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.compaints.service.impl.Complaint_DlFileEntriesServiceImpl
 * @see com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesServiceUtil
 * @generated
 */
public abstract class Complaint_DlFileEntriesServiceBaseImpl
	extends BaseServiceImpl implements Complaint_DlFileEntriesService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesServiceUtil} to access the complaint_ dl file entries remote service.
	 */

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
	}

	public void destroy() {
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
	private Complaint_DlFileEntriesServiceClpInvoker _clpInvoker = new Complaint_DlFileEntriesServiceClpInvoker();
}