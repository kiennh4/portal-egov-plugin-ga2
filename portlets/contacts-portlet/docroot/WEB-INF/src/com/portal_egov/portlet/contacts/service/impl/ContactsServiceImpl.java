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

package com.portal_egov.portlet.contacts.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.portal_egov.portlet.contacts.model.Contacts;
import com.portal_egov.portlet.contacts.permission.ContactsPermission;
import com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil;
import com.portal_egov.portlet.contacts.service.base.ContactsServiceBaseImpl;

/**
 * The implementation of the contacts remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.contacts.service.ContactsService} interface.
 * <p> This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.contacts.service.base.ContactsServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.ContactsServiceUtil
 */
public class ContactsServiceImpl extends ContactsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.contacts.service.ContactsServiceUtil} to
	 * access the contacts remote service.
	 */
	
	public Contacts getContact(long contactId) throws PortalException, SystemException{
		return ContactsLocalServiceUtil.getContacts(contactId);
	}
	
	
	public JSONObject getGroupContacts(long groupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<Contacts> groupContactsList = ContactsLocalServiceUtil.findByGroup(groupId);
		
		String groupContactsJSONStr = JSONFactoryUtil.looseSerialize(groupContactsList);
		
		JSONArray groupContactsJSONArray = JSONFactoryUtil.createJSONArray(groupContactsJSONStr);
		
		jsonObject.put("groupContacts", groupContactsJSONArray);
		
		return jsonObject;
	}
	
	public JSONObject getDepartmentContacts(long groupId,long departmentId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<Contacts> departmentContactList = ContactsLocalServiceUtil.findByDepartmentAndGroup(groupId, departmentId);
		
		String departmentContactsJSONStr = JSONFactoryUtil.looseSerialize(departmentContactList);
		
		JSONArray departmentContactsJSONArray = JSONFactoryUtil.createJSONArray(departmentContactsJSONStr);
		
		jsonObject.put("departmentContacts", departmentContactsJSONArray);
		
		return jsonObject;
	}
	
	
	public JSONObject findByKeyword(long groupId,String searchKeyword) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<Contacts> searchResultList = ContactsLocalServiceUtil.findByKeyword(groupId, searchKeyword, -1, 0, -1);
		
		String resultJSONStr = JSONFactoryUtil.looseSerialize(searchResultList);
		
		JSONArray resultJSONArray = JSONFactoryUtil.createJSONArray(resultJSONStr);
		
		jsonObject.put("searchResults", resultJSONArray);
		
		return jsonObject;
	}
	
	public void updateContactState(long contactId,int displayPriority) throws PrincipalException, PortalException, SystemException{
		
		if(contactId > 0L){
			
			ContactsPermission.check(getPermissionChecker(), contactId, ContactsPermission.UPDATE);
			ContactsLocalServiceUtil.updateContactState(contactId, displayPriority);
		}
	}
	
	public void updateContactDepartment(long contactId,long departmentId) throws PrincipalException, PortalException, SystemException{
		
		if(contactId > 0L){
			ContactsPermission.check(getPermissionChecker(), contactId, ContactsPermission.UPDATE);
			ContactsLocalServiceUtil.updateContactDepartment(contactId, departmentId);
		}
	}
	
	public void deleteContacts(long contactId) throws PrincipalException, PortalException, SystemException{
		if(contactId > 0L){
			
			ContactsPermission.check(getPermissionChecker(), contactId, ContactsPermission.DELETE);
			
			ContactsLocalServiceUtil.deleteContact(contactId);
		}
	}
	
	public String getContactPortraitURL(String imagePath,long contactImageId){
		
		return UserConstants.getPortraitURL(imagePath, true, contactImageId);
	}
}
