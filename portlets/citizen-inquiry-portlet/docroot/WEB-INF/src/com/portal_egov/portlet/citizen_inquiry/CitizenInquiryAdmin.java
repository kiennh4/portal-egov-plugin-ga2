package com.portal_egov.portlet.citizen_inquiry;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory;
import com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryCategoryLocalServiceUtil;
import com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil;

/**
 * Portlet implementation class CitizenInquiryAdmin
 */
public class CitizenInquiryAdmin extends MVCPortlet {
 

	public void updateInquiry(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long inquiryId = ParamUtil.getLong(actionRequest, "inquiryId",0L);
			
			if(inquiryId > 0L){
				
				CitizenInquiry inquiry = CitizenInquiryLocalServiceUtil.getCitizenInquiry(inquiryId);
				
				if(inquiry != null){
					
					long companyId = PortalUtil.getCompanyId(actionRequest);
					long groupId = PortalUtil.getScopeGroupId(actionRequest);
					long userId = PortalUtil.getUserId(actionRequest);
					String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
					
					boolean approvedStatus = inquiry.getApproved();
					
					Date feedbackDate = inquiry.getInquiryFeedbackDate();
					
					String citizenName = ParamUtil.getString(actionRequest, "citizenName");
					
					String citizenAddress = ParamUtil.getString(actionRequest, "citizenAddress");
					
					String inquiryTitle = ParamUtil.getString(actionRequest, "inquiryTitle");
					
					String inquiryContent = ParamUtil.getString(actionRequest, "inquiryContent");
					
					String inquiryFeedback = ParamUtil.getString(actionRequest, "inquiryFeedback");
					
					if(Validator.isNull(feedbackDate) && Validator.isNotNull(inquiryFeedback)){
						
						feedbackDate = new Date();
					}
					
					if(!approvedStatus && Validator.isNotNull(inquiryFeedback)){
						
						approvedStatus = true;
					}
					
					String inquiryFeedbackUser = ParamUtil.getString(actionRequest, "inquiryFeedbackUser");
					
					String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
					
					ServiceContext serviceContext = ServiceContextFactory.getInstance(CitizenInquiryCategory.class.getName(), actionRequest);
					
					serviceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
					serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
					
					CitizenInquiryLocalServiceUtil.updateInquiry(inquiryId, companyId, groupId, userId, userName, 0L, 
						citizenName, StringPool.BLANK, StringPool.BLANK, citizenAddress, inquiryTitle, inquiryContent,
						 inquiryFeedback,inquiryFeedbackUser, feedbackDate, approvedStatus, serviceContext);
					
					SessionMessages.add(actionRequest, "request_processed");
					
					if(Validator.isNotNull(redirectURL)){
						actionResponse.sendRedirect(redirectURL);
					}
				}
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void deleteInquiry(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long inquiryId = ParamUtil.getLong(actionRequest, "inquiryId",0L);
			
			if(inquiryId > 0){
				
				CitizenInquiryLocalServiceUtil.deleteCitizenInquiry(inquiryId);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void updateInquiryCategory(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			String categoryName = ParamUtil.getString(actionRequest, "categoryName");
			
			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CitizenInquiryCategory.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
			serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
			
			if(categoryId > 0){//Update category
				
				CitizenInquiryCategoryLocalServiceUtil.updateInquiryCategory(categoryId, 
					companyId, groupId, userId, userName, categoryName, categoryDesc, serviceContext);
			}else{
				
				CitizenInquiryCategoryLocalServiceUtil.addInquiryCategory(companyId, groupId, userId,
					userName, categoryName, categoryDesc, serviceContext);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	
	public void deleteInquiryCategory(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			if(categoryId > 0){
				
				CitizenInquiryCategoryLocalServiceUtil.deleteCitizenInquiryCategory(categoryId);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	private static Log _log = LogFactory.getLog(CitizenInquiryAdmin.class);
}
