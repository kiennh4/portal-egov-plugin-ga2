package com.portal_egov.portlet.proposition_feedback;

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

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.portal_egov.portlet.proposition_feedback.PropositionFeedback;
import com.portal_egov.portlet.proposition_feedback.permission.PropositionFeedbackPermission;
import com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.util.PropositionConstants;
import com.portal_egov.portlet.proposition_feedback.util.PropositionUtil;

/**
 * Portlet implementation class PropositionFeedback
 */
public class PropositionFeedback extends MVCPortlet {

	// NamLHc bo sung ham send feedback nguoi dan
	public static void updateFeedbackContent(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long feedbackFileAttId = ParamUtil.getLong(actionRequest, "feedbackFileAttId",0L);
			
			long feedbackId = ParamUtil
					.getLong(actionRequest, "feedbackId", 0L);

			int feedbackStatus = ParamUtil.getInteger(actionRequest, "status",
					PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE);

			long propositionId = ParamUtil.getLong(actionRequest,
					"propositionId", 0L);

			String citizenName = ParamUtil.getString(actionRequest,
					"citizenName", StringPool.BLANK);

			String citizenEmail = ParamUtil.getString(actionRequest,
					"citizenEmail", StringPool.BLANK);

			String citizenPhone = ParamUtil.getString(actionRequest,
					"citizenPhone", StringPool.BLANK);

			String citizenAddress = ParamUtil.getString(actionRequest,
					"citizenAddress", StringPool.BLANK);

			String feedbackTitle = ParamUtil.getString(actionRequest,
					"feedbackTitle", StringPool.BLANK);

			String feedbackContent = ParamUtil.getString(actionRequest,
					"feedbackContent", StringPool.BLANK);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL", StringPool.BLANK);

			if (feedbackId > 0) {

				PropositionFeedbackLocalServiceUtil.updatePropositionFeedback(
						feedbackId, companyId, groupId, userId, propositionId,
						0, feedbackTitle, feedbackContent, citizenName,
						citizenEmail, citizenPhone, citizenAddress,
						feedbackStatus);

			} else {

				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(PropositionFeedback.class.getName(),
								actionRequest);

				serviceContext
						.setGroupPermissions(new String[] { PropositionFeedbackPermission.VIEW });
				serviceContext
						.setGuestPermissions(new String[] { PropositionFeedbackPermission.VIEW });

				if (checkCaptcha(actionRequest)) {

					PropositionFeedback proEntry = (PropositionFeedback) PropositionFeedbackLocalServiceUtil
							.addPropositionFeedback(companyId, groupId, userId, propositionId, feedbackFileAttId, feedbackTitle, feedbackContent, citizenName, citizenEmail, citizenPhone, citizenAddress, PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE, serviceContext);
									
									

					SessionMessages.add(actionRequest, "give-ask-success");

				} else {

					SessionErrors.add(actionRequest, "invalid-captcha");
				}
				
				PropositionFeedbackLocalServiceUtil.addPropositionFeedback(
						companyId, groupId, userId, propositionId, 0L,
						feedbackTitle, feedbackContent, citizenName,
						citizenEmail, citizenPhone, citizenAddress,
						feedbackStatus, serviceContext);
			}

			PropositionLocalServiceUtil.incrementFeedbackCounter(propositionId);
			

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	// NamLhc bo sung ham` general image captcha
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {

			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(
					resourceRequest, resourceResponse);
		} catch (Exception e) {
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

	private static Log _log = LogFactory.getLog(PropositionFeedback.class
			.getName());
}
