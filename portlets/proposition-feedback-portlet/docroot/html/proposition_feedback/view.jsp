<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/proposition_feedback/init.jsp"%>

<%
	long propositionId = ParamUtil.getLong(request, "propositionId",0L);

	long feedbackId = ParamUtil.getLong(request, "feedbackId",0L);
	
	if(feedbackId > 0L && propositionId <= 0L){
		
		PropositionFeedback feedback = PropositionFeedbackLocalServiceUtil.getPropositionFeedback(feedbackId);
		
		if(feedback != null && feedback.getPropositionId() > 0){
			
			propositionId = feedback.getPropositionId();
		}
	}
%>

<c:choose>
	<c:when test="<%=propositionId > 0 %>">
		<liferay-util:include page="/html/proposition_feedback/proposition_content/view_proposition_details.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:when>
	
	<c:otherwise>
		<div id="proposition_feedback_view">
			<div class="proposition_search_form">
				<%@ include file="/html/proposition_feedback/proposition_search_form.jspf" %>
			</div>
			
			<div class="proposition_display_list">
			
				<div class="proposition_list_header_tab">
					<span id="lastest_propositions" class="propositions_tab propositions_active_tab">
						<a href="javascript:;"><liferay-ui:message key="lastest-propositions" /></a>			
					</span>
						
					<span id="top_view_counter_propositions" class="propositions_tab">
						<a href="javascript:;"><liferay-ui:message key="top-view-counter-propositions" /></a>
					</span>
									
					<span id="top_feedback_counter_propositions" class="propositions_tab">
						<a href="javascript:;"><liferay-ui:message key="top-feedback-counter-propositions" /></a>
					</span>
				</div>
				
				<div class="proposition_list">
					<div class="lastest_propositions" >
						<%@include file="/html/proposition_feedback/propositions_tab/tab_lastest.jspf"%>
					</div>
							
					<div class="top_view_counter_propositions">
						<%@include file="/html/proposition_feedback/propositions_tab/tab_top_view_count.jspf"%>
					</div>
													
					<div class="top_feedback_counter_propositions">
						<%@include file="/html/proposition_feedback/propositions_tab/tab_top_feedback.jspf"%>
					</div>
					<div style="clear: both;"></div>
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>


<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		
		var lastestPropositionTab = A.one('#lastest_propositions');
		var topViewCounterTab = A.one('#top_view_counter_propositions');
		var topFeedbackTab = A.one('#top_feedback_counter_propositions');
		
		var lastestPropositionDiv = A.one('.lastest_propositions');
		var topViewCounterDiv = A.one('.top_view_counter_propositions');
		var topFeedbackDiv = A.one('.top_feedback_counter_propositions');
		
		if(lastestPropositionTab){		
			lastestPropositionTab.on('click', function(){	
					
				lastestPropositionTab.removeClass('propositions_deactive_tab').addClass('propositions_active_tab');
				
				topViewCounterTab.removeClass('propositions_active_tab');
				topFeedbackTab.removeClass('propositions_active_tab');
				
				lastestPropositionDiv.removeClass('propositions_deactive_div').addClass('propositions_active_div');
				
				topViewCounterDiv.removeClass('propositions_active_div').addClass('propositions_deactive_div');
				topFeedbackDiv.removeClass('propositions_active_div').addClass('propositions_deactive_div');
			});
		}
			
		if(topViewCounterTab){		
			topViewCounterTab.on('click', function(){	
					
				topViewCounterTab.removeClass('propositions_deactive_tab').addClass('propositions_active_tab');
				
				lastestPropositionTab.removeClass('propositions_active_tab');
				topFeedbackTab.removeClass('propositions_active_tab');
				
				topViewCounterDiv.removeClass('propositions_deactive_div').addClass('propositions_active_div');
				
				lastestPropositionDiv.removeClass('propositions_active_div').addClass('propositions_deactive_div');
				topFeedbackDiv.removeClass('propositions_active_div').addClass('propositions_deactive_div');
			});
		}
			
		if(topFeedbackTab){		
			topFeedbackTab.on('click', function(){	
					
				topFeedbackTab.removeClass('propositions_deactive_tab').addClass('propositions_active_tab');
				
				topViewCounterTab.removeClass('propositions_active_tab');
				lastestPropositionTab.removeClass('propositions_active_tab');
				
				topFeedbackDiv.removeClass('propositions_deactive_div').addClass('propositions_active_div');
				
				topViewCounterDiv.removeClass('propositions_active_div').addClass('propositions_deactive_div');
				lastestPropositionDiv.removeClass('propositions_active_div').addClass('propositions_deactive_div');
			});
		}
	})

</script>

