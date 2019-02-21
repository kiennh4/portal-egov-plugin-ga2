<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	/**
	*	Scope Parameters
	**/
	PortletPreferences preferences = PortalUtil.getPreferences(request);

	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if(Validator.isNotNull(portletResource)){
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	long groupId = PortalUtil.getScopeGroupId(request);
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	//Id cua folder hien thi anh
	long selectedImageFolderId = GetterUtil.getLong(preferences.getValue("selectedImageFolderId", String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)));
	
	//So luong anh hien thi.Mac dinh la tat ca anh co trong thu muc duoc chon.
	int numbersOfImageDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfImageDisplay","5"));
	
	//Su dung anh nho (thumbnail) de hien thi
	boolean useThumbnailImage = GetterUtil.getBoolean(preferences.getValue("useThumbnailImage", "true"));
	
	//Hien thi kich thuoc anh tuy chon
	boolean useCustomImageSize = GetterUtil.getBoolean(preferences.getValue("useCustomImageSize", "false"));
	
	//Chieu dai anh thumbnail mac dinh cua file anh tren thu vien
	int imageThumbnailWidth = GetterUtil.getInteger(preferences.getValue("imageThumbnailWidth","260"));
	
	//Chieu rong anh thumbnail mac dinh cua file anh tren thu vien
	int imageThumbnailHeight = GetterUtil.getInteger(preferences.getValue("imageThumbnailHeight","140"));
	
	//Hien thi link den trang Gallery
	boolean displayGalleryLink = GetterUtil.getBoolean(preferences.getValue("displayGalleryLink", "true"));
	
	//Id cua Page hien thi Gallery
	long galleryPageId = GetterUtil.getLong(preferences.getValue("galleryPageId", String.valueOf(themeDisplay.getPlid())));
%>

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