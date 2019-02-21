<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/proposition_feedback/init.jsp"%>

<%
	long propositionId = ParamUtil.getLong(request, "propositionId",0L);

	String categoryName = "";
	String compilationDepartmentName = "";
	String verificationDepartmentName = "";

	Proposition proposition = null;

	if(propositionId > 0){
		
		proposition = PropositionLocalServiceUtil.incrementViewCounter(propositionId);
		
		if(proposition != null){
			
			if(proposition.getCategoryId() > 0){
				categoryName = PropositionCategoryLocalServiceUtil.getPropositionCategory(proposition.getCategoryId()).getCategoryName();
			}
			
			if(proposition.getCompilationDepartmentId() > 0){
				compilationDepartmentName = PropositionCategoryLocalServiceUtil.getPropositionCategory(proposition.getCompilationDepartmentId()).getCategoryName();
			}
			
			if(proposition.getVerificationDepartmentId() > 0){
				verificationDepartmentName = PropositionCategoryLocalServiceUtil.getPropositionCategory(proposition.getVerificationDepartmentId()).getCategoryName();
			}
		}
	}
	
	List<PropositionFeedback> feedbackList = PropositionFeedbackLocalServiceUtil.findByPropositionAndStatusAndGroup(scopeGroupId, 
		propositionId, PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE);
%>

<c:if test='<%=Validator.isNotNull(proposition) %>'>
	
	<div class="proposition-preview">
		
		<div class="proposition_title" align="center"><liferay-ui:message key="proposition-title" /></div>
		<div class="proposition_name" align="center"><%=proposition.getPropositionName() %></div>
		
		<div style="clear: both;"></div>
		
		<div>
			<div class="proposition_header_tab">
				<span id="summary_content" class="proposition_content_tab proposition_content_active_tab">
					<a href="javascript:;"><liferay-ui:message key="proposition-summary" /></a>			
				</span>
					
				<span id="full_content" class="proposition_content_tab">
					<a href="javascript:;"><liferay-ui:message key="proposition-content" /></a>
				</span>
								
				<span id="feedback_content" class="proposition_content_tab">
					<a href="javascript:;"><liferay-ui:message key="proposition-feedback" /></a>
				</span>
			</div>
		</div>
		
		<div style="clear: both;"></div>
		
		<div class="proposition_content">
		
			<div class="proposition_summary_content">
			
				<div class="proposition_properties_name">
					<span style="font-weight: bold;"><liferay-ui:message key="proposition-category"/><%=StringPool.COLON %></span>
					<span><%=categoryName%></span>
				</div>
							
				<div class="proposition_properties_name">
					<span style="font-weight: bold;"><liferay-ui:message key="compilation-department"/><%=StringPool.COLON %></span>
					<%=compilationDepartmentName%>
				</div>
							
				<div class="proposition_properties_name">
					<span style="font-weight: bold;"><liferay-ui:message key="verification-department"/><%=StringPool.COLON %></span>
					<span><%=verificationDepartmentName%></span>
				</div>
							
				<div class="proposition_properties_name">
					<span style="font-weight: bold;"><liferay-ui:message key="publish-date"/><%=StringPool.COLON %></span>
					<span><%=dateFormat.format(proposition.getCreateDate()) %></span>
				</div>
											
				<div class="proposition_properties_name">
					<span style="font-weight: bold;"><liferay-ui:message key="view-count"/><%=StringPool.COLON %></span>
					<span><%=proposition.getViewCount() %></span>
				</div>
															
				<div class="proposition_properties_name">
					<span style="font-weight: bold;"><liferay-ui:message key="feedback-count"/><%=StringPool.COLON %></span>
					<span><%=proposition.getFeedbackCount() %></span>
				</div>
																			
				<div class="proposition_properties_name">
					<span style="font-weight: bold;"><liferay-ui:message key="content-change"/><%=StringPool.COLON %></span>
					<br/>
					<span><%=proposition.getPropositionDesc() %></span>
				</div>
			</div>
			
			<div style="clear: both;"></div>
						
			<div class="proposition_full_content_wrapper">
				<%=proposition.getPropositionContent() %>
			</div>
			
			<div style="clear: both;"></div>
						
			<div class="feedback_content_wrapper">
				<c:choose>
					<c:when test="<%=feedbackList.isEmpty() %>">
						<span><liferay-ui:message key="no-feedback-found"/></span>
					</c:when>
					<c:otherwise>
						<%
						for(PropositionFeedback feedbackEntry : feedbackList){
							
							String citizenName = feedbackEntry.getCitizenName();
							String citizenEmail = feedbackEntry.getCitizenEmail();
							
							String feedbackTittle = feedbackEntry.getFeedbackTitle();
							String feedbackContent = feedbackEntry.getFeedbackContent();
							
							String sendDate = dateTimeFormat.format(feedbackEntry.getCreateDate());
						%>
							<div class="feedback_content">
								<div class="feedback_title"><%=feedbackTittle %></div>
								
								<div class="feedback_full_content"><%=feedbackContent %></div>
								
								<div class="feedback_metadata">
									<span class="citizen_name"><%=citizenName %> | </span>
									<span><liferay-ui:message key="send-date"/></span>
									<span><%=sendDate %></span>
								</div>
							</div>
							
							<div style="clear: both;"></div>
						<%
						}
						%>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
			
	<div class="aui-button-holder">
		<aui:button value="update" name="updatePropositionBtn" />
		<aui:button value="close" name="closePopupBtn"/>
	</div>
</c:if>

<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		
		var summaryContentTab = A.one('#summary_content');
		var fullContentTab = A.one('#full_content');
		var feedbackContentTab = A.one('#feedback_content');
					
		var summaryContentDiv = A.one('.proposition_summary_content');
		var fullContentDiv = A.one('.proposition_full_content_wrapper');
		var feedbackContentDiv = A.one('.feedback_content_wrapper');
		
		if(summaryContentTab){		
			summaryContentTab.on('click', function(){	
					
				summaryContentTab.removeClass('proposition_content_deactive_tab').addClass('proposition_content_active_tab');
				
				fullContentTab.removeClass('proposition_content_active_tab');
				feedbackContentTab.removeClass('proposition_content_active_tab');
				
				summaryContentDiv.removeClass('proposition_content_deactive_div').addClass('proposition_content_active_div');
				
				fullContentDiv.removeClass('proposition_content_active_div').addClass('proposition_content_deactive_div');
				feedbackContentDiv.removeClass('proposition_content_active_div').addClass('proposition_content_deactive_div');
			});
		}
		
		if(fullContentTab){		
			fullContentTab.on('click', function(){	
					
				fullContentTab.removeClass('proposition_content_deactive_tab').addClass('proposition_content_active_tab');
				
				summaryContentTab.removeClass('proposition_content_active_tab');
				feedbackContentTab.removeClass('proposition_content_active_tab');
				
				fullContentDiv.removeClass('proposition_content_deactive_div').addClass('proposition_content_active_div');
				
				summaryContentDiv.removeClass('proposition_content_active_div').addClass('proposition_content_deactive_div');
				feedbackContentDiv.removeClass('proposition_content_active_div').addClass('proposition_content_deactive_div');
			});
		}
			
		if(feedbackContentTab){		
			feedbackContentTab.on('click', function(){	
					
				feedbackContentTab.removeClass('proposition_content_deactive_tab').addClass('proposition_content_active_tab');
				
				summaryContentTab.removeClass('proposition_content_active_tab');
				fullContentTab.removeClass('proposition_content_active_tab');
				
				feedbackContentDiv.removeClass('proposition_content_deactive_div').addClass('proposition_content_active_div');
				
				summaryContentDiv.removeClass('proposition_content_active_div').addClass('proposition_content_deactive_div');
				fullContentDiv.removeClass('proposition_content_active_div').addClass('proposition_content_deactive_div');
			});
		}
		
		var updatePropositionBtn = A.one('#<portlet:namespace/>updatePropositionBtn');
				
		if(updatePropositionBtn){
			
			updatePropositionBtn.on('click',function(){

				Liferay.Util.getOpener().showPropositionUpdateForm('<%=propositionId%>');
				
				Liferay.Util.getWindow().close();
			});
		}
		
		var closePopupBtn = A.one('#<portlet:namespace/>closePopupBtn');
		
		if(closePopupBtn){
			
			closePopupBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</script>	
