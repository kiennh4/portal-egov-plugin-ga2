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
	int tthcLevelIndex = 0;
	
	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		tthcLevelIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	long levelId = ParamUtil.getLong(request, "levelId",0L);

	//Tu khoa tim kiem 
	String levelSearchKeyword = ParamUtil.getString(request, "levelSearchKeyword");

	String levelCommand = ParamUtil.getString(request, "levelCommand");
	
	TTHC_Category tthcLevel = null;
	
	if(levelId > 0){		
		tthcLevel = TTHC_CategoryLocalServiceUtil.getTTHC_Category(levelId);
	}
	
	//Ket qua tim kiem theo keyword
	List<TTHC_Category> tthcLevelList = TTHC_CategoryLocalServiceUtil.findByKeyword(scopeGroupId,
		TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID, levelSearchKeyword,0,-1);
	
%>
		
<liferay-portlet:renderURL var="tthclevelAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_category_admin/tthc_category_admin.jsp" />
	<liferay-portlet:param name="tabs1" value="TTHCLevels"/>
</liferay-portlet:renderURL>
		
<liferay-portlet:renderURL var="updateLevelRenderURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_category_admin/tthc_category_admin.jsp" />
	<liferay-portlet:param name="tabs1" value="TTHCLevels"/>
	<liferay-portlet:param name="levelCommand" value="updateLevel"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="updateLevelActionURL" name="updateCategory">
	<liferay-portlet:param name="redirectURL" value="<%=tthclevelAdminURL%>" />
</liferay-portlet:actionURL>

<div class="tthc-category-admin">					
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">	
						
			<div class="add-tthc-category-button" align="left">
				<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.ADD_CATEGORY) %>">
					<aui:button type="button" value="add-tthc-level" href="<%=updateLevelRenderURL %>"/>
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
			
				<aui:form name="tthc_category_search_form" method="post" action="<%=tthclevelAdminURL %>">
					<input type="text" id="<portlet:namespace/>levelSearchInput" name="levelSearchKeyword" value='<%= levelSearchKeyword%>'/>
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=tthclevelAdminURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
	
	<c:if test='<%=Validator.equals(levelCommand, "updateLevel")%>'>
		<div class="tthc-category-update-form" align="center">
			<br/>
			<aui:form name="tthc_level_update_form" method="post" action="<%=updateLevelActionURL%>">
				<table>				
					<tr>
						<td><liferay-ui:message key="tthc-level-name"/> (<liferay-ui:message key="required"/>)</td>
						<td>
							<aui:input type="text" name="categoryName" label="" 
											value='<%= tthcLevel != null ? tthcLevel.getCategoryName() : ""%>'/>
						</td>
					</tr>		
															
					<tr>
						<td><liferay-ui:message key="display-priority"/></td>
						<td>
							<aui:input type="text" name="displayPriority" label="" value='<%= tthcLevel != null ? tthcLevel.getDisplayPriority() : "0"%>'>
								<aui:validator name="digits"/>
							</aui:input>
						</td>
					</tr>
											
					<tr>
						<td><liferay-ui:message key="tthc-level-desc"/></td>
						<td>
							<aui:input type="textarea" name="categoryDesc" label="" 
										value='<%= tthcLevel != null ? tthcLevel.getCategoryDesc(): ""%>'/>
						</td>
					</tr>
																												
					<tr>
						<td><liferay-ui:message key=""/></td>
						
						<td>
							<div class="aui-button-holder">			
								<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.ADD_CATEGORY) %>">
									<aui:button type="submit" value="save"/>
								</c:if>							
								<aui:button type="button" value="cancel" href="<%=tthclevelAdminURL %>"/>
							</div>
						</td>
					</tr>
				</table>
	
				<aui:input type="hidden" name="categoryId"  value="<%=levelId%>" />
				<aui:input type="hidden" name="categoryTypeId"  value="<%=TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID %>" />				
			</aui:form>	
		</div>
	</c:if>
	
	<div class="tthc-category-search-container">
		
		<liferay-ui:search-container emptyResultsMessage="no-entry-found">
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(tthcLevelList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=tthcLevelList.size() %>"
			>			
			</liferay-ui:search-container-results>
				
			<liferay-ui:search-container-row className="TTHC_Category" keyProperty="categoryId" modelVar="tthcCategory" >
				
				<%
					tthcLevelIndex ++;
					int tthcCounter = TTHC_EntryLocalServiceUtil.countByLevelAndGroup(tthcCategory.getCategoryId(), scopeGroupId);
				%>
																									
				<liferay-portlet:renderURL var="editCategoryURL" >
					<liferay-portlet:param name="jspPage" value="/html/tthc_category_admin/tthc_category_admin.jsp" />
					<liferay-portlet:param name="tabs1" value="TTHCLevels"/>
					<liferay-portlet:param name="levelCommand" value="updateLevel"/>
					<liferay-portlet:param name="levelId" value="<%=String.valueOf(tthcCategory.getCategoryId())%>"/>
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(tthcLevelIndex) %>" href="<%=editCategoryURL %>"/>
																	
				<liferay-ui:search-container-column-text name="tthc-level-name" value="<%=tthcCategory.getCategoryName() %>" href="<%=editCategoryURL %>"/>
					
				<liferay-ui:search-container-column-text name="TTHC" value="<%=String.valueOf(tthcCounter) %>"/>
								
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(tthcCategory.getCreateDate())%>"/>
					
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=UserLocalServiceUtil.getUser(tthcCategory.getUserId()).getFullName()%>"/>
					
				<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.UPDATE_CATEGORY) %>">
					<liferay-ui:search-container-column-text name="edit">																	
						<liferay-ui:icon image="edit" message="edit" url="<%= editCategoryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
															
				<c:if test="<%=TTHCCategoryPermission.contains(permissionChecker, scopeGroupId, TTHCCategoryPermission.DELETE_CATEGORY) %>">										
					<liferay-portlet:actionURL  name="deleteCategory" var="deleteCategoryURL">
						<portlet:param name="categoryId" value="<%=String.valueOf(tthcCategory.getCategoryId())%>"/>
						<portlet:param name="redirectURL" value="<%=tthclevelAdminURL%>"/>
					</liferay-portlet:actionURL>
					<liferay-ui:search-container-column-text name="delete">	
						<liferay-ui:icon-delete url="<%= deleteCategoryURL %>" />	
					</liferay-ui:search-container-column-text>				
				</c:if>
					
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=false %>" />
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var levelSearchInput = A.one('#<portlet:namespace/>levelSearchInput');
		
		if(levelSearchInput){
			levelSearchInput.focus();
		}
		
		if(<%=Validator.equals(levelCommand, "updateLevel")%>){
		
			var levelNameInput = A.one('#<portlet:namespace />categoryName');
			
			if(levelNameInput){
				levelNameInput.focus();
			}
	
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />tthc_level_update_form,
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
