<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQConstants"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Category"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	boolean vbpqAdvanceSearch = false;

	int selectAllVBPQStatus = -1;
	
	int vbpqIndex = 0;
	
	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		vbpqIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	//CategoryId lay tu URL lien ket voi portlet vbpq_category
	long vbpqCategoryId = ParamUtil.getLong(request, "vbpqCategoryId",0L);

	long departmentId = ParamUtil.getLong(request, "departmentId",0L);
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);
	long doctypeId = ParamUtil.getLong(request, "doctypeId",0L);

	String vbpqSearchResultTitle = "vbpq-list";
	
	String vbpqCategoryName = "";
	
	String vbpqSearchKeyword = ParamUtil.getString(request, "vbpqSearchKeyword",StringPool.BLANK);
	
	String statisticStartDate = ParamUtil.getString(request, "statisticStartDate",StringPool.BLANK);
	
	String statisticEndDate = ParamUtil.getString(request, "statisticEndDate",StringPool.BLANK);
	
	if((vbpqCategoryId > 0L) || (departmentId > 0) || (categoryId > 0) || (doctypeId > 0)){
		
		vbpqAdvanceSearch = true;
	}
	
	if(vbpqCategoryId > 0){
		
		VBPQ_Category currentVBPQCategory = VBPQ_CategoryLocalServiceUtil.getCategory(vbpqCategoryId);
		
		if(currentVBPQCategory != null){
			
			vbpqCategoryName = currentVBPQCategory.getCategoryName();
			
			//Id phan loai VBPQ_Category
			//currentCategoryTypeId = 1 tuong ung voi Co quan ban hanh VBPQ
			//currentCategoryTypeId = 2 tuong ung voi Linh vuc thong ke VBPQ
			//currentCategoryTypeId = 3 tuong ung voi Loai VBPQ
			int currentCategoryTypeId = currentVBPQCategory.getTypeId();
			
			if(currentCategoryTypeId == VBPQConstants.DEPARTMENT_ID){//Category hien tai la Co quan ban hanh VBPQ

				departmentId = vbpqCategoryId;
				categoryId = 0L;
				doctypeId = 0L;
				vbpqSearchResultTitle = "vbpq-published-by-department";
			
			}else if(currentCategoryTypeId == VBPQConstants.CATEGORY_ID){
				categoryId = vbpqCategoryId;
				departmentId = 0L;
				doctypeId = 0L;
				vbpqSearchResultTitle = "vbpq-published-by-category";
				
			}else if(currentCategoryTypeId == VBPQConstants.DOCUMENT_TYPE_ID){
				doctypeId = vbpqCategoryId;
				departmentId = 0L;
				categoryId = 0L;
				vbpqSearchResultTitle = "";
			}	
		}
	}
	
	//Danh sach co quan ban hanh VBPQ
	List<VBPQ_Category> vbpqDepartmentList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.DEPARTMENT_ID, groupId);

	//Danh sach linh vuc thong ke VBPQ
	List<VBPQ_Category> vbpqCategoryList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.CATEGORY_ID, groupId);

	//Danh sach loai VBPQ
	List<VBPQ_Category> vbpqDocTypeList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.DOCUMENT_TYPE_ID, groupId);
%>

<liferay-portlet:renderURL var="vbpqViewPageURL">
	<liferay-portlet:param name="jspPage" value="/html/view/view.jsp" />
	<liferay-portlet:param name="vbpqCategoryId" value="0" />
</liferay-portlet:renderURL>

<div class="vbpq_search_form_wrapper">
	
	<div class="vbpq_search_form_left_content">
		<div class="title"><liferay-ui:message key="VBPQ"/></div>
	</div>
	
	<div class="vbpq_search_form_center_content">
		
		<div class="vbpq_search_form">
			<aui:form name="vbpq_search_form" method="post" action="<%=vbpqViewPageURL %>">
								
				<div id="<portlet:namespace/>vbpqSearchFormHelp" class="vbpq_search_form_help_content" >
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
								name="vbpqSearchKeyword" value='<%= vbpqSearchKeyword%>'
								placeholder="vbpq-entry-title" 
					/>
				
					<aui:button type="submit" name="vbpqSearchFormSubmitBtn" value="search"/>
				</div>

				<div id="<portlet:namespace/>vbpqAdvancedSearchForm" class="vbpq_search_form_advance_option aui-helper-hidden" >

					<aui:select name="departmentId" label="">
						<aui:option value="0" selected="<%=(departmentId == 0L) %>" label="vbpq-department" />
						<%for(VBPQ_Category vbpqDepartment : vbpqDepartmentList){%>
							<aui:option value="<%=vbpqDepartment.getCategoryId()%>" label="<%=vbpqDepartment.getCategoryName() %>"
										selected="<%=(departmentId == vbpqDepartment.getCategoryId())%>"
							/>				
						<%}%>					
					</aui:select>

					<aui:select name="categoryId" label="">
						<aui:option value="0" selected="<%=(categoryId == 0L) %>" label="vbpq-category" />
						<%for(VBPQ_Category vbpqCategory : vbpqCategoryList){%>
							<aui:option value="<%=vbpqCategory.getCategoryId()%>" label="<%=vbpqCategory.getCategoryName() %>"
										selected="<%=(categoryId == vbpqCategory.getCategoryId())%>"/>				
						<%}%>					
					</aui:select>

					<aui:select name="doctypeId" label="">
						<aui:option value="0" selected="<%=(doctypeId == 0L) %>" label="vbpq-doc-type" />
						<%for(VBPQ_Category vbpqDocType : vbpqDocTypeList){	%>
							<aui:option value="<%=vbpqDocType.getCategoryId()%>" label="<%=vbpqDocType.getCategoryName() %>"
										selected="<%=(doctypeId == vbpqDocType.getCategoryId())%>"/>				
						<%}%>					
					</aui:select>
				</div>
			</aui:form>
		</div>
	</div>
		
	<div class="vbpq_search_form_right_content">
		<span class="vbpq_search_form_help">
			<a href="<%=vbpqViewPageURL%>"><liferay-ui:message key="show-all-vbpq"/></a>
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
		<div class="vbpq-search-result-title" align="left" style="float: left;">
			<c:choose>
				<c:when test="<%= (vbpqSearchKeyword.length() > 0) || vbpqAdvanceSearch %>">
					<span><liferay-ui:message key="vbpq-search-results"/></span>
				</c:when>
				
				<c:otherwise>
					<span><liferay-ui:message key="<%=vbpqSearchResultTitle %>"/>&nbsp;<%=vbpqCategoryName %></span>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="vbpq-home-page-btn" align="right">
			<aui:button value="show-all" href="<%=vbpqViewPageURL %>"/>
		</div>
	</div>
	<div style="clear: both;"></div>
	<div class="vbpq_search_results">
		<div class="search_result_list">
							
			<liferay-portlet:renderURL varImpl="vbpqViewPageIteratorURL">
				<liferay-portlet:param name="jspPage" value="/html/view/view.jsp" />
				<liferay-portlet:param name="vbpqSearchKeyword" value="<%=vbpqSearchKeyword %>" />
				<liferay-portlet:param name="departmentId" value="<%=String.valueOf(departmentId) %>" />
				<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>" />
				<liferay-portlet:param name="doctypeId" value="<%=String.valueOf(doctypeId) %>" />
			</liferay-portlet:renderURL>
			
			<%
			
			List<VBPQ_Entry> vbpqSearchResultList = VBPQ_EntryLocalServiceUtil.findByMultiCondition(groupId, vbpqSearchKeyword,departmentId, 
															categoryId, doctypeId, statisticStartDate,statisticEndDate,
															selectAllVBPQStatus,0,numbersOfEntriesDisplayOnSearchResultPage);
			%>
			
			<liferay-ui:search-container emptyResultsMessage="no-search-result" iteratorURL="<%=vbpqViewPageIteratorURL %>" >
				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(vbpqSearchResultList, searchContainer.getStart(), searchContainer.getEnd())%>"
					total="<%=vbpqSearchResultList.size() %>"
				>			
				</liferay-ui:search-container-results>
				
				<liferay-ui:search-container-row  className="VBPQ_Entry" keyProperty="entryId" modelVar="vbpqEntry" >
					
					<%
						vbpqIndex++;
						
						StringBundler sb = new StringBundler();
	
						sb.append("javascript:");
						sb.append("showVBPQPreviewDialog");
						sb.append("('");
						sb.append(vbpqEntry.getEntryId());
						sb.append("')");
	
						String	rowHREF = sb.toString();
					%>
					
					<liferay-ui:search-container-column-text title='<%=LanguageUtil.get(locale, "view") %>'  
							name="#" value="<%=String.valueOf(vbpqIndex)%>" href="<%=rowHREF %>"/>
					
					<liferay-ui:search-container-column-text title='<%=LanguageUtil.get(locale, "view") %>' 
							name="vbpq-code" value="<%=vbpqEntry.getEntryCode()%>" href="<%=rowHREF %>"/>						
					
					<liferay-ui:search-container-column-text title='<%=LanguageUtil.get(locale, "view") %>'  
							name="vbpq-entry-name" value="<%=vbpqEntry.getEntryName()%>" href="<%=rowHREF %>"/>
					
					<c:if test='<%=Validator.isNotNull(vbpqEntry.getPublishDate()) %>'>
						<liferay-ui:search-container-column-text name="vbpq-publish-date" value="<%=dateFormat.format(vbpqEntry.getPublishDate())%>"/>										 
					</c:if>
					<c:if test='<%=Validator.isNotNull(vbpqEntry.getExecuteDate()) %>'>
						<liferay-ui:search-container-column-text name="vbpq-execute-date" value="<%=dateFormat.format(vbpqEntry.getExecuteDate())%>"/>										 
					</c:if>
					<c:choose>
						<c:when test='<%=(vbpqEntry.isNeverExpired())%>'>
							<liferay-ui:search-container-column-text name="vbpq-expired-date" >
								<liferay-ui:message key="never-expired"/>
							</liferay-ui:search-container-column-text>										 
						</c:when>
						<c:otherwise>
							<c:if test="<%=Validator.isNotNull(vbpqEntry.getExpirationDate()) %>">
								<liferay-ui:search-container-column-text name="vbpq-expired-date" >
									<%=dateFormat.format(vbpqEntry.getExpirationDate()) %>
								</liferay-ui:search-container-column-text>
							</c:if>	
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-row>	
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</div>
</c:if>
	
<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		var vbpqSearchFormHelpContainer = A.one('#<portlet:namespace/>vbpqSearchFormHelp');
		
		var advanceSearchFormContainer = A.one('#<portlet:namespace/>vbpqAdvancedSearchForm');
		
		if(advanceSearchFormContainer && vbpqSearchFormHelpContainer){
			
			var showAdvancedSearchForm = <%=vbpqAdvanceSearch %>;
			
			if(showAdvancedSearchForm){
				advanceSearchFormContainer.show();
				vbpqSearchFormHelpContainer.hide();
			}else{
				
				advanceSearchFormContainer.hide();
				vbpqSearchFormHelpContainer.show();
			}
			
			var vbpqSearchInput = A.one('#<portlet:namespace/>vbpqSearchKeyword');
			
			if(vbpqSearchInput){
			
				vbpqSearchInput.focus();
			}
			
							
			var showAdvancedSearchToggleLink = A.one('#<portlet:namespace/>advancedSearchFormToggleLink');
			
			if(showAdvancedSearchToggleLink){
				
				showAdvancedSearchToggleLink.on('click',function(){
					
					vbpqSearchInput.focus();
					
					if(advanceSearchFormContainer.hasClass('aui-helper-hidden')){
										
						advanceSearchFormContainer.show();
						
						vbpqSearchFormHelpContainer.hide();
						
					}else{
						advanceSearchFormContainer.hide();
						
						vbpqSearchFormHelpContainer.show();
					}
				});
			}
		}
	});
	
	Liferay.provide(
		window,
		'showVBPQPreviewDialog',
		function(vbpqEntryId) {
			
			var A = AUI();
			
			A.DialogManager.hideAll();
								
			var vbpqPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(vbpqPreviewRenderURL){
				
				vbpqPreviewRenderURL.setPortletId('<%=portletId %>');
				vbpqPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				vbpqPreviewRenderURL.setParameter('jspPage', '/html/view/vbpq_preview.jsp');
				vbpqPreviewRenderURL.setParameter('vbpqEntryId', vbpqEntryId);
				vbpqPreviewRenderURL.setDoAsGroupId('<%=groupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '.vbpq_search_form_wrapper',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true,
						width:708
					},
					id: '<portlet:namespace/>vbpqPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "vbpq-preview-content") %>',
					uri: vbpqPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
</script>
