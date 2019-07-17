<%@page
	import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>
<%
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil
			.getAssetList(request, 0);
%>
<c:choose>
	<c:when test='<%=assetCacheList.size() > 0%>'>
		<div class="article-publisher-display-style-10">
			<%
				for (AssetEntryCache assetCache : assetCacheList) {

							String assetTitle = StringUtil.shorten(
									assetCache.getTitle(), 120);
							String assetSumary = ArticlePublisherUtil.getContentSummary(request, 
									assetCache.getClassPK(), 130);

							String assetLink = ArticlePublisherUtil
									.getViewContentURL(request, assetCache);
							String assetImage = ArticlePublisherUtil
									.getSmallImagePath(request,
											assetCache.getClassPK());
							String publishDate = dateFormat.format(assetCache
									.getPublishDate());
			%>
						<div class="style-asset">
							<div class="asset-img">
								<a href="<%=assetLink%>" class="">
									<img alt="<%=assetTitle%>" src="<%=assetImage%>"
									 onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'">
								</a>
							</div>
							<div class="asset-content">
								<div class="asset-title">
									<a href="<%=assetLink %>">
										<h6><%=assetTitle %></h6>
									</a>
								</div>
								<div class="asset-sumary">
									<p><%=assetSumary %></p>
								</div>
							</div>
							<div class="border-footer"></div>
						</div>
			<%
				}
			%>
		</div>
	</c:when>

	<c:otherwise>
		<%
			renderRequest.setAttribute(
							WebKeys.PORTLET_CONFIGURATOR_VISIBILITY,
							Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%=portletDisplay.getURLConfiguration()%>"
				label="no-asset-found"
				onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>