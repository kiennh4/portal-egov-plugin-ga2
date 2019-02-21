<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<c:choose>
	<c:when test='<%=Validator.equals(displayStyle, goldPriceStyle) %>'>
		<liferay-util:include page="/html/view/gold_price.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:when>
	
	<c:when test='<%=Validator.equals(displayStyle, currencyRateStyle) %>'>
		<liferay-util:include page="/html/view/currency_rate.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:when>
	
	<c:otherwise>
		<liferay-util:include page="/html/view/gold_price.jsp" servletContext="<%=this.getServletContext() %>"/>
		
		<div style="clear: both;color:blue;"><hr></div>
		
		<liferay-util:include page="/html/view/currency_rate.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:otherwise>
</c:choose>