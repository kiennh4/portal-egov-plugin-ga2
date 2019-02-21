<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.WeblinkCategory"%>
<%@page import="com.portal_egov.portlet.weblinks.permission.WeblinkCategoryPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks_admin/init.jsp"%>

<%

	int weblinkCategoryIndex = 0;

	//Id cua chuyen muc lay tu URL (truong hop update)
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	//Chuyen muc
	WeblinkCategory weblinkCategory = null;
	
	if(categoryId > 0L){//truong hop update chuyen muc
		
		weblinkCategory = WeblinkCategoryLocalServiceUtil.getWeblinkCategory(categoryId);
	}
	
	String categoryCommand = ParamUtil.getString(request, "categoryCommand");
	
	//Tu khoa nhap vao o tim kiem chuyen muc
	String weblinkCategorySearchKeyword = ParamUtil.getString(request, "weblinkCategorySearchKeyword");
		
	//Danh sach ket qua tim kiem chuyen muc theo tu khoa
	List<WeblinkCategory> weblinkCategoryList = WeblinkCategoryLocalServiceUtil.findByKeyword(groupId, weblinkCategorySearchKeyword, 0, -1);
%>

<div class="weblink_admin">

	<liferay-portlet:renderURL var="weblinkCategoryAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/weblinks_admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="WeblinkCategories"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL var="weblinkCategoryUpdateFormURL">
		<liferay-portlet:param name="jspPage" value="/html/weblinks_admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="WeblinkCategories"/>
		<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
	</liferay-portlet:renderURL>
	
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="add_new_category_button" align="left">
				<c:if test="<%=WeblinkCategoryPermission.contains(permissionChecker, groupId, WeblinkCategoryPermission.ADD)%>">
					<aui:button type="button" value="add-new-weblink-category" href="<%=weblinkCategoryUpdateFormURL %>"/>
				</c:if>
				
				<c:if test="<%=WeblinkCategoryPermission.contains(permissionChecker, groupId, WeblinkCategoryPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=WeblinkCategory.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="weblink_category_search_form" align="right">
				<aui:form name="weblink_category_search_form" method="post" action="<%=weblinkCategoryAdminHomePageURL %>">
				
					<input type="text" id="<portlet:namespace/>categorySearchInput" name="weblinkCategorySearchKeyword" value='<%= weblinkCategorySearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=weblinkCategoryAdminHomePageURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
		
	<c:if test='<%=Validator.equals(categoryCommand, "updateCategory")%>'>
		
		
		<div class="weblink-update-form" align="center">
		
			<liferay-portlet:actionURL name="updateWeblinkCategory" var="updateWeblinkCategoryActionURL">
				<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
				<liferay-portlet:param name="redirectURL" value="<%=weblinkCategoryAdminHomePageURL %>"/>
			</liferay-portlet:actionURL>
			
			<aui:form name="weblink_category_update_form"  method="post" action="<%=updateWeblinkCategoryActionURL%>">
				<br/>
				<table>
					<tr>
						<td><liferay-ui:message key="weblink-category-name"/> (<liferay-ui:message key="required"/>)</td>
						<td>
							
							<aui:input  name="weblinkCategoryName" type="text" label="" 
										value='<%=(weblinkCategory != null) ? weblinkCategory.getCategoryName() : "" %>'/>
						</td>
					</tr>								
					<tr>
						<td><liferay-ui:message key="weblink-category-desc"/></td>
						
						<td>
							<aui:input  name="weblinkCategoryDesc" type="textarea" label=""
										value='<%=(weblinkCategory != null) ? weblinkCategory.getCategoryName() : "" %>'/>
						</td>
					</tr>
					<tr>
						<td>
							<liferay-ui:message key=""/>
						</td>
						
						<td>			
							<div class="aui-button-holder">												
								<c:if test="<%=WeblinkCategoryPermission.contains(permissionChecker, groupId, WeblinkCategoryPermission.UPDATE) %>">
									<aui:button type="submit" value="save" />
								</c:if>							
								<aui:button type="button" value="cancel" href="<%=weblinkCategoryAdminHomePageURL %>"/>
							</div>
						</td>
					</tr>
				</table>
				<aui:input type="hidden" name="categoryId"  value="<%=categoryId%>" />
			</aui:form>
		</div>
		<br/>
	</c:if>
	
	<div class="weblink_categories">
		
		<liferay-ui:search-container emptyResultsMessage="no-entry-found" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(weblinkCategoryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=weblinkCategoryList.size() %>"
			/>			
				
			<liferay-ui:search-container-row className="WeblinkCategory" keyProperty="categoryId" modelVar="category" >
				<%
					weblinkCategoryIndex++;
					
					int weblinkCounter = WeblinkLocalServiceUtil.countByCategory(category.getCategoryId());
				%>
				<liferay-portlet:renderURL var="updateCategoryURL" >				
					<liferay-portlet:param name="jspPage" value="/html/weblinks_admin/view.jsp"/>
					<liferay-portlet:param name="tabs1" value="WeblinkCategories"/>
					<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
					<liferay-portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId())%>"/>
				</liferay-portlet:renderURL>
								
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(weblinkCategoryIndex) %>" href="<%=updateCategoryURL %>"/>
					
				<liferay-ui:search-container-column-text name="weblink-category-name" value="<%=category.getCategoryName()%>" href="<%=updateCategoryURL %>"/>
				
				<liferay-ui:search-container-column-text name="weblink-link-counter" value="<%=String.valueOf(weblinkCounter)%>" href="<%=updateCategoryURL %>"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(category.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=category.getUserName()%>"/>
				
				<liferay-ui:search-container-column-text name="edit">
					<c:if test="<%=WeblinkCategoryPermission.contains(permissionChecker, groupId, WeblinkCategoryPermission.UPDATE)%>">														
						<liferay-ui:icon image="edit" message="edit" url="<%= updateCategoryURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete">
					<c:if test="<%=WeblinkCategoryPermission.contains(permissionChecker, groupId, WeblinkCategoryPermission.DELETE)%>">															
						<liferay-portlet:actionURL  name="deleteWeblinkCategory" var="deleteWeblinkCategoryURL">
							<liferay-portlet:param name="categoryId" value="<%=String.valueOf(category.getCategoryId())%>"/>
							<liferay-portlet:param name="deleteWeblinks" value="<%=String.valueOf(false)%>"/>	
							<liferay-portlet:param name="redirectURL" value="<%=weblinkCategoryAdminHomePageURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteWeblinkCategoryURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=false %>"/>
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var categorySearchInput = A.one('#<portlet:namespace/>categorySearchInput');
		
		if(categorySearchInput){
			categorySearchInput.focus();
		}
		
		if(<%=Validator.equals(categoryCommand, "updateCategory")%>){
		
			var categoryNameInput = A.one('#<portlet:namespace />weblinkCategoryName');
			
			if(categoryNameInput){
				categoryNameInput.focus();
			}
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />weblink_category_update_form,
		
		        rules: {
		            <portlet:namespace />weblinkCategoryName: {
		                required: true,
		                rangeLength: ['3','300']
		            },
		            <portlet:namespace />weblinkCategoryDesc: {
		                required: false,
		                rangeLength: ['0','450']
		            }
		        }
		    });
		}
	});

</script>