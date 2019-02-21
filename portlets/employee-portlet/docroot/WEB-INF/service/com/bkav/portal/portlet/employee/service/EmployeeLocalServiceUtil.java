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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the employee local service. This utility wraps {@link com.bkav.portal.portlet.employee.service.impl.EmployeeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ducdvd
 * @see EmployeeLocalService
 * @see com.bkav.portal.portlet.employee.service.base.EmployeeLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.employee.service.impl.EmployeeLocalServiceImpl
 * @generated
 */
public class EmployeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bkav.portal.portlet.employee.service.impl.EmployeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the employee to the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.employee.model.Employee addEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmployee(employee);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param emplId the primary key for the new employee
	* @return the new employee
	*/
	public static com.bkav.portal.portlet.employee.model.Employee createEmployee(
		long emplId) {
		return getService().createEmployee(emplId);
	}

	/**
	* Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emplId the primary key of the employee
	* @return the employee that was removed
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.employee.model.Employee deleteEmployee(
		long emplId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmployee(emplId);
	}

	/**
	* Deletes the employee from the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.employee.model.Employee deleteEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmployee(employee);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.bkav.portal.portlet.employee.model.Employee fetchEmployee(
		long emplId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmployee(emplId);
	}

	/**
	* Returns the employee with the primary key.
	*
	* @param emplId the primary key of the employee
	* @return the employee
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.employee.model.Employee getEmployee(
		long emplId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployee(emplId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> getEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(start, end);
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeesCount();
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.employee.model.Employee updateEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmployee(employee);
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @param merge whether to merge the employee with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.employee.model.Employee updateEmployee(
		com.bkav.portal.portlet.employee.model.Employee employee, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmployee(employee, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int countByDep(long depId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDep(depId);
	}

	public static int countByPost(long postId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByPost(postId);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static com.bkav.portal.portlet.employee.model.Employee findByEmplId(
		long emplId)
		throws com.bkav.portal.portlet.employee.NoSuchEmployeeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEmplId(emplId);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByDep(
		long depId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDep(depId);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByDep(
		long postId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDep(postId, start, end);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByPost(
		long postId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPost(postId);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByPost(
		long postId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPost(postId, start, end);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByKeyword(
		long groupId, long depId, long postId, java.lang.String keyword,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String check, java.lang.String createDate,
		java.lang.String endDate, java.lang.String checkEndDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByKeyword(groupId, depId, postId, keyword, start, end,
			obc, check, createDate, endDate, checkEndDate);
	}

	public static com.bkav.portal.portlet.employee.model.Employee addEmployees(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String name, java.util.Date birthday, java.lang.String male,
		long phone, java.lang.String addres, java.lang.String email,
		long postId, long depId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmployees(companyId, groupId, userId, userName, name,
			birthday, male, phone, addres, email, postId, depId);
	}

	public static com.bkav.portal.portlet.employee.model.Employee updateemployees(
		long companyId, long groupId, long userId, java.lang.String userName,
		long emplId, java.lang.String name, java.util.Date birthday,
		java.lang.String male, long phone, java.lang.String addres,
		java.lang.String email, long postId, long depId, long sal,
		int breakDay, int addDay, java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateemployees(companyId, groupId, userId, userName,
			emplId, name, birthday, male, phone, addres, email, postId, depId,
			sal, breakDay, addDay, endDate);
	}

	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> getEmployees(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator comparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(start, end, comparator);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmployeeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmployeeLocalService.class.getName());

			if (invokableLocalService instanceof EmployeeLocalService) {
				_service = (EmployeeLocalService)invokableLocalService;
			}
			else {
				_service = new EmployeeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmployeeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(EmployeeLocalService service) {
	}

	private static EmployeeLocalService _service;
}