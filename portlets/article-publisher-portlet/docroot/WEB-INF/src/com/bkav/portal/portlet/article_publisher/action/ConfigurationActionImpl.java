package com.bkav.portal.portlet.article_publisher.action;


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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * 
 * @author HungDX
 *
 */

public class ConfigurationActionImpl extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
			
			//SystemProperties.set("com.bkav.portal.memcache.key", "hungdx");
			
			System.out.println(SystemProperties.get("com.bkav.portal.memcache.key"));
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);

			String displayStyle = ParamUtil.getString(actionRequest,"displayStyle",StringPool.BLANK);
			
			String styleTitle = ParamUtil.getString(actionRequest, "styleTitle");
			
			boolean showPublishDate = ParamUtil.getBoolean(actionRequest, "showPublishDate",false);
			
			boolean showRSSIcon = ParamUtil.getBoolean(actionRequest, "showRSSIcon",false);
			
			boolean showViewMoreAssetURL = ParamUtil.getBoolean(actionRequest, "showViewMoreAssetURL",false);
			
			boolean queryContains = ParamUtil.getBoolean(actionRequest, "queryContains",true);
			
			boolean queryAndOperator = ParamUtil.getBoolean(actionRequest, "queryAndOperator",false);
			
			String queryName = ParamUtil.getString(actionRequest, "queryName","assetTags");
			
			String[] queryValues = StringUtil.split(ParamUtil.getString(actionRequest, "selectedCategoryIds",StringPool.BLANK));
			
			if(Validator.equals(queryName, "assetTags")){//Truong hop loc tin theo Tag
				queryValues = StringUtil.split(ParamUtil.getString(actionRequest, "selectedTagsNames",StringPool.BLANK));
			}
			
			int numbersOfEntriesDisplay = ParamUtil.getInteger(actionRequest, "numbersOfEntriesDisplay",6);
			
			String orderByColumn = ParamUtil.getString(actionRequest, "orderByColumn","publishDate");
			String orderByType = ParamUtil.getString(actionRequest, "orderByType","DESC");
			
			preferences.setValue("displayStyle", displayStyle);
			preferences.setValue("styleTitle", styleTitle);
			preferences.setValue("showPublishDate", String.valueOf(showPublishDate));
			preferences.setValue("showRSSIcon", String.valueOf(showRSSIcon));
			preferences.setValue("showViewMoreAssetURL", String.valueOf(showViewMoreAssetURL));
			preferences.setValue("queryContains", String.valueOf(queryContains));
			preferences.setValue("queryAndOperator", String.valueOf(queryAndOperator));
			preferences.setValue("queryName", queryName);
			preferences.setValues("queryValues", queryValues);
			preferences.setValue("numbersOfEntriesDisplay", String.valueOf(numbersOfEntriesDisplay));
			preferences.setValue("orderByColumn", orderByColumn);
			preferences.setValue("orderByType", orderByType);
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
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
		return "/html/configuration.jsp";
	}
	
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class.getName());	
}