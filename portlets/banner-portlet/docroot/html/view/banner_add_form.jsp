<%@page import="com.portal_egov.portlet.banner.service.BannerGroupLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.banner.model.BannerGroup"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.portal_egov.portlet.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.banner.model.Banner"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	List<BannerGroup> bannerGroupList = BannerGroupLocalServiceUtil.findByGroup(groupId);
	
	String redirect = ParamUtil.getString(request, "redirect",bannerAdminHomePageURL.toString());
	
	String bannerAdminPortletId = "banner_admin_WAR_bannerportlet";
	
	String nameSpaces = "_banner_admin_WAR_bannerportlet_";
%>

<liferay-portlet:actionURL portletName="<%=bannerAdminPortletId %>" name="updateBanner" var="updateBannerActionURL">
	<liferay-portlet:param name="redirectURL" value="<%=redirect %>"/>
</liferay-portlet:actionURL>

<div class="banner-admin-form">
	<aui:form name="banner_update_form" enctype="multipart/form-data" method="post" action="<%=updateBannerActionURL %>">
		
		<aui:input name="bannerTitle" id='<%=nameSpaces + "bannerTitle" %>'/>
		
		<aui:input name="bannerLink" type="textarea" placeholder="http://example.com" />
		
		<aui:input type="file" name="bannerImageFile" label="choose-image-file"/>
							
		<aui:select name="bannerGroupId" label="banner-group">
			<aui:option label="other" value="0" />
			<%
				for(BannerGroup bannerGroup : bannerGroupList){
					
					long currentBannerGroupId = bannerGroup.getBannerGroupId();
					
					String bannerGroupName = bannerGroup.getGroupName();
			%>
				<aui:option label="<%=bannerGroupName %>" value="<%=String.valueOf(currentBannerGroupId) %>"
				/>
			<%
			}
			%>
		</aui:select>
								
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
			
	</aui:form>
</div>

<script type="text/javascript">

	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var bannerTitleInput = A.one('#<portlet:namespace />bannerTitle');
		
		if(bannerTitleInput){
			bannerTitleInput.focus();
		}
					
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />banner_update_form,
	
	        rules: {
	            <portlet:namespace />bannerTitle: {
	                required: true,
	                rangeLength: ['3','300']
	            },
	            <portlet:namespace />bannerLink: {
	                required: false,
	                rangeLength: ['3','300']
	            }
	        }
	    });
		
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</script>
