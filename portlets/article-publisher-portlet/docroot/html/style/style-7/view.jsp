<%@page import="com.bkav.portal.portlet.article_publisher.cache.AssetEntryCache"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<AssetEntryCache> assetCacheList = ArticlePublisherUtil.getAssetList(request,0);
%>

<c:choose>
	<c:when test='<%=assetCacheList.size() > 0 %>'>
		<div class="article-publisher-display-style-7" id="articlePubliserStyle7">
			<ul id="<portlet:namespace/>jcarousel" class="jcarousel-skin-tango">
			<%
			int assetIndex = 0;
			
			for(AssetEntryCache asset : assetCacheList){
				
				assetIndex ++;
				
				String assetTitle = StringUtil.shorten(asset.getTitle(), 50);


				String assetLink =  ArticlePublisherUtil.getViewContentURL(request, asset);

				
				String publishDate = dateFormat.format(asset.getPublishDate());
			%>
				<li class="asset-entry">

					
						<table>
							<tr>
								<td>
									<span class="asset-index"><%=assetIndex %></span>
								</td>
								<td>
									<a href="<%=assetLink%>" title="<%=asset.getTitle()%>">
										<span class="asset-title"><%=assetTitle %></span>
									</a>
								</td>
							</tr>
						</table>

<%-- 					<a href="<%=assetLink%>" title="<%=asset.getTitle()%>"> --%>
<%-- 						<span class="asset-index"><%=assetIndex %></span> --%>
<%-- 						<span class="asset-title"><%=assetTitle %></span> --%>
<!-- 						<span style="clear: both;"></span> -->
<!-- 					</a> -->

				</li>
			<%
			}
			%>
			</ul>
		</div>
		
		<script type="text/javascript">
		
			jQuery(document).ready(function() {
			    jQuery('#<portlet:namespace/>jcarousel').jcarousel({        
			    	vertical:true,
			    	scroll:1,
			    	auto:5,
			    	rtl: false,
			    	wrap:"circular",
			    	animation:1000,
			    	easing: 'linear',
			    	initCallback : initCallbackFx
			    });
			});
			//Init callback
			function initCallbackFx(carousel, obejctli,liindex,listate){
			    $("#<portlet:namespace/>jcarousel li").mouseenter(function(){
			        carousel.stopAuto();
			    }).mouseleave(function(){
			        carousel.startAuto();
			    });
			}
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