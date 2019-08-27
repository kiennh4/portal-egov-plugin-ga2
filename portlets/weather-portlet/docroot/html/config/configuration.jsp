<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="weatherPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="weather-portlet-config-form" method="post" action="<%=weatherPortletConfigURL %>">
	<div class="weather_portlet_config_page">
		<aui:select name="displayCity" label="Chọn thành phố:">
			<%
				for (int i = 0;i<arrayCity.length;i++)
				{
			%>
				<aui:option label="<%=arrayCityVi[i] %>" value="<%=arrayCity[i] %>" selected='<%=Validator.equals(displayCity, arrayCity[i]) %>'/>
			<%
				}
			%>
		</aui:select>
		<br/>
		<aui:select name="displayCurrency" label="Chọn loại tỷ giá:">
			<%
				for (int i = 0;i<currencyType.length;i++)
				{
			%>
				<aui:option label="<%=currencyType[i] %>" value="<%=currencyType[i] %>" selected='<%=Validator.equals(displayCurrency, currencyType[i]) %>'/>
			<%
				}
			%>
		</aui:select>
	</div>
	<br/>
	<aui:button type="submit" value="save"/>
</aui:form>