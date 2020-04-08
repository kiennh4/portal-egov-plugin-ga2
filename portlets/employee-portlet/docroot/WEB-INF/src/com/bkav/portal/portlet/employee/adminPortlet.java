package com.bkav.portal.portlet.employee;

import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil;
import com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil;
import com.bkav.portal.portlet.employee.service.PostLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class adminPortlet
 */
public class adminPortlet extends MVCPortlet {
	public void updatePosts(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
		long companyId = PortalUtil.getCompanyId(actionRequest);

		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		long userId = PortalUtil.getUserId(actionRequest);

		String userName = PortalUtil.getUserName(userId, StringPool.BLANK);

		long postId = ParamUtil.getLong(actionRequest, "postId", 0L);

		String postName = ParamUtil.getString(actionRequest, "postName");

		if (postId > 0) {// Update post

			PostLocalServiceUtil.updatePost(companyId, groupId, userId, userName, postId, postName);
		} else {// Add post

			PostLocalServiceUtil.addPost(companyId, groupId, userId, userName, postName);
		}
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		SessionMessages.add(actionRequest, "post-save-done");
		if (Validator.isNotNull(redirectURL)) {

			actionResponse.sendRedirect(redirectURL);
		}
		}
		catch (Exception e) {
			    e.printStackTrace();
				SessionErrors.add(actionRequest, "save-failed");
				
		}
	}
	
	public void deletePosts(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long postId = ParamUtil.getLong(actionRequest, "postId",0L);
			
			boolean deleteEmployees = ParamUtil.getBoolean(actionRequest, "deleteEmployees",false);
			
			if(postId > 0){
				
				PostLocalServiceUtil.deletePost(postId, deleteEmployees);
			}
			
			SessionMessages.add(actionRequest, "delete-done");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "delete-failed");
		}
		
	}
	
	public void updateDeps(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
		long companyId = PortalUtil.getCompanyId(actionRequest);

		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		long userId = PortalUtil.getUserId(actionRequest);

		String userName = PortalUtil.getUserName(userId, StringPool.BLANK);

		long depId = ParamUtil.getLong(actionRequest, "depId", 0L);

		String depName = ParamUtil.getString(actionRequest, "depName");
		
		String depAddres = ParamUtil.getString(actionRequest, "depAddress");
		
		String depPhone = ParamUtil.getString(actionRequest, "depPhone");

		if (depId > 0) {// Update dep

			DepartmentLocalServiceUtil.updateDepartment(companyId, groupId, userId, userName, depId, depName, depAddres, depPhone);
		} else {// Add dep

			DepartmentLocalServiceUtil.addDepartment(companyId, groupId, userId, userName, depName, depAddres, depPhone);
		}
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		SessionMessages.add(actionRequest, "dep-save-done");
		if (Validator.isNotNull(redirectURL)) {

			actionResponse.sendRedirect(redirectURL);
		}
		}
		catch (Exception e) {
			    e.printStackTrace();
				SessionErrors.add(actionRequest, "save-failed");
				
		}
	}
	
	public void deleteDeps(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long depId = ParamUtil.getLong(actionRequest, "depId",0L);
			
			boolean deleteEmployees = ParamUtil.getBoolean(actionRequest, "deleteEmployees",false);
			
			if(depId > 0){
				
				DepartmentLocalServiceUtil.deleteDep(depId, deleteEmployees);
			}
			
			SessionMessages.add(actionRequest, "delete-done");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "delete-failed");
		}
		
	}
	
	public void updateEmployees(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
		long companyId = PortalUtil.getCompanyId(actionRequest);

		long groupId = PortalUtil.getScopeGroupId(actionRequest);

		long userId = PortalUtil.getUserId(actionRequest);

		String userName = PortalUtil.getUserName(userId, StringPool.BLANK);

		long emplId = ParamUtil.getLong(actionRequest, "emplId", 0L);

		String name = ParamUtil.getString(actionRequest, "name");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date birthday = ParamUtil.getDate(actionRequest, "birthDay", dateFormat);
		
		String male = ParamUtil.getString(actionRequest, "male");
		
		long phone = ParamUtil.getLong(actionRequest, "phone");
		
		String addres = ParamUtil.getString(actionRequest, "addres");
		
		String email = ParamUtil.getString(actionRequest, "email");
		
		long depId = ParamUtil.getLong(actionRequest, "department");
		
		long postId = ParamUtil.getLong(actionRequest, "post");
		
		long sal = ParamUtil.getLong(actionRequest, "sal");
		
		int breakDay = ParamUtil.getInteger(actionRequest, "breakDay");
		
		int addDay = ParamUtil.getInteger(actionRequest, "addDay");
		
		String endDate = ParamUtil.getString(actionRequest, "endDate");

		if (emplId > 0) {// Update EMPLOYEE

			EmployeeLocalServiceUtil.updateemployees(companyId, groupId, userId, userName, emplId, name, birthday, male, phone, addres, email, postId, depId, sal, breakDay, addDay, endDate);
		} else {// Add EMPLOYEE

			EmployeeLocalServiceUtil.addEmployees(companyId, groupId, userId, userName, name, birthday, male, phone, addres, email, postId, depId);
		}
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		SessionMessages.add(actionRequest, "post-save-done");
		if (Validator.isNotNull(redirectURL)) {

			actionResponse.sendRedirect(redirectURL);
		}
		}
		catch (Exception e) {
			    e.printStackTrace();
				SessionErrors.add(actionRequest, "save-failed");
				
		}
	}
	
	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long employeeId = ParamUtil.getLong(actionRequest, "emplId",0L);
			
			if(employeeId > 0){
				
				EmployeeLocalServiceUtil.deleteEmployee(employeeId);
			}
			
			SessionMessages.add(actionRequest, "delete-done");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "delete-failed");
		}
		
	}


}
