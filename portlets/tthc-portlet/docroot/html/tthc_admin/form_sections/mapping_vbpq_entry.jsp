<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Category"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Attribute"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int vbpqMappingEntryIndex = 0;

	//List chua danh sach vbpq mapping voi thu tuc hien tai
	List<TTHC_Attribute> vbpqMappingAttributeList = new ArrayList<TTHC_Attribute>();
	
	//Danh sach VBPQ quy dinh thu tuc
	List<VBPQ_Entry> vbpqMappingList = new ArrayList<VBPQ_Entry>();
	
	long tthcEntryId = ParamUtil.getLong(request, "tthcEntryId",0L);
	
	if(tthcEntryId > 0){//Truong hop update thu tuc
		
		vbpqMappingAttributeList = TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndGroup(scopeGroupId, tthcEntryId, TTHCConstants.VBPQ_ID_ATTRIBUTE_TYPE_ID);
	}
	
	for(TTHC_Attribute vbpqMappingAttribute : vbpqMappingAttributeList){
		
		long vbpqMappingId = GetterUtil.getLong(vbpqMappingAttribute.getAttributeValue(), 0L);
		
		if(vbpqMappingId > 0){
			
			VBPQ_Entry vbpqMapping = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(vbpqMappingId);
			
			if(vbpqMapping != null){
				
				vbpqMappingList.add(vbpqMapping);
			}else{
				
				TTHC_AttributeLocalServiceUtil.deleteTTHC_Attribute(vbpqMappingAttribute);
			}
		}
	}
%>

<h3><liferay-ui:message key="mapping-vbpq-entry" /></h3>

<c:if test="<%=vbpqMappingList.size() <= 0 %>">
	<div class="portlet-msg-info">
		<liferay-ui:message key="select-vbpq-entry"/>
	</div>
</c:if>
	
<div class="vbpq_mapping_list">

	<liferay-util:buffer var="removeVBPQIcon">
		<liferay-ui:icon image="unlink" label="<%=true %>" message="remove"/>
	</liferay-util:buffer>
	
	<liferay-ui:search-container headerNames="#,title,department,null" id="vbpqMappingSearchContainer">
		<liferay-ui:search-container-results 
				results="<%=vbpqMappingList %>"
				total="<%=vbpqMappingList.size() %>"
		/>
		
		<liferay-ui:search-container-row className="VBPQ_Entry" keyProperty="entryId" modelVar="vbpqMappingEntry" >
			<%
			
			vbpqMappingEntryIndex ++;
			
			long vbpqId = vbpqMappingEntry.getEntryId();
			//Co quan ban hanh
			String vbpqDepartmentName = "";
			
			if(vbpqMappingEntry.getDepartmentId() > 0){
				
				VBPQ_Category vbpqDepartment =  VBPQ_CategoryLocalServiceUtil.getVBPQ_Category(vbpqMappingEntry.getDepartmentId());
				
				if(vbpqDepartment != null){
					
					vbpqDepartmentName = vbpqDepartment.getCategoryName();
				}
			}
			
			%>
			
			<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(vbpqMappingEntryIndex) %>"/>
			<liferay-ui:search-container-column-text name="title" value="<%=vbpqMappingEntry.getEntryName() %>"/>
			<liferay-ui:search-container-column-text name="department" value="<%=vbpqDepartmentName %>"/>
			
			<liferay-ui:search-container-column-text>
				<a class="modify-link" data-rowId="<%= vbpqId %>" href="javascript:;"><%= removeVBPQIcon %></a>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="<%= false %>" />
	</liferay-ui:search-container>
</div>

<div class="aui-button-holder">
	<aui:button name="select-vbpq-document" value="select-vbpq" onClick='openVBPQSelectBrowser();'/>
</div>

<aui:script>

	var vbpqMappingEntryIndex = <%=vbpqMappingEntryIndex %>;
	
	function openVBPQSelectBrowser() {
	
		var url = '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">';	   	 		        
			url += '<liferay-portlet:param name="jspPage" value="/html/tthc_admin/form_sections/vbpq_list.jsp" />';
	        url += '</liferay-portlet:renderURL>';
	     														
		var dialogAlignConfig = {
				node: '#_tthc_entry_management_WAR_tthcportlet_select-vbpq-document',
				points: ['tl', 'tl']
		};
							   
		Liferay.Util.openWindow(
			{
				dialog: {
					align: dialogAlignConfig,
					constrain: true,
					width: 820
				},
				id: 'asset_browser',
				title: '<%= UnicodeLanguageUtil.get(pageContext, "vbpq-select") %>',
				uri: url
			}
		);
	}

	Liferay.provide(
		window,
		'addVBPQLink',
		function(vbpqId, vbpqTitle, vbpqDepartment) {
			var A = AUI();

			vbpqMappingEntryIndex ++;
			
			var searchContainerName = 'vbpqMappingSearchContainer';

			searchContainer = Liferay.SearchContainer.get(searchContainerName);

			var vbpqLink = '<a class="modify-link" data-rowId="' + vbpqId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeVBPQIcon) %></a>';

			searchContainer.addRow([vbpqMappingEntryIndex,vbpqTitle, vbpqDepartment, vbpqLink], vbpqId);

			searchContainer.updateDataStore();
		},
		['liferay-search-container']
	);

</aui:script>

<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('vbpqMappingSearchContainer');

	searchContainer.get('contentBox').delegate(
		'click',
		function(event) {
			var link = event.currentTarget;

			var tr = link.ancestor('tr');

			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		},
		'.modify-link'
	);
</aui:script>

