<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalService"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.bkav.portal.portlet.video.permission.VideoEntryPermission"%>
<%@page import="com.bkav.portal.portlet.video.permission.VideoCategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.bkav.portal.portlet.video.search.VideoSearch"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoEntry"%>
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
int videoIndex = 0;

int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);

int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);

if(searchContainerCurrentPage > 1){
	
	videoIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
}

String videoSearchKeyword = ParamUtil.getString(request, "videoSearchKeyword");
%>

<liferay-portlet:renderURL varImpl="videoAdminRenderURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="videoAdminRenderImplURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="videoSearchKeyword" value="<%=videoSearchKeyword %>"/>
</liferay-portlet:renderURL>

<div class="video-search">
	
		<input type="text" id="<portlet:namespace />videoSearchKeywordInput" 
				name="videoSearchKeyword" />
		
		<aui:button type="button" name = "searchBtn" value="search"/>
		
		<aui:button value="show-all-video" href="javascript: <portlet:namespace />loadVideos();" />
		
		<aui:button name="addNewVideoBtn" value="add-new-video" />
		
		<aui:button name="addNewCateBtn" value="add-new-category" />
	
</div>

<div style="clear: both;"></div>

<div class="separator"></div>

<div class = "videos-content">
	<aui:layout>
		<aui:column columnWidth="40" cssClass="">
			<div class = "video-category">
				<p class = "video-category-title" style = ""><liferay-ui:message key="category-list" /></p>
				<ul>
					<%
						List<VideoCategory> listCategory = VideoCategoryLocalServiceUtil.findByGroup(groupId);
					%>
					<c:choose>
						<c:when test="<%=((Validator.isNotNull(listCategory))&&(listCategory.size()>0)) %>">
							<%
								for (int i = 0; i<listCategory.size();i++)
								{
							%>
									<li class = "category-item">
										<table style = "width:100%">
											<tr>
												<td onclick = "<portlet:namespace/>loadVideos(<%=listCategory.get(i).getCategoryId()%>)">
													<p class = "category-name"><%=listCategory.get(i).getCategoryName() %></p>
													<p class = "category-date"><%=dateTimeFormat.format(listCategory.get(i).getModifiedDate()) %></p>
												</td>
												<td width = '60px'>
													<a href = 'javascript:;' onclick = '<portlet:namespace/>showCategoryUpdateForm(<%=listCategory.get(i).getCategoryId()%>)'>
													<c:if test="<%=VideoCategoryPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE) %>">
																									
															
															<liferay-ui:icon image = "edit" />
														
													</c:if>
													</a><br/>
													<c:if test="<%=VideoCategoryPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
																									
															<liferay-portlet:actionURL  name="deleteVideoCategory" var="deleteCategorynURL">
																<liferay-portlet:param name="categoryId" value="<%=String.valueOf(listCategory.get(i).getCategoryId())%>"/>
																<liferay-portlet:param name="redirectURL" value="<%=albumAdminHomePageURL %>"/>
																
															</liferay-portlet:actionURL>
															
															<liferay-ui:icon-delete url="<%= deleteCategorynURL %>" />
														
													</c:if>
												</td>
											</tr>
										</table>
									</li>
							<%
								}
							%>
						</c:when>
						<c:otherwise>
							<liferay-ui:message key="no-category"/>
						</c:otherwise>
					</c:choose>
					<li style = "background: #8fbe31;color:white;margin-top:5px;height:30px;" onclick = "<portlet:namespace/>showCategoryUpdateForm()" class = "add-new-category">
						<center>
							<b><liferay-ui:message key="add-new-category"/></b>
							<liferay-ui:icon image="add"/>
						</center>
					</li>
				</ul>
			</div>
		</aui:column>
		<aui:column columnWidth="60" cssClass="video-entry-content" >
			<p class = "video-entry-title" style = ""><liferay-ui:message key="videos" /></p>
			<div id = "<portlet:namespace />video-entries" class = "video-entry">
							
			</div>
		</aui:column>
	</aui:layout>
</div>
<liferay-portlet:renderURL var="ajaxVideoUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/admin/list_video_category.jsp"/>
</liferay-portlet:renderURL>

<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		Liferay.provide(
			window,
			'<portlet:namespace/>loadVideos',
			function(categoryId, entryKey) {
			
			var portletContainerId = 'p_p_id' + '<%=renderResponse.getNamespace() %>';
			
			
				
			A.io.request('<%=ajaxVideoUrl%>',{   
				
				data:{
					categoryId: categoryId,
					key: entryKey,
					redirectUrl: '<%=PortalUtil.getCurrentURL(request) %>'
				},
				on: {   
					success: function(){
						
						var videoList = this.get('responseData');

						var videoListContainer = A.one('#<portlet:namespace/>video-entries');
						
						if(videoListContainer && videoList){
							
							videoListContainer.empty();
							
							videoListContainer.html(videoList);
						}
					},
					failure:function(){
						
						var loadDataFailMsgTpl 	= '<div class="portlet-msg-info">'
												+ 	'<liferay-ui:message key="load-data-failure"/>'
												+ '</div>';
												
						var videoListContainer = A.one('#<portlet:namespace/>video-entries');
						
						videoListContainer.html(loadDataFailMsgTpl);
					}
				} 
			});
				
		});

		var videoSearchKeywordInput = A.one('#<portlet:namespace />videoSearchKeywordInput');
		
		if(videoSearchKeywordInput){
			videoSearchKeywordInput.focus();
		}
		
		var searchVideoBtn = A.one('#<portlet:namespace/>searchBtn');
		
		if(searchVideoBtn){
			searchVideoBtn.on('click',function(){
				var key = videoSearchKeywordInput.attr('value');
				if (key.length>0)
					<portlet:namespace/>loadVideos('',key);
				else
					videoSearchKeywordInput.focus();
			})
		}
		
		var addNewVideoBtn = A.one('#<portlet:namespace/>addNewVideoBtn');
		
		if(addNewVideoBtn){
			
			addNewVideoBtn.on('click',function(){

				var addVideoURL = Liferay.PortletURL.createRenderURL();
											
				addVideoURL.setPortletId('<%=videoAdminPortletResource %>');
				addVideoURL.setWindowState('pop_up');
				addVideoURL.setParameter('jspPage', '/html/admin/video_update_form.jsp');
				addVideoURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-video'),
					uri: addVideoURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
		
		var addNewCateBtn = A.one('#<portlet:namespace/>addNewCateBtn');
		
		if(addNewCateBtn){
			
			addNewCateBtn.on('click',function(){

				var addCateURL = Liferay.PortletURL.createRenderURL();
											
				addCateURL.setPortletId('<%=videoAdminPortletResource %>');
				addCateURL.setWindowState('pop_up');
				addCateURL.setParameter('jspPage', '/html/admin/category_update_form.jsp');
				addCateURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 500,
						cache: false
					},
					title: Liferay.Language.get('add-new-category'),
					uri: addCateURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
		<portlet:namespace/>loadVideos();
	});
							
	Liferay.provide(
		window,
		'<portlet:namespace/>showVideoUpdateForm',
		function(videoId){
			
			var updateVideoURL = Liferay.PortletURL.createRenderURL();
										
			updateVideoURL.setPortletId('<%=videoAdminPortletResource %>');
			updateVideoURL.setWindowState('pop_up');
			updateVideoURL.setParameter('jspPage', '/html/admin/video_update_form.jsp');
			updateVideoURL.setParameter('videoId', videoId);
			updateVideoURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				title: Liferay.Language.get('update-video'),
				uri: updateVideoURL
			};
			
			Liferay.Util.openWindow(dialogWidow);
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace/>showCategoryUpdateForm',
		function(categoryId){
			
			var addCateURL = Liferay.PortletURL.createRenderURL();
											
			addCateURL.setPortletId('<%=videoAdminPortletResource %>');
			addCateURL.setWindowState('pop_up');
			addCateURL.setParameter('jspPage', '/html/admin/category_update_form.jsp');
			addCateURL.setParameter('categoryId', categoryId);
			addCateURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 500,
					cache: false
				},
				title: Liferay.Language.get('add-new-category'),
				uri: addCateURL
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
				
	Liferay.provide(
		window,
		'refresh',
		function(){
			Liferay.Portlet.refresh('#p_p_id_videoadmin_WAR_videoplayerportlet_');
		}
	);
</aui:script>

<script type = "text/javascript">
	$('.category-item').click (function(){
		$('.category-item').each(function(){
			$(this).css ({
				'background':'white'
			});
			
		});
		$(this).css ({
			'background':'#eee'
		});
	})
	
	
</script>