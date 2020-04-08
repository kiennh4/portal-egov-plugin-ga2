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
import com.liferay.portal.security.auth.PrincipalException;
import com.portal_egov.portlet.contacts.model.ContactsDepartment;
import com.portal_egov.portlet.contacts.permission.ContactsDepartmentPermission;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil;
import com.portal_egov.portlet.contacts.service.base.ContactsDepartmentServiceBaseImpl;
import com.portal_egov.portlet.contacts.util.ContactsDepartmentUtil;

/**
 * The implementation of the contacts department remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added,
 *  rerun ServiceBuilder to copy their definitions 
 *  into the {@link com.portal_egov.portlet.contacts.service.ContactsDepartmentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks
 *  based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.contacts.service.base.ContactsDepartmentServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.ContactsDepartmentServiceUtil
 */
public class ContactsDepartmentServiceImpl
	extends ContactsDepartmentServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly.
	 *  Always use {@link com.portal_egov.portlet.contacts.service.ContactsDepartmentServiceUtil}
	 *   to access the contacts department remote service.
	 */
	
	public ContactsDepartment getDepartment(long departmentId) throws PortalException, SystemException{
		
		return ContactsDepartmentLocalServiceUtil.getContactsDepartment(departmentId);
	}
	
	public JSONObject getGroupDepartments(long groupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<ContactsDepartment> groupDepartmentList = ContactsDepartmentLocalServiceUtil.findByGroup(groupId);
		
		String groupDepartmentJSON = JSONFactoryUtil.looseSerialize(groupDepartmentList);
		
		JSONArray groupDepartmentsJSONArray = JSONFactoryUtil.createJSONArray(groupDepartmentJSON);
		
		jsonObject.put("groupDepartments", groupDepartmentsJSONArray);
		
		return jsonObject;
	}
	
	
	public JSONObject getChildDepartments(long groupId,long parentDepartmentId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<ContactsDepartment> childDepartmentList = ContactsDepartmentLocalServiceUtil.findByParentAndGroup(groupId, parentDepartmentId);
		
		String childDepartmentsJSON = JSONFactoryUtil.looseSerialize(childDepartmentList);
		
		JSONArray childDepartmentsJSONArray = JSONFactoryUtil.createJSONArray(childDepartmentsJSON);
		
		jsonObject.put("childDepartments", childDepartmentsJSONArray);
		
		return jsonObject;
	}
	
	
	public int countChildDepartment(long groupId,long departmentId) throws SystemException{
		
		return ContactsDepartmentLocalServiceUtil.countByParentAndGroup(groupId, departmentId);
	}
	
	public void updateDepartmentState(long departmentId,int displayPriority) throws PrincipalException, PortalException, SystemException{
		
		if(departmentId > 0L){
			ContactsDepartmentPermission.check(getPermissionChecker(), departmentId, ContactsDepartmentPermission.UPDATE);
			ContactsDepartmentLocalServiceUtil.updateDepartmentState(departmentId, displayPriority);
		}
	}
	
	public void updateDepartmentParent(long departmentId,long parentDepartmentId) throws PrincipalException, PortalException, SystemException{
		
		if(departmentId > 0L){
			ContactsDepartmentPermission.check(getPermissionChecker(), departmentId, ContactsDepartmentPermission.UPDATE);
			ContactsDepartmentLocalServiceUtil.updateDepartmentParent(departmentId, parentDepartmentId);
		}
	}
	
	public void deleteDepartment(long groupId,long departmentId) throws PrincipalException, PortalException, SystemException{
		
		if(departmentId > 0L){
			ContactsDepartmentPermission.check(getPermissionChecker(), departmentId, ContactsDepartmentPermission.DELETE);
			ContactsDepartmentUtil.deleteDepartment(groupId, departmentId);
		}
	}
}