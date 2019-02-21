<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.compaints.service.ComplaintLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.compaints.model.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int complaintIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		complaintIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}

	int complaintStatus = ParamUtil.getInteger(request, "complaintStatus",-1);

	String searchKeyword = HtmlUtil.escape(ParamUtil.getString(request, "searchKeyword"));
	
	String searchResultTitle = "";
	
	if(Validator.isNotNull(searchKeyword)){
		
		searchResultTitle = "complaint-search-result";
		
	}else{
		
		if(complaintStatus == 0){
			
			searchResultTitle = "complaint-entry";
		
		}else if(complaintStatus == 1){
			
			searchResultTitle = "complaint-feedback";
		}
	}
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	List<Complaint> searchResults = ComplaintLocalServiceUtil.findByKeyword(groupId, searchKeyword, complaintStatus, -1, -1, null);
%>

<div class="complaint-view">
	
	<liferay-portlet:renderURL var="complaintViewPageURL" >
		<liferay-portlet:param name="complaintStatus" value="-1"/>
	</liferay-portlet:renderURL>
	
	<div class="complaint-search-form">
			
		<div class="form-bg">
			<div class="title"><liferay-ui:message key="KNTC"/></div>
		</div>
		
		<div class="form-content">
			<aui:form name="fm" method="post" action="<%= complaintViewPageURL %>" >
			
					<div  class="search-guide" >
						<div class ="search-form-title"><liferay-ui:message key="complaint-search-title"/></div>

						<div class ="search-guide-content">
							<liferay-ui:message key="please-enter-document-name-or-keyword-on-search-content-below"/>
						</div>
					</div>
								
				<div class="lfr-form-row">
					<aui:input 	label=""
								name="searchKeyword" value='<%= searchKeyword%>'
								placeholder="complaint-search-input-holder" 
					/>
				
					<aui:button type="submit" value="search"/>
					<aui:button value="show-all" href="<%=complaintViewPageURL %>"/>
				</div>
				
			</aui:form>
		</div>	
	</div>	
	
	<div class="complaint-search-result">
		
		<div class="search-result-title"><liferay-ui:message key="<%=searchResultTitle %>"/></div>
									
		<liferay-portlet:renderURL varImpl="complaintViewPageImplURL">
			<liferay-portlet:param name="searchKeyword" value="<%=searchKeyword %>"/>
			<liferay-portlet:param name="complaintStatus" value="<%=String.valueOf(complaintStatus) %>"/>
		</liferay-portlet:renderURL>
			
		<liferay-ui:search-container iteratorURL="<%=complaintViewPageImplURL %>" emptyResultsMessage="no-data">
		
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(searchResults, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=searchResults.size() %>"
			/>
				
			<liferay-ui:search-container-row className="Complaint" keyProperty="complaintId" modelVar="complaint" escapedModel="<%=true %>">
				<%
				
				complaintIndex ++;
				
				String complaintTitle = StringUtil.shorten(complaint.getComplaintTitle(), 80);
				
				StringBundler sb = new StringBundler();

				sb.append("javascript:");
				sb.append("showComplaintPreviewDialog");
				sb.append("('");
				sb.append(complaint.getComplaintId());
				sb.append("','");
				sb.append(complaintTitle);
				sb.append("');");

				String	rowHREF = sb.toString();
				
				%>
		
				<liferay-ui:search-container-column-text 
					name="#" value="<%=String.valueOf(complaintIndex)%>" 
					title="view"
				/>
								
				<liferay-ui:search-container-column-text 
					name="title" 
					value="<%=complaintTitle%>" 
					href="<%=rowHREF %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="publish-date" 
					value="<%=simpleDateFormat.format(complaint.getCreateDate())%>"
					href="<%=rowHREF %>"
					title="view" 
				/>
												
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
	
<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		
		var complaintSearchInput = A.one('#<portlet:namespace/>searchKeyword');
		
		if(complaintSearchInput){
		
			complaintSearchInput.focus();
		}
	});
	
	Liferay.provide(
		window,
		'showComplaintPreviewDialog',
		function(complaintId,complaintTitle) {
			
			var A = AUI();
			
			A.DialogManager.hideAll();
								
			var complaintPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(complaintPreviewRenderURL){
				
				complaintPreviewRenderURL.setPortletId('<%=portletId %>');
				complaintPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				complaintPreviewRenderURL.setParameter('jspPage', '/html/view/preview.jsp');
				complaintPreviewRenderURL.setParameter('complaintId', complaintId);
				complaintPreviewRenderURL.setDoAsGroupId('<%=groupId %>');
			}
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						centered: true,
						constrain: true,
						width:680
					},
					id: '<portlet:namespace/>complaintPreviewDialog',
					title: complaintTitle,
					uri: complaintPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
</script>
