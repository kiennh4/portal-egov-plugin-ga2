<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Company"%>
<%@page import="com.bkav.portal.portlet.contentsharing.util.ContentSharingAdminUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.bkav.portal.portlet.contentsharing.model.ContentSharing"%>
<%@page import="com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil"%>
<%@include file="/html/admin/init.jsp"%>
<%

	ContentSharing contentSharing = ContentSharingLocalServiceUtil.findByCompanyAndGroup(companyId, groupId);

	String listContentNameTag = "";

	String[] listContentTag = null;
	
	String firstTabs = "";
	
	if (contentSharing!=null)
	{
		listContentTag = contentSharing.getContentSharing().split(StringPool.COMMA);
		
		listContentNameTag = ContentSharingAdminUtil.listContentName(listContentTag);
		
		firstTabs = contentSharing.getContentSharing().split(StringPool.COMMA)[0];
	}
	
	String  tabsContent = ParamUtil.getString(request,"tabs1"
			,firstTabs);
	
	long selectedCompanyId = ParamUtil.getLong(request, "companyId",companyId);
	
%>
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
<div class = "company-select-box">
		<aui:select name="companyId" inlineLabel="company-id">
			<%
				List<Company> listCompany = CompanyLocalServiceUtil.getCompanies();
			
				for (Company company : listCompany)
				{
			%>
					<aui:option value = "<%=company.getCompanyId() %>" 
						selected="<%=((selectedCompanyId==company.getCompanyId()) ? true : false) %>">
							<%=company.getName() %>
					</aui:option>
			<%
				}
				
			%>
		</aui:select>
		<aui:button  value = "show" name = "showBtn"  />
</div>
<br>
<div class = "content-sharing-view">

	<c:choose>
		<c:when test="<%=((listContentTag!=null)&&(!listContentNameTag.equals(StringPool.BLANK)))%>">
			<%
				String[] listContentNameTagArr = listContentNameTag.split(StringPool.COMMA);

				String tabsUrl = contentSharingAdminPageURL.toString()+"&_"+contentSharingAdminPortletId+"_companyId="+selectedCompanyId;
			
				//String tabs1 = listContentNameTag.split(StringPool.COMMA)[0];
			%>
			<liferay-ui:tabs tabsValues="<%=contentSharing.getContentSharing() %>" 
								names="<%=listContentNameTag %>"
							 	url="<%=tabsUrl %>"
			>
				<%
					for (int i = 0; i < listContentTag.length;i++)
					{
				%>
				
					<c:if test='<%=tabsContent.equals(listContentTag[i]) %>'>
					    <liferay-util:include page="/html/admin/content-sharing-view/list-content.jsp" 
					    					  servletContext="<%=this.getServletContext() %>"/>
					</c:if>
				<%
					}
				%>
			</liferay-ui:tabs>
		</c:when>
	</c:choose>
</div>
<aui:script>

	Liferay.provide(
		window,
		'<portlet:namespace/>listContent',
		function(){

			var companyId = document.getElementById('<portlet:namespace />companyId').value;

			var listContentByCompanyIdUrl = Liferay.PortletURL.createRenderURL();
										
			listContentByCompanyIdUrl.setPortletId('<%=contentSharingAdminPortletId %>'); 
			listContentByCompanyIdUrl.setParameter('jspPage', '/html/admin/view.jsp');
			listContentByCompanyIdUrl.setParameter('companyId', companyId);
			listContentByCompanyIdUrl.setParameter('tabs1', '<%=tabsContent %>');
			listContentByCompanyIdUrl.setDoAsGroupId('<%=groupId %>');
			
			location.href = listContentByCompanyIdUrl;			
			
		}
	);

	AUI().ready('aui-base','liferay-portlet-url',function(A){
	
		A.one('#<portlet:namespace/>showBtn').on('click',function(){
			<portlet:namespace/>listContent();
		});
	
	});
</aui:script>