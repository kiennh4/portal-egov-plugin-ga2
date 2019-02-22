<%@page import="com.bkav.portal.portlet.rss.util.RssFeedUtil"%>
<%@page import="com.sun.syndication.feed.synd.SyndEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ObjectValuePair"%>
<%@page import="com.bkav.portal.portlet.rss.service.RssFeedLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.rss.model.RssFeed"%>
<%@page import="com.sun.syndication.feed.synd.SyndFeed"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	long selectedFeedId = GetterUtil.getLong(preferences.getValue("selectedFeedId", "0"));
%>

<c:choose>
	<c:when test="<%=selectedFeedId > 0L %>">
		<%
		
		RssFeed rssFeed = RssFeedLocalServiceUtil.getRssFeed(selectedFeedId);
		
		String feedURL = rssFeed.getUrl();
		
		SyndFeed feed = null;
		
		try {
			ObjectValuePair ovp = RssFeedUtil.getFeed(feedURL);

			feed = (SyndFeed)ovp.getValue();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(feed != null){
			
			List feedAssets = feed.getEntries();
			
			if(feedAssets.size() > 0){
			
				SyndEntry topEntry = (SyndEntry)feedAssets.get(0);
				
				String topEntryTitle = topEntry.getTitle();
				String topEntryLink = topEntry.getLink();
				String topEntryDesc = topEntry.getDescription().getValue();
				String topEntryPublishDate = dateTimeFormat.format(topEntry.getPublishedDate());
		%>
				<div class="top-asset">
					<div class="asset-title">
						<a href="<%=topEntryLink%>" title="<%=topEntryTitle%>">
							<%=topEntryTitle %>
						</a>
						<c:if test="<%=showPublishDate %>">
							<span class="publish-date"><%=topEntryPublishDate %></span>
						</c:if>
					</div>
					
					<div class="asset-summary">
						<span class="summary-content"><%=topEntryDesc %></span>
					</div>
					
					<div style="clear: both;"></div>
				</div>
				
				<div class="separator"></div>
		<%
		
				for(int i = 0;i < feedAssets.size(); i++){
					
					SyndEntry syndEntry = (SyndEntry)feedAssets.get(i);
					
					String entryTitle = syndEntry.getTitle();
					String entryLink = syndEntry.getLink();
					String entryPublishDate = dateTimeFormat.format(syndEntry.getPublishedDate());
		%>
					<div class="older-asset">
						<span class="asset-title">
							<a href="<%=entryLink%>" title="<%=entryTitle%>"><%=entryTitle %></a>
						</span>
						<c:if test='<%=showPublishDate %>'>
							<span class="publish-date">(<%=entryPublishDate %>)</span>
						</c:if>
					</div>
		<%	
					if((i + 1) >= numbersOfFeedEntries){
						break;
					}
				}
			}
		}
		%>
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