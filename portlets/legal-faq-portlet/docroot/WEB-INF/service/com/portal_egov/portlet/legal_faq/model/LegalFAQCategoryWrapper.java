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

package com.portal_egov.portlet.legal_faq.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegalFAQCategory}.
 * </p>
 *
 * @author    HungDX
 * @see       LegalFAQCategory
 * @generated
 */
public class LegalFAQCategoryWrapper implements LegalFAQCategory,
	ModelWrapper<LegalFAQCategory> {
	public LegalFAQCategoryWrapper(LegalFAQCategory legalFAQCategory) {
		_legalFAQCategory = legalFAQCategory;
	}

	public Class<?> getModelClass() {
		return LegalFAQCategory.class;
	}

	public String getModelClassName() {
		return LegalFAQCategory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("parentId", getParentId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryDesc", getCategoryDesc());
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
	* Returns the primary key of this legal f a q category.
	*
	* @return the primary key of this legal f a q category
	*/
	public long getPrimaryKey() {
		return _legalFAQCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal f a q category.
	*
	* @param primaryKey the primary key of this legal f a q category
	*/
	public void setPrimaryKey(long primaryKey) {
		_legalFAQCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this legal f a q category.
	*
	* @return the category ID of this legal f a q category
	*/
	public long getCategoryId() {
		return _legalFAQCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this legal f a q category.
	*
	* @param categoryId the category ID of this legal f a q category
	*/
	public void setCategoryId(long categoryId) {
		_legalFAQCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the company ID of this legal f a q category.
	*
	* @return the company ID of this legal f a q category
	*/
	public long getCompanyId() {
		return _legalFAQCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this legal f a q category.
	*
	* @param companyId the company ID of this legal f a q category
	*/
	public void setCompanyId(long companyId) {
		_legalFAQCategory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this legal f a q category.
	*
	* @return the group ID of this legal f a q category
	*/
	public long getGroupId() {
		return _legalFAQCategory.getGroupId();
	}

	/**
	* Sets the group ID of this legal f a q category.
	*
	* @param groupId the group ID of this legal f a q category
	*/
	public void setGroupId(long groupId) {
		_legalFAQCategory.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this legal f a q category.
	*
	* @return the user ID of this legal f a q category
	*/
	public long getUserId() {
		return _legalFAQCategory.getUserId();
	}

	/**
	* Sets the user ID of this legal f a q category.
	*
	* @param userId the user ID of this legal f a q category
	*/
	public void setUserId(long userId) {
		_legalFAQCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legal f a q category.
	*
	* @return the user uuid of this legal f a q category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this legal f a q category.
	*
	* @param userUuid the user uuid of this legal f a q category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_legalFAQCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the parent ID of this legal f a q category.
	*
	* @return the parent ID of this legal f a q category
	*/
	public long getParentId() {
		return _legalFAQCategory.getParentId();
	}

	/**
	* Sets the parent ID of this legal f a q category.
	*
	* @param parentId the parent ID of this legal f a q category
	*/
	public void setParentId(long parentId) {
		_legalFAQCategory.setParentId(parentId);
	}

	/**
	* Returns the category name of this legal f a q category.
	*
	* @return the category name of this legal f a q category
	*/
	public java.lang.String getCategoryName() {
		return _legalFAQCategory.getCategoryName();
	}

	/**
	* Sets the category name of this legal f a q category.
	*
	* @param categoryName the category name of this legal f a q category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_legalFAQCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this legal f a q category.
	*
	* @return the category desc of this legal f a q category
	*/
	public java.lang.String getCategoryDesc() {
		return _legalFAQCategory.getCategoryDesc();
	}

	/**
	* Sets the category desc of this legal f a q category.
	*
	* @param categoryDesc the category desc of this legal f a q category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_legalFAQCategory.setCategoryDesc(categoryDesc);
	}

	/**
	* Returns the create date of this legal f a q category.
	*
	* @return the create date of this legal f a q category
	*/
	public java.util.Date getCreateDate() {
		return _legalFAQCategory.getCreateDate();
	}

	/**
	* Sets the create date of this legal f a q category.
	*
	* @param createDate the create date of this legal f a q category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_legalFAQCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this legal f a q category.
	*
	* @return the modified date of this legal f a q category
	*/
	public java.util.Date getModifiedDate() {
		return _legalFAQCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this legal f a q category.
	*
	* @param modifiedDate the modified date of this legal f a q category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_legalFAQCategory.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _legalFAQCategory.isNew();
	}

	public void setNew(boolean n) {
		_legalFAQCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _legalFAQCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_legalFAQCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _legalFAQCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _legalFAQCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legalFAQCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legalFAQCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legalFAQCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegalFAQCategoryWrapper((LegalFAQCategory)_legalFAQCategory.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory) {
		return _legalFAQCategory.compareTo(legalFAQCategory);
	}

	@Override
	public int hashCode() {
		return _legalFAQCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> toCacheModel() {
		return _legalFAQCategory.toCacheModel();
	}

	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory toEscapedModel() {
		return new LegalFAQCategoryWrapper(_legalFAQCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legalFAQCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _legalFAQCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legalFAQCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LegalFAQCategory getWrappedLegalFAQCategory() {
		return _legalFAQCategory;
	}

	public LegalFAQCategory getWrappedModel() {
		return _legalFAQCategory;
	}

	public void resetOriginalValues() {
		_legalFAQCategory.resetOriginalValues();
	}

	private LegalFAQCategory _legalFAQCategory;
}