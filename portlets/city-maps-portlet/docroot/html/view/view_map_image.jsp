<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	String cityMapImagePath = ParamUtil.getString(request, "cityMapImagePath");

	String cityMapName = ParamUtil.getString(request, "cityMapName");
%>

	<c:if test='<%=Validator.isNotNull(cityMapImagePath) %>'>
	
		<div class="citi-map-image-view" align="center">
			<div class="city-map-image">
				<img alt="" src="<%=cityMapImagePath%>">
			</div>
		</div>
	</c:if>