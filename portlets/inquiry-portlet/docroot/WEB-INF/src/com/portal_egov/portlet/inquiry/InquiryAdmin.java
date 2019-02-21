package com.portal_egov.portlet.inquiry;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil;

/**
 * Portlet implementation class InquiryAdmin
 */
public class InquiryAdmin extends MVCPortlet {
 
	
	public void deleteInquiry(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long inquiryId = ParamUtil.getLong(actionRequest, "inquiryId",0L);
			
			if(inquiryId > 0){
				
				OnlineInquiryLocalServiceUtil.deleteInquiry(inquiryId);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
}
