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

import com.bkav.portal.portlet.employee.NoSuchPostException;
import com.bkav.portal.portlet.employee.model.Employee;
import com.bkav.portal.portlet.employee.model.Post;
import com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil;
import com.bkav.portal.portlet.employee.service.base.PostLocalServiceBaseImpl;
import com.bkav.portal.portlet.employee.service.persistence.PostFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.ResourceConstants;




/**
 * The implementation of the post local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.employee.service.PostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ducdvd
 * @see com.bkav.portal.portlet.employee.service.base.PostLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.employee.service.PostLocalServiceUtil
 */
public class PostLocalServiceImpl extends PostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.employee.service.PostLocalServiceUtil} to access the post local service.
	 */
	public int countAll() throws SystemException{
		return postPersistence.countAll();
	}
	
	public int countByCompany(long companyId) throws SystemException{
		return postPersistence.countByCompany(companyId);
	}
	
	public int countByGroup(long groupId) throws SystemException{
		return postPersistence.countByGroup(groupId);
	}

	public List<Post> findAll() throws SystemException{
		return postPersistence.findAll();
	}
    
	public Post findByProductId(long postId) throws SystemException, NoSuchPostException{
		return postPersistence.findByPrimaryKey(postId);
	}
	
	public List<Post> findByCompany(long companyId) throws SystemException{
		return postPersistence.findByCompany(companyId);
	}
	
	public List<Post> findByCompany(long companyId,int start,int end) throws SystemException{
		return postPersistence.findByCompany(companyId,start,end);
	}
	
	public List<Post> findByGroup(long groupId) throws SystemException{
		return postPersistence.findByGroup(groupId);
	}
	
	public List<Post> findByGroup(long groupId,int start,int end) throws SystemException{
		return postPersistence.findByGroup(groupId,start,end);
	}
	
	public List<Post> findByKeyword(long groupId, String keyword,
			int start, int end) throws SystemException{
		return PostFinderUtil.findByKeyword(groupId, keyword, start, end);
	}
	
	public Post addPost(long companyId, long groupId,
			long userId, String userName, String postName) throws SystemException,
			PortalException {

		Date now = new Date();

		long postId = counterLocalService.increment();

		Post post = postPersistence.create(postId);

		post.setCompanyId(companyId);
		post.setGroupId(groupId);
		post.setUserId(userId);
		post.setUserName(userName);
		post.setPostName(postName);
		post.setCreateDate(now);
		post.setModifiedDate(now);

		postPersistence.update(post, false);

		return post;
	}
	
	public Post updatePost(long companyId, long groupId,
			long userId, String userName, long postId, String postName) throws SystemException,
			PortalException {

		Date now = new Date();

		Post post = postPersistence.fetchByPrimaryKey(postId);

		post.setCompanyId(companyId);
		post.setGroupId(groupId);
		post.setUserId(userId);
		post.setUserName(userName);
		post.setPostId(postId);
		post.setPostName(postName);
		post.setModifiedDate(now);

		postPersistence.update(post, false);

		return post;
	}
	
	public void deletePost(long postId, boolean deleteEmlpoyees)
			throws SystemException, PortalException {

		if (postId > 0) {

			Post post = getPost(postId);

			if (post != null) {

				List<Employee> employeeList = EmployeeLocalServiceUtil.findByPost(postId);

				if (deleteEmlpoyees && !employeeList.isEmpty()) {// Truong hop xoa
																// tat ca cac
																// lien ket
																// thuoc bang
																// post

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
																		// post

					for (Employee employee : employeeList) {
						// Cap nhat Id post cua lien ket = 0
						employee.setPostId(0);
						EmployeeLocalServiceUtil.updateEmployee(employee, false);
					}
				}

				// Xoa post
				postPersistence.remove(postId);

				// remove portal resource
				resourceLocalService.deleteResource(
						post.getCompanyId(),
						Post.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, postId);
			}
		}
	}
	

}