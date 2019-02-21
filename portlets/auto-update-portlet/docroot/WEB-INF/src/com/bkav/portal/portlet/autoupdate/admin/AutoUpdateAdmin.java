package com.bkav.portal.portlet.autoupdate.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.autoupdate.admin.util.AutoUpdateRestore;
import com.bkav.portal.autoupdate.admin.util.AutoUpdateScheduler;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AutoUpdateAdmin
 */
public class AutoUpdateAdmin extends MVCPortlet {
 
	public void updatePlugins (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			
		}
		catch (Exception e)
		{
			_log.error(e);
		}
	}
	
	public void restorePlugins (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			String pluginCode = ParamUtil.getString(actionRequest, "pluginCode");
			
			if (AutoUpdateRestore.isRestoredPlugin(pluginCode))
			{
				SessionMessages.add(actionRequest, "restore-success");
			}
			else
			{
				SessionErrors.add(actionRequest, "restore-failed");
			}
		}
		catch (Exception e)
		{
			_log.error(e);
			SessionErrors.add(actionRequest, "restore-failed");
		}
	}
	
	public void saveUpdateConfig (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);
			boolean isAutoUpdate = ParamUtil.getBoolean(actionRequest, "isAutoUpdate", false);
			String serverUpdateDomain = ParamUtil.getString(actionRequest, "serverUpdateDomain");
			
			preferences.setValue("isAutoUpdate", StringUtil.valueOf(isAutoUpdate));
			
			if (isAutoUpdate)
			{
				int autoUpdateHour = ParamUtil.getInteger(actionRequest, "autoUpdateHour",0);
				int autoUpdateMinutes = ParamUtil.getInteger(actionRequest, "autoUpdateMinutes",0);
				
				preferences.setValue("autoUpdateHour", StringUtil.valueOf(autoUpdateHour));
				preferences.setValue("autoUpdateMinutes", StringUtil.valueOf(autoUpdateMinutes));
				
				boolean isUpdateByDay = ParamUtil.getBoolean(actionRequest, "isUpdateByDay",false);
				
				preferences.setValue("isUpdateByDay", StringUtil.valueOf(isUpdateByDay));
				
				if (isUpdateByDay)
				{
					int autoUpdateDay = ParamUtil.getInteger(actionRequest, "autoUpdateDay",0);
					preferences.setValue("autoUpdateDay", StringUtil.valueOf(autoUpdateDay));
				}
				else
				{
					preferences.setValue("autoUpdateDay", "-1");
				}
			}
			preferences.setValue("serverUpdateDomain", serverUpdateDomain);
			
			preferences.store();

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");
			
			if (isAutoUpdate)
			{
			
				AutoUpdateScheduler.autoUpdateRegisterScheduler(preferences);
			}
			else
			{
				AutoUpdateScheduler.autoUpdateUnregisterScheduler();
			}
			
			if (Validator.isNotNull(redirectURL)) {
				SessionMessages.add(actionRequest, "save-config-success");
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e)
		{
			SessionErrors.add(actionRequest, "save-config-error");
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactory.getLog(AutoUpdateAdmin.class);
}
