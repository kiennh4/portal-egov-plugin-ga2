<%@page import="com.portal_egov.portlet.banner.model.Banner"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.banner.permission.BannerPermission"%>
<%@page import="com.portal_egov.portlet.banner.permission.BannerGroupPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script type="text/javascript" src="/banner-portlet/js/service.js"></script>

<%@include file="/html/admin/init.jsp"%>

<div class="banner-admin">
	
	<div class="lfr-header-row">
		
		<div class="admin-btn" align="left">
			
			<c:if test="<%=BannerGroupPermission.contains(permissionChecker, groupId, BannerGroupPermission.ADD)%>">
				<aui:button name="addBannerGroupBtn" type="button" value="add-new-banner-group"/>
			</c:if>
			
			<c:if test="<%=BannerPermission.contains(permissionChecker, groupId, BannerPermission.ADD)%>">
				<aui:button name="addBannerBtn" type="button" value="add-new-banner"/>
			</c:if>
			
			<c:if test="<%=BannerPermission.contains(permissionChecker, groupId, BannerPermission.PERMISSIONS)%>">
				<liferay-security:permissionsURL
					modelResource="<%=Banner.class.getName() %>"
					modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
					resourcePrimKey="<%= String.valueOf(groupId) %>"
					var="permissionsURL"
				/>
		
				<aui:button href="<%= permissionsURL %>" value="banner-permissions" />
			</c:if>
		</div>			
		
		<div class="admin-search-form" align="right">
		
			<input id='<portlet:namespace />bannerSearchInput' type="text" value=""/>
			
			<aui:button name="searchBannerBtn" type="button" value="search"/>
			
			<aui:button name="showAllBannerBtn" type="button" value="show-all-banners"/>
		</div>
	</div>
	
	<div class="banner-list">
		<aui:layout>
		
			<aui:column columnWidth="20" cssClass="group_menu">
				<div id="banner-groups-container" class="banner-groups-container"></div>
			</aui:column>
			
			<aui:column columnWidth="80" cssClass="banners">
				<div id="banner-list-container" class="banner-list-container"></div>	
			</aui:column>
			
		</aui:layout>
	</div>
</div>

<aui:script use="portal-egov-banner-admin">
	
	new Liferay.Portlet.BannerAdmin(
		{
			scopeGroupId: <%= groupId %>
		}
	);
</aui:script>