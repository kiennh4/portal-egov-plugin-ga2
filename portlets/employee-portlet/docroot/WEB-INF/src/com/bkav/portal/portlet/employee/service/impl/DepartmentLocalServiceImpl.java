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

package com.bkav.portal.portlet.employee.service.impl;

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.employee.NoSuchDepartmentException;
import com.bkav.portal.portlet.employee.model.Department;
import com.bkav.portal.portlet.employee.model.Employee;
import com.bkav.portal.portlet.employee.model.Post;
import com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil;
import com.bkav.portal.portlet.employee.service.base.DepartmentLocalServiceBaseImpl;
import com.bkav.portal.portlet.employee.service.persistence.DepartmentFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;

/**
 * The implementation of the department local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.employee.service.DepartmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ducdvd
 * @see com.bkav.portal.portlet.employee.service.base.DepartmentLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil
 */
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil} to access the department local service.
	 */
	public int countAll() throws SystemException{
		return departmentPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return departmentPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return departmentPersistence.countByGroup(groupId);
	}
	
	public List<Department> findAll() throws SystemException{
		return departmentPersistence.findAll();
	}
    
	public Department findByProductId(long depId) throws SystemException, NoSuchDepartmentException{
		return departmentPersistence.findByPrimaryKey(depId);
	}
	
	public List<Department> findByCompany(long companyId) throws SystemException{
		return departmentPersistence.findByCompany(companyId);
	}
	
	public List<Department> findByCompany(long companyId,int start,int end) throws SystemException{
		return departmentPersistence.findByCompany(companyId,start,end);
	}
	
	public List<Department> findByGroup(long groupId) throws SystemException{
		return departmentPersistence.findByGroup(groupId);
	}
	
	public List<Department> findByGroup(long groupId,int start,int end) throws SystemException{
		return departmentPersistence.findByGroup(groupId,start,end);
	}
	
	public List<Department> findByKeyword(long groupId, String keyword,
			int start, int end) throws SystemException{
		return DepartmentFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public Department addDepartment(long companyId, long groupId,
			long userId, String userName, String depName, String depAddres, String depPhone) throws SystemException,
			PortalException {

		Date now = new Date();

		long depId = counterLocalService.increment();

		Department department = departmentPersistence.create(depId);

		department.setCompanyId(companyId);
		department.setGroupId(groupId);
		department.setUserId(userId);
		department.setUserName(userName);
		department.setDepName(depName);
		department.setDepAddres(depAddres);
		department.setDepPhone(depPhone);
		department.setCreateDate(now);
		department.setModifiedDate(now);

		departmentPersistence.update(department, false);
		
		return department;
	}
	
	public Department updateDepartment(long companyId, long groupId,
			long userId, String userName, long depId, String depName, String depAddres, String depPhone) throws SystemException,
			PortalException {

		Date now = new Date();

		Department department = departmentPersistence.fetchByPrimaryKey(depId);

		department.setCompanyId(companyId);
		department.setGroupId(groupId);
		department.setUserId(userId);
		department.setUserName(userName);
		department.setDepId(depId);
		department.setDepName(depName);
		department.setDepAddres(depAddres);
		department.setDepPhone(depPhone);
		department.setModifiedDate(now);

		departmentPersistence.update(department, false);

		return department;
	}
	
	public Department deleteDepartment(long depId) throws SystemException, PortalException{
		
		return departmentPersistence.remove(depId);
	}
	
	public List<Department> getDepartments(int start, int end, OrderByComparator comparator)
			throws SystemException {
		return departmentPersistence.findAll(start, end, comparator);
	}
	
	public void deleteDep(long depId, boolean deleteEmlpoyees)
			throws SystemException, PortalException {

		if (depId > 0) {

			Department dep = getDepartment(depId);

			if (dep != null) {

				List<Employee> employeeList = EmployeeLocalServiceUtil.findByDep(depId);

				if (deleteEmlpoyees && !employeeList.isEmpty()) {// Truong hop xoa
																// tat ca cac
																// lien ket
																// thuoc bang
																// dep

					for (Employee employee : employeeList) {
						// Xoa tat ca cac lien ket
						EmployeeLocalServiceUtil.deleteEmployee(employee.getEmplId());
					}
				} else if (!deleteEmlpoyees && !employeeList.isEmpty()) {// Truong
																		// hop
																		// khong
																		// xoa
																		// cac
																		// lien
																		// ket
																		// thuoc
																		// bang
																		// dep

					for (Employee employee : employeeList) {
						// Cap nhat Id post cua lien ket = 0
						employee.setDepId(0);
						EmployeeLocalServiceUtil.updateEmployee(employee, false);
					}
				}

				// Xoa post
				departmentPersistence.remove(depId);

				// remove portal resource
				resourceLocalService.deleteResource(
						dep.getCompanyId(),
						Department.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, depId);
			}
		}
	}
}