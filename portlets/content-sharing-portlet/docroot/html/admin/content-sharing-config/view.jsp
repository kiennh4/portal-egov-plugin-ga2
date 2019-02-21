<%@page import="com.bkav.portal.portlet.contentsharing.util.ContentSharingAdminUtil"%>
<%@page import="com.bkav.portal.portlet.contentsharing.model.ContentSharing"%>
<%@page import="com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Company"%>
<%@include file="/html/admin/init.jsp"%>
<%
	String[] listContent = PropsUtil.get("portal.key.content.allowed.sharing").split(StringPool.COMMA);

	ContentSharing contentSharingAvailable = ContentSharingLocalServiceUtil.fetchContentSharing(0);
	
	if (contentSharingAvailable!=null)
	{
		listContent = contentSharingAvailable.getContentSharing().split(StringPool.COMMA);
	}
	
	ContentSharing contentShared = ContentSharingLocalServiceUtil.findByCompanyAndGroup(companyId, groupId);

	String listContentName = ContentSharingAdminUtil.listContentName(listContent);
	
	String[] listContentSaved = new String[0];
	
	if (contentShared!=null)
	{
		listContentSaved = contentShared.getContentSharing().split(StringPool.COMMA);
	}
	
%>
<liferay-portlet:actionURL portletName = "<%=contentSharingAdminPortletId %>" name="updateListContentSharing" var="updateListContentSharingUrl" >
	<liferay-portlet:param name="companyId" value="<%=StringUtil.valueOf(CompanyLocalServiceUtil.getCompany(companyId).getCompanyId()) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=contentSharingAdminPageURL %>"/>
</liferay-portlet:actionURL>

<liferay-ui:error key = "save-error" message = "save-error" />

<div class = "header-control">
	<c:choose>
		<c:when test="<%=PortalUtil.isCompanyAdmin(user)%>">
			<aui:button href="<%=contentSharingConfigPageURL %>" value = "content-sharing-config" />
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="<%=PortalUtil.isOmniadmin(userId)%>">
			<aui:button href="<%=contentSharingConfigAdminPageURL %>" value = "content-sharing-config-admin" />
		</c:when>
	</c:choose>
</div>
<br>
<div class = "content-sharing-config">
<c:choose>
	<c:when test="<%=((listContent!=null)&&(listContent.length>0)) %>">
		<h3><liferay-ui:message key="list-content-can-be-share"/></h3>
		<aui:form method="POST" action="<%=updateListContentSharingUrl%>" >
			<%
				String[] listContentNameArr = listContentName.split(StringPool.COMMA);
			
				for (int i = 0; i < listContent.length; i++)
				{
					String checked = "";
					if ((listContentSaved!=null)&&(listContentSaved.length>0))
					{
						for (String contentSaved : listContentSaved)
						{
							if (contentSaved.equals(listContent[i]))
							{
								checked = "checked";
								break;
							}
						}
					}
			%>
					<c:choose>
						<c:when test="<%=((listContentNameArr!=null)&&(listContentNameArr[i]!=null)&&(!listContentNameArr[i].equals(StringPool.QUOTE))) %>">
							<input type="checkbox" class = "contentCheckbox" 
							name="contentAllowedCheckbox" 
							value="<%=listContent[i] %>" 
							<%=checked %>>
							<%=listContentNameArr[i] %>
							<br>
						</c:when>
						<c:otherwise>
							<input type="checkbox"  class = "contentCheckbox"
							name="contentAllowedCheckbox" 
							value="<%=listContent[i] %>" 
							<%=checked%>/>
							<%=listContent[i] %><br>
						</c:otherwise>
					</c:choose>
			<%
				}
			%>
			<br>
			<aui:button name = "save" type = "submit"/>
			<aui:button href="<%=contentSharingAdminPageURL %>" value = "back" />
		</aui:form>
	</c:when>
	
	<c:otherwise>
		<liferay-ui:message key="no-content-can-be-share"/>
	</c:otherwise>
	
</c:choose>
</div>