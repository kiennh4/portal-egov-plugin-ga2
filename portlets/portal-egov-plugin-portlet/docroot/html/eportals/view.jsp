<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.ePortals"%>
<%@ include file = "/html/eportals/init.jsp"%>
<%
	int eportalIndex = 0;
	
	String ePortalName = ParamUtil.getString(request, "ePortalName", StringPool.BLANK);
	
	String ePortalCode = ParamUtil.getString(request, "ePortalCode", StringPool.BLANK);

	List<ePortals> listEPortal = new ArrayList<ePortals>();
	
	if ((!ePortalName.equals(StringPool.BLANK))||(!ePortalCode.equals(StringPool.BLANK)))
	{
		listEPortal = ePortalsLocalServiceUtil.findEportalByFilter(groupId, ePortalName, ePortalCode, -1, -1);
	}
	else
	{
		 listEPortal = ePortalsLocalServiceUtil.findByGroupId(groupId);
	}
%>
<div class = "eportals-list">
	<liferay-portlet:renderURL varImpl="searchURL" portletName="eportals_WAR_portalegovpluginportlet">
		<portlet:param name="mvcPath" value="/html/eportals/view.jsp" />
	</liferay-portlet:renderURL>
	<h3>
		<liferay-ui:message key="eportals"/>
	</h3>
	<hr>
	<div class = "eportals-search-form">
		<form action="<%=searchURL%>" method="post">
			<aui:fieldset>
				<aui:input name="ePortalName" inlineLabel="true" inlineField="true"/>
				<aui:input name="ePortalCode" inlineLabel="true" inlineField="true"/>
			</aui:fieldset>
			<aui:button type = "submit" value = "search"/>
		</form>
	</div>
	<hr>
	<div class = "eportals-list-content">
		<liferay-portlet:renderURL var="addPluginUrl">
			<liferay-portlet:param name="jspPage" value="/html/eportals/updateeportal.jsp"/>
		</liferay-portlet:renderURL>
		<aui:button type = "button" href="<%=addPluginUrl %>" value = "add-eportal"/>
		<liferay-ui:search-container
		emptyResultsMessage="no-plugin-found"
		delta = "1"
	>
		<liferay-ui:search-container-results >
			<%
				results = listEPortal;
				
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", listEPortal.size());
			%>
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row className="com.bkav.portal.portlet.portalplugins.model.ePortals" keyProperty="eportalId" modelVar="eportal" >
			<%
					String eportalEditUrl = "javascript: "
								+PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request))
								+"viewPluginDetail("+eportal.getEportalId()+");";
					eportalIndex++;
			%>
			<liferay-ui:search-container-column-text 
					name = "#"
					href = "<%=eportalEditUrl %>"  
					value = "<%=StringUtil.valueOf(eportalIndex) %>"
				/>
				
				<liferay-ui:search-container-column-text 
					name = "e-portal-name"
					href = "<%=eportalEditUrl %>"   
					value = "<%=eportal.getEportalName() %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "e-portal-code"  
					href = "<%=eportalEditUrl %>"  
					value = "<%=eportal.getEportalCode() %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "e-portal-version" 
					href = "<%=eportalEditUrl %>"    
					value = "<%=StringUtil.valueOf(eportal.getEportalVersion()) %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "domain" 
					href = "<%=eportalEditUrl %>"     
					value = "<%=StringUtil.valueOf(eportal.getEportalDomain()) %>"
				/>
				<liferay-ui:search-container-column-text name = "action" >
					<liferay-portlet:renderURL var="updateEPoralUrl">
						<liferay-portlet:param name="jspPage" value="/html/eportals/updateeportal.jsp"/>
						<liferay-portlet:param name="ePortalId" value="<%=StringUtil.valueOf(eportal.getEportalId()) %>"/>
					</liferay-portlet:renderURL>
					<liferay-portlet:actionURL name = "deleteEPortal" var="deleteEPortalUrl">
						<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
						<liferay-portlet:param name="ePortalId" value="<%=StringUtil.valueOf(eportal.getEportalId()) %>"/>
					</liferay-portlet:actionURL>
					<liferay-ui:icon-menu>
						 <liferay-ui:icon image="edit" message="edit" url="<%=updateEPoralUrl%>"   />
						 <liferay-ui:icon image="delete" message="delete" url="<%=deleteEPortalUrl%>"   />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	</div>
</div>