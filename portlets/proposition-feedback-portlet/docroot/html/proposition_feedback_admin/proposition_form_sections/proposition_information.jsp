<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int propositionStatus = PropositionConstants.DEFAULT_PROPOSITION_STATUS_VALUE;
	
	long propositionDocFileId = 0L;

	long fileAttachmentMaxSize = GetterUtil.getLong(PropsUtil.get(PropsKeys.DL_FILE_MAX_SIZE));
	
	//Id cua du thao hien tai
	long propositionId = ParamUtil.getLong(request, "propositionId",0L);
	
	String propositionContent = "";
	
	Proposition currentProposition = null;
	
	if(propositionId > 0){
		currentProposition = PropositionLocalServiceUtil.getProposition(propositionId);
		
		if(currentProposition != null){
			
			propositionStatus = currentProposition.getStatus();
			propositionContent = currentProposition.getPropositionContent();
			propositionDocFileId = currentProposition.getDocumentFileId();
		}
	}
	
	//File van ban goc cua du thao luat
	DLFileEntry propositionDocFile = null;
	
	if(propositionDocFileId > 0L){
		propositionDocFile = PropositionUtil.getDocFileEntry(propositionDocFileId);
	}
%>

	<h3><liferay-ui:message key="proposition-information" /></h3>

	<aui:input type="textarea" name="propositionName" value='<%= (currentProposition != null) ? currentProposition.getPropositionName() : ""%>'>
		<aui:validator name="required"/>	
	</aui:input>
			
	<aui:input type="textarea" name="propositionDesc" value='<%= (currentProposition != null) ? currentProposition.getPropositionDesc() : ""%>' />
			
	<aui:select name="propositionStatus">
	
		<aui:option value="<%=PropositionConstants.DEFAULT_PROPOSITION_STATUS_VALUE %>" label="unpublish-proposition"
					selected="<%=propositionStatus == PropositionConstants.DEFAULT_PROPOSITION_STATUS_VALUE %>"/>
						
		<aui:option value="<%=PropositionConstants.PUBLISH_PROPOSITION_STATUS_VALUE %>" label="publish-proposition"
					selected="<%=propositionStatus == PropositionConstants.PUBLISH_PROPOSITION_STATUS_VALUE %>"/>
						
		<aui:option value="<%=PropositionConstants.UNRELEASE_PROPOSITION_STATUS_VALUE %>" label="unrelease-proposition"
					selected="<%=propositionStatus == PropositionConstants.UNRELEASE_PROPOSITION_STATUS_VALUE %>"/>
						
		<aui:option value="<%=PropositionConstants.RELEASED_PROPOSITION_STATUS_VALUE %>" label="released-proposition"
					selected="<%=propositionStatus == PropositionConstants.RELEASED_PROPOSITION_STATUS_VALUE %>"/>
	</aui:select>
		
	<c:if test="<%= propositionDocFile != null %>">
		<%
		String docfileName = propositionDocFile.getTitle();
		String docFileSize = TextFormatter.formatKB(propositionDocFile.getSize(), locale) + " KB";
		String docfileDownloadLink = PropositionUtil.getPropositionDocFileDownloadLink(propositionDocFileId, themeDisplay);
		%>
		<div class="proposition-doc-file-attach">
			<a href="<%=docfileDownloadLink%>">
				<%= docfileName + " (" + docFileSize + ")" %>
			</a>
		</div>
	</c:if>
			
	<aui:input type="file" name="propositionDocumentFile" />
					
	<div class="portlet-msg-info">
		<span><liferay-ui:message arguments="<%= String.valueOf(fileAttachmentMaxSize/(1024*1024)) %>" key="please-select-file-with-file-size-no-larger-than-x-mb" /></span>
	</div>
	
	<h3><liferay-ui:message key="proposition-content" /></h3>
		
	<liferay-ui:input-editor name="propositionContentEditor" height="400" initMethod="initPropositionContentEditor"/>
	
	<aui:input type="hidden" name="propositionContent"/>
		
	<aui:script>
		function <portlet:namespace />initPropositionContentEditor() {
			return "<%= UnicodeFormatter.toString(propositionContent)%>";
		}
	</aui:script>
			
