<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Category"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.conversation.permission.CO_CategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int threadCategoryIndex = 0;

	long currentCategoryId = ParamUtil.getLong(request, "currentCategoryId",0L);
	
	CO_Category currentCategory = null;
	
	if(currentCategoryId > 0){
		
		currentCategory = CO_CategoryLocalServiceUtil.getCO_Category(currentCategoryId);
	}

	String coCategoryCommand = ParamUtil.getString(request, "coCategoryCommand",StringPool.BLANK);
	
	List<CO_Category> coCategoryList = CO_CategoryLocalServiceUtil.findByGroup(scopeGroupId);
%>

<c:if test='<%=Validator.equals(coCategoryCommand, "updateCategory")%>'>

	<liferay-portlet:renderURL var="categoryAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="COCategories"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:actionURL var="updateCOCategoryURL" name="updateCOCategory">
		<liferay-portlet:param name="categoryId" value="<%=String.valueOf(currentCategoryId) %>"/>
		<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="COCategories"/>
		<liferay-portlet:param name="redirectURL" value="<%=categoryAdminHomePageURL %>"/>
	</liferay-portlet:actionURL>
						
	<div class="co_category_update_form" align="center">
		<aui:form name="co_category_update_form"  method="post" action="<%=updateCOCategoryURL%>">
			<table>
				<tr>
					<td>
						<liferay-ui:message key="co-category-name" />(*)
					</td>
					
					<td>
						<aui:input type="text" name="categoryName" label="" 
									value='<%= currentCategory != null ? currentCategory.getCategoryName() : ""%>'>
							<aui:validator name="required" />
						</aui:input>
					</td>
				</tr>								
				<tr>
					<td>
						<liferay-ui:message key="co-category-desc"/>
					</td>
					
					<td>
						<aui:input type="textarea" name="categoryDesc" label="" 
									value='<%= currentCategory != null ? currentCategory.getCategoryDesc(): ""%>'/>
					</td>
				</tr>
				
				<tr>
					<td>
						<liferay-ui:message key=""/>
					</td>
					
					<td>			
						<div class="button_row">												
							<c:if test="<%=CO_CategoryPermission.contains(permissionChecker, scopeGroupId, CO_CategoryPermission.UPDATE_CATEGORY) %>">
								<aui:button type="button" value="save" onClick='saveCategory();'/>
							</c:if>							
							
							<aui:button type="button" value="cancel" href="<%=categoryAdminHomePageURL %>"/>
						</div>
					</td>
				</tr>
			</table>
		</aui:form>
	</div>
</c:if>

<div class="co_thread_management">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div>
				<c:if test="<%=CO_CategoryPermission.contains(permissionChecker, scopeGroupId, CO_CategoryPermission.UPDATE_CATEGORY)%>">
									
					<liferay-portlet:renderURL var="addNewCoCategoryURL">
						<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp"/>
						<liferay-portlet:param name="tabs1" value="COCategories"/>
						<liferay-portlet:param name="coCategoryCommand" value="updateCategory"/>
					</liferay-portlet:renderURL>
					
					<aui:button type="button" value="add-co-category" href="<%=addNewCoCategoryURL %>"/>
				</c:if>
				
				<c:if test="<%=CO_CategoryPermission.contains(permissionChecker, scopeGroupId, CO_CategoryPermission.CATEGORY_PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=CO_Category.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>
		</div>
	</div>
</div>

<div id="co_category_management">
																			
	<liferay-portlet:renderURL varImpl="categorySearchCtnImplURL" >
		<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="COCategories"/>
	</liferay-portlet:renderURL>

	<liferay-ui:search-container emptyResultsMessage="no-co-category-found" delta="10" iteratorURL="<%=categorySearchCtnImplURL %>">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(coCategoryList, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=coCategoryList.size() %>"
		>			
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row className="CO_Category" keyProperty="categoryId" modelVar="coCategory" >
			
			<%
				threadCategoryIndex ++;
			%>
																			
			<liferay-portlet:renderURL var="editCategoryURL" >
				<liferay-portlet:param name="currentCategoryId" value="<%=String.valueOf(coCategory.getCategoryId())%>"/>
				<liferay-portlet:param name="coCategoryCommand" value="updateCategory"/>
				<liferay-portlet:param name="tabs1" value="COCategories"/>
			</liferay-portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(threadCategoryIndex)%>" href="<%=editCategoryURL %>"/>
									
			<liferay-ui:search-container-column-text name="co-category-name" value="<%=coCategory.getCategoryName() %>" href="<%=editCategoryURL %>"/>
			
			<liferay-ui:search-container-column-text name="co-category-desc" value="<%=coCategory.getCategoryDesc() %>" href="<%=editCategoryURL %>"/>
			
			<liferay-ui:search-container-column-text name="Create-date" value="<%=dateTimeFormat.format(coCategory.getCreateDate())%>"/>
			
			<liferay-ui:search-container-column-text name="User" value="<%=UserLocalServiceUtil.getUser(coCategory.getUserId()).getFullName()%>"/>
			
			<liferay-ui:search-container-column-text name="edit">
				<c:if test="<%=CO_CategoryPermission.contains(permissionChecker, scopeGroupId, CO_CategoryPermission.UPDATE_CATEGORY) %>">															
					<liferay-ui:icon image="edit" message="edit" url="<%= editCategoryURL %>" />
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-portlet:renderURL var="categoryAdminHomePageURL">
				<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp"/>
				<liferay-portlet:param name="tabs1" value="COCategories"/>
			</liferay-portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="delete">
				<c:if test="<%=CO_CategoryPermission.contains(permissionChecker, scopeGroupId, CO_CategoryPermission.DELETE_CATEGORY) %>">										
					<liferay-portlet:actionURL  name="deleteCOCategory" var="deleteCOCategoryURL">
<%-- 						<portlet:param name="currentCategoryId" value="<%=String.valueOf(coCategory.getCategoryId())%>"/> --%>
						<portlet:param name="categoryId" value="<%=String.valueOf(coCategory.getCategoryId())%>"/>
						<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
					</liferay-portlet:actionURL>
					
					<liferay-ui:icon-delete url="<%= deleteCOCategoryURL %>" />					
				</c:if>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

<aui:script use='aui-form-validator,aui-overlay-context-panel'>
	
	window.validator = new A.FormValidator({

        boundingBox: document.<portlet:namespace />co_category_update_form,

        fieldContainer: 'span',
        validateOnBlur: false,
        selectText: false,

        rules: {
            <portlet:namespace />categoryName: {
                required: true,
                rangeLength: ['3','150']
            },
            <portlet:namespace />categoryDesc: {
                required: false,
                rangeLength: ['0','300']
            }
        },
        fieldStrings: {
            <portlet:namespace />categoryName: {
                required: 'Please enter a valid name'
            }
        }
    });

</aui:script>

<aui:script>

	function saveCategory () {
	
		window.validator.validate();
		
		if (!window.validator.hasErrors()) {

			submitForm(document.<portlet:namespace />co_category_update_form);			
		}
	};
	
	function cancelForm(){
	    var url = '<liferay-portlet:renderURL>';	   	 		        
			url += '<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp" />';
			url += '<liferay-portlet:param name="tabs1" value="COCategories"/>';
	        url += '</liferay-portlet:renderURL>';
	    window.location = url;
	}
</aui:script>