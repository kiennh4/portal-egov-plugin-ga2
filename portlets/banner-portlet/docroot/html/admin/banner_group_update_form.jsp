<%@page import="com.portal_egov.portlet.banner.service.BannerGroupLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.banner.model.BannerGroup"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long bannerGroupId = ParamUtil.getLong(request, "bannerGroupId");

	BannerGroup bannerGroup = null;
	
	if(bannerGroupId > 0){
		
		bannerGroup = BannerGroupLocalServiceUtil.getBannerGroup(bannerGroupId);
	}
	
%>

<div class="banner-admin-form">

	<liferay-portlet:actionURL name="updateBannerGroup" var="updateBannerGroupActionURL">
		<liferay-portlet:param name="bannerGroupId" value="<%=String.valueOf(bannerGroupId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=bannerAdminHomePageURL%>"/>
	</liferay-portlet:actionURL>
	
	<aui:form name="banner_group_update_form" method="post" action="<%=updateBannerGroupActionURL %>">
		
		<aui:input  name="bannerGroupName" value='<%=(bannerGroup != null) ? bannerGroup.getGroupName() : "" %>'>
			<aui:validator name="required" />
		</aui:input>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script>

	AUI().ready(function(A){
		
		var bannerGroupNameInput = A.one('#<portlet:namespace />bannerGroupName');
		
		if(bannerGroupNameInput){
			bannerGroupNameInput.focus();
		}
				
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>
