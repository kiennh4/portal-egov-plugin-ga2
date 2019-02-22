<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoEntry"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	
	long categoryId = ParamUtil.getLong(request, "categoryId");

	VideoCategory videoCate = null;
	
	String categoryName = "";
	
	if(categoryId > 0){
		
		videoCate = VideoCategoryLocalServiceUtil.getVideoCategory(categoryId);
		
		if(videoCate != null){
			
			categoryName = videoCate.getCategoryName();
		}
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateCategory();";
%>

<div class="category-update-form">
	<c:choose>	
		<c:when test='<%= SessionMessages.contains(renderRequest, "category-saved-successfully") %>'>
			<aui:script>
				Liferay.Util.getOpener().refresh();
				Liferay.Util.getWindow().close();
			</aui:script>
		</c:when>
		
		<c:otherwise>
		
			<liferay-portlet:actionURL portletName="<%=videoAdminPortletResource %>" name="updateVideoCategory" var="updateCateActionURL">
				<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
	
			<aui:form name="fm" method="post" action="<%=updateCateActionURL%>" >
				
				<aui:input name="categoryName" label="video-category-name" value = "<%=categoryName %>">
					<aui:validator name="required" />
				</aui:input>
				<br>
				<br>
				
				<aui:button-row>
					<aui:button type="submit" value="save"/>
					<aui:button name="closeFormBtn" value="cancel"/>
				</aui:button-row>
				
			</aui:form>
		</c:otherwise>
	</c:choose>
</div>

<aui:script>
	AUI().ready(function(A){
	
		var categoryNameInput = A.one('#<portlet:namespace/>categoryName');
		
		if(categoryNameInput){
			categoryNameInput.focus();
		}
		
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />fm,
	
	        rules: {
	           
	            <portlet:namespace />categoryName: {
	                required: true,
	                rangeLength: ['6','300']
	            }
	 
	        }
	    });
		
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});			
</aui:script>