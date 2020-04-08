<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.legal_faq.permission.LegalFAQCategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String categoryCommand = ParamUtil.getString(request, "categoryCommand",StringPool.BLANK);

	LegalFAQCategory currentCategory = null;
	
	long categoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	if(categoryId >0){
		currentCategory = LegalFAQCategoryLocalServiceUtil.getCategory(categoryId);
	}
	
	String faqCategorySearchKeyword = ParamUtil.getString(request, "faqCategorySearchKeyword");
	
	List<LegalFAQCategory> faqCategoryList = LegalFAQCategoryLocalServiceUtil.findByKeyword(scopeGroupId, faqCategorySearchKeyword, 0, -1);
	
	int faqCategoryIndex = 0;
%>
	
	<liferay-portlet:renderURL var="faqCategoryAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp" />
		<liferay-portlet:param name="tabs1" value="FAQCategories"/>
	</liferay-portlet:renderURL>
			
	<liferay-portlet:renderURL var="addNewFaqCategoryURL">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp" />
		<liferay-portlet:param name="tabs1" value="FAQCategories"/>
		<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
	</liferay-portlet:renderURL>
			
	<liferay-portlet:actionURL var="updateFAQCategoryURL" name="updateFAQCategory">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp" />
		<liferay-portlet:param name="ridirectURL" value="<%=faqCategoryAdminHomePageURL %>" />
	</liferay-portlet:actionURL>
	
	<div class="legal-faq-admin-toolbar">
		<div class="lfr-header-row">
			<div class="lfr-header-row-content">						
				<c:if test="<%=LegalFAQCategoryPermission.contains(permissionChecker, scopeGroupId, LegalFAQCategoryPermission.UPDATE) %>">	
					<div class="add-category-btn-container" align="left">
						<aui:button type="button" value="add-faq-category" href="<%=addNewFaqCategoryURL %>"/>
											
						<c:if test="<%=LegalFAQCategoryPermission.contains(permissionChecker, scopeGroupId, LegalFAQCategoryPermission.PERMISSIONS)%>">
							<liferay-security:permissionsURL
								modelResource="<%=LegalFAQCategory.class.getName() %>"
								modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
								resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
								var="permissionsURL"
							/>
					
							<aui:button href="<%= permissionsURL %>" value="permissions" />
						</c:if>
					</div>			
				</c:if>

				
				<div class="faq-category-search-form" align="right">
					<aui:form name="faq_category_search_form" method="post" action="<%=faqCategoryAdminHomePageURL %>">
						
						<input type="text" id="<portlet:namespace/>faqCategorySearchInput" name="faqCategorySearchKeyword" value='<%= faqCategorySearchKeyword%>'/>
						
						<aui:button type="submit" value="search"/>
						
						<aui:button type="button" value="show-all" href="<%=faqCategoryAdminHomePageURL %>"/>
					</aui:form>	
				</div>
			</div>
		</div>
	</div>
	
	<c:if test='<%=Validator.equals(categoryCommand, "updateCategory")%>'>
		<div class="faq_category_update_form" align="center">
			<aui:form name="faq_category_update_form"  method="post" action="<%=updateFAQCategoryURL%>">
				<br/>
				<table>
					<tr>
						<td><liferay-ui:message key="faq-category-name"/> (<liferay-ui:message key="required"/>)</td>
						<td>
							<aui:input type="text" name="categoryName" label="" 
										value='<%= currentCategory != null ? currentCategory.getCategoryName() : ""%>'/>
						</td>
					</tr>								
					<tr>
						<td><liferay-ui:message key="faq-category-desc"/></td>
						
						<td>
							<%-- <aui:input type="textarea" name="categoryDesc" label="" 
										value='<%= currentCategory != null ? currentCategory.getCategoryDesc(): ""%>'/> --%>
							 <textarea name="categoryDesc" id="categoryDesc" style="float: left; height: 28px;">${categoryDesc }</textarea>							 
						</td>
					</tr>
					<tr>
						<td>
							<liferay-ui:message key=""/>
						</td>
						
						<td>			
							<div class="button_row">
																			
								<c:if test="<%=LegalFAQCategoryPermission.contains(permissionChecker, scopeGroupId, LegalFAQCategoryPermission.UPDATE) %>">
									<aui:button type="submit" value="save" />
								</c:if>	
								<input type="button" onclick="callDLUploader('categoryDesc')" value="Chọn ảnh đại diện" />							
								<aui:button type="button" value="cancel" href="<%=faqCategoryAdminHomePageURL %>"/>
								
							</div>
						</td>
					</tr>
				</table>
				<aui:input type="hidden" name="categoryId"  value="<%=categoryId%>" />
			</aui:form>
			
		<liferay-portlet:renderURL portletName="15"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>"
			var="selectDLURL">
			<liferay-portlet:param name="struts_action"
				value="/journal/select_document_library" />
			<liferay-portlet:param name="currentURL"
				value="<%=PortalUtil.getCurrentURL(renderRequest)%>" />
			<liferay-portlet:param name="groupId"
				value="<%=String.valueOf(themeDisplay.getScopeGroupId())%>" />
		</liferay-portlet:renderURL>


		<script type="text/javascript">
var <portlet:namespace/>popup;
var _15_selectDocumentLibrary;
                
function callDLUploader(fieldNameDL){
       <portlet:namespace/>popup = window.open('<%=selectDLURL%>','_blank','directories=no,height=640,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=680');

       <portlet:namespace/>popup.focus();
       _15_selectDocumentLibrary=function(url){
              <portlet:namespace/>popup.close();
              jQuery("#" + fieldNameDL).val(url);
       }
}
</script>
		</div>
		<br/>
	</c:if>

	<div>
		<liferay-ui:search-container emptyResultsMessage="no-entry-found">
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(faqCategoryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=faqCategoryList.size() %>"
			>			
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="LegalFAQCategory" keyProperty="categoryId" modelVar="faqCategory" >
				
				<%
					faqCategoryIndex ++;
					int faqCounter = LegalFAQEntryLocalServiceUtil.countByCategory(companyId, faqCategory.getCategoryId());
				%>
																							
				<liferay-portlet:renderURL var="editCategoryURL" >
					<liferay-portlet:param name="categoryId" value="<%=String.valueOf(faqCategory.getCategoryId())%>"/>
					<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
					<liferay-portlet:param name="tabs1" value="FAQCategories"/>
				</liferay-portlet:renderURL>
										
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(faqCategoryIndex)%>" href="<%=editCategoryURL %>"/>
				
				<liferay-ui:search-container-column-text name="faq-category-name" value="<%=faqCategory.getCategoryName() %>" href="<%=editCategoryURL %>"/>
				
				<liferay-ui:search-container-column-text name="faq-counter" value="<%=String.valueOf(faqCounter)%>"/>
							
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(faqCategory.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=UserLocalServiceUtil.getUser(faqCategory.getUserId()).getFullName()%>"/>
				
				<liferay-ui:search-container-column-text name="profile-picture"><img height="42" width="42" src="<%=faqCategory.getCategoryDesc()%> " /></liferay-ui:search-container-column-text>
				<c:if test="<%=LegalFAQCategoryPermission.contains(permissionChecker, scopeGroupId, LegalFAQCategoryPermission.UPDATE) %>">
					<liferay-ui:search-container-column-text name="edit">															
						<liferay-ui:icon image="edit" message="edit" url="<%= editCategoryURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
														
				<c:if test="<%=LegalFAQCategoryPermission.contains(permissionChecker, scopeGroupId, LegalFAQCategoryPermission.DELETE) %>">										
					<liferay-portlet:actionURL  name="deleteFAQCategory" var="deleteFAQCategoryURL">
						<portlet:param name="categoryId" value="<%=String.valueOf(faqCategory.getCategoryId())%>"/>
						<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
					</liferay-portlet:actionURL>
					<liferay-ui:search-container-column-text name="delete">
						<liferay-ui:icon-delete url="<%= deleteFAQCategoryURL %>" />
					</liferay-ui:search-container-column-text>					
				</c:if>
				
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator paginate="<%=false %>"/>
		</liferay-ui:search-container>
	</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var faqCategorySearchInput = A.one('#<portlet:namespace/>faqCategorySearchInput');
		
		if(faqCategorySearchInput){
			faqCategorySearchInput.focus();
		}
		
		if(<%=Validator.equals(categoryCommand, "updateCategory")%>){
		
			var categoryInput = A.one('#<portlet:namespace />categoryName');
			
			if(categoryInput){
				categoryInput.focus();
			}
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />faq_category_update_form,
		
		        rules: {
		            <portlet:namespace />categoryName: {
		                required: true,
		                rangeLength: ['1','150']
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