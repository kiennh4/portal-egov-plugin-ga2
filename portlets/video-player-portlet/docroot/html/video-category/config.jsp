<%@page import="java.util.List"%>
<%@include file = "/html/video-category/init.jsp" %>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<aui:form name = "fm" action = "<%=configurationActionURL %>" method = "POST">

	<aui:select name="videocategoryPageLayoutId" label="display-video-on-page">
		<%
		for(Layout layout : groupLayoutList){
		%>
			<aui:option label="<%=layout.getName() %>" value="<%=layout.getPlid() %>" 
						selected="<%=videocategoryPageLayoutId == layout.getPlid() %>"/>
		<%
		}
		%>
	</aui:select>

	<aui:input name="numCategoryDisplay" value = "<%=numCategoryDisplay %>"/>
	<aui:button type = "button" value = "save" name = "saveBtn"/>
	<aui:button type = "button" value = "close" name = "cancelBtn"/>
</aui:form>

<aui:script>
	AUI().ready(function(A){
		var saveConfigPageBtn = A.one('#<portlet:namespace/>saveBtn');
		
		if(saveConfigPageBtn){
			
			saveConfigPageBtn.on('click',function(){
			
			
				var numberCategoryDisplay = parseInt(A.one('#<portlet:namespace/>numCategoryDisplay').attr('value')) || -1;
				
				if (numberCategoryDisplay<0)
				{
					A.one('#<portlet:namespace/>numCategoryDisplay').focus();
				}
				else
				{
					A.one('#<portlet:namespace/>fm').submit();
				}
			});
		}
		
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>