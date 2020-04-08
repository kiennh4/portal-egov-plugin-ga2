<%@page import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.getAssetList(request,numbersOfEntriesDisplay);
	int counter = 0;
%>
<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		<div class="article-publisher-display-style-7" id="articlePublisher7">
		
			<div class="style-title">
				<span><%=styleTitle %></span>
			</div>
			<div class="list-news">
  				<ul id="light-slider1" class="light-slider">
				<%
				for(AssetEntryCache assetCache : assetCacheList){
					
					String assetTitle = StringUtil.shorten(assetCache.getTitle(), 60);
					
					String assetLink = ArticlePublisherUtil.getViewContentURL(request, assetCache);
					
					String assetImagePath = assetCache.getSmallImagePath();
					
					counter = counter + 1;
				%><li>
					<div class="asset-entry <%= counter == 1 ? "first" : ""%>">
						<div class="asset-image">
							<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
								<img class="small-img" align="left" 
									src="<%= assetImagePath %>" 
									title="<%=assetCache.getTitle()%>"
									onerror="this.src='/thumbnail/default-image.jpg'"	
								/>
							</a>
						</div>
						
						<div class="asset-title">
							<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
								<%= assetTitle %>
							</a>
						</div>
						<div style="clear: both;"></div>
					</div>
					</li>
				<%
				}
				%>
				</ul>
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
<script src="/article-publisher-portlet/js/lightslider.js"></script>
<script>
$("#light-slider1").lightSlider({
    item: 4,
    loop: true,
    auto: true,
    slideMargin: 20,
    pager: false,
    easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
    pauseOnHover: true,
    responsive: [{
        breakpoint: 800,
        settings: {
            item: 1,
            slideMove: 1
        }
    }]
});
</script>