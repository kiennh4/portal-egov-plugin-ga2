<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.portal_egov.portlet.landprice.service.LandPriceLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandPrice"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandLocation"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	
	int statisticYear = ParamUtil.getInteger(request, "statisticYear");

	long locationId = 0L;

	long priceId = ParamUtil.getLong(request, "priceId");

	String landPriceContent = "";
	
	LandPrice landPrice = null;
	
	if(priceId > 0){
		
		landPrice = LandPriceLocalServiceUtil.getLandPrice(priceId);
		
		if(landPrice != null){
			
			locationId = landPrice.getLocationId();
			landPriceContent = landPrice.getContent();
		}
	}
	
	List<LandLocation> rootLocationList = LandLocationLocalServiceUtil.findByParentLocation(0);
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitPriceUpdateForm();";
%>


<div class="landprice-update-form">

	<liferay-portlet:renderURL var="landPriceAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="LandPrice"/>
	</liferay-portlet:renderURL>

	<liferay-ui:header
		backURL="<%= landPriceAdminURL %>"
		title='<%= (landPrice != null) ? StringUtil.shorten(landPrice.getTitle(),80) : "add-new-land-price" %>'
	/>
		
	<liferay-portlet:actionURL name="updateLandPrice" var="updateLandPriceActionURL" >
		<liferay-portlet:param name="priceId" value="<%=String.valueOf(priceId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=landPriceAdminURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form name="fm" method="post" action="<%= updateLandPriceActionURL %>">
		
		<aui:model-context bean="<%= landPrice %>" model="<%= LandPrice.class %>" />
		
		<aui:select name="statisticYear" label="statistic-year">
			<aui:option label="<%=currentYear %>" value="<%=currentYear %>" selected="<%=statisticYear == currentYear %>"/>
			<aui:option label="<%=currentYear-1 %>" value="<%=currentYear-1 %>" selected="<%=statisticYear == currentYear-1 %>"/>
			<aui:option label="<%=currentYear-2 %>" value="<%=currentYear-2 %>" selected="<%=statisticYear == currentYear-2 %>"/>
			<aui:option label="<%=currentYear-3 %>" value="<%=currentYear-3 %>" selected="<%=statisticYear == currentYear-3 %>"/>
		</aui:select>
		
		<aui:select name="locationId" label="land-location">
		
			<aui:option label="none" value="0" selected="<%=locationId == 0L %>"/>
			
			<%
			for(LandLocation rootLocation : rootLocationList){
			%>
			<aui:option label="<%=rootLocation.getLocationName() %>" value="<%=rootLocation.getLocationId() %>" 
						selected="<%=locationId == rootLocation.getLocationId() %>"/>
			<%
			
				buildLandLocationTree(rootLocation.getLocationId(), 1, out, locationId);
			}
			%>
		</aui:select>
		
		<aui:input type="text" name="title" >
			<aui:validator name="required"/>
		</aui:input>
		
		<span class="aui-field-label"><liferay-ui:message key="price-content"/></span>
		<liferay-ui:input-editor name="landPriceContent" height="400" initMethod="initLandPriceContentEditor"/>
		
		<aui:input type="hidden" name="landPriceContent"/>
				
		<aui:button-row>
			<aui:button type="submit" value='save'/>
	
			<aui:button href="<%= landPriceAdminURL %>" type="cancel"/>
		</aui:button-row>
	</aui:form>
</div>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		Liferay.provide(
			window,
			'<portlet:namespace />submitPriceUpdateForm',
			function() {
				
				var portletContainer = A.one('#p_p_id_landprice_admin_WAR_landpriceportlet_');

				portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
				
				portletContainer.loadingmask.toggle();
				
				var landPriceContent = window.<portlet:namespace />landPriceContent.getHTML();
				
				A.one('#<portlet:namespace/>landPriceContent').val(landPriceContent);
				
				document.<portlet:namespace />fm.submit();
			}
		);
	});

</script>
	
<aui:script>
	function <portlet:namespace />initLandPriceContentEditor() {
		return "<%= UnicodeFormatter.toString(landPriceContent)%>";
	}
</aui:script>