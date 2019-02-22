<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Category"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<style type="text/css">
	.vbpq_search_form input[type="text"]{
		width: 300px;
	}
	.vbpq_list_title{
		font-size: 18px;
		font-weight: normal;
		color: #00528B;
		padding-bottom: 15px;
		text-transform: uppercase;
	}
</style>

<%

	int vbpqEntryIndex = 0;

	//Tu khoa tim kiem vbpq
	String vbpqSearchKeyword = ParamUtil.getString(request, "vbpqSearchKeyword",StringPool.BLANK);

	//Ket qua tim kiem VBPQ theo tu khoa
	List<VBPQ_Entry> vbpqEntryList = VBPQ_EntryLocalServiceUtil.findByKeyword(vbpqSearchKeyword, scopeGroupId,0,-1);
	
	//Ten co quan ban hanh VBPQ
	String departmentName = "others";
	
	//Ten method xu ly viec add them vbpq duoc chon vao danh sach mapping tren cua so chinh
	String callbackMethod = "addVBPQLink";

%>
<div class="vbpq_list_title" align="center"><liferay-ui:message key="vbpq-list"/></div>
<div class=tthc_admin>
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			
			<liferay-portlet:renderURL var="vbpqSearchFormURL"  windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<liferay-portlet:param name="jspPage" value="/html/tthc_admin/form_sections/vbpq_list.jsp" />			
			</liferay-portlet:renderURL>
			
			<div class="vbpq_search_form" align="right">
				<aui:form name="vbpq_search_form" method="post" action="<%=vbpqSearchFormURL %>">				
					<input type="text" name="vbpqSearchKeyword" value='<%= vbpqSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button value="show-all" href="<%=vbpqSearchFormURL %>"/>
				</aui:form>	
			</div>	
		</div>
	</div>
	
	<br/>
	
	<div id="vbpq_list">
				
		<liferay-portlet:renderURL varImpl="vbpqEntryListImplURL">
			<liferay-portlet:param name="jspPage" value="/html/tthc_admin/form_sections/vbpq_list.jsp" />			
		</liferay-portlet:renderURL>
			
		<liferay-ui:search-container emptyResultsMessage="no-vbpq-found" delta="5" iteratorURL="<%=vbpqEntryListImplURL %>">
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(vbpqEntryList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=vbpqEntryList.size() %>"
			>			
			</liferay-ui:search-container-results>
				
			<liferay-ui:search-container-row className="VBPQ_Entry" keyProperty="entryId" modelVar="vbpqEntry" >
				<%
					vbpqEntryIndex ++;
				
					if(vbpqEntry.getDepartmentId() > 0){
						
						VBPQ_Category vbpqCategory = VBPQ_CategoryLocalServiceUtil.getCategory(vbpqEntry.getDepartmentId());
						
						if(vbpqCategory != null){
							departmentName = vbpqCategory.getCategoryName();
						}
					}

					StringBundler sb = new StringBundler(9);

					sb.append("javascript:Liferay.Util.getOpener().");
					sb.append(callbackMethod);
					sb.append("('");
					sb.append(vbpqEntry.getEntryId());
					sb.append("', '");
					sb.append(vbpqEntry.getEntryName());
					sb.append("', '");
					sb.append(departmentName);
					sb.append("');Liferay.Util.getWindow().close();");
	
					String	rowHREF = sb.toString();
					
				%>																					
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(vbpqEntryIndex) %>" href="<%=rowHREF %>"/>										
				<liferay-ui:search-container-column-text name="Title" value="<%=vbpqEntry.getEntryName() %>" href="<%=rowHREF %>"/>
								
				<liferay-ui:search-container-column-text name="Department" value="<%=departmentName %>" href="<%=rowHREF %>"/>
					
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
