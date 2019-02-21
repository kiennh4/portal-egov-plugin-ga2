<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.persistence.PropositionFinderUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.search.PropositionSearch"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.permission.PropositionPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Trang thai cua du thao luat. propositionStatus = -1 tuong ung voi viec hien thi tat ca cac du thao luat
	int selectedPropositionStatus = ParamUtil.getInteger(request, "selectedPropositionStatus",-1);
	
	int propositionCounter = PropositionLocalServiceUtil.countByGroup(scopeGroupId);
	
	int propositionIndex = 0;
	
	//Tu khoa nhap vao o tim kiem
	String searchKeyword = ParamUtil.getString(request, "searchKeyword",StringPool.BLANK);
	
	String portletId = PortalUtil.getPortletId(request);
%>
			
<liferay-portlet:renderURL var="propositionAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Propositions"/>
</liferay-portlet:renderURL>
			
<liferay-portlet:renderURL var="propositionUpdateURL">
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/proposition_update_form.jsp" />
	<liferay-portlet:param name="tabs1" value="Propositions"/>
</liferay-portlet:renderURL>

<div class="proposition_admin">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			<c:if test="<%=PropositionPermission.contains(permissionChecker, scopeGroupId, PropositionPermission.UPDATE) %>">	
				<div class="add_proposition_button" align="left">
					<aui:button type="button" value="add-new-proposition" href="<%=propositionUpdateURL %>"/>
																										
					<c:if test="<%=PropositionPermission.contains(permissionChecker, scopeGroupId, PropositionPermission.PERMISSIONS)%>">
						<liferay-security:permissionsURL
							modelResource="<%=Proposition.class.getName() %>"
							modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
							resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
							var="permissionsURL"
						/>
				
						<aui:button href="<%= permissionsURL %>" value="permissions" />
					</c:if>
				</div>			
			</c:if>
			
			<liferay-portlet:renderURL var="propositionSearchFormURL">
				<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp" />
				<liferay-portlet:param name="tabs1" value="Propositions"/>
				<liferay-portlet:param name="searchKeyword" value="<%=searchKeyword %>"/>
				<liferay-portlet:param name="selectedPropositionStatus" value="<%=String.valueOf(selectedPropositionStatus) %>"/>
			</liferay-portlet:renderURL>
			
			<div class="proposition_search_form" align="right">
				<aui:form name="proposition_search_form" method="post" action="<%=propositionSearchFormURL %>">
					
					<input type="text" id="<portlet:namespace/>searchInput" name="searchKeyword" value='<%= searchKeyword%>'/>
					
					<select name="selectedPropositionStatus">
						<option value="-1" <%=(selectedPropositionStatus == -1) ? "selected" : "" %>>
							<liferay-ui:message key="all-proposition"/>
						</option>
											
						<option value="<%=PropositionConstants.DEFAULT_PROPOSITION_STATUS_VALUE %>" 
								<%=(selectedPropositionStatus == PropositionConstants.DEFAULT_PROPOSITION_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="unpublish-proposition"/>
						</option>
																	
						<option value="<%=PropositionConstants.PUBLISH_PROPOSITION_STATUS_VALUE %>"
								<%=(selectedPropositionStatus == PropositionConstants.PUBLISH_PROPOSITION_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="publish-proposition"/>
						</option>
																	
						<option value="<%=PropositionConstants.UNRELEASE_PROPOSITION_STATUS_VALUE %>"
								<%=(selectedPropositionStatus == PropositionConstants.UNRELEASE_PROPOSITION_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="unrelease-proposition"/>
						</option>
																	
						<option value="<%=PropositionConstants.RELEASED_PROPOSITION_STATUS_VALUE %>"
								<%=(selectedPropositionStatus == PropositionConstants.RELEASED_PROPOSITION_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="released-proposition"/>
						</option>
					</select>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button type="button" value="show-all" href="<%=propositionAdminURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
		
	<liferay-portlet:renderURL varImpl="propositionAdminHomePageURL" >
		<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="Propositions"/>
		<liferay-portlet:param name="searchKeyword" value="<%=searchKeyword %>"/>
		<liferay-portlet:param name="selectedPropositionStatus" value="<%=String.valueOf(selectedPropositionStatus) %>"/>
	</liferay-portlet:renderURL>
	
	<liferay-ui:search-container searchContainer="<%=new PropositionSearch(renderRequest,propositionAdminHomePageURL) %>" emptyResultsMessage="no-search-result-found">
		<%
		
		//Ket qua tim kiem voi 2 tham so truyen vao la keyword va status
		List<Proposition> propositionList = PropositionLocalServiceUtil.findByMultiCondition(scopeGroupId, 0L, 0L, 0L, searchKeyword,
			selectedPropositionStatus,searchContainer.getStart(),searchContainer.getEnd(),searchContainer.getOrderByComparator());
		
		%>
		<liferay-ui:search-container-results
			results="<%=propositionList%>"
			total="<%=propositionList.size() %>"
		/>			
		<liferay-ui:search-container-row className="Proposition" keyProperty="propositionId" modelVar="proposition" >
			
			<%
				propositionIndex ++;
			
				StringBundler sb = new StringBundler();
	
				sb.append("javascript:");
				sb.append("showPropositionPreviewDialog");
				sb.append("('");
				sb.append(proposition.getPropositionId());
				sb.append("')");
	
				String	rowHREF = sb.toString();
			%>
			
			<liferay-portlet:renderURL var="editPropositionContentURL" >
				<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/proposition_update_form.jsp"/>
				<liferay-portlet:param name="propositionId" value="<%=String.valueOf(proposition.getPropositionId())%>"/>
				<liferay-portlet:param name="backURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
			</liferay-portlet:renderURL>
						
			<liferay-portlet:renderURL var="viewFeedbackListURL" >
				<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/feedback_admin.jsp"/>
				<liferay-portlet:param name="propositionId" value="<%=String.valueOf(proposition.getPropositionId())%>"/>
				<liferay-portlet:param name="selectedFeedbackStatus" value="<%=String.valueOf(PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE)%>"/>
				<liferay-portlet:param name="backURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
			</liferay-portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(propositionIndex) %>" href="<%=rowHREF %>"/>
									
			<liferay-ui:search-container-column-text 
					name="Name" 
					value="<%=StringUtil.shorten(proposition.getPropositionName(), 60) %>" 
					href="<%=rowHREF %>"
					orderable="<%=true %>"
					orderableProperty="proposition-name"
			/>
			
			<liferay-ui:search-container-column-text 
					name="Feedback-count" 
					value="<%=String.valueOf(proposition.getFeedbackCount())%>" 
					orderable="<%=true %>"
					orderableProperty="feedback-count"
			/>
			
			<liferay-ui:search-container-column-text 
					name="modified-date" 
					value="<%=dateTimeFormat.format(proposition.getModifiedDate())%>"
					orderable="<%=true %>"
					orderableProperty="modified-date"
			/>
			
			<liferay-ui:search-container-column-text 
					name="Proposition-Status" 
					orderable="<%=true %>"
					orderableProperty="proposition-status"
			>
				<liferay-ui:message  key="<%=PropositionUtil.getPropositionStatusTitle(proposition.getPropositionId())%>"/>
			</liferay-ui:search-container-column-text>
			
			<c:if test="<%=PropositionPermission.contains(permissionChecker, scopeGroupId, PropositionPermission.UPDATE) %>">
				<liferay-ui:search-container-column-text name="edit">														
					<liferay-ui:icon image="edit" message="edit" url="<%= editPropositionContentURL %>" />
				</liferay-ui:search-container-column-text>
			</c:if>
																		
			<c:if test="<%=PropositionPermission.contains(permissionChecker, scopeGroupId, PropositionPermission.DELETE) %>">										
				<liferay-portlet:actionURL  name="deleteProposition" var="deletePropositionURL">
					<liferay-portlet:param name="propositionId" value="<%=String.valueOf(proposition.getPropositionId())%>"/>
					<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
				</liferay-portlet:actionURL>
				
				<liferay-ui:search-container-column-text name="delete">
					<liferay-ui:icon-delete url="<%= deletePropositionURL %>" 
											confirmation="are-you-sure-to-delete-proposition-and-delete-all-feedback-entries-of-this-proposition?"/>		
				</liferay-ui:search-container-column-text>		
			</c:if>
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		var propositionSearchKeywordInput = A.one('#<portlet:namespace/>searchInput');
		
		if(propositionSearchKeywordInput){
			propositionSearchKeywordInput.focus();
		}
	});
	
	Liferay.provide(
		window,
		'showPropositionPreviewDialog',
		function(propositionId) {
			
			var A = AUI();
			
			A.DialogManager.hideAll();
								
			var propositionPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(propositionPreviewRenderURL){
				
				propositionPreviewRenderURL.setPortletId('<%=portletId %>');
				propositionPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				propositionPreviewRenderURL.setParameter('jspPage', '/html/proposition_feedback_admin/proposition_preview.jsp');
				propositionPreviewRenderURL.setParameter('propositionId', propositionId);
				propositionPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '#_proposition_feedback_admin_WAR_proposition_feedbackportlet_tabs170101101100989799107115TabsId',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true
					},
					id: '<portlet:namespace/>propositionPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "proposition-preview-content") %>',
					uri: propositionPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
	
	Liferay.provide(
		window,
		'showPropositionUpdateForm',
		function(propositionId) {
											
			var propositionUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(propositionUpdateFormURL){
				
				propositionUpdateFormURL.setPortletId('<%=portletId %>');
				propositionUpdateFormURL.setWindowState('<%=LiferayWindowState.MAXIMIZED.toString() %>');
				propositionUpdateFormURL.setParameter('jspPage', '/html/proposition_feedback_admin/proposition_update_form.jsp');
				propositionUpdateFormURL.setParameter('propositionId', propositionId);
				propositionUpdateFormURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
			
			window.location = propositionUpdateFormURL;					
		},
		['aui-base']
	);
	
</script>
