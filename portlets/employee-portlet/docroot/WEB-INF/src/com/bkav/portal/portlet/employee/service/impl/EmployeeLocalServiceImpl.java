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
import com.bkav.portal.portlet.employee.NoSuchEmployeeException;
import com.bkav.portal.portlet.employee.model.Department;
import com.bkav.portal.portlet.employee.model.Employee;
import com.bkav.portal.portlet.employee.service.base.EmployeeLocalServiceBaseImpl;
import com.bkav.portal.portlet.employee.service.persistence.EmployeeFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.employee.service.EmployeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ducdvd
 * @see com.bkav.portal.portlet.employee.service.base.EmployeeLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil} to access the employee local service.
	 */
	public int countAll() throws SystemException{
		return employeePersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return employeePersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return employeePersistence.countByGroup(groupId);
	}
	
	public int countByDep(long depId) throws SystemException{
		return employeePersistence.countByDep(depId);
	}
	
	public int countByPost(long postId) throws SystemException{
		return employeePersistence.countByPost(postId);
	}
	
	public List<Employee> findAll() throws SystemException{
		return employeePersistence.findAll();
	}
    
	public Employee findByEmplId(long emplId) throws SystemException, NoSuchEmployeeException{
		return employeePersistence.findByPrimaryKey(emplId);
	}
	
	public List<Employee> findByCompany(long companyId) throws SystemException{
		return employeePersistence.findByCompany(companyId);
	}
	
	public List<Employee> findByCompany(long companyId,int start,int end) throws SystemException{
		return employeePersistence.findByCompany(companyId,start,end);
	}
	
	public List<Employee> findByGroup(long groupId) throws SystemException{
		return employeePersistence.findByGroup(groupId);
	}
	
	public List<Employee> findByGroup(long groupId,int start,int end) throws SystemException{
		return employeePersistence.findByGroup(groupId,start,end);
	}
	
	public List<Employee> findByDep(long depId) throws SystemException{
		return employeePersistence.findByDep(depId);
	}
	
	public List<Employee> findByDep(long postId,int start,int end) throws SystemException{
		return employeePersistence.findByDep(postId, start, end);
	}
	
	public List<Employee> findByPost(long postId) throws SystemException{
		return employeePersistence.findByPost(postId);
	}
	
	public List<Employee> findByPost(long postId,int start,int end) throws SystemException{
		return employeePersistence.findByPost(postId, start, end);
	}
	
	public List<Employee> findByKeyword(long groupId, long depId, long postId, String keyword,
			int start, int end, OrderByComparator obc, String check, String createDate, String endDate, String checkEndDate) throws SystemException{
		return EmployeeFinderUtil.findByKeyword(groupId, depId, postId, keyword, start, end, obc, check, createDate, endDate, checkEndDate);
	}
	
	public Employee addEmployees(long companyId, long groupId,
			long userId, String userName, String name,
			Date birthday, String male, long phone, String addres, String email, long postId, long depId) throws SystemException,
			PortalException {

		Date now = new Date();

		long emplId = counterLocalService.increment();

		Employee employee = employeePersistence.create(emplId);

		employee.setCompanyId(companyId);
		employee.setGroupId(groupId);
		employee.setUserId(userId);
		employee.setUserName(userName);
		employee.setName(name);
		employee.setBirthday(birthday);
		employee.setMale(male);
		employee.setPhone(phone);
		employee.setAddres(addres);
		employee.setEmail(email);
		employee.setPostId(postId);
		employee.setDepId(depId);
		employee.setCreateDate(now);
		employee.setModifiedDate(now);

		employeePersistence.update(employee, false);

		
		return employee;
	}
	
	public Employee updateemployees(long companyId, long groupId,
			long userId, String userName, long emplId, String name,
			Date birthday, String male, long phone, String addres, String email, long postId, long depId, 
			long sal, int breakDay, int addDay, String endDate) throws SystemException,
			PortalException {

		Date now = new Date();

		Employee employee = employeePersistence.fetchByPrimaryKey(emplId);

		employee.setCompanyId(companyId);
		employee.setGroupId(groupId);
		employee.setUserId(userId);
		employee.setUserName(userName);
		employee.setEmplId(emplId);
		employee.setName(name);
		employee.setBirthday(birthday);
		employee.setMale(male);
		employee.setPhone(phone);
		employee.setAddres(addres);
		employee.setEmail(email);
		employee.setPostId(postId);
		employee.setDepId(depId);
		employee.setSal(sal);
		employee.setBreakDay(breakDay);
		employee.setAddDay(addDay);
		employee.setEndDate(endDate);
		employee.setModifiedDate(now);
        
		employeePersistence.update(employee, false);

		return employee;
	}
	
	public Employee deleteEmployee(long emplId) throws SystemException, PortalException{
		
		return employeePersistence.remove(emplId);
	}
	
	public List<Employee> getEmployees(int start, int end, OrderByComparator comparator)
			throws SystemException {
		return employeePersistence.findAll(start, end, comparator);
	}
}