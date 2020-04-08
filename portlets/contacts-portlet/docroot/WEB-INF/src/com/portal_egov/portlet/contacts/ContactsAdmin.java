package com.portal_egov.portlet.contacts;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.contacts.util.ContactsDepartmentUtil;
import com.portal_egov.portlet.contacts.util.ContactsUtil;

/**
 * Portlet implementation class ContactsAdmin
 */
public class ContactsAdmin extends MVCPortlet {
 
	
	public void updateContact(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ContactsUtil.updateContact(actionRequest);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void deleteContact(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ContactsUtil.deleteContact(actionRequest);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (PortalException e) {
			_log.error(e);
		}
		catch (SystemException e) {
			_log.error(e);
		}
		catch (IOException e) {
			_log.error(e);
		}
		
	}
	
	
	public void updateDepartment(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			ContactsDepartmentUtil.updateDepartment(actionRequest);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	 
	public void deleteDepartment(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			long departmentId = ParamUtil.getLong(actionRequest, "departmentId");
			
			if(groupId > 0 && departmentId > 0){
				ContactsDepartmentUtil.deleteDepartment(groupId, departmentId);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
		}
		catch (PortalException e) {
			_log.error(e);
		}
		catch (IOException e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactory.getLog(ContactsAdmin.class);

}
