<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.ykct.permission.YKCTCategoryPermission"%>
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
String ykctCategorySearchKeyword = ParamUtil.getString(request, "ykctCategorySearchKeyword", StringPool.BLANK);

List<YKCT_Category> ykctCategoryList = YKCT_CategoryLocalServiceUtil.findByKeyword(groupId, ykctCategorySearchKeyword, -1, -1);

int ykctCategoryIndex = 0;

String categoryCommand = ParamUtil.getString(request, "categoryCommand");
%>

<liferay-portlet:renderURL var="ykctCategoryAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="ykct_category"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="ykctCategoryUpdateFormURL">
	<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp"/>
	<liferay-portlet:param name="tabs1" value="ykct_category"/>
	<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
</liferay-portlet:renderURL>

<div class="ykct_category_admin">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="add_new_ykct_category_button" align="left">
				<c:if test="<%=YKCTCategoryPermission.contains(permissionChecker, groupId, YKCTCategoryPermission.ADD_CATEGORY) %>">
					<aui:button type="button" value="add-ykct-category" href="<%=ykctCategoryUpdateFormURL %>"/>
				</c:if>
				
				<c:if test="<%=YKCTCategoryPermission.contains(permissionChecker, groupId, YKCTCategoryPermission.CATEGORY_PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%=YKCT_Category.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>
			
			<div class="ykct_category_search_form" align="right">
				<aui:form name="ykct_category_search_form" method="post" action="<%=ykctCategoryAdminURL %>">
					<input type="text" id="<portlet:namespace/>ykctCategorySearchInput" name="ykctCategorySearchKeyword" value='<%= ykctCategorySearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button type="button" value="show-all" href="<%=ykctCategoryAdminURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
	
	<c:if test='<%=Validator.equals(categoryCommand, "updateCategory")%>'>
	
		<%
		long categoryId = ParamUtil.getLong(request, "categoryId", 0L);

		YKCT_Category ykctCategory = null;

		if(categoryId > 0){
			
			ykctCategory = YKCT_CategoryLocalServiceUtil.getYKCT_Category(categoryId);
		}
		%>
		<liferay-portlet:renderURL var="ykctCategoryAdminHomePageURL">
			<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp"/>
			<liferay-portlet:param name="tabs1" value="ykct_category"/>
			<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:actionURL name="updateYKCTCategory" var="updateYKCTCategoryActionURL">
			<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
			<liferay-portlet:param name="redirectURL" value="<%=ykctCategoryAdminHomePageURL %>"/>
		</liferay-portlet:actionURL>
			
		<div class="ykct-category-update-form" align="center">
			<aui:form name="ykct_category_update_form"  method="post" action="<%=updateYKCTCategoryActionURL%>">
				</br>
				<table>
					<tr>
						<td><liferay-ui:message key="ykct-category-name"/> (<liferay-ui:message key="required"/>)</td>
						<td>
							
							<aui:input  name="ykctCategoryName" type="text" label="" 
										value='<%=(ykctCategory != null) ? ykctCategory.getCategoryName() : "" %>'/>
						</td>
					</tr>
					
					<tr>
						<td><liferay-ui:message key="ykct-category-desc"/></td>
						
						<td>
							<aui:input  name="ykctCategoryDesc" type="textarea" label=""
										value='<%=(ykctCategory != null) ? ykctCategory.getCategoryDesc() : "" %>'/>
						</td>
					</tr>
					
					<tr>
						<td>
							<liferay-ui:message key=""/>
						</td>
						
						<td>			
							<div class="aui-button-holder">												
								<c:if test="<%=YKCTCategoryPermission.contains(permissionChecker, groupId, YKCTCategoryPermission.UPDATE_CATEGORY) %>">
									<aui:button type="submit" value="save" />
								</c:if>							
								<aui:button type="button" value="cancel" href="<%=ykctCategoryAdminHomePageURL %>"/>
							</div>
						</td>
					</tr>
				</table>
			</aui:form>
		</div>
	</c:if>
	
	<div class="ykct_category_search_results">
		<liferay-portlet:renderURL varImpl="ykctCategoryAdminImplURL">
			<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp"/>
			<liferay-portlet:param name="tabs1" value="ykct_category"/>
			<liferay-portlet:param name="ykctCategorySearchKeyword" value="<%=ykctCategorySearchKeyword %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container emptyResultsMessage="no-ykct-entry-found" iteratorURL="<%=ykctCategoryAdminImplURL %>" delta="20" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(ykctCategoryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=ykctCategoryList.size() %>"
			>
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="YKCT_Category" keyProperty="categoryId" modelVar="ykctCategory" >
				<%
					ykctCategoryIndex ++;
				
					String ykctCategoryName = ykctCategory.getCategoryName();
					
					String ykctCategoryDesc = ykctCategory.getCategoryDesc();
				%>
				
				<liferay-portlet:renderURL var="updateCategoryURL" >				
					<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp"/>
					<liferay-portlet:param name="tabs1" value="ykct_category"/>
					<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
					<liferay-portlet:param name="categoryId" value="<%=String.valueOf(ykctCategory.getCategoryId())%>"/>
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" title='<%=LanguageUtil.get(locale, "view") %>' 
						value="<%=String.valueOf(ykctCategoryIndex) %>" href="<%=updateCategoryURL %>"/>
						
				<liferay-ui:search-container-column-text name="ykct-category-name" title='<%=LanguageUtil.get(locale, "view") %>' 
						value="<%= ykctCategoryName%>" href="<%=updateCategoryURL %>"/>
						
				<liferay-ui:search-container-column-text name="ykct-category-desc" title='<%=LanguageUtil.get(locale, "view") %>' 
						value="<%= ykctCategoryDesc%>" href="<%=updateCategoryURL %>"/>
						
				<c:if test="<%=YKCTCategoryPermission.contains(permissionChecker, groupId, YKCTCategoryPermission.UPDATE_CATEGORY) %>">
					<liferay-ui:search-container-column-text name="edit">															
						<liferay-ui:icon image="edit" message="edit" url="<%= updateCategoryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
				
				<c:if test="<%=YKCTCategoryPermission.contains(permissionChecker, groupId, YKCTCategoryPermission.DELETE_CATEGORY) %>">
					<liferay-ui:search-container-column-text name="delete">													
						<liferay-portlet:actionURL  name="deleteYKCTCategory" var="deleteCategoryURL">
							<liferay-portlet:param name="categoryId" value="<%=String.valueOf(ykctCategory.getCategoryId())%>"/>
							<liferay-portlet:param name="deleteYKCT_Entry" value="<%=String.valueOf(false)%>"/>
							<portlet:param name="redirectURL" value="<%=ykctCategoryAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteCategoryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>					
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var categorySearchInput = A.one('#<portlet:namespace/>ykctCategorySearchInput');
		
		if(categorySearchInput){
			categorySearchInput.focus();
		}
		
		if(<%=Validator.equals(categoryCommand, "updateCategory")%>){
		
			var categoryNameInput = A.one('#<portlet:namespace />ykctCategoryName');
			
			if(categoryNameInput){
				categoryNameInput.focus();
			}
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />ykct_category_update_form,
		
		        rules: {
		            <portlet:namespace />ykctCategoryName: {
		                required: true,
		                rangeLength: ['3','300']
		            },
		            <portlet:namespace />ykctCategoryDesc: {
		                required: false,
		                rangeLength: ['0','450']
		            }
		        }
		    });
		}
	});

</script>