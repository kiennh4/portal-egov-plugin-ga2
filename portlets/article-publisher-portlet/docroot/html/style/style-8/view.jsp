<%@page import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String queryValue = ParamUtil.getString(request, "queryValue", queryValuesArray[0]);
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.getAssetsById(request, 1, queryValue);
%>

<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		
		<div class="article-publisher-display-style-6" style = "  border: 1px solid #ccc;background: #eee;">
			<aui:layout>
				<aui:column columnWidth="70" >
				<%
					AssetEntryCache topAsset = assetCacheList.get(0);
				
					String topAssetTitle = topAsset.getTitle();
					
					String topAssetViewContentURL = ArticlePublisherUtil.getViewContentURL(request, topAsset);
					
					String topAssetSummaryContent = StringUtil.shorten(topAsset.getSummary(), 290);
					
					String topAssetSmallImagePath = topAsset.getSmallImagePath();
					
					
				%>
					<div class="top-asset">
						<span class="top-asset-img">
							<a href="<%=topAssetViewContentURL%>">
								<img class="small-img" align="left" src="<%= topAssetSmallImagePath %>" title="<%=topAssetTitle%>"
										onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'"
								/>
							</a>
						</span>
						
						<span class="top-asset-title">
						     <a href="<%=topAssetViewContentURL%>"><%= topAssetTitle %></a>
						</span>
						
						<c:if test='<%=Validator.isNotNull(topAssetSummaryContent) %>'>
							<span class="top-asset-summary"><%= topAssetSummaryContent%></span>  
						</c:if>
					</div>
				</aui:column>
				
				<aui:column columnWidth="30" >
					<div class="older-asset">
						<div class="older-asset-tittle">
							<a href="<%=ArticlePublisherUtil.getOlderAssetsURL(request)%>" title='<liferay-ui:message key="view-more"/>'>
								<liferay-ui:message key="older-assets"/>
							</a>
						</div>
						<ul>
						<%
						
						for(int i = 1;i < assetCacheList.size(); i ++ ){
								
							AssetEntryCache olderAsset = assetCacheList.get(i);
							
							String olderAssetTitle = StringUtil.shorten(olderAsset.getTitle(), 60);
							
							String olderAssetViewContentURL = ArticlePublisherUtil.getViewContentURL(request, olderAsset);
							
							String publishDate = dateFormat.format(olderAsset.getPublishDate());
						%>
								<li>						
									<a href="<%=olderAssetViewContentURL%>" title="<%= olderAsset.getTitle() %>"><%= olderAssetTitle %></a>
									
									<c:if test="<%=showPublishDate%>">
										<span class="publish-date">(<%=publishDate%>)</span>
									</c:if> 
								</li>
						<%
						}
						%>
						</ul>
					</div>
				</aui:column>
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