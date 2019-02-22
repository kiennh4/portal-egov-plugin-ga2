<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalService"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsDepartment"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	long companyId = themeDisplay.getCompanyId();
	
	long groupId = themeDisplay.getScopeGroupId();
	
	String portletId = PortalUtil.getPortletId(request);
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	long defaultDepartmentId = GetterUtil.getLong(preferences.getValue("defaultDepartmentId", "0"));
	
	boolean showDepartmentOnly = GetterUtil.getBoolean(preferences.getValue("showDepartmentOnly", "false"));
	
	boolean showDepartmentInfo = GetterUtil.getBoolean(preferences.getValue("showDepartmentInfo", "false"));
	
	boolean showEmptyDepartment = GetterUtil.getBoolean(preferences.getValue("showEmptyDepartment", "false"));
%>

<%!
/**
* Tao cay don vi
* parentFolderId - Id cua thu muc cha (mac dinh la thu muc Root)
* treeLevel - Cap thu muc
* selectedFolderId - Thu muc dang duoc chon de hien thi anh
*/
protected void buildContactDepartmentTree(long groupId,long parentDepartmentId,int treeLevel,JspWriter jspWriter,long selectedDepartmentId){
	
	try{

		List<ContactsDepartment> listRootDepartments = ContactsDepartmentLocalServiceUtil.findByParentAndGroup(groupId, parentDepartmentId);
		
		if(listRootDepartments.size() > 0){
			
			for(ContactsDepartment childDeparment : listRootDepartments){
				
				String departmentNamePrefix = "";
				
				if(treeLevel > 0){
					
					for(int i = 0; i< treeLevel; i++){
						
						departmentNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					}
				}
				
				String childDeparmentName = departmentNamePrefix + childDeparment.getDepartmentName();
				
				if(childDeparment.getDepartmentId() == selectedDepartmentId){
					
					jspWriter.println("<option selected=\"selected\" value=\"" + childDeparment.getDepartmentId() + "\">" + childDeparmentName + "</option>");
				}else{
					
					jspWriter.println("<option value=\"" + childDeparment.getDepartmentId() + "\">" + childDeparmentName + "</option>");
				}
				
				int nextTreeLevel = treeLevel + 1;
				
				buildContactDepartmentTree(groupId, childDeparment.getDepartmentId(), nextTreeLevel, jspWriter, selectedDepartmentId);
			}
		}
	}catch(Exception e){
		
	}
}
%>