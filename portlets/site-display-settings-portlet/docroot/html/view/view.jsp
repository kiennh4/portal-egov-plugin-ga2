<%@page import="com.liferay.portlet.documentlibrary.ImageSizeException"%>
<%@page import="com.liferay.portal.ImageTypeException"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	String siteName = "new-site";	

	Group group = GroupLocalServiceUtil.getGroup(groupId);
	
	if(group != null){
		
		siteName = group.getDescriptiveName(locale);
	}
	
	String currentURL = PortalUtil.getCurrentURL(request);
%>

<div class="setting-container taglib-form-navigator">
	<liferay-ui:header title="<%=siteName %>" />
	
	<aui:layout>
		<aui:column columnWidth="70" cssClass="setting-content form-section" first="true">
			<div id="<portlet:namespace />setting-content-container"></div>
		</aui:column>
		
		<aui:column columnWidth="30" cssClass="setting-menu lfr-component form-navigator" >
		
			<h3><liferay-ui:message key="setting-menu"/></h3>
			
			<div id='<portlet:namespace/>setting-menu-container'>
				<ul>
					<li>
						<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= true %>" varImpl="updateSiteHeaderURL">
							<portlet:param name="jspPage" value="/html/view/sections/header.jsp" />
						</liferay-portlet:resourceURL>
						
						<a class="setting-menu-item" href='<%=updateSiteHeaderURL %>' id="<portlet:namespace/>updateSiteHeader">
							<liferay-ui:message key="header"/>
						</a>
					</li>
								
					<li>
						<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= true %>" varImpl="updateSiteFooterURL">
							<portlet:param name="jspPage" value="/html/view/sections/footer.jsp" />
						</liferay-portlet:resourceURL>
						
						<a class="setting-menu-item" href='<%=updateSiteFooterURL %>' id="<portlet:namespace/>updateSiteFooter">
							<liferay-ui:message key="footer"/>
						</a>
					</li>
					<li>
						<liferay-portlet:resourceURL copyCurrentRenderParameters="<%=true %>" varImpl="updateSloganURL">
							<portlet:param name="jspPage" value="/html/view/sections/slogan.jsp"/>
						</liferay-portlet:resourceURL>
						
						<a href='<%=updateSloganURL%>' class="setting-menu-item" id="<portlet:namespace/>updateSlogan">
							<liferay-ui:message key="slogan"/>
						</a>
					</li>
					<li>
						<liferay-portlet:resourceURL copyCurrentRenderParameters="<%=true %>" varImpl="updateSiteInfoURL">
							<portlet:param name="jspPage" value="/html/view/sections/siteinfo.jsp"/>
						</liferay-portlet:resourceURL>
				
						<a href='<%=updateSiteInfoURL%>' class="setting-menu-item" id="<portlet:namespace/>updateSiteInfo">
							<liferay-ui:message key="site-info"/>
						</a>
					</li>
				</ul>
			</div>
		</aui:column>

	</aui:layout>
</div>

<aui:script use="aui-io-plugin,node-event-simulate,history-hash">

	var settingContentContainer = A.one('#<portlet:namespace />setting-content-container');

	settingContentContainer.plug(
		A.Plugin.IO,
		{
			autoLoad: false
		}
	);
	
	var firstLoad = false;
	
	A.on('hashchange', function (e) {
	
		var hash = location.hash;
		
		var itemNode = A.one(hash); 
		
		firstLoad = false;
		
		if(itemNode){
			firstLoad = true;
			settingContentContainer.io.set('uri', itemNode.get('href'));
			settingContentContainer.io.start();
		};
	}, A.config.win);

	if(!firstLoad){
	
		var hash = location.hash;
		
		var itemNode = A.one(hash); 
		
		if(itemNode){
			firstLoad = true;
			settingContentContainer.io.set('uri', itemNode.get('href'));
			settingContentContainer.io.start();
		};
	}
	
	if(!firstLoad) {
		var itemNode = A.one('#<portlet:namespace />setting-menu-container .setting-menu-item');
		settingContentContainer.io.set('uri', itemNode.get('href'));
		settingContentContainer.io.start();
		
		itemNode.addClass('active');
	}

	A.one('#<portlet:namespace />setting-menu-container').delegate(
		'click',
		function(event) {
		
			event.preventDefault();
			
			var item = event.currentTarget;
			
			A.all('.setting-menu-item').removeClass('active');
			
			item.addClass('active');
			
			var requestUri = item.get('href');
			var id = item.get('id');
			
			var ioStart = true;
			
			if(item.get('id') == '<portlet:namespace/>resetSite'){
			
				ioStart = false;
				
				var res = confirm('<liferay-ui:message key="confirm-reset" />');
				
				if(res == true){
					window.close();
					window.parent.location.href = requestUri;
				}
			}

			if(ioStart && id) {
				window.location.hash = '#' + id;
			}
		},
		'.setting-menu-item'
	);
</aui:script>
