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

package com.portal_egov.portlet.contacts.service.base;

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

import com.portal_egov.portlet.contacts.model.ContactsDepartment;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalService;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalService;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyService;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentService;
import com.portal_egov.portlet.contacts.service.ContactsLocalService;
import com.portal_egov.portlet.contacts.service.ContactsPropertyLocalService;
import com.portal_egov.portlet.contacts.service.ContactsPropertyService;
import com.portal_egov.portlet.contacts.service.ContactsService;
import com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentFinder;
import com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentPersistence;
import com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentPropertyFinder;
import com.portal_egov.portlet.contacts.service.persistence.ContactsDepartmentPropertyPersistence;
import com.portal_egov.portlet.contacts.service.persistence.ContactsFinder;
import com.portal_egov.portlet.contacts.service.persistence.ContactsPersistence;
import com.portal_egov.portlet.contacts.service.persistence.ContactsPropertyFinder;
import com.portal_egov.portlet.contacts.service.persistence.ContactsPropertyPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the contacts department local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentLocalServiceImpl
 * @see com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil
 * @generated
 */
public abstract class ContactsDepartmentLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ContactsDepartmentLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil} to access the contacts department local service.
	 */

	/**
	 * Adds the contacts department to the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactsDepartment the contacts department
	 * @return the contacts department that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ContactsDepartment addContactsDepartment(
		ContactsDepartment contactsDepartment) throws SystemException {
		contactsDepartment.setNew(true);

		return contactsDepartmentPersistence.update(contactsDepartment, false);
	}

	/**
	 * Creates a new contacts department with the primary key. Does not add the contacts department to the database.
	 *
	 * @param departmentId the primary key for the new contacts department
	 * @return the new contacts department
	 */
	public ContactsDepartment createContactsDepartment(long departmentId) {
		return contactsDepartmentPersistence.create(departmentId);
	}

	/**
	 * Deletes the contacts department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the contacts department
	 * @return the contacts department that was removed
	 * @throws PortalException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public ContactsDepartment deleteContactsDepartment(long departmentId)
		throws PortalException, SystemException {
		return contactsDepartmentPersistence.remove(departmentId);
	}

	/**
	 * Deletes the contacts department from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactsDepartment the contacts department
	 * @return the contacts department that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public ContactsDepartment deleteContactsDepartment(
		ContactsDepartment contactsDepartment) throws SystemException {
		return contactsDepartmentPersistence.remove(contactsDepartment);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ContactsDepartment.class,
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
		return contactsDepartmentPersistence.findWithDynamicQuery(dynamicQuery);
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
		return contactsDepartmentPersistence.findWithDynamicQuery(dynamicQuery,
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
		return contactsDepartmentPersistence.findWithDynamicQuery(dynamicQuery,
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
		return contactsDepartmentPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public ContactsDepartment fetchContactsDepartment(long departmentId)
		throws SystemException {
		return contactsDepartmentPersistence.fetchByPrimaryKey(departmentId);
	}

	/**
	 * Returns the contacts department with the primary key.
	 *
	 * @param departmentId the primary key of the contacts department
	 * @return the contacts department
	 * @throws PortalException if a contacts department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactsDepartment getContactsDepartment(long departmentId)
		throws PortalException, SystemException {
		return contactsDepartmentPersistence.findByPrimaryKey(departmentId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return contactsDepartmentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the contacts departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts departments
	 * @param end the upper bound of the range of contacts departments (not inclusive)
	 * @return the range of contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactsDepartment> getContactsDepartments(int start, int end)
		throws SystemException {
		return contactsDepartmentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of contacts departments.
	 *
	 * @return the number of contacts departments
	 * @throws SystemException if a system exception occurred
	 */
	public int getContactsDepartmentsCount() throws SystemException {
		return contactsDepartmentPersistence.countAll();
	}

	/**
	 * Updates the contacts department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param contactsDepartment the contacts department
	 * @return the contacts department that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ContactsDepartment updateContactsDepartment(
		ContactsDepartment contactsDepartment) throws SystemException {
		return updateContactsDepartment(contactsDepartment, true);
	}

	/**
	 * Updates the contacts department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param contactsDepartment the contacts department
	 * @param merge whether to merge the contacts department with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the contacts department that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ContactsDepartment updateContactsDepartment(
		ContactsDepartment contactsDepartment, boolean merge)
		throws SystemException {
		contactsDepartment.setNew(false);

		return contactsDepartmentPersistence.update(contactsDepartment, merge);
	}

	/**
	 * Returns the contacts local service.
	 *
	 * @return the contacts local service
	 */
	public ContactsLocalService getContactsLocalService() {
		return contactsLocalService;
	}

	/**
	 * Sets the contacts local service.
	 *
	 * @param contactsLocalService the contacts local service
	 */
	public void setContactsLocalService(
		ContactsLocalService contactsLocalService) {
		this.contactsLocalService = contactsLocalService;
	}

	/**
	 * Returns the contacts remote service.
	 *
	 * @return the contacts remote service
	 */
	public ContactsService getContactsService() {
		return contactsService;
	}

	/**
	 * Sets the contacts remote service.
	 *
	 * @param contactsService the contacts remote service
	 */
	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	/**
	 * Returns the contacts persistence.
	 *
	 * @return the contacts persistence
	 */
	public ContactsPersistence getContactsPersistence() {
		return contactsPersistence;
	}

	/**
	 * Sets the contacts persistence.
	 *
	 * @param contactsPersistence the contacts persistence
	 */
	public void setContactsPersistence(ContactsPersistence contactsPersistence) {
		this.contactsPersistence = contactsPersistence;
	}

	/**
	 * Returns the contacts finder.
	 *
	 * @return the contacts finder
	 */
	public ContactsFinder getContactsFinder() {
		return contactsFinder;
	}

	/**
	 * Sets the contacts finder.
	 *
	 * @param contactsFinder the contacts finder
	 */
	public void setContactsFinder(ContactsFinder contactsFinder) {
		this.contactsFinder = contactsFinder;
	}

	/**
	 * Returns the contacts department local service.
	 *
	 * @return the contacts department local service
	 */
	public ContactsDepartmentLocalService getContactsDepartmentLocalService() {
		return contactsDepartmentLocalService;
	}

	/**
	 * Sets the contacts department local service.
	 *
	 * @param contactsDepartmentLocalService the contacts department local service
	 */
	public void setContactsDepartmentLocalService(
		ContactsDepartmentLocalService contactsDepartmentLocalService) {
		this.contactsDepartmentLocalService = contactsDepartmentLocalService;
	}

	/**
	 * Returns the contacts department remote service.
	 *
	 * @return the contacts department remote service
	 */
	public ContactsDepartmentService getContactsDepartmentService() {
		return contactsDepartmentService;
	}

	/**
	 * Sets the contacts department remote service.
	 *
	 * @param contactsDepartmentService the contacts department remote service
	 */
	public void setContactsDepartmentService(
		ContactsDepartmentService contactsDepartmentService) {
		this.contactsDepartmentService = contactsDepartmentService;
	}

	/**
	 * Returns the contacts department persistence.
	 *
	 * @return the contacts department persistence
	 */
	public ContactsDepartmentPersistence getContactsDepartmentPersistence() {
		return contactsDepartmentPersistence;
	}

	/**
	 * Sets the contacts department persistence.
	 *
	 * @param contactsDepartmentPersistence the contacts department persistence
	 */
	public void setContactsDepartmentPersistence(
		ContactsDepartmentPersistence contactsDepartmentPersistence) {
		this.contactsDepartmentPersistence = contactsDepartmentPersistence;
	}

	/**
	 * Returns the contacts department finder.
	 *
	 * @return the contacts department finder
	 */
	public ContactsDepartmentFinder getContactsDepartmentFinder() {
		return contactsDepartmentFinder;
	}

	/**
	 * Sets the contacts department finder.
	 *
	 * @param contactsDepartmentFinder the contacts department finder
	 */
	public void setContactsDepartmentFinder(
		ContactsDepartmentFinder contactsDepartmentFinder) {
		this.contactsDepartmentFinder = contactsDepartmentFinder;
	}

	/**
	 * Returns the contacts department property local service.
	 *
	 * @return the contacts department property local service
	 */
	public ContactsDepartmentPropertyLocalService getContactsDepartmentPropertyLocalService() {
		return contactsDepartmentPropertyLocalService;
	}

	/**
	 * Sets the contacts department property local service.
	 *
	 * @param contactsDepartmentPropertyLocalService the contacts department property local service
	 */
	public void setContactsDepartmentPropertyLocalService(
		ContactsDepartmentPropertyLocalService contactsDepartmentPropertyLocalService) {
		this.contactsDepartmentPropertyLocalService = contactsDepartmentPropertyLocalService;
	}

	/**
	 * Returns the contacts department property remote service.
	 *
	 * @return the contacts department property remote service
	 */
	public ContactsDepartmentPropertyService getContactsDepartmentPropertyService() {
		return contactsDepartmentPropertyService;
	}

	/**
	 * Sets the contacts department property remote service.
	 *
	 * @param contactsDepartmentPropertyService the contacts department property remote service
	 */
	public void setContactsDepartmentPropertyService(
		ContactsDepartmentPropertyService contactsDepartmentPropertyService) {
		this.contactsDepartmentPropertyService = contactsDepartmentPropertyService;
	}

	/**
	 * Returns the contacts department property persistence.
	 *
	 * @return the contacts department property persistence
	 */
	public ContactsDepartmentPropertyPersistence getContactsDepartmentPropertyPersistence() {
		return contactsDepartmentPropertyPersistence;
	}

	/**
	 * Sets the contacts department property persistence.
	 *
	 * @param contactsDepartmentPropertyPersistence the contacts department property persistence
	 */
	public void setContactsDepartmentPropertyPersistence(
		ContactsDepartmentPropertyPersistence contactsDepartmentPropertyPersistence) {
		this.contactsDepartmentPropertyPersistence = contactsDepartmentPropertyPersistence;
	}

	/**
	 * Returns the contacts department property finder.
	 *
	 * @return the contacts department property finder
	 */
	public ContactsDepartmentPropertyFinder getContactsDepartmentPropertyFinder() {
		return contactsDepartmentPropertyFinder;
	}

	/**
	 * Sets the contacts department property finder.
	 *
	 * @param contactsDepartmentPropertyFinder the contacts department property finder
	 */
	public void setContactsDepartmentPropertyFinder(
		ContactsDepartmentPropertyFinder contactsDepartmentPropertyFinder) {
		this.contactsDepartmentPropertyFinder = contactsDepartmentPropertyFinder;
	}

	/**
	 * Returns the contacts property local service.
	 *
	 * @return the contacts property local service
	 */
	public ContactsPropertyLocalService getContactsPropertyLocalService() {
		return contactsPropertyLocalService;
	}

	/**
	 * Sets the contacts property local service.
	 *
	 * @param contactsPropertyLocalService the contacts property local service
	 */
	public void setContactsPropertyLocalService(
		ContactsPropertyLocalService contactsPropertyLocalService) {
		this.contactsPropertyLocalService = contactsPropertyLocalService;
	}

	/**
	 * Returns the contacts property remote service.
	 *
	 * @return the contacts property remote service
	 */
	public ContactsPropertyService getContactsPropertyService() {
		return contactsPropertyService;
	}

	/**
	 * Sets the contacts property remote service.
	 *
	 * @param contactsPropertyService the contacts property remote service
	 */
	public void setContactsPropertyService(
		ContactsPropertyService contactsPropertyService) {
		this.contactsPropertyService = contactsPropertyService;
	}

	/**
	 * Returns the contacts property persistence.
	 *
	 * @return the contacts property persistence
	 */
	public ContactsPropertyPersistence getContactsPropertyPersistence() {
		return contactsPropertyPersistence;
	}

	/**
	 * Sets the contacts property persistence.
	 *
	 * @param contactsPropertyPersistence the contacts property persistence
	 */
	public void setContactsPropertyPersistence(
		ContactsPropertyPersistence contactsPropertyPersistence) {
		this.contactsPropertyPersistence = contactsPropertyPersistence;
	}

	/**
	 * Returns the contacts property finder.
	 *
	 * @return the contacts property finder
	 */
	public ContactsPropertyFinder getContactsPropertyFinder() {
		return contactsPropertyFinder;
	}

	/**
	 * Sets the contacts property finder.
	 *
	 * @param contactsPropertyFinder the contacts property finder
	 */
	public void setContactsPropertyFinder(
		ContactsPropertyFinder contactsPropertyFinder) {
		this.contactsPropertyFinder = contactsPropertyFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.contacts.model.ContactsDepartment",
			contactsDepartmentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.contacts.model.ContactsDepartment");
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
		return ContactsDepartment.class;
	}

	protected String getModelClassName() {
		return ContactsDepartment.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = contactsDepartmentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ContactsLocalService.class)
	protected ContactsLocalService contactsLocalService;
	@BeanReference(type = ContactsService.class)
	protected ContactsService contactsService;
	@BeanReference(type = ContactsPersistence.class)
	protected ContactsPersistence contactsPersistence;
	@BeanReference(type = ContactsFinder.class)
	protected ContactsFinder contactsFinder;
	@BeanReference(type = ContactsDepartmentLocalService.class)
	protected ContactsDepartmentLocalService contactsDepartmentLocalService;
	@BeanReference(type = ContactsDepartmentService.class)
	protected ContactsDepartmentService contactsDepartmentService;
	@BeanReference(type = ContactsDepartmentPersistence.class)
	protected ContactsDepartmentPersistence contactsDepartmentPersistence;
	@BeanReference(type = ContactsDepartmentFinder.class)
	protected ContactsDepartmentFinder contactsDepartmentFinder;
	@BeanReference(type = ContactsDepartmentPropertyLocalService.class)
	protected ContactsDepartmentPropertyLocalService contactsDepartmentPropertyLocalService;
	@BeanReference(type = ContactsDepartmentPropertyService.class)
	protected ContactsDepartmentPropertyService contactsDepartmentPropertyService;
	@BeanReference(type = ContactsDepartmentPropertyPersistence.class)
	protected ContactsDepartmentPropertyPersistence contactsDepartmentPropertyPersistence;
	@BeanReference(type = ContactsDepartmentPropertyFinder.class)
	protected ContactsDepartmentPropertyFinder contactsDepartmentPropertyFinder;
	@BeanReference(type = ContactsPropertyLocalService.class)
	protected ContactsPropertyLocalService contactsPropertyLocalService;
	@BeanReference(type = ContactsPropertyService.class)
	protected ContactsPropertyService contactsPropertyService;
	@BeanReference(type = ContactsPropertyPersistence.class)
	protected ContactsPropertyPersistence contactsPropertyPersistence;
	@BeanReference(type = ContactsPropertyFinder.class)
	protected ContactsPropertyFinder contactsPropertyFinder;
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
	private ContactsDepartmentLocalServiceClpInvoker _clpInvoker = new ContactsDepartmentLocalServiceClpInvoker();
}