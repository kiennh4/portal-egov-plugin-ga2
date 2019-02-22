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

		<%
			AssetEntryCache topAsset = focusAssetList.get(0);

			String topAssetTitle = StringUtil.shorten(topAsset.getTitle(), 100);

			String viewTopAssetContentURL = FocusAssetUtil.getViewContentURL(request, topAsset); //topAsset.getViewContentURL();

			String topAssetImgPath = topAsset.getSmallImagePath();
			focusAssetList.remove(topAsset);
		%>
		<div class="focus-asset-display-style-6">
			<div class="row-1">
				<div class="top-asset-1">
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
				<%
					AssetEntryCache topAsset1 = focusAssetList.get(0);

					String topAssetTitle1 = StringUtil.shorten(topAsset1.getTitle(), 100);

					String viewTopAssetContentURL1 = FocusAssetUtil.getViewContentURL(request, topAsset1); //topAsset.getViewContentURL();

					String topAssetImgPath1 = topAsset1.getSmallImagePath();
					focusAssetList.remove(topAsset1);
				%>
				<div class="top-asset-2">
					<p class="article-thumbnail">
						<a href="<%=viewTopAssetContentURL1%>" title="<%=topAssetTitle1%>">
							<img alt="<%=topAssetTitle1%>" src="<%=topAssetImgPath1%>">
						</a>
					</p>
					<div class="header">
						<p class="article-title">
							<a href="<%=viewTopAssetContentURL1%>" title="<%=topAssetTitle1%>">
								<%=topAssetTitle1%>
							</a>
						</p>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="row-2">
				<%
					for (int i = 0; i < focusAssetList.size(); i++) {

							AssetEntryCache focusAsset = focusAssetList.get(i);

							long assetEntryId = focusAsset.getEntryId();

							String focusAssetTitle = StringUtil.shorten(
										focusAsset.getTitle(), 90);

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
			<%-- <div class="hight-light">
				<a href="<%=viewTopAssetContentURL%>" class="article-hightlight">
					<img alt="<%=topAssetTitle%>" src="<%=topAssetImgPath%>">
					<h2 class="hightlight-title">
						<%=topAssetTitle%>
					</h2> 
				</a>
			</div>
			<div class="list-article">
				<div class="forcus-asset-entries">
					<ul class="list_article_pkg">
						<%
							for (int i = 0; i < focusAssetList.size(); i++) {

										AssetEntryCache focusAsset = focusAssetList.get(i);

										long assetEntryId = focusAsset.getEntryId();

										String focusAssetTitle = StringUtil.shorten(
												focusAsset.getTitle(), 90);

										String viewAssetContentURL = FocusAssetUtil
												.getViewContentURL(request, focusAsset);

										String focusAssetImgPath = focusAsset
												.getSmallImagePath();
						%>
						<li class="pkg">
							<a href="<%=viewAssetContentURL%>" class="article-hightlight">
									<h2 class="hightlight-title">
										<%=topAssetTitle%>
									</h2> <img alt="<%=focusAssetTitle%>" src="<%=focusAssetImgPath%>">
							</a>
						</li>
						<%
							}
						%>
					</ul>

				</div>
			</div> --%>
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