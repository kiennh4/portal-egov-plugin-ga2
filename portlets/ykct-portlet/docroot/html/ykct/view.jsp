<%@page import="com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Entry"%>
<%@page import="com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Category"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/ykct/init.jsp"%>
<%
boolean ykctAdvanceSearch = false;

String ykctSearchKeyword = ParamUtil.getString(request, "ykctSearchKeyword",StringPool.BLANK);

List<YKCT_Category> ykctCategoryList = YKCT_CategoryLocalServiceUtil.findByGroup(groupId);

long categoryId = ParamUtil.getLong(request, "categoryId",0L);

int ykctIndex = 0;
%>
<liferay-portlet:renderURL var="ykctViewPageURL">
	<liferay-portlet:param name="jspPage" value="/html/ykct/view.jsp" />
</liferay-portlet:renderURL>

<div class="ykct_search_form_wrapper">
	<div class="ykct_search_form_left_content">
		<div class="title"><liferay-ui:message key="YKCT"/></div>
	</div>
	
	<div class="ykct_search_form_center_content">
		<div class="ykct_search_form">
			<aui:form name="ykct_search_form" method="post" action="<%=ykctViewPageURL %>">
				<div id="<portlet:namespace/>ykctSearchFormHelp" class="ykct_search_form_help_content" >
					<span class ="search_form_title"><liferay-ui:message key="legal-document-search-form"/></span>
					<br/>
					<span class ="help_content">
						<liferay-ui:message key="please-enter-document-name-or-keyword-on-search-content-below"/>
						<br/>
						<liferay-ui:message key="select-advance-search-for-more-search-options"/>
					</span>
				</div>
				
				<div class="lfr-form-row">
					<aui:input 	type="text" label=""
								name="ykctSearchKeyword" value='<%= ykctSearchKeyword%>'
								placeholder="ykct-entry-title" 
					/>
				
					<aui:button type="submit" name="ykctSearchFormSubmitBtn" value="search"/>
				</div>
				
				<div id="<portlet:namespace/>ykctAdvancedSearchForm" class="ykct_search_form_advance_option aui-helper-hidden" >
					
					<aui:select name="categoryId" label="">
						<aui:option value="0" label="all"/>
						<%for(YKCT_Category ykctCategory : ykctCategoryList){ %>
							<aui:option value="<%=ykctCategory.getCategoryId() %>" label="<%=ykctCategory.getCategoryName() %>"/>
						<%} %>
					</aui:select>
					
				</div>
			</aui:form>
		</div>
	</div>
	
	<div class="ykct_search_form_right_content">
		<span class="ykct_search_form_help">
			<a href="<%=ykctViewPageURL%>"><liferay-ui:message key="show-all-ykct"/></a>
		</span>
		
		<span class="show_advanced_search_form">
			<div class="show_advanced">
				<a id="<portlet:namespace/>advancedSearchFormToggleLink" href="javascript:;"><liferay-ui:message key="advance-search"/></a>
			</div>
		</span>
	</div>
</div>

<c:if test='<%=Validator.equals(displayStyle, "default-display-style") %>'>
	<div class="aui-button-holder">
		<div class="ykct-search-result-title" align="left" style="float: left;">
			<span><liferay-ui:message key="ykct-search-results"/></span>
		</div>
		
		<div class="ykct-home-page-btn" align="right">
			<aui:button value="show-all" href="<%=ykctViewPageURL %>"/>
		</div>
		<div style="clear: both;"></div>
	</div>
	
	<div class="ykct_search_results">
		<div class="search_result_list">
							
			<liferay-portlet:renderURL varImpl="ykctViewPageIteratorURL">
				<liferay-portlet:param name="jspPage" value="/html/ykct/view.jsp" />
				<liferay-portlet:param name="ykctSearchKeyword" value="<%=ykctSearchKeyword %>" />
				<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>" />
			</liferay-portlet:renderURL>
			
			<%
			
			List<YKCT_Entry> ykctSearchResultList = YKCT_EntryLocalServiceUtil.findByMultiCondition(groupId, ykctSearchKeyword, 
					categoryId, 0, numbersOfEntriesDisplayOnSearchResultPage);
			%>
			
			<liferay-ui:search-container emptyResultsMessage="no-search-result" iteratorURL="<%=ykctViewPageIteratorURL %>" >
				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(ykctSearchResultList, searchContainer.getStart(), searchContainer.getEnd())%>"
					total="<%=ykctSearchResultList.size() %>"
				>			
				</liferay-ui:search-container-results>
				
				<liferay-ui:search-container-row  className="YKCT_Entry" keyProperty="entryId" modelVar="ykctEntry" >
					
					<%
						ykctIndex++;
						
						StringBundler sb = new StringBundler();
	
						sb.append("javascript:");
						sb.append("showYKCTreviewDialog");
						sb.append("('");
						sb.append(ykctEntry.getEntryId());
						sb.append("')");
	
						String	rowHREF = sb.toString();
						
						YKCT_Category ykctCategory = YKCT_CategoryLocalServiceUtil.fetchYKCT_Category(ykctEntry.getCategoryId());
					%>
					
					<liferay-ui:search-container-column-text title='<%=LanguageUtil.get(locale, "view") %>'  
							name="#" value="<%=String.valueOf(ykctIndex)%>" href="<%=rowHREF %>"/>
					
					<liferay-ui:search-container-column-text title='<%=LanguageUtil.get(locale, "view") %>'  
							name="ykct-entry-name" value="<%=ykctEntry.getEntryName()%>" href="<%=rowHREF %>"/>
							
					<liferay-ui:search-container-column-text title='<%=LanguageUtil.get(locale, "view") %>'  
							name="ykct-category-name" value="<%=ykctCategory.getCategoryName() %>">
							
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>	
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		var ykctSearchFormHelpContainer = A.one('#<portlet:namespace/>ykctSearchFormHelp');
		
		var advanceSearchFormContainer = A.one('#<portlet:namespace/>ykctAdvancedSearchForm');
		
		if(advanceSearchFormContainer && ykctSearchFormHelpContainer){
			
			var showAdvancedSearchForm = <%=ykctAdvanceSearch %>;
			
			if(showAdvancedSearchForm){
				advanceSearchFormContainer.show();
				ykctSearchFormHelpContainer.hide();
			}else{
				
				advanceSearchFormContainer.hide();
				ykctSearchFormHelpContainer.show();
			}
			
			var ykctSearchInput = A.one('#<portlet:namespace/>ykctSearchKeyword');
			
			if(ykctSearchInput){
			
				ykctSearchInput.focus();
			}
			
							
			var showAdvancedSearchToggleLink = A.one('#<portlet:namespace/>advancedSearchFormToggleLink');
			
			if(showAdvancedSearchToggleLink){
				
				showAdvancedSearchToggleLink.on('click',function(){
					
					ykctSearchInput.focus();
					
					if(advanceSearchFormContainer.hasClass('aui-helper-hidden')){
										
						advanceSearchFormContainer.show();
						
						ykctSearchFormHelpContainer.hide();
						
					}else{
						advanceSearchFormContainer.hide();
						
						ykctSearchFormHelpContainer.show();
					}
				});
			}
		}
	});
	
	Liferay.provide(
		window,
		'showYKCTreviewDialog',
		function(ykctEntryId) {
			
			var A = AUI();
			
			A.DialogManager.hideAll();
								
			var ykctPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(ykctPreviewRenderURL){
				
				ykctPreviewRenderURL.setPortletId('<%=portletId %>');
				ykctPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				ykctPreviewRenderURL.setParameter('jspPage', '/html/ykct/ykct_preview.jsp');
				ykctPreviewRenderURL.setParameter('ykctEntryId', ykctEntryId);
				ykctPreviewRenderURL.setDoAsGroupId('<%=groupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '.ykct_search_form_wrapper',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true,
						width:708
					},
					id: '<portlet:namespace/>ykctPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "ykct-preview-content") %>',
					uri: ykctPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
</script>
