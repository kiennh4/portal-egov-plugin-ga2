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
 * This class is a wrapper for {@link PostLocalService}.
 * </p>
 *
 * @author    ducdvd
 * @see       PostLocalService
 * @generated
 */
public class PostLocalServiceWrapper implements PostLocalService,
	ServiceWrapper<PostLocalService> {
	public PostLocalServiceWrapper(PostLocalService postLocalService) {
		_postLocalService = postLocalService;
	}

	/**
	* Adds the post to the database. Also notifies the appropriate model listeners.
	*
	* @param post the post
	* @return the post that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Post addPost(
		com.bkav.portal.portlet.employee.model.Post post)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.addPost(post);
	}

	/**
	* Creates a new post with the primary key. Does not add the post to the database.
	*
	* @param postId the primary key for the new post
	* @return the new post
	*/
	public com.bkav.portal.portlet.employee.model.Post createPost(long postId) {
		return _postLocalService.createPost(postId);
	}

	/**
	* Deletes the post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postId the primary key of the post
	* @return the post that was removed
	* @throws PortalException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Post deletePost(long postId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.deletePost(postId);
	}

	/**
	* Deletes the post from the database. Also notifies the appropriate model listeners.
	*
	* @param post the post
	* @return the post that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Post deletePost(
		com.bkav.portal.portlet.employee.model.Post post)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.deletePost(post);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postLocalService.dynamicQuery();
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
		return _postLocalService.dynamicQuery(dynamicQuery);
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
		return _postLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _postLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _postLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.bkav.portal.portlet.employee.model.Post fetchPost(long postId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.fetchPost(postId);
	}

	/**
	* Returns the post with the primary key.
	*
	* @param postId the primary key of the post
	* @return the post
	* @throws PortalException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Post getPost(long postId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.getPost(postId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @return the range of posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.employee.model.Post> getPosts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.getPosts(start, end);
	}

	/**
	* Returns the number of posts.
	*
	* @return the number of posts
	* @throws SystemException if a system exception occurred
	*/
	public int getPostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.getPostsCount();
	}

	/**
	* Updates the post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param post the post
	* @return the post that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Post updatePost(
		com.bkav.portal.portlet.employee.model.Post post)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.updatePost(post);
	}

	/**
	* Updates the post in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param post the post
	* @param merge whether to merge the post with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the post that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.employee.model.Post updatePost(
		com.bkav.portal.portlet.employee.model.Post post, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.updatePost(post, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _postLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_postLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _postLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.countByGroup(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Post> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.findAll();
	}

	public com.bkav.portal.portlet.employee.model.Post findByProductId(
		long postId)
		throws com.bkav.portal.portlet.employee.NoSuchPostException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.findByProductId(postId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Post> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.findByCompany(companyId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Post> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Post> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.findByGroup(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Post> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.bkav.portal.portlet.employee.model.Post> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.findByKeyword(groupId, keyword, start, end);
	}

	public com.bkav.portal.portlet.employee.model.Post addPost(long companyId,
		long groupId, long userId, java.lang.String userName,
		java.lang.String postName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.addPost(companyId, groupId, userId, userName,
			postName);
	}

	public com.bkav.portal.portlet.employee.model.Post updatePost(
		long companyId, long groupId, long userId, java.lang.String userName,
		long postId, java.lang.String postName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _postLocalService.updatePost(companyId, groupId, userId,
			userName, postId, postName);
	}

	public void deletePost(long postId, boolean deleteEmlpoyees)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_postLocalService.deletePost(postId, deleteEmlpoyees);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PostLocalService getWrappedPostLocalService() {
		return _postLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPostLocalService(PostLocalService postLocalService) {
		_postLocalService = postLocalService;
	}

	public PostLocalService getWrappedService() {
		return _postLocalService;
	}

	public void setWrappedService(PostLocalService postLocalService) {
		_postLocalService = postLocalService;
	}

	private PostLocalService _postLocalService;
}