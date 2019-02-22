package com.portal_egov.portlet.inquiry;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.inquiry.model.OnlineInquiry;
import com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil;

/**
 * Portlet implementation class Inquiry
 */
public class Inquiry extends MVCPortlet {
	 
		public void updateInquiryContent(ActionRequest actionRequest,ActionResponse actionResponse){
			
			try {
				
				long companyId = PortalUtil.getCompanyId(actionRequest);

				long groupId = PortalUtil.getScopeGroupId(actionRequest);

				long userId = PortalUtil.getUserId(actionRequest);
				
				String userName = PortalUtil.getUserName(userId, "Guest");
				
				String fullName = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "fullName"));
				
				String phoneNumbers = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "phoneNumbers"));
				
				String emailAddress = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "emailAddress"));
				
				String inquiryContent = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "inquiryContent"));
				
				String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(OnlineInquiry.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
				serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				if(checkCaptcha(actionRequest)){
					
					OnlineInquiryLocalServiceUtil.addInquiry(companyId, groupId, userId, userName, fullName,
						phoneNumbers, emailAddress, inquiryContent, serviceContext);
					
					SessionMessages.add(actionRequest, "send-success");
					
				}else{
					
					SessionErrors.add(actionRequest, "invalid-captcha");
				}
				
				actionResponse.sendRedirect(redirectURL);
			}
			catch (Exception e) {
				SessionErrors.add(actionRequest, "give-ask-unsuccess");
				_log.error(e);
			}
		}
		
		@Override
		public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
			try {
				
				CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
	    public static boolean checkCaptcha(PortletRequest request) throws Exception {
	        
	    	boolean isValidCaptcha = true;
	    	
	    	String enteredCaptchaText = ParamUtil.getString(request, "captchaText");

	        PortletSession session = request.getPortletSession();
	        
	        String captchaText = getCaptchaValueFromSession(session);
	        
	        if (Validator.isNull(captchaText)) {
	        	
	        	isValidCaptcha = false;
	        }
	        if (!Validator.equals(captchaText, enteredCaptchaText)) {
	        	
	        	isValidCaptcha = false;
	        	_log.info("Warning: Inquiry Portlet - invalid captcha text!");
	        }
	        
	        return isValidCaptcha;
	    }

		
	    private static String getCaptchaValueFromSession(PortletSession session) {
	        Enumeration<String> atNames = session.getAttributeNames();
	        while (atNames.hasMoreElements()) {
	            String name = atNames.nextElement();
	            if (name.contains("CAPTCHA_TEXT")) {
	                return (String) session.getAttribute(name);
	            }
	        }
	        return null;
	    }
	    
		private static Log _log = LogFactory.getLog(Inquiry.class.getName());

}
