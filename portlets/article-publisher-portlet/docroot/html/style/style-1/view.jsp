<%@page import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.getAssetList(request,1);
%>

<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		
		<div class="article-publisher-display-style-1" id="articlePubliserStyle1">
		
		<%
		String topAssetSummary = "";
		String topAssetImgPath = "";
		
		for(int index = 0; index < assetCacheList.size(); index ++){
			
			AssetEntryCache assetCache = assetCacheList.get(index);
			
			String assetTitle = StringUtil.shorten(assetCache.getTitle(), 120);
			
			String assetLink = ArticlePublisherUtil.getViewContentURL(request, assetCache); //assetCache.getViewContentURL();
			
			String publishDate = dateFormat.format(assetCache.getPublishDate());
			
			if(index == 0){
				topAssetSummary = assetCache.getSummary();
				topAssetImgPath = assetCache.getSmallImagePath();
			}
		%>
			<c:choose>
				<c:when test='<%=(index == 0)%>'>
					<div class="top-asset">
						<div class="asset-title">
							<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
								<%=assetTitle %>
							</a>
							<c:if test="<%=showPublishDate %>">
								<span class="publish-date"><%=publishDate %></span>
							</c:if>
						</div>
						
						<div class="asset-summary">
							<c:if test='<%=Validator.isNotNull(topAssetImgPath) %>'>
								<span class="asset-image">
									<a href="<%=assetLink%>">
										<img class="small-img" align="left" 
											src="<%= topAssetImgPath %>" 
											title="<%=assetCache.getTitle()%>"
											onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'"	
										/>
									</a>
								</span>
							</c:if>
							<div class="asset-title-mobile">
								<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
									<%=assetTitle %>
								</a>
								<c:if test="<%=showPublishDate %>">
									<span class="publish-date"><%=publishDate %></span>
								</c:if>
							</div>
							<span class="summary-content"><%=topAssetSummary %></span>
						</div>
						
						<div style="clear: both;"></div>
					</div>
				</c:when>
				
				<c:otherwise>
					<div class="older-asset">
						<span class="asset-title">
							<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>"><%=assetTitle %></a>
						</span>
						<c:if test='<%=showPublishDate %>'>
							<span class="publish-date">(<%=publishDate %>)</span>
						</c:if>
					</div>
				</c:otherwise>
			</c:choose>
		<%
		}
		%>
		</div>
	</c:when>
	
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>"
				label="no-asset-found" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>