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

package com.portal_egov.portlet.vbpq.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VBPQ_Category}.
 * </p>
 *
 * @author    HungDX
 * @see       VBPQ_Category
 * @generated
 */
public class VBPQ_CategoryWrapper implements VBPQ_Category,
	ModelWrapper<VBPQ_Category> {
	public VBPQ_CategoryWrapper(VBPQ_Category vbpq_Category) {
		_vbpq_Category = vbpq_Category;
	}

	public Class<?> getModelClass() {
		return VBPQ_Category.class;
	}

	public String getModelClassName() {
		return VBPQ_Category.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("parentId", getParentId());
		attributes.put("typeId", getTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());
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

		Integer typeId = (Integer)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Integer displayPriority = (Integer)attributes.get("displayPriority");

		if (displayPriority != null) {
			setDisplayPriority(displayPriority);
		}
	}

	/**
	* Returns the primary key of this v b p q_ category.
	*
	* @return the primary key of this v b p q_ category
	*/
	public long getPrimaryKey() {
		return _vbpq_Category.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v b p q_ category.
	*
	* @param primaryKey the primary key of this v b p q_ category
	*/
	public void setPrimaryKey(long primaryKey) {
		_vbpq_Category.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this v b p q_ category.
	*
	* @return the category ID of this v b p q_ category
	*/
	public long getCategoryId() {
		return _vbpq_Category.getCategoryId();
	}

	/**
	* Sets the category ID of this v b p q_ category.
	*
	* @param categoryId the category ID of this v b p q_ category
	*/
	public void setCategoryId(long categoryId) {
		_vbpq_Category.setCategoryId(categoryId);
	}

	/**
	* Returns the parent ID of this v b p q_ category.
	*
	* @return the parent ID of this v b p q_ category
	*/
	public long getParentId() {
		return _vbpq_Category.getParentId();
	}

	/**
	* Sets the parent ID of this v b p q_ category.
	*
	* @param parentId the parent ID of this v b p q_ category
	*/
	public void setParentId(long parentId) {
		_vbpq_Category.setParentId(parentId);
	}

	/**
	* Returns the type ID of this v b p q_ category.
	*
	* @return the type ID of this v b p q_ category
	*/
	public int getTypeId() {
		return _vbpq_Category.getTypeId();
	}

	/**
	* Sets the type ID of this v b p q_ category.
	*
	* @param typeId the type ID of this v b p q_ category
	*/
	public void setTypeId(int typeId) {
		_vbpq_Category.setTypeId(typeId);
	}

	/**
	* Returns the company ID of this v b p q_ category.
	*
	* @return the company ID of this v b p q_ category
	*/
	public long getCompanyId() {
		return _vbpq_Category.getCompanyId();
	}

	/**
	* Sets the company ID of this v b p q_ category.
	*
	* @param companyId the company ID of this v b p q_ category
	*/
	public void setCompanyId(long companyId) {
		_vbpq_Category.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this v b p q_ category.
	*
	* @return the group ID of this v b p q_ category
	*/
	public long getGroupId() {
		return _vbpq_Category.getGroupId();
	}

	/**
	* Sets the group ID of this v b p q_ category.
	*
	* @param groupId the group ID of this v b p q_ category
	*/
	public void setGroupId(long groupId) {
		_vbpq_Category.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this v b p q_ category.
	*
	* @return the user ID of this v b p q_ category
	*/
	public long getUserId() {
		return _vbpq_Category.getUserId();
	}

	/**
	* Sets the user ID of this v b p q_ category.
	*
	* @param userId the user ID of this v b p q_ category
	*/
	public void setUserId(long userId) {
		_vbpq_Category.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v b p q_ category.
	*
	* @return the user uuid of this v b p q_ category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vbpq_Category.getUserUuid();
	}

	/**
	* Sets the user uuid of this v b p q_ category.
	*
	* @param userUuid the user uuid of this v b p q_ category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vbpq_Category.setUserUuid(userUuid);
	}

	/**
	* Returns the category name of this v b p q_ category.
	*
	* @return the category name of this v b p q_ category
	*/
	public java.lang.String getCategoryName() {
		return _vbpq_Category.getCategoryName();
	}

	/**
	* Sets the category name of this v b p q_ category.
	*
	* @param categoryName the category name of this v b p q_ category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_vbpq_Category.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this v b p q_ category.
	*
	* @return the category desc of this v b p q_ category
	*/
	public java.lang.String getCategoryDesc() {
		return _vbpq_Category.getCategoryDesc();
	}

	/**
	* Sets the category desc of this v b p q_ category.
	*
	* @param categoryDesc the category desc of this v b p q_ category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_vbpq_Category.setCategoryDesc(categoryDesc);
	}

	/**
	* Returns the create date of this v b p q_ category.
	*
	* @return the create date of this v b p q_ category
	*/
	public java.util.Date getCreateDate() {
		return _vbpq_Category.getCreateDate();
	}

	/**
	* Sets the create date of this v b p q_ category.
	*
	* @param createDate the create date of this v b p q_ category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_vbpq_Category.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this v b p q_ category.
	*
	* @return the modified date of this v b p q_ category
	*/
	public java.util.Date getModifiedDate() {
		return _vbpq_Category.getModifiedDate();
	}

	/**
	* Sets the modified date of this v b p q_ category.
	*
	* @param modifiedDate the modified date of this v b p q_ category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vbpq_Category.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the active of this v b p q_ category.
	*
	* @return the active of this v b p q_ category
	*/
	public boolean getActive() {
		return _vbpq_Category.getActive();
	}

	/**
	* Returns <code>true</code> if this v b p q_ category is active.
	*
	* @return <code>true</code> if this v b p q_ category is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _vbpq_Category.isActive();
	}

	/**
	* Sets whether this v b p q_ category is active.
	*
	* @param active the active of this v b p q_ category
	*/
	public void setActive(boolean active) {
		_vbpq_Category.setActive(active);
	}

	/**
	* Returns the display priority of this v b p q_ category.
	*
	* @return the display priority of this v b p q_ category
	*/
	public int getDisplayPriority() {
		return _vbpq_Category.getDisplayPriority();
	}

	/**
	* Sets the display priority of this v b p q_ category.
	*
	* @param displayPriority the display priority of this v b p q_ category
	*/
	public void setDisplayPriority(int displayPriority) {
		_vbpq_Category.setDisplayPriority(displayPriority);
	}

	public boolean isNew() {
		return _vbpq_Category.isNew();
	}

	public void setNew(boolean n) {
		_vbpq_Category.setNew(n);
	}

	public boolean isCachedModel() {
		return _vbpq_Category.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vbpq_Category.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vbpq_Category.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vbpq_Category.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vbpq_Category.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vbpq_Category.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vbpq_Category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VBPQ_CategoryWrapper((VBPQ_Category)_vbpq_Category.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.vbpq.model.VBPQ_Category vbpq_Category) {
		return _vbpq_Category.compareTo(vbpq_Category);
	}

	@Override
	public int hashCode() {
		return _vbpq_Category.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.vbpq.model.VBPQ_Category> toCacheModel() {
		return _vbpq_Category.toCacheModel();
	}

	public com.portal_egov.portlet.vbpq.model.VBPQ_Category toEscapedModel() {
		return new VBPQ_CategoryWrapper(_vbpq_Category.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vbpq_Category.toString();
	}

	public java.lang.String toXmlString() {
		return _vbpq_Category.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vbpq_Category.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VBPQ_Category getWrappedVBPQ_Category() {
		return _vbpq_Category;
	}

	public VBPQ_Category getWrappedModel() {
		return _vbpq_Category;
	}

	public void resetOriginalValues() {
		_vbpq_Category.resetOriginalValues();
	}

	private VBPQ_Category _vbpq_Category;
}