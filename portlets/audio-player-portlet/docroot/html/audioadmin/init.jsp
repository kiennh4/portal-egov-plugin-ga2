<%@page import="java.util.prefs.Preferences"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.util.*"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>

 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
	
	long groupId = PortalUtil.getScopeGroupId(request);
	
	long userId = PortalUtil.getUserId(request);
	
	long companyId = PortalUtil.getCompanyId(request);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss"); 
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String audioplayerAdminPortletId = "audioadmin_WAR_audioplayerportlet";
	
	long audioFolderId = GetterUtil.getLong(preferences.getValue("audioFolderId", "0"));
	
	AudioConstants audioConstants = new AudioConstants();
	
	String audioExtensions = StringUtil.merge(preferences.getValues("audioExtensions", 
			audioConstants.DEFAULT_AUDIO_EXTENSIONS));

	long audioMaxSize = GetterUtil.getLong(preferences.getValue("audioMaxSize",
			String.valueOf(audioConstants.DEFAULT_AUDIO_MAX_SIZE)));
	
	String imageCoverExtensions = StringUtil.merge(preferences.getValues("imageCoverExtensions",
			audioConstants.DEFAULT_IMAGE_COVER_EXTENSIONS));
	
	long imageCoverMaxSize = GetterUtil.getLong(preferences.getValue("imageCoverMaxSize",
			String.valueOf(audioConstants.DEFAULT_IMAGE_COVER_MAX_SIZE)));
%>

	<liferay-portlet:renderURL var="albumAdminHomePageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/audioadmin/view.jsp"/>
	</liferay-portlet:renderURL>
	
<%!
	/**
	* Tao cay thu muc trong document media
	* parentFolderId - Id cua thu muc cha (mac dinh la thu muc Root)
	* treeLevel - Cap thu muc
	* selectedFolderId - Thu muc dang duoc chon de hien thi anh
	*/
	protected void buildDLFolderTree(long groupId,long parentFolderId,int treeLevel,JspWriter jspWriter,long selectedFolderId){
		
		try{
	
			//Lay danh sach thu muc con cap 1 tinh tu thu muc cha (theo parentFolderId)
			List<DLFolder> subFolderList = DLFolderLocalServiceUtil.getFolders(groupId, parentFolderId);
			
			if(subFolderList.size() > 0){
				
				for(DLFolder subFolder : subFolderList){
					
					String folderNamePrefix = "";
					
					if(treeLevel > 0){
						
						for(int i = 0; i< treeLevel; i++){
							
							folderNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
					}
					
					String subFolderName = folderNamePrefix + subFolder.getName();
					
					if(subFolder.getFolderId() == selectedFolderId){
						
						jspWriter.println("<option selected=\"selected\" value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
					}else{
						
						jspWriter.println("<option value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
					}
					
					int nextTreeLevel = treeLevel + 1;
					
					buildDLFolderTree(groupId, subFolder.getFolderId(), nextTreeLevel, jspWriter, selectedFolderId);
				}
			}
		}catch(Exception e){
			
		}
	}
%>