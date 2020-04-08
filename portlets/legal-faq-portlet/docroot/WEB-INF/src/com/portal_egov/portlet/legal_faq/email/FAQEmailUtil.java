/**
 * @author HungDX
 * @time 3:05:52 PM
 * @project legal_faq-portlet
 */
package com.portal_egov.portlet.legal_faq.email;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.ContentUtil;
import com.liferay.util.mail.MailEngine;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;

public class FAQEmailUtil {

	public static void sendMail(String emailContent) {

		try {

			Layout controlPanel = LayoutLocalServiceUtil
					.getLayout(CONTROL_PANEL_LAYOUT_ID);

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(controlPanel, FAQ_ADMIN_PORTLET_ID, null);

			String fromEmailName = preferences.getValue("fromEmailName",
					"Admin");

			String fromEmailAddress = preferences.getValue("fromEmailAddress",
					"chuvanquang96@gmail.com");

			String toEmailAddress = preferences.getValue("toEmailAddress",
					"quangchuit96@gmail.com");

			String emailSubject = preferences.getValue("emailSubject",
					"Portal-eGov");

			if (Validator.isNotNull(toEmailAddress)) {

				InternetAddress fromEmail = new InternetAddress(fromEmailName,
						fromEmailAddress);

				InternetAddress toEmail = new InternetAddress(toEmailAddress);

				MailEngine.send(fromEmail, toEmail, emailSubject, emailContent,
						true);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public static void sendAnswerMail(String emailContent,
			String toEmailAddress, ActionRequest actionRequest) {
		try {

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);

			String fromEmailName = preferences.getValue("fromEmailName",
					"Admin");

			String fromEmailAddress = preferences.getValue("fromEmailAddress",
					"admin@portal-egov.com");
			System.out.println(fromEmailAddress);
			String emailSubject = preferences.getValue("emailSubject",
					"Portal-eGov");

			if (Validator.isNotNull(toEmailAddress)) {
				MailMessage mailMessage = new MailMessage();
				mailMessage.setBody(emailContent);
				mailMessage.setSubject(emailSubject);
				mailMessage.setFrom(new InternetAddress(fromEmailAddress,fromEmailName));
				mailMessage.setTo(new InternetAddress(toEmailAddress));
				MailServiceUtil.sendEmail(mailMessage);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public static String buildFAQEmailContent(LegalFAQEntry faqEntry) {

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat(
					" dd/MM/yyyy ' | ' hh:mm a");

			VelocityEngine velocityEngine = new VelocityEngine();

			velocityEngine.init();

			VelocityContext velocityContext = new VelocityContext();

			Map<String, String> templateVariables = new HashMap<String, String>();

			templateVariables.put("notifyTitle",
					LanguageUtil.get(LOCATE, "faq-notify-email-title"));
			templateVariables.put("askDateKeyword",
					LanguageUtil.get(LOCATE, "faq-notify-email-ask-date"));
			templateVariables.put("senderNameKeyword",
					LanguageUtil.get(LOCATE, "faq-notify-email-sender-name"));
			templateVariables.put("senderEmailKeyword",
					LanguageUtil.get(LOCATE, "faq-notify-email-sender-email"));
			templateVariables.put("askTitleKeyword",
					LanguageUtil.get(LOCATE, "faq-notify-email-ask-title"));
			templateVariables.put("askContentKeyword",
					LanguageUtil.get(LOCATE, "faq-notify-email-ask-content"));
			templateVariables.put("notifyBottomKeyword",
					LanguageUtil.get(LOCATE, "faq-notify-email-notify-bottom"));

			templateVariables.put("askDate",
					dateFormat.format(faqEntry.getAskDate()));
			templateVariables.put("citizenName", faqEntry.getCitizenName());
			templateVariables.put("citizenEmail", faqEntry.getCitizenEmail());
			templateVariables.put("askTitle", faqEntry.getAskTitle());
			templateVariables.put("askContent", faqEntry.getAskContent());

			Iterator<Map.Entry<String, String>> itr = templateVariables
					.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();

				String key = entry.getKey();
				Object value = entry.getValue();

				if (Validator.isNotNull(key)) {
					velocityContext.put(key, value);
				}
			}

			UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

			String emailTemplate = ContentUtil.get(EMAIL_TEMPLATE_FILE_PATH);

			velocityEngine.evaluate(velocityContext, unsyncStringWriter,
					FAQEmailUtil.class.getName(), emailTemplate);

			return unsyncStringWriter.toString();

		} catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}

	public static String buildAnswerEmailContent(LegalFAQEntry legalFAQEntry,
			String viewDetailLink) {

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat(
					" dd/MM/yyyy ' | ' hh:mm a");

			String askDate = dateFormat.format(legalFAQEntry.getAskDate());

			VelocityEngine velocityEngine = new VelocityEngine();

			velocityEngine.init();

			VelocityContext velocityContext = new VelocityContext();

			Map<String, String> templateVariables = new HashMap<String, String>();

			templateVariables.put("notifyTitleAnswer",
					LanguageUtil.get(LOCATE, "faq-notify-email-answer-title"));
			templateVariables.put("askDate", askDate);

			templateVariables.put("faqLink", viewDetailLink);
			Iterator<Map.Entry<String, String>> itr = templateVariables
					.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();

				String key = entry.getKey();
				Object value = entry.getValue();

				if (Validator.isNotNull(key)) {
					velocityContext.put(key, value);
				}
			}

			UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

			String emailTemplate = ContentUtil
					.get(ANSWER_EMAIL_TEMPLATE_FILE_PATH);

			velocityEngine.evaluate(velocityContext, unsyncStringWriter,
					FAQEmailUtil.class.getName(), emailTemplate);

			return unsyncStringWriter.toString();

		} catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}

	private static Log _log = LogFactory.getLog(FAQEmailUtil.class.getName());

	private static final long CONTROL_PANEL_LAYOUT_ID = 10022;

	private static final String FAQ_ADMIN_PORTLET_ID = "legal_faq_management_WAR_legal_fagportlet";

	private static final String EMAIL_TEMPLATE_FILE_PATH = "com/portal_egov/portlet/legal_faq/email/email_template.vm";

	private static final String ANSWER_EMAIL_TEMPLATE_FILE_PATH = "com/portal_egov/portlet/legal_faq/email/email_answer_template.vm";

	public static final Locale LOCATE = new Locale("vi", "VN");
}
