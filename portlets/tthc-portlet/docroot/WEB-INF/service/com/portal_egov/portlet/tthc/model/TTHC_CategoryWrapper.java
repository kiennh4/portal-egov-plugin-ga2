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

package com.portal_egov.portlet.tthc.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TTHC_Category}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_Category
 * @generated
 */
public class TTHC_CategoryWrapper implements TTHC_Category,
	ModelWrapper<TTHC_Category> {
	public TTHC_CategoryWrapper(TTHC_Category tthc_Category) {
		_tthc_Category = tthc_Category;
	}

	public Class<?> getModelClass() {
		return TTHC_Category.class;
	}

	public String getModelClassName() {
		return TTHC_Category.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("parentId", getParentId());
		attributes.put("categoryTypeId", getCategoryTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("displayPriority", getDisplayPriority());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Integer categoryTypeId = (Integer)attributes.get("categoryTypeId");

		if (categoryTypeId != null) {
			setCategoryTypeId(categoryTypeId);
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

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer displayPriority = (Integer)attributes.get("displayPriority");

		if (displayPriority != null) {
			setDisplayPriority(displayPriority);
		}
	}

	/**
	* Returns the primary key of this t t h c_ category.
	*
	* @return the primary key of this t t h c_ category
	*/
	public long getPrimaryKey() {
		return _tthc_Category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t t h c_ category.
	*
	* @param primaryKey the primary key of this t t h c_ category
	*/
	public void setPrimaryKey(long primaryKey) {
		_tthc_Category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this t t h c_ category.
	*
	* @return the category ID of this t t h c_ category
	*/
	public long getCategoryId() {
		return _tthc_Category.getCategoryId();
	}

	/**
	* Sets the category ID of this t t h c_ category.
	*
	* @param categoryId the category ID of this t t h c_ category
	*/
	public void setCategoryId(long categoryId) {
		_tthc_Category.setCategoryId(categoryId);
	}

	/**
	* Returns the parent ID of this t t h c_ category.
	*
	* @return the parent ID of this t t h c_ category
	*/
	public long getParentId() {
		return _tthc_Category.getParentId();
	}

	/**
	* Sets the parent ID of this t t h c_ category.
	*
	* @param parentId the parent ID of this t t h c_ category
	*/
	public void setParentId(long parentId) {
		_tthc_Category.setParentId(parentId);
	}

	/**
	* Returns the category type ID of this t t h c_ category.
	*
	* @return the category type ID of this t t h c_ category
	*/
	public int getCategoryTypeId() {
		return _tthc_Category.getCategoryTypeId();
	}

	/**
	* Sets the category type ID of this t t h c_ category.
	*
	* @param categoryTypeId the category type ID of this t t h c_ category
	*/
	public void setCategoryTypeId(int categoryTypeId) {
		_tthc_Category.setCategoryTypeId(categoryTypeId);
	}

	/**
	* Returns the company ID of this t t h c_ category.
	*
	* @return the company ID of this t t h c_ category
	*/
	public long getCompanyId() {
		return _tthc_Category.getCompanyId();
	}

	/**
	* Sets the company ID of this t t h c_ category.
	*
	* @param companyId the company ID of this t t h c_ category
	*/
	public void setCompanyId(long companyId) {
		_tthc_Category.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this t t h c_ category.
	*
	* @return the group ID of this t t h c_ category
	*/
	public long getGroupId() {
		return _tthc_Category.getGroupId();
	}

	/**
	* Sets the group ID of this t t h c_ category.
	*
	* @param groupId the group ID of this t t h c_ category
	*/
	public void setGroupId(long groupId) {
		_tthc_Category.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this t t h c_ category.
	*
	* @return the user ID of this t t h c_ category
	*/
	public long getUserId() {
		return _tthc_Category.getUserId();
	}

	/**
	* Sets the user ID of this t t h c_ category.
	*
	* @param userId the user ID of this t t h c_ category
	*/
	public void setUserId(long userId) {
		_tthc_Category.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t t h c_ category.
	*
	* @return the user uuid of this t t h c_ category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_Category.getUserUuid();
	}

	/**
	* Sets the user uuid of this t t h c_ category.
	*
	* @param userUuid the user uuid of this t t h c_ category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tthc_Category.setUserUuid(userUuid);
	}

	/**
	* Returns the category name of this t t h c_ category.
	*
	* @return the category name of this t t h c_ category
	*/
	public java.lang.String getCategoryName() {
		return _tthc_Category.getCategoryName();
	}

	/**
	* Sets the category name of this t t h c_ category.
	*
	* @param categoryName the category name of this t t h c_ category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_tthc_Category.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this t t h c_ category.
	*
	* @return the category desc of this t t h c_ category
	*/
	public java.lang.String getCategoryDesc() {
		return _tthc_Category.getCategoryDesc();
	}

	/**
	* Sets the category desc of this t t h c_ category.
	*
	* @param categoryDesc the category desc of this t t h c_ category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_tthc_Category.setCategoryDesc(categoryDesc);
	}

	/**
	* Returns the create date of this t t h c_ category.
	*
	* @return the create date of this t t h c_ category
	*/
	public java.util.Date getCreateDate() {
		return _tthc_Category.getCreateDate();
	}

	/**
	* Sets the create date of this t t h c_ category.
	*
	* @param createDate the create date of this t t h c_ category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_tthc_Category.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t t h c_ category.
	*
	* @return the modified date of this t t h c_ category
	*/
	public java.util.Date getModifiedDate() {
		return _tthc_Category.getModifiedDate();
	}

	/**
	* Sets the modified date of this t t h c_ category.
	*
	* @param modifiedDate the modified date of this t t h c_ category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tthc_Category.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the display priority of this t t h c_ category.
	*
	* @return the display priority of this t t h c_ category
	*/
	public int getDisplayPriority() {
		return _tthc_Category.getDisplayPriority();
	}

	/**
	* Sets the display priority of this t t h c_ category.
	*
	* @param displayPriority the display priority of this t t h c_ category
	*/
	public void setDisplayPriority(int displayPriority) {
		_tthc_Category.setDisplayPriority(displayPriority);
	}

	public boolean isNew() {
		return _tthc_Category.isNew();
	}

	public void setNew(boolean n) {
		_tthc_Category.setNew(n);
	}

	public boolean isCachedModel() {
		return _tthc_Category.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tthc_Category.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tthc_Category.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tthc_Category.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tthc_Category.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tthc_Category.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tthc_Category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TTHC_CategoryWrapper((TTHC_Category)_tthc_Category.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category) {
		return _tthc_Category.compareTo(tthc_Category);
	}

	@Override
	public int hashCode() {
		return _tthc_Category.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.tthc.model.TTHC_Category> toCacheModel() {
		return _tthc_Category.toCacheModel();
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Category toEscapedModel() {
		return new TTHC_CategoryWrapper(_tthc_Category.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tthc_Category.toString();
	}

	public java.lang.String toXmlString() {
		return _tthc_Category.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tthc_Category.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TTHC_Category getWrappedTTHC_Category() {
		return _tthc_Category;
	}

	public TTHC_Category getWrappedModel() {
		return _tthc_Category;
	}

	public void resetOriginalValues() {
		_tthc_Category.resetOriginalValues();
	}

	private TTHC_Category _tthc_Category;
}