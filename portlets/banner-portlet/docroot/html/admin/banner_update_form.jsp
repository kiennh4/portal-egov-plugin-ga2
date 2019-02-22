<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
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
	long bannerId = ParamUtil.getLong(request, "bannerId");

	long bannerGroupId = ParamUtil.getLong(request, "bannerGroupId");
	
	String bannerAdminPortletId = "banner_admin_WAR_bannerportlet";
	
	String bannerImagePath = "";
	
	Banner banner = null;
	
	if(bannerId > 0){
		
		banner = BannerLocalServiceUtil.getBanner(bannerId);
		
		if(banner != null){
			
			bannerGroupId = banner.getBannerGroupId();
			
			long bannerImageId = banner.getBannerImageId();
			
			if(bannerImageId > 0){
				
				bannerImagePath = themeDisplay.getPathImage() + "/logo?img_id=" 
								+ bannerImageId + "&t" + WebServerServletTokenUtil.getToken(bannerImageId);
			}
		}
	}
	
	List<BannerGroup> bannerGroupList = BannerGroupLocalServiceUtil.findByGroup(groupId);
	
	String redirect = ParamUtil.getString(request, "redirect",bannerAdminHomePageURL.toString());
	
	boolean closeDialog = false;
	
	PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

	String portletInstanceResource = ParamUtil.getString(request, "portletInstanceResource");
	
	if(Validator.isNotNull(portletInstanceResource)){
		redirect = PortalUtil.getCurrentURL(request);
	}
	
	if(SessionErrors.isEmpty(portletRequest) && !SessionMessages.isEmpty(portletRequest) && Validator.isNotNull(portletInstanceResource)){
		closeDialog = true;
	}
	
	String configFrameName = StringPool.UNDERLINE + portletInstanceResource + StringPool.UNDERLINE + "configurationIframeDialog";
%>
<c:if test="<%=closeDialog%>">
	<aui:script use="aui-base">
		 closeAndRefreshPopup();
	</aui:script>
</c:if>

<liferay-portlet:actionURL portletName="<%=bannerAdminPortletId %>" name="updateBanner" var = "updateBannerActionURL">
	<liferay-portlet:param name="bannerId" value="<%=String.valueOf(bannerId) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=redirect %>"/>
</liferay-portlet:actionURL>

<div class="banner-admin-form">
	<aui:form name="banner_update_form" enctype="multipart/form-data" method="post" action="<%=updateBannerActionURL %>">
		
		<aui:model-context bean="<%= banner %>" model="<%= Banner.class %>" />
		
		<aui:input name="bannerTitle">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="bannerLink" type="textarea" placeholder="http://example.com"/>
										
		<c:if test='<%=Validator.isNotNull(bannerImagePath) %>'>
			<img class="banner-thumbnail-img" alt="" src="<%=bannerImagePath%>" style="border: 1px solid #E4E4E4;">
		</c:if>
		
		<aui:input type="file" name="bannerImageFile" label="choose-image-file"/>
							
		<aui:select name="bannerGroupId" label="banner-group">
			<aui:option label="other" value="0" selected="<%=bannerGroupId == 0L %>"/>
			<%
				for(BannerGroup bannerGroup : bannerGroupList){
			%>
				<aui:option label="<%=bannerGroup.getGroupName() %>" 
							value="<%=String.valueOf(bannerGroup.getBannerGroupId()) %>"
							selected="<%=bannerGroupId == bannerGroup.getBannerGroupId()%>"
				/>
			<%
			}
			%>
		</aui:select>
		
		<aui:input type="hidden" name="bannerImageId" value='<%= banner != null ? banner.getBannerImageId() : CounterLocalServiceUtil.increment() %>'/>
										
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
		
	</aui:form>
</div>

<aui:script>

	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var bannerTitleInput = A.one('#<portlet:namespace/>bannerTitle');
		
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
			
	Liferay.provide(
        window,
        'closeAndRefreshPopup',function() {
			var configDocument = parent.frames['<%=configFrameName%>'].document;
			configDocument.location.reload(true);
		    Liferay.Util.getWindow().close();
        }     
    );
</aui:script>
