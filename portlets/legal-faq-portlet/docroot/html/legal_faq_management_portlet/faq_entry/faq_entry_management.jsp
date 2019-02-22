<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.legal_faq.search.FAQEntrySearch"%>
<%@page import="com.portal_egov.portlet.legal_faq.comparator.FAQStatusComparator"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="com.portal_egov.portlet.legal_faq.permission.LegalFAQEntryPermission"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String portletId = PortalUtil.getPortletId(request);
	
	//Tu khoa tim kiem
	String searchKeyword = ParamUtil.getString(request, "searchKeyword",StringPool.BLANK);
	
	//Ket qua tim kiem FAQ Entry
	List<LegalFAQEntry> legalFAQEntryList = LegalFAQEntryLocalServiceUtil.findByGroup(scopeGroupId);
	
	String entryCommand = ParamUtil.getString(request, "entryCommand",StringPool.BLANK);
	
	int legalFAQEntryIndex = 0;
	
%>
<liferay-portlet:renderURL var="faqEntryAdminHomePageURL">
	<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp" />
	<liferay-portlet:param name="tabs1" value="FAQEntries"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="faqEntryUpdateFormURL">
	<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/faq_entry/faq_entry_update_form.jsp" />
</liferay-portlet:renderURL>

<div class="legal-faq-admin-toolbar">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="faq-entry-search-form">
			
				<div style="float: left;">
				
					<aui:button href="<%= faqEntryUpdateFormURL %>" value="add-new-question" />
					
					<c:if test="<%=LegalFAQEntryPermission.contains(permissionChecker, scopeGroupId, LegalFAQEntryPermission.PERMISSIONS)%>">
						<liferay-security:permissionsURL
							modelResource="<%=LegalFAQEntry.class.getName() %>"
							modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
							resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
							var="permissionsURL"
						/>
				
						<aui:button href="<%= permissionsURL %>" value="permissions" name="faqEntryPermissionBtn"/>
					</c:if>
				</div>
				
				<div style="float: right;">
					<aui:form name="faq_entry_search_form" method="post" action="<%=faqEntryAdminHomePageURL %>">
						
						<input type="text" id="<portlet:namespace/>faqEntrySearchInput" name="searchKeyword" value='<%= searchKeyword%>'/>		
						
						<aui:button type="submit" value="search"/>
						
						<aui:button type="button" value="show-all" href="<%=faqEntryAdminHomePageURL %>"/>
					</aui:form>	
				</div>
			</div>
		</div>
	</div>
</div>

<div class="faq_entry_list">
	
	<liferay-portlet:renderURL varImpl="faqAdminHomePageImplURL" var="">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp"/>
	</liferay-portlet:renderURL>
		
			
	<liferay-ui:search-container emptyResultsMessage="no-data"
		searchContainer="<%=new FAQEntrySearch(renderRequest,faqAdminHomePageImplURL)%>"
	>
		<%
			List<LegalFAQEntry> searchResultList = LegalFAQEntryLocalServiceUtil.findByKeyword(scopeGroupId, 0L, searchKeyword,
					-1,-1, searchContainer.getOrderByComparator());
		%>
		
		<liferay-ui:search-container-results results="<%=ListUtil.subList(searchResultList,searchContainer.getStart(), searchContainer.getEnd())%>" total="<%=searchResultList.size() %>" />			
		
		<liferay-ui:search-container-row className="LegalFAQEntry" keyProperty="entryId" modelVar="faqEntry"  escapedModel="<%=true %>">
			
			<%
				//So thu tu
				legalFAQEntryIndex ++;
				
				String faqCategoryName = "others";
				
				if(faqEntry.getCategoryId() > 0){
					
					LegalFAQCategory faqCategory = LegalFAQCategoryLocalServiceUtil.getCategory(faqEntry.getCategoryId() );
					
					if(faqCategory != null){
						faqCategoryName = faqCategory.getCategoryName();
					}
				}
			
				String status = "un-answer";
				
				if (faqEntry.getStatus() == 1){
					status = "answer";
				}
				
				StringBundler sb = new StringBundler();

				sb.append("javascript:");
				sb.append("showFAQPreviewDialog");
				sb.append("('");
				sb.append(faqEntry.getEntryId());
				sb.append("')");

				String	rowHREF = sb.toString();
			%>
																							
			<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(legalFAQEntryIndex) %>" href="<%=rowHREF %>"/>
								
			<liferay-ui:search-container-column-text name="ask-title" 
				value="<%=StringUtil.shorten(faqEntry.getAskTitle(), 60) %>" 
				orderable="<%=true %>"
				orderableProperty="ask-title"
				href="<%=rowHREF %>"
			/>
											
			<liferay-ui:search-container-column-text name="faq-category" 
				orderable="<%=true %>"
				orderableProperty="category-id"
				href="<%=rowHREF %>"
			>
				<liferay-ui:message key="<%=faqCategoryName%>"/>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text 
				name="Receive-date" 
				value="<%=dateFormat.format(faqEntry.getCreateDate())%>"
				orderable="<%=true %>"
				orderableProperty="create-date"
			/>
			
			<liferay-ui:search-container-column-text 
				name="Status"
				orderable="<%=true %>"
				orderableProperty="status"
			>
				<liferay-ui:message key="<%=status%>"/>
			</liferay-ui:search-container-column-text>
			
			<c:if test="<%=LegalFAQEntryPermission.contains(permissionChecker, scopeGroupId, LegalFAQEntryPermission.UPDATE)%>">
				<liferay-ui:search-container-column-text name="edit">	
					<liferay-portlet:renderURL var="updateEntryURL" >
						<liferay-portlet:param name="legalFAQEntryId" value="<%=String.valueOf(faqEntry.getEntryId())%>"/>
						<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/faq_entry/faq_entry_update_form.jsp" />
					</liferay-portlet:renderURL>													
					<liferay-ui:icon image="edit" message="reply" url="<%= updateEntryURL %>" />
				</liferay-ui:search-container-column-text>
			</c:if>
													
			<c:if test="<%=LegalFAQEntryPermission.contains(permissionChecker, scopeGroupId, LegalFAQEntryPermission.DELETE) %>">										
				<liferay-portlet:actionURL  name="deleteFAQEntry" var="deleteFAQEntryURL">
					<liferay-portlet:param name="legalFAQEntryId" value="<%=String.valueOf(faqEntry.getEntryId())%>"/>
					<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
				</liferay-portlet:actionURL>
				<liferay-ui:search-container-column-text name="delete">	
					<liferay-ui:icon-delete url="<%= deleteFAQEntryURL %>" />
				</liferay-ui:search-container-column-text>				
			</c:if>
			
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</div>

<aui:script>

	var A = AUI();
	
	AUI().ready('aui-base',function(A){
		
		var faqEntrySearchInput = A.one('#<portlet:namespace/>faqEntrySearchInput');
		
		if(faqEntrySearchInput){
			faqEntrySearchInput.focus();
		}
	});

	Liferay.provide(
		window,
		'showFAQPreviewDialog',
		function(legalFAQEntryId) {
			
			A.DialogManager.hideAll();
								
			var faqPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(faqPreviewRenderURL){
				
				faqPreviewRenderURL.setPortletId('<%=portletId %>');
				faqPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				faqPreviewRenderURL.setParameter('jspPage', '/html/legal_faq_management_portlet/faq_entry_preview.jsp');
				faqPreviewRenderURL.setParameter('legalFAQEntryId', legalFAQEntryId);
				faqPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '#<portlet:namespace/>faqEntryPermissionBtn',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true
					},
					id: '<portlet:namespace/>faqPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "faq-preview-content") %>',
					uri: faqPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
	
	Liferay.provide(
		window,
		'showFAQUpdateForm',
		function(legalFAQEntryId) {
											
			var faqUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(faqUpdateFormURL){
				
				faqUpdateFormURL.setPortletId('<%=portletId %>');
				faqUpdateFormURL.setWindowState('<%=LiferayWindowState.MAXIMIZED.toString() %>');
				faqUpdateFormURL.setParameter('jspPage', '/html/legal_faq_management_portlet/faq_entry/faq_entry_update_form.jsp');
				faqUpdateFormURL.setParameter('legalFAQEntryId', legalFAQEntryId);
				faqUpdateFormURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
			
			window.location = faqUpdateFormURL;					
		},
		['aui-base']
	);
</aui:script>