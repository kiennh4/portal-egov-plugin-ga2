<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.tourism_map.model.TourismMapMarker"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long markerGroupId = 0L;

	long markerImageId = 0L;
	
	String markerImagePath = "";

	long markerId = ParamUtil.getLong(request, "markerId",0L);

	TourismMapMarker marker = null;
	
	if(markerId > 0){
		
		marker = TourismMapMarkerLocalServiceUtil.getMarker(markerId);
		
		if(marker != null){
			markerGroupId = marker.getMarkerGroupId();
			markerImageId = marker.getMarkerImageId();
			
			if(markerImageId > 0){
				markerImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + markerImageId + "&t" + WebServerServletTokenUtil.getToken(markerImageId);
			}
		}
	}
	
	//Danh sach cac nhom dia diem
	List<TourismMapMarkerGroup> markerGroupList = TourismMapMarkerGroupLocalServiceUtil.findByGroup(groupId);
%>

<liferay-portlet:renderURL var="mapAdminHomePageURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>
		
<liferay-portlet:actionURL name="updateMarker" var = "updateMarkerActionURl">
	<liferay-portlet:param name="markerId" value="<%=String.valueOf(markerId) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=mapAdminHomePageURL %>"/>
</liferay-portlet:actionURL>

<div class="tourism_map_admin">
	<div class="marker_update_form">
		<aui:form name="marker_update_form" enctype="multipart/form-data" method="post" action="<%=updateMarkerActionURl %>">
			
			<aui:select name="markerGroupId" label="select-marker-group">
				<%
				for(TourismMapMarkerGroup markerGroup : markerGroupList){
					
					long currentMarkerGroupId = markerGroup.getMarkerGroupId();
					
					String markerGroupName = markerGroup.getMarkerGroupName();
				%>
					<aui:option label="<%=markerGroupName %>" value="<%=String.valueOf(currentMarkerGroupId) %>"
								selected="<%= (currentMarkerGroupId == markerGroupId) %>"
					/>
				<%
				}
				%>
			</aui:select>
			
			<aui:input name="markerTitle" value='<%= (marker != null) ? marker.getMarkerTitle() : "" %>'>
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input name="markerLatitude" value='<%= (marker != null) ? marker.getMarkerLatitude() : "" %>'>
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input name="markerLongitude" value='<%= (marker != null) ? marker.getMarkerLongitude() : "" %>'>
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input name="markerInfo" type="textarea" value='<%= (marker != null) ? marker.getMarkerInfo() : "" %>'/>
			
			<aui:input name="markerAddress" type="textarea" value='<%= (marker != null) ? marker.getMarkerAddress() : "" %>'/>
								
			<c:if test='<%=Validator.isNotNull(markerImagePath) %>'>
				<liferay-ui:message key="marker-image"/>
				<img alt="" src="<%=markerImagePath%>" style="border: 1px solid #E4E4E4;">
			</c:if>
			
			<aui:input type="file" name="markerImageFile" label="choose-marker-image-file"/>
					
			<aui:button-row>
				<aui:button type="submit" value="save" />
				<aui:button type="button" name="closeDialogBtn" value="cancel"/>
			</aui:button-row>
		</aui:form>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var markerTitleInput = A.one('#<portlet:namespace/>markerTitle');
		
		if(markerTitleInput){
			markerTitleInput.focus();
		}
		
		var closeDialogBtn = A.one('#<portlet:namespace/>closeDialogBtn');
		
		if(closeDialogBtn){
			
			closeDialogBtn.on('click',function(){
				
				A.DialogManager.hideAll();
			});
		}
		
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />marker_update_form,
	
	        rules: {
	            <portlet:namespace />markerTitle: {
	                required: true,
	                rangeLength: ['3','300']
	            },
	            <portlet:namespace />markerLatitude: {
	                required: true,
	                rangeLength: ['3','75']
	            },
	            <portlet:namespace />markerLongitude: {
	                required: true,
	                rangeLength: ['3','75']
	            },
	            <portlet:namespace />markerInfo: {
	                required: false,
	                rangeLength: ['0','4000']
	            },
	            <portlet:namespace />markerAddress: {
	                required: false,
	                rangeLength: ['0','1000']
	            }
	        }
	    });
	});

</script>
