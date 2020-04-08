package com.portal_egov.portlet.navigation.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.portal_egov.portlet.navigation.util.NavigationUtil;

/**
 * @author HungDX
 */

public class ConfigurationActionImpl extends DefaultConfigurationAction{
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, PORTLET_RESOURCE);
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			String configCommand = ParamUtil.getString(actionRequest,CONFIG_COMMAND,StringPool.BLANK );
			
			if(Validator.equals(configCommand, UPDATE_ENTRIES_SELECTION_COMMAND)){
				
				updateEntrySelection(actionRequest, preferences);
				
				updateDisplaySettings(actionRequest, preferences);
				
			}else if (Validator.equals(configCommand, UPDATE_ENTRY_PROPERTIES_COMMAND)) {
				
				NavigationUtil.updateDisplayName(actionRequest);
				NavigationUtil.updateIconImage(actionRequest);
				NavigationUtil.updateCustomURL(actionRequest);
			
			}else{
				
				System.out.println("[Portlet Navigation] Invalid configuration command!");
			}
			
									
			if(SessionErrors.isEmpty(actionRequest)){
				
				//Luu thong tin cau hinh
				preferences.store();
							
				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);

				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
		
	}
	
	@Override
	public String render(PortletConfig portletConfig,RenderRequest renderRequest, RenderResponse renderResponse)throws Exception {
		
		return "/html/config/configuration.jsp";
	}
	
	
	private static void updateDisplaySettings(ActionRequest actionRequest,PortletPreferences preferences){
		
		try {
			
			String navigationTitle = ParamUtil.getString(actionRequest,NAVIGATION_TITLE,StringPool.BLANK);
			
			String displayStyle = ParamUtil.getString(actionRequest, DISPLAY_STYLE,DEFAULT_DISPLAY_STYLE);
			
			//save configuration
			preferences.setValue(DISPLAY_STYLE, displayStyle);
			
			preferences.setValue(NAVIGATION_TITLE, navigationTitle);
			
		} catch (ReadOnlyException e) {
			e.printStackTrace();
		}				
	}
	
	private static void updateEntrySelection(ActionRequest actionRequest,PortletPreferences preferences){
		
		try {
			
			String selectedName = ParamUtil.getString(actionRequest, SELECTED_NAME,ASSET_TAGS);
			
			String[] selectedValues = StringUtil.split(ParamUtil.getString(actionRequest, SELECTED_CATEGORY_IDS,StringPool.BLANK));
			
			if(Validator.equals(selectedName, ASSET_TAGS)){
			
				selectedValues = StringUtil.split(ParamUtil.getString(actionRequest, SELECTED_TAGS_NAMES,StringPool.BLANK));
			}
																										
			preferences.setValue(SELECTED_NAME, selectedName);
									
			preferences.setValues(SELECTED_VALUES, selectedValues);
			
		}catch (ReadOnlyException e) {
			e.printStackTrace();
		}
	}
	
	
	private static final String PORTLET_RESOURCE = "portletResource";
	
	private static final String DISPLAY_STYLE = "displayStyle";
	
	private static final String DEFAULT_DISPLAY_STYLE = "default-style";
		
	private static final String NAVIGATION_TITLE = "navigationTitle";
			
	private static final String ASSET_TAGS = "assetTags";
		
	private static final String SELECTED_NAME = "selectedName";
	
	private static final String SELECTED_TAGS_NAMES = "selectedTagsNames";
	
	private static final String SELECTED_CATEGORY_IDS = "selectedCategoryIds";
	
	private static final String SELECTED_VALUES = "selectedValues";
	
	private static final String CONFIG_COMMAND = "configCommand";
	
	private static final String UPDATE_ENTRIES_SELECTION_COMMAND = "updateEntriesSelection";
	
	private static final String UPDATE_ENTRY_PROPERTIES_COMMAND = "updateEntryProperties";
}
