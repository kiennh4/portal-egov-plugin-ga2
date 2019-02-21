<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="sun.security.acl.GroupImpl"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.search.FeedbackSearch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.permission.PropositionFeedbackPermission"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int feedbackIndex = 0;

	//Trang thai xuat ban cua Gop y lay tu select box
	int selectedFeedbackStatus = ParamUtil.getInteger(request, "selectedFeedbackStatus",-1);

	//Id cua du thao phap luat
	long propositionId = ParamUtil.getLong(request, "propositionId",0L);
	
	String feedbackSearchKeyword = ParamUtil.getString(request, "feedbackSearchKeyword");
	
	String portletId = PortalUtil.getPortletId(request);
	
	List<PropositionFeedback> feedbackList = new ArrayList<PropositionFeedback>();
%>
			
<liferay-portlet:renderURL var="feedbackAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Feedbacks"/>
</liferay-portlet:renderURL>
			
<liferay-portlet:renderURL var="feedbackUpdateFormURL">
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/feedback_update_form.jsp" />
	<liferay-portlet:param name="tabs1" value="Feedbacks"/>
</liferay-portlet:renderURL>

<div class="proposition_admin">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			
			<c:if test="<%=PropositionFeedbackPermission.contains(permissionChecker, scopeGroupId, PropositionFeedbackPermission.UPDATE) %>">	
				<div class="add_proposition_button" align="left">
					<aui:button type="button" value="add-new-feedback" href="<%=feedbackUpdateFormURL %>"/>
																										
					<c:if test="<%=PropositionFeedbackPermission.contains(permissionChecker, scopeGroupId, PropositionFeedbackPermission.PERMISSIONS)%>">
						<liferay-security:permissionsURL
							modelResource="<%=PropositionFeedback.class.getName() %>"
							modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
							resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
							var="permissionsURL"
						/>
				
						<aui:button href="<%= permissionsURL %>" value="permissions" />
					</c:if>
				</div>			
			</c:if>
			
			<div class="proposition_search_form" align="right">
							
				<liferay-portlet:renderURL var="feedbackSearchFormURL">
					<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp" />
					<liferay-portlet:param name="tabs1" value="Feedbacks"/>
					<liferay-portlet:param name="feedbackSearchKeyword" value="<%=feedbackSearchKeyword %>"/>
					<liferay-portlet:param name="selectedFeedbackStatus" value="<%=String.valueOf(selectedFeedbackStatus) %>"/>
				</liferay-portlet:renderURL>
			
				<aui:form name="proposition_search_form" method="post" action="<%=feedbackSearchFormURL %>">
			
					<input type="text" id="<portlet:namespace/>feedbackSearchInput" name="feedbackSearchKeyword" value='<%= feedbackSearchKeyword%>'/>
					
					<select name="selectedFeedbackStatus" >
						<option value="-1" <%=(selectedFeedbackStatus == -1) ? "selected" : "" %>>
							<liferay-ui:message key="all-feedback"/>
						</option>
											
						<option value="<%=PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE %>" 
								<%=(selectedFeedbackStatus == PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="unpublish-feedback"/>
						</option>
																	
						<option value="<%=PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE %>"
								<%=(selectedFeedbackStatus == PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="publish-feedback"/>
						</option>
					</select>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button type="button" value="show-all" href="<%=feedbackAdminURL %>"/>
					
				</aui:form>
			</div>
		</div>
	</div>
	
	<div class="feedback_list">
				
		<liferay-portlet:renderURL varImpl="feedbackAdminHomePageImplURL" var="">
			<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp" />
			<liferay-portlet:param name="tabs1" value="Feedbacks"/>
			<liferay-portlet:param name="feedbackSearchKeyword" value="<%=feedbackSearchKeyword %>"/>
			<liferay-portlet:param name="selectedFeedbackStatus" value="<%=String.valueOf(selectedFeedbackStatus) %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container searchContainer="<%=new FeedbackSearch(renderRequest,feedbackAdminHomePageImplURL) %>">
		
			<%
				feedbackList = PropositionFeedbackLocalServiceUtil.findByKeyword(scopeGroupId, propositionId, feedbackSearchKeyword,
					selectedFeedbackStatus, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			%>
			
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(feedbackList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=feedbackList.size() %>"
			/>			
			<liferay-ui:search-container-row className="PropositionFeedback" keyProperty="feedbackId" modelVar="feedback" >
				
				<%
					feedbackIndex ++;
				
					String propositionName = "";
					if(feedback.getPropositionId() >0){
						
						Proposition currentProposition = PropositionLocalServiceUtil.getProposition(feedback.getPropositionId());
						
						if(currentProposition != null){
							
							propositionName = currentProposition.getPropositionName();
						}
					}
					
					StringBundler sb = new StringBundler();
		
					sb.append("javascript:");
					sb.append("showFeedbackPreviewDialog");
					sb.append("('");
					sb.append(feedback.getFeedbackId());
					sb.append("')");
		
					String	viewFeedbackContentURL = sb.toString();
				%>
				
				<liferay-ui:search-container-column-text 
						name="#" 
						value="<%=String.valueOf(feedbackIndex) %>" 
						href="<%=viewFeedbackContentURL %>"
				/>
					
				<liferay-ui:search-container-column-text 
						name="Name" 
						value="<%=StringUtil.shorten(feedback.getFeedbackTitle(), 60) %>" 
						href="<%=viewFeedbackContentURL %>"
						orderable="<%=true %>"
						orderableProperty="feedback-title"
				/>
				
				<liferay-ui:search-container-column-text 
						name="proposition-name" 
						value="<%=StringUtil.shorten(propositionName, 60) %>" 
						orderable="<%=true %>"
						orderableProperty="proposition-name"
				/>
				
				<liferay-ui:search-container-column-text 
						name="citizen-name" 
						value="<%=feedback.getCitizenName() %>" 
				/>
				
				<liferay-ui:search-container-column-text 
						name="feedback-date" 
						value="<%=dateTimeFormat.format(feedback.getCreateDate())%>"
						orderable="<%=true %>"
						orderableProperty="feedback-date"
				/>
				
				<liferay-ui:search-container-column-text 
						name="feedback-status"
						orderable="<%=true %>"
						orderableProperty="feedback-status"
				>
					<liferay-ui:message  key="<%=PropositionUtil.getFeedbackStatusTitle(feedback)%>"/>
				</liferay-ui:search-container-column-text>
				
				<c:if test="<%=PropositionFeedbackPermission.contains(permissionChecker, scopeGroupId, PropositionFeedbackPermission.UPDATE) %>">
					<liferay-ui:search-container-column-text name="edit">	
						<liferay-portlet:renderURL var="updateFeedbackContent" >
							<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/feedback_update_form.jsp"/>
							<liferay-portlet:param name="feedbackId" value="<%=String.valueOf(feedback.getFeedbackId())%>"/>
						</liferay-portlet:renderURL>	

						<liferay-ui:icon image="edit" message="publish" url="<%= updateFeedbackContent %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
																				
				<c:if test="<%=PropositionFeedbackPermission.contains(permissionChecker, scopeGroupId, PropositionFeedbackPermission.DELETE) %>">
					<liferay-ui:search-container-column-text name="delete">										
						<liferay-portlet:actionURL  name="deleteFeedback" var="deleteFeedbackURL">
							<liferay-portlet:param name="feedbackId" value="<%=String.valueOf(feedback.getFeedbackId())%>"/>
							<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteFeedbackURL %>" confirmation="are-you-sure-to-delete-this-feedback-entry?"/>
					</liferay-ui:search-container-column-text>				
				</c:if>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		var feedbackSearchInput = A.one('#<portlet:namespace/>feedbackSearchInput');

		if(feedbackSearchInput){
			feedbackSearchInput.focus();
		}
	});
	
	Liferay.provide(
		window,
		'showFeedbackPreviewDialog',
		function(feedbackId) {
			
			var A = AUI();
			
			A.DialogManager.hideAll();
								
			var feedbackPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(feedbackPreviewRenderURL){
				
				feedbackPreviewRenderURL.setPortletId('<%=portletId %>');
				feedbackPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				feedbackPreviewRenderURL.setParameter('jspPage', '/html/proposition_feedback_admin/feedback_preview.jsp');
				feedbackPreviewRenderURL.setParameter('feedbackId', feedbackId);
				feedbackPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
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
					id: '<portlet:namespace/>feedbackPreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "feedback-preview-content") %>',
					uri: feedbackPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
	
	Liferay.provide(
		window,
		'showFeedbackUpdateForm',
		function(feedbackId) {
											
			var feedbackUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(feedbackUpdateFormURL){
				
				feedbackUpdateFormURL.setPortletId('<%=portletId %>');
				feedbackUpdateFormURL.setWindowState('<%=LiferayWindowState.MAXIMIZED.toString() %>');
				feedbackUpdateFormURL.setParameter('jspPage', '/html/proposition_feedback_admin/feedback_update_form.jsp');
				feedbackUpdateFormURL.setParameter('feedbackId', feedbackId);
				feedbackUpdateFormURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
			
			window.location = feedbackUpdateFormURL;					
		},
		['aui-base']
	);
	
	Liferay.provide(
		window,
		'publishFeedback',
		function(feedbackId) {
											
			var publishFeedbackActionURL = Liferay.PortletURL.createActionURL();
			
			if(publishFeedbackActionURL){
				
				publishFeedbackActionURL.setName('publishFeedback');
				publishFeedbackActionURL.setPortletId('<%=portletId %>');
				publishFeedbackActionURL.setParameter('feedbackId', feedbackId);
				publishFeedbackActionURL.setParameter('redirectURL', '<%=feedbackAdminURL%>');
				publishFeedbackActionURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
			
			window.location = publishFeedbackActionURL;					
		},
		['aui-base']
	);
</script>