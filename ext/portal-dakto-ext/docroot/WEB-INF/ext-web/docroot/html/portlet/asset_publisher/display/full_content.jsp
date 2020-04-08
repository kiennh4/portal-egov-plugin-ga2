<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<style type="text/css">
	.asset-abstract{
		padding-bottom: 10px;
	}

	.asset-abstract .assetdesc-text{
		font-weight: bold !important;
		text-align: justify !important;
	}
	.asset-publish-date span{
		color: #2e567a;
    	font-size: 13px;
    	margin-bottom: 15px;
	}
	.social-panel{
		height: 25px;
	    margin-bottom: 15px;
	    margin-right: 10px;	
	}
	.asset-publish-date{
		float: left;
	}
	.social-icon{
		float: right;
		font-size: 13px !important;
	}
	
</style>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	
	List results = (List)request.getAttribute("view.jsp-results");
	
	int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
	Object obj = request.getAttribute("view.jsp-assetEntry");
	AssetEntry assetEntry = null;
	if(obj instanceof AssetEntry){
		AssetEntry currentAssetEntry = (AssetEntry)obj;
		request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, currentAssetEntry);
		AssetEntry incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(currentAssetEntry.getClassName(), currentAssetEntry.getClassPK());
		
		if (incrementAssetEntry != null) {
			assetEntry = incrementAssetEntry;
		}
	} else{
		AssetEntryCache assetEntryCache = (AssetEntryCache)obj;
		request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, assetEntryCache);
		AssetEntry incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(assetEntryCache.getClassName(), assetEntryCache.getClassPK());
		
		if (incrementAssetEntry != null) {
			assetEntry = incrementAssetEntry;
		}
	}
	AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
	
	String title = (String)request.getAttribute("view.jsp-title");
	
	boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();
	boolean print = ((Boolean)request.getAttribute("view.jsp-print")).booleanValue();
	
	request.setAttribute("view.jsp-showIconLabel", true);

	if (showContextLink) {
		if (PortalUtil.getPlidFromPortletId(assetRenderer.getGroupId(), assetRendererFactory.getPortletId()) == 0) {
			showContextLink = false;
		}
	}

	PortletURL viewFullContentURL = renderResponse.createRenderURL();

	viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
	viewFullContentURL.setParameter("type", assetRendererFactory.getType());

	if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
		if (assetRenderer.getGroupId() != scopeGroupId) {
			viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
		}

		viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
	}

	String viewFullContentURLString = viewFullContentURL.toString();

	viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);
	
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(assetEntry.getPublishDate());
	
	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:ss");
	
	String[] strDayOfWeek = {" ", "Chủ Nhật, ngày ", "Thứ Hai, ngày ", "Thứ Ba, ngày ", "Thứ Tư, ngày ",
							  "Thứ Năm, ngày ", "Thứ Sáu, ngày ", "Thứ Bẩy, ngày "
							};
	
	String assetPubLishDate = strDayOfWeek[dayOfWeek] + dateFormat.format(assetEntry.getPublishDate());
	
	List<AssetCategory> assetCategoryList = AssetCategoryLocalServiceUtil.getEntryCategories(assetEntry.getEntryId());
	
	if(assetCategoryList.size() > 0){
		
		AssetCategory firstCategory = assetCategoryList.get(0);
		
		renderResponse.setTitle(firstCategory.getName());
	}
	
	String summary = assetRenderer.getSummary(locale);
	
	if((summary.length() > 0) && abstractLength > 0){
		
		summary = StringUtil.shorten(assetRenderer.getSummary(locale), abstractLength);
	}
	
	long classPK = assetEntry.getClassPK();	
	
	String journalLanguageId = LanguageUtil.getLanguageId(request);
	
	//Dua vao classPK cua AssetEntry de lay tin bai chi tiet tuong ung luu trong bang journalarticle
	JournalArticleResource journalResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

	JournalArticleDisplay journalDisplay = JournalContentUtil.getDisplay(journalResource.getGroupId(),journalResource.getArticleId(), 
																		 null, null,journalLanguageId, themeDisplay);
	
	String smallImagePath = "";

	if (journalDisplay.isSmallImage()) {//Neu tin bai co anh nho mo ta thi method se tra ve duong dan tuong doi cua anh mo ta
		
		if(journalDisplay.getSmallImageId() > 0){
			
			smallImagePath = themeDisplay.getPathImage()+ "/journal/article?img_id="
							 + journalDisplay.getSmallImageId()
							 + "&t=" + WebServerServletTokenUtil.getToken(journalDisplay.getSmallImageId());
		}else{
			
			smallImagePath = journalDisplay.getSmallImageURL();
		}
	}
%>

<div class="asset_publisher_view_full_content">
	<c:if test="<%= showAssetTitle %>">
		<div class="asset_title">
			<span><%=title %></span>
		</div>
	</c:if>
	<div class="social-panel">
		<div class="asset-publish-date">
			<span><%=assetPubLishDate %></span>
		</div>
		<div class="social-icon">
			<span class="mail_icon">
				<a href="javascript:sendMail();">
					<img alt="" src="/html/portlet/asset_publisher/images/email.png">
					Email
				</a>
			</span>
			<a href="javascript:void(0)" id="decreaseText"> <b>A</b> <sup>-</sup></a>
			<a href="javascript:void(0)" id="increaseText"> <b>A</b> <sup>+</sup></a>
			<button class="article-audio" id="btnSpeak"></button>
		</div>
	</div>
	
	<c:if test="<%= displayAssetDescription %>">
		<div class="asset-abstract" >
			<div class="assetdesc">
				<span class="assetdesc-text">
					<%= summary%>
				</span>  
			</div>
		</div>
		
		<div style="clear: both;"></div>
	</c:if>
		
	<div class="asset-full-content <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %> <%= showAssetTitle ? "show-asset-title" : "no-title" %>">
	
		<div class="asset-content">

			<%
			String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_FULL_CONTENT);
	
			request.setAttribute(WebKeys.ASSET_RENDERER_FACTORY, assetRendererFactory);
			request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
			
			%>
			<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>" />
			
			<%
			JournalArticleResource journalArticleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());

			JournalArticleDisplay journalArticleDisplay = JournalContentUtil.getDisplay(journalArticleResource.getGroupId(),journalArticleResource.getArticleId(), 
																				 null, null,LanguageUtil.getLanguageId(request), themeDisplay);
			
			%>
			
			<c:if test="<%= themeDisplay.isSignedIn() %>">
				<liferay-portlet:renderURL portletName="<%= PortletKeys.JOURNAL %>" var="editURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
					<portlet:param name="struts_action" value="/journal/edit_article" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="originalRedirect" value="<%= currentURL %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(PortalUtil.getScopeGroupId(request)) %>" />
					<portlet:param name="articleId" value="<%= String.valueOf(journalArticleDisplay.getArticleId()) %>" />
					<portlet:param name="version" value="<%= String.valueOf(journalArticleDisplay.getVersion()) %>" />
				</liferay-portlet:renderURL>
	
				<liferay-ui:icon
					image="edit"
					message="edit-web-content"
					url="<%= editURL %>"
				/>
			</c:if>
			
			<c:if test="<%= enableFlags %>">
				<div class="asset-flag">
					<liferay-ui:flags
						className="<%= assetEntry.getClassName() %>"
						classPK="<%= assetEntry.getClassPK() %>"
						contentTitle="<%= assetRenderer.getTitle(locale) %>"
						reportedUserId="<%= assetRenderer.getUserId() %>"
					/>
				</div>
			</c:if>
	
			<c:if test="<%= enableRatings %>">
				<div class="asset-ratings">
					<liferay-ui:ratings
						className="<%= assetEntry.getClassName() %>"
						classPK="<%= assetEntry.getClassPK() %>"
					/>
				</div>
			</c:if>
	
			<c:if test="<%= showContextLink && !print && assetEntry.isVisible() %>">
				<div class="asset-more">
					<a href="<%= assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString) %>"><liferay-ui:message key="<%= assetRenderer.getViewInContextMessage() %>" /> &raquo;</a>
				</div>
			</c:if>
	
			<br />
	
			<c:if test="<%= enableRelatedAssets %>">
				<liferay-ui:asset-links
					assetEntryId="<%= assetEntry.getEntryId() %>"
				/>
			</c:if>
		</div>
		<c:if test="<%= show %>">
			<div class="asset-metadata">
				<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
			</div>
		</c:if>
	</div>
	
	<c:choose>
		<c:when test="<%= !showAssetTitle && ((assetEntryIndex + 1) < results.size()) %>">
			<div class="separator"><!-- --></div>
		</c:when>
		<c:when test="<%= (assetEntryIndex + 1) == results.size() %>">
			<div class="final-separator"><!-- --></div>
		</c:when>
	</c:choose>
	
	<c:if test="<%=displayRelatedAsset %>">
		<%@ include file="/html/portlet/asset_publisher/display/related_assets.jspf" %>
	</c:if>
	
</div>
<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.asset_publisher.display_full_content_jsp");
%>

<aui:script>
	function sendMail(){
		var link = window.location;
		var emailAddress = prompt("Please enter the recipients email address","");
		var emailSubject = "Check this out: "+ document.title;		
		window.location  = "mailto:"+emailAddress+"?Subject="+emailSubject+"&body="+link
	}
</aui:script>