<%@page import="com.bkav.portal.portlet.focus_asset.cache.AssetEntryCache"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-2/init.jsp"%>

<%

	List<AssetEntryCache> firstTabAssetList = FocusAssetUtil.getTabAssetList(request,FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS[0]);
%>

<div class="focus-asset-display-style-2">
	
	<div class="asset-summary-container">
		<div id="<portlet:namespace/>asset-summary-content" class="asset-summary-content">
			<div class="asset-image">
				<a href="javascript:;">
					<img id="<portlet:namespace/>focus-asset-img" 
					 	src="/focus-asset-portlet/images/default-asset-image.jpg"
					 	onerror="this.src='/thumbnail/default-image.jpg'"
					 />
				 </a>
				 			
				<div class="asset-title">
					<a href="javascript:;">
						<span id="<portlet:namespace/>asset-title"><liferay-ui:message key="asset-title"/></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="tab-content-container">
		<div id="<portlet:namespace/>tab-names-container" class="tab-names-container">
			<ul>
			<%
				for (int i = 0; i < FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS.length; i++) {
				
				String tabPrefix = FocusAssetConstants.STYLE_2_TAB_PARAM_PREFIXS[i];
				String tabName = preferences.getValue(tabPrefix + "TabTitle",StringPool.BLANK);
			%>
				<li data-tabPrefix="<%=tabPrefix%>">
					<a href="javascript:;"><%=tabName %></a>
				</li>
			<%
			}
			%>
			</ul>
			
			<div style="clear: both;"></div>
		</div>
		
		<div id="<portlet:namespace/>tab-assets-container" class="tab-assets-container">
			<liferay-util:include page="/html/style/style-2/tab-assets.jsp" servletContext="<%=getServletContext() %>"/>
		</div>
	</div>
	<div style="clear: both;"></div>	
</div>

<liferay-portlet:renderURL var="tabAssetsURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>" portletName="<%=PortalUtil.getPortletId(request) %>">
	<liferay-portlet:param name="jspPage" value="/html/style/style-2/tab-assets.jsp"/>
</liferay-portlet:renderURL>

<aui:script>
				
	var index = 1;
	
	var autoPushData = null;
		
	AUI().ready(function(A){
				
		if(autoPushData){
			clearInterval(autoPushData);
		}
		
		var firstAsset = A.one('#<portlet:namespace/>tab-assets-container .focus-asset a');
		
		<portlet:namespace />showAssetSummaryContent(firstAsset);
		
		var defaultAssetList = A.all('#<portlet:namespace/>tab-assets-container .focus-asset a');
				
		autoPushData = setInterval(function(){
				<portlet:namespace />autoPushAssetSummaryContent(defaultAssetList);
			},
			4000
		);
		
		var firstTab = A.one('#<portlet:namespace/>tab-names-container li');
		
		if(firstTab){
			firstTab.addClass('active-tab');
		}
		
		var assetTabs = A.all('#<portlet:namespace/>tab-names-container li');
		
		assetTabs.each(function(assetTab){
			
			assetTab.on('click',function(){
				A.all('#<portlet:namespace/>tab-names-container li').removeClass('active-tab');
				
				this.addClass('active-tab');
				
				var tabPrefix = this.getAttribute('data-tabPrefix');
				
				var tabAssetContainer = A.one('#<portlet:namespace/>tab-assets-container');
									
<!-- 				tabAssetContainer.plug(A.LoadingMask, { background: '#e8e8e8' }); -->
				
<!-- 				tabAssetContainer.loadingmask.toggle(); -->
							
				A.io.request('<%=tabAssetsURL%>',{   
					dataType: 'html',
					data:{
						tabParamPrefix: tabPrefix
					},
					on: {   
						success: function(){
							
							var responseData = this.get('responseData');
								
							tabAssetContainer.empty();
							
							tabAssetContainer.html(responseData);
															
							if(autoPushData){
								clearInterval(autoPushData);
							}
							
							var tabAssets = A.all('#<portlet:namespace/>tab-assets-container .focus-asset a');
							
							index = 0;
							
							var firstTabAsset = A.one('#<portlet:namespace/>tab-assets-container .focus-asset a');
							
							<portlet:namespace />showAssetSummaryContent(firstTabAsset);
							
							index ++;
							
							autoPushData = setInterval(function(){
									<portlet:namespace />autoPushAssetSummaryContent(tabAssets);
								},
								4000
							);
						},
						failure:function(){
							
							var loadDataFailMsgTpl 	= '<div class="portlet-msg-info">'
													+ 	'<liferay-ui:message key="load-data-failure"/>'
													+ '</div>';
							
							tabAssetContainer.html(loadDataFailMsgTpl);
						}
					} 
				});
			});
		});
		
		var assetList = A.all('#<portlet:namespace/>tab-assets-container .focus-asset a');
		
		assetList.each(function(focusAsset,assetIndex){
			
			focusAsset.on('mouseover',function(){
			
				A.all('#<portlet:namespace/>tab-assets-container .focus-asset').removeClass('selected');
			
				<portlet:namespace />showAssetSummaryContent(focusAsset);
								
				if(autoPushData){
					clearInterval(autoPushData);
				}
			});
									
			focusAsset.on('mouseout',function(){
				
				index = assetIndex + 1;
				
				autoPushData = setInterval(function(){
						<portlet:namespace />autoPushAssetSummaryContent(assetList);
					},
					4000
				);
			});
		});
	});
									
	Liferay.provide(
		window,
		'<portlet:namespace />autoPushAssetSummaryContent',
		function(assetList) {
		
			var A = AUI();
			
			var assetNodes = assetList._nodes;
							
			if(index >= assetNodes.length){
				index = 0;
			}
			
			var currentNode = assetNodes[index];
			
			var nodeItem = A.one('#<portlet:namespace/>tab-assets-container li[data-assetId="' + currentNode.getAttribute('data-assetId') + '"]');
			
			if(nodeItem){
				
				A.all('#<portlet:namespace/>tab-assets-container .focus-asset').removeClass('selected');
				
				nodeItem.addClass('selected');
			}
							
			var assetLinks = A.all('#<portlet:namespace/>asset-summary-content a');
			
			assetLinks.each(function(linkItem){
				linkItem.setAttribute('href',currentNode.getAttribute('href'));
			});
			
			var assetTitleHolder = A.one('#<portlet:namespace/>asset-title');
			
			assetTitleHolder.set('text',currentNode.getAttribute('data-assetTitle'));
							
			var assetImageHolder = A.one('#<portlet:namespace/>focus-asset-img');
			
			assetImageHolder.setAttribute('src',currentNode.getAttribute('data-imageSrcPath'));
			
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
			
			var assetLinks = A.all('#<portlet:namespace/>asset-summary-content a');
			
			assetLinks.each(function(linkItem){
				linkItem.setAttribute('href',focusAsset.getAttribute('href'));
			});
			
			var assetTitleHolder = A.one('#<portlet:namespace/>asset-title');
			
			assetTitleHolder.set('text',focusAsset.getAttribute('data-assetTitle'));
			assetTitleHolder.setAttribute('title',focusAsset.getAttribute('data-assetTitle'));
							
			var assetImageHolder = A.one('#<portlet:namespace/>focus-asset-img');
			
			assetImageHolder.setAttribute('src',focusAsset.getAttribute('data-imageSrcPath'));
		}
	);
</aui:script>

