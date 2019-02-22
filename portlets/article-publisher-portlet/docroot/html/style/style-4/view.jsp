<%@page import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.getAssetList(request,numbersOfEntriesDisplay);
%>

<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		<div class="article-publisher-display-style-4">
			<ul>
			<%
			for(AssetEntryCache assetCache : assetCacheList){
				
				String assetTitle = StringUtil.shorten(assetCache.getTitle(), 120);
				
				String assetLink = ArticlePublisherUtil.getViewContentURL(request, assetCache);
				
				String assetImagePath = assetCache.getSmallImagePath();
				
				String publishDate = dateFormat.format(assetCache.getPublishDate());
			%>
				<li>
					<div class="asset-image">
						<a href="<%=assetLink%>">
							<img class="small-img" align="left" 
								src="<%= assetImagePath %>" 
								title="<%=assetCache.getTitle()%>"
								onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'"	
							/>
						</a>
					</div>
					
					<div class="asset-title">
						<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
							<%= assetTitle %>
						
							<c:if test="<%=showPublishDate %>">
								<span class="publish-date">(<%=publishDate %>)</span>
							</c:if>
						</a>
					</div>
					
					<div style="clear: both;"></div>
				</li>
			<%
			}
			%>
			</ul>
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