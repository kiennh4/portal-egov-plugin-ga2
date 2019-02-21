<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="exRatePortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="exchange-rate-portlet-config-form" method="post" action="<%=exRatePortletConfigURL %>">
	<div class="exchange_rate_portlet_config_page">
		<aui:select name="displayStyle" label="">
			<aui:option label="default-style" value="<%=defaultDisplayStyle %>" selected='<%=Validator.equals(displayStyle, defaultDisplayStyle) %>'/>
			<aui:option label="gold-price-style" value="<%=goldPriceStyle %>" selected='<%=Validator.equals(displayStyle, goldPriceStyle) %>'/>
			<aui:option label="currency-rate-style" value="<%=currencyRateStyle %>" selected='<%=Validator.equals(displayStyle, currencyRateStyle) %>'/>
		</aui:select>
		
		<div id="<portlet:namespace />forexCode"></div>
	</div>
	<br/>
	<aui:button type="submit" value="save"/>
</aui:form>
