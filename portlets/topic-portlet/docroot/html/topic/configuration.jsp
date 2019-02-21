<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@ include file = "/html/topic/init.jsp"%>
<liferay-portlet:actionURL portletConfiguration="true" var="topicConfigActionUrl">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>
<%
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
%>
<aui:form name = "topic-config-form" method = "post" action = "<%=topicConfigActionUrl %>">
	<aui:select name="topicPageLayoutId" label="display-topic-on-page">
		<%
		for(Layout layout : groupLayoutList){
		%>
			<aui:option label="<%=layout.getName() %>" value="<%=layout.getPlid() %>" 
						selected="<%=topicPageLayoutId == layout.getPlid() %>"/>
		<%
		}
		%>
	</aui:select>
	<hr>
	<aui:select name="topicStyle">
		<aui:option value = "big" selected = "<%=((Validator.equals(topicStyle, bigStyle)) ? true : false)%>"><liferay-ui:message key ="big"/></aui:option>
		<aui:option value = "small" selected = "<%=((Validator.equals(topicStyle, smallStyle)) ? true : false)%>"><liferay-ui:message key ="small"/></aui:option>
	</aui:select>
	<hr>
	<b><liferay-ui:message key="all-topic-url"/></b>
	<br>
	<%=PortalUtil.getHomeURL(request) %>/<input type = "text" name = "allTopicUrl" value = "<%=preferences.getValue("allTopicUrl", "chuyen-de") %>"/>
	<hr>
	<aui:input 
		cssClass = "showAllTopicCheckBox" 
		type = "checkbox" 
		name = "showAllTopic" 
		value = "<%=((numberTopicDisplay==0) ? true : false) %>" 
	/>
	<br>
	
	<div id="<portlet:namespace />numberTopicDisplayWrapper">	
		<aui:input cssClass = "numberTopicDisplayInput" type = "number" name="numberTopicDisplay"  value = "<%=((numberTopicDisplay==0) ? 5 : numberTopicDisplay) %>"/>
	</div>
	
	<aui:button-row>
		<aui:button type = "button" name = "submitConfigBtn" value = "save"/>
	</aui:button-row>
</aui:form> 

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />showAllTopicCheckbox','<portlet:namespace />numberTopicDisplayWrapper',true);
</aui:script>

<aui:script>
	AUI().ready(function(A){
		
		A.one ('#<portlet:namespace/>submitConfigBtn').on('click',function (){
			if (A.one('.numberTopicDisplayInput').getStyle('display')!='none')
			{
				var numberTopicDisplayStr = A.one('#<portlet:namespace/>numberTopicDisplay').attr('value');
				
				var numberTopciDisplay = parseInt(numberTopicDisplayStr) || -1;
				
				if (numberTopciDisplay<0)
				{
					A.one('#<portlet:namespace/>numberTopicDisplay').focus();
				}
				else
				{
					A.one('#<portlet:namespace/>topic-config-form').submit();
				}
			}
			else
			{
				A.one('#<portlet:namespace/>topic-config-form').submit();
			}
			
		});
		
	});
</aui:script>