<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.search.InquirySearch"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.permission.InquiryPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	boolean closeDialog = false;

	int inquiryIndex = 0;

	String inquirySearchKeyword = ParamUtil.getString(request, "inquirySearchKeyword");
	
	
	PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);
	
	if(SessionErrors.isEmpty(portletRequest) && !SessionMessages.isEmpty(portletRequest)){
		closeDialog = true;
	}
%>


<div class="inquiry-admin">
	
	<liferay-portlet:renderURL var="inquiryAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL var="inquiryCategoryUpdateURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="Categories"/>
		<liferay-portlet:param name="categoryCommand" value="updateCategory"/>
	</liferay-portlet:renderURL>
		
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="inquiry-permission-btn-row" align="left">
				
				<c:if test="<%=InquiryPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=CitizenInquiry.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>	
						
			<div class="inquiry-search-form" align="right">
				<aui:form name="fm" method="post" action="<%=inquiryAdminURL %>">
				
					<input type="text" id="<portlet:namespace/>inquirySearchKeyword" size="40" name="inquirySearchKeyword" value='<%= inquirySearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=inquiryAdminURL %>"/>
				</aui:form>	
			</div>		
		</div>
	</div>
	
	<div class="inquiry-list">
		
		<liferay-portlet:renderURL varImpl="inquiryAdminImplURL">
			<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
			<liferay-portlet:param name="inquirySearchKeyword" value="<%=inquirySearchKeyword %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container 
			searchContainer="<%=new InquirySearch(renderRequest,inquiryAdminImplURL) %>"
		>
			<%	
				List<CitizenInquiry> inquiryList = CitizenInquiryLocalServiceUtil.findByKeyword(groupId, 0L, 
					inquirySearchKeyword,searchContainer.getStart(), searchContainer.getEnd(),true, searchContainer.getOrderByComparator());
			%>
			
			<liferay-ui:search-container-results results="<%=inquiryList %>" total="<%=inquiryList.size() %>"/>
			
			<liferay-ui:search-container-row className="CitizenInquiry" keyProperty="inquiryId" modelVar="inquiry" escapedModel="<%=true %>">
				<%
				
				inquiryIndex ++;
				
				StringBundler inquiryContentBundle = new StringBundler();

				inquiryContentBundle.append("javascript:");
				inquiryContentBundle.append("showInquiryPreview");
				inquiryContentBundle.append("('");
				inquiryContentBundle.append(inquiry.getInquiryId());
				inquiryContentBundle.append("',");
				inquiryContentBundle.append("'");
				inquiryContentBundle.append(StringUtil.shorten(inquiry.getInquiryTitle(), 60));
				inquiryContentBundle.append("')");

				String	inquiryPreviewURL = inquiryContentBundle.toString();
				
				
				StringBundler updateInquiryBundle = new StringBundler();

				updateInquiryBundle.append("javascript:");
				updateInquiryBundle.append("showInquiryUpdateForm");
				updateInquiryBundle.append("('");
				updateInquiryBundle.append(inquiry.getInquiryId());
				updateInquiryBundle.append("',");
				updateInquiryBundle.append("'");
				updateInquiryBundle.append(StringUtil.shorten(inquiry.getInquiryTitle(), 60));
				updateInquiryBundle.append("')");

				String	updateInquiryURL = updateInquiryBundle.toString();
				
				String inquiryStatusImagePath = "/citizen_inquiry_admin-portlet/images/invisible.png";
				
				if(inquiry.getApproved()){
					
					inquiryStatusImagePath = "/citizen_inquiry_admin-portlet/images/available.png";
				}
				%>
					
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(inquiryIndex)%>" href="<%=inquiryPreviewURL %>"
					title="<%=inquiry.getInquiryTitle() %>"
				/>
								
				<liferay-ui:search-container-column-text 
					name="inquiry-title" 
					value="<%=StringUtil.shorten(inquiry.getInquiryTitle(), 80)%>" 
					href="<%=inquiryPreviewURL %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="citizen-name" 
					value="<%=inquiry.getCitizenName()%>" 
					href="<%=inquiryPreviewURL %>"
					title="view"
				/>
																
				<liferay-ui:search-container-column-text 
					name="inquiry-create-date" 
					value="<%=dateFormat.format(inquiry.getCreateDate())%>"
					orderable="true"
					orderableProperty="createDate"
					href="<%=inquiryPreviewURL %>"
					title="view" 
				/>
				<c:choose>
					<c:when test="<%=inquiry.getApproved() && inquiry.getInquiryFeedbackDate() != null %>">
						<liferay-ui:search-container-column-text 
							name="feedback-date" 
							value="<%=dateFormat.format(inquiry.getInquiryFeedbackDate())%>"
							orderable="true"
							orderableProperty="inquiryFeedbackDate"
							href="<%=inquiryPreviewURL %>"
							title="view"
						/>
					</c:when>
					
					<c:otherwise>
						<liferay-ui:search-container-column-text 
							name="feedback-date" 
							value="---"
							title="view"
						/>
					</c:otherwise>
				</c:choose>
														
				<liferay-ui:search-container-column-text
					href="<%= inquiryPreviewURL %>"
					align="center"
					name="status"
					orderable="<%= true %>"
					orderableProperty="approvedStatus"
					title="view"
				>
					<img src="<%=inquiryStatusImagePath%>"/>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="update" align="center">
					<liferay-ui:icon image="edit" message="update" url="<%= updateInquiryURL %>" />
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete"  align="center">
					<c:if test="<%=InquiryPermission.contains(permissionChecker, groupId, ActionKeys.DELETE)%>">		
																		
						<liferay-portlet:actionURL  name="deleteInquiry" var="deleteInquiryActionURL">
							<liferay-portlet:param name="inquiryId" value="<%=String.valueOf(inquiry.getInquiryId())%>"/>
							<liferay-portlet:param name="redirectURL" value="<%=inquiryAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteInquiryActionURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		var inquirySearchInput = A.one('#<portlet:namespace/>inquirySearchKeyword');
		
		if(inquirySearchInput){
			
			inquirySearchInput.focus();
		}
		
		if(<%=closeDialog %>){
			
			Liferay.fire(
				'closeWindow',
				{
					id: '<portlet:namespace/>inquiryDialog',
				},window.top.location.reload(true)
			);
		}
		
		Liferay.provide(window,'showInquiryPreview',function(inquiryId,inquiryTitle){
			
			A.DialogManager.hideAll();
								
			var inquiryPreviewURL = Liferay.PortletURL.createRenderURL();
			
			if(inquiryPreviewURL){
				
				inquiryPreviewURL.setPortletId('<%=portletId %>');
				inquiryPreviewURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				inquiryPreviewURL.setParameter('jspPage', '/html/admin/inquiry/inquiry_preview.jsp');
				inquiryPreviewURL.setParameter('inquiryId', inquiryId);
				inquiryPreviewURL.setDoAsGroupId('<%=groupId %>');
			}
			
			var dialogAlignConfig = {
					node: '.inquiry-admin',
					points: ['tl', 'tl']
			};
			
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true,
						destroyOnClose:true
					},
					id: '<portlet:namespace/>inquiryDialog',
					title: inquiryTitle,
					uri: inquiryPreviewURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
		);
		
		
		Liferay.provide(window,'showInquiryUpdateForm',function(inquiryId,inquiryTitle){
			
			A.DialogManager.hideAll();
								
			var inquiryUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(inquiryUpdateFormURL){
				
				inquiryUpdateFormURL.setPortletId('<%=portletId %>');
				inquiryUpdateFormURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				inquiryUpdateFormURL.setParameter('jspPage', '/html/admin/inquiry/inquiry_update_form.jsp');
				inquiryUpdateFormURL.setParameter('inquiryId', inquiryId);
				inquiryUpdateFormURL.setDoAsGroupId('<%=groupId %>');
			}
			
			var dialogAlignConfig = {
					node: '.inquiry-admin',
					points: ['tl', 'tl']
			};
			
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true,
						destroyOnClose:true
					},
					id: '<portlet:namespace/>inquiryDialog',
					title: inquiryTitle,
					uri: inquiryUpdateFormURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
		);
	});
</script>