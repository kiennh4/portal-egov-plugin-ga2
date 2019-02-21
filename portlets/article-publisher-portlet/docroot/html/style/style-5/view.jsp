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
<style>
	.jcarousel-skin-tango .asset-title a{
		font-size: 13px;
		font-family: "Open Sans",sans-serif;
	}
	
	#_article_publisher_WAR_articlepublisherportlet_INSTANCE_ocPjQXt4CuJN_jcarousel{
		left: -5px;
	}
</style>
<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		<div class="article-publisher-display-style-5">
		
			<div class="style-title">
				<span><%=styleTitle %></span>
			</div>
			
			<div class="style-content">
				<ul id="<portlet:namespace/>jcarousel" class="jcarousel-skin-tango">
				<%
				for(AssetEntryCache assetCache : assetCacheList){
					
					String assetTitle = StringUtil.shorten(assetCache.getTitle(), 40);
					
					String assetLink = ArticlePublisherUtil.getViewContentURL(request, assetCache);
					
					String assetImagePath = assetCache.getSmallImagePath();
				%>
					<li class="asset-entry">
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
							</a>
						</div>
						
						<div style="clear: both;"></div>
					</li>
				<%
				}
				%>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript">
		
			jQuery(document).ready(function() {
			    jQuery('#<portlet:namespace/>jcarousel').jcarousel({        
			    	scroll: 1,
			    	auto: 10,
			    	wrap: 'both'
			    });
			});
		
		</script>
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