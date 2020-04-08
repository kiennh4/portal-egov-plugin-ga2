<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.bkav.portal.portlet.rss.service.RssFeedLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.rss.model.RssFeed"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long feedId = ParamUtil.getLong(request, "feedId");

	RssFeed rssFeed = null;
	
	if(feedId > 0){
		
		rssFeed = RssFeedLocalServiceUtil.getRssFeed(feedId);
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateRssFeed();";
%>

<div class="rss-update-form">
	
	<liferay-portlet:actionURL portletName="rssadmin_WAR_rssportlet" name="updateRssFeed" var = "updateRssFeedActionURL">
		<liferay-portlet:param name="feedId" value="<%=String.valueOf(feedId) %>"/>
	</liferay-portlet:actionURL>

	<aui:form name="fm"  method="post" action="<%=updateRssFeedActionURL%>" onSubmit="<%=taglibOnSubmit %>">
	
		<aui:model-context bean="<%= rssFeed %>" model="<%= RssFeed.class %>" />
				
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
				
		<aui:input name="url" placeholder="http://example.com/rss">
			<aui:validator name="required" />
			<aui:validator name="url" />
		</aui:input>		
<%-- 		<aui:input type="textarea" name="description" /> --%>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
		
	</aui:form>
</div>

<aui:script>
	AUI().ready('aui-loading-mask', 'aui-io-request',function(A){
	
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
				
		Liferay.provide(
			window,
			'<portlet:namespace />updateRssFeed',
			function() {
				
				var formContainer = A.one('#<portlet:namespace />fm');
				
				formContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
				
				formContainer.loadingmask.toggle();
				
				A.io.request(
					document.<portlet:namespace />fm.action,
					{
						dataType: 'html',
						form: {
							id: document.<portlet:namespace />fm
						},
						after: {
							success: function() {
								Liferay.Util.getOpener().refresh();
								Liferay.Util.getWindow().close();
							}
						}
					}
				);
			}
		);
	});			
</aui:script>