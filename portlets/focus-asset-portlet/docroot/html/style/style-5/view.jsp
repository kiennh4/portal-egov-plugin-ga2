<%@page import="sun.misc.FpUtils"%>
<%@page
	import="com.bkav.portal.portlet.focus_asset.cache.AssetEntryCache"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-5/init.jsp"%>


<div class="focus-asset-display-style-5">
	<%
		for(int i=0; i < FocusAssetConstants.STYLE_5_TAB_PARAM_PREFIXS.length; i++){
			String elementName = FocusAssetConstants.STYLE_5_TAB_PARAM_PREFIXS[i];
			String tabPrefix = FocusAssetConstants.STYLE_5_TAB_PARAM_PREFIXS[i] + "TabTitle";
			String tabName = preferences.getValue(tabPrefix, StringPool.BLANK);
			String url = FocusAssetUtil.getOlderAssetsURL(request,elementName);
	%>
		<section class="article-slidebar <%= elementName%>">
			<div class="header-topper">
				<div class="header-title-inner">
					<div class="header-icon">
						<div class="header-title">
						<a href="<%=url %>">
							<span class="box-icon"><img alt="" src="/article-publisher-portlet/icon.png"></span>
							<span class="title-text"><%= tabName %></span>
						</a>
						</div>
					</div>
				</div>
			</div>
			<div class="list-news">
			<%
				List<AssetEntryCache> assetCacheList = FocusAssetUtil.getTabAssetList(request, elementName);
				String topAssetSummary = "";
				String topAssetImgPath = "";
				
				for(int index = 0; index < assetCacheList.size(); index ++){
					
					AssetEntryCache assetCache = assetCacheList.get(index);
					
					String assetTitle = StringUtil.shorten(assetCache.getTitle(), 120);
					
					String assetLink = FocusAssetUtil.getViewContentURL(request, assetCache); //assetCache.getViewContentURL();
					
					String publishDate = dateFormat.format(assetCache.getPublishDate());
					
					if(index == 0){
						topAssetSummary = FocusAssetUtil.getContentSummary(request, assetCache.getClassPK(), 500);
						topAssetImgPath = assetCache.getSmallImagePath();
					}
				%>
					<c:choose>
						<c:when test='<%=(index == 0)%>'>
							<div class="top-asset">
								<span class="asset-title">
									<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
										<%=assetTitle %>
									</a>
								</span>
								
								<div class="asset-summary">
									<c:if test='<%=Validator.isNotNull(topAssetImgPath) %>'>
										<span class="asset-image">
											<a href="<%=assetLink%>">
												<img class="small-img" align="left" 
													src="<%= topAssetImgPath %>" 
													title="<%=assetCache.getTitle()%>"
													onerror="this.src='/thumbnail/default-image.jpg'"	
												/>
											</a>
										</span>
									</c:if>
									<span class="asset-title-mobile">
										<a href="<%=assetLink%>" title="<%=assetCache.getTitle()%>">
											<%=assetTitle %>
										</a>
									</span>
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
							</div>
						</c:otherwise>
					</c:choose>
				<%
				}
				%>
			</div>
		</section>
	<%
		} 
	%>
	<div style="clear: both;"></div>
</div>



