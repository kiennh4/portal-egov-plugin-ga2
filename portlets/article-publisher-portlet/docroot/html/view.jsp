<%@page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.LayoutLocalService"%>
<%@page import="com.liferay.portal.service.LayoutServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String styleViewPath = "/html/style/" + displayStyle.trim() + "/view.jsp";

	String linkToLayoutUuid = GetterUtil.getString(preferences.getValue("portletSetupLinkToLayoutUuid", null)); 

	String linkToPage = "";
	
	if ((linkToLayoutUuid!=null)&&(!linkToLayoutUuid.equals("")))
	{
		Layout layout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(linkToLayoutUuid, groupId);
		
		if (layout!=null)
		{
			linkToPage = layout.getFriendlyURL();
		}
		
	}

%>

<c:if test="<%=themeDisplay.isSignedIn()%>">
	<aui:form name="fm">
		<div class="lfr-meta-actions add-article-action" >
			<%@ include file="/html/add_asset.jspf" %>
		</div>
	</aui:form>
</c:if>

<c:choose>
	<c:when test='<%=Validator.isNotNull(displayStyle) %>'>
		<c:choose>
			<c:when test="<%=displayStyle.equals(ArticlePublisherConstants.DISPLAY_STYLE_8) %>">
				<liferay-portlet:renderURL var="style8ContentUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
					<liferay-portlet:param name="jspPage" value="/html/style/style-8/view.jsp"/>
				</liferay-portlet:renderURL>
				
				<aui:script>
				var A = AUI();
				
					Liferay.provide(
							window,
							'<portlet:namespace/>renderArticle',
							function(queryValue, queryId){
							
							var portletContainerId = 'p_p_id' + '<%=renderResponse.getNamespace() %>';
							
							A.all('.<portlet:namespace/>article-tabs').removeClass('active');
							
							A.one('.<portlet:namespace/>article-tab-'+queryId).addClass('active');
								
							A.io.request('<%=style8ContentUrl%>',{   
								
								data:{
									queryValue: queryValue,
								},
								on: {   
									success: function(){
										
										var content = this.get('responseData');
				
										var style8ContentContainer = A.one('#<portlet:namespace/>style8Content');
										
										if(style8ContentContainer && content){
											
											style8ContentContainer.empty();
											
											style8ContentContainer.html(content);
										}
									},
									failure:function(){
										
										var loadDataFailMsgTpl 	= '<div class="portlet-msg-info">'
																+ 	'<liferay-ui:message key="load-data-failure"/>'
																+ '</div>';
																
										var style8ContentContainer = A.one('#<portlet:namespace/>style8Content');
										
										style8ContentContainer.html(loadDataFailMsgTpl);
									}
								} 
							});
								
						});
					
				</aui:script>
				<div id = "<portlet:namespace/>style8Content">
					<liferay-util:include page="<%=styleViewPath %>" servletContext="<%=this.getServletContext() %>"/>
				</div>
			</c:when>
			<c:otherwise>
				<liferay-util:include page="<%=styleViewPath %>" servletContext="<%=this.getServletContext() %>"/>
			</c:otherwise>
		</c:choose>
		
		
		<c:if test="<%=showRSSIcon || showViewMoreAssetURL %>">
			<div class="bottom-links">
				<c:if test="<%=showRSSIcon %>">
				
					<portlet:resourceURL var="rssResourceURL"/>
					
					<div class="subscribe">
						<liferay-ui:icon
							image="rss"
							label="<%= true %>"
							method="get"
							target="_blank"
							url="<%= rssResourceURL %>"
						/>
					</div>
				</c:if>
				
				<c:if test="<%=showViewMoreAssetURL %>">
					<%
					String olderAssetURL = ArticlePublisherUtil.getOlderAssetsURL(request);
					%>
					<div class="read-more-articles">
						<a href="<%=olderAssetURL%>"><liferay-ui:message key="more-articles"/></a>
					</div>
				</c:if>
			</div>
		</c:if>
	</c:when>
	
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-config-this-portlet-to-display-assets" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>


