<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.permission.TTHCCategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Category"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int tthcAudienceIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		tthcAudienceIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}

	long audienceId = ParamUtil.getLong(request, "audienceId",0L);
	
	String audienceCommand = ParamUtil.getString(request, "audienceCommand");
	
	String audienceSearchKeyword = ParamUtil.getString(request, "audienceSearchKeyword");
	
	TTHC_Category currentAudience = null;
	
	if(audienceId > 0){
		currentAudience = TTHC_CategoryLocalServiceUtil.getTTHC_Category(audienceId);
	}

	//Ket qua tim kiem theo keyword
	List<TTHC_Category> tthcAudienceList = TTHC_CategoryLocalServiceUtil.findByKeyword(scopeGroupId, 
													TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID, audienceSearchKeyword,0,-1);
%>
		
<liferay-portlet:renderURL var="tthcAudienceAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_category_admin/tthc_category_admin.jsp" />
	<liferay-portlet:param name="tabs1" value="Audiences"/>
</liferay-portlet:renderURL>
		
<liferay-portlet:renderURL var="updateAudienceRenderURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_category_admin/tthc_category_admin.jsp" />
	<liferay-portlet:param name="tabs1" value="Audiences"/>
	<liferay-portlet:param name="audienceCommand" value="updateAudience"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="updateAudienceActionURL" name="updateCategory">
	<liferay-portlet:param name="redirectURL" value="<%=tthcAudienceAdminURL%>" />
</liferay-portlet:actionURL>

<div class="tthc-category-admin">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			
			<div class="add-tthc-category-button" align="left">
				<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.ADD_CATEGORY) %>">
					<aui:button type="button" value="add-tthc-audience" href="<%=updateAudienceRenderURL %>"/>
				</c:if>
												
				<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.CATEGORY_PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%=TTHC_Category.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="tthc-category-search-form" align="right">
				
				<aui:form name="tthc_category_search_form" method="post" action="<%=tthcAudienceAdminURL %>">
				
					<input type="text" id="<portlet:namespace/>audienceSearchInput" name="audienceSearchKeyword" value='<%= audienceSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=tthcAudienceAdminURL %>"/>
				</aui:form>	
			</div>
		
		</div>
	</div>
	
	<c:if test='<%=Validator.equals(audienceCommand, "updateAudience")%>'>
	
		<div class="tthc-category-update-form" align="center">
			<br/>		
			<aui:form name="tthc_audience_update_form" method="post" action="<%=updateAudienceActionURL.toString() %>">
					
				<table>
					<tr>
						<td><liferay-ui:message key="tthc-audience-name"/> (<liferay-ui:message key="required"/>)</td>
						<td>
							<aui:input type="text" name="categoryName" label="" 
											value='<%= currentAudience != null ? currentAudience.getCategoryName() : ""%>'/>
						</td>
					</tr>	
																														
					<tr>
						<td><liferay-ui:message key="display-priority"/></td>
						<td>
							<aui:input type="text" name="displayPriority" label="" value='<%= currentAudience != null ? currentAudience.getDisplayPriority() : "0"%>'>
								<aui:validator name="digits"/>
							</aui:input>
						</td>
					</tr>
												
					<tr>
						<td><liferay-ui:message key="tthc-audience-desc"/></td>
						<td>
							<aui:input type="textarea" name="categoryDesc" label="" 
										value='<%= currentAudience != null ? currentAudience.getCategoryDesc(): ""%>'/>
						</td>
					</tr>
															
					<tr>
						<td><liferay-ui:message key=""/></td>
						
						<td>
							<div class="aui-button-holder">		
								<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.ADD_CATEGORY) %>">
									<aui:button type="submit" value="save"/>
								</c:if>							
								<aui:button type="button" value="cancel" href="<%=tthcAudienceAdminURL %>"/>
							</div>	
						</td>
					</tr>
				</table>
	
				<aui:input type="hidden" name="categoryId"  value="<%=audienceId%>" />
				<aui:input type="hidden" name="categoryTypeId"  value="<%=TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID %>" />				
			</aui:form>	
		</div>
		<br/>
	</c:if>	
	
	<div class="tthc-category-search-container">

		<liferay-ui:search-container emptyResultsMessage="no-entry-found">
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(tthcAudienceList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=tthcAudienceList.size() %>"
			>			
			</liferay-ui:search-container-results>
				
			<liferay-ui:search-container-row className="TTHC_Category" keyProperty="categoryId" modelVar="tthcCategory" >
				<%
					tthcAudienceIndex ++;
				
					int tthcCounter = TTHC_EntryLocalServiceUtil.countByAudience(tthcCategory.getCategoryId(), scopeGroupId);
				%>
																									
				<liferay-portlet:renderURL var="editCategoryURL" >
					<liferay-portlet:param name="jspPage" value="/html/tthc_category_admin/tthc_category_admin.jsp" />
					<liferay-portlet:param name="tabs1" value="Audiences"/>
					<liferay-portlet:param name="audienceCommand" value="updateAudience"/>
					<liferay-portlet:param name="audienceId" value="<%=String.valueOf(tthcCategory.getCategoryId())%>"/>
				</liferay-portlet:renderURL>
											
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(tthcAudienceIndex) %>" href="<%=editCategoryURL %>"/>
				
				<liferay-ui:search-container-column-text name="tthc-audience-name" value="<%=tthcCategory.getCategoryName() %>" href="<%=editCategoryURL %>"/>
					
				<liferay-ui:search-container-column-text name="TTHC" value="<%=String.valueOf(tthcCounter) %>"/>
								
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(tthcCategory.getCreateDate())%>"/>
					
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=UserLocalServiceUtil.getUser(tthcCategory.getUserId()).getFullName()%>"/>
					
				<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.UPDATE_CATEGORY) %>">
					<liferay-ui:search-container-column-text name="edit">														
						<liferay-ui:icon image="edit" message="edit" url="<%= editCategoryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
															
				<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.DELETE_CATEGORY) %>">										
					<liferay-ui:search-container-column-text name="delete">
						<liferay-portlet:actionURL  name="deleteCategory" var="deleteCategoryURL">
							<portlet:param name="categoryId" value="<%=String.valueOf(tthcCategory.getCategoryId())%>"/>
							<portlet:param name="redirectURL" value="<%=tthcAudienceAdminURL%>"/>
						</liferay-portlet:actionURL>
							
						<liferay-ui:icon-delete url="<%= deleteCategoryURL %>" />	
					</liferay-ui:search-container-column-text>				
				</c:if>
					
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=false %>"/>
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var audienceSearchInput = A.one('#<portlet:namespace/>audienceSearchInput');
		
		if(audienceSearchInput){
			audienceSearchInput.focus();
		}
		
		if(<%=Validator.equals(audienceCommand, "updateAudience")%>){
		
			var audienceNameInput = A.one('#<portlet:namespace />categoryName');
			
			if(audienceNameInput){
				audienceNameInput.focus();
			}
	
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />tthc_audience_update_form,
		        rules: {
		            <portlet:namespace />categoryName: {
		                required: true,
		                rangeLength: ['3','150']
		            },
		            <portlet:namespace />categoryDesc: {
		                required: false,
		                rangeLength: ['0','300']
		            }
		        }
		    });
		}
	});

</script>
