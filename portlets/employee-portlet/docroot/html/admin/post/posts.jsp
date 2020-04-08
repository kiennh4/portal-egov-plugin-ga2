<%@page import="com.bkav.portal.portlet.employee.service.PostLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal.portlet.employee.model.Post"%>
<%@page import="com.bkav.portal.portlet.employee.permission.postPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/admin/init.jsp"%>
<%
   String postAdminPortletResource = "admin_WAR_employeeportlet";
   
   String postSearchKeyword = ParamUtil.getString(request, "postSearchKeyword");
   List<Post> listPost = PostLocalServiceUtil.findByKeyword(groupId, postSearchKeyword, 0, -1);
   int postIndex = 0;

%>

<!-- .Post -->
<div class="post">
    <liferay-portlet:renderURL var="postsAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="post"/>
	</liferay-portlet:renderURL>
    
    <!-- .lfr-header-row -->
    <div class="lfr-header-row">
        <div class="lfr-header-row-content">
             <div class="add_new_posts_button" align="left">
                  <c:if test="<%=postPermission.contains(permissionChecker, groupId, postPermission.ADD)%>">
					  <aui:button name="addNewPostBtn" value="add-new-post"/>
				  </c:if>
				  
				  <c:if test="<%=postPermission.contains(permissionChecker, groupId, postPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=Post.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button name="postPermissionsBtn" href="<%= permissionsURL %>" value="permissions" />
				  </c:if>
             </div>
             
             <!-- .post_search_form -->
			<div class="post_search_form" align="right">
				<aui:form name="post_search_form" method="post" action="<%=postsAdminHomePageURL%>">
					<input type="text" id="<portlet:namespace/>categorySearchInput"
						name="postSearchKeyword"
						value='<%=postSearchKeyword%>' />
					<aui:button type="submit" value="search" />
					<aui:button type="button" value="show_all" href="<%=postsAdminHomePageURL%>" />
				</aui:form>
			</div>
        </div>
    </div>
    
    <div class="posts">
		
		<liferay-ui:search-container emptyResultsMessage="no-entry-found" >
			<liferay-ui:search-container-results
				results="<%=listPost%>"
				total="<%=listPost.size() %>"
			/>			
				
			<liferay-ui:search-container-row className="Post" keyProperty="postId" modelVar="post" >
				<%
					postIndex++;
					
					int postCounter = PostLocalServiceUtil.countByGroup(groupId);
					
					String updatePostURL = "javascrip:;";
					
					if(postPermission.contains(permissionChecker, groupId, postPermission.UPDATE)){
						
						updatePostURL = "javascript:" + renderResponse.getNamespace() 
											+ "showPostUpdateForm(" + String.valueOf(post.getPostId()) + ");";
					}
				%>

				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(postIndex) %>"/>
					
				<liferay-ui:search-container-column-text name="post-name" value="<%=post.getPostName()%>"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(post.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=post.getUserName()%>"/>
				
				<liferay-ui:search-container-column-text name="edit">
					<c:if test="<%=postPermission.contains(permissionChecker, groupId, postPermission.UPDATE)%>">														
						<liferay-ui:icon image="edit" message="edit" url="<%=updatePostURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete">
					<c:if test="<%=postPermission.contains(permissionChecker, groupId, postPermission.DELETE)%>">															
						<liferay-portlet:actionURL  name="deletePosts" var="deletePostURL">
							<liferay-portlet:param name="postId" value="<%=String.valueOf(post.getPostId())%>"/>
							<liferay-portlet:param name="redirectURL" value="<%=postsAdminHomePageURL%>"/>
							<liferay-portlet:param name="deleteEmployees" value="<%String.valueOf(false) %>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deletePostURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=false %>"/>
		</liferay-ui:search-container>
	</div>
    
</div>
<aui:script>
	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		var addNewPostBtn = A.one('#<portlet:namespace/>addNewPostBtn');
		
		if(addNewPostBtn){
			
			addNewPostBtn.on('click',function(){

				var addPostURL = Liferay.PortletURL.createRenderURL();
											
				addPostURL.setPortletId('<%=postAdminPortletResource %>');
				addPostURL.setWindowState('pop_up');
				addPostURL.setParameter('jspPage', '/html/admin/post/posts_add_form.jsp');
				addPostURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-post'),
					uri: addPostURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
	});
	
	Liferay.provide(
		window,
		'<portlet:namespace/>showPostUpdateForm',
		function(postId){
			
			var updateVideoURL = Liferay.PortletURL.createRenderURL();
										
			updateVideoURL.setPortletId('<%=postAdminPortletResource %>');
			updateVideoURL.setWindowState('pop_up');
			updateVideoURL.setParameter('jspPage', '/html/admin/post/posts_update_form.jsp');
			updateVideoURL.setParameter('postId', postId);
			updateVideoURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				title: Liferay.Language.get('update-post'),
				uri: updateVideoURL
			};
			
			Liferay.Util.openWindow(dialogWidow);
		}
	);
	
    Liferay.provide(
		window,
		'refresh',
		function(){
			Liferay.Portlet.refresh('#p_p_id_admin_WAR_employeeportlet_');
		}
	);

</aui:script>