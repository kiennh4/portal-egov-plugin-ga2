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

package com.portal_egov.portlet.citizen_inquiry.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CitizenInquiryCategory}.
 * </p>
 *
 * @author    HungDX
 * @see       CitizenInquiryCategory
 * @generated
 */
public class CitizenInquiryCategoryWrapper implements CitizenInquiryCategory,
	ModelWrapper<CitizenInquiryCategory> {
	public CitizenInquiryCategoryWrapper(
		CitizenInquiryCategory citizenInquiryCategory) {
		_citizenInquiryCategory = citizenInquiryCategory;
	}

	public Class<?> getModelClass() {
		return CitizenInquiryCategory.class;
	}

	public String getModelClassName() {
		return CitizenInquiryCategory.class.getName();
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
	* Returns the primary key of this citizen inquiry category.
	*
	* @return the primary key of this citizen inquiry category
	*/
	public long getPrimaryKey() {
		return _citizenInquiryCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this citizen inquiry category.
	*
	* @param primaryKey the primary key of this citizen inquiry category
	*/
	public void setPrimaryKey(long primaryKey) {
		_citizenInquiryCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this citizen inquiry category.
	*
	* @return the category ID of this citizen inquiry category
	*/
	public long getCategoryId() {
		return _citizenInquiryCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this citizen inquiry category.
	*
	* @param categoryId the category ID of this citizen inquiry category
	*/
	public void setCategoryId(long categoryId) {
		_citizenInquiryCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the group ID of this citizen inquiry category.
	*
	* @return the group ID of this citizen inquiry category
	*/
	public long getGroupId() {
		return _citizenInquiryCategory.getGroupId();
	}

	/**
	* Sets the group ID of this citizen inquiry category.
	*
	* @param groupId the group ID of this citizen inquiry category
	*/
	public void setGroupId(long groupId) {
		_citizenInquiryCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this citizen inquiry category.
	*
	* @return the company ID of this citizen inquiry category
	*/
	public long getCompanyId() {
		return _citizenInquiryCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this citizen inquiry category.
	*
	* @param companyId the company ID of this citizen inquiry category
	*/
	public void setCompanyId(long companyId) {
		_citizenInquiryCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this citizen inquiry category.
	*
	* @return the user ID of this citizen inquiry category
	*/
	public long getUserId() {
		return _citizenInquiryCategory.getUserId();
	}

	/**
	* Sets the user ID of this citizen inquiry category.
	*
	* @param userId the user ID of this citizen inquiry category
	*/
	public void setUserId(long userId) {
		_citizenInquiryCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this citizen inquiry category.
	*
	* @return the user uuid of this citizen inquiry category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _citizenInquiryCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this citizen inquiry category.
	*
	* @param userUuid the user uuid of this citizen inquiry category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_citizenInquiryCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this citizen inquiry category.
	*
	* @return the user name of this citizen inquiry category
	*/
	public java.lang.String getUserName() {
		return _citizenInquiryCategory.getUserName();
	}

	/**
	* Sets the user name of this citizen inquiry category.
	*
	* @param userName the user name of this citizen inquiry category
	*/
	public void setUserName(java.lang.String userName) {
		_citizenInquiryCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this citizen inquiry category.
	*
	* @return the create date of this citizen inquiry category
	*/
	public java.util.Date getCreateDate() {
		return _citizenInquiryCategory.getCreateDate();
	}

	/**
	* Sets the create date of this citizen inquiry category.
	*
	* @param createDate the create date of this citizen inquiry category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_citizenInquiryCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this citizen inquiry category.
	*
	* @return the modified date of this citizen inquiry category
	*/
	public java.util.Date getModifiedDate() {
		return _citizenInquiryCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this citizen inquiry category.
	*
	* @param modifiedDate the modified date of this citizen inquiry category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_citizenInquiryCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category name of this citizen inquiry category.
	*
	* @return the category name of this citizen inquiry category
	*/
	public java.lang.String getCategoryName() {
		return _citizenInquiryCategory.getCategoryName();
	}

	/**
	* Sets the category name of this citizen inquiry category.
	*
	* @param categoryName the category name of this citizen inquiry category
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_citizenInquiryCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the category desc of this citizen inquiry category.
	*
	* @return the category desc of this citizen inquiry category
	*/
	public java.lang.String getCategoryDesc() {
		return _citizenInquiryCategory.getCategoryDesc();
	}

	/**
	* Sets the category desc of this citizen inquiry category.
	*
	* @param categoryDesc the category desc of this citizen inquiry category
	*/
	public void setCategoryDesc(java.lang.String categoryDesc) {
		_citizenInquiryCategory.setCategoryDesc(categoryDesc);
	}

	public boolean isNew() {
		return _citizenInquiryCategory.isNew();
	}

	public void setNew(boolean n) {
		_citizenInquiryCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _citizenInquiryCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_citizenInquiryCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _citizenInquiryCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _citizenInquiryCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_citizenInquiryCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _citizenInquiryCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_citizenInquiryCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CitizenInquiryCategoryWrapper((CitizenInquiryCategory)_citizenInquiryCategory.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory) {
		return _citizenInquiryCategory.compareTo(citizenInquiryCategory);
	}

	@Override
	public int hashCode() {
		return _citizenInquiryCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> toCacheModel() {
		return _citizenInquiryCategory.toCacheModel();
	}

	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory toEscapedModel() {
		return new CitizenInquiryCategoryWrapper(_citizenInquiryCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _citizenInquiryCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _citizenInquiryCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_citizenInquiryCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CitizenInquiryCategory getWrappedCitizenInquiryCategory() {
		return _citizenInquiryCategory;
	}

	public CitizenInquiryCategory getWrappedModel() {
		return _citizenInquiryCategory;
	}

	public void resetOriginalValues() {
		_citizenInquiryCategory.resetOriginalValues();
	}

	private CitizenInquiryCategory _citizenInquiryCategory;
}