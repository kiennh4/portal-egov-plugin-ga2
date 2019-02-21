<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Category"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Entry"%>
<%@page import="com.portal_egov.portlet.ykct.permission.YKCTEntryPermission"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/ykctadmin/init.jsp"%>

<%
String ykctBasicSearchKeyword = ParamUtil.getString(request, "ykctBasicSearchKeyword", StringPool.BLANK);

String ykctAdvancedSearchKeyword = ParamUtil.getString(request, "ykctAdvancedSearchKeyword", StringPool.BLANK);

long categoryId = ParamUtil.getLong(request, "categoryId",0L);

List<YKCT_Category> ykctCategoryList = YKCT_CategoryLocalServiceUtil.findByGroup(groupId);

boolean advancedSearch = false;

if(categoryId > 0){
	
	advancedSearch = true;
}

List<YKCT_Entry> ykctEntryList = YKCT_EntryLocalServiceUtil.findByKeyword(groupId, ykctBasicSearchKeyword, -1, -1);

int ykctEntryIndex = 0;
%>
<liferay-portlet:renderURL var="ykctAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="ykct_entry"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="addNewYKCTURL">
	<liferay-portlet:param name="jspPage" value="/html/ykctadmin/ykct_entry/ykct_update_form.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="ykctUploadSettingURL">
	<liferay-portlet:param name="jspPage" value="/html/ykctadmin/ykct_settings/ykct_settings.jsp" />
</liferay-portlet:renderURL>

<div class="ykct_entry_admin">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="add_new_ykct_button" align="left">
				<c:if test="<%=YKCTEntryPermission.contains(permissionChecker, groupId, YKCTEntryPermission.ADD_YKCT) %>">
					<aui:button type="button" value="add-ykct" href="<%=addNewYKCTURL %>"/>
				</c:if>
				
				<c:if test="<%=YKCTEntryPermission.contains(permissionChecker, groupId, YKCTEntryPermission.FILE_ATTACHMENT_CONFIG) %>">
					<aui:button type="button" name="vbpqUploadSettingsBtn" value="upload-settings" href="<%=ykctUploadSettingURL %>"/>
				</c:if>
				
				<c:if test="<%=YKCTEntryPermission.contains(permissionChecker, groupId, YKCTEntryPermission.YKCT_PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%=YKCT_Entry.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>
			
			<div class="ykct_search_form" align="right">
				<aui:form name="ykct_search_form" method="post" action="<%=ykctAdminURL %>">
					<input type="text" id="<portlet:namespace/>ykctBasicSearchInput" name="ykctBasicSearchKeyword" value='<%= ykctBasicSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button type="button" value="advance-search" onClick='openAdvancedSearch();'/>
					
					<aui:button type="button" value="show-all" href="<%=ykctAdminURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
	
	<div id="ykct_advance_search" class="ykct_advance_search_form aui-helper-hidden" align="center">
		<aui:form name="ykct_search_form" method="post" action="<%=ykctAdminURL %>">
			<table>
				<tr>
					<td><liferay-ui:message key="keyword"/></td>
					<td>
						<input type="text" id="<portlet:namespace/>ykctAdvancedSearchInput" name="ykctAdvancedSearchKeyword" value='<%= ykctAdvancedSearchKeyword%>'/>
					</td>
				</tr>
				
				<tr>
					<td><liferay-ui:message key="ykct-category"/></td>
					<td>
						<aui:select name="categoryId" label="">
							<aui:option value="0" label="all" selected="<%= (categoryId == 0) %>"/>
							<%for(YKCT_Category ykctCategory : ykctCategoryList){ %>
								<aui:option value="<%=ykctCategory.getCategoryId() %>" label="<%= ykctCategory.getCategoryName() %>"
									selected="<%=(ykctCategory.getCategoryId() == categoryId) %>"/>
							<%} %>	
						</aui:select>
					</td>
				</tr>
			</table>
		</aui:form>
	</div>
	
	<div class="ykct_search_results">
	
		<liferay-portlet:renderURL varImpl="ykctAdminImplURL">
			<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp"/>
			<liferay-portlet:param name="tabs1" value="ykct_entry"/>
			<liferay-portlet:param name="ykctBasicSearchKeyword" value="<%=ykctBasicSearchKeyword %>"/>
		</liferay-portlet:renderURL>
		
		<%
		if(advancedSearch){
			ykctAdminImplURL.setParameter("ykctAdvancedSearchKeyword", ykctAdvancedSearchKeyword);
			ykctAdminImplURL.setParameter("categoryId", String.valueOf(categoryId));
		}
		%>
		
		<liferay-ui:search-container emptyResultsMessage="no-ykct-entry-found" iteratorURL="<%=ykctAdminImplURL %>" delta="20" >
		
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(ykctEntryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=ykctEntryList.size() %>"
			>			
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="YKCT_Entry" keyProperty="entryId" modelVar="ykctEntry" >
				<%
					ykctEntryIndex ++;
				
					String ykctName = StringUtil.shorten(ykctEntry.getEntryName(), 100);
					
					long ykctCategoryId = ykctEntry.getCategoryId();
					
					YKCT_Category ykctCategory = null;
					
					String ykctCategoryName = null;
					
					if(ykctCategoryId > 0){
					
						ykctCategory = YKCT_CategoryLocalServiceUtil.fetchYKCT_Category(ykctCategoryId);
						
						ykctCategoryName = ykctCategory.getCategoryName();
					
					}
					
					StringBundler sb = new StringBundler();

					sb.append("javascript:");
					sb.append("showYKCTPreviewDialog");
					sb.append("('");
					sb.append(ykctEntry.getEntryId());
					sb.append("')");

					String	rowHREF = sb.toString();
				%>
				
				<liferay-portlet:renderURL var="editURL" >
					<liferay-portlet:param name="jspPage" value="/html/ykctadmin/ykct_entry/ykct_update_form.jsp" />
					<liferay-portlet:param name="entryId" value="<%=String.valueOf(ykctEntry.getEntryId())%>"/>
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" title='<%=LanguageUtil.get(locale, "view") %>' 
						value="<%=String.valueOf(ykctEntryIndex) %>" href="<%=rowHREF %>"/>
						
				<liferay-ui:search-container-column-text name="ykct-entry-name" title='<%=LanguageUtil.get(locale, "view") %>'  
						value="<%=ykctName%>" href="<%=rowHREF %>"/>
<%-- 				<c:choose> --%>
<%-- 					<c:when test="<%= ykctCategoryName != null %>"> --%>
<%-- 						<liferay-ui:search-container-column-text name="ykct-category-name" title='<%=LanguageUtil.get(locale, "view") %>'   --%>
<%-- 							value='<%=ykctCategoryName%>'/> --%>
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<%-- 						<liferay-ui:search-container-column-text name="ykct-category-name"> --%>
<%-- 							<liferay-ui:message key="ungraded"/> --%>
<%-- 						</liferay-ui:search-container-column-text> --%>
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
				
				<liferay-ui:search-container-column-text name="ykct-category-name" title='<%=LanguageUtil.get(locale, "view") %>'  
					value='<%=(ykctCategory != null) ? ykctCategory.getCategoryName() : "Ch&#432;a ph&#226;n lo&#7841;i"%>'/>
						
				<c:if test="<%=YKCTEntryPermission.contains(permissionChecker, groupId, YKCTEntryPermission.UPDATE_YKCT) %>">
					<liferay-ui:search-container-column-text name="edit">															
						<liferay-ui:icon image="edit" message="edit" url="<%= editURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
				
				<c:if test="<%=YKCTEntryPermission.contains(permissionChecker, groupId, YKCTEntryPermission.DELETE_YKCT) %>">
					<liferay-ui:search-container-column-text name="delete">													
						<liferay-portlet:actionURL  name="deleteYKCTEntry" var="deleteEntryURL">
							<liferay-portlet:param name="entryId" value="<%=String.valueOf(ykctEntry.getEntryId())%>"/>
							<portlet:param name="redirectURL" value="<%=ykctAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteEntryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>				
				
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>	
</div>
<aui:script>
	var A = AUI();
	
	var advanceSearchFormWrapper = A.one('#ykct_advance_search');
	
	if(<%=advancedSearch %>){
	
		advanceSearchFormWrapper.show();
		
		var ykctAdvancedSearchInput = A.one('#<portlet:namespace/>ykctAdvancedSearchInput');
		
		if(ykctBasicSearchInput){
		
			ykctAdvancedSearchInput.focus();
		}
	}else{
	
		var ykctBasicSearchInput = A.one('#<portlet:namespace/>ykctBasicSearchInput');
		
		if(ykctBasicSearchInput){
			
			ykctBasicSearchInput.focus();
		}
	}
	
	function openAdvancedSearch(){
	
		var advancedSearchWrapper = A.one('#ykct_advance_search');
		
		if(advancedSearchWrapper){
		
			var advancedSearch = false;
					
			if(!advancedSearchWrapper.hasClass('aui-helper-hidden')){
				
				advancedSearch = true;
			}
			
			var ykctBasicSearchInput = A.one('#<portlet:namespace/>ykctBasicSearchInput');
			
			var ykctAdvancedSearchInput = A.one('#<portlet:namespace/>ykctAdvancedSearchInput');
			
			if(ykctBasicSearchInput && ykctAdvancedSearchInput){
				
				var ykctBasicSearchKeyword = ykctBasicSearchInput.val();
				
				var ykctAdvancedSearchKeyword = ykctAdvancedSearchInput.val();
				
				if(advancedSearch){
					advancedSearchWrapper.hide();
					ykctBasicSearchInput.focus();
					ykctBasicSearchInput.val(ykctAdvancedSearchKeyword);
					
				}else{
					advancedSearchWrapper.show();
					ykctAdvancedSearchInput.focus();
					ykctAdvancedSearchInput.val(ykctBasicSearchKeyword);
				}
			}
		}
	}
	
	function closeAdvancedSearch(){
		var advancedSearchWrapper = A.one('#ykct_advance_search');
		
		if(advancedSearchWrapper){
			advancedSearchWrapper.hide();
		}
	}
	
	Liferay.provide(
		window,
		'showYKCTPreviewDialog',
		function(ykctEntryId) {
			
			A.DialogManager.hideAll();
								
			var ykctPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(ykctPreviewRenderURL){
				
				ykctPreviewRenderURL.setPortletId('<%=portletId %>');
				ykctPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				ykctPreviewRenderURL.setParameter('jspPage', '/html/ykctadmin/ykct_entry/ykct_preview.jsp');
				ykctPreviewRenderURL.setParameter('ykctEntryId', ykctEntryId);
				ykctPreviewRenderURL.setDoAsGroupId('<%=groupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '#<portlet:namespace/>ykctUploadSettingsBtn',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true
					},
					id: '<portlet:namespace/>ykctPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "ykct-preview-content") %>',
					uri: ykctPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
	
	Liferay.provide(
		window,
		'showYKCTUpdateForm',
		function(ykctEntryId) {
											
			var ykctUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(ykctUpdateFormURL){
				
				ykctUpdateFormURL.setPortletId('<%=portletId %>');
				ykctUpdateFormURL.setWindowState('<%=LiferayWindowState.MAXIMIZED.toString() %>');
				ykctUpdateFormURL.setParameter('jspPage', '/html/ykctadmin/ykct_entry/ykct_update_form.jsp');
				ykctUpdateFormURL.setParameter('entryId', ykctEntryId);
				ykctUpdateFormURL.setDoAsGroupId('<%=groupId %>');
			}
			
			window.location = ykctUpdateFormURL;					
		},
		['aui-base']
	);
</aui:script>