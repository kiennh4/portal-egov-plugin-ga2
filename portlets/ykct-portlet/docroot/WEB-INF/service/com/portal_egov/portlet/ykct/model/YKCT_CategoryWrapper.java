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

package com.portal_egov.portlet.ykct.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link YKCT_Category}.
 * </p>
 *
 * @author    DucDVd
 * @see       YKCT_Category
 * @generated
 */
public class YKCT_CategoryWrapper implements YKCT_Category,
	ModelWrapper<YKCT_Category> {
	public YKCT_CategoryWrapper(YKCT_Category ykct_Category) {
		_ykct_Category = ykct_Category;
	}

	public Class<?> getModelClass() {
		return YKCT_Category.class;
	}

	public String getModelClassName() {
		return YKCT_Category.class.getName();
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
	}

	/**
	* Returns the primary key of this y k c t_ category.
	*
	* @return the primary key of this y k c t_ category
	*/
	public long getPrimaryKey() {
		return _ykct_Category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this y k c t_ category.
	*
	* @param primaryKey the primary key of this y k c t_ category
	*/
	public void setPrimaryKey(long primaryKey) {
		_ykct_Category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this y k c t_ category.
	*
	* @return the category ID of this y k c t_ category
	*/
	public long getCategoryId() {
		return _ykct_Category.getCategoryId();
	}

	/**
	* Sets the category ID of this y k c t_ category.
	*
	* @param categoryId the category ID of this y k c t_ category
	*/
	public void setCategoryId(long categoryId) {
		_ykct_Category.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this y k c t_ category.
	*
	* @return the group ID of this y k c t_ category
	*/
	public long getGroupId() {
		return _ykct_Category.getGroupId();
	}

	/**
	* Sets the group ID of this y k c t_ category.
	*
	* @param groupId the group ID of this y k c t_ category
	*/
	public void setGroupId(long groupId) {
		_ykct_Category.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this y k c t_ category.
	*
	* @return the company ID of this y k c t_ category
	*/
	public long getCompanyId() {
		return _ykct_Category.getCompanyId();
	}

	/**
	* Sets the company ID of this y k c t_ category.
	*
	* @param companyId the company ID of this y k c t_ category
	*/
	public void setCompanyId(long companyId) {
		_ykct_Category.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this y k c t_ category.
	*
	* @return the user ID of this y k c t_ category
	*/
	public long getUserId() {
		return _ykct_Category.getUserId();
	}

	/**
	* Sets the user ID of this y k c t_ category.
	*
	* @param userId the user ID of this y k c t_ category
	*/
	public void setUserId(long userId) {
		_ykct_Category.setUserId(userId);
	}

	/**
	* Returns the user uuid of this y k c t_ category.
	*
	* @return the user uuid of this y k c t_ category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ykct_Category.getUserUuid();
	}

	/**
	* Sets the user uuid of this y k c t_ category.
	*
	* @param userUuid the user uuid of this y k c t_ category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_ykct_Category.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this y k c t_ category.
	*
	* @return the user name of this y k c t_ category
	*/
	public java.lang.String getUserName() {
		return _ykct_Category.getUserName();
	}

	/**
	* Sets the user name of this y k c t_ category.
	*
	* @param userName the user name of this y k c t_ category
	*/
	public void setUserName(java.lang.String userName) {
		_ykct_Category.setUserName(userName);
	}

	/**
	* Returns the create date of this y k c t_ category.
	*
	* @return the create date of this y k c t_ category
	*/
	public java.util.Date getCreateDate() {
		return _ykct_Category.getCreateDate();
	}

	/**
	* Sets the create date of this y k c t_ category.
	*
	* @param createDate the create date of this y k c t_ category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_ykct_Category.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this y k c t_ category.
	*
	* @return the modified date of this y k c t_ category
	*/
	public java.util.Date getModifiedDate() {
		return _ykct_Category.getModifiedDate();
	}

	/**
	* Sets the modified date of this y k c t_ category.
	*
	* @param modifiedDate the modified date of this y k c t_ category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ykct_Category.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this y k c t_ category.
	*
	* @return the category name of this y k c t_ category
	*/
	public java.lang.String getCategoryName() {
		return _ykct_Category.getCategoryName();
	}

	/**
	* Sets the category name of this y k c t_ category.
	*
	* @param categoryName the category name of this y k c t_ category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_ykct_Category.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this y k c t_ category.
	*
	* @return the category desc of this y k c t_ category
	*/
	public java.lang.String getCategoryDesc() {
		return _ykct_Category.getCategoryDesc();
	}

	/**
	* Sets the category desc of this y k c t_ category.
	*
	* @param categoryDesc the category desc of this y k c t_ category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_ykct_Category.setCategoryDesc(categoryDesc);
	}

	public boolean isNew() {
		return _ykct_Category.isNew();
	}

	public void setNew(boolean n) {
		_ykct_Category.setNew(n);
	}

	public boolean isCachedModel() {
		return _ykct_Category.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ykct_Category.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ykct_Category.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ykct_Category.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ykct_Category.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ykct_Category.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ykct_Category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YKCT_CategoryWrapper((YKCT_Category)_ykct_Category.clone());
	}

	public int compareTo(YKCT_Category ykct_Category) {
		return _ykct_Category.compareTo(ykct_Category);
	}

	@Override
	public int hashCode() {
		return _ykct_Category.hashCode();
	}

	public com.liferay.portal.model.CacheModel<YKCT_Category> toCacheModel() {
		return _ykct_Category.toCacheModel();
	}

	public YKCT_Category toEscapedModel() {
		return new YKCT_CategoryWrapper(_ykct_Category.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ykct_Category.toString();
	}

	public java.lang.String toXmlString() {
		return _ykct_Category.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ykct_Category.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public YKCT_Category getWrappedYKCT_Category() {
		return _ykct_Category;
	}

	public YKCT_Category getWrappedModel() {
		return _ykct_Category;
	}

	public void resetOriginalValues() {
		_ykct_Category.resetOriginalValues();
	}

	private YKCT_Category _ykct_Category;
}