<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Category"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/tthc_view/init.jsp"%>

<%	
	boolean advancedSearch = false;
	
	int tthcIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		tthcIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	//Id cua co cap thuc hien thu tuc
	long levelId = ParamUtil.getLong(request, "levelId",0L);
	
	//Id cua co quan thuc hien thu tuc
	long departmentId = ParamUtil.getLong(request, "departmentId",0L);
	
	//ID cua linh vuc thong ke thu tuc
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	//Id cua doi tuong thuc hien thu tuc
	long audienceId = ParamUtil.getLong(request, "audienceId",0L);

	if((levelId > 0) || (departmentId > 0) || (categoryId > 0) || (audienceId > 0)){
		
		advancedSearch = true;
	}
	
	String tthcSearchKeyword = ParamUtil.getString(request, "tthcSearchKeyword",StringPool.BLANK);

	String tthcSearchResultTitle = "tthc-list";

	String selectedCategoryName = "";

	//tthcCategoryId bat duoc tu URL khi lien ket voi portlet TTHC Categories
	long tthcCategoryId = ParamUtil.getLong(request, "tthcCategoryId",0L);
	
	if(Validator.isNotNull(tthcScope)){
		
		if(Validator.equals(tthcScope, "tthcDepartment") && (tthcCategoryId == 0L)){
			
			tthcCategoryId = departmentScopeId;
			
		}else if(Validator.equals(tthcScope, "tthcCategory") && (tthcCategoryId == 0L)){
			
			tthcCategoryId = categoryScopeId;
			
		}else if(Validator.equals(tthcScope, "tthcLevel") && (tthcCategoryId == 0L)){
			
			tthcCategoryId = tthcLevelScopeId;
		}
	}
	
	if(tthcCategoryId > 0){
		
		TTHC_Category selectedCategory = TTHC_CategoryLocalServiceUtil.getTTHC_Category(tthcCategoryId);
		
		if(selectedCategory != null){
			
			selectedCategoryName = selectedCategory.getCategoryName();
			
			//Id phan loai TTHC Category
			int categoryTypeId = selectedCategory.getCategoryTypeId();
			
			if(categoryTypeId == TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID){//selectedCategory la Cap thuc hien TTHC.Luc nay tthcCategoryId = tthcLevelId
				
				levelId = tthcCategoryId;
				departmentId = 0;
				categoryId = 0;
				audienceId = 0;
				
				tthcSearchResultTitle = "tthc-published-by-level";
								
			}else if(categoryTypeId == TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID){//selectedCategory la Co quan thuc hien TTHC
				
				levelId = 0;
				departmentId = tthcCategoryId;
				categoryId = 0;
				audienceId = 0;
			
				tthcSearchResultTitle = "tthc-published-by-department";
			
			}else if(categoryTypeId == TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID){//selectedCategory la Linh vuc thong ke TTHC
				
				levelId = 0;
				departmentId = 0;
				categoryId = tthcCategoryId;
				audienceId = 0;
			
				tthcSearchResultTitle = "tthc-published-by-category";
			
			}else if(categoryTypeId == TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID){//selectedCategory la Doi tuong thuc hien TTHC
				
				levelId = 0;
				departmentId = 0;
				categoryId = 0;
				audienceId = tthcCategoryId;
			
				tthcSearchResultTitle = "tthc-published-by-audience";
			}
		}
	}
	
	//Danh sach cap thuc hien tthc
	List<TTHC_Category> tthcLevelList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID, groupId);
	
	//Danh sach co quan thuc hien tthc
	List<TTHC_Category> tthcDepartmentList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID, groupId);
	
	//Danh sach linh vuc thong ke thu tuc
	List<TTHC_Category> tthcCategoryList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID, groupId);
	
	//Danh sach doi tuong thuc hien thu tuc
	List<TTHC_Category> tthcAudienceList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID, groupId);
%>
<liferay-portlet:renderURL var="tthcHomePageURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_view/view.jsp" />
	<liferay-portlet:param name="tthcCategoryId" value="0" />
</liferay-portlet:renderURL>
		
<div class="tthc_search_form_wrapper">
	
	<div class="tthc_search_form_left_content">
		<div class="title"><liferay-ui:message key="TTHC"/></div>
	</div>
	
	<div class="tthc_search_form_center_content">
		
		<div class="tthc_search_form">
			<aui:form name="tthc_search_form" method="post" action="<%=tthcHomePageURL %>">
								
				<div id="<portlet:namespace/>tthcHelpContentContainer" class="tthc_search_form_help_content">
					<span class ="search_form_title"><liferay-ui:message key="tthc-search-form"/></span>
					<br/>
					<span class ="help_content">
						<liferay-ui:message key="please-enter-tthc-name-or-keyword-on-search-content-below"/>
						<br/>
						<liferay-ui:message key="select-advance-search-for-more-search-options"/>
					</span>
				</div>
				
				<div class="lfr-form-row">
					<aui:input 	type="text" label=""
								name="tthcSearchKeyword" value='<%= tthcSearchKeyword%>'
								placeholder="tthc-title" 
					/>
					
					<aui:button type="submit" value="search"/>
				</div>

				<div  id="<portlet:namespace/>tthcAdvancedSearchFormContainer" class="tthc_search_form_advance_option aui-helper-hidden">
					<table>
						<tr>
							<td>
								<aui:select name="levelId" label="">
									<aui:option value="0" selected="<%=(levelId == 0L) %>" label="tthc-level" />
									<%for(TTHC_Category tthcLevel : tthcLevelList){%>
										<aui:option value="<%=tthcLevel.getCategoryId()%>" label="<%=tthcLevel.getCategoryName() %>"
													selected="<%=(levelId == tthcLevel.getCategoryId())%>"
										/>				
									<%}%>					
								</aui:select>
							</td>
							<td>
								<aui:select name="categoryId" label="">
									<aui:option value="0" selected="<%=(categoryId == 0L) %>" label="tthc-category" />
									<%for(TTHC_Category tthcCategory : tthcCategoryList){%>
										<aui:option value="<%=tthcCategory.getCategoryId()%>" label="<%=tthcCategory.getCategoryName() %>"
													selected="<%=(categoryId == tthcCategory.getCategoryId())%>"
										/>				
									<%}%>					
								</aui:select>
							</td>
						</tr>
						<tr>
							<td>
								<aui:select name="departmentId" label="">
									<aui:option value="0" selected="<%=(departmentId == 0L) %>" label="tthc-department" />
									<%for(TTHC_Category tthcDepartment : tthcDepartmentList){%>
										<aui:option value="<%=tthcDepartment.getCategoryId()%>" label="<%=tthcDepartment.getCategoryName() %>"
													selected="<%=(departmentId == tthcDepartment.getCategoryId())%>"
										/>				
									<%}%>					
								</aui:select>
							</td>					
							<td>
								<aui:select name="audienceId" label="">
									<aui:option value="0" selected="<%=(audienceId == 0L) %>" label="tthc-audience" />
									<%for(TTHC_Category tthcAudience : tthcAudienceList){%>
										<aui:option value="<%=tthcAudience.getCategoryId()%>" label="<%=tthcAudience.getCategoryName() %>"
													selected="<%=(audienceId == tthcAudience.getCategoryId())%>"
										/>				
									<%}%>					
								</aui:select>
							</td>
						</tr>
					</table>
				</div>
			</aui:form>
		</div>
	</div>
		
	<div class="tthc_search_form_right_content">
		<span class="tthc_search_form_help">
			<a href="<%=tthcHomePageURL%>"><liferay-ui:message key="show-all-tthc"/></a>
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
		<div class="tthc-search-result-title" align="left" style="float: left;">
			<c:choose>
				<c:when test="<%= (tthcSearchKeyword.length() > 0) || advancedSearch %>">
					<span><liferay-ui:message key="vbpq-search-results"/></span>
				</c:when>
				
				<c:otherwise>
					<span><liferay-ui:message key="<%=tthcSearchResultTitle %>"/>&nbsp;<%=selectedCategoryName %></span>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="vbpq-home-page-btn" align="right">
			<aui:button value="show-all" href="<%=tthcHomePageURL %>"/>
		</div>
	</div>
	<div style="clear: both;"></div>
		
	<%
		List<TTHC_Entry> tthcSearchResultList = TTHC_EntryLocalServiceUtil.findByMultiCondition(groupId, tthcSearchKeyword, levelId, 
			departmentId, categoryId, audienceId, 0, 0, numbersOfEntriesDisplayOnSearchResultPage);
	%>
	
	<div class="tthc_search_result">
		<div class="tthc_search_result_list">		
								
			<liferay-portlet:renderURL varImpl="tthcSearchResultsIteratorURL">
				<liferay-portlet:param name="jspPage" value="/html/tthc_view/view.jsp" />
				<liferay-portlet:param name="tthcSearchKeyword" value="<%=tthcSearchKeyword %>" />
				<liferay-portlet:param name="levelId" value="<%=String.valueOf(levelId) %>" />
				<liferay-portlet:param name="departmentId" value="<%=String.valueOf(departmentId) %>" />
				<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>" />
				<liferay-portlet:param name="audienceId" value="<%=String.valueOf(audienceId) %>" />
			</liferay-portlet:renderURL>
			
			<liferay-ui:search-container emptyResultsMessage="no-search-result" iteratorURL="<%=tthcSearchResultsIteratorURL %>" delta="20">
				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(tthcSearchResultList, searchContainer.getStart(), searchContainer.getEnd())%>"
					total="<%=tthcSearchResultList.size() %>"
				>			
				</liferay-ui:search-container-results>
				
				<liferay-ui:search-container-row className="TTHC_Entry" keyProperty="entryId" modelVar="tthcEntry" >
					<%
						tthcIndex ++;
					
						StringBundler sb = new StringBundler();
		
						sb.append("javascript:");
						sb.append("showTTHCPreviewDialog");
						sb.append("('");
						sb.append(tthcEntry.getEntryId());
						sb.append("')");
		
						String	rowHREF = sb.toString();
					%>
					
					<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(tthcIndex)%>" href="<%=rowHREF %>" title="view"/>
								
					<liferay-ui:search-container-column-text name="tthc-title" value="<%=tthcEntry.getEntryName()%>" href="<%=rowHREF %>" title="view"/>
					
					<liferay-ui:search-container-column-text name="tthc-category" value="<%=TTHCUtil.getTTHCCategoryName(tthcEntry.getCategoryId())%>"/>
																					
				</liferay-ui:search-container-row>	
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		var tthcHelpContentContainer = A.one('#<portlet:namespace/>tthcHelpContentContainer');
		
		var tthcAdvancedSearchFormContainer = A.one('#<portlet:namespace/>tthcAdvancedSearchFormContainer');
		
		if(tthcHelpContentContainer && tthcAdvancedSearchFormContainer){
			
			var advancedSearch = <%=advancedSearch %>;
			
			if(advancedSearch){
				tthcAdvancedSearchFormContainer.show();
				tthcHelpContentContainer.hide();
			}else{
				
				tthcAdvancedSearchFormContainer.hide();
				tthcHelpContentContainer.show();
			}
			
			var tthcSearchKeywordInput = A.one('#<portlet:namespace/>tthcSearchKeyword');
			
			if(tthcSearchKeywordInput){
			
				tthcSearchKeywordInput.focus();
			}
			
							
			var showAdvancedSearchToggleLink = A.all('#<portlet:namespace/>advancedSearchFormToggleLink');
			
			if(showAdvancedSearchToggleLink){
				
				showAdvancedSearchToggleLink.on('click',function(){
					
					tthcSearchKeywordInput.focus();
					
					if(tthcAdvancedSearchFormContainer.hasClass('aui-helper-hidden')){
										
						tthcAdvancedSearchFormContainer.show();
						
						tthcHelpContentContainer.hide();
						
					}else{
						tthcAdvancedSearchFormContainer.hide();
						
						tthcHelpContentContainer.show();
					}
				});
			}
		}
	});
	
	Liferay.provide(
		window,
		'showTTHCPreviewDialog',
		function(tthcEntryId) {
			
			var A = AUI();
			
			A.DialogManager.hideAll();
								
			var tthcPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(tthcPreviewRenderURL){
				
				tthcPreviewRenderURL.setPortletId('<%=portletId %>');
				tthcPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				tthcPreviewRenderURL.setParameter('jspPage', '/html/tthc_view/tthc_preview.jsp');
				tthcPreviewRenderURL.setParameter('tthcEntryId', tthcEntryId);
				tthcPreviewRenderURL.setDoAsGroupId('<%=groupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '.tthc_search_form_wrapper',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true
					},
					id: '<portlet:namespace/>tthcPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "tthc-preview-content") %>',
					uri: tthcPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
</script>
