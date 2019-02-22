<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.permission.PropositionCategoryPermission"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//TypeId tuong ung voi Uy ban tham tra noi dung du thao
	int categoryTypeId = PropositionConstants.VERIFICATION_DEPARTMENT_CATEGORY_TYPE_ID;
	
	String categoryCommand = ParamUtil.getString(request, "categoryCommand",StringPool.BLANK);

	//Danh sach uy ban tham tra
	List<PropositionCategory> categoryList = PropositionCategoryLocalServiceUtil.findByTypeAndGroup(scopeGroupId, categoryTypeId);
	
	int categoryIndex = 0;
%>
																											
<liferay-portlet:renderURL var="verificationDepartmentURL" >
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_category_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="VerificationDepartments"/>
</liferay-portlet:renderURL>

<div class="proposition_category_admin_content">
	
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			<c:if test="<%=PropositionCategoryPermission.contains(permissionChecker, scopeGroupId, PropositionCategoryPermission.UPDATE)%>">	
				<div class="button_row" align="left">
																															
					<liferay-portlet:renderURL var="addVerificationDepartmentURL" >
						<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_category_admin/view.jsp" />
						<liferay-portlet:param name="tabs1" value="VerificationDepartments"/>
						<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
						<liferay-portlet:param name="categoryType" value="verificationDepartment"/>
						<liferay-portlet:param name="redirectURL" value="<%=verificationDepartmentURL %>"/>
					</liferay-portlet:renderURL>
					
					<aui:button type="button" value="add-new-verification-department" href="<%=addVerificationDepartmentURL %>"/>
																
					<c:if test="<%=PropositionCategoryPermission.contains(permissionChecker, scopeGroupId, PropositionCategoryPermission.PERMISSIONS)%>">
						<liferay-security:permissionsURL
							modelResource="<%=PropositionCategory.class.getName() %>"
							modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
							resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
							var="permissionsURL"
						/>
				
						<aui:button href="<%= permissionsURL %>" value="permissions" />
					</c:if>
				</div>
			</c:if>
		</div>
	</div>
	
	<c:if test='<%=Validator.equals(categoryCommand, "updateCategory") %>'>
		<%@ include file="/html/proposition_feedback_category_admin/proposition_category_update_form.jspf" %>
	</c:if>

	<liferay-portlet:renderURL varImpl="iteratorURL">
		<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_category_admin/view.jsp" />
		<liferay-portlet:param name="tabs1" value="VerificationDepartments"/>
	</liferay-portlet:renderURL>
	
	<liferay-ui:search-container emptyResultsMessage="no-verification-department-found" >
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(categoryList, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=categoryList.size() %>"
		>			
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row className="PropositionCategory" keyProperty="categoryId" modelVar="category" >
			
			<%
				categoryIndex ++;
			%>
																							
			<liferay-portlet:renderURL var="editCategoryURL" >
				<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_category_admin/view.jsp" />
				<liferay-portlet:param name="tabs1" value="VerificationDepartments"/>
				<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
				<liferay-portlet:param name="categoryType" value="verificationDepartment"/>
				<liferay-portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId())%>"/>
				<liferay-portlet:param name="redirectURL" value="<%=verificationDepartmentURL %>"/>
			</liferay-portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(categoryIndex) %>" href="<%=editCategoryURL %>"/>
									
			<liferay-ui:search-container-column-text name="proposition-department-name" value="<%=category.getCategoryName() %>" href="<%=editCategoryURL %>"/>
			
			<liferay-ui:search-container-column-text name="Proposition-count" value="<%=String.valueOf(category.getPropositionCount()) %>"/>
						
			<liferay-ui:search-container-column-text name="create-date" value="<%=dateFormat.format(category.getCreateDate())%>"/>
			
			<liferay-ui:search-container-column-text name="User" value="<%=UserLocalServiceUtil.getUser(category.getUserId()).getFullName()%>"/>
			
			<liferay-ui:search-container-column-text name="edit">
				<c:if test="<%=PropositionCategoryPermission.contains(permissionChecker, scopeGroupId, PropositionCategoryPermission.UPDATE) %>">															
					<liferay-ui:icon image="edit" message="edit" url="<%= editCategoryURL %>" />
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="delete">
				<c:if test="<%=PropositionCategoryPermission.contains(permissionChecker, scopeGroupId, PropositionCategoryPermission.DELETE) %>">										
					<liferay-portlet:actionURL  name="deletePropositionCategory" var="deleteCategoryURL">
						<liferay-portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId())%>"/>
						<liferay-portlet:param name="redirectURL" value="<%=verificationDepartmentURL %>"/>
					</liferay-portlet:actionURL>
					
					<liferay-ui:icon-delete url="<%= deleteCategoryURL %>" />				
				</c:if>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator paginate="<%=false %>"/>
	</liferay-ui:search-container>
</div>
