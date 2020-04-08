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

package com.portal_egov.portlet.weblinks.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WeblinkCategory}.
 * </p>
 *
 * @author    HungDX
 * @see       WeblinkCategory
 * @generated
 */
public class WeblinkCategoryWrapper implements WeblinkCategory,
	ModelWrapper<WeblinkCategory> {
	public WeblinkCategoryWrapper(WeblinkCategory weblinkCategory) {
		_weblinkCategory = weblinkCategory;
	}

	public Class<?> getModelClass() {
		return WeblinkCategory.class;
	}

	public String getModelClassName() {
		return WeblinkCategory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("categoryIconId", getCategoryIconId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Long categoryIconId = (Long)attributes.get("categoryIconId");

		if (categoryIconId != null) {
			setCategoryIconId(categoryIconId);
		}
	}

	/**
	* Returns the primary key of this weblink category.
	*
	* @return the primary key of this weblink category
	*/
	public long getPrimaryKey() {
		return _weblinkCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this weblink category.
	*
	* @param primaryKey the primary key of this weblink category
	*/
	public void setPrimaryKey(long primaryKey) {
		_weblinkCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this weblink category.
	*
	* @return the category ID of this weblink category
	*/
	public long getCategoryId() {
		return _weblinkCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this weblink category.
	*
	* @param categoryId the category ID of this weblink category
	*/
	public void setCategoryId(long categoryId) {
		_weblinkCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this weblink category.
	*
	* @return the group ID of this weblink category
	*/
	public long getGroupId() {
		return _weblinkCategory.getGroupId();
	}

	/**
	* Sets the group ID of this weblink category.
	*
	* @param groupId the group ID of this weblink category
	*/
	public void setGroupId(long groupId) {
		_weblinkCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this weblink category.
	*
	* @return the company ID of this weblink category
	*/
	public long getCompanyId() {
		return _weblinkCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this weblink category.
	*
	* @param companyId the company ID of this weblink category
	*/
	public void setCompanyId(long companyId) {
		_weblinkCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this weblink category.
	*
	* @return the user ID of this weblink category
	*/
	public long getUserId() {
		return _weblinkCategory.getUserId();
	}

	/**
	* Sets the user ID of this weblink category.
	*
	* @param userId the user ID of this weblink category
	*/
	public void setUserId(long userId) {
		_weblinkCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this weblink category.
	*
	* @return the user uuid of this weblink category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _weblinkCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this weblink category.
	*
	* @param userUuid the user uuid of this weblink category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_weblinkCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this weblink category.
	*
	* @return the user name of this weblink category
	*/
	public java.lang.String getUserName() {
		return _weblinkCategory.getUserName();
	}

	/**
	* Sets the user name of this weblink category.
	*
	* @param userName the user name of this weblink category
	*/
	public void setUserName(java.lang.String userName) {
		_weblinkCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this weblink category.
	*
	* @return the create date of this weblink category
	*/
	public java.util.Date getCreateDate() {
		return _weblinkCategory.getCreateDate();
	}

	/**
	* Sets the create date of this weblink category.
	*
	* @param createDate the create date of this weblink category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_weblinkCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this weblink category.
	*
	* @return the modified date of this weblink category
	*/
	public java.util.Date getModifiedDate() {
		return _weblinkCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this weblink category.
	*
	* @param modifiedDate the modified date of this weblink category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_weblinkCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this weblink category.
	*
	* @return the category name of this weblink category
	*/
	public java.lang.String getCategoryName() {
		return _weblinkCategory.getCategoryName();
	}

	/**
	* Sets the category name of this weblink category.
	*
	* @param categoryName the category name of this weblink category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_weblinkCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this weblink category.
	*
	* @return the category desc of this weblink category
	*/
	public java.lang.String getCategoryDesc() {
		return _weblinkCategory.getCategoryDesc();
	}

	/**
	* Sets the category desc of this weblink category.
	*
	* @param categoryDesc the category desc of this weblink category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_weblinkCategory.setCategoryDesc(categoryDesc);
	}

	/**
	* Returns the category icon ID of this weblink category.
	*
	* @return the category icon ID of this weblink category
	*/
	public long getCategoryIconId() {
		return _weblinkCategory.getCategoryIconId();
	}

	/**
	* Sets the category icon ID of this weblink category.
	*
	* @param categoryIconId the category icon ID of this weblink category
	*/
	public void setCategoryIconId(long categoryIconId) {
		_weblinkCategory.setCategoryIconId(categoryIconId);
	}

	public boolean isNew() {
		return _weblinkCategory.isNew();
	}

	public void setNew(boolean n) {
		_weblinkCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _weblinkCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_weblinkCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _weblinkCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _weblinkCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_weblinkCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _weblinkCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_weblinkCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WeblinkCategoryWrapper((WeblinkCategory)_weblinkCategory.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory) {
		return _weblinkCategory.compareTo(weblinkCategory);
	}

	@Override
	public int hashCode() {
		return _weblinkCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.weblinks.model.WeblinkCategory> toCacheModel() {
		return _weblinkCategory.toCacheModel();
	}

	public com.portal_egov.portlet.weblinks.model.WeblinkCategory toEscapedModel() {
		return new WeblinkCategoryWrapper(_weblinkCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _weblinkCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _weblinkCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_weblinkCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WeblinkCategory getWrappedWeblinkCategory() {
		return _weblinkCategory;
	}

	public WeblinkCategory getWrappedModel() {
		return _weblinkCategory;
	}

	public void resetOriginalValues() {
		_weblinkCategory.resetOriginalValues();
	}

	private WeblinkCategory _weblinkCategory;
}