package com.portal_egov.portlet.legal_faq;

import java.io.IOException;
import java.util.Date;
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

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.legal_faq.email.FAQEmailUtil;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.permission.LegalFAQEntryPermission;
import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.util.LegalFAQConstants;

/**
 * Portlet implementation class LegalFAQ
 */
public class LegalFAQ extends MVCPortlet {
 
	public void updateAskContent(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			String citizenName = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "citizenName",StringPool.BLANK));
			
			String citizenPhone = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "citizenPhone",StringPool.BLANK));
			
			String citizenAddress = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "citizenAddress",StringPool.BLANK));
			
			String citizenEmail = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "citizenEmail",StringPool.BLANK));
			
			String askTitle = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "askTitle",StringPool.BLANK));
			
			String askContent = HtmlUtil.stripHtml(ParamUtil.getString(actionRequest, "askContent",StringPool.BLANK));
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			Date now = new Date();
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(LegalFAQEntry.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {LegalFAQEntryPermission.VIEW});
			serviceContext.setGuestPermissions(new String[] {LegalFAQEntryPermission.VIEW});
			
			if(checkCaptcha(actionRequest)){
				
				LegalFAQEntry faqEntry =  LegalFAQEntryLocalServiceUtil.addFAQEntry(companyId, groupId, userId, categoryId, citizenName,
					citizenPhone, citizenEmail, citizenAddress, now, askTitle, askContent, now, StringPool.BLANK, 
					LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE, LegalFAQConstants.LEGAL_FAQ_ENTRY_DEFAULT_STATUS_VALUE, serviceContext);
				
				String emailContent = FAQEmailUtil.buildFAQEmailContent(faqEntry);
				
				FAQEmailUtil.sendMail(emailContent);
				
				SessionMessages.add(actionRequest, "give-ask-success");
				
			}else{
				
				SessionErrors.add(actionRequest, "invalid-captcha");
			}
			
			actionResponse.sendRedirect(redirectURL);
			
		}catch(Exception e){
			SessionErrors.add(actionRequest, "give-ask-unsuccess");
			_log.error(e);
		}
	}
	
	public void updateEntryViewCount(ActionRequest actionRequest,ActionResponse actionResponse){
		try {
			
			long legalFAQEntryId = ParamUtil.getLong(actionRequest, "legalFAQEntryId",0L);
			
			if(legalFAQEntryId > 0){
				
				LegalFAQEntry legalFAQEntry = LegalFAQEntryLocalServiceUtil.getEntry(legalFAQEntryId);
				
				legalFAQEntry.setViewCount(legalFAQEntry.getViewCount() + 1);
				
				LegalFAQEntryLocalServiceUtil.updateLegalFAQEntry(legalFAQEntry, false);
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		try {
			
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
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
        	_log.info("Warning: Legal FAQ Portlet - invalid captcha text!");
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
    
	private static Log _log = LogFactory.getLog(LegalFAQ.class.getName());
}
