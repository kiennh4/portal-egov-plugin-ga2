<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
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
	
	if (numberTopicDisplay>0)
	{
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Topic.class);
		
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		dynamicQuery.setLimit(0, numberTopicDisplay);
	
		 listTopic = TopicLocalServiceUtil.dynamicQuery(dynamicQuery);
	}
	else
	{
		listTopic = TopicLocalServiceUtil.findByGroup(groupId);
	}

	int totalTopic = TopicLocalServiceUtil.getTopicsCount();

	PortletURL portletURL = renderResponse.createRenderURL();

	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);
 
	if (!paginationType.equals("none")) {
		searchContainer.setDelta(10);
		searchContainer.setDeltaConfigurable(false);
	}
	
	searchContainer.setResults(listTopic);
	searchContainer.setTotal(totalTopic);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	List<Topic> curTopics = ListUtil.subList(listTopic, start, end);
%>

<div class = "list-topic-big">
<c:choose>
	<c:when test="<%=((Validator.isNotNull(listTopic))&&(listTopic.size()>0)) %>">
		<ul>
			<%
				for (Topic topicItem : curTopics)
				{
					String categoryIdsValidate = TopicUtil.topicCategoryValidate(topicItem.getTopicId(), topicItem.getCategoryIds());
					
					String viewContentURL = ""; 
					PortletURL portletURL_ = PortletURLFactoryUtil.create(request, "101", topicPageLayoutId, PortletRequest.RENDER_PHASE);
					portletURL_.setParameter("topicCategoryIds", categoryIdsValidate);
					portletURL_.setParameter("topicName", topicItem.getTopicName());
					viewContentURL = portletURL_.toString();					
			%>
				<li class = "topic-item-big" >
					<a target="_self" href = "<%=viewContentURL%>">
						<%=topicItem.getTopicName() %>
					</a>
				</li>
			<%
				}
			%>
		</ul>
	</c:when>
</c:choose>

<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="regular" />


</div>