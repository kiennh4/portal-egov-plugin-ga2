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
 * This class is a wrapper for {@link TTHC_Attribute}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_Attribute
 * @generated
 */
public class TTHC_AttributeWrapper implements TTHC_Attribute,
	ModelWrapper<TTHC_Attribute> {
	public TTHC_AttributeWrapper(TTHC_Attribute tthc_Attribute) {
		_tthc_Attribute = tthc_Attribute;
	}

	public Class<?> getModelClass() {
		return TTHC_Attribute.class;
	}

	public String getModelClassName() {
		return TTHC_Attribute.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attributeId", getAttributeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("tthcEntryId", getTthcEntryId());
		attributes.put("attributeTypeId", getAttributeTypeId());
		attributes.put("attributeIndex", getAttributeIndex());
		attributes.put("attributeName", getAttributeName());
		attributes.put("attributeValue", getAttributeValue());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long attributeId = (Long)attributes.get("attributeId");

		if (attributeId != null) {
			setAttributeId(attributeId);
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

		Long tthcEntryId = (Long)attributes.get("tthcEntryId");

		if (tthcEntryId != null) {
			setTthcEntryId(tthcEntryId);
		}

		Integer attributeTypeId = (Integer)attributes.get("attributeTypeId");

		if (attributeTypeId != null) {
			setAttributeTypeId(attributeTypeId);
		}

		Integer attributeIndex = (Integer)attributes.get("attributeIndex");

		if (attributeIndex != null) {
			setAttributeIndex(attributeIndex);
		}

		String attributeName = (String)attributes.get("attributeName");

		if (attributeName != null) {
			setAttributeName(attributeName);
		}

		String attributeValue = (String)attributes.get("attributeValue");

		if (attributeValue != null) {
			setAttributeValue(attributeValue);
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
	* Returns the primary key of this t t h c_ attribute.
	*
	* @return the primary key of this t t h c_ attribute
	*/
	public long getPrimaryKey() {
		return _tthc_Attribute.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t t h c_ attribute.
	*
	* @param primaryKey the primary key of this t t h c_ attribute
	*/
	public void setPrimaryKey(long primaryKey) {
		_tthc_Attribute.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the attribute ID of this t t h c_ attribute.
	*
	* @return the attribute ID of this t t h c_ attribute
	*/
	public long getAttributeId() {
		return _tthc_Attribute.getAttributeId();
	}

	/**
	* Sets the attribute ID of this t t h c_ attribute.
	*
	* @param attributeId the attribute ID of this t t h c_ attribute
	*/
	public void setAttributeId(long attributeId) {
		_tthc_Attribute.setAttributeId(attributeId);
	}

	/**
	* Returns the company ID of this t t h c_ attribute.
	*
	* @return the company ID of this t t h c_ attribute
	*/
	public long getCompanyId() {
		return _tthc_Attribute.getCompanyId();
	}

	/**
	* Sets the company ID of this t t h c_ attribute.
	*
	* @param companyId the company ID of this t t h c_ attribute
	*/
	public void setCompanyId(long companyId) {
		_tthc_Attribute.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this t t h c_ attribute.
	*
	* @return the group ID of this t t h c_ attribute
	*/
	public long getGroupId() {
		return _tthc_Attribute.getGroupId();
	}

	/**
	* Sets the group ID of this t t h c_ attribute.
	*
	* @param groupId the group ID of this t t h c_ attribute
	*/
	public void setGroupId(long groupId) {
		_tthc_Attribute.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this t t h c_ attribute.
	*
	* @return the user ID of this t t h c_ attribute
	*/
	public long getUserId() {
		return _tthc_Attribute.getUserId();
	}

	/**
	* Sets the user ID of this t t h c_ attribute.
	*
	* @param userId the user ID of this t t h c_ attribute
	*/
	public void setUserId(long userId) {
		_tthc_Attribute.setUserId(userId);
	}

	/**
	* Returns the user uuid of this t t h c_ attribute.
	*
	* @return the user uuid of this t t h c_ attribute
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_Attribute.getUserUuid();
	}

	/**
	* Sets the user uuid of this t t h c_ attribute.
	*
	* @param userUuid the user uuid of this t t h c_ attribute
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tthc_Attribute.setUserUuid(userUuid);
	}

	/**
	* Returns the tthc entry ID of this t t h c_ attribute.
	*
	* @return the tthc entry ID of this t t h c_ attribute
	*/
	public long getTthcEntryId() {
		return _tthc_Attribute.getTthcEntryId();
	}

	/**
	* Sets the tthc entry ID of this t t h c_ attribute.
	*
	* @param tthcEntryId the tthc entry ID of this t t h c_ attribute
	*/
	public void setTthcEntryId(long tthcEntryId) {
		_tthc_Attribute.setTthcEntryId(tthcEntryId);
	}

	/**
	* Returns the attribute type ID of this t t h c_ attribute.
	*
	* @return the attribute type ID of this t t h c_ attribute
	*/
	public int getAttributeTypeId() {
		return _tthc_Attribute.getAttributeTypeId();
	}

	/**
	* Sets the attribute type ID of this t t h c_ attribute.
	*
	* @param attributeTypeId the attribute type ID of this t t h c_ attribute
	*/
	public void setAttributeTypeId(int attributeTypeId) {
		_tthc_Attribute.setAttributeTypeId(attributeTypeId);
	}

	/**
	* Returns the attribute index of this t t h c_ attribute.
	*
	* @return the attribute index of this t t h c_ attribute
	*/
	public int getAttributeIndex() {
		return _tthc_Attribute.getAttributeIndex();
	}

	/**
	* Sets the attribute index of this t t h c_ attribute.
	*
	* @param attributeIndex the attribute index of this t t h c_ attribute
	*/
	public void setAttributeIndex(int attributeIndex) {
		_tthc_Attribute.setAttributeIndex(attributeIndex);
	}

	/**
	* Returns the attribute name of this t t h c_ attribute.
	*
	* @return the attribute name of this t t h c_ attribute
	*/
	public java.lang.String getAttributeName() {
		return _tthc_Attribute.getAttributeName();
	}

	/**
	* Sets the attribute name of this t t h c_ attribute.
	*
	* @param attributeName the attribute name of this t t h c_ attribute
	*/
	public void setAttributeName(java.lang.String attributeName) {
		_tthc_Attribute.setAttributeName(attributeName);
	}

	/**
	* Returns the attribute value of this t t h c_ attribute.
	*
	* @return the attribute value of this t t h c_ attribute
	*/
	public java.lang.String getAttributeValue() {
		return _tthc_Attribute.getAttributeValue();
	}

	/**
	* Sets the attribute value of this t t h c_ attribute.
	*
	* @param attributeValue the attribute value of this t t h c_ attribute
	*/
	public void setAttributeValue(java.lang.String attributeValue) {
		_tthc_Attribute.setAttributeValue(attributeValue);
	}

	/**
	* Returns the create date of this t t h c_ attribute.
	*
	* @return the create date of this t t h c_ attribute
	*/
	public java.util.Date getCreateDate() {
		return _tthc_Attribute.getCreateDate();
	}

	/**
	* Sets the create date of this t t h c_ attribute.
	*
	* @param createDate the create date of this t t h c_ attribute
	*/
	public void setCreateDate(java.util.Date createDate) {
		_tthc_Attribute.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this t t h c_ attribute.
	*
	* @return the modified date of this t t h c_ attribute
	*/
	public java.util.Date getModifiedDate() {
		return _tthc_Attribute.getModifiedDate();
	}

	/**
	* Sets the modified date of this t t h c_ attribute.
	*
	* @param modifiedDate the modified date of this t t h c_ attribute
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tthc_Attribute.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _tthc_Attribute.isNew();
	}

	public void setNew(boolean n) {
		_tthc_Attribute.setNew(n);
	}

	public boolean isCachedModel() {
		return _tthc_Attribute.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tthc_Attribute.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tthc_Attribute.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tthc_Attribute.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tthc_Attribute.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tthc_Attribute.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tthc_Attribute.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TTHC_AttributeWrapper((TTHC_Attribute)_tthc_Attribute.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute) {
		return _tthc_Attribute.compareTo(tthc_Attribute);
	}

	@Override
	public int hashCode() {
		return _tthc_Attribute.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.tthc.model.TTHC_Attribute> toCacheModel() {
		return _tthc_Attribute.toCacheModel();
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Attribute toEscapedModel() {
		return new TTHC_AttributeWrapper(_tthc_Attribute.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tthc_Attribute.toString();
	}

	public java.lang.String toXmlString() {
		return _tthc_Attribute.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tthc_Attribute.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TTHC_Attribute getWrappedTTHC_Attribute() {
		return _tthc_Attribute;
	}

	public TTHC_Attribute getWrappedModel() {
		return _tthc_Attribute;
	}

	public void resetOriginalValues() {
		_tthc_Attribute.resetOriginalValues();
	}

	private TTHC_Attribute _tthc_Attribute;
}