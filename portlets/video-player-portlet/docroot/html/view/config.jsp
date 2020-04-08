<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);

	List<VideoCategory> listCategory = VideoCategoryLocalServiceUtil.findByGroup(groupId);	

%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<div class="portlet-msg-info"><liferay-ui:message key="only-gallery-style-can-be-show-all-categories"/> </div>

<aui:form name="fm" method="post" action="<%=configurationActionURL %>">
	<div class="portlet-config-form">		
	
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:select name="displayStyle" label="display-style" inlineLabel="left">
					<aui:option label="default-style" value="default-style" 
								selected='<%=Validator.equals(displayStyle, "default-style") %>'/>
					<aui:option label="gallery-style" value="gallery-style" 
								selected='<%=Validator.equals(displayStyle, "gallery-style") %>'/>
					<aui:option label="slider-style" value="slider-style" 
								selected='<%=Validator.equals(displayStyle, "slider-style") %>'/>
					<aui:option label="abstract-style" value="abstract-style" 
								selected='<%=Validator.equals(displayStyle, "abstract-style") %>'/>
				</aui:select>
				
				<aui:input name="styleTitle" value="<%=styleTitle %>"/>
			</div>
		</div>
		
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:select name="videoCategory" label="display-category" inlineLabel="left">
					<c:choose>
						<c:when test="<%=(listCategory.size()>0) %>">
							<%
								for (int i = 0; i < listCategory.size();i++)
								{
							%>
								<aui:option label = "<%=listCategory.get(i).getCategoryName() %>" 
											value = "<%=listCategory.get(i).getCategoryId() %>"
											selected = "<%=Validator.equals(listCategory.get(i).getCategoryId(), categoryId) %>"	
								/>
							<%
								}
							%>
							<aui:option label = "all" value = "0" cssClass = "categoryStyleDefault" 
							style = '<%=(Validator.equals(displayStyle, "gallery-style")) ? "display:block" : "display:none" %>' />
						</c:when>
						<c:otherwise>
							<aui:option  label = "no-category" value = "0L"/>
						</c:otherwise>
					</c:choose>
				</aui:select>
			</div>
		</div>
			
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:select name="numbersOfVideoDisplay" label="total-video-display" inlineLabel="left">
					<%
					for(int i = 0;i < numbersOfEntriesDisplayValues.length; i++)
					{
						int numbersOfEntriesDisplayValue = GetterUtil.getInteger(numbersOfEntriesDisplayValues[i]);
					%>
						<aui:option label="<%= String.valueOf(numbersOfEntriesDisplayValue)%>" value="<%= String.valueOf(numbersOfEntriesDisplayValue)%>"
									selected='<%= numbersOfVideoDisplay == numbersOfEntriesDisplayValue %>'/>
					<%
					}
					%>
					<aui:option label="all" value="-1" selected="<%=numbersOfVideoDisplay == -1 %>"/>
				</aui:select>
			</div>
		</div>
		
		<div class="lfr-form-row">
			<div class="row-fields">
				<aui:input type="checkbox" name="useCustomVideoFrameSize" value="<%=useCustomVideoFrameSize %>"/>
				
				<div id="<portlet:namespace />frameSizeSettingContainer" class="aui-helper-hidden">
					<aui:input name="videoFrameHeight" value="<%=videoFrameHeight %>">
						<aui:validator name="digits"/>
					</aui:input>
									
					<aui:input name="videoFrameWidth" value="<%=videoFrameWidth %>">
						<aui:validator name="digits"/>
					</aui:input>
				</div>
			</div>
		</div>
				
		<div class="lfr-form-row">
			<div class="row-fields">
							
				<aui:input type="checkbox" name="showVideoThumbnail" value="<%=showVideoThumbnail %>"/>
				
				<aui:input type="checkbox" name="showVideoPublishDate" value="<%=showVideoPublishDate %>"/>
				
				<aui:input type="checkbox" name="showViewMoreVideoLink" value="<%=showViewMoreVideoLink %>"/>
				
				<div id="<portlet:namespace />videoPageSelectorContainer" class="aui-helper-hidden">
			
					<aui:select name="videoPageLayoutId" label="display-video-on-page">
						<%
						for(Layout layout : groupLayoutList){
						%>
							<aui:option label="<%=layout.getName() %>" value="<%=layout.getPlid() %>" 
										selected="<%=videoPageLayoutId == layout.getPlid() %>"/>
						<%
						}
						%>
					</aui:select>
				</div>
			</div>
		</div>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</div>
</aui:form>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />useCustomVideoFrameSizeCheckbox','<portlet:namespace />frameSizeSettingContainer');
	Liferay.Util.toggleBoxes('<portlet:namespace />showViewMoreVideoLinkCheckbox','<portlet:namespace />videoPageSelectorContainer');
</aui:script>

<aui:script>
	AUI().ready(function(A){
		
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		var displayStyleSelect = A.one('#<portlet:namespace/>displayStyle');
		
		if (displayStyleSelect)
		{
			displayStyleSelect.on('change',function(){
				var displayStyle = displayStyleSelect.attr('value');
				if (displayStyle == 'gallery-style')
				{
					A.one ('.categoryStyleDefault').setStyle ("display","block");
				}
				else
				{
					A.one ('.categoryStyleDefault').setStyle ("display","none");
					document.getElementById("<portlet:namespace/>videoCategory").selectedIndex = -1;
				}
				
			});
		}
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>

