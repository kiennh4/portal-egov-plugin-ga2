<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioFile"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>

<%@include file="/html/audioadmin/init.jsp"%>

<b style = "float:left;"><liferay-ui:message key="choose-audio"/></b>
<div  style = "float:right;margin-bottom:10px;">
	<aui:input type = "text" label = '' name = "searchForm" class = "audioSearchForm" style = "float:right;" />
	
</div>
<br/>
<div class = "<portlet:namespace/>list-audio" style = "width:100%;height:300px;overflow:auto;background:#dff4ff;">
						
<%
	long albumId = ParamUtil.getLong(request, "albumId");
	List<AudioFile> audios = AudioFileLocalServiceUtil.findByGroup(groupId);
	
	String selectedAudioStr = ParamUtil.getString(request, "selectedAudio");
	
	List<AlbumAudioMap> aam = AlbumAudioMapLocalServiceUtil.findByAlbumId(albumId);
	
	String audioExisted = aam.toString();
	for (int i = 0;i<audios.size();i++)
	{
		AudioFile audio = audios.get(i);
		if (selectedAudioStr.indexOf(StringUtil.valueOf(audio.getAudioId()))<0)
		{
%>
	<div class = "audio-file-item" audio-name = "<%=audio.getAudioName() %>" style = "margin-left: 8px;margin-top:5px;">
		<input class = "audio-checkbox-item" style = "padding-left: 5px;padding-top:2px;" type="checkbox" audio-name = "<%=audio.getAudioName() %>" value = "<%=audio.getAudioId() %>" name = "listAudioSelected"/><%=audio.getAudioName() %><br/>
	</div>
<%
		}
	}
%>
</div>
<aui:button-row>
	<aui:button name="submitSelectionBtn" value="save"/>
	<aui:button name="closeFormBtn" value="cancel"/>
</aui:button-row>
<aui:script >
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel','liferay-portlet-url',function(A){
	
		A.one('#<portlet:namespace />searchForm').on('keyup',function(){
			var key = this.get('value').toLowerCase();
			A.all('.audio-file-item').each(function(){
				var audioName = this.getAttribute('audio-name');
				
				if (audioName.toLowerCase().indexOf(key)<0)
					this.setStyle('display','none');
				else
					this.setStyle('display','block');
			});
			
			
		});
		
		A.one ('#<portlet:namespace />submitSelectionBtn').on('click',function (){
			
			var audioSelectedListItem = [];
			
			
			
			A.all ('.audio-checkbox-item').each (function(){
				if (this.attr('checked'))
				{
					var audioSelectedItem = {
						audioId: this.getAttribute('value'),
						audioName: this.getAttribute('audio-name')
					};
					
					audioSelectedListItem.push(audioSelectedItem);
				}
			});
			
			Liferay.Util.getOpener().getSelectedAudio(audioSelectedListItem);
			Liferay.Util.getWindow().close();
		});
		
		A.one ('#<portlet:namespace />closeFormBtn').on('click',function (){
			Liferay.Util.getWindow().close();
		});
	})
</aui:script>