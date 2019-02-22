<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/tthc_lastest_entries_portlet/init.jsp"%>

<%
	List<TTHC_Entry> lastestTTHCEntryList = TTHC_EntryLocalServiceUtil.findByGroup(scopeGroupId, 0, numbersOfEntriesDisplay);
%>

<div class="tthc-lastest-entries">
	<ul>
		<%
			for(TTHC_Entry lastestEntry : lastestTTHCEntryList)
			{
				
				long tthcEntryId = lastestEntry.getEntryId();
				
				String entryName = lastestEntry.getEntryName();
				
				StringBundler sb = new StringBundler();

				sb.append("javascript:");
				sb.append("showTTHCPreviewDialog");
				sb.append("('");
				sb.append(tthcEntryId);
				sb.append("')");

				String	tthcPreviewURL = sb.toString();
		%>
				<li>	  		  
		  		    <a href="<%= tthcPreviewURL%>">
		  		    	<%=entryName%>
		  		    </a>
			    </li>
		<%
			}
		%>
	</ul>
</div>

<script type="text/javascript">

Liferay.provide(
	window,
	'showTTHCPreviewDialog',
	function(tthcEntryId) {
		
		var A = AUI();
		
		A.DialogManager.hideAll();
							
		var tthcPreviewRenderURL = Liferay.PortletURL.createRenderURL();
		
		if(tthcPreviewRenderURL){
			
			tthcPreviewRenderURL.setPortletId('<%=portletId %>');
			tthcPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
			tthcPreviewRenderURL.setParameter('jspPage', '/html/tthc_lastest_entries_portlet/tthc_preview.jsp');
			tthcPreviewRenderURL.setParameter('tthcEntryId', tthcEntryId);
			tthcPreviewRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
		}
																		
		var dialogAlignConfig = {
				node: '.tthc_search_form_wrapper',
				points: ['tl', 'tl']
		};
							   
		Liferay.Util.openWindow(
			{
				dialog: {
					align: dialogAlignConfig,
					constrain: true
				},
				id: '<portlet:namespace/>tthcPreviewDialog',
				title: '<%= UnicodeLanguageUtil.get(pageContext, "tthc-preview-content") %>',
				uri: tthcPreviewRenderURL
			}
		);
	},
	['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
);

</script>