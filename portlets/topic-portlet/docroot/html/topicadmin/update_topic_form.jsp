<%@page import="com.bkav.portal.portlet.topic.util.TopicUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.topic.model.Topic"%>
<%@ include file = "/html/topicadmin/init.jsp" %>

<%
	long topicId = ParamUtil.getLong(request, "topicId");

	String categoryIds = "";
	Topic topic = null;
	if ((Validator.isNotNull(topicId))&&(topicId>0))
	{
		topic = TopicLocalServiceUtil.getTopic(topicId);
		categoryIds = TopicUtil.topicCategoryValidate(topic.getTopicId(), topic.getCategoryIds());
	}

	//JournalArticle acticle = (JournalArticle)request.getAttribute(WebKeys);
	
%>
<liferay-portlet:actionURL portletName="<%=topicAdminPortletId %>"  name="updateTopic" var = "updateTopicActionURL">
	<liferay-portlet:param name="albumId" value="<%=String.valueOf(topicId) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=topicAdminHomePageURL %>"/>
</liferay-portlet:actionURL>

<div class="portlet-msg-info" id = "<portlet:namespace/>lengthTopicNameMsg" style = "display:none;">
	<span><liferay-ui:message  key="topic-name-length" /></span>
</div>

<div class = "update-topic-form">
	<form name = "topic_update_form" id = "<portlet:namespace/>topicUpdateForm" method = "post" action = "<%=updateTopicActionURL%>">
		<aui:model-context bean="<%= topic %>" model="<%= Topic.class %>" />
		<aui:input type="text" name="topicName"  style = "width:250px;">
		</aui:input>
		<aui:input type = "hidden" name = "topicId" value = "<%=topicId %>"/>
		<br>
		<b><liferay-ui:message key="choose-category"/></b>
		<aui:fieldset>
		
			<liferay-ui:asset-categories-selector 
				hiddenInput="categoryIds"  
				curCategoryIds="<%=categoryIds %>"
			/>
			
		</aui:fieldset>
		<br>
		<aui:button type = "button" name = "submitUpdateBtn" value = "save"/>
		<aui:button type = "button" value = "close" name = "closeUpdateBtn"/>
		
	</form>
</div>

<aui:script>
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel','liferay-portlet-url',function(A){
		
	   A.one("#<portlet:namespace />submitUpdateBtn").on('click',function (){
	   		var topicName = A.one('#<portlet:namespace />topicName').attr('value');
	   		if ((topicName.length<3)||(topicName.length>100))
	   		{
	   			A.one('#<portlet:namespace/>lengthTopicNameMsg').setStyle('display','block');
	   			A.one('#<portlet:namespace />topicName').focus();
	   		}
	   		else
	   		{
	   			A.one('#<portlet:namespace/>topicUpdateForm').submit();
	   		}
	   });	
	   
	   A.one("#<portlet:namespace />closeUpdateBtn").on('click',function (){
	   		location.href = '<%=topicAdminHomePageURL %>';
	   });
	})
</aui:script>