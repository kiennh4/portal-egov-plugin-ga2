<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioFile"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@include file="/html/admin/init.jsp"%>
<%
	long objectId = ParamUtil.getLong(request, "objectId",0);
	
	AudioFile audioFile = AudioFileLocalServiceUtil.fetchAudioFile(objectId);
	
	long companyIdSelected = ParamUtil.getLong(request, "companyId", companyId);

%>
<script type="text/javascript" src="/content-sharing-portlet/js/jwplayer/jwplayer.js"></script>
<div class = "asset-entry-view" style = "height:200px;overflow-y:auto">
<c:choose>
	<c:when test="<%=(audioFile!=null) %>">
		<%
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(audioFile.getAudioFileId());
		
		fileEntry = fileEntry.toEscapedModel();
		
		long folderId = fileEntry.getFolderId();
		String title = fileEntry.getTitle();

		String fileUrl = themeDisplay.getPortalURL() 
				+ themeDisplay.getPathContext() 
				+ "/documents/" 
				+ GroupLocalServiceUtil.getGroup(companyIdSelected, "Guest").getGroupId() 
				+ "//" + folderId +  "//"
				+ HttpUtil.encodeURL(HtmlUtil.unescape(title));

		%>
		<div class = "audio-title" style = "">
			<b><%=audioFile.getAudioName() %></b>
		</div>
		<div class = "audio-content">
			<div id = "<portlet:namespace/>audio-player">
			</div>
			<aui:script>
				jwplayer("<portlet:namespace/>audio-player").setup({
			        file: '<%=fileUrl %>',
			        autostart: false,
			         skin: '/content-sharing-portlet/js/jwplayer/five.xml',
			        width: '100%',
			        height: 30
		    	});
		    	
			</aui:script>
		</div>
	</c:when>
</c:choose>
</div>
