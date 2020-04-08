<%@page import="com.bkav.portal.portlet.focus_asset.cache.AssetEntryCache"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-1/init.jsp"%>

<%
	List<AssetEntryCache> focusAssetList = FocusAssetUtil.getAssetList(request);
%>

<c:choose>
	<c:when test='<%=focusAssetList.size() > 0 %>'>
	
		<%
		AssetEntryCache topAsset = focusAssetList.get(0);
		
		String topAssetTitle = StringUtil.shorten(topAsset.getTitle(), 120);
		
		String viewTopAssetContentURL = FocusAssetUtil.getViewContentURL(request, topAsset); //topAsset.getViewContentURL();
		
		String topAssetImgPath = topAsset.getSmallImagePath();
		
		%>
		<div class="focus-asset-display-style-1">
			
			<div id="<portlet:namespace/>asset-summary-panel" class="asset-summary-panel">
				<div class="asset-image">
					<a href="<%=viewTopAssetContentURL%>">
						<img id="<portlet:namespace/>focus-asset-img" 
						 	src="<%=topAssetImgPath %>"
						 	onerror="this.src='/thumbnail/default-image.jpg'"/>
					 </a>
				</div>
				
				<div class="asset-title">
					<a href="<%=viewTopAssetContentURL%>">
						<span id="<portlet:namespace/>asset-title"><%=topAssetTitle %></span>
					</a>
				</div>
			</div>
			
			<div class="asset-list-panel">
				<div class="panel-header">
					<a href="javascript:;">
						<span class="header-title"><%=styleTitle %></span>
					</a>
				</div>
				
				<div id="<portlet:namespace/>asset-list"  class="panel-content">
					<ul>
					<%
						for(int i = 0; i < focusAssetList.size(); i++){
							
							AssetEntryCache focusAsset = focusAssetList.get(i);
											
							long assetEntryId = focusAsset.getEntryId();
							
							String focusAssetTitle = StringUtil.shorten(focusAsset.getTitle(), 90);
							
							String viewAssetContentURL = FocusAssetUtil.getViewContentURL(request, focusAsset);
							
							String focusAssetImgPath = focusAsset.getSmallImagePath();
					%>
							<li data-assetId = "<%=assetEntryId %>" class='focus-asset <%= (i == 0) ? "selected" : StringPool.BLANK%>'>
								<a  href="<%=viewAssetContentURL%>"
									title="<%=focusAsset.getTitle() %>"
									data-assetId = "<%=assetEntryId %>" 
									data-assetTitle="<%=focusAssetTitle%>" 
									data-imageSrcPath="<%=focusAssetImgPath%>"
									data-assetdesc = "<%=StringUtil.shorten(focusAsset.getDescription(), 200) %>"
								>
									<span><%=focusAssetTitle %></span>
								</a>
							</li>
					<%
						}
					%>
					</ul>
				</div>
			</div>
			<div style="clear:both;"></div>
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



<aui:script>
	AUI().ready(function(A){
		
		var autoPushData = null;
		
		var index = 1;
		
		var focusAssetList = A.all('#<portlet:namespace/>asset-list a');
		
		if(autoPushData){
			clearInterval(autoPushData);
		}
		
		autoPushData = setInterval(function(){
				<portlet:namespace />autoPushAssetSummaryContent(focusAssetList);
			},
			4000
		);
		
		focusAssetList.each(function(focusAsset,listIndex){
			
			focusAsset.on('mouseover',function(){
			
				A.all('#<portlet:namespace/>asset-list .focus-asset').removeClass('selected');
			
				<portlet:namespace />showAssetSummaryContent(focusAsset);
				
				if(autoPushData){
					clearInterval(autoPushData);
				}
			});
						
			focusAsset.on('mouseout',function(){
				
				index = listIndex + 1;
				
				autoPushData = setInterval(function(){
						<portlet:namespace />autoPushAssetSummaryContent(focusAssetList);
					},
					4000
				);
			});
		});
						
		Liferay.provide(
			window,
			'<portlet:namespace />autoPushAssetSummaryContent',
			function(focusAssetList) {
			
				var A = AUI();
				
				var assetNodes = focusAssetList._nodes;
								
				if(index >= assetNodes.length){
					index = 0;
				}
				
				var currentNode = assetNodes[index];
				
				var nodeItem = A.one('#<portlet:namespace/>asset-list li[data-assetId="' + currentNode.getAttribute('data-assetId') + '"]');
				
				if(nodeItem){
					
					A.all('#<portlet:namespace/>asset-list .focus-asset').removeClass('selected');
					
					nodeItem.addClass('selected');
				}
								
				var assetLinks = A.all('#<portlet:namespace/>asset-summary-panel a');
				
				assetLinks.each(function(linkItem){
					linkItem.setAttribute('href',currentNode.getAttribute('href'));
				});
				
				var assetTitleHolder = A.one('#<portlet:namespace/>asset-title');
				
				assetTitleHolder.set('text',currentNode.getAttribute('data-assetTitle'));
								
				var assetImageHolder = A.one('#<portlet:namespace/>focus-asset-img');
				
				assetImageHolder.setAttribute('src',currentNode.getAttribute('data-imageSrcPath'));
				
				var assetDescription = A.one('#<portlet:namespace/>asset-description');
				
				assetDescription.html(currentNode.getAttribute('data-assetdesc'));
				
				index ++;
			}
		);
				
		Liferay.provide(
			window,
			'<portlet:namespace />showAssetSummaryContent',
			function(focusAsset) {
				
				var A = AUI();
				
				var assetAncestor = focusAsset.ancestor('.focus-asset');
				
				if(assetAncestor){
					assetAncestor.addClass('selected');
				}
				
				var assetLinks = A.all('#<portlet:namespace/>asset-summary-panel a');
				
				assetLinks.each(function(linkItem){
					linkItem.setAttribute('href',focusAsset.getAttribute('href'));
				});
				
				var assetTitleHolder = A.one('#<portlet:namespace/>asset-title');
				
				assetTitleHolder.set('text',focusAsset.getAttribute('data-assetTitle'));
								
				var assetImageHolder = A.one('#<portlet:namespace/>focus-asset-img');
				
				assetImageHolder.setAttribute('src',focusAsset.getAttribute('data-imageSrcPath'));
				
				var assetDescription = A.one('#<portlet:namespace/>asset-description');
				
				assetDescription.text(focusAsset.getAttribute('data-assetdesc'));
			}
		);
	});
</aui:script>
	

