<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="siteMapConfigURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<div class="site-map-config-panel">

	<aui:form name="site_map_config_form" method="post" action="<%=siteMapConfigURL%>">
	
			
		<aui:select name="rootLayoutId" label="select-root-layout">				
			<aui:option value="0" label="all" selected="<%= rootLayoutId == 0L%>"/>					
			<%
			for(Layout rootLayout : groupLayoutList){
				
			%>
				<aui:option value="<%=rootLayout.getLayoutId()%>" label="<%=rootLayout.getNameCurrentValue() %>"
							selected="<%=rootLayoutId == rootLayout.getLayoutId()%>"
				/>
			<%
			}
			%>	
		</aui:select>
		
		<aui:input type="checkbox" name="highLightCurrentLayout" value="<%= highLightCurrentLayout %>"/>
			
		<aui:input type="checkbox" name="expandAllLayout"  value="<%= expandAllLayout %>"/>
		
		<aui:button type="submit" value="save" />
	</aui:form>
</div>

