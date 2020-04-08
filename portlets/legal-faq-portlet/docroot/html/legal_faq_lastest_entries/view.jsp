<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/legal_faq_lastest_entries/init.jsp"%>


<%
	//List cau hoi co luot xem cao nhat
	List<LegalFAQEntry> topViewCountEntryList = LegalFAQEntryLocalServiceUtil.findByViewCount(scopeGroupId, 0L, 0, numbersOfTopViewEntriesDisplay);

	//List cau hoi moi cap nhat noi dung
	List<LegalFAQEntry> lastestEntryList = LegalFAQEntryLocalServiceUtil.findByGroupAndStatus(scopeGroupId,
		LegalFAQConstants.LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE, LegalFAQConstants.LEGAL_FAQ_ENTRY_ANSWERED_STATUS_VALUE, 0, numbersOfLastestEntriesDisplay);
%>


<div class="legal_faq_lastest_entries_default_style">
	<div class="legal_faq_tabs_name">
		<aui:layout>
			<aui:column columnWidth="50" id="top_view_entries">
				<a href='javascript:;'>
					<liferay-ui:message key="top-view-count-entries" />		
				</a>
			</aui:column>
			
			<aui:column columnWidth="50" id="lastest_entries">
				<a href='javascript:;'>
					<liferay-ui:message key="lastest-entries" />
				</a>
			</aui:column>
		</aui:layout>
	</div>

	<div class="tab_content">

		<div class="top_view_entries">
			<ul>
				<%
				for(LegalFAQEntry topViewCountEntry : topViewCountEntryList)
				{					
				%>
					<liferay-portlet:renderURL var="topViewCountEntryURL">
						<liferay-portlet:param  name="legalFAQEntryId" value="<%=String.valueOf(topViewCountEntry.getEntryId())%>"/>
					</liferay-portlet:renderURL>
					
					<li>
						<a href="<%=topViewCountEntryURL%>">
							<%=topViewCountEntry.getAskTitle() %>
						</a>
					</li>
				<%
				}
				%>			
			</ul>
		</div>
		
		<div class="lastest_entries">
			<ul>
				<%
				for(LegalFAQEntry lastestEntry : lastestEntryList)
				{					
				%>
					<liferay-portlet:renderURL var="lastestEntryURL">
						<liferay-portlet:param  name="legalFAQEntryId" value="<%=String.valueOf(lastestEntry.getEntryId())%>"/>
					</liferay-portlet:renderURL>
					
					<li>
						<a href="<%=lastestEntryURL%>">
							<%=lastestEntry.getAskTitle() %>
						</a>
					</li>
				<%
				}
				%>			
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		
		var portletId = '<%=portletId%>';
		
		var portletIdPrefix = '#_' + portletId + '_';
		
		var topViewEntriesTab = A.one(portletIdPrefix + 'top_view_entries');
		var lastestEntriesTab = A.one(portletIdPrefix + 'lastest_entries');
		
		var topViewEntriesContentDiv = A.one('.top_view_entries');
		var lastestEntriesContentDiv = A.one('.lastest_entries');
		
		if(topViewEntriesTab){
			
			topViewEntriesTab.addClass('active_tab');
			
			topViewEntriesTab.on('click', function(){
				
				topViewEntriesTab.removeClass('deactive_tab').addClass('active_tab');
				lastestEntriesTab.removeClass('active_tab');
				
				topViewEntriesContentDiv.removeClass('tab_content_deactive_div').addClass('tab_content_active_div');
				lastestEntriesContentDiv.removeClass('tab_content_active_div').addClass('tab_content_deactive_div');
			});
		}
			
		if(lastestEntriesTab){
			lastestEntriesTab.on('click', function(){
				
				lastestEntriesTab.removeClass('deactive_tab').addClass('active_tab');
				topViewEntriesTab.removeClass('active_tab');
				
				lastestEntriesContentDiv.removeClass('tab_content_deactive_div').addClass('tab_content_active_div');
				topViewEntriesContentDiv.removeClass('tab_content_active_div').addClass('tab_content_deactive_div');
			});
		}
	});
</script>


