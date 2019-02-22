<%@page import="com.bkav.portal.portlet.topic.util.TopicUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.bkav.portal.portlet.topic.util.TopicAdminUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.topic.model.Topic"%>
<%@page import="com.bkav.portal.portlet.topic.permission.AdminTopicPermission"%>
<%@ include file = "/html/topicadmin/init.jsp" %>

<%

	String topicKey = ParamUtil.getString(request, "key","");

	int topicStart = ParamUtil.getInteger(request, "topicStart",-1); 
	
	int topicEnd = ParamUtil.getInteger(request, "topicEnd",-1); 

	int topicIndex = 0;
%>
<div class = "topic-admin">

	<div class="lfr-header-row">
		
		<div class="topic-admin-btn" align="left">
			
				<c:if test="<%=AdminTopicPermission.contains(permissionChecker, groupId, AdminTopicPermission.ADD)%>">
					<aui:button name="addTopicBtn" type="button" value="add-new-topic"/>
				</c:if>
				
				<c:if test="<%=AdminTopicPermission.contains(permissionChecker, groupId, AdminTopicPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=Topic.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="topic-permissions" />
				</c:if>
			
		</div>			
		
		<div class="topic-search-form" align="right">
		
			<input title="<liferay-ui:message key = 'at-least-3-char'/>" id='<portlet:namespace />topicSearchInput' type="text" value="<%=topicKey%>"/>
			
			<aui:button name="searchTopicBtn" type="button" value="search"/>
			
			<aui:button name="showAllBtn" type="button" value="show-all" />
		</div>
	</div>
	
	<div class = "list-topic">
			<liferay-ui:search-container 
				emptyResultsMessage="no-topic-found"
				delta = "20"
			>
			
			<liferay-ui:search-container-results >
			<% 
				List<Topic> listTopic = TopicLocalServiceUtil.findByTopicName(topicKey,groupId,topicStart, topicEnd, null);
				
				results = ListUtil.subList(listTopic, searchContainer.getStart(), searchContainer.getEnd());
				
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", listTopic.size());
				
			%>
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="com.bkav.portal.portlet.topic.model.Topic" keyProperty="topicId" modelVar="topicItem" >
				
				<%
					topicIndex++;
					
					String editTopicUrl = "javascript:;";
					
					if (AdminTopicPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE))
					{
						editTopicUrl = "javascript:" + renderResponse.getNamespace() 
								+ "showUpdateTopic(" + String.valueOf(topicItem.getTopicId()) + ");";
					}
				%>
				
				<liferay-ui:search-container-column-text 
					name = "#"
					href = "<%=editTopicUrl %>"  
					value = "<%=StringUtil.valueOf(topicIndex) %>"
				/>
				
				<liferay-ui:search-container-column-text 
					name = "topic-name"
					href = "<%=editTopicUrl %>"  
					value = "<%=topicItem.getTopicName() %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "topic-modify-date"  
					href = "<%=editTopicUrl %>"   
					value = "<%=StringUtil.valueOf(dateFormat.format(topicItem.getModifiedDate())) %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "topic-user" 
					href = "<%=editTopicUrl %>"   
					value = "<%=topicItem.getUserName() %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "list-categorys" 
				>
					<aui:select name = "listCategorys" >
					<%
					
						String[] categoryArrayId = TopicUtil.topicCategoryValidate(topicItem.getTopicId(),topicItem.getCategoryIds()).split(",");
					
						if ((categoryArrayId.length<=0)||(topicItem.getCategoryIds().equals("")))
						{
							
					%>
						<aui:option><liferay-ui:message key = "no-category"/></aui:option>
					<% 
						}
						else
						{
							for (int i = 0; i < categoryArrayId.length; i++)
							{
								AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(categoryArrayId[i]));
					%>
						<aui:option><%=category.getName() %></aui:option>
					<%
							}
						}
					%>
					</aui:select>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text 
					name = "action" 
				>
					<a href = 'javascript:;' onclick = '<portlet:namespace/>showUpdateTopic(<%=topicItem.getTopicId()%>)'>
						<c:if test="<%=AdminTopicPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE) %>">
																		
								
								<liferay-ui:icon image = "edit" />
							
						</c:if>
						</a>
					<c:if test="<%=AdminTopicPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
																	
							<liferay-portlet:actionURL  name="deleteTopic" var="deleteTopicActionURL">
								<liferay-portlet:param name="topicId" value="<%=String.valueOf(topicItem.getTopicId())%>"/>
								<liferay-portlet:param name="redirectURL" value="<%=topicAdminHomePageURL %>"/>
								
							</liferay-portlet:actionURL>
							
							<liferay-ui:icon-delete url="<%= deleteTopicActionURL %>" />
						
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
			
		</liferay-ui:search-container>
	</div>

</div>

<aui:script use="aui-dialog" >
	Liferay.provide(
		window,
		'<portlet:namespace/>showUpdateTopic',
		function(topicId){

			var topicUpdateUrl_ = Liferay.PortletURL.createRenderURL();
										
			topicUpdateUrl_.setPortletId('<%=topicAdminPortletId %>'); 
			topicUpdateUrl_.setParameter('jspPage', '/html/topicadmin/update_topic_form.jsp');
			topicUpdateUrl_.setParameter('topicId', topicId);
			topicUpdateUrl_.setDoAsGroupId('<%=groupId %>');
			
			location.href = topicUpdateUrl_;			
			
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace/>searchTopic',
		function(){

			var topicKey = document.getElementById('<portlet:namespace />topicSearchInput').value;

			var topicUpdateUrl_ = Liferay.PortletURL.createRenderURL();
										
			topicUpdateUrl_.setPortletId('<%=topicAdminPortletId %>'); 
			topicUpdateUrl_.setParameter('jspPage', '/html/topicadmin/view.jsp');
			topicUpdateUrl_.setParameter('key', topicKey);
			topicUpdateUrl_.setDoAsGroupId('<%=groupId %>');
			
			location.href = topicUpdateUrl_;			
			
		}
	);
	
	AUI().ready('aui-base','liferay-portlet-url',function(A){ 
	
		A.one('#<portlet:namespace/>addTopicBtn').on('click',function (){
			location.href = '<%=updateTopicURL %>';
		})
	
		A.one('#<portlet:namespace/>searchTopicBtn').on('click',function (){
			<portlet:namespace/>searchTopic();
		})
	
		A.one('#<portlet:namespace/>showAllBtn').on('click',function (){
			location.href = '<%=topicAdminHomePageURL %>';
		})
	
	});
	
</aui:script>