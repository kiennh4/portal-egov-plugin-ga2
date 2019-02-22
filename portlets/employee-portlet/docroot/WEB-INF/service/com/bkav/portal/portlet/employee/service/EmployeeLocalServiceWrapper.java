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

package com.bkav.portal.portlet.employee.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeLocalService}.
 * </p>
 *
 * @author    ducdvd
 * @see       EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceWrapper implements EmployeeLocalService,
	ServiceWrapper<EmployeeLocalService> {
	public EmployeeLocalServiceWrapper(
		EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	/**
	* Adds the employee to the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Employee addEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.addEmployee(employee);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param emplId the primary key for the new employee
	* @return the new employee
	*/
	public com.bkav.portal.portlet.employee.model.Employee createEmployee(
		long emplId) {
		return _employeeLocalService.createEmployee(emplId);
	}

	/**
	* Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emplId the primary key of the employee
	* @return the employee that was removed
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Employee deleteEmployee(
		long emplId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.deleteEmployee(emplId);
	}

	/**
	* Deletes the employee from the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Employee deleteEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.deleteEmployee(employee);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeLocalService.dynamicQuery();
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
		return _employeeLocalService.dynamicQuery(dynamicQuery);
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
		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _employeeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.employee.model.Employee fetchEmployee(
		long emplId) throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.fetchEmployee(emplId);
	}

	/**
	* Returns the employee with the primary key.
	*
	* @param emplId the primary key of the employee
	* @return the employee
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Employee getEmployee(
		long emplId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployee(emplId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> getEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(start, end);
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public int getEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployeesCount();
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Employee updateEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.updateEmployee(employee);
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @param merge whether to merge the employee with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Employee updateEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.updateEmployee(employee, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _employeeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_employeeLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _employeeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countByGroup(groupId);
	}

	public int countByDep(long depId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countByDep(depId);
	}

	public int countByPost(long postId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.countByPost(postId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findAll();
	}

	public com.bkav.portal.portlet.employee.model.Employee findByEmplId(
		long emplId)
		throws com.bkav.portal.portlet.employee.NoSuchEmployeeException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByEmplId(emplId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByCompany(companyId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByGroup(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByDep(
		long depId) throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByDep(depId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByDep(
		long postId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByDep(postId, start, end);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByPost(
		long postId) throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByPost(postId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByPost(
		long postId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByPost(postId, start, end);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByKeyword(
		long groupId, long depId, long postId, java.lang.String keyword,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String check, java.lang.String createDate,
		java.lang.String endDate, java.lang.String checkEndDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.findByKeyword(groupId, depId, postId,
			keyword, start, end, obc, check, createDate, endDate, checkEndDate);
	}

	public com.bkav.portal.portlet.employee.model.Employee addEmployees(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String name, java.util.Date birthday, java.lang.String male,
		long phone, java.lang.String addres, java.lang.String email,
		long postId, long depId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.addEmployees(companyId, groupId, userId,
			userName, name, birthday, male, phone, addres, email, postId, depId);
	}

	public com.bkav.portal.portlet.employee.model.Employee updateemployees(
		long companyId, long groupId, long userId, java.lang.String userName,
		long emplId, java.lang.String name, java.util.Date birthday,
		java.lang.String male, long phone, java.lang.String addres,
		java.lang.String email, long postId, long depId, long sal,
		int breakDay, int addDay, java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.updateemployees(companyId, groupId,
			userId, userName, emplId, name, birthday, male, phone, addres,
			email, postId, depId, sal, breakDay, addDay, endDate);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Employee> getEmployees(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeLocalService.getEmployees(start, end, comparator);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EmployeeLocalService getWrappedEmployeeLocalService() {
		return _employeeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEmployeeLocalService(
		EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	public EmployeeLocalService getWrappedService() {
		return _employeeLocalService;
	}

	public void setWrappedService(EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	private EmployeeLocalService _employeeLocalService;
}