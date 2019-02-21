<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.bkav.portal.portlet.rss.permission.RssFeedPermission"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bkav.portal.portlet.rss.service.RssFeedLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.rss.model.RssFeed"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	int feedIndex = 0;
	
	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		feedIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}

	String rssAdminPortletResource = "rssadmin_WAR_rssportlet";
	
	String rssSearchKeyword = ParamUtil.getString(request, "rssSearchKeyword");
	
	List<RssFeed> groupFeeds = RssFeedLocalServiceUtil.findByKeyword(groupId, rssSearchKeyword, 0, -1);
%>

<liferay-portlet:renderURL varImpl="rssAdminRenderURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="rssAdminRenderImplURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="rssSearchKeyword" value="<%=rssSearchKeyword %>"/>
</liferay-portlet:renderURL>

<div class="rss-search">
	<aui:form name="rss_search_fm" method="post" action="<%=rssAdminRenderImplURL.toString() %>">
	
		<input type="text" id="<portlet:namespace/>rssSearchKeywordInput" name="rssSearchKeyword" 
				value="<%=rssSearchKeyword %>"/>
		
		<aui:button type="submit" value="search"/>
		
		<aui:button value="show-all" href="<%=rssAdminRenderURL.toString() %>"/>
		
		<aui:button name="addNewFeedBtn" value="add-new-feed"/>
	</aui:form>
</div>

<div style="clear: both;"></div>

<div class="separator"></div>

<div class="rss-list">
		
	<liferay-ui:search-container iteratorURL="<%=rssAdminRenderImplURL %>" delta="10">
	
		<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(groupFeeds, searchContainer.getStart(), searchContainer.getEnd()) %>" 
			total="<%=groupFeeds.size() %>"
		/>
		<liferay-ui:search-container-row className="RssFeed" keyProperty="id_" modelVar="rssFeed">
			
			<%
				feedIndex ++;
			
				long feedId = rssFeed.getId_();
				
				String updateRssFeedURL = "javascrip:;";
				
				if(RssFeedPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)){
					
					updateRssFeedURL = "javascript:" + renderResponse.getNamespace() 
										+ "showFeedUpdateForm(" + String.valueOf(feedId) + ");";
				}
			%>
			
			<liferay-ui:search-container-column-text 
				name="#" 
				value="<%=String.valueOf(feedIndex)%>" 
				href="<%=updateRssFeedURL %>"
				title="select"
			/>
											
			<liferay-ui:search-container-column-text 
				name="feed-name"
				value="<%=rssFeed.getName()%>" 
				href="<%=updateRssFeedURL %>"
				title="select"
			/>
															
			<liferay-ui:search-container-column-text 
				name="feed-url" 
				value="<%=rssFeed.getUrl()%>" 
				href="<%=updateRssFeedURL %>"
				title="select"
			/>
											
			<liferay-ui:search-container-column-text 
				name="create-date" 
				value="<%=dateTimeFormat.format(rssFeed.getCreateDate())%>"
				href="<%=updateRssFeedURL %>"
				title="select"
			/>
							
			<c:if test="<%=RssFeedPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE) %>">
				<liferay-ui:search-container-column-text name="edit">															
					<liferay-ui:icon image="edit" message="edit" url="<%= updateRssFeedURL %>" />
				</liferay-ui:search-container-column-text>
			</c:if>
																								
			<c:if test="<%=RssFeedPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
				<liferay-ui:search-container-column-text name="delete">													
					<liferay-portlet:actionURL  name="deleteRssFeed" var="deleteFeedURL">
						<liferay-portlet:param name="feedId" value="<%=String.valueOf(feedId)%>"/>
					</liferay-portlet:actionURL>
					
					<liferay-ui:icon-delete url="<%= deleteFeedURL %>" />
				</liferay-ui:search-container-column-text>
			</c:if>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator paginate="<%=true %>"/>
	</liferay-ui:search-container>
</div>

<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		var rssSearchKeywordInput = A.one('#<portlet:namespace/>rssSearchKeywordInput');
		
		if(rssSearchKeywordInput){
			rssSearchKeywordInput.focus();
		}
		
		var addNewFeedBtn = A.one('#<portlet:namespace/>addNewFeedBtn');
		
		if(addNewFeedBtn){
			
			addNewFeedBtn.on('click',function(){

				var addFeedURL = Liferay.PortletURL.createRenderURL();
											
				addFeedURL.setPortletId('<%=rssAdminPortletResource %>');
				addFeedURL.setWindowState('pop_up');
				addFeedURL.setParameter('jspPage', '/html/admin/rss_feed_update_form.jsp');
				addFeedURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-rss-feed'),
					uri: addFeedURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
	});
							
	Liferay.provide(
		window,
		'<portlet:namespace/>showFeedUpdateForm',
		function(feedId){
			
			var updateFeedURL = Liferay.PortletURL.createRenderURL();
										
			updateFeedURL.setPortletId('<%=rssAdminPortletResource %>');
			updateFeedURL.setWindowState('pop_up');
			updateFeedURL.setParameter('jspPage', '/html/admin/rss_feed_update_form.jsp');
			updateFeedURL.setParameter('feedId', feedId);
			updateFeedURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				title: Liferay.Language.get('update-rss-feed'),
				uri: updateFeedURL
			};
			
			Liferay.Util.openWindow(dialogWidow);
		}
	);
				
	Liferay.provide(
		window,
		'refresh',
		function(){
			Liferay.Portlet.refresh('#p_p_id_rssadmin_WAR_rssportlet_');
		}
	);
</aui:script>