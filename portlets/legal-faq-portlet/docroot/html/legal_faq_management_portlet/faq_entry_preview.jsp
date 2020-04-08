<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
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

<style type="text/css">
	.faq-entry-preview{
		font-size: 12px;
		padding: 0px;
		margin: 0px;
	}
	
	.faq-entry-preview .faq-entry-title{
		font-size: 16px;
		color: #00528b;
		padding: 10px 0px;
		font-weight: bold;
		text-align: center;
		text-decoration: underline;
	}
	
	.faq-entry-preview .faq-entry-content{
		color: #434343;
		text-align: justify;
	}
		
	.faq-entry-preview .faq-entry-content table{
		
		border-collapse: collapse;
		width: 100%;
	}	
	
	.faq-entry-preview .faq-entry-content table tr{
		border-bottom: 1px dotted #E4E4E4;
		height: 35px;
	}
				
	.faq-entry-preview .faq-entry-content table tr td{
		padding: 5px 0px;
	}
			
	.faq-entry-preview .faq-entry-content table tr td:first-child{
		color: #00528B;
		min-width: 120px;
		font-weight: bold;
	}
</style>

<%@include file="/html/init.jsp"%>

<%
	long legalFAQEntryId = ParamUtil.getLong(request, "legalFAQEntryId",0L);
	
	LegalFAQEntry legalFAQEntry = null;
	
	if(legalFAQEntryId > 0){
		
		legalFAQEntry = LegalFAQEntryLocalServiceUtil.incrementViewCounter(legalFAQEntryId);
	}
%>


<c:choose>
	<c:when test="<%=legalFAQEntry != null %>">
		<%
			String faqCategoryName = "other";
		
			if(legalFAQEntry.getCategoryId() > 0){
				
				LegalFAQCategory faqCategory = LegalFAQCategoryLocalServiceUtil.getCategory(legalFAQEntry.getCategoryId());
				
				if(faqCategory != null){
					
					faqCategoryName = faqCategory.getCategoryName();
				}
			}
		%>
		<div class="faq-entry-preview">
			<div class="faq-entry-title">
				<span><%=legalFAQEntry.getAskTitle() %></span>
			</div>
			<div class="faq-entry-content">
				<table>
																		
					<tr>			
						<td><liferay-ui:message key="category-name"/></td>
						<td><liferay-ui:message key="<%=faqCategoryName %>"/></td>
					</tr>
					
					<tr>			
						<td><liferay-ui:message key="sender-name"/></td>
						<td><%=legalFAQEntry.getCitizenName() %></td>
					</tr>
						
					<c:if test='<%=Validator.isNotNull(legalFAQEntry.getCitizenPhone()) %>'>		
						<tr>			
							<td><liferay-ui:message key="phone-numbers"/></td>
							<td><%=legalFAQEntry.getCitizenPhone() %></td>
						</tr>
					</c:if>			
					
					<c:if test='<%=Validator.isNotNull(legalFAQEntry.getCitizenAddress()) %>'>	
						<tr>			
							<td><liferay-ui:message key="address"/></td>
							<td><%=legalFAQEntry.getCitizenAddress() %></td>
						</tr>
					</c:if>
					
					<c:if test='<%=Validator.isNotNull(legalFAQEntry.getCitizenEmail()) %>'>	
						<tr>			
							<td><liferay-ui:message key="email-address"/></td>
							<td><%=legalFAQEntry.getCitizenEmail() %></td>
						</tr>
					</c:if>
									
					<tr>			
						<td><liferay-ui:message key="ask-date"/></td>
						<td><%=dateFormat.format(legalFAQEntry.getAskDate()) %></td>
					</tr>
																								
					<tr>			
						<td><liferay-ui:message key="ask-content"/></td>
						<td><liferay-ui:message key="<%=legalFAQEntry.getAskContent() %>"/></td>
					</tr>
					
					<c:if test='<%=Validator.isNotNull(legalFAQEntry.getAnswerContent()) %>'>
						<tr>			
							<td><liferay-ui:message key="answer-date"/></td>
							<td><%=dateFormat.format(legalFAQEntry.getAnswerDate()) %></td>
						</tr>
					
						<tr>			
							<td><liferay-ui:message key="answer-content"/></td>
							<td><liferay-ui:message key="<%=legalFAQEntry.getAnswerContent() %>"/></td>
						</tr>
					
						<tr>			
							<td><liferay-ui:message key="answer-user"/></td>
							<td><%=legalFAQEntry.getUserName() %></td>
						</tr>
					</c:if>
				</table>
			</div>
		</div>
				
		<div class="aui-button-holder">
			<aui:button value="update" name="updateFAQBtn" />
			<aui:button value="close" name="closePopupBtn"/>
		</div>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-info">
			<span><liferay-ui:message key="no-such-faq-entry-with-primary-key"/> <%=legalFAQEntryId %></span>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
	
		var updateFAQBtn = A.one('#<portlet:namespace/>updateFAQBtn');
				
		if(updateFAQBtn){
			
			updateFAQBtn.on('click',function(){

				Liferay.Util.getOpener().showFAQUpdateForm('<%=legalFAQEntryId %>');
				
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
