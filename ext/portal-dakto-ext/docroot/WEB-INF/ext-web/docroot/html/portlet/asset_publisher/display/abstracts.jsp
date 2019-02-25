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

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource"%>

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%

	List results = (List)request.getAttribute("view.jsp-results");
	
	int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
	
	AssetEntryCache assetEntry = (AssetEntryCache)request.getAttribute("view.jsp-assetEntry");
	AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
	
	boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();
	
	request.setAttribute("view.jsp-showIconLabel", true);
	
	String title = (String)request.getAttribute("view.jsp-title");
	
	if (Validator.isNull(title)) {
		title = assetRenderer.getTitle(locale);
	}
	
	PortletURL viewFullContentURL = renderResponse.createRenderURL();
	
	viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
	viewFullContentURL.setParameter("assetEntryId", String.valueOf(assetEntry.getEntryId()));
	viewFullContentURL.setParameter("type", assetRendererFactory.getType());
	
	if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
		if (assetRenderer.getGroupId() != scopeGroupId) {
			viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
		}
	
		viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
	}
	
	String summary = assetRenderer.getSummary(locale);
	
	if((summary.length() > 0) && abstractLength > 0){
		
		summary = StringUtil.shorten(assetRenderer.getSummary(locale), abstractLength);
	}
	
	String viewURL = null;
	
	if (viewInContext) {
		String viewFullContentURLString = viewFullContentURL.toString();
	
		viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);
	
		viewURL = assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString);
	
		//viewURL = HttpUtil.setParameter(viewURL, "redirect", currentURL);
	}
	else {
		viewURL = viewFullContentURL.toString();
	}
	
	if (Validator.isNull(viewURL)) {
		viewURL = viewFullContentURL.toString();
	}
	
	String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

	/*
	 * Hook by HungDX 08/08/2012
	 * Noi dung :- Hien thi truc tiep noi dung mo ta ngan cua tin bai,ko goi qua file abstract cua portlet Journal
	 *			 - Sua lai giao dien hien thi 	
	 */
	long classPK = assetEntry.getClassPK();	
	
	String smallImagePath = "";
	
	String languageId = LanguageUtil.getLanguageId(request);
	//Dua vao classPK cua AssetEntry de lay tin bai chi tiet tuong ung luu trong bang journalarticle
	JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(classPK);

	JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(),articleResource.getArticleId(), 
																		 null, null,languageId, themeDisplay);
	
	
	if (articleDisplay.isSmallImage()) {//Neu tin bai co anh nho mo ta thi method se tra ve duong dan tuong doi cua anh mo ta
		
		long smallImageId = articleDisplay.getSmallImageId();
		
		
		if(smallImageId <= 0){
			
			String smallImageURL = articleDisplay.getSmallImageURL();
			
			if(Validator.isNotNull(smallImageURL)){
				smallImagePath = smallImageURL;
			}
		}else{
			
			Image smallImage = ImageLocalServiceUtil.fetchImage(smallImageId);
		
			if(smallImage != null){
					
				String smallImageIdStr = String.valueOf(smallImageId);
				
				String[] smallImageIdStrSplitedArr = smallImageIdStr.split("(?<=\\G.{2})");
				
				StringBuilder stringBuilder = new StringBuilder();
				
				stringBuilder.append("/thumbnail/");
				
				stringBuilder.append("400x300");
				/* if(assetEntryIndex==0){
					stringBuilder.append("300x180");
				}else{
					stringBuilder.append("180x110");
				} */
				
				stringBuilder.append(StringPool.SLASH);
				
				for (int i = 0; i < smallImageIdStrSplitedArr.length; i++){
					
					stringBuilder.append(smallImageIdStrSplitedArr[i]);
					stringBuilder.append(StringPool.SLASH);
				}
				
				stringBuilder.append(smallImageId + "." + smallImage.getType());
				
				smallImagePath = stringBuilder.toString();
					
// 					smallImagePath = themeDisplay.getPathImage() + "/journal/article?img_id="
// 									 + articleDisplay.getSmallImageId()
// 									 + "&t=" + WebServerServletTokenUtil.getToken(articleDisplay.getSmallImageId());
			}
		}
	}
	
	String assetCategoryName = "";
	
	List<AssetCategory> assetCategoryList = AssetCategoryLocalServiceUtil.getEntryCategories(assetEntry.getEntryId());
	
	if(assetCategoryList.size() > 0){
		AssetCategory assetCategory = assetCategoryList.get(0);
		assetCategoryName = assetCategory.getName();
	}
	
	SimpleDateFormat sdFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	String assetPublishDate = sdFormat.format(assetEntry.getPublishDate());
%>
<c:if test="<%= show %>">
	<div class="asset-abstract<%= (assetEntryIndex==0) ? "-first" : StringPool.BLANK %> <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %> ">
		<div class="asset-content">   
		    <div style="clear: both;"></div>		
			<div class="assetdesc">
				<c:if test='<%=Validator.isNotNull(smallImagePath) %>'>	           				
					<div class="assetdesc-img">
						<a href="<%=viewURL%>">
							<img class="img-outsite" align="left" src="<%= smallImagePath %>" width="180" height="100" 
								 onerror="this.src='/html/portlet/asset_publisher/images/default_image.jpg'"
							/>
						</a>
					</div>
				</c:if>
				<div class="assetdesc-content">
					<div class="asset_title">
				       	<a href="<%=viewURL%>"><%= HtmlUtil.escape(title) %> </a>
				    </div>
					<div class="asset-info">
				    	<span class="asset-category-name"><%=assetCategoryName %></span>
				    	|
				    	<span class="asset-publish-date"><%=assetPublishDate %></span>
				    </div>
				    <div style = "text-align: justify;" class="asset-sumary">
						<%=StringUtil.shorten(HtmlUtil.extractText(summary), 240)%>
					</div>
				</div>  
				<span style="display: block; clear: both;"></span>           				
			</div>
			
			<div style="clear: both;"></div>
		</div>	

		<div class="asset-metadata">
			<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
		</div>
		
		 <c:if test="<%= (assetEntryIndex + 1) != delta %>">
		   	  <div class="border-footer" style="border-top: 1px solid #E2E1E1;clear: both;height: 1px;margin-top: 20px;padding-bottom: 5px;width: 100%;"></div>
		 </c:if>
	</div>
</c:if>