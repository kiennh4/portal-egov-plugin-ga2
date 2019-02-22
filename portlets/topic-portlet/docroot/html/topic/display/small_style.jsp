<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.bkav.portal.portlet.topic.util.TopicUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil"%>
<%@  page import= "com.bkav.portal.portlet.topic.model.Topic"%>
<%
	List<Topic> listTopic = null;

	int totalTopic = TopicLocalServiceUtil.getTopicsCount();

	if (numberTopicDisplay>0)
	{
// 		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Topic.class);
		
// 		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
// 		dynamicQuery.setLimit(0, numberTopicDisplay);
		
		
// 		 listTopic = TopicLocalServiceUtil.dynamicQuery(dynamicQuery);
		 
		 listTopic = TopicLocalServiceUtil.findByGroup(groupId);
		 
		 listTopic = ListUtil.subList(listTopic, 0, numberTopicDisplay);
	}
	else
	{
		listTopic = TopicLocalServiceUtil.findByGroup(groupId);
	}
	
%>

<div class = "list-topic-small">
<c:choose>
	<c:when test="<%=((Validator.isNotNull(listTopic))&&(listTopic.size()>0)) %>">
		<ul>
			<%
				for (Topic topicItem : listTopic)
				{
					String categoryIdsValidate = TopicUtil.topicCategoryValidate(topicItem.getTopicId(), topicItem.getCategoryIds());				
					
					String viewContentURL = ""; 
					PortletURL portletURL_ = PortletURLFactoryUtil.create(request, "101", topicPageLayoutId, PortletRequest.RENDER_PHASE);
					portletURL_.setParameter("topicCategoryIds", categoryIdsValidate);
					portletURL_.setParameter("topicName", topicItem.getTopicName());
					viewContentURL = portletURL_.toString();					
			%>
				<li >
					<span class = "topic-item-small" >
						<a target="_self" href = "<%=viewContentURL%>">
							<%=topicItem.getTopicName() %>
						</a>
						</span>
					<span style="display: block; clear: both;"></span>
				</li>
			<%
				}
			%>
		</ul>
	</c:when>
</c:choose>
<c:choose>
	<c:when test="<%=((numberTopicDisplay>0)&&(numberTopicDisplay<totalTopic)) %>">
		<div style = "display:block;text-align:right">
			<a href = "<%=allTopicPageUrl %>" style = "font-size:11px" ><liferay-ui:message key="see-more"/>>></a>
		</div>
	</c:when>
</c:choose>

</div>