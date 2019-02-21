<%@page import="com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.permission.InquiryCategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int inquiryCategoryIndex = 0;

	//Id cua chuyen muc lay tu URL (truong hop update)
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	CitizenInquiryCategory inquiryCategory = null;
	
	if(categoryId > 0L){
		
		inquiryCategory = CitizenInquiryCategoryLocalServiceUtil.getCitizenInquiryCategory(categoryId);
	}
	
	String categoryCommand = ParamUtil.getString(request, "categoryCommand");
	
	List<CitizenInquiryCategory> inquiryCategoryList = CitizenInquiryCategoryLocalServiceUtil.getGroupCategories(groupId);
%>
<div class="inquiry-admin">
	
	<liferay-portlet:renderURL var="inquiryCategoryAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="Categories"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL var="inquiryCategoryUpdateURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="Categories"/>
		<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
	</liferay-portlet:renderURL>
		
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="add_new_category_button" align="left">
				<c:if test="<%=InquiryCategoryPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">
					<aui:button type="button" value="add-new-category" href="<%=inquiryCategoryUpdateURL %>"/>
				</c:if>
				
				<c:if test="<%=InquiryCategoryPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=CitizenInquiryCategory.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
		</div>
	</div>
			
	<div class='inquiry-update-form <%=Validator.equals(categoryCommand, "updateCategory") ? "" : "aui-helper-hidden" %>' align="center">
	
		<liferay-portlet:actionURL name="updateInquiryCategory" var="updateInquiryCategoryActionURL">
			<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
			<liferay-portlet:param name="redirectURL" value="<%=inquiryCategoryAdminURL %>"/>
		</liferay-portlet:actionURL>
		
		<aui:form name="fm"  method="post" action="<%=updateInquiryCategoryActionURL%>">
			<br/>
			<aui:model-context bean="<%= inquiryCategory %>" model="<%= CitizenInquiryCategory.class %>" />
			<table>
				<tr>
					<td><liferay-ui:message key="inquiry-category-name"/> (<liferay-ui:message key="required"/>)</td>
					<td>
						
						<aui:input  name="categoryName" label="" />
					</td>
				</tr>								
				<tr>
					<td><liferay-ui:message key="category-desc"/></td>
					
					<td>
						<aui:input  name="categoryDesc" type="textarea" label=""/>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key=""/>
					</td>
					
					<td>			
						<div class="aui-button-holder">												
							<c:if test="<%=InquiryCategoryPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">
								<aui:button type="submit" value="save" />
							</c:if>							
							<aui:button type="button" value="cancel" href="<%=inquiryCategoryAdminURL %>"/>
						</div>
					</td>
				</tr>
			</table>
		</aui:form>
	</div>
	<br/>
		
	<div class="category-list">
		
		<liferay-ui:search-container emptyResultsMessage="no-entry-found" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(inquiryCategoryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=inquiryCategoryList.size() %>"
			/>			
				
			<liferay-ui:search-container-row className="CitizenInquiryCategory" keyProperty="categoryId" modelVar="category" >
				<%
					inquiryCategoryIndex++;
					
					int inquiryCounter = CitizenInquiryLocalServiceUtil.countCategoryInquiries(category.getCategoryId());
				%>
				<liferay-portlet:renderURL var="updateCategoryURL" >				
					<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
					<liferay-portlet:param name="tabs1" value="Categories"/>
					<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
					<liferay-portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId())%>"/>
				</liferay-portlet:renderURL>
								
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(inquiryCategoryIndex) %>" href="<%=updateCategoryURL %>"/>
					
				<liferay-ui:search-container-column-text name="category-name" value="<%=category.getCategoryName()%>" href="<%=updateCategoryURL %>"/>
				
				<liferay-ui:search-container-column-text name="inquiry-counter" value="<%=String.valueOf(inquiryCounter)%>" href="<%=updateCategoryURL %>"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(category.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=category.getUserName()%>"/>
				
				<liferay-ui:search-container-column-text name="edit">
					<liferay-ui:icon image="edit" message="edit" url="<%= updateCategoryURL %>" />
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete">
					<c:if test="<%=InquiryCategoryPermission.contains(permissionChecker, groupId, ActionKeys.DELETE)%>">		
																		
						<liferay-portlet:actionURL  name="deleteInquiryCategory" var="deleteInquiryCategoryActionURL">
							<liferay-portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId())%>"/>
							<liferay-portlet:param name="redirectURL" value="<%=inquiryCategoryAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteInquiryCategoryActionURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=false %>"/>
		</liferay-ui:search-container>
	</div>
	
</div>


<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		if(<%=Validator.equals(categoryCommand, "updateCategory")%>){
		
			var categoryNameInput = A.one('#<portlet:namespace />categoryName');
			
			if(categoryNameInput){
				categoryNameInput.focus();
			}
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />fm,
		
		        rules: {
		            <portlet:namespace />categoryName: {
		                required: true,
		                rangeLength: ['3','300']
		            },
		            <portlet:namespace />categoryDesc: {
		                required: false,
		                rangeLength: ['0','450']
		            }
		        }
		    });
		}
	});

</script>