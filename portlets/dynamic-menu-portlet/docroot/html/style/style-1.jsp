<%@page import="com.bkav.portal.portlet.dynamic_menu.util.DynamicMenuUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<DynamicMenuItem> rootMenuItems = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId, selectedMenuId, 0);
%>

<div class="dynamic-menu-style-1">
	<ul id="<portlet:namespace/>root-menu-item-wrapper" class="root-menu-item-wrapper">
		<%
		for(DynamicMenuItem rootMenuItem : rootMenuItems){
			
			long itemId = rootMenuItem.getItemId();
			
			String itemURL = DynamicMenuUtil.getMenuItemURL(themeDisplay, rootMenuItem.getUrlType(), rootMenuItem.getUrl());
		%>
			<li class="menu-item root-item">
				<a href="<%=itemURL%>"><%=rootMenuItem.getName() %></a>
				<%
				buildDropdownMenu(groupId, selectedMenuId, itemId, 1,themeDisplay, out);
				%>
			</li>
		<%
		}
		%>	
	</ul>
</div>

<div style="clear:both;"></div>

<script type="text/javascript">

	AUI().ready(function(A){
		
		jQuery('#<portlet:namespace/>root-menu-item-wrapper').tendina({
		   animate: true,
		   speed: 500,
		   onHover: true,
		   hoverDelay: 300
		});
	});

</script>
