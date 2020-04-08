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

package com.portal_egov.portlet.contacts.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the contacts local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see ContactsLocalServiceUtil
 * @see com.portal_egov.portlet.contacts.service.base.ContactsLocalServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.impl.ContactsLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ContactsLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactsLocalServiceUtil} to access the contacts local service. Add custom service methods to {@link com.portal_egov.portlet.contacts.service.impl.ContactsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the contacts to the database. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @return the contacts that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts addContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new contacts with the primary key. Does not add the contacts to the database.
	*
	* @param contactId the primary key for the new contacts
	* @return the new contacts
	*/
	public com.portal_egov.portlet.contacts.model.Contacts createContacts(
		long contactId);

	/**
	* Deletes the contacts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts that was removed
	* @throws PortalException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts deleteContacts(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the contacts from the database. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @return the contacts that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts deleteContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.contacts.model.Contacts fetchContacts(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contacts with the primary key.
	*
	* @param contactId the primary key of the contacts
	* @return the contacts
	* @throws PortalException if a contacts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.contacts.model.Contacts getContacts(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contactses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contactses
	* @param end the upper bound of the range of contactses (not inclusive)
	* @return the range of contactses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> getContactses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contactses.
	*
	* @return the number of contactses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getContactsesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the contacts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @return the contacts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts updateContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the contacts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contacts the contacts
	* @param merge whether to merge the contacts with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contacts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.contacts.model.Contacts updateContacts(
		com.portal_egov.portlet.contacts.model.Contacts contacts, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCompanyAndStatus(long companyId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroupAndStatus(long groupId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByDepartmentAndCompany(long companyId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByDepartmentAndGroup(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCompanyAndDepartmentAndStatus(long companyId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroupAndDepartmentAndStatus(long groupId,
		long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndCompany(
		long companyId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByDepartmentAndGroup(
		long groupId, long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByCompanyAndDepartmentAndStatus(
		long companyId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByGroupAndDepartmentAndStatus(
		long groupId, long departmentId, int contactStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByKeyword(
		long groupId, java.lang.String keyword, int contactStatus, int start,
		int end);

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByKeywordAndDepartment(
		long groupId, long departmentId, java.lang.String keyword,
		int contactStatus, int start, int end);

	public com.portal_egov.portlet.contacts.model.Contacts addContact(
		long groupId, long companyId, long userId, java.lang.String userName,
		long departmentId, java.lang.String contactName, long avatarImageId,
		java.lang.String jobTitle, java.lang.String phoneNumbers,
		java.lang.String homePhone, java.lang.String mobile,
		java.lang.String email, int displayPriority, int contactStatus,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.contacts.model.Contacts updateContact(
		long contactId, long groupId, long companyId, long userId,
		java.lang.String userName, long departmentId,
		java.lang.String contactName, long avatarImageId,
		java.lang.String jobTitle, java.lang.String phoneNumbers,
		java.lang.String homePhone, java.lang.String mobile,
		java.lang.String email, int displayPriority, int contactStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void updateContactState(long contactId, int displayPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateContactDepartment(long contactId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.contacts.NoSuchContactsException;
}