<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%	
	String processRequirement = "";

	TTHC_Entry tthcEntry = null;
	
	long tthcEntryId = ParamUtil.getLong(request, "tthcEntryId",0L);
	
	if(tthcEntryId > 0){
		
		tthcEntry = TTHC_EntryLocalServiceUtil.getTTHC_Entry(tthcEntryId);
		
		if(tthcEntry!= null){
			
			processRequirement = tthcEntry.getProcessRequirement();
		}
	}
%>

<h3><liferay-ui:message key="tthc-required-document" /></h3>

<liferay-ui:input-editor name="processRequirement" height="400" initMethod="initRequirementEditor"/>

<aui:input type="hidden" name="processRequirement"/>


<aui:script>
	function <portlet:namespace />initRequirementEditor() {
		return "<%= UnicodeFormatter.toString(processRequirement)%>";
	}
</aui:script>
