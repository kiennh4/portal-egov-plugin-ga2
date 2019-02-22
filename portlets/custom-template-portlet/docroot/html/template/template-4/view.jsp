<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/init.jsp"%>
<div class="custom-template-4">
	<c:if test="<%=Validator.isNotNull(styleTitle)%>">
		<div class="style-title">
			<h3><%=styleTitle%></h3>
			<div class="sperator"></div>
		</div>
	</c:if>
	<portlet:actionURL var="editUrl" name="fixExpandoTable"/>
	<div class="frm-register">
		<aui:form class="form-inline" action="<%=editUrl%>" method="post">
			<input type="text" id="rgst"
				placeholder="<liferay-ui:message key="put-your-email"/>" name="rgst">
			<button type="submit" class="btn-submit"><liferay-ui:message key="register"/></button>
		</aui:form>
		<div style="clear: both;"></div>
	</div>
</div>