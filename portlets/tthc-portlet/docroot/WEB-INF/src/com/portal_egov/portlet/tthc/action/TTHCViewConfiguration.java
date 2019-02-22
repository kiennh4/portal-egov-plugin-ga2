package com.portal_egov.portlet.tthc.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * @author HungDX
 */
public class TTHCViewConfiguration extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			String tthcScope = ParamUtil.getString(actionRequest, "tthcScope",StringPool.BLANK);
			
			if(Validator.isNotNull(tthcScope)){
				
				long departmentScopeId = ParamUtil.getLong(actionRequest, "departmentScopeId",0L);
				long categoryScopeId = ParamUtil.getLong(actionRequest, "categoryScopeId",0L);
				long tthcLevelScopeId = ParamUtil.getLong(actionRequest, "tthcLevelScopeId",0L);
				
				preferences.setValue("departmentScopeId", String.valueOf(departmentScopeId));
				preferences.setValue("categoryScopeId", String.valueOf(categoryScopeId));
				preferences.setValue("tthcLevelScopeId", String.valueOf(tthcLevelScopeId));
			}
			
			String displayStyle  = ParamUtil.getString(actionRequest, "displayStyle","default-display-style");
			
			int numbersOfLastestEntriesDisplay = ParamUtil.getInteger(actionRequest, "numbersOfLastestEntriesDisplay",6);
			
			int numbersOfEntriesDisplayOnSearchResultPage = ParamUtil.getInteger(actionRequest, "numbersOfEntriesDisplayOnSearchResultPage",6);
			
			boolean displayTTHCSearchForm = ParamUtil.getBoolean(actionRequest, "displayTTHCSearchForm", true);
			
			boolean displayTTHCRelatedEntries = ParamUtil.getBoolean(actionRequest, "displayTTHCRelatedEntries", true);
			
			String relatedVBPQFilter = ParamUtil.getString(actionRequest, "relatedVBPQFilter","vbpqCategory");
			
			int numbersOfRelatedEntries = ParamUtil.getInteger(actionRequest, "numbersOfRelatedEntries",6);
			
			preferences.setValue("displayStyle", displayStyle);
			preferences.setValue("tthcScope", tthcScope);
			preferences.setValue("numbersOfLastestEntriesDisplay", String.valueOf(numbersOfLastestEntriesDisplay));
			preferences.setValue("numbersOfEntriesDisplayOnSearchResultPage", String.valueOf(numbersOfEntriesDisplayOnSearchResultPage));
			preferences.setValue("displayTTHCSearchForm", String.valueOf(displayTTHCSearchForm));
			preferences.setValue("displayTTHCRelatedEntries", String.valueOf(displayTTHCRelatedEntries));
			preferences.setValue("relatedVBPQFilter", relatedVBPQFilter);
			preferences.setValue("numbersOfRelatedEntries", String.valueOf(numbersOfRelatedEntries));
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);

				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
			
		} catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
		
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/tthc_view/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(TTHCViewConfiguration.class);
}