<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long markerGroupId = ParamUtil.getLong(request, "markerGroupId",0L);

	TourismMapMarkerGroup markerGroup = null;
	
	if(markerGroupId > 0){
		
		markerGroup = TourismMapMarkerGroupLocalServiceUtil.getMarkerGroup(markerGroupId);
	}
%>

<liferay-portlet:renderURL var="mapAdminHomePageURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>
		
<liferay-portlet:actionURL name="updateMarkerGroup" var = "updateMarkerGroupActionURL">
	<liferay-portlet:param name="markerGroupId" value="<%=String.valueOf(markerGroupId) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=mapAdminHomePageURL %>"/>
</liferay-portlet:actionURL>

<div class="tourism_map_admin">
	<div class="marker_group_update_form">
		<aui:form name="marker_group_update_form" method="post" action="<%=updateMarkerGroupActionURL %>">
			
			<aui:input name="markerGroupName" value='<%= (markerGroup != null) ? markerGroup.getMarkerGroupName() : "" %>'>
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input name="markerGroupInfo" type="textarea" value='<%= (markerGroup != null) ? markerGroup.getMarkerGroupInfo() : "" %>'/>
						
			<aui:button-row>
				<aui:button type="submit" value="save"/>
				<aui:button type="button" name="closeDialogBtn" value="cancel"/>
			</aui:button-row>
		</aui:form>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var markerGroupNameInput = A.one('#<portlet:namespace/>markerGroupName');
		
		if(markerGroupNameInput){
			markerGroupNameInput.focus();
		}
		
		var closeDialogBtn = A.one('#<portlet:namespace/>closeDialogBtn');
		
		if(closeDialogBtn){
			
			closeDialogBtn.on('click',function(){
				
				A.DialogManager.hideAll();
			});
		}
		
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />marker_group_update_form,
	
	        rules: {
	            <portlet:namespace />markerGroupName: {
	                required: true,
	                rangeLength: ['3','300']
	            },
	            <portlet:namespace />markerGroupInfo: {
	                required: false,
	                rangeLength: ['0','450']
	            }
	        }
	    });
	});

</script>
