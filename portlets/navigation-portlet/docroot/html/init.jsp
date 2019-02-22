<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	long companyId = themeDisplay.getCompanyId();
	
	long scopeGroupId = themeDisplay.getScopeGroupId();
	
	//Property key tuong ung voi ten hien thi cua Tag
	String displayNamePropertyKey = "display-name";	
	
	//Property key tuong ung voi Id anh icon cua Tag
	String iconImageIdPropertyKey = "icon-image-id";
	
	//Property key tuong ung custom url cua Tag
	String customURLPropertyKey = "custom-url";
	
	//Tieu de hien thi
	String navigationTitle = preferences.getValue("navigationTitle",StringPool.BLANK);
	
	//Kieu hien thi mac dinh
	String defaultDisplayStyle = "default-style";
	
	String listTitleDisplayStyle = "list-title-style";
	
	String sliderDisplayStyle = "slider-style";
	
	//Kieu hien thi
	String displayStyle = preferences.getValue("displayStyle",defaultDisplayStyle);
					
	long repositoryId = themeDisplay.getLayout().getGroupId();	
	
	//Kieu du lieu hien thi : Asset Tag,Asset Category hoac Vocabulary
	String selectedName =  preferences.getValue("selectedName", "assetTags");
	
	//Cac entry hien tai dang chon
	String currentSelectedValues = StringUtil.merge(preferences.getValues("selectedValues", new String[0]));
	
	if(Validator.equals(selectedName,"assetTags")){
		
		currentSelectedValues = ParamUtil.getString(request, "selectedTagsNames", currentSelectedValues);
		
	}else {
		currentSelectedValues = ParamUtil.getString(request, "selectedCategoryIds", currentSelectedValues);
	}
	
	String[] selectedValues = preferences.getValues("selectedValues", new String[0]);
	
	long[] selectedTagIds = new long[selectedValues.length];
	long[] selectedCategoryIds = new long[selectedValues.length];
		
	if(Validator.equals(selectedName,"assetTags")){
		
		
		selectedTagIds = AssetTagLocalServiceUtil.getTagIds(scopeGroupId, selectedValues);
		
	}else {
				
		for(int i =0;i < selectedValues.length; i++){
			selectedCategoryIds[i] = Long.parseLong(selectedValues[i]);
		}
		
	}
	
%>















