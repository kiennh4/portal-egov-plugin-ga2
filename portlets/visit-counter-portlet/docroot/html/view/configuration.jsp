<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	if(Validator.isNull(displayStyle)){
		displayStyle="style-1";
	}

	String styleThumbnailImgPath = "/visit-counter-portlet/html/style/" + displayStyle.trim() + "/thumbnail.png";
%>

<liferay-portlet:actionURL portletConfiguration="true" var="visitCounterConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="visit_counter_config_form" method="post" action="<%=visitCounterConfigURL %>">
	<aui:select name="displayStyle" label="display-style">
		<aui:option value="style-1" selected='<%=(displayStyle.equals("style-1") ? true : false) %>'><liferay-ui:message key="style-1"/></aui:option>
		<aui:option value="style-2" selected='<%=(displayStyle.equals("style-2") ? true : false) %>'><liferay-ui:message key="style-2"/></aui:option>
	</aui:select>
	
	<div class="lfr-form-row style-thumbnail">
		<img 
			id="<portlet:namespace/>styleThumbnailImage"  
			src="<%=styleThumbnailImgPath %>"
			onerror="this.src='/visit-counter-portlet/images/default-asset-image.png'" 
		/>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
</aui:form>

<aui:script>
AUI().ready('aui-loading-mask','aui-io-request','liferay-portlet-url',function(A){

	var displayStyleSelector = A.one('#<portlet:namespace/>displayStyle');
			
	if(displayStyleSelector){
		
		displayStyleSelector.on('change',function(){
			
			var selectedStyle = this.val().trim();
			
			var styleThumbnailImg = A.one('#<portlet:namespace/>styleThumbnailImage');
			
			if(styleThumbnailImg){
				var selectedStyleThumbnailPath = '/visit-counter-portlet/html/style/' + selectedStyle + '/thumbnail.png';
				
				styleThumbnailImg.setAttribute('src',selectedStyleThumbnailPath);
			}
		});
	}
		
});
</aui:script>