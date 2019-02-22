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

package com.portal_egov.portlet.proposition_feedback.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PropositionCategory}.
 * </p>
 *
 * @author    HungDX
 * @see       PropositionCategory
 * @generated
 */
public class PropositionCategoryWrapper implements PropositionCategory,
	ModelWrapper<PropositionCategory> {
	public PropositionCategoryWrapper(PropositionCategory propositionCategory) {
		_propositionCategory = propositionCategory;
	}

	public Class<?> getModelClass() {
		return PropositionCategory.class;
	}

	public String getModelClassName() {
		return PropositionCategory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("categoryTypeId", getCategoryTypeId());
		attributes.put("parentId", getParentId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
		attributes.put("propositionCount", getPropositionCount());
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

		Integer categoryTypeId = (Integer)attributes.get("categoryTypeId");

		if (categoryTypeId != null) {
			setCategoryTypeId(categoryTypeId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryDesc = (String)attributes.get("categoryDesc");

		if (categoryDesc != null) {
			setCategoryDesc(categoryDesc);
		}

		Integer propositionCount = (Integer)attributes.get("propositionCount");

		if (propositionCount != null) {
			setPropositionCount(propositionCount);
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
	* Returns the primary key of this proposition category.
	*
	* @return the primary key of this proposition category
	*/
	public long getPrimaryKey() {
		return _propositionCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this proposition category.
	*
	* @param primaryKey the primary key of this proposition category
	*/
	public void setPrimaryKey(long primaryKey) {
		_propositionCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this proposition category.
	*
	* @return the category ID of this proposition category
	*/
	public long getCategoryId() {
		return _propositionCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this proposition category.
	*
	* @param categoryId the category ID of this proposition category
	*/
	public void setCategoryId(long categoryId) {
		_propositionCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the company ID of this proposition category.
	*
	* @return the company ID of this proposition category
	*/
	public long getCompanyId() {
		return _propositionCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this proposition category.
	*
	* @param companyId the company ID of this proposition category
	*/
	public void setCompanyId(long companyId) {
		_propositionCategory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this proposition category.
	*
	* @return the group ID of this proposition category
	*/
	public long getGroupId() {
		return _propositionCategory.getGroupId();
	}

	/**
	* Sets the group ID of this proposition category.
	*
	* @param groupId the group ID of this proposition category
	*/
	public void setGroupId(long groupId) {
		_propositionCategory.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this proposition category.
	*
	* @return the user ID of this proposition category
	*/
	public long getUserId() {
		return _propositionCategory.getUserId();
	}

	/**
	* Sets the user ID of this proposition category.
	*
	* @param userId the user ID of this proposition category
	*/
	public void setUserId(long userId) {
		_propositionCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this proposition category.
	*
	* @return the user uuid of this proposition category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _propositionCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this proposition category.
	*
	* @param userUuid the user uuid of this proposition category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_propositionCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the category type ID of this proposition category.
	*
	* @return the category type ID of this proposition category
	*/
	public int getCategoryTypeId() {
		return _propositionCategory.getCategoryTypeId();
	}

	/**
	* Sets the category type ID of this proposition category.
	*
	* @param categoryTypeId the category type ID of this proposition category
	*/
	public void setCategoryTypeId(int categoryTypeId) {
		_propositionCategory.setCategoryTypeId(categoryTypeId);
	}

	/**
	* Returns the parent ID of this proposition category.
	*
	* @return the parent ID of this proposition category
	*/
	public long getParentId() {
		return _propositionCategory.getParentId();
	}

	/**
	* Sets the parent ID of this proposition category.
	*
	* @param parentId the parent ID of this proposition category
	*/
	public void setParentId(long parentId) {
		_propositionCategory.setParentId(parentId);
	}

	/**
	* Returns the category name of this proposition category.
	*
	* @return the category name of this proposition category
	*/
	public java.lang.String getCategoryName() {
		return _propositionCategory.getCategoryName();
	}

	/**
	* Sets the category name of this proposition category.
	*
	* @param categoryName the category name of this proposition category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_propositionCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this proposition category.
	*
	* @return the category desc of this proposition category
	*/
	public java.lang.String getCategoryDesc() {
		return _propositionCategory.getCategoryDesc();
	}

	/**
	* Sets the category desc of this proposition category.
	*
	* @param categoryDesc the category desc of this proposition category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_propositionCategory.setCategoryDesc(categoryDesc);
	}

	/**
	* Returns the proposition count of this proposition category.
	*
	* @return the proposition count of this proposition category
	*/
	public int getPropositionCount() {
		return _propositionCategory.getPropositionCount();
	}

	/**
	* Sets the proposition count of this proposition category.
	*
	* @param propositionCount the proposition count of this proposition category
	*/
	public void setPropositionCount(int propositionCount) {
		_propositionCategory.setPropositionCount(propositionCount);
	}

	/**
	* Returns the create date of this proposition category.
	*
	* @return the create date of this proposition category
	*/
	public java.util.Date getCreateDate() {
		return _propositionCategory.getCreateDate();
	}

	/**
	* Sets the create date of this proposition category.
	*
	* @param createDate the create date of this proposition category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_propositionCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this proposition category.
	*
	* @return the modified date of this proposition category
	*/
	public java.util.Date getModifiedDate() {
		return _propositionCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this proposition category.
	*
	* @param modifiedDate the modified date of this proposition category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_propositionCategory.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _propositionCategory.isNew();
	}

	public void setNew(boolean n) {
		_propositionCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _propositionCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_propositionCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _propositionCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _propositionCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_propositionCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _propositionCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_propositionCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PropositionCategoryWrapper((PropositionCategory)_propositionCategory.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory) {
		return _propositionCategory.compareTo(propositionCategory);
	}

	@Override
	public int hashCode() {
		return _propositionCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> toCacheModel() {
		return _propositionCategory.toCacheModel();
	}

	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory toEscapedModel() {
		return new PropositionCategoryWrapper(_propositionCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _propositionCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _propositionCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_propositionCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PropositionCategory getWrappedPropositionCategory() {
		return _propositionCategory;
	}

	public PropositionCategory getWrappedModel() {
		return _propositionCategory;
	}

	public void resetOriginalValues() {
		_propositionCategory.resetOriginalValues();
	}

	private PropositionCategory _propositionCategory;
}