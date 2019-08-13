<%@page import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.
	getAssetList(request,0);
%>
<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		<div class="article-publisher-display-style-8">
			<%
				AssetEntryCache topAssetCache = assetCacheList.get(0);
				
				String topAssetTitle = StringUtil.shorten(topAssetCache.getTitle(),70);
				
				String topAssetSumary = ArticlePublisherUtil.getContentSummary(request, 
						topAssetCache.getClassPK(), 80);
				
				String topAssetViewUrlContent = ArticlePublisherUtil.getViewContentURL(request,
						topAssetCache);
				
				String topImagePath = ArticlePublisherUtil.getSmallImagePath(request, topAssetCache.getClassPK());
				
			%>
			<aui:column columnWidth="100">
				<div class="top-asset-image">
					<a href="<%=topAssetViewUrlContent%>" title="<%=topAssetCache.getTitle() %>">
						<img alt="<%=topAssetCache.getTitle() %>" src="<%=topImagePath%>"
						onerror="this.src='/thumbnail/default-image.jpg'"
						/>
					</a>
				</div>
				<div class="top-asset-title">
					<a href="<%=topAssetViewUrlContent%>" title="<%=topAssetCache.getTitle()%>">
						<%=topAssetTitle%>
					</a>
				</div>
				<div class="top-asset-sumary">
					<span> <%= topAssetSumary%></span>
				</div>
			</aui:column>
			<aui:layout>
			<%
				for(int i=1; i < assetCacheList.size(); i++){
					AssetEntryCache entryCache = assetCacheList.get(i);
					String entryTitle = StringUtil.shorten(entryCache.getTitle(),70);
					
					String entrySumary = ArticlePublisherUtil.getContentSummary(request, 
							entryCache.getClassPK(), 50);
					
					String entryViewContentUrl = ArticlePublisherUtil.getViewContentURL(request,
							entryCache);
					
					String entryImagePath = ArticlePublisherUtil.getSmallImagePath(request,
							entryCache.getClassPK());
			%>
				<aui:column columnWidth="100">
					<aui:column columnWidth="30">
						<a href="<%=entryViewContentUrl%>"
							title="<%=entryCache.getTitle()%>" class="asset-thumbnail"> <img
							alt="<%=entryCache.getTitle()%>" width="100%"
							src="<%=entryImagePath%>"
							onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'">
						</a>
					</aui:column>
					<aui:column columnWidth="70">
						<div class="asset-title">
							<a href="<%=entryViewContentUrl%>"
								title="<%=entryCache.getTitle()%>"> <%=entryTitle%>
							</a>
						</div>
						<div class="asset-sumary">
							<span> <%=entrySumary%></span>
						</div>
					</aui:column>
				</aui:column>

				<%
				}
			%>
			</aui:layout>
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