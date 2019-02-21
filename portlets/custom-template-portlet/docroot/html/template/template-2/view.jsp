<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>
<div class="custom-template-2">
	<c:if test="<%=Validator.isNotNull(styleTitle)%>">
		<div class="style-title">
			<h3><%=styleTitle%></h3>
			<div class="sperator"></div>
		</div>
	</c:if>
	<div class="style-content">
		<div class="text">
			<p><liferay-ui:message key="let-join-our-program"/></p>
		</div>
		<div class="action">
			<button onclick="location.href='/nop-ho-so'"><liferay-ui:message key="submit"/></button>
		</div>
	</div>
</div>