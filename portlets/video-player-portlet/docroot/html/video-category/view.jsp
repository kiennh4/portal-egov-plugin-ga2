<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@include file = "/html/video-category/init.jsp" %>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategoryMap"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil"%>
<%
	List<VideoCategory> listCategory = null;
%>
<div class = "list-video-category">
<c:choose>
	<c:when test="<%=numCategoryDisplay>0 %>">
		<%
		listCategory = VideoCategoryLocalServiceUtil.findByGroup(groupId, 0, numCategoryDisplay);
		%>
		<c:choose>
			<c:when test="<%=((listCategory!=null)&&(listCategory.size()>0)) %>">
				<ul>
					<%
						for (VideoCategory videoCategory:listCategory)
						{
							String viewContentURL = ""; 
							PortletURL portletUrl = PortletURLFactoryUtil.create(request, portletVideoPlayerId, videocategoryPageLayoutId,  PortletRequest.RENDER_PHASE);
							portletUrl.setParameter("categoryId", StringUtil.valueOf(videoCategory.getCategoryId()));
							viewContentURL = portletUrl.toString();		
					%>
						<li>
							<span class = "video-category-item" >
								<a target="_self" href = "<%=viewContentURL%>">
									<%=videoCategory.getCategoryName()%>
								</a>
								</span>
							<span style="display: block; clear: both;"></span>
						</li>
					<%
						}
					%>
				</ul>
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="no-categories"/>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<%
			renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
 		%> 

 		<div class="portlet-configuration portlet-msg-info"> 
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>"  
			label="please-config-this-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" /> 
 		</div>
	</c:otherwise>
</c:choose>
</div>