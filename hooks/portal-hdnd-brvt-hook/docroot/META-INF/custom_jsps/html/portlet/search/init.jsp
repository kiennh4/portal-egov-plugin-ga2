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
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %><%@
page import="com.liferay.portal.kernel.search.Document" %><%@
page import="com.liferay.portal.kernel.search.FacetedSearcher" %><%@
page import="com.liferay.portal.kernel.search.Hits" %><%@
page import="com.liferay.portal.kernel.search.Indexer" %><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.search.OpenSearch" %><%@
page import="com.liferay.portal.kernel.search.OpenSearchUtil" %><%@
page import="com.liferay.portal.kernel.search.SearchContext" %><%@
page import="com.liferay.portal.kernel.search.SearchContextFactory" %><%@
page import="com.liferay.portal.kernel.search.Summary" %><%@
page import="com.liferay.portal.kernel.search.facet.AssetEntriesFacet" %><%@
page import="com.liferay.portal.kernel.search.facet.Facet" %><%@
page import="com.liferay.portal.kernel.search.facet.ScopeFacet" %><%@
page import="com.liferay.portal.kernel.search.facet.collector.FacetCollector" %><%@
page import="com.liferay.portal.kernel.search.facet.collector.TermCollector" %><%@
page import="com.liferay.portal.kernel.search.facet.config.FacetConfiguration" %><%@
page import="com.liferay.portal.kernel.search.facet.config.FacetConfigurationUtil" %><%@
page import="com.liferay.portal.kernel.search.facet.util.FacetFactoryUtil" %><%@
page import="com.liferay.portal.kernel.search.facet.util.RangeParserUtil" %><%@
page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %><%@
page import="com.liferay.portal.kernel.xml.Element" %><%@
page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %><%@
page import="com.liferay.portal.security.permission.comparator.ModelResourceComparator" %><%@
page import="com.liferay.portal.service.PortletLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil" %><%@
page import="com.liferay.portlet.asset.NoSuchCategoryException" %><%@
page import="com.liferay.portlet.asset.model.AssetCategory" %><%@
page import="com.liferay.portlet.asset.model.AssetEntry" %><%@
page import="com.liferay.portlet.asset.model.AssetRenderer" %><%@
page import="com.liferay.portlet.asset.model.AssetRendererFactory" %><%@
page import="com.liferay.portlet.asset.model.AssetVocabulary" %><%@
page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetVocabularyServiceUtil" %><%@
page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants" %><%@
page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %><%@
page import="com.liferay.util.PropertyComparator" %>

<%@ page import="java.util.Comparator" %><%@
page import="java.util.LinkedList" %>

<%
PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

//Cac bien config luu pham vi tim kiem(Ten cac bang duoc phep tim kiem)

//Journal Article
boolean searchOnJournalArticle = GetterUtil.getBoolean(portletPreferences.getValue("searchOnJournalArticle", null),true);

//Van Ban Phap Quy
boolean searchOnVBPQ = GetterUtil.getBoolean(portletPreferences.getValue("searchOnVBPQ", null),false);

//Thu tuc hanh chinh
boolean searchOnTTHC = GetterUtil.getBoolean(portletPreferences.getValue("searchOnTTHC", null),false);

//Thu tuc online (lien thong voi eGate)
boolean searchOnPublicDocType = GetterUtil.getBoolean(portletPreferences.getValue("searchOnPublicDocType", null),false);

//Du thao phap luat
boolean searchOnProposition = GetterUtil.getBoolean(portletPreferences.getValue("searchOnProposition", null),false);

//Hoi dap & tu van phap luat
boolean searchOnLegalFAQ = GetterUtil.getBoolean(portletPreferences.getValue("searchOnLegalFAQ", null),false);

//Document And MEdia file
boolean searchOnDLFileEntry = GetterUtil.getBoolean(portletPreferences.getValue("searchOnDLFileEntry", null));


boolean advancedConfiguration = GetterUtil.getBoolean(portletPreferences.getValue("advancedConfiguration", null));
boolean displayAssetTypeFacet = GetterUtil.getBoolean(portletPreferences.getValue("displayAssetTypeFacet", null), true);
boolean displayAssetTagsFacet = GetterUtil.getBoolean(portletPreferences.getValue("displayAssetTagsFacet", null), false);
boolean displayAssetCategoriesFacet = GetterUtil.getBoolean(portletPreferences.getValue("displayAssetCategoriesFacet", null), false);
boolean displayModifiedRangeFacet = GetterUtil.getBoolean(portletPreferences.getValue("displayModifiedRangeFacet", null), true);

boolean displayResultsInDocumentForm = GetterUtil.getBoolean(portletPreferences.getValue("displayResultsInDocumentForm", null));

if (!permissionChecker.isCompanyAdmin()) {
	displayResultsInDocumentForm = false;
}

boolean viewInContext = GetterUtil.getBoolean(portletPreferences.getValue("viewInContext", null));
boolean displayMainQuery = GetterUtil.getBoolean(portletPreferences.getValue("displayMainQuery", null));
boolean displayOpenSearchResults = GetterUtil.getBoolean(portletPreferences.getValue("displayOpenSearchResults", null));

String searchConfiguration = "";

if(advancedConfiguration){//Truong hop cau hinh tim kiem nang cao (manual)
	
	searchConfiguration = portletPreferences.getValue("searchConfiguration", StringPool.BLANK);

}else{//Truong hop cau hinh tim kiem co ban
	
	StringBundler sb = new StringBundler();

	sb.append("{facets: [");

	if (displayAssetTypeFacet) {
		//Append facets className
		sb.append("{className: 'com.liferay.portal.kernel.search.facet.AssetEntriesFacet',");
		
		//Append facets data
		sb.append(" data: {frequencyThreshold: 1, values: [");
		
		//Append DLFileEntry className
		if(searchOnDLFileEntry){
			sb.append("'com.liferay.portlet.documentlibrary.model.DLFileEntry',");
		}
		
		//Append VBPQ entry className
		if(searchOnVBPQ){
			sb.append("'com.portal_egov.portlet.vbpq.model.VBPQ_Entry',");
		}
		
		//Append TTHC entry className
		if(searchOnTTHC){
			sb.append("'com.portal_egov.portlet.tthc.model.TTHC_Entry',");
		}
		
		//Append Public Doctype className
		if(searchOnPublicDocType){
			sb.append("'com.portal_egov.portlet.egate.model.EGatePublicDocType',");
		}
		
		//Append Proposition entry className
		if(searchOnProposition){
			sb.append("'com.portal_egov.portlet.proposition_feedback.model.Proposition',");
		}
		
		//Append Legal FAQ className
		if(searchOnLegalFAQ){
			sb.append("'com.portal_egov.portlet.legal_faq.model.LegalFAQEntry',");
		}
		
		//Append journal article className (default)
		sb.append("'com.liferay.portlet.journal.model.JournalArticle'");
		
		//Append close facets data character
		sb.append("]},");
		
		//Append displayStyle,fieldName,...
		sb.append(" displayStyle: 'asset_entries', fieldName: 'entryClassName', label: 'asset-type', order: 'OrderHitsDesc', static: false, weight: 1.5},");
	}
	
	if (displayAssetTagsFacet) {
		sb.append("{className: 'com.liferay.portal.kernel.search.facet.MultiValueFacet', data: {displayStyle: 'list', frequencyThreshold: 1, maxTerms: 10, showAssetCount: true}, displayStyle: 'asset_tags', fieldName: 'assetTagNames', label: 'tag', order: 'OrderHitsDesc', static: false, weight: 1.4},");
	}

	if (displayAssetCategoriesFacet) {
		sb.append("{className: 'com.liferay.portal.kernel.search.facet.MultiValueFacet', data: {displayStyle: 'list', frequencyThreshold: 1, maxTerms: 10, showAssetCount: true}, displayStyle: 'asset_vocabulary.jsp', fieldName: 'assetCategoryNames', label: 'category', order: 'OrderHitsDesc', static: false, weight: 1.3},");
	}

	if (displayModifiedRangeFacet) {
		sb.append("{className: 'com.liferay.portal.kernel.search.facet.RangeFacet', data: {frequencyThreshold: 1, ranges: [{label:'modified', range:'[19700101000000 TO *]'}]}, displayStyle: 'modified', fieldName: 'modified', label: 'modified', order: 'OrderHitsDesc', static: false, weight: 1.1}");
	}

	sb.append("]}");

	searchConfiguration = sb.toString();
	
}

boolean dlLinkToViewURL = false;
boolean includeSystemPortlets = false;
%>

<%@ include file="/html/portlet/search/init-ext.jsp" %>

<%!

private String _buildAssetCategoryPath(AssetCategory assetCategory, Locale locale) throws Exception {
	List<AssetCategory> assetCategories = assetCategory.getAncestors();

	if (assetCategories.isEmpty()) {
		return assetCategory.getName();
	}

	Collections.reverse(assetCategories);

	StringBundler sb = new StringBundler(assetCategories.size() * 2 + 1);

	for (AssetCategory curAssetCategory : assetCategories) {
		sb.append(curAssetCategory.getTitle(locale));
		sb.append(" &raquo; ");
	}

	sb.append(assetCategory.getName());

	return sb.toString();
}

private String _checkViewURL(ThemeDisplay themeDisplay, String viewURL, String currentURL) {
	if (Validator.isNotNull(viewURL) && viewURL.startsWith(themeDisplay.getURLPortal())) {
		viewURL = HttpUtil.setParameter(viewURL, "redirect", currentURL);
	}

	return viewURL;
}

//Tao URL den trang xem chi tiet noi dung ket qua tim kiem
private PortletURL _getViewFullContentURL(HttpServletRequest request, ThemeDisplay themeDisplay, String portletId, Document document) throws Exception {
	
	long groupId = GetterUtil.getLong(document.get(Field.GROUP_ID));

	if (groupId == 0) {
		Layout layout = themeDisplay.getLayout();

		groupId = layout.getGroupId();
	}

	long scopeGroupId = GetterUtil.getLong(document.get(Field.SCOPE_GROUP_ID));

	if (scopeGroupId == 0) {
		scopeGroupId = themeDisplay.getScopeGroupId();
	}

	long plid = LayoutServiceUtil.getDefaultPlid(groupId, scopeGroupId, false, portletId);

	if (plid == 0) {
		plid = LayoutServiceUtil.getDefaultPlid(groupId, scopeGroupId, true, portletId);
	}

	if (plid == 0) {
		Layout layout = (Layout)request.getAttribute(WebKeys.LAYOUT);

		if (layout != null) {
			plid = layout.getPlid();
		}
	}
	
	//Tao URL den trang hien thi du lieu(co portlet hien thi tuong ung)
	PortletURL portletURL = PortletURLFactoryUtil.create(request, portletId, plid, PortletRequest.RENDER_PHASE);
	portletURL.setPortletMode(PortletMode.VIEW);

	return portletURL;
}

//Lay ten public-render-parameter cua portlet hien thi chi tiet noi dung KQ tim kiem (trong portlet.xml)
//assetClassName = className cua kieu du lieu (vd: com.portal_egov.portlet.vbpq.model.VBPQ_Entry)
private String _getAssetPPName(String assetClassName){
	
	String className = assetClassName.trim();
	
	if(Validator.equals(className, "com.portal_egov.portlet.vbpq.model.VBPQ_Entry")){
		
		return "vbpqEntryId";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.tthc.model.TTHC_Entry")){
		
		return "tthcEntryId";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.egate.model.EGatePublicDocType")){
		
		return "docTypeId";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.proposition_feedback.model.Proposition")){
		
		return "propositionId";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.legal_faq.model.LegalFAQEntry")){
		
		return "legalFAQEntryId";
		
	}else{
		return StringPool.BLANK;
	}
}


//Tao duong dan anh icon theo tung kieu du lieu khac nhau
private String _getDataTypeIconPath(String assetClassName){
	
	String className = assetClassName.trim();
	
	if(Validator.equals(className, "com.portal_egov.portlet.vbpq.model.VBPQ_Entry")){
		
		return "/html/portlet/search/images/data_type_icon/vbpq_icon.png";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.tthc.model.TTHC_Entry")){
		
		return "/html/portlet/search/images/data_type_icon/tthc_icon.png";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.egate.model.EGatePublicDocType")){
		
		return "/html/portlet/search/images/data_type_icon/egate_icon.png";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.proposition_feedback.model.Proposition")){
		
		return "/html/portlet/search/images/data_type_icon/proposition_icon.png";
		
	}else if(Validator.equals(className, "com.portal_egov.portlet.legal_faq.model.LegalFAQEntry")){
		
		return "/html/portlet/search/images/data_type_icon/legal_faq_icon.png";
		
	}else{
		return StringPool.BLANK;
	}
}
%>