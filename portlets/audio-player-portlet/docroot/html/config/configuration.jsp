<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AlbumPermission"%>
<%@include file="/html/audioplayer/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<portlet:defineObjects />


<liferay-portlet:actionURL portletConfiguration="true" var="audioplayerConfigActionUrl">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL portletConfiguration = "true" var="ajaxAlbumListUrl" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	
</liferay-portlet:renderURL>

<aui:form name="audioplayer-portlet-config-form" method="post" action="<%=audioplayerConfigActionUrl %>">
	<div class="audioplayer_portlet_config_page">
		<aui:select name="defaultAlbum" label = "default-album">
			<%
				List<AudioAlbum> listAlbum = AudioAlbumLocalServiceUtil.findByGroup(groupId);
				
				for (int i = 0;i<listAlbum.size();i++)
				{
					AudioAlbum album = listAlbum.get(i);
			%>
				<aui:option value = "<%=album.getAlbumId() %>" selected='<%=Validator.equals(defaultAlbum, StringUtil.valueOf(album.getAlbumId())) %>'><%=album.getAlbumName() %></aui:option>
			<%
				}
			%>
		</aui:select>
		<aui:select name="displayStyle" label="display-style">
			
			<aui:option label="small-display" value="<%=smallStyle %>" selected='<%=Validator.equals(currentStyle, smallStyle) %>'/>
			<aui:option label="big-display" value="<%=bigStyle %>" selected='<%=Validator.equals(currentStyle, bigStyle) %>'/>
		</aui:select>
		
		<c:choose>
			<c:when test="<%=AlbumPermission.contains(permissionChecker, groupId, AlbumPermission.ADD) %>">
				<aui:button type = "button" value = "add-album" name = "addAlbumBtn"/>
			</c:when>
		</c:choose>
	</div>
	<br/>
	<aui:button type="submit" value="save"/>
</aui:form>

<aui:script use="aui-dialog">
	AUI().ready('aui-base','liferay-portlet-url',function(A){
	
			Liferay.provide(
				window,
				'<portlet:namespace/>showUpdateAlbum',
				function(albumId){
		
					var updateAudioUrl_ = Liferay.PortletURL.createRenderURL();
												
					updateAudioUrl_.setPortletId('<%=audioplayerAdminPortletId %>'); 
					updateAudioUrl_.setWindowState('pop_up');
					updateAudioUrl_.setParameter('jspPage', '/html/audioadmin/update_album_form.jsp');
					updateAudioUrl_.setParameter('albumId', albumId);
					updateAudioUrl_.setDoAsGroupId('<%=groupId %>');
								
					var dialogWidow = {
						dialog: {
							align: Liferay.Util.Window.ALIGN_CENTER,
							modal: true,
							width: 600,
							height:700,
							draggable: true,
		        			resizable: false,
							cache: false,
							on: {
								close: function (){
									//window.location.href = '<%=ajaxAlbumListUrl %>';
									window.location.reload();
								}
							}
						},
						id: '<portlet:namespace/>audioDetailForm',
						title: '<liferay-ui:message key="audio-info" />',
						uri: updateAudioUrl_
						
					};
					
					Liferay.Util.openWindow(dialogWidow);	
				}
			);
			
			A.one('#<portlet:namespace/>addAlbumBtn').on('click',function (){
				<portlet:namespace/>showUpdateAlbum();
			});
			
			Liferay.provide(
				window,
				'refresh',
				function(){
					
					
				}
			);
		
			
	});
	
	
</aui:script>