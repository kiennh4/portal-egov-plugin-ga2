<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>

<%@page import="com.bkav.portal.portlet.article_publisher.util.ArticlePublisherConstants"%>
<%@page import="com.bkav.portal.portlet.article_publisher.util.ArticlePublisherUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />
<%
	String languageId = LanguageUtil.getLanguageId(request);

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");

	PortletPreferences preferences = PortalUtil.getPreferences(request);

	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if(Validator.isNotNull(portletResource)){
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

	long groupId = PortalUtil.getScopeGroupId(request);

	String portletId = PortalUtil.getPortletId(request).toString();
	
	Locale locale = PortalUtil.getLocale(request);
	
	long plid = themeDisplay.getPlid();
	
	//Kieu hien thi
	String displayStyle = preferences.getValue("displayStyle", StringPool.BLANK);
	
	String[] numbersOfEntriesDisplayValues = {"1","2","3","4","5","6","7","8","9","10","15","20","30","40","50"};
	
	String styleTitle = preferences.getValue("styleTitle", LanguageUtil.get(locale, "title"));
	
	boolean showPublishDate = GetterUtil.getBoolean(preferences.getValue("showPublishDate", null),false);
	
	boolean showRSSIcon = GetterUtil.getBoolean(preferences.getValue("showRSSIcon", null),false);
	
	boolean showViewMoreAssetURL = GetterUtil.getBoolean(preferences.getValue("showViewMoreAssetURL", null),false);
	
	boolean queryContains = GetterUtil.getBoolean(preferences.getValue("queryContains", null),true);
	
	boolean queryAndOperator = GetterUtil.getBoolean(preferences.getValue("queryAndOperator", null),false);
	
	String queryName = preferences.getValue("queryName","assetTags");
	
	String queryValues = StringUtil.merge(preferences.getValues("queryValues", new String[0]));
	
	String[] queryValuesArray = preferences.getValues("queryValues", new String[0]);
	
	long[] allAssetCategoryIds = new long[0];
	
	String[] allAssetTagNames = new String[0];
	
	if(Validator.equals(queryName,"assetTags")){
		
		queryValues = ParamUtil.getString(request, "selectedTagsNames", queryValues);
		
		allAssetTagNames = new String[queryValuesArray.length];
		
		allAssetTagNames = queryValuesArray;
	}else {
		
		queryValues = ParamUtil.getString(request, "selectedCategoryIds", queryValues);
		
		allAssetCategoryIds = new long[queryValuesArray.length];
		
		for(int i = 0;i < queryValuesArray.length; i++){
			allAssetCategoryIds[i] = Long.parseLong(queryValuesArray[i]);
		}
	}
	
	int numbersOfEntriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfEntriesDisplay", "8"));
	
	String orderByColumn = preferences.getValue("orderByColumn","publishDate");
	
	String orderByType = preferences.getValue("orderByType","DESC");
%>
