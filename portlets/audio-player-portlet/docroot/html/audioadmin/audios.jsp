<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="com.liferay.portal.service.PortletLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalService"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.impl.AudioAlbumLocalServiceImpl"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.util.AudioUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioFile"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AudioPermission"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AlbumPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript" src="/audio-player-portlet/js/jwplayer/jwplayer.js"></script>
<%@include file="/html/audioadmin/init.jsp"%>
<%
	System.out.println(PortletProps.get("portlet.version"));
	
	System.out.println(PortalUtil.getPortletId(request));
%>
<div class="audio-admin">
	
	<div class="lfr-header-row">
		
		<div class="admin-btn" align="left">
			
				<c:if test="<%=AlbumPermission.contains(permissionChecker, groupId, AlbumPermission.ADD)%>">
					<aui:button name="addAlbumBtn" type="button" value="add-new-album"/>
				</c:if>
				
				<c:if test="<%=AudioPermission.contains(permissionChecker, groupId, AudioPermission.ADD)%>">
					<aui:button name="addAudioBtn" type="button" value="add-new-audio"/>
				</c:if>
				
				<c:if test="<%=AudioPermission.contains(permissionChecker, groupId, AudioPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=AudioAlbum.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="audio-permissions" />
				</c:if>
			
		</div>			
		
		<div class="audio-search-form" align="right">
		
			<input title="<liferay-ui:message key = 'at-least-3-char'/>" id='<portlet:namespace />audioSearchInput' type="text" value=""/>
			
			<aui:button name="searchAudioBtn" type="button" value="search"/>
			
			<aui:button name="showAllAudioBtn" type="button" value="show-all-audios"/>
		</div>
	</div>
	
	<div class="audio-list" style = "height: 650px; overflow:auto;">
		<aui:layout>
			
			<aui:column columnWidth="40" cssClass="album-menu">
				<p style = "font-size:14px;color:blue;margin:0px;padding-left:25px;background:rgb(163, 207, 255);border-right:1px solid #ccc;"><liferay-ui:message key="album-list" /></p>
				<div id="<portlet:namespace/>audio-album-container" class="album-container scroll-left"   style = "height: 600px; overflow-y:auto;">
					<ul class = 'albumListTable' >
						
					<%
						
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
						int albumsCount = AudioAlbumLocalServiceUtil.getAudioAlbumsCount();
						List<AudioAlbum> albumList = AudioAlbumLocalServiceUtil.findByGroup(groupId);
						for (int i = 0;i<albumList.size();i++)
						{
							AudioAlbum album = albumList.get(i);
							String albumCoverLink = AudioUtil.getAlbumCoverPath(request, album.getAlbumCoverId());
					%>
						<li class = 'album-item' onclick = "<portlet:namespace/>loadAudios(<%=album.getAlbumId() %>)"  album-id = '<%=album.getAlbumId() %>' style = 'width:100%;'>
							<table style = 'width:100%;'>
								<tr>
									<td width = '50px'>
										<img width = '50px' height = '50px' src = '<%=albumCoverLink %>'/>
									</td>
									<td style = 'padding:10px;'>
										<p class = 'albumName'><%=album.getAlbumName() %></p>
										<p class = 'albumInfo'><%=album.getAlbumInfo() %></p>
										<p class = 'albumDate'><liferay-ui:message key = "view-counter"/>: <%=album.getViewCounter()%></p>
										<p class = 'albumDate'><liferay-ui:message key = "update-date"/>:  <%=df.format(album.getModifyDate()) %></p>
									</td>
									<td width = '60px'>
										<a href = 'javascript:;' onclick = '<portlet:namespace/>showUpdateAlbum(<%=album.getAlbumId()%>)'>
										<c:if test="<%=AlbumPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE) %>">
																						
												
												<liferay-ui:icon image = "edit" />
											
										</c:if>
										</a><br/>
										<c:if test="<%=AlbumPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
																						
												<liferay-portlet:actionURL  name="deleteAlbum" var="deleteAudioActionURL">
													<liferay-portlet:param name="albumId" value="<%=String.valueOf(album.getAlbumId())%>"/>
													<liferay-portlet:param name="redirectURL" value="<%=albumAdminHomePageURL %>"/>
													
												</liferay-portlet:actionURL>
												
												<liferay-ui:icon-delete url="<%= deleteAudioActionURL %>" />
											
										</c:if>
									</td>
								</tr>
							</table>
						</li>
					<%
						}
						
					%>
						<li style = "background: #8fbe31;color:white;margin-top:5px;" class = "add-new-album">
							<center>
								<b><liferay-ui:message key="add-new-album"/></b>
								<liferay-ui:icon image="add"/>
							</center>
						</li>
					</ul>
				</div>
			</aui:column>
			
			<aui:column columnWidth="60" cssClass="audio-menu">
				<p style = "font-size:14px;color:blue;margin:0px;padding-left:25px;background:rgb(163, 207, 255);border-right:1px solid #ccc;"><liferay-ui:message key="audio-list" /></p>
				
				
					<div id = "<portlet:namespace/>previewAudioForm"  style = "border-radius:5px 5px 5px 5px; height:50px;width:100%%;background:white;display:none;" >
						
						<div id = "<portlet:namespace/>previewAudioFile">
						</div>
						<marquee class = "audio-name-marquee" align = "center" direction = "left" height = "20px"  scrollamount="2.5" width="75%" style = "float:left;color:black;">
							
						</marquee>
						<aui:button name = "audioPreviewPause" value = "close" style = "height:20px;float:right;width:20%;"/>
					</div>
				
				<div id="<portlet:namespace/>audio-file-container" class="audio-container" style = "margin-left:20px;height: 540px; overflow-y:auto;">
					
				</div>	
			</aui:column>
			
		</aui:layout>
	</div>
</div>

<liferay-portlet:renderURL portletConfiguration="true" var="updateAudioUrl" windowState="<%= LiferayWindowState.POP_UP.toString() %>" >
	<liferay-portlet:param name="jspPage" value="/html/audioadmin/update_audio_form.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="ajaxAudioUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/audioadmin/list_audio_album.jsp"/>
</liferay-portlet:renderURL>

<aui:script use="aui-dialog" >
AUI().use ('aui-tooltip',
	function (A)
	{
			new A.Tooltip({
			trigger: '#<portlet:namespace />audioSearchInput',
			title: true,
			align: { points: [ 'rc', 'lc' ] }
		}).render();
	}
)

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
					cache: false
				},
				id: '<portlet:namespace/>audioDetailForm',
				title: '<liferay-ui:message key="album-info" />',
				uri: updateAudioUrl_
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace/>showUpdateAudio',
		function(audioId,albumId){

			var updateAudioUrl_ = Liferay.PortletURL.createRenderURL();
										
			updateAudioUrl_.setPortletId('<%=audioplayerAdminPortletId %>'); 
			updateAudioUrl_.setWindowState('pop_up');
			updateAudioUrl_.setParameter('jspPage', '/html/audioadmin/update_audio_form.jsp');
			updateAudioUrl_.setParameter('audioId', audioId);
			updateAudioUrl_.setParameter('albumId', albumId);
			updateAudioUrl_.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					centered: true,
					modal: true,
					overflow:true,
					width: 500,
					height:650,
					draggable: true,
        			resizable: false,
					cache: false
				},
				id: '<portlet:namespace/>audioDetailForm',
				title: '<liferay-ui:message key="audio-info" />',
				uri: updateAudioUrl_
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);

Liferay.provide(
			window,
			'<portlet:namespace/>loadAudios',
			function(albumId, audioNameKey) {
			
			var portletContainerId = 'p_p_id' + '<%=renderResponse.getNamespace() %>';
			
			
				
			A.io.request('<%=ajaxAudioUrl%>',{   
				
				data:{
					albumId: albumId,
					key: audioNameKey,
					redirectUrl: '<%=PortalUtil.getCurrentURL(request) %>'
				},
				on: {   
					success: function(){
						
						var audioList = this.get('responseData');

						var audioListContainer = A.one('#<portlet:namespace/>audio-file-container');
						
						if(audioListContainer && audioList){
							
							audioListContainer.empty();
							
							audioListContainer.html(audioList);
						}
					},
					failure:function(){
						
						var loadDataFailMsgTpl 	= '<div class="portlet-msg-info">'
												+ 	'<liferay-ui:message key="load-data-failure"/>'
												+ '</div>';
												
						var audioListContainer = A.one('#<portlet:namespace/>audio-file-container');
						
						audioListContainer.html(loadDataFailMsgTpl);
					}
				} 
			});
				
		});
AUI().ready('aui-base','liferay-portlet-url',function(A){

	
	<portlet:namespace/>loadAudios(0);
	
	
	Liferay.provide(
		window,
		'<portlet:namespace/>previewAudio',
		function(audioFileUrl,audioName){
			
			A.one ('#<portlet:namespace/>previewAudioForm').setStyle ('display','block');
			
			jwplayer("<portlet:namespace/>previewAudioFile").setup({
		        file: audioFileUrl,
		        autostart: true,
		         skin: '/audio-player-portlet/js/jwplayer/five.xml',
		        width: '100%',
		        height: 30
		    });
			A.one('.audio-name-marquee').html(audioName);
		}
	);
	
	A.one('#<portlet:namespace/>addAlbumBtn').on('click',function(){
		<portlet:namespace/>showUpdateAlbum();
	});

	A.one('#<portlet:namespace/>audioPreviewPause').on('click',function(){
		A.one ('#<portlet:namespace/>previewAudioForm').setStyle ('display','none');
		jwplayer().pause();
	});
	
	Liferay.provide(
		window,
		'refresh',
		function(){
			//Liferay.Portlet.refresh('#p_p_id_audioadmin_WAR_audioplayerportlet_');
			location.reload();
		}
	);
	
	A.one('#<portlet:namespace/>addAudioBtn').on('click',function(){
		<portlet:namespace/>showUpdateAudio();
	});
	
	A.one('#<portlet:namespace/>showAllAudioBtn').on('click',function(){
		
		<portlet:namespace/>loadAudios(-1,'');
		A.all('.album-item').each(function(){
			A.all('.album-item').setStyle ('background','white');
			A.all('.album-item').setStyle ('border','0px');
			A.all('.album-item').setStyle ('border-right','1px solid #ccc');
		});
	});
	
	A.one('#<portlet:namespace/>searchAudioBtn').on('click',function(){
		
		var searchKey = A.one('#<portlet:namespace />audioSearchInput').get('value');
		if (searchKey.length>=3)
		{
			<portlet:namespace/>loadAudios(-1,searchKey);
			A.all('.album-item').each(function(){
				A.all('.album-item').setStyle ('background','white');
				A.all('.album-item').setStyle ('border','0px');
				A.all('.album-item').setStyle ('border-right','1px solid #ccc');
			});
		}
	});
	
	A.one('.add-new-album').on('click',function(){
		
		<portlet:namespace/>showUpdateAlbum();
	});
	
	
	
	
});



</aui:script>

<script type = "text/javascript">
	$('.album-item').click (function(){
		$('.album-item').each(function(){
			$(this).css ({
				'background':'white',
				'border':'0px',
				'border-right':'1px solid #ccc'
			});
			
		});
		$(this).css ({
			'background':'beige',
			'border':'1px solid #ccc',
			'border-right':'0px',
			'cursor':'pointer'
		});
	})
	
	
</script>
