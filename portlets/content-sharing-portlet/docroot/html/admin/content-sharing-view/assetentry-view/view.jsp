<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@include file="/html/admin/init.jsp"%>
<%
	long objectId = ParamUtil.getLong(request, "objectId",0);
	
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(objectId);	

%>
<div class = "asset-entry-view" style = "height:600px;overflow-y:auto">
<c:choose>
	<c:when test="<%=(assetEntry!=null) %>">
		<%
			String className = PortalUtil.getClassName(assetEntry.getClassNameId());
			long classPK = assetEntry.getClassPK();	
		
			AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
			
			AssetRenderer assetRender = assetRendererFactory.getAssetRenderer(classPK);
			
			String title = assetRender.getTitle(PortalUtil.getLocale(request));
			
			String path = assetRender.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_FULL_CONTENT);
		%>
		<div class = "asset-entry-title" style = "">
			<b><%=title %></b>
		</div>
		<div class = "asset-entry-content">
			<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>" />
		</div>
	</c:when>
</c:choose>
</div>