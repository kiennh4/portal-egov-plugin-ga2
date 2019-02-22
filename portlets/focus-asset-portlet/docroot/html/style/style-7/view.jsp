<%@page
	import="com.bkav.portal.portlet.focus_asset.cache.AssetEntryCache"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-1/init.jsp"%>

<%
	List<AssetEntryCache> focusAssetList = FocusAssetUtil
			.getAssetList(request);
%>
<c:choose>
	<c:when test='<%=focusAssetList.size() > 0%>'>
		<div class="focus-asset-display-style-7">
			<div class="focus-asset-container">
				<div class="row1" id="hightlight-article">
					<%
						AssetEntryCache topAsset = focusAssetList.get(0);

								String topAssetTitle = StringUtil.shorten(
										topAsset.getTitle(), 200);

								String viewTopAssetContentURL = FocusAssetUtil
										.getViewContentURL(request, topAsset); //topAsset.getViewContentURL();

								String topAssetImgPath = topAsset.getSmallImagePath();
								focusAssetList.remove(topAsset);
					%>
					<div class="row1-content">
						<p class="article-thumbnail">
							<a href="<%=viewTopAssetContentURL%>" title="<%=topAssetTitle%>">
								<img alt="<%=topAssetTitle%>" src="<%=topAssetImgPath%>">
							</a>
						</p>
						<div class="header">
							<p class="article-title">
								<a href="<%=viewTopAssetContentURL%>" title="<%=topAssetTitle%>">
									<%=topAssetTitle%>
								</a>
							</p>
						</div>
					</div>
				</div>
				<div class="row2" id="slideShow">
					<%
						for (int i = 3; i < focusAssetList.size(); i++) {

							AssetEntryCache focusAsset = focusAssetList.get(i);

							long assetEntryId = focusAsset.getEntryId();

							String focusAssetTitle = StringUtil.shorten(
											focusAsset.getTitle(), 70);

							String viewAssetContentURL = FocusAssetUtil
											.getViewContentURL(request, focusAsset);

							String focusAssetImgPath = focusAsset
											.getSmallImagePath();
					%>
						<div class="top-asset-item">
							<div class="article-thumbnail">
								<a href="<%=viewAssetContentURL%>" title="<%=focusAssetTitle%>">
									<img alt="<%=focusAssetTitle%>" src="<%=focusAssetImgPath%>">
								</a>
							</div>
							<div class="header">
								<p class="article-title">
									<a href="<%=viewAssetContentURL%>" title="<%=focusAssetTitle%>">
										<%=focusAssetTitle%>
									</a>
								</p>
							</div>
						</div>
					<%
						}
					%>
				</div>
				<div class="row3">
					<%
						for (int i = 1; i < 3; i++) {

									AssetEntryCache focusAsset = focusAssetList.get(i);

									long assetEntryId = focusAsset.getEntryId();

									String focusAssetTitle = StringUtil.shorten(
											focusAsset.getTitle(), 70);

									String viewAssetContentURL = FocusAssetUtil
											.getViewContentURL(request, focusAsset);

									String focusAssetImgPath = focusAsset
											.getSmallImagePath();
					%>
						<div class="top-asset-item">
							<p class="article-thumbnail">
								<a href="<%=viewAssetContentURL%>" title="<%=focusAssetTitle%>">
									<img alt="<%=focusAssetTitle%>" src="<%=focusAssetImgPath%>">
								</a>
							</p>
							<div class="header">
								<p class="article-title">
									<a href="<%=viewAssetContentURL%>" title="<%=focusAssetTitle%>">
										<%=focusAssetTitle%>
									</a>
								</p>
							</div>
						</div>
					<%
						}
					%>
				</div>
				<div style="clear: both;"></div>
			</div>
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
<script>
	
</script>