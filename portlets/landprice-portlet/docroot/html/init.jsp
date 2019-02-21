<%@page import="com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandLocation"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	long companyId = PortalUtil.getCompanyId(request);
	
	long groupId = PortalUtil.getScopeGroupId(request);
	
	long userId = PortalUtil.getUserId(request);
	
	User user = null;
	
	if(userId > 0){
		user = UserLocalServiceUtil.getUser(userId);
	}
	
	String portletId = PortalUtil.getPortletId(request);
	
	Locale locale = PortalUtil.getLocale(request);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
%>


<%!
protected void buildLandLocationTree(long parentLocationId,int treeLevel,JspWriter jspWriter,long selectedLocationId){
	
	try{

		List<LandLocation> subLocationList = LandLocationLocalServiceUtil.findByParentLocation(parentLocationId);
		
		if(subLocationList.size() > 0){
			
			for(LandLocation subLocation : subLocationList){
				
				String locationNamePrefix = "";
				
				if(treeLevel > 0){
					
					for(int i = 0; i< treeLevel; i++){
						
						locationNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					}
				}
				
				String subLocationName = locationNamePrefix + " - " + subLocation.getLocationName();
				
				if(subLocation.getLocationId() == selectedLocationId){
					
					jspWriter.println("<option selected=\"selected\" value=\"" + subLocation.getLocationId() + "\">" + subLocationName + "</option>");
				}else{
					
					jspWriter.println("<option value=\"" + subLocation.getLocationId() + "\">" + subLocationName + "</option>");
				}
				
				int nextTreeLevel = treeLevel + 1;
				
				buildLandLocationTree(subLocation.getLocationId(), nextTreeLevel, jspWriter, selectedLocationId);
			}
		}
	}catch(Exception e){
		
	}
}
%>