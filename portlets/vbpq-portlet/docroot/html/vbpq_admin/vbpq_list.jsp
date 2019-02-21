<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQConstants"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Category"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.portal_egov.portlet.vbpq.permission.VBPQEntryPermission"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int vbpqEntryIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		vbpqEntryIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}

	String departmentName = "other";
	String categoryName = "other";
		
	String vbpqBasicSearchKeyword = ParamUtil.getString(request, "vbpqBasicSearchKeyword",StringPool.BLANK);
	String vbpqAdvancedSearchKeyword = ParamUtil.getString(request, "vbpqAdvancedSearchKeyword",StringPool.BLANK);
	String vbpqSearchStyle = ParamUtil.getString(request, "vbpqSearchStyle",StringPool.BLANK);
	
	long departmentId = ParamUtil.getLong(request, "departmentId",0L);
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);
	long doctypeId = ParamUtil.getLong(request, "doctypeId",0L);
	
	//Danh sach co quan ban hanh VBPQ
	List<VBPQ_Category> vbpqDepartmentList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.DEPARTMENT_ID, groupId);

	//Danh sach linh vuc thong ke VBPQ
	List<VBPQ_Category> vbpqCategoryList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.CATEGORY_ID, groupId);

	//Danh sach loai VBPQ
	List<VBPQ_Category> vbpqDocTypeList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.DOCUMENT_TYPE_ID, groupId);
	
	//Danh sach VBPQ entry theo companyId
	List<VBPQ_Entry> vbpqEntryList = VBPQ_EntryLocalServiceUtil.findByKeyword(vbpqBasicSearchKeyword, groupId,-1,-1);
	
	if(Validator.equals(vbpqSearchStyle, "advancedSearch")){
		
		vbpqEntryList = VBPQ_EntryLocalServiceUtil.findByMultiCondition(groupId, vbpqAdvancedSearchKeyword, departmentId, categoryId, doctypeId, null, null, -1,-1,-1);
	}
%>
			
<liferay-portlet:renderURL var="vbpqAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/vbpq_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Entries"/>
</liferay-portlet:renderURL>
			
<liferay-portlet:renderURL var="addNewVBPQURL">
	<liferay-portlet:param name="jspPage" value="/html/vbpq_admin/vbpq_update_form.jsp" />
</liferay-portlet:renderURL>
			
<liferay-portlet:renderURL var="vbpqUploadSettingURL">
	<liferay-portlet:param name="jspPage" value="/html/vbpq_admin/vbpq_settings/vbpq_settings.jsp" />
</liferay-portlet:renderURL>

<div class="vbpq_entry_management">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			
			<div class="add_new_vbpq_button" align="left">
				<c:if test="<%=VBPQEntryPermission.contains(permissionChecker, groupId, VBPQEntryPermission.ADD_VBPQ) %>">
					<aui:button type="button" value="add-vbpq" href="<%=addNewVBPQURL %>"/>
				</c:if>
									
				<c:if test="<%=VBPQEntryPermission.contains(permissionChecker, groupId, VBPQEntryPermission.FILE_ATTACHMENT_CONFIG) %>">
					<aui:button type="button" value="upload-settings" href="<%=vbpqUploadSettingURL %>"/>
				</c:if>
							
				<c:if test="<%=VBPQEntryPermission.contains(permissionChecker, groupId, VBPQEntryPermission.VBPQ_PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%=VBPQ_Entry.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="vbpq_search_form" align="right">
				<aui:form name="vbpq_search_form" method="post" action="<%=vbpqAdminURL %>">
					<input type="text" id="<portlet:namespace/>vbpqBasicSearchInput" name="vbpqBasicSearchKeyword" value='<%= vbpqBasicSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button type="button" value="advance-search" onClick='openAdvancedSearch();'/>
					
					<aui:button type="button" value="show-all" href="<%=vbpqAdminURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
	
	<div id="vbpq_advance_search" class="vbpq_advance_search_form aui-helper-hidden" align="center">
		
		<liferay-portlet:renderURL var="vbpqAdvancedSearchFormURL">
			<liferay-portlet:param name="jspPage" value="/html/vbpq_admin/view.jsp" />
			<liferay-portlet:param name="tabs1" value="Entries"/>
			<liferay-portlet:param name="vbpqSearchStyle" value="advancedSearch"/>
		</liferay-portlet:renderURL>
		
		<aui:form name="vbpq_search_form" method="post" action="<%=vbpqAdvancedSearchFormURL %>">
			<table>
				<tr>
					<td><liferay-ui:message key="keyword"/></td>
					<td>
						<input type="text" id="<portlet:namespace/>vbpqAdvancedSearchInput" name="vbpqAdvancedSearchKeyword" value='<%= vbpqAdvancedSearchKeyword%>'/>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="vbpq-department"/></td>
					<td>
						<aui:select name="departmentId" label="">
							<aui:option value="0" selected="<%=(departmentId == 0L) %>" label="all" />
							<%for(VBPQ_Category vbpqDepartment : vbpqDepartmentList){%>
								<aui:option value="<%=vbpqDepartment.getCategoryId()%>" label="<%=vbpqDepartment.getCategoryName() %>"
											selected="<%=(departmentId == vbpqDepartment.getCategoryId())%>"
								/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="vbpq-category"/></td>
					<td>
						<aui:select name="categoryId" label="">
							<aui:option value="0" selected="<%=(categoryId == 0L) %>" label="all" />
							<%for(VBPQ_Category vbpqCategory : vbpqCategoryList){%>
								<aui:option value="<%=vbpqCategory.getCategoryId()%>" label="<%=vbpqCategory.getCategoryName() %>"
											selected="<%=(categoryId == vbpqCategory.getCategoryId())%>"/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="vbpq-doc-type"/></td>
					<td>
						<aui:select name="doctypeId" label="">
							<aui:option value="0" selected="<%=(doctypeId == 0L) %>" label="all" />
							<%for(VBPQ_Category vbpqDocType : vbpqDocTypeList){	%>
								<aui:option value="<%=vbpqDocType.getCategoryId()%>" label="<%=vbpqDocType.getCategoryName() %>"
											selected="<%=(doctypeId == vbpqDocType.getCategoryId())%>"/>				
							<%}%>					
						</aui:select>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key=""/></td>
					<td>
						<aui:button type="submit" value="search"/>
						<aui:button type="button" value="close" onClick='closeAdvancedSearch();'/>
					</td>
				</tr>
			</table>
		</aui:form>	
	</div>
	
	<liferay-portlet:renderURL varImpl="vbpqAdminImplURL">
		<liferay-portlet:param name="jspPage" value="/html/vbpq_admin/view.jsp" />
		<liferay-portlet:param name="tabs1" value="Entries"/>
		<liferay-portlet:param name="vbpqBasicSearchKeyword" value="<%=vbpqBasicSearchKeyword %>"/>
	</liferay-portlet:renderURL>
	
	<%
	if(Validator.equals(vbpqSearchStyle, "advancedSearch")){
		
		vbpqAdminImplURL.setParameter("vbpqSearchStyle", "advancedSearch");
		vbpqAdminImplURL.setParameter("vbpqAdvancedSearchKeyword", vbpqAdvancedSearchKeyword);
		vbpqAdminImplURL.setParameter("departmentId", String.valueOf(departmentId));
		vbpqAdminImplURL.setParameter("categoryId", String.valueOf(categoryId));
		vbpqAdminImplURL.setParameter("doctypeId", String.valueOf(doctypeId));
	}
	%>
	
	<h3>searchContainerDelta = <%=searchContainerDelta %></h3>
	<h3>searchContainerCurrentPage = <%=searchContainerCurrentPage %></h3>
	<div class="vbpq_search_results">
		<liferay-ui:search-container emptyResultsMessage="no-vbpq-entry-found" iteratorURL="<%=vbpqAdminImplURL %>" delta="20" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(vbpqEntryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=vbpqEntryList.size() %>"
			>			
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="VBPQ_Entry" keyProperty="entryId" modelVar="vbpqEntry" >
				
				<%
					vbpqEntryIndex ++;
				
					String vbpqName = StringUtil.shorten(vbpqEntry.getEntryName(), 100);
				
					if(vbpqEntry.getDepartmentId() > 0){
						VBPQ_Category vbpqDepartment = VBPQ_CategoryLocalServiceUtil.getCategory(vbpqEntry.getDepartmentId());
						
						if(vbpqDepartment != null){
							departmentName = vbpqDepartment.getCategoryName();
						}
					}
					
					StringBundler sb = new StringBundler();

					sb.append("javascript:");
					sb.append("showVBPQPreviewDialog");
					sb.append("('");
					sb.append(vbpqEntry.getEntryId());
					sb.append("')");

					String	rowHREF = sb.toString();
				%>
				<liferay-portlet:renderURL var="editURL" >
					<liferay-portlet:param name="jspPage" value="/html/vbpq_admin/vbpq_update_form.jsp" />
					<liferay-portlet:param name="entryId" value="<%=String.valueOf(vbpqEntry.getEntryId())%>"/>
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" title="view" value="<%=String.valueOf(vbpqEntryIndex) %>" href="<%=rowHREF %>"/>
							
				<liferay-ui:search-container-column-text name="Code" title="view" value="<%=vbpqEntry.getEntryCode() %>" href="<%=rowHREF %>"/>
			
				<liferay-ui:search-container-column-text name="vbpq-entry-name" 
						title='<liferay-ui:message key="view"/>' value="<%=vbpqName%>" href="<%=rowHREF %>"/>
				
				<liferay-ui:search-container-column-text name="Department">
					<liferay-ui:message key="<%=departmentName%>"/>
				</liferay-ui:search-container-column-text>
				
				<c:if test="<%=VBPQEntryPermission.contains(permissionChecker, groupId, VBPQEntryPermission.UPDATE_VBPQ) %>">
					<liferay-ui:search-container-column-text name="edit">															
						<liferay-ui:icon image="edit" message="edit" url="<%= editURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
																									
				<c:if test="<%=VBPQEntryPermission.contains(permissionChecker, groupId, VBPQEntryPermission.DELETE_VBPQ) %>">
					<liferay-ui:search-container-column-text name="delete">													
						<liferay-portlet:actionURL  name="deleteVBPQEntry" var="deleteEntryURL">
							<liferay-portlet:param name="entryId" value="<%=String.valueOf(vbpqEntry.getEntryId())%>"/>
							<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteEntryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>		
															 						
			</liferay-ui:search-container-row >	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container >
	</div>
</div>

<aui:script>
	AUI().ready('aui-base',function(A){
	
		var vbpqBasicSearchInput = A.one('#<portlet:namespace/>vbpqBasicSearchInput');
		
		if(vbpqBasicSearchInput){
			vbpqBasicSearchInput.focus();
		}
	});
</aui:script>

<aui:script>

	var A = AUI();
	
	var advanceSearchFormWrapper = A.one('#vbpq_advance_search');
	
	if(<%=Validator.equals(vbpqSearchStyle, "advancedSearch") %>){
		advanceSearchFormWrapper.setStyle('display','block');
	}
	
	function openAdvancedSearch(){
		
		var advancedSearchWrapper = A.one('#vbpq_advance_search');
		
		if(advancedSearchWrapper){
		
			var advancedSearch = false;
					
			if(!advancedSearchWrapper.hasClass('aui-helper-hidden')){
				
				advancedSearch = true;
			}
					
			var vbpqBasicSearchInput = A.one('#<portlet:namespace/>vbpqBasicSearchInput');
			
			var vbpqAdvancedSearchInput = A.one('#<portlet:namespace/>vbpqAdvancedSearchInput');
			
			if(vbpqBasicSearchInput && vbpqAdvancedSearchInput){
				
				var vbpqBasicSearchKeyword = vbpqBasicSearchInput.val();
				
				var vbpqAdvancedSearchKeyword = vbpqAdvancedSearchInput.val();
				
				if(advancedSearch){
					advancedSearchWrapper.hide();
					vbpqBasicSearchInput.focus();
					vbpqBasicSearchInput.val(vbpqAdvancedSearchKeyword);
					
				}else{
					advancedSearchWrapper.show();
					vbpqAdvancedSearchInput.focus();
					vbpqAdvancedSearchInput.val(vbpqBasicSearchKeyword);
				}
			}
		}
	}
	
	function closeAdvancedSearch(){
		var advancedSearchWrapper = A.one('#vbpq_advance_search');
		
		if(advancedSearchWrapper){
			advancedSearchWrapper.setStyle('display','none');
		}
	}
	

	Liferay.provide(
		window,
		'showVBPQPreviewDialog',
		function(vbpqEntryId) {
			
			A.DialogManager.hideAll();
								
			var vbpqPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(vbpqPreviewRenderURL){
				
				vbpqPreviewRenderURL.setPortletId('<%=portletId %>');
				vbpqPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				vbpqPreviewRenderURL.setParameter('jspPage', '/html/vbpq_admin/vbpq_preview.jsp');
				vbpqPreviewRenderURL.setParameter('vbpqEntryId', vbpqEntryId);
				vbpqPreviewRenderURL.setDoAsGroupId('<%=groupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '#_vbpq_management_WAR_vbpqportlet_tabs18666808183101116116105110103115TabsId',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true
					},
					id: '<portlet:namespace/>vbpqPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "vbpq-preview-content") %>',
					uri: vbpqPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
	
	Liferay.provide(
		window,
		'showVBPQUpdateForm',
		function(vbpqEntryId) {
											
			var vbpqUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(vbpqUpdateFormURL){
				
				vbpqUpdateFormURL.setPortletId('<%=portletId %>');
				vbpqUpdateFormURL.setWindowState('<%=LiferayWindowState.MAXIMIZED.toString() %>');
				vbpqUpdateFormURL.setParameter('jspPage', '/html/vbpq_admin/vbpq_update_form.jsp');
				vbpqUpdateFormURL.setParameter('entryId', vbpqEntryId);
				vbpqUpdateFormURL.setDoAsGroupId('<%=groupId %>');
			}
			
			window.location = vbpqUpdateFormURL;					
		},
		['aui-base']
	);
</aui:script>
