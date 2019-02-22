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

package com.portal_egov.portlet.legal_faq.service.base;

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

import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;
import com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalService;
import com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryService;
import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalService;
import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryService;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQCategoryFinder;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQCategoryPersistence;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQEntryFinder;
import com.portal_egov.portlet.legal_faq.service.persistence.LegalFAQEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the legal f a q category local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.portal_egov.portlet.legal_faq.service.impl.LegalFAQCategoryLocalServiceImpl}.
 * </p>
 *
 * @author HungDX
 * @see com.portal_egov.portlet.legal_faq.service.impl.LegalFAQCategoryLocalServiceImpl
 * @see com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil
 * @generated
 */
public abstract class LegalFAQCategoryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements LegalFAQCategoryLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil} to access the legal f a q category local service.
	 */

	/**
	 * Adds the legal f a q category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFAQCategory the legal f a q category
	 * @return the legal f a q category that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LegalFAQCategory addLegalFAQCategory(
		LegalFAQCategory legalFAQCategory) throws SystemException {
		legalFAQCategory.setNew(true);

		return legalFAQCategoryPersistence.update(legalFAQCategory, false);
	}

	/**
	 * Creates a new legal f a q category with the primary key. Does not add the legal f a q category to the database.
	 *
	 * @param categoryId the primary key for the new legal f a q category
	 * @return the new legal f a q category
	 */
	public LegalFAQCategory createLegalFAQCategory(long categoryId) {
		return legalFAQCategoryPersistence.create(categoryId);
	}

	/**
	 * Deletes the legal f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the legal f a q category
	 * @return the legal f a q category that was removed
	 * @throws PortalException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public LegalFAQCategory deleteLegalFAQCategory(long categoryId)
		throws PortalException, SystemException {
		return legalFAQCategoryPersistence.remove(categoryId);
	}

	/**
	 * Deletes the legal f a q category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFAQCategory the legal f a q category
	 * @return the legal f a q category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public LegalFAQCategory deleteLegalFAQCategory(
		LegalFAQCategory legalFAQCategory) throws SystemException {
		return legalFAQCategoryPersistence.remove(legalFAQCategory);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(LegalFAQCategory.class,
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
		return legalFAQCategoryPersistence.findWithDynamicQuery(dynamicQuery);
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
		return legalFAQCategoryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return legalFAQCategoryPersistence.findWithDynamicQuery(dynamicQuery,
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
		return legalFAQCategoryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public LegalFAQCategory fetchLegalFAQCategory(long categoryId)
		throws SystemException {
		return legalFAQCategoryPersistence.fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns the legal f a q category with the primary key.
	 *
	 * @param categoryId the primary key of the legal f a q category
	 * @return the legal f a q category
	 * @throws PortalException if a legal f a q category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LegalFAQCategory getLegalFAQCategory(long categoryId)
		throws PortalException, SystemException {
		return legalFAQCategoryPersistence.findByPrimaryKey(categoryId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return legalFAQCategoryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the legal f a q categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal f a q categories
	 * @param end the upper bound of the range of legal f a q categories (not inclusive)
	 * @return the range of legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<LegalFAQCategory> getLegalFAQCategories(int start, int end)
		throws SystemException {
		return legalFAQCategoryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of legal f a q categories.
	 *
	 * @return the number of legal f a q categories
	 * @throws SystemException if a system exception occurred
	 */
	public int getLegalFAQCategoriesCount() throws SystemException {
		return legalFAQCategoryPersistence.countAll();
	}

	/**
	 * Updates the legal f a q category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalFAQCategory the legal f a q category
	 * @return the legal f a q category that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LegalFAQCategory updateLegalFAQCategory(
		LegalFAQCategory legalFAQCategory) throws SystemException {
		return updateLegalFAQCategory(legalFAQCategory, true);
	}

	/**
	 * Updates the legal f a q category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalFAQCategory the legal f a q category
	 * @param merge whether to merge the legal f a q category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the legal f a q category that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LegalFAQCategory updateLegalFAQCategory(
		LegalFAQCategory legalFAQCategory, boolean merge)
		throws SystemException {
		legalFAQCategory.setNew(false);

		return legalFAQCategoryPersistence.update(legalFAQCategory, merge);
	}

	/**
	 * Returns the legal f a q category local service.
	 *
	 * @return the legal f a q category local service
	 */
	public LegalFAQCategoryLocalService getLegalFAQCategoryLocalService() {
		return legalFAQCategoryLocalService;
	}

	/**
	 * Sets the legal f a q category local service.
	 *
	 * @param legalFAQCategoryLocalService the legal f a q category local service
	 */
	public void setLegalFAQCategoryLocalService(
		LegalFAQCategoryLocalService legalFAQCategoryLocalService) {
		this.legalFAQCategoryLocalService = legalFAQCategoryLocalService;
	}

	/**
	 * Returns the legal f a q category remote service.
	 *
	 * @return the legal f a q category remote service
	 */
	public LegalFAQCategoryService getLegalFAQCategoryService() {
		return legalFAQCategoryService;
	}

	/**
	 * Sets the legal f a q category remote service.
	 *
	 * @param legalFAQCategoryService the legal f a q category remote service
	 */
	public void setLegalFAQCategoryService(
		LegalFAQCategoryService legalFAQCategoryService) {
		this.legalFAQCategoryService = legalFAQCategoryService;
	}

	/**
	 * Returns the legal f a q category persistence.
	 *
	 * @return the legal f a q category persistence
	 */
	public LegalFAQCategoryPersistence getLegalFAQCategoryPersistence() {
		return legalFAQCategoryPersistence;
	}

	/**
	 * Sets the legal f a q category persistence.
	 *
	 * @param legalFAQCategoryPersistence the legal f a q category persistence
	 */
	public void setLegalFAQCategoryPersistence(
		LegalFAQCategoryPersistence legalFAQCategoryPersistence) {
		this.legalFAQCategoryPersistence = legalFAQCategoryPersistence;
	}

	/**
	 * Returns the legal f a q category finder.
	 *
	 * @return the legal f a q category finder
	 */
	public LegalFAQCategoryFinder getLegalFAQCategoryFinder() {
		return legalFAQCategoryFinder;
	}

	/**
	 * Sets the legal f a q category finder.
	 *
	 * @param legalFAQCategoryFinder the legal f a q category finder
	 */
	public void setLegalFAQCategoryFinder(
		LegalFAQCategoryFinder legalFAQCategoryFinder) {
		this.legalFAQCategoryFinder = legalFAQCategoryFinder;
	}

	/**
	 * Returns the legal f a q entry local service.
	 *
	 * @return the legal f a q entry local service
	 */
	public LegalFAQEntryLocalService getLegalFAQEntryLocalService() {
		return legalFAQEntryLocalService;
	}

	/**
	 * Sets the legal f a q entry local service.
	 *
	 * @param legalFAQEntryLocalService the legal f a q entry local service
	 */
	public void setLegalFAQEntryLocalService(
		LegalFAQEntryLocalService legalFAQEntryLocalService) {
		this.legalFAQEntryLocalService = legalFAQEntryLocalService;
	}

	/**
	 * Returns the legal f a q entry remote service.
	 *
	 * @return the legal f a q entry remote service
	 */
	public LegalFAQEntryService getLegalFAQEntryService() {
		return legalFAQEntryService;
	}

	/**
	 * Sets the legal f a q entry remote service.
	 *
	 * @param legalFAQEntryService the legal f a q entry remote service
	 */
	public void setLegalFAQEntryService(
		LegalFAQEntryService legalFAQEntryService) {
		this.legalFAQEntryService = legalFAQEntryService;
	}

	/**
	 * Returns the legal f a q entry persistence.
	 *
	 * @return the legal f a q entry persistence
	 */
	public LegalFAQEntryPersistence getLegalFAQEntryPersistence() {
		return legalFAQEntryPersistence;
	}

	/**
	 * Sets the legal f a q entry persistence.
	 *
	 * @param legalFAQEntryPersistence the legal f a q entry persistence
	 */
	public void setLegalFAQEntryPersistence(
		LegalFAQEntryPersistence legalFAQEntryPersistence) {
		this.legalFAQEntryPersistence = legalFAQEntryPersistence;
	}

	/**
	 * Returns the legal f a q entry finder.
	 *
	 * @return the legal f a q entry finder
	 */
	public LegalFAQEntryFinder getLegalFAQEntryFinder() {
		return legalFAQEntryFinder;
	}

	/**
	 * Sets the legal f a q entry finder.
	 *
	 * @param legalFAQEntryFinder the legal f a q entry finder
	 */
	public void setLegalFAQEntryFinder(LegalFAQEntryFinder legalFAQEntryFinder) {
		this.legalFAQEntryFinder = legalFAQEntryFinder;
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
		PersistedModelLocalServiceRegistryUtil.register("com.portal_egov.portlet.legal_faq.model.LegalFAQCategory",
			legalFAQCategoryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.portal_egov.portlet.legal_faq.model.LegalFAQCategory");
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
		return LegalFAQCategory.class;
	}

	protected String getModelClassName() {
		return LegalFAQCategory.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = legalFAQCategoryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = LegalFAQCategoryLocalService.class)
	protected LegalFAQCategoryLocalService legalFAQCategoryLocalService;
	@BeanReference(type = LegalFAQCategoryService.class)
	protected LegalFAQCategoryService legalFAQCategoryService;
	@BeanReference(type = LegalFAQCategoryPersistence.class)
	protected LegalFAQCategoryPersistence legalFAQCategoryPersistence;
	@BeanReference(type = LegalFAQCategoryFinder.class)
	protected LegalFAQCategoryFinder legalFAQCategoryFinder;
	@BeanReference(type = LegalFAQEntryLocalService.class)
	protected LegalFAQEntryLocalService legalFAQEntryLocalService;
	@BeanReference(type = LegalFAQEntryService.class)
	protected LegalFAQEntryService legalFAQEntryService;
	@BeanReference(type = LegalFAQEntryPersistence.class)
	protected LegalFAQEntryPersistence legalFAQEntryPersistence;
	@BeanReference(type = LegalFAQEntryFinder.class)
	protected LegalFAQEntryFinder legalFAQEntryFinder;
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
	private LegalFAQCategoryLocalServiceClpInvoker _clpInvoker = new LegalFAQCategoryLocalServiceClpInvoker();
}