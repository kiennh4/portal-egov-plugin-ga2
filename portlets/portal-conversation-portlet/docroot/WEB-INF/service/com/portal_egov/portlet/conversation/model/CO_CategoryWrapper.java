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

package com.portal_egov.portlet.conversation.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CO_Category}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_Category
 * @generated
 */
public class CO_CategoryWrapper implements CO_Category,
	ModelWrapper<CO_Category> {
	public CO_CategoryWrapper(CO_Category co_Category) {
		_co_Category = co_Category;
	}

	public Class<?> getModelClass() {
		return CO_Category.class;
	}

	public String getModelClassName() {
		return CO_Category.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("parentCategoryId", getParentCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("threadCount", getThreadCount());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long parentCategoryId = (Long)attributes.get("parentCategoryId");

		if (parentCategoryId != null) {
			setParentCategoryId(parentCategoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Integer threadCount = (Integer)attributes.get("threadCount");

		if (threadCount != null) {
			setThreadCount(threadCount);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this c o_ category.
	*
	* @return the primary key of this c o_ category
	*/
	public long getPrimaryKey() {
		return _co_Category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this c o_ category.
	*
	* @param primaryKey the primary key of this c o_ category
	*/
	public void setPrimaryKey(long primaryKey) {
		_co_Category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this c o_ category.
	*
	* @return the category ID of this c o_ category
	*/
	public long getCategoryId() {
		return _co_Category.getCategoryId();
	}

	/**
	* Sets the category ID of this c o_ category.
	*
	* @param categoryId the category ID of this c o_ category
	*/
	public void setCategoryId(long categoryId) {
		_co_Category.setCategoryId(categoryId);
	}

	/**
	* Returns the company ID of this c o_ category.
	*
	* @return the company ID of this c o_ category
	*/
	public long getCompanyId() {
		return _co_Category.getCompanyId();
	}

	/**
	* Sets the company ID of this c o_ category.
	*
	* @param companyId the company ID of this c o_ category
	*/
	public void setCompanyId(long companyId) {
		_co_Category.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this c o_ category.
	*
	* @return the group ID of this c o_ category
	*/
	public long getGroupId() {
		return _co_Category.getGroupId();
	}

	/**
	* Sets the group ID of this c o_ category.
	*
	* @param groupId the group ID of this c o_ category
	*/
	public void setGroupId(long groupId) {
		_co_Category.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this c o_ category.
	*
	* @return the user ID of this c o_ category
	*/
	public long getUserId() {
		return _co_Category.getUserId();
	}

	/**
	* Sets the user ID of this c o_ category.
	*
	* @param userId the user ID of this c o_ category
	*/
	public void setUserId(long userId) {
		_co_Category.setUserId(userId);
	}

	/**
	* Returns the user uuid of this c o_ category.
	*
	* @return the user uuid of this c o_ category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_Category.getUserUuid();
	}

	/**
	* Sets the user uuid of this c o_ category.
	*
	* @param userUuid the user uuid of this c o_ category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_co_Category.setUserUuid(userUuid);
	}

	/**
	* Returns the parent category ID of this c o_ category.
	*
	* @return the parent category ID of this c o_ category
	*/
	public long getParentCategoryId() {
		return _co_Category.getParentCategoryId();
	}

	/**
	* Sets the parent category ID of this c o_ category.
	*
	* @param parentCategoryId the parent category ID of this c o_ category
	*/
	public void setParentCategoryId(long parentCategoryId) {
		_co_Category.setParentCategoryId(parentCategoryId);
	}

	/**
	* Returns the category name of this c o_ category.
	*
	* @return the category name of this c o_ category
	*/
	public java.lang.String getCategoryName() {
		return _co_Category.getCategoryName();
	}

	/**
	* Sets the category name of this c o_ category.
	*
	* @param categoryName the category name of this c o_ category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_co_Category.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this c o_ category.
	*
	* @return the category desc of this c o_ category
	*/
	public java.lang.String getCategoryDesc() {
		return _co_Category.getCategoryDesc();
	}

	/**
	* Sets the category desc of this c o_ category.
	*
	* @param categoryDesc the category desc of this c o_ category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_co_Category.setCategoryDesc(categoryDesc);
	}

	/**
	* Returns the thread count of this c o_ category.
	*
	* @return the thread count of this c o_ category
	*/
	public int getThreadCount() {
		return _co_Category.getThreadCount();
	}

	/**
	* Sets the thread count of this c o_ category.
	*
	* @param threadCount the thread count of this c o_ category
	*/
	public void setThreadCount(int threadCount) {
		_co_Category.setThreadCount(threadCount);
	}

	/**
	* Returns the create date of this c o_ category.
	*
	* @return the create date of this c o_ category
	*/
	public java.util.Date getCreateDate() {
		return _co_Category.getCreateDate();
	}

	/**
	* Sets the create date of this c o_ category.
	*
	* @param createDate the create date of this c o_ category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_co_Category.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this c o_ category.
	*
	* @return the modified date of this c o_ category
	*/
	public java.util.Date getModifiedDate() {
		return _co_Category.getModifiedDate();
	}

	/**
	* Sets the modified date of this c o_ category.
	*
	* @param modifiedDate the modified date of this c o_ category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_co_Category.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _co_Category.isNew();
	}

	public void setNew(boolean n) {
		_co_Category.setNew(n);
	}

	public boolean isCachedModel() {
		return _co_Category.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_co_Category.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _co_Category.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _co_Category.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_co_Category.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _co_Category.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_co_Category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CO_CategoryWrapper((CO_Category)_co_Category.clone());
	}

	public int compareTo(CO_Category co_Category) {
		return _co_Category.compareTo(co_Category);
	}

	@Override
	public int hashCode() {
		return _co_Category.hashCode();
	}

	public com.liferay.portal.model.CacheModel<CO_Category> toCacheModel() {
		return _co_Category.toCacheModel();
	}

	public CO_Category toEscapedModel() {
		return new CO_CategoryWrapper(_co_Category.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _co_Category.toString();
	}

	public java.lang.String toXmlString() {
		return _co_Category.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_co_Category.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CO_Category getWrappedCO_Category() {
		return _co_Category;
	}

	public CO_Category getWrappedModel() {
		return _co_Category;
	}

	public void resetOriginalValues() {
		_co_Category.resetOriginalValues();
	}

	private CO_Category _co_Category;
}