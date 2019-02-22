<%@page import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.getAssetList(request,0);
%>

<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		<div class="article-publisher-display-style-3">
			
<!-- 			<div class="style-title"> -->
<%-- 				<span class="title"><%=styleTitle %></span> --%>
<!-- 			</div> -->
			
			<div class="style-asset">
				<marquee behavior="up" direction="up" scrollamount="2" scrolldelay="5" 
						 onmouseover="this.stop();" onmouseout="this.start();" height="320px;">
					<ul>
					<%
					for(AssetEntryCache assetCache : assetCacheList){
						
						String assetTitle = StringUtil.shorten(assetCache.getTitle(), 120);
						
						String assetLink = ArticlePublisherUtil.getViewContentURL(request, assetCache);
						
						String publishDate = dateFormat.format(assetCache.getPublishDate());
					%>
						<li>
							<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
								<%= assetTitle %>
							
								<c:if test="<%=showPublishDate %>">
									<span class="publish-date">(<%=publishDate %>)</span>
								</c:if>
							</a>
						</li>
					<%
					}
					%>
					</ul>
				</marquee>
			</div>
		</div>
	</c:when>
	
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>"
				label="no-asset-found" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>