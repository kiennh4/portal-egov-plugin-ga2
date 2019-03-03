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
		<div class="article-publisher-display-style-9">
			<c:if test="<%=Validator.isNotNull(styleTitle)%>">
				<div class="style-title">
					<h3><%=styleTitle%></h3>
					<div class="sperator"></div>
				</div>
			</c:if>
			<%
				int size = assetCacheList.size();
				double ratio = (double)100/size;
				String style = "width:" + String.valueOf(ratio) + "%";
				for (AssetEntryCache assetCache : assetCacheList) {

					String assetTitle = StringUtil.shorten(
									assetCache.getTitle(), 90);
					String assetSumary = ArticlePublisherUtil.getContentSummary(request, assetCache.getClassPK(), 110);

					String assetLink = ArticlePublisherUtil
									.getViewContentURL(request, assetCache);
					String assetImage = ArticlePublisherUtil
									.getSmallImagePath(request,
											assetCache.getClassPK());
					String publishDate = dateFormat.format(assetCache
									.getPublishDate());
			%>
					<div class="asset-entry" style="<%=style%>">
						<a href="<%=assetLink %>" title="<%= assetTitle %>" class="asset-title"> 
							<h3><%=assetTitle %></h3>
						</a>
						<a href="<%=assetLink %>" title="<%=assetTitle%>" class="asset-thumb">
							<img alt="<%=assetTitle %>" src="<%=assetImage%>" onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'">
						</a>
						<h6>
							<%=assetSumary %>
						</h6>
					</div>
			<%
				}
			%>
			<div style="clear: both;"></div>
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