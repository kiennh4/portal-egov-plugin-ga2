<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/init.jsp"%>
<div class="custom-template-3">
	<c:if test="<%=Validator.isNotNull(styleTitle)%>">
		<div class="style-title">
			<h3><%=styleTitle%></h3>
			<div class="sperator"></div>
		</div>
	</c:if>
	<div class="contact">
		<ul>
			<li>
				<a href="javascript:;" title="<liferay-ui:message key='via-facebook'/>">
					<img src="/custom-template-portlet/images/icon/facebook.png" alt="<liferay-ui:message key='via-facebook'/>"/>
				</a>
			</li>
			<li>
				<a href="javascript:;" title="<liferay-ui:message key='via-twitter'/>">
					<img src="/custom-template-portlet/images/icon/twitter.png" alt="<liferay-ui:message key='via-twitter'/>"/>
				</a>
			</li>
			<li>
				<a href="javascript:;" title="<liferay-ui:message key='via-zalo'/>">
					<img src="/custom-template-portlet/images/icon/zalo.png" alt="<liferay-ui:message key='via-twitter'/>"/>
				</a>
			</li>
		</ul>
	</div>
</div>