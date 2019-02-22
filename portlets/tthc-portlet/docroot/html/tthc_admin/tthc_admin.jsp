<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Category"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.tthc.permission.TTHCEntryPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%	
	//Trang thai hien thi hay khong hien thi form tim kiem nang cao
	boolean advanceSearch = false;

	int showAllEntries = -1;

	int tthcEntryIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		tthcEntryIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	//Id cua cap thuc hien TTHC lay tu form tim kiem nang cao
	long tthcLevelId = ParamUtil.getLong(request, "tthcLevelId",0L);
	//Id cua co quan thuc hien TTHC lay tu form tim kiem nang cao
	long tthcDepartmentId = ParamUtil.getLong(request, "tthcDepartmentId",0L);
	//Id cua linh vuc thong ke TTHC lay tu form tim kiem nang cao
	long tthcCategoryId = ParamUtil.getLong(request, "tthcCategoryId",0L);
	//Id cua doi tuong thuc hien TTHC lay tu form tim kiem nang cao
	long tthcAudienceId = ParamUtil.getLong(request, "tthcAudienceId",0L);
	//Id cua ket qua thuc hien TTHC lay tu form tim kiem nang cao
	long tthcResultTypeId = ParamUtil.getLong(request, "tthcResultTypeId",0L);
	
	if(tthcLevelId > 0L || tthcDepartmentId > 0L || tthcCategoryId > 0L || tthcAudienceId > 0L || tthcResultTypeId > 0L){
		
		advanceSearch = true;
	}
	//Keyword lay tu form tim kiem co ban
	String tthcBasicSearchKeyword = ParamUtil.getString(request, "tthcBasicSearchKeyword",StringPool.BLANK);

	//Keyword lay tu form tim kiem nang cao
	String tthcAdvancedSearchKeyword = ParamUtil.getString(request, "tthcAdvancedSearchKeyword",StringPool.BLANK);

	//Danh sach cap thuc hien TTHC
	List<TTHC_Category> tthcLevelList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID, scopeGroupId);
	//Danh sach co quan thuc hien TTHC
	List<TTHC_Category> tthcDepartmentList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID, scopeGroupId);
	//Danh sach linh vuc thong ke TTHC
	List<TTHC_Category> tthcCategoryList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID, scopeGroupId);
	//Danh sach doi tuong thuc hien TTHC
	List<TTHC_Category> tthcAudienceList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID, scopeGroupId);
	//Danh sach ket qua thuc hien TTHC
	List<TTHC_Category> tthcResultTypeList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_RESULT_TYPE_CATEGORY_TYPE_ID, scopeGroupId);
	
	//Danh sach tthc
	List<TTHC_Entry> tthcEntryList = new ArrayList<TTHC_Entry>();
	
	if(advanceSearch){//Tim kiem nang cao
		
		tthcEntryList = TTHC_EntryLocalServiceUtil.findByMultiCondition(scopeGroupId, tthcAdvancedSearchKeyword, tthcLevelId, tthcDepartmentId,
			tthcCategoryId, tthcAudienceId, tthcResultTypeId, 0, showAllEntries);
	}else{//Tim kiem co ban
		
		tthcEntryList = TTHC_EntryLocalServiceUtil.findByKeyword(scopeGroupId, tthcBasicSearchKeyword, 0, showAllEntries);
	}
%>
			
<liferay-portlet:renderURL var="tthcAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_admin/tthc_admin.jsp" />
</liferay-portlet:renderURL>
			
<liferay-portlet:renderURL var="addNewTTHCURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_admin/tthc_update_form.jsp" />
</liferay-portlet:renderURL>
			
<liferay-portlet:renderURL var="tthcUploadSettingURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_admin/tthc_settings.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:actionURL var="deleteAllTTHC" name="deleteAllTTHCEntry">
	<liferay-portlet:param name="redirectURL" value="/html/tthc_admin/tthc_admin.jsp"/>
</liferay-portlet:actionURL>
<div class=tthc-admin>
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			
			<div class="add_new_tthc_button" align="left">
				<c:if test="<%=TTHCEntryPermission.contains(permissionChecker, scopeGroupId, TTHCEntryPermission.ADD_TTHC) %>">
					<aui:button type="button" value="add-new-tthc" href="<%=addNewTTHCURL %>"/>
				</c:if>
				
				<c:if test="<%=TTHCEntryPermission.contains(permissionChecker, scopeGroupId, TTHCEntryPermission.FILE_ATTACHMENT_CONFIG) %>">
					<aui:button type="button" name="uploadSettingsBtn" value="upload-settings" href="<%=tthcUploadSettingURL %>"/>
				</c:if>
																
				<c:if test="<%=TTHCEntryPermission.contains(permissionChecker, scopeGroupId, TTHCEntryPermission.TTHC_PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%=TTHC_Entry.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="tthc_simple_search_form" align="right">
			
				<aui:form name="tthc_simple_search_form" method="post" action="<%=tthcAdminURL %>">
				
					<aui:input placeholder="search" label="" name="tthcBasicSearchKeyword" value='<%= tthcBasicSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button type="button" name="openAdvancedSearchFormBtn" value="advance-search"/>
					<aui:button type="button" value="show-all" href="<%=tthcAdminURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
	
	
	<div id="<portlet:namespace/>tthcAdvancedSearchForm" class="tthc_advance_search_form aui-helper-hidden" align="center">
		
		<aui:form name="tthc_advanced_search_form" method="post" action="<%=tthcAdminURL %>">
			<table>
				<tr>
					<td><liferay-ui:message key="search-keyword"/></td>
					<td><input type="text" id="<portlet:namespace/>tthcAdvancedSearchKeyword" name="tthcAdvancedSearchKeyword" value='<%= tthcAdvancedSearchKeyword%>'/></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="tthc-level"/></td>
					<td>
						<aui:select name="tthcLevelId" label="">
							<aui:option value="0" selected="<%=(tthcLevelId == 0L) %>" label="all" />
							<%for(TTHC_Category tthcLevel : tthcLevelList){%>
								<aui:option value="<%=tthcLevel.getCategoryId()%>" label="<%=tthcLevel.getCategoryName() %>"
											selected="<%=(tthcLevelId == tthcLevel.getCategoryId())%>"
								/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="tthc-department"/></td>
					<td>
						<aui:select name="tthcDepartmentId" label="">
							<aui:option value="0" selected="<%=(tthcDepartmentId == 0L) %>" label="all" />
							<%for(TTHC_Category tthcDepartment : tthcDepartmentList){%>
								<aui:option value="<%=tthcDepartment.getCategoryId()%>" label="<%=tthcDepartment.getCategoryName() %>"
											selected="<%=(tthcDepartmentId == tthcDepartment.getCategoryId())%>"/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="tthc-category"/></td>
					<td>
						<aui:select name="tthcCategoryId" label="">
							<aui:option value="0" selected="<%=(tthcCategoryId == 0L) %>" label="all" />
							<%for(TTHC_Category tthcCategory : tthcCategoryList){	%>
								<aui:option value="<%=tthcCategory.getCategoryId()%>" label="<%=tthcCategory.getCategoryName() %>"
											selected="<%=(tthcCategoryId == tthcCategory.getCategoryId())%>"/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="tthc-audience"/></td>
					<td>
						<aui:select name="tthcAudienceId" label="">
							<aui:option value="0" selected="<%=(tthcAudienceId == 0L) %>" label="all" />
							<%for(TTHC_Category tthcAudience : tthcAudienceList){	%>
								<aui:option value="<%=tthcAudience.getCategoryId()%>" label="<%=tthcAudience.getCategoryName() %>"
											selected="<%=(tthcAudienceId == tthcAudience.getCategoryId())%>"/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="tthc-result-type"/></td>
					<td>
						<aui:select name="tthcResultTypeId" label="">
							<aui:option value="0" selected="<%=(tthcResultTypeId == 0L) %>" label="all" />
							<%for(TTHC_Category tthcResultType : tthcResultTypeList){	%>
								<aui:option value="<%=tthcResultType.getCategoryId()%>" label="<%=tthcResultType.getCategoryName() %>"
											selected="<%=(tthcResultTypeId == tthcResultType.getCategoryId())%>"/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key=""/></td>
					<td>
						<aui:button type="submit" value="search"/>
						<aui:button type="button" name="closeAdvancedSearchFormBtn" value="close"/>
					</td>
				</tr>
			</table>
		</aui:form>	
	</div>
	
	<liferay-portlet:renderURL varImpl="tthcAdminImplURL">
		<liferay-portlet:param name="jspPage" value="/html/tthc_admin/tthc_admin.jsp" />
		<liferay-portlet:param name="tthcBasicSearchKeyword" value="<%=tthcBasicSearchKeyword %>"/>
	</liferay-portlet:renderURL>
		
	<%
	if(advanceSearch){
		
		tthcAdminImplURL.setParameter("tthcAdvancedSearchKeyword", tthcAdvancedSearchKeyword);
		tthcAdminImplURL.setParameter("tthcLevelId", String.valueOf(tthcLevelId));
		tthcAdminImplURL.setParameter("tthcDepartmentId", String.valueOf(tthcDepartmentId));
		tthcAdminImplURL.setParameter("tthcCategoryId", String.valueOf(tthcCategoryId));
		tthcAdminImplURL.setParameter("tthcAudienceId", String.valueOf(tthcAudienceId));
		tthcAdminImplURL.setParameter("tthcResultTypeId", String.valueOf(tthcResultTypeId));
	}
	%>
	
	<div class="tthc_search_results">
		
		<liferay-ui:search-container emptyResultsMessage="no-entry-found" iteratorURL="<%=tthcAdminImplURL %>" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(tthcEntryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=tthcEntryList.size() %>"
			/>			
				
			<liferay-ui:search-container-row className="TTHC_Entry" keyProperty="entryId" modelVar="tthcEntry" >
			
				<%
					tthcEntryIndex ++;
				
					StringBundler sb = new StringBundler();
	
					sb.append("javascript:");
					sb.append("showTTHCPreviewDialog");
					sb.append("('");
					sb.append(tthcEntry.getEntryId());
					sb.append("')");
	
					String	rowHREF = sb.toString();
				%>
				<liferay-portlet:renderURL var="editEntryURL" >				
					<liferay-portlet:param name="jspPage" value="/html/tthc_admin/tthc_update_form.jsp" />
					<portlet:param name="tthcEntryId" value="<%=String.valueOf(tthcEntry.getEntryId())%>"/>				
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(tthcEntryIndex) %>" href="<%=rowHREF %>"/>
				
				<liferay-ui:search-container-column-text name="tthc-name" title="view"  value="<%=StringUtil.shorten(tthcEntry.getEntryName(), 100) %>" href="<%=rowHREF %>"/>
					
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(tthcEntry.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value='<%=PortalUtil.getUserName(tthcEntry.getUserId(), "-")%>'/>
								
				<c:if test="<%=TTHCEntryPermission.contains(permissionChecker, scopeGroupId, TTHCEntryPermission.UPDATE_TTHC)%>">														
					<liferay-ui:search-container-column-text name="edit">
						<liferay-ui:icon image="edit" message="edit" url="<%= editEntryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
															
				<c:if test="<%=TTHCEntryPermission.contains(permissionChecker, scopeGroupId, TTHCEntryPermission.DELETE_TTHC) %>">										
					<liferay-portlet:actionURL  name="deleteTTHCEntry" var="deleteTTHCEntryURL">
						<portlet:param name="tthcEntryId" value="<%=String.valueOf(tthcEntry.getEntryId())%>"/>
						<portlet:param name="redirectURL" value="<%=tthcAdminURL%>"/>
					</liferay-portlet:actionURL>
					<liferay-ui:search-container-column-text name="delete">	
						<liferay-ui:icon-delete url="<%= deleteTTHCEntryURL %>" />
					</liferay-ui:search-container-column-text>		
				</c:if>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>


<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		
		var HIDDEN_CSS_CLASS = 'aui-helper-hidden';
		
		var tthcBasicSearchInput = A.one('#<portlet:namespace/>tthcBasicSearchKeyword');
		
		var tthcAdvancedSearchInput= A.one('#<portlet:namespace/>tthcAdvancedSearchKeyword');
		
		var advanceSearchFormWrapper = A.one('#<portlet:namespace/>tthcAdvancedSearchForm');
		
		if(<%=advanceSearch %>){
			
			advanceSearchFormWrapper.show();
			tthcAdvancedSearchInput.focus();
		
		}else{
			
			tthcBasicSearchInput.focus();
		}
		
		var openAdvancedSearchFormBtn = A.one('#<portlet:namespace/>openAdvancedSearchFormBtn');
		
		if(openAdvancedSearchFormBtn){
			
			openAdvancedSearchFormBtn.on('click',function(){
				
				if(advanceSearchFormWrapper.hasClass(HIDDEN_CSS_CLASS)){
					
					advanceSearchFormWrapper.show();
					tthcAdvancedSearchInput.val(tthcBasicSearchInput.val());
					tthcAdvancedSearchInput.focus();
				}else{
					
					advanceSearchFormWrapper.hide();
					tthcBasicSearchInput.val(tthcAdvancedSearchInput.val());
					tthcBasicSearchInput.focus();
				}
			});
		}
		
		var closeAdvancedSearchFormBtn = A.one('#<portlet:namespace/>closeAdvancedSearchFormBtn');
		
		if(closeAdvancedSearchFormBtn){
			
			closeAdvancedSearchFormBtn.on('click',function(){
					
				advanceSearchFormWrapper.hide();
				tthcBasicSearchInput.val(tthcAdvancedSearchInput.val());
				tthcBasicSearchInput.focus();
			});
		}
		
		
		Liferay.provide(
			window,
			'showTTHCPreviewDialog',
			function(tthcEntryId) {
				
				A.DialogManager.hideAll();
									
				var tthcPreviewRenderURL = Liferay.PortletURL.createRenderURL();
				
				if(tthcPreviewRenderURL){
					
					tthcPreviewRenderURL.setPortletId('<%=portletId %>');
					tthcPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
					tthcPreviewRenderURL.setParameter('jspPage', '/html/tthc_admin/tthc_preview.jsp');
					tthcPreviewRenderURL.setParameter('tthcEntryId', tthcEntryId);
					tthcPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
				}
																				
				var dialogAlignConfig = {
						node: '#<portlet:namespace/>uploadSettingsBtn',
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
		
		Liferay.provide(
			window,
			'showTTHCUpdateForm',
			function(tthcEntryId) {
												
				var tthcUpdateFormURL = Liferay.PortletURL.createRenderURL();
				
				if(tthcUpdateFormURL){
					
					tthcUpdateFormURL.setPortletId('<%=portletId %>');
					tthcUpdateFormURL.setWindowState('<%=LiferayWindowState.MAXIMIZED.toString() %>');
					tthcUpdateFormURL.setParameter('jspPage', '/html/tthc_admin/tthc_update_form.jsp');
					tthcUpdateFormURL.setParameter('tthcEntryId', tthcEntryId);
					tthcUpdateFormURL.setDoAsGroupId('<%=scopeGroupId %>');
				}
				
				window.location = tthcUpdateFormURL;					
			},
			['aui-base']
		);
	});
</script>