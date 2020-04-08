<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.inquiry.model.OnlineInquiry"%>
<%@page import="com.portal_egov.portlet.inquiry.search.InquirySearch"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.portal_egov.portlet.inquiry.permission.OnlineInquiryPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int inquiryIndex = 0;
	
	String inquirySearchKeyword = ParamUtil.getString(request, "inquirySearchKeyword");
%>


<div class="inquiry-admin">
	
	<liferay-portlet:renderURL var="inquiryAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	</liferay-portlet:renderURL>
		
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="inquiry-permission-btn-row" align="left">
				
				<c:if test="<%=OnlineInquiryPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=OnlineInquiry.class.getName() %>"
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
				List<OnlineInquiry> inquiryList = OnlineInquiryLocalServiceUtil.findByKeyword(groupId, 
					inquirySearchKeyword,searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			%>
			
			<liferay-ui:search-container-results results="<%=inquiryList %>" total="<%=inquiryList.size() %>"/>
			
			<liferay-ui:search-container-row className="OnlineInquiry" keyProperty="inquiryId" modelVar="inquiry" escapedModel="<%=true %>">
				<%
				
				inquiryIndex ++;
				
				String inquiryTitle = StringUtil.shorten(inquiry.getInquiryContent(), 100);
				
				StringBundler inquiryContentBundle = new StringBundler();

				inquiryContentBundle.append("javascript:");
				inquiryContentBundle.append("showInquiryPreview");
				inquiryContentBundle.append("('");
				inquiryContentBundle.append(inquiry.getInquiryId());
				inquiryContentBundle.append("',");
				inquiryContentBundle.append("'");
				inquiryContentBundle.append(inquiryTitle);
				inquiryContentBundle.append("')");

				String	inquiryPreviewURL = inquiryContentBundle.toString();
				
				%>
					
				<liferay-ui:search-container-column-text 
					name="#" value="<%=String.valueOf(inquiryIndex)%>" 
					title="<%=inquiryTitle %>"
				/>
								
				<liferay-ui:search-container-column-text 
					name="title" 
					value="<%=inquiryTitle%>" 
					href="<%=inquiryPreviewURL %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="full-name" 
					value="<%=inquiry.getFullName()%>" 
					href="<%=inquiryPreviewURL %>"
					title="view"
				/>
																
				<liferay-ui:search-container-column-text 
					name="send-date" 
					value="<%=dateFormat.format(inquiry.getCreateDate())%>"
					orderable="true"
					orderableProperty="createDate"
					href="<%=inquiryPreviewURL %>"
					title="view" 
				/>
								
				<liferay-ui:search-container-column-text name="delete"  align="center">
					<c:if test="<%=OnlineInquiryPermission.contains(permissionChecker, groupId, ActionKeys.DELETE)%>">		
																		
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
		
		Liferay.provide(window,'showInquiryPreview',function(inquiryId,inquiryTitle){
			
			A.DialogManager.hideAll();
								
			var inquiryPreviewURL = Liferay.PortletURL.createRenderURL();
			
			if(inquiryPreviewURL){
				
				inquiryPreviewURL.setPortletId('<%=portletId %>');
				inquiryPreviewURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				inquiryPreviewURL.setParameter('jspPage', '/html/admin/inquiry_preview.jsp');
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
	});
</script>