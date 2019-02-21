<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.asset.service.persistence.AssetEntryQuery"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.contentsharing.util.ContentSharingAdminUtil"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.bean.PortletBeanLocatorUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.bkav.portal.portlet.contentsharing.model.ContentSharing"%>
<%@page import="com.bkav.portal.portlet.contentsharing.service.ContentSharingLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.contentsharing.service.persistence.ContentSharingFinderUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@include file="/html/admin/init.jsp"%>
<style>

#toggle_asset_search {
	display:none;
}

</style>
<%
	long companyIdSelected = ParamUtil.getLong(request, "companyId",companyId);

	ContentSharing contentSharing = ContentSharingLocalServiceUtil.findByCompanyAndGroup(companyIdSelected, 
		GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId());

	String content = ParamUtil.getString(request, "tabs1",
			contentSharing.getContentSharing().split(StringPool.COMMA)[0]);
	
	List<Object> listObject = new ArrayList<Object>();

	List<AssetEntry> listAsset = new ArrayList<AssetEntry>();
	
	String classModel = "";
	
	boolean isAbleViewDetail = false;
	
	for (String ableView : contentAvailableViewDetail)
	{
		if (StringUtil.lowerCase(content).equals(ableView))
		{
			isAbleViewDetail = true;
			break;
		}
	}
	
	if (!content.equals("AssetEntry"))
	{
		
		classModel = ContentSharingAdminUtil.getContentClassModel(content);
		
		listObject = ContentSharingAdminUtil.getListItemContentSharing(companyIdSelected
				, ContentSharingAdminUtil.getServletContext(content)
				, ContentSharingAdminUtil.getContentClassModel(content)
				, ContentSharingAdminUtil.getContentClassUtil(content));
	}
	else
	{
		listAsset = ContentSharingAdminUtil.getListAssetEntry(companyIdSelected, 
				GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId());
	}
%>

<div class = "content-sharing-list">
	<c:choose>
		<c:when test="<%=(listAsset.size()>0) %>">
		<liferay-portlet:renderURL varImpl="searchURL">
			<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
		</liferay-portlet:renderURL>

	<aui:form action="<%=searchURL %>" method="post" name="searchForm">
	
		<liferay-portlet:renderURL varImpl="iteratorURL">
			<portlet:param name="companyId" value="<%=  String.valueOf(companyIdSelected) %>" />
			<portlet:param name="mvcPath" value="/html/admin/view.jsp" />
		</liferay-portlet:renderURL>
		
			<%
				int assetEntryIndex = 0;
			%>
			
			<liferay-ui:search-container 
				displayTerms="<%= new DisplayTerms(renderRequest) %>"
				emptyResultsMessage="no-article-found"
				delta = "20"
				iteratorURL="<%= iteratorURL %>"
			>
			<%
				DisplayTerms displayTerms = searchContainer.getDisplayTerms();
				
				displayTerms.setAdvancedSearch(false);
			%>
			
			<liferay-ui:search-toggle 
				buttonLabel="Search"
				displayTerms="<%= displayTerms %>"
				id="toggle_asset_search">
				
				<aui:input name="companyId" type="hidden" value = "<%=companyIdSelected %>" disabled="true"/>
				
			</liferay-ui:search-toggle>
			<aui:script>
				var A = AUI();
		    
			    A.all('.taglib-search-toggle').each(function() {
			      this.setStyle ('display','none');
			      
				});
			</aui:script>
				<liferay-ui:search-container-results >
				<%
					if (displayTerms.isAdvancedSearch()) {
						total = ContentSharingAdminUtil.getListAssetEntry(companyIdSelected, 
								GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId()).size();
					
						pageContext.setAttribute("results", ListUtil.subList( ContentSharingAdminUtil.getListAssetEntry(
								companyIdSelected, GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId())
								,searchContainer.getStart(), searchContainer.getEnd())
								);
						pageContext.setAttribute("total", total);
					}
					else
					{
						String searchkeywords = displayTerms.getKeywords();
						
						String numbesearchkeywords = Validator.isNumber(searchkeywords) ? searchkeywords : String.valueOf(0);
						
						System.out.println(searchkeywords);
						
						pageContext.setAttribute("results", ListUtil.subList( ContentSharingAdminUtil.getListAssetEntry(
								companyIdSelected, GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId())
								,searchContainer.getStart(), searchContainer.getEnd())
								);
						
// 						pageContext.setAttribute("results", ListUtil.subList( ContentSharingAdminUtil.getListAssetEntry(
// 								Long.parseLong(numbesearchkeywords), GroupLocalServiceUtil.getGroup(Long.parseLong(numbesearchkeywords), "Guest").getGroupId())
// 								,searchContainer.getStart(), searchContainer.getEnd())
// 								);
						pageContext.setAttribute("total", total);
					}
				
// 					results = ListUtil.subList(listAsset, searchContainer.getStart(), searchContainer.getEnd());
					
// 					pageContext.setAttribute("results", results);
// 					pageContext.setAttribute("total", listAsset.size());
				%>
					
				</liferay-ui:search-container-results>
			
				<liferay-ui:search-container-row className="com.liferay.portlet.asset.model.AssetEntry" keyProperty="entryId" modelVar="assetEntryItem" >
				
					<%
						assetEntryIndex ++;
					
						AssetRenderer assetRenderer = null;
						
						String title = "";
						
						try {
							assetRenderer = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(JournalArticle.class.getName()).getAssetRenderer(assetEntryItem.getClassPK());
							title = assetRenderer.getTitle(PortalUtil.getLocale(request));
						}
						catch (Exception e) {
							
						}
						
						String viewDetailUrl = "javascript:;";
						
						viewDetailUrl = "javascript:" + renderResponse.getNamespace() 
								+ "viewDetail('/html/admin/content-sharing-view/assetentry-view/view.jsp'"
								+ ","+companyIdSelected
								+ ","+GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId()
								+ ","+assetEntryItem.getEntryId()
								+")";
						String doCopyUrl = "javascript:" + renderResponse.getNamespace() 
								+ "doCopy('"+assetEntryItem.getClassPK()+"','"+assetEntryItem.getEntryId()+"')";
					%>
					
					<liferay-ui:search-container-column-text align="center" cssClass="width:10%"
					name = "#"
					href = "<%=viewDetailUrl %>"  
					value = "<%=StringUtil.valueOf(assetEntryIndex) %>"
					/>
					
					<liferay-ui:search-container-column-text 
					name = "title"
					href = "<%=viewDetailUrl %>"  
					value = "<%=title %>"
					/>
					
					<liferay-ui:search-container-column-text align="center"
					name = "modified-date"
					href = "<%=viewDetailUrl %>"  
					value = "<%=StringUtil.valueOf(dateFormat.format(assetEntryItem.getModifiedDate())) %>"
					/>
					
					<liferay-ui:search-container-column-text align="center"
					name = "status"
					href = "<%=viewDetailUrl %>"  
					value = "<%=assetEntryItem.getUserName() %>"
					/>
					
					<liferay-ui:search-container-column-text align="center"
					name = "action" 
					>
						<liferay-ui:icon image="copy" url="<%=doCopyUrl %>" onClick="" />
						
					</liferay-ui:search-container-column-text>
					
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
			
			</liferay-ui:search-container>
		</aui:form>	
			
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="<%=((listObject!=null)&&(listObject.size()>0)) %>">
					<table style = "width:100%">
						<thead>
							<tr>
							<%
								String[] listColoumnName = ContentSharingAdminUtil.getColumnName(content).split(StringPool.MINUS);
								String[] listMethod	= ContentSharingAdminUtil.getMethod(content).split(StringPool.MINUS);
							
								for (String columnName : listColoumnName)
								{
							%>
									<th >
										<%=columnName %>
									</th>
							<%
								}
							%>
								<th>
									<liferay-ui:message key="action"/>
								</th>
							</tr>
						</thead>
						<tbody>
							
							<%
								for (Object obj : listObject)
								{
							%>
								<tr>
							<%
								String objectId = "0";
								String viewDetailUrl = "javascript:;";
								String copyUrl = "javascript:;";
								
									for (int i = 0; i < listMethod.length; i++)
									{
										Object objTemp = Class.forName(classModel).cast(obj);
										
								 		Class noparams[] = {};
										
								 		Method method = Class.forName(classModel).getMethod(listMethod[i], noparams);
								 		
								 		if (i==0)
								 		{
								 			objectId = method.invoke(objTemp, null).toString();
								 			
								 			if (isAbleViewDetail)
											
											viewDetailUrl = "javascript:" + renderResponse.getNamespace() 
													+ "viewDetail('/html/admin/content-sharing-view/"
													+StringUtil.lowerCase(content)
													+"-view/view.jsp'"
													+ ","+companyIdSelected
													+ ","+GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId()
													+ ","+objectId
													+")";
								 			
								 			copyUrl = "javascript:" + renderResponse.getNamespace() 
													+ "viewDetail('/html/admin/content-sharing-action/"
													+StringUtil.lowerCase(content)
													+"-copy-action.jsp'"
													+ ","+companyIdSelected
													+ ","+GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId()
													+ ","+objectId
													+")";
								 		}
							%>
									<td><%=method.invoke(objTemp, null)%></td>
							<%
									}
							%>
									<td style = "text-align:center">
										<input type = "button" value = "copy" onclick = "<%=copyUrl%>">
										<input type = "button" value = "view" onclick = "<%=viewDetailUrl%>">
									</td>
								</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</c:when>
			</c:choose>
		</c:otherwise>
	</c:choose>
</div>

<aui:script use="aui-dialog" >
	Liferay.provide(
		window,
		'<portlet:namespace/>viewDetail',
		function(url, companyId, groupId, objectId){

			var viewDetailUrl = Liferay.PortletURL.createRenderURL();
										
			viewDetailUrl.setPortletId('<%=contentSharingAdminPortletId %>');
			viewDetailUrl.setWindowState('pop_up'); 
			viewDetailUrl.setParameter('jspPage', url);
			viewDetailUrl.setParameter('companyId', companyId);
			viewDetailUrl.setParameter('groupId',groupId);
			viewDetailUrl.setParameter('objectId',objectId);
			
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 800,
					height:700,
					draggable: true,
        			resizable: false,
					cache: false
				},
				title: '<liferay-ui:message key="detail" />',
				uri: viewDetailUrl
			};
			
			Liferay.Util.openWindow(dialogWidow);	
			
			//location.href = viewDetailUrl;			
			
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace/>doCopy',
		function(classPK, objectId){

			var viewDetailUrl = Liferay.PortletURL.createRenderURL();
										
			viewDetailUrl.setPortletId('<%=contentSharingAdminPortletId %>');
			viewDetailUrl.setWindowState('pop_up'); 
			viewDetailUrl.setParameter('jspPage', '/html/admin/content-sharing-action/assetentry-copy-action.jsp');
<!-- 			viewDetailUrl.setParameter('companyId', companyId); -->
<!-- 			viewDetailUrl.setParameter('groupId',groupId); -->
			viewDetailUrl.setParameter('classPK',classPK);
			viewDetailUrl.setParameter('objectId',objectId);
			
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 500,
					height:600,
					draggable: true,
        			resizable: false,
					cache: false
				},
				title: '<liferay-ui:message key="detail" />',
				uri: viewDetailUrl
			};
			
			var r = confirm ("<liferay-ui:message key="confirm-copy-content"/>?");
			
			if (r==true)
			{
				Liferay.Util.openWindow(dialogWidow);
			}	
			
		}
	);
	
</aui:script>