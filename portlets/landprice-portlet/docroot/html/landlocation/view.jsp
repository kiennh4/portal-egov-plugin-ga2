<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style>
		
	.land-location ul{
		padding: 0px;
		margin: 0px;
		list-style: none outside none;
	}
			
	.land-location ul li a{
		font-weight: bold;
		display: block;
	}
			
	.land-location .sub-location {
		margin-left: 10px;
	}
		
	.land-location .sub-location li{
		padding-left: 12px;
		padding: 6px;
		border-bottom: 1px solid #f6f7f8;
	}
		
	.land-location .sub-location li:hover{
		background: #D3E8F1;
	}
		
	.land-location .sub-location li.selected{
		background: #D3E8F1;
	}
						
	.land-location .sub-location li.selected a{
		color: #BC0000;
	}
			
	.land-location .sub-location li:last-child{
		border: none;
	}
			
	.land-location .sub-location a{
		background: url("/complaints-portlet/html/images/category_bullet.png") no-repeat scroll 5px 5px transparent;
		padding-left: 20px;
		font-weight: normal !important;
	}

</style>

<%@include file="/html/init.jsp"%>

<%
	long selectedLocationId = ParamUtil.getLong(request, "locationId");	

	List<LandLocation> rootLocationList = LandLocationLocalServiceUtil.findByParentLocation(0);
%>

<div class="land-location">
	<ul>
	<%
	for(LandLocation rootLocation : rootLocationList){
		
		long locationId = rootLocation.getLocationId();
		
		String locationName = rootLocation.getLocationName();
	
	%>
		<liferay-portlet:renderURL var="rootLocationViewURL" >
			<liferay-portlet:param name="locationId" value="<%=String.valueOf(locationId) %>"/>
		</liferay-portlet:renderURL>
		<li>
			<a href="<%=rootLocationViewURL%>"><%=locationName %></a>
		
	<%
		buildLandLocationTreeView(request, locationId,out, selectedLocationId);
	%>
		</li>
	<%
	}
	%>
	</ul>
</div>

<%!
protected void buildLandLocationTreeView(HttpServletRequest request,long parentLocationId,JspWriter jspWriter,long selectedLocationId){
	
	try{

		List<LandLocation> subLocationList = LandLocationLocalServiceUtil.findByParentLocation(parentLocationId);
		
		if(subLocationList.size() > 0){
			
			jspWriter.println("<ul class=\"sub-location\">");
			
			for(LandLocation subLocation : subLocationList){
				
				String subLocationName = subLocation.getLocationName();
				
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				
				PortletURL locationURL = PortletURLFactoryUtil.create(request, "landprice_WAR_landpriceportlet", 
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				
				locationURL.setParameter("locationId", String.valueOf(subLocation.getLocationId()));
				
				if(subLocation.getLocationId() == selectedLocationId){
					
					jspWriter.println("<li class=\"selected\" >" + "<a href=\" " + locationURL.toString() + "\" >" + subLocationName + "</a></li>");
				}else{
					
					jspWriter.println("<li>" + "<a href=\" " + locationURL.toString() + "\" >" + subLocationName + "</a></li>");
				}
				
				buildLandLocationTreeView(request,subLocation.getLocationId(),jspWriter, selectedLocationId);
			}
			
			jspWriter.println("</ul>");
		}
	}catch(Exception e){
		
	}
}
%>