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

package com.portal_egov.portlet.tthc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TTHC_AttributeLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_AttributeLocalService
 * @generated
 */
public class TTHC_AttributeLocalServiceWrapper
	implements TTHC_AttributeLocalService,
		ServiceWrapper<TTHC_AttributeLocalService> {
	public TTHC_AttributeLocalServiceWrapper(
		TTHC_AttributeLocalService tthc_AttributeLocalService) {
		_tthc_AttributeLocalService = tthc_AttributeLocalService;
	}

	/**
	* Adds the t t h c_ attribute to the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Attribute the t t h c_ attribute
	* @return the t t h c_ attribute that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Attribute addTTHC_Attribute(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.addTTHC_Attribute(tthc_Attribute);
	}

	/**
	* Creates a new t t h c_ attribute with the primary key. Does not add the t t h c_ attribute to the database.
	*
	* @param attributeId the primary key for the new t t h c_ attribute
	* @return the new t t h c_ attribute
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Attribute createTTHC_Attribute(
		long attributeId) {
		return _tthc_AttributeLocalService.createTTHC_Attribute(attributeId);
	}

	/**
	* Deletes the t t h c_ attribute with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attributeId the primary key of the t t h c_ attribute
	* @return the t t h c_ attribute that was removed
	* @throws PortalException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Attribute deleteTTHC_Attribute(
		long attributeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.deleteTTHC_Attribute(attributeId);
	}

	/**
	* Deletes the t t h c_ attribute from the database. Also notifies the appropriate model listeners.
	*
	* @param tthc_Attribute the t t h c_ attribute
	* @return the t t h c_ attribute that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Attribute deleteTTHC_Attribute(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.deleteTTHC_Attribute(tthc_Attribute);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tthc_AttributeLocalService.dynamicQuery();
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
		return _tthc_AttributeLocalService.dynamicQuery(dynamicQuery);
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
		return _tthc_AttributeLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _tthc_AttributeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _tthc_AttributeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Attribute fetchTTHC_Attribute(
		long attributeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.fetchTTHC_Attribute(attributeId);
	}

	/**
	* Returns the t t h c_ attribute with the primary key.
	*
	* @param attributeId the primary key of the t t h c_ attribute
	* @return the t t h c_ attribute
	* @throws PortalException if a t t h c_ attribute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Attribute getTTHC_Attribute(
		long attributeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.getTTHC_Attribute(attributeId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the t t h c_ attributes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ attributes
	* @param end the upper bound of the range of t t h c_ attributes (not inclusive)
	* @return the range of t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> getTTHC_Attributes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.getTTHC_Attributes(start, end);
	}

	/**
	* Returns the number of t t h c_ attributes.
	*
	* @return the number of t t h c_ attributes
	* @throws SystemException if a system exception occurred
	*/
	public int getTTHC_AttributesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.getTTHC_AttributesCount();
	}

	/**
	* Updates the t t h c_ attribute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Attribute the t t h c_ attribute
	* @return the t t h c_ attribute that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Attribute updateTTHC_Attribute(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.updateTTHC_Attribute(tthc_Attribute);
	}

	/**
	* Updates the t t h c_ attribute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tthc_Attribute the t t h c_ attribute
	* @param merge whether to merge the t t h c_ attribute with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the t t h c_ attribute that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Attribute updateTTHC_Attribute(
		com.portal_egov.portlet.tthc.model.TTHC_Attribute tthc_Attribute,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.updateTTHC_Attribute(tthc_Attribute,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tthc_AttributeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tthc_AttributeLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tthc_AttributeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.countAll();
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndCompany(
		long companyId, long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndCompany(companyId,
			tthcEntryId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndCompany(
		long companyId, long tthcEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndCompany(companyId,
			tthcEntryId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndGroup(
		long groupId, long tthcEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndGroup(groupId,
			tthcEntryId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndGroup(
		long groupId, long tthcEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndGroup(groupId,
			tthcEntryId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttrTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndAttrTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttrTypeAndCompany(
		long companyId, long tthcEntryId, int attributeTypeId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndAttrTypeAndCompany(companyId,
			tthcEntryId, attributeTypeId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttrTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndAttrTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId);
	}

	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Attribute> findByTTHCEntryAndAttrTypeAndGroup(
		long groupId, long tthcEntryId, int attributeTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.findByTTHCEntryAndAttrTypeAndGroup(groupId,
			tthcEntryId, attributeTypeId, start, end);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Attribute addTTHCAttribute(
		long companyId, long groupId, long userId, long tthcEntryId,
		int attributeTypeId, int attributeIndex,
		java.lang.String attributeName, java.lang.String attributeValue,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.addTTHCAttribute(companyId, groupId,
			userId, tthcEntryId, attributeTypeId, attributeIndex,
			attributeName, attributeValue, serviceContext);
	}

	public com.portal_egov.portlet.tthc.model.TTHC_Attribute updateTTHCAttribute(
		long attributeId, long companyId, long groupId, long userId,
		long tthcEntryId, int attributeTypeId, int attributeIndex,
		java.lang.String attributeName, java.lang.String attributeValue)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tthc_AttributeLocalService.updateTTHCAttribute(attributeId,
			companyId, groupId, userId, tthcEntryId, attributeTypeId,
			attributeIndex, attributeName, attributeValue);
	}

	public void deleteTTHCAttribute(long attributeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tthc_AttributeLocalService.deleteTTHCAttribute(attributeId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TTHC_AttributeLocalService getWrappedTTHC_AttributeLocalService() {
		return _tthc_AttributeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTTHC_AttributeLocalService(
		TTHC_AttributeLocalService tthc_AttributeLocalService) {
		_tthc_AttributeLocalService = tthc_AttributeLocalService;
	}

	public TTHC_AttributeLocalService getWrappedService() {
		return _tthc_AttributeLocalService;
	}

	public void setWrappedService(
		TTHC_AttributeLocalService tthc_AttributeLocalService) {
		_tthc_AttributeLocalService = tthc_AttributeLocalService;
	}

	private TTHC_AttributeLocalService _tthc_AttributeLocalService;
}