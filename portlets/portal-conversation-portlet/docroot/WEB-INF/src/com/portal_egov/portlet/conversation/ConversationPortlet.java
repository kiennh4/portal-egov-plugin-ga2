package com.portal_egov.portlet.conversation;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.permission.CO_ConversationPermission;
import com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil;

/**
 * Portlet implementation class ConversationPortlet
 */
public class ConversationPortlet extends MVCPortlet {
public static void updateAskContent(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			
			long userId = PortalUtil.getUserId(actionRequest);
			
			long threadId = ParamUtil.getLong(actionRequest, "threadId",0L);
			
			String askUserName = ParamUtil.getString(actionRequest, "askUserName",StringPool.BLANK);
			
			String askUserAge = ParamUtil.getString(actionRequest, "askUserName",StringPool.BLANK);
			
			String askUserAddress = ParamUtil.getString(actionRequest, "askUserAddress",StringPool.BLANK);
			
			String askUserInfo = askUserAge + StringPool.COMMA + askUserAddress;
			
			String askTitle = ParamUtil.getString(actionRequest, "askTitle",StringPool.BLANK);
			
			String askContent = ParamUtil.getString(actionRequest, "askContent",StringPool.BLANK);
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL",StringPool.BLANK);
			
			Date askDate = new Date();
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CO_Conversation.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {CO_ConversationPermission.VIEW_CONVERSATION});
			serviceContext.setGuestPermissions(new String[] {CO_ConversationPermission.VIEW_CONVERSATION});
			
			//if(checkCaptcha(actionRequest)){
				//add new entry
				CO_ConversationLocalServiceUtil.addCOConversation(companyId, groupId, userId, threadId, askTitle, 
								askUserName, askUserInfo, askContent, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
								askDate, null, serviceContext);
				SessionMessages.add(actionRequest, "send-question-success");
				actionResponse.sendRedirect(redirectURL);
			//}
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, "send-question-error");
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
        	System.out.println("Invalid captcha text. Please reenter.");
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
	private static Log _log = LogFactory.getLog(ConversationPortlet.class.getName());

}
