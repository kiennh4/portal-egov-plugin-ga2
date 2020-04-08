package com.bkav.portal.portlet.eportals;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.model.ePortals;
import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;
import com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil;
import com.bkav.portal.portlet.portalplugins.util.EportalConstant;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EPortals
 */
public class EPortals extends MVCPortlet {
	@SuppressWarnings("deprecation")
	public void addEPortal(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			String ePortalName = ParamUtil.getString(actionRequest,
					"ePortalName");
			String ePortalCode = ParamUtil.getString(actionRequest,
					"ePortalCode");
			String ePortalDomain = ParamUtil.getString(actionRequest,
					"ePortalDomain");
			String ePortalVersion = ParamUtil.getString(actionRequest,
					"ePortalVersion");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					ePortals.class.getName(), actionRequest);

			Locale locale = actionRequest.getLocale();
			ServiceContext userServiceContext = new ServiceContext();
			Date now = new Date();
			String emailAddress = ePortalCode
					+ EportalConstant.EPORTAL_MAIL_SURFIX;
			String password = ePortalCode
					+ EportalConstant.USER_PASSWORD_SURFIX;
			String jobTitle = EportalConstant.USER_TITLE_JOB;

			UserLocalServiceUtil.addUser(userId, companyId, false, password,
					password, true, ePortalName, emailAddress, 0,
					StringPool.BLANK, locale, ePortalName, StringPool.BLANK,
					StringPool.BLANK, 0, 0, true, now.getMonth(),
					now.getDate(), now.getYear(), jobTitle, new long[] {},
					new long[] {}, new long[] {}, new long[] {}, false,
					userServiceContext);

			ePortalsLocalServiceUtil.addEPortal(groupId, userId, userName,
					companyId, ePortalName, ePortalCode, ePortalDomain,
					ePortalVersion, serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
	}

	public void updateEPortal(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long eportalId = ParamUtil.getLong(actionRequest, "ePortalId");
			String ePortalName = ParamUtil.getString(actionRequest,
					"ePortalName");
			String ePortalDomain = ParamUtil.getString(actionRequest,
					"ePortalDomain");
			String ePortalVersion = ParamUtil.getString(actionRequest,
					"ePortalVersion");

			ePortals ePortal = ePortalsLocalServiceUtil
					.fetchePortals(eportalId);

			if (ePortal != null) {
				String ePortalCode = ePortal.getEportalCode();
				ePortalsLocalServiceUtil.updateEPortal(eportalId, ePortalName,
						ePortalCode, ePortalDomain, ePortalVersion);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteEPortal(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long eportalId = ParamUtil.getLong(actionRequest, "ePortalId");
			long companyId = PortalUtil.getCompanyId(actionRequest);
			ePortals ePortal = ePortalsLocalServiceUtil
					.fetchePortals(eportalId);

			if (ePortal != null) {
				List<PortalPlugins> listPlugins = PortalPluginsLocalServiceUtil
						.findByEportalId(eportalId);

				if ((Validator.isNotNull(listPlugins))
						&& (listPlugins.size() > 0)) {
					for (PortalPlugins plugin : listPlugins) {
						PortalPluginsLocalServiceUtil.deletePortalPlugin(plugin
								.getPluginId());
					}
				}

				User portalUser = UserLocalServiceUtil.getUserByEmailAddress(
						companyId, ePortal.getEportalCode()
								+ EportalConstant.EPORTAL_MAIL_SURFIX);
				UserLocalServiceUtil.deleteUser(portalUser);

				ePortalsLocalServiceUtil.deleteePortals(ePortal);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(EPortals.class);
}
