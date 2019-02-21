<%@page import="com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.ePortals"%>
<%@ include file = "/html/eportals/init.jsp"%>
<%
	long ePortalId = ParamUtil.getLong(request, "ePortalId");
	ePortals portal = ePortalsLocalServiceUtil.fetchePortals(ePortalId);
%>
<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="jspPage" value="/html/eportals/view.jsp"/>
</liferay-portlet:renderURL>
<div class = "update-eportals">
	<c:choose>
		<c:when test="<%=(portal!=null) %>">
			<liferay-portlet:actionURL name="updateEPortal" var="updateEPortalUrl">
				<liferay-portlet:param name="ePortalId" value="<%=Long.toString(portal.getEportalId()) %>"/>
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
			<h3>
				<liferay-ui:message key="update-eportal"/>
			</h3>
			<div class = "update-eportal-update-form">
				<aui:form action="<%=updateEPortalUrl %>" method="post">
					<aui:input type = "text" name = "ePortalName" value = "<%=portal.getEportalName() %>"/>
					<aui:input type = "text" name = "ePortalCode" value = "<%=portal.getEportalCode() %>" disabled="true"/>	
					<aui:input type = "text" name = "ePortalDomain" value = "<%=portal.getEportalDomain() %>"/>	
					<aui:input type = "text" name = "ePortalVersion" value = "<%=portal.getEportalVersion() %>"/>	
					<aui:button type = "submit" value = "save"/>
					<aui:button type = "button" href="<%=backURL %>" value = "cancel"/>
				</aui:form>
			</div>
		</c:when>
		<c:otherwise>
			<liferay-portlet:actionURL name="addEPortal" var="addEPortalUrl">
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
			<h3>
				<liferay-ui:message key="update-eportal"/>
			</h3>
			<div class = "update-eportal-update-form">
				<aui:form action="<%=addEPortalUrl %>" method="post">
					<aui:input type = "text" name = "ePortalName" />
					<aui:input type = "text" name = "ePortalCode"  />	
					<aui:input type = "text" name = "ePortalDomain" />	
					<aui:input type = "text" name = "ePortalVersion" />	
					<aui:button type = "submit" value = "save"/>
					<aui:button type = "button" href="<%=backURL %>" value = "cancel"/>
				</aui:form>
			</div>
		</c:otherwise>
	</c:choose>
	<h3>
	</h3>
</div>