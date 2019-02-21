<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script type="text/javascript" src="/html/js/liferay/service.js" ></script>

<%@include file="/html/init.jsp"%>

<div id="<portlet:namespace />site-map-container"></div>


<aui:script use="portal-egov-sitemap">
	
	new Liferay.Portlet.SiteMap(
		{
			scopeGroupId: <%= groupId %>,
			container: '<portlet:namespace />site-map-container',
			rootLayoutId: <%=rootLayoutId %>,
			expandAllLayout: <%=expandAllLayout %>,
			highLightCurrentLayout: <%=highLightCurrentLayout %>
		}
	);
</aui:script>