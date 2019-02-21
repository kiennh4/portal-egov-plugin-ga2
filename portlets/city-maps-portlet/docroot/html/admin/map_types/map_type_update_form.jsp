<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMapType"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	//Id cua loai ban do lay tu URL (truong hop update)
	long mapTypeId = ParamUtil.getLong(request, "mapTypeId",0L);

	//Loai ban do
	CityMapType mapType = null;	
		
	if(mapTypeId > 0L){//truong hop update loai ban do
		
		mapType = CityMapTypeLocalServiceUtil.getCityMapType(mapTypeId);
	}
%>

<div class="citymap_admin">
	<liferay-portlet:renderURL var="redirectURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/admin/redirect.jsp"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:actionURL name="updateMapType" var="updateMapTypeActionURL">
		<liferay-portlet:param name="mapTypeId" value="<%=String.valueOf(mapTypeId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=redirectURL %>"/>
	</liferay-portlet:actionURL>
	
	<div class="city_map_admin_form">
		<aui:form name="map_type_update_form" method="post" action="<%=updateMapTypeActionURL %>">
			
			<aui:input  name="mapTypeName" value='<%=(mapType != null) ? mapType.getTypeName() : "" %>'>
				<aui:validator name="required" />
			</aui:input>
					
			<aui:input  name="mapTypeDesc" type="textarea" value='<%=(mapType != null) ? mapType.getTypeDesc() : "" %>'/>
			
			<aui:button type="submit" value="save"/>
			<aui:button name="closeUpdateFormBtn" value="cancel"/>
		</aui:form>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var mapTypeNameInput = A.one('#<portlet:namespace/>mapTypeName');
		
		if(mapTypeNameInput){
			mapTypeNameInput.focus();
		}
		
		var closeUpdateFormBtn = A.one('#<portlet:namespace/>closeUpdateFormBtn');
		
		if(closeUpdateFormBtn){
			
			closeUpdateFormBtn.on('click',function(){
				
				Liferay.Util.getWindow().close();
			});
		}
		
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />map_type_update_form,
	
	        rules: {
	            <portlet:namespace />mapTypeName: {
	                required: true,
	                rangeLength: ['3','300']
	            },
	            <portlet:namespace />mapTypeDesc: {
	                required: false,
	                rangeLength: ['0','450']
	            }
	        }
	    });
	});

</script>
