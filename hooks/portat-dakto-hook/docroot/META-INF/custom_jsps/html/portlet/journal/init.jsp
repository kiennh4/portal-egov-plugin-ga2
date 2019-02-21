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
<style type="text/css">

	.portlet-journal{
		color: #434343 !important;
	}

	.portlet-journal select,
	.portlet-journal textarea,
	.portlet-journal input[type="text"]{
	  display: inline-block;
	  padding: 6px 5px !important;
	  color: #555555;
	  vertical-align: middle;
	  -webkit-border-radius: 3px !important;
	     -moz-border-radius: 3px !important;
	          border-radius: 3px !important;
	  background-color: #ffffff !important;
	  border: 1px solid #cccccc ;
	  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
	     -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
	          box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
	  -webkit-transition: border linear 0.2s, box-shadow linear 0.2s !important;
	     -moz-transition: border linear 0.2s, box-shadow linear 0.2s !important;
	       -o-transition: border linear 0.2s, box-shadow linear 0.2s !important;
	          transition: border linear 0.2s, box-shadow linear 0.2s !important;
	}
		
	.portlet-journal select:focus,
	.portlet-journal textarea:focus,
	.portlet-journal input[type="text"]:focus{
	  border-color: rgba(82, 168, 236, 0.8) !important;
	  outline: 0;
	  outline: thin dotted \9;
	  /* IE6-9 */
	
	  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	     -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	          box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	}
	
	.portlet-journal .cke_skin_kama .cke_focus{
		outline-color:rgba(82, 168, 236, 0.8) !important;
	}
		
	.portlet-journal .aui-tagselector-focused,
	.portlet-journal .aui-categoriesselector-focused{
		outline: none;
		border: none;
	}
			
	.portlet-journal .aui-categoriesselector .aui-textboxlistentry-holder li{
		margin: 5px !important;
	}
	
	.aui-tagselector-focused .aui-textboxlistentry-holder{
		background: #ffffff none !important;
		border-color: rgba(82, 168, 236, 0.8) !important;
	}
	
	.portlet-journal .aui-tagselector .lfr-tag-selector-input{
		background: 0  !important;
		padding: 0 !important;
		width: auto !important;
		border: none !important;
	}
		
	.portlet-journal .aui-tagselector input[type="text"]{
		border: none !important;
		padding: 6px 5px !important;
		box-shadow: none;
	}
			
	.portlet-journal .aui-tagselector input[type="text"]:hover{
		border: none !important;
		box-shadow: none;
	}
	
	.portlet-journal .aui-textboxlist-content .aui-field-input-text{
		border-width: 0 !important;
		outline-width: 0 !important;
	}
	
</style>


<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portal.NoSuchLayoutException" %><%@
page import="com.liferay.portal.kernel.editor.EditorUtil" %><%@
page import="com.liferay.portal.kernel.xml.Document" %><%@
page import="com.liferay.portal.kernel.xml.Element" %><%@
page import="com.liferay.portal.kernel.xml.Node" %><%@
page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %><%@
page import="com.liferay.portal.kernel.xml.XPath" %><%@
page import="com.liferay.portal.util.LayoutLister" %><%@
page import="com.liferay.portal.util.LayoutView" %><%@
page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil" %><%@
page import="com.liferay.portlet.asset.NoSuchEntryException" %><%@
page import="com.liferay.portlet.asset.model.AssetEntry" %><%@
page import="com.liferay.portlet.asset.model.AssetRenderer" %><%@
page import="com.liferay.portlet.asset.model.AssetRendererFactory" %><%@
page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %><%@
page import="com.liferay.portlet.journal.ArticleContentException" %><%@
page import="com.liferay.portlet.journal.ArticleContentSizeException" %><%@
page import="com.liferay.portlet.journal.ArticleDisplayDateException" %><%@
page import="com.liferay.portlet.journal.ArticleExpirationDateException" %><%@
page import="com.liferay.portlet.journal.ArticleIdException" %><%@
page import="com.liferay.portlet.journal.ArticleSmallImageNameException" %><%@
page import="com.liferay.portlet.journal.ArticleSmallImageSizeException" %><%@
page import="com.liferay.portlet.journal.ArticleTitleException" %><%@
page import="com.liferay.portlet.journal.ArticleTypeException" %><%@
page import="com.liferay.portlet.journal.ArticleVersionException" %><%@
page import="com.liferay.portlet.journal.DuplicateArticleIdException" %><%@
page import="com.liferay.portlet.journal.DuplicateFeedIdException" %><%@
page import="com.liferay.portlet.journal.DuplicateStructureElementException" %><%@
page import="com.liferay.portlet.journal.DuplicateStructureIdException" %><%@
page import="com.liferay.portlet.journal.DuplicateTemplateIdException" %><%@
page import="com.liferay.portlet.journal.FeedContentFieldException" %><%@
page import="com.liferay.portlet.journal.FeedIdException" %><%@
page import="com.liferay.portlet.journal.FeedNameException" %><%@
page import="com.liferay.portlet.journal.FeedTargetLayoutFriendlyUrlException" %><%@
page import="com.liferay.portlet.journal.FeedTargetPortletIdException" %><%@
page import="com.liferay.portlet.journal.NoSuchArticleException" %><%@
page import="com.liferay.portlet.journal.NoSuchStructureException" %><%@
page import="com.liferay.portlet.journal.NoSuchTemplateException" %><%@
page import="com.liferay.portlet.journal.RequiredStructureException" %><%@
page import="com.liferay.portlet.journal.RequiredTemplateException" %><%@
page import="com.liferay.portlet.journal.StructureIdException" %><%@
page import="com.liferay.portlet.journal.StructureInheritanceException" %><%@
page import="com.liferay.portlet.journal.StructureNameException" %><%@
page import="com.liferay.portlet.journal.StructureXsdException" %><%@
page import="com.liferay.portlet.journal.TemplateIdException" %><%@
page import="com.liferay.portlet.journal.TemplateNameException" %><%@
page import="com.liferay.portlet.journal.TemplateSmallImageNameException" %><%@
page import="com.liferay.portlet.journal.TemplateSmallImageSizeException" %><%@
page import="com.liferay.portlet.journal.TemplateXslException" %><%@
page import="com.liferay.portlet.journal.action.EditArticleAction" %><%@
page import="com.liferay.portlet.journal.model.JournalArticle" %><%@
page import="com.liferay.portlet.journal.model.JournalArticleConstants" %><%@
page import="com.liferay.portlet.journal.model.JournalArticleDisplay" %><%@
page import="com.liferay.portlet.journal.model.JournalArticleResource" %><%@
page import="com.liferay.portlet.journal.model.JournalFeed" %><%@
page import="com.liferay.portlet.journal.model.JournalFeedConstants" %><%@
page import="com.liferay.portlet.journal.model.JournalStructure" %><%@
page import="com.liferay.portlet.journal.model.JournalTemplate" %><%@
page import="com.liferay.portlet.journal.model.JournalTemplateConstants" %><%@
page import="com.liferay.portlet.journal.model.impl.JournalArticleImpl" %><%@
page import="com.liferay.portlet.journal.search.ArticleDisplayTerms" %><%@
page import="com.liferay.portlet.journal.search.ArticleSearch" %><%@
page import="com.liferay.portlet.journal.search.ArticleSearchTerms" %><%@
page import="com.liferay.portlet.journal.search.FeedDisplayTerms" %><%@
page import="com.liferay.portlet.journal.search.FeedSearch" %><%@
page import="com.liferay.portlet.journal.search.FeedSearchTerms" %><%@
page import="com.liferay.portlet.journal.search.StructureDisplayTerms" %><%@
page import="com.liferay.portlet.journal.search.StructureSearch" %><%@
page import="com.liferay.portlet.journal.search.StructureSearchTerms" %><%@
page import="com.liferay.portlet.journal.search.TemplateDisplayTerms" %><%@
page import="com.liferay.portlet.journal.search.TemplateSearch" %><%@
page import="com.liferay.portlet.journal.search.TemplateSearchTerms" %><%@
page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalFeedLocalServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalStructureServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalTemplateServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.permission.JournalArticlePermission" %><%@
page import="com.liferay.portlet.journal.service.permission.JournalFeedPermission" %><%@
page import="com.liferay.portlet.journal.service.permission.JournalPermission" %><%@
page import="com.liferay.portlet.journal.service.permission.JournalStructurePermission" %><%@
page import="com.liferay.portlet.journal.service.permission.JournalTemplatePermission" %><%@
page import="com.liferay.portlet.journal.util.JournalUtil" %><%@
page import="com.liferay.portlet.journalcontent.util.JournalContentUtil" %><%@
page import="com.liferay.util.RSSUtil" %>

<%@ page import="java.net.URLDecoder" %>

<%
PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);

Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>