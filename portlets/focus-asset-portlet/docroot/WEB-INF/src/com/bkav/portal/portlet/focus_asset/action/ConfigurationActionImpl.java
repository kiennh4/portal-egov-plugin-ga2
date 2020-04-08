package com.bkav.portal.portlet.focus_asset.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.focus_asset.util.FocusAssetConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * 
 * @author HungDX
 *
 */

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		try {

			String portletResource = ParamUtil.getString(actionRequest,
					"portletResource");

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest, portletResource);

			String displayStyle = ParamUtil.getString(actionRequest,
					"displayStyle", StringPool.BLANK);

			if (Validator.equals(displayStyle,
					FocusAssetConstants.DISPLAY_STYLE_1)) {

				updateStyle1Config(actionRequest, preferences);

			} else if (Validator.equals(displayStyle,
					FocusAssetConstants.DISPLAY_STYLE_2)) {

				for (int i = 0; i < FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS.length; i++) {

					String tabPrefix = FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS[i];

					updateTabConfig(actionRequest, tabPrefix, preferences);
				}
			} else if (Validator.equals(displayStyle,
					FocusAssetConstants.DISPLAY_STYLE_3)) {

				for (int i = 0; i < FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS.length; i++) {

					String tabPrefix = FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS[i];

					updateTabConfig(actionRequest, tabPrefix, preferences);

				}
			} else if (Validator.equals(displayStyle,
					FocusAssetConstants.DISPLAY_STYLE_4)) {

				for (int i = 0; i < FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS.length; i++) {

					String tabPrefix = FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS[i];

					updateTabConfig(actionRequest, tabPrefix, preferences);

				}
			} else if (Validator.equals(displayStyle,
					FocusAssetConstants.DISPLAY_STYLE_5)) {
				for(int i=0; i < FocusAssetConstants.STYLE_5_TAB_PARAM_PREFIXS.length; i++){
					String tabPrefix = FocusAssetConstants.STYLE_5_TAB_PARAM_PREFIXS[i];
					updateTabConfig(actionRequest, tabPrefix, preferences);
				}
			}

			preferences.setValue("displayStyle", displayStyle);

			if (SessionErrors.isEmpty(actionRequest)) {

				preferences.store();

				SessionMessages.add(actionRequest,
						portletConfig.getPortletName()
								+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
						portletResource);

				SessionMessages
						.add(actionRequest,
								portletConfig.getPortletName()
										+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
		} catch (Exception e) {
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

	protected void updateStyle1Config(ActionRequest actionRequest,
			PortletPreferences preferences) throws PortalException,
			SystemException, ReadOnlyException, ValidatorException, IOException {

		String styleTitle = ParamUtil.getString(actionRequest, "styleTitle");

		boolean showPublishDate = ParamUtil.getBoolean(actionRequest,
				"showPublishDate", false);

		boolean queryContains = ParamUtil.getBoolean(actionRequest,
				"queryContains", true);

		boolean queryAndOperator = ParamUtil.getBoolean(actionRequest,
				"queryAndOperator", false);

		String queryName = ParamUtil.getString(actionRequest, "queryName",
				"assetTags");

		String[] queryValues = StringUtil.split(ParamUtil.getString(
				actionRequest, "selectedCategoryIds", StringPool.BLANK));

		if (Validator.equals(queryName, "assetTags")) {// Truong hop loc tin
														// theo Tag

			queryValues = StringUtil.split(ParamUtil.getString(actionRequest,
					"selectedTagsNames", StringPool.BLANK));
		}

		int numbersOfEntriesDisplay = ParamUtil.getInteger(actionRequest,
				"numbersOfEntriesDisplay", 6);

		String orderByColumn = ParamUtil.getString(actionRequest,
				"orderByColumn", "publishDate");
		String orderByType = ParamUtil.getString(actionRequest, "orderByType",
				"DESC");

		preferences.setValue("styleTitle", styleTitle);
		preferences
				.setValue("showPublishDate", String.valueOf(showPublishDate));
		preferences.setValue("queryContains", String.valueOf(queryContains));
		preferences.setValue("queryAndOperator",
				String.valueOf(queryAndOperator));
		preferences.setValue("queryName", queryName);
		preferences.setValues("queryValues", queryValues);
		preferences.setValue("numbersOfEntriesDisplay",
				String.valueOf(numbersOfEntriesDisplay));
		preferences.setValue("orderByColumn", orderByColumn);
		preferences.setValue("focusAssetOrderByType", orderByType);

	}

	protected void updateTabConfig(ActionRequest actionRequest,
			String configParamPrefix, PortletPreferences preferences)
			throws PortalException, SystemException, ReadOnlyException,
			ValidatorException, IOException {

		String tabTitle = ParamUtil.getString(actionRequest, configParamPrefix
				+ "TabTitle");

		boolean queryContains = ParamUtil.getBoolean(actionRequest,
				configParamPrefix + "TabQueryContains", true);

		boolean queryAndOperator = ParamUtil.getBoolean(actionRequest,
				configParamPrefix + "TabQueryAndOperator", false);

		String queryName = ParamUtil.getString(actionRequest, configParamPrefix
				+ "TabQueryName", "assetTags");

		String[] queryValues = StringUtil.split(ParamUtil.getString(
				actionRequest, configParamPrefix + "TabSelectedCategoryIds",
				StringPool.BLANK));

		if (Validator.equals(queryName, "assetTags")) {// Truong hop loc tin
														// theo Tag

			queryValues = StringUtil.split(ParamUtil.getString(actionRequest,
					configParamPrefix + "TabSelectedTagsNames",
					StringPool.BLANK));
		}

		int numbersOfEntriesDisplay = ParamUtil.getInteger(actionRequest,
				configParamPrefix + "TabEntriesDisplay", 6);

		String orderByColumn = ParamUtil.getString(actionRequest,
				configParamPrefix + "TabOrderByColumn", "publishDate");
		String orderByType = ParamUtil.getString(actionRequest,
				configParamPrefix + "TabOrderByType", "DESC");

		preferences.setValue(configParamPrefix + "TabTitle", tabTitle);
		preferences.setValue(configParamPrefix + "TabQueryContains",
				String.valueOf(queryContains));
		preferences.setValue(configParamPrefix + "TabQueryAndOperator",
				String.valueOf(queryAndOperator));
		preferences.setValue(configParamPrefix + "TabQueryName", queryName);
		preferences
				.setValues(configParamPrefix + "TabQueryValues", queryValues);
		preferences.setValue(configParamPrefix + "TabEntriesDisplay",
				String.valueOf(numbersOfEntriesDisplay));
		preferences.setValue(configParamPrefix + "TabOrderByColumn",
				orderByColumn);
		preferences.setValue(configParamPrefix + "TabOrderByType", orderByType);

	}
	

	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class
			.getName());
}