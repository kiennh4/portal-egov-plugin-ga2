<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%	
	String processGuide = "";

	TTHC_Entry tthcEntry = null;
	
	long tthcEntryId = ParamUtil.getLong(request, "tthcEntryId",0L);

	if(tthcEntryId > 0){
		
		tthcEntry = TTHC_EntryLocalServiceUtil.getTTHC_Entry(tthcEntryId);
		
		if(tthcEntry!= null){
			
			processGuide = tthcEntry.getProcessGuide();
		}
	}
%>

<h3><liferay-ui:message key="tthc-process-guide" /></h3>

<liferay-ui:input-editor name="processGuide" height="400" initMethod="initProcessGuideEditor"/>

<aui:input type="hidden" name="processGuide"/>

<aui:script>
	function <portlet:namespace />initProcessGuideEditor() {
		return "<%= UnicodeFormatter.toString(processGuide)%>";
	}
</aui:script>

