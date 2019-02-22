<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.bkav.portal.portlet.topic.service.TopicLocalServiceUtil"%>
<%@ include file = "/html/topic/init.jsp"%>
<%
%>
<c:choose>
	<c:when test='<%= topicStyle.equals("small") %>'>
		<%@ include file="/html/topic/display/small_style.jsp" %>
	</c:when>
	<c:when test='<%= topicStyle.equals("big") %>'>
		<%@ include file="/html/topic/display/big_style.jsp" %>
	</c:when>
</c:choose>
