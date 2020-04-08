<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Collections"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long legalFAQEntryId = ParamUtil.getLong(request, "legalFAQEntryId",0L);
	
	LegalFAQEntry legalFAQEntry = null;
	
	long categoryId = 0L;
	
	List<LegalFAQEntry> relatedEntryList = Collections.emptyList();
	
	if(legalFAQEntryId > 0){
		
		legalFAQEntry = LegalFAQEntryLocalServiceUtil.incrementViewCounter(legalFAQEntryId);
		
		if(legalFAQEntry != null){
			
			categoryId = legalFAQEntry.getCategoryId();
			
			relatedEntryList = LegalFAQEntryLocalServiceUtil.findByCategoryAndStatus(companyId, categoryId,
						LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE, LegalFAQConstants.LEGAL_FAQ_ENTRY_ANSWERED_STATUS_VALUE, 0, 4);
		}
	}

%>

<div class="legal_faq_navigation_row" align="right">

	<liferay-portlet:renderURL var="giveAskURL" >
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/give_ask_form.jsp" />
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL var="backURL" >
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view.jsp" />
		<liferay-portlet:param  name="legalFAQEntryId" value="0"/>
		<liferay-portlet:param  name="legalFAQCategoryId" value="0"/>
	</liferay-portlet:renderURL>
	
	<span class="give_ask_icon" id='<portlet:namespace />giveAskBtn'>
		<a href="<%=giveAskURL%>">
			<liferay-ui:message key="give-ask"/>
		</a>
	</span>
	
	<span class="back_icon">
		<a href="<%=backURL%>">
			<liferay-ui:message key="back-to-faq-home-page"/>
		</a>
	</span>
</div>

<div style="clear: both;"></div>

<c:if test='<%=Validator.isNotNull(legalFAQEntry) %>'>
			
	<div class = "legal_faq_ask_content">
		<div class="ask_title">
			<a href="#"><%=legalFAQEntry.getAskTitle() %></a>
		</div>
		
		<div style="clear: both;"></div>
		
		<div class="ask_content"><%=legalFAQEntry.getAskContent() %></div>
		
		<div style="clear: both;"></div>
		
	</div>
	
	<div class = "legal_faq_answer_content">
		<div class="answer_title">
			<a href="javascript:;"><liferay-ui:message key="answer-content"/></a>
		</div>
		
		<div style="clear: both;"></div>
		
		<div class="answer_content"><%=legalFAQEntry.getAnswerContent() %></div>
		
		<div style="clear: both;"></div>
		
		<div class="answer_metadata">
			<liferay-ui:message key="answer-by"/> :&nbsp; <%=UserLocalServiceUtil.getUser(legalFAQEntry.getUserId()).getFullName() %>
			<br/>
			<liferay-ui:message key="answer-date"/> :&nbsp; <%=dateFormat.format(legalFAQEntry.getAnswerDate()) %>
		</div>
	</div>
	
	<c:if test="<%=relatedEntryList.size() > 1 %>">
		<div class="related_faq_entry">
		
			<span class="related_title"><liferay-ui:message key="related-entries"/></span>
			<ul>
				<%
				for(LegalFAQEntry relatedEntry : relatedEntryList)
				{
					long relatedEntryId = relatedEntry.getEntryId();
				%>
				<c:if test="<%= !(relatedEntryId == legalFAQEntryId) %>">		
					<liferay-portlet:renderURL var="viewRelatedEntryURL" >
						<liferay-portlet:param name="legalFAQEntryId" value="<%=String.valueOf(relatedEntry.getEntryId())%>"/>
						<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view_faq_entry.jsp" />
					</liferay-portlet:renderURL>
					
					<li>	  		  
			  		  <span class="related_entry_ask_title">
			  		    <a href="<%= viewRelatedEntryURL%>"><%=relatedEntry.getAskTitle()%></a>
			  		  </span>
			  		  
			  		  <span class="publish_date">(<%=dateFormat.format(relatedEntry.getModifiedDate()) %>)</span>
				    </li>
			    </c:if>
				<%
				}
				%>
			</ul>
		</div>
	</c:if>
</c:if>

