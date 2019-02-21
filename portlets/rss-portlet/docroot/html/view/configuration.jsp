<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.bkav.portal.portlet.rss.service.RssFeedLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.rss.model.RssFeed"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	int feedIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		feedIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	String[] numbersOfEntriesDisplayValues = {"1","2","3","4","5","6","7","8","9","10","15","20","30","40","50"};
	
	long selectedFeedId = ParamUtil.getLong(request, "selectedFeedId",
			GetterUtil.getLong(preferences.getValue("selectedFeedId", "0")));
	
	String selectedFeedName = "";
	
	RssFeed selectedFeed = null;
	
	if(selectedFeedId > 0L){
		
		selectedFeed = RssFeedLocalServiceUtil.getRssFeed(selectedFeedId);
		
		if(selectedFeed != null){
			selectedFeedName = selectedFeed.getName();
		}
	}
	
	String rssAdminPortletResource = "rssadmin_WAR_rssportlet";
	
	String portletConfigContainerId = StringPool.UNDERLINE + portletResource + StringPool.UNDERLINE + "configurationIframeDialog";

	String rssSearchKeyword = ParamUtil.getString(request, "rssSearchKeyword");

	List<RssFeed> groupFeeds = RssFeedLocalServiceUtil.findByKeyword(groupId, rssSearchKeyword, 0, -1);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="rssConfigActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="rssConfigRenderURL" />

<liferay-portlet:renderURL portletConfiguration="true" varImpl="rssConfigRenderImpURL" >
	<liferay-portlet:param name="rssSearchKeyword" value="<%=rssSearchKeyword %>"/>
</liferay-portlet:renderURL>

<div id="<portlet:namespace/>rss-config-form" class="rss-config-form">
				
	<div class="portlet-msg-info">
		<c:choose>
			<c:when test='<%=Validator.isNotNull(selectedFeedName) %>'>
				<span class="displaying-article-id-holder">
					<liferay-ui:message key="displayed-rss-feed" />: 
					<span class="displaying-article-id"><%= selectedFeedName %></span>
				</span>
			</c:when>
			<c:otherwise>
				<span class="displaying-help-message-holder <%= selectedFeed != null ? "aui-helper-hidden"  : StringPool.BLANK %>">
					<liferay-ui:message key="please-select-a-rss-feed-from-the-list-below-and-click-save-button" />
				</span>
			
				<span class="displaying-article-id-holder <%= selectedFeed != null ?  StringPool.BLANK  :"aui-helper-hidden"%>">
					<liferay-ui:message key="displayed-rss-feed" />: 
					<span class="displaying-article-id"><%= selectedFeedName %></span>
				</span>
			</c:otherwise>
		</c:choose>		
	</div>
	
	<div>
		<aui:form name="fm" method="post" action="<%=rssConfigActionURL %>">
			<aui:select name="numbersOfFeedEntries" label="total-assets-display" inlineLabel="left">
				<%
				for(int i = 0;i < numbersOfEntriesDisplayValues.length; i++)
				{
					int numbersOfEntriesDisplayValue = GetterUtil.getInteger(numbersOfEntriesDisplayValues[i]);
				%>
					<aui:option label="<%= String.valueOf(numbersOfEntriesDisplayValue)%>" 
								value="<%= String.valueOf(numbersOfEntriesDisplayValue)%>"
								selected='<%= numbersOfFeedEntries == numbersOfEntriesDisplayValue %>'/>
				<%
				}
				%>
			</aui:select>
			
			<aui:input type="checkbox" name="showPublishDate" value="<%=showPublishDate %>"/>
					
			<aui:input type="hidden"  name="selectedFeedId" value="<%= selectedFeedId %>"/>
			
			<aui:button-row>
				<aui:button type="submit" value="save"/>
				<aui:button name="cancelBtn" value="cancel"/>
			</aui:button-row>
		</aui:form>
	</div>
	
	<div class="separator"></div>
	
	<div class="rss-select-wrapper">
		<div class="rss-search">
			<aui:form name="rss_search_fm" method="post" action="<%=rssConfigRenderImpURL.toString() %>">
				<input type="text" id="<portlet:namespace/>rssSearchKeywordInput" name="rssSearchKeyword" 
					   value="<%=rssSearchKeyword %>"/>
				
				<aui:button type="submit" value="search"/>
				
				<aui:button value="show-all" href="<%=rssConfigRenderURL %>"/>
				
				<aui:button name="addNewFeedBtn" value="add-new-feed"/>
			</aui:form>
		</div>
		
		<div style="clear: both;"></div>
		
		<div class="separator"></div>
		
		<div class="rss-list">
		
			<liferay-ui:search-container iteratorURL="<%=rssConfigRenderImpURL %>" delta="10">
			
				<liferay-ui:search-container-results 
					results="<%=ListUtil.subList(groupFeeds, searchContainer.getStart(), searchContainer.getEnd()) %>" 
					total="<%=groupFeeds.size() %>"
				/>
				<liferay-ui:search-container-row className="RssFeed" keyProperty="id_" modelVar="rssFeed">
					
					<%
						feedIndex ++;
					%>
					
					<liferay-portlet:renderURL portletConfiguration="true" var="selectFeedURL" >
						<liferay-portlet:param name="selectedFeedId" value="<%=String.valueOf(rssFeed.getId_()) %>"/>
					</liferay-portlet:renderURL>
															
					<liferay-ui:search-container-column-text 
						name="#" 
						value="<%=String.valueOf(feedIndex)%>" 
						href="<%=selectFeedURL %>"
						title="select"
					/>
													
					<liferay-ui:search-container-column-text 
						name="feed-name"
						value="<%=rssFeed.getName()%>" 
						href="<%=selectFeedURL %>"
						title="select"
					/>
																	
					<liferay-ui:search-container-column-text 
						name="feed-url" 
						value="<%=rssFeed.getUrl()%>" 
						href="<%=selectFeedURL %>"
						title="select"
					/>
													
					<liferay-ui:search-container-column-text 
						name="create-date" 
						value="<%=dateTimeFormat.format(rssFeed.getCreateDate())%>"
						href="<%=selectFeedURL %>"
						title="select"
					/>
					
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator paginate="<%=true %>"/>
			</liferay-ui:search-container>
		</div>
	</div>
</div>

<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		var rssSearchKeywordInput = A.one('#<portlet:namespace/>rssSearchKeywordInput');
		
		if(rssSearchKeywordInput){
			rssSearchKeywordInput.focus();
		}
		
		var addNewFeedBtn = A.one('#<portlet:namespace/>addNewFeedBtn');
		
		if(addNewFeedBtn){
			
			addNewFeedBtn.on('click',function(){

				var addFeedURL = Liferay.PortletURL.createRenderURL();
											
				addFeedURL.setPortletId('<%=rssAdminPortletResource %>');
				addFeedURL.setWindowState('pop_up');
				addFeedURL.setParameter('jspPage', '/html/admin/rss_feed_update_form.jsp');
				addFeedURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-rss-feed'),
					uri: addFeedURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
								
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
				
	Liferay.provide(
		window,
		'refresh',
		function(){
			var portletConfigDialog = parent.frames['<%=portletConfigContainerId%>'].document;
			
			if(portletConfigDialog){
				portletConfigDialog.location.reload(true);
			}
		}
	);
</aui:script>
