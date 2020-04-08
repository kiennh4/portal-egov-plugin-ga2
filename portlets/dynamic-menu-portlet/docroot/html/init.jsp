<%@page import="com.bkav.portal.portlet.dynamic_menu.util.DynamicMenuUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.permission.DynamicMenuItemPermission"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.permission.DynamicMenuPermission"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuItemLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>

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
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	Locale locale = PortalUtil.getLocale(request);
	
	long groupId = themeDisplay.getScopeGroupId();
	
	long userId = PortalUtil.getUserId(request);
	
	boolean hasSignedIn = themeDisplay.isSignedIn();
	
	boolean hasAddMenuPermission = hasSignedIn 
					&& DynamicMenuPermission.contains(permissionChecker, groupId,"ADD");
	
	boolean hasUpdateMenuPermission = hasSignedIn 
					&& DynamicMenuPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE);
	
	boolean hasDeleteMenuPermission = hasSignedIn 
					&& DynamicMenuPermission.contains(permissionChecker, groupId, ActionKeys.DELETE);
	
	boolean hasAddMenuItemPermission = hasSignedIn 
					&& DynamicMenuItemPermission.contains(permissionChecker, groupId,"ADD");
	
	boolean hasUpdateMenuItemPermission = hasSignedIn 
					&& DynamicMenuItemPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE);
	
	boolean hasDeleteMenuItemPermission = hasSignedIn 
					&& DynamicMenuItemPermission.contains(permissionChecker, groupId, ActionKeys.DELETE);
		
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)){
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//Id cua menu duoc chon hien thi
	long selectedMenuId = GetterUtil.getLong(preferences.getValue("selectedMenuId", "0"));
	
	String displayStyle = preferences.getValue("displayStyle", "style-1");
%>

<%!
	protected void buildMenuItemTree(long groupId,long menuId,long parentItemId,
		int treeLevel,HttpServletRequest request,JspWriter jspWriter){
		
		try{
	
			List<DynamicMenuItem> childItems = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId, menuId, parentItemId);
			
			if(childItems.size() > 0){
				
				jspWriter.println("<ul class=\"sub-menu-item-wrapper\">");
				
				for(DynamicMenuItem childItem : childItems){
					
					String childItemName = childItem.getName();
					
					long itemId = childItem.getItemId();
					
					long parentId = childItem.getParentId();
					
					ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
					
					PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
					
					boolean hasSignedIn = themeDisplay.isSignedIn();
					
					boolean hasAddMenuPermission = hasSignedIn 
									&& DynamicMenuPermission.contains(permissionChecker, groupId,"ADD");
					
					boolean hasUpdateMenuPermission = hasSignedIn 
									&& DynamicMenuPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE);
					
					boolean hasDeleteMenuPermission = hasSignedIn 
									&& DynamicMenuPermission.contains(permissionChecker, groupId, ActionKeys.DELETE);
					
					boolean hasAddMenuItemPermission = hasSignedIn 
									&& DynamicMenuItemPermission.contains(permissionChecker, groupId,"ADD");
					
					boolean hasUpdateMenuItemPermission = hasSignedIn 
									&& DynamicMenuItemPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE);
					
					boolean hasDeleteMenuItemPermission = hasSignedIn 
									&& DynamicMenuItemPermission.contains(permissionChecker, groupId, ActionKeys.DELETE);
					
					PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
					
					String itemURL = DynamicMenuUtil.getMenuItemURL(themeDisplay, 
															childItem.getUrlType(), childItem.getUrl());
					
					String addChildItemURL = "javascript:" + portletDisplay.getNamespace() 
										   + "showMenuItemUpdateForm(" + menuId + "," + itemId + "," + 0 + ");";
							
					String updateItemURL = "javascript:" + portletDisplay.getNamespace() 
										 + "showMenuItemUpdateForm(" + menuId + "," + parentId + "," + itemId + ");";
					
				 	PortletURL deleteItemURL = PortletURLFactoryUtil.create(request, portletDisplay.getId(),
				 		themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
				 	
				 	deleteItemURL.setWindowState(LiferayWindowState.POP_UP);
				 	deleteItemURL.setParameter(ActionRequest.ACTION_NAME, "deleteMenuItem");
				 	deleteItemURL.setParameter("itemId", String.valueOf(itemId));
				 	deleteItemURL.setParameter("redirectURL", PortalUtil.getCurrentURL(request));
										 
					jspWriter.println("<li class=\"menu-item\">");
					
					jspWriter.println("<a href=\"" + itemURL + "\">" + childItemName + "</a>");
					
					jspWriter.println("<div class=\"menu-action\">");
					if(hasAddMenuItemPermission){
						jspWriter.println("<a class=\"add-menu-item-trigger menu-actions\" href=\"" 
											+ addChildItemURL + "\"></a>");
					}
					
					if(hasUpdateMenuItemPermission){
						jspWriter.println("<a class=\"update-menu-item-trigger menu-actions\" href=\"" 
											+ updateItemURL + "\"></a>");
					}
					
					if(hasDeleteMenuItemPermission){
						jspWriter.println("<a class=\"delete-menu-item-trigger menu-actions\" href=\"" 
											+ deleteItemURL.toString() 
											+ "\" onclick=\"return confirm('confirm delete ?');\" ></a>");
					}
					
					jspWriter.println("</div>");
					
					int nextTreeLevel = treeLevel + 1;
					
					buildMenuItemTree(groupId, childItem.getMenuId(),childItem.getItemId(),nextTreeLevel,request,jspWriter);
					
					jspWriter.println("</li>");
				}
				
				jspWriter.println("</ul>");
			}
		}catch(Exception e){
			
		}
	}

	protected void buildDropdownMenu(long groupId,long menuId,long parentItemId,
		int treeLevel,ThemeDisplay themeDisplay,JspWriter jspWriter){
		
		try{
	
			List<DynamicMenuItem> childItems = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId, menuId, parentItemId);
			
			if(childItems.size() > 0){
				
				jspWriter.println("<ul class=\"sub-menu-item-wrapper\">");
				
				for(DynamicMenuItem childItem : childItems){
					
					String childItemName = childItem.getName();
					
					long itemId = childItem.getItemId();
					
					long parentId = childItem.getParentId();
					
					String itemURL = DynamicMenuUtil.getMenuItemURL(themeDisplay, 
															childItem.getUrlType(), childItem.getUrl());
					
										 
					jspWriter.println("<li class=\"menu-item\">");
					
					jspWriter.println("<a href=\"" + itemURL + "\">" + childItemName + "</a>");
					
					int nextTreeLevel = treeLevel + 1;
					
					buildDropdownMenu(groupId, childItem.getMenuId(),childItem.getItemId(),nextTreeLevel,themeDisplay,jspWriter);
					
					jspWriter.println("</li>");
				}
				
				jspWriter.println("</ul>");
			}
		}catch(Exception e){
			
		}
	}

	protected void buildMenuItemTreeSelector(long groupId,long menuId,long parentItemId,
		long selectedItemId,int treeLevel,JspWriter jspWriter){
		
		try{
	
			List<DynamicMenuItem> childItems = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId, menuId, parentItemId);
			
			if(childItems.size() > 0){
				
				for(DynamicMenuItem childItem : childItems){
					
					String prefix = "";
					
					if(treeLevel > 0){
						
						for(int i = 0; i< treeLevel; i++){
							
							prefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
					}
					
					String childItemName = prefix + childItem.getName();
					
					if(childItem.getItemId() == selectedItemId){
						
						jspWriter.println("<option selected=\"selected\" value=\"" 
										 	+ childItem.getItemId() + "\">" + childItemName + "</option>");
					}else{
						
						jspWriter.println("<option value=\"" + childItem.getItemId() + "\">" + childItemName + "</option>");
					}
					
					
					int nextTreeLevel = treeLevel + 1;
					
					buildMenuItemTreeSelector(groupId, childItem.getMenuId(),childItem.getItemId(),
						selectedItemId,nextTreeLevel,jspWriter);
				}
			}
		}catch(Exception e){
			
		}
	}
%>
