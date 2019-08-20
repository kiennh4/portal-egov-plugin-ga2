<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>



<%@ include file="/init.jsp" %>

<%
	String resourceInstanceName = ParamUtil.getString(request,"resourceInstanceName");
	long childFolderId = ParamUtil.getLong(request, "childFolderId", 0L);
%>

<liferay-portlet:actionURL var="updateSliderURL" name="updateSlider"  portletName="<%=sliderAdminPortletName %>"/> 
<liferay-portlet:renderURL var="productDetailURL" windowState="<%= WindowState.NORMAL.toString() %>">
	
</liferay-portlet:renderURL>

<aui:form name="fmUpdateSlider" action="<%=updateSliderURL %>">
	
	<aui:fieldset label="">
		<aui:input name="sliderName" type="text" label="sliderName" id="sliderName"/>
	</aui:fieldset>
	
	<aui:fieldset label="">
		<liferay-util:include page="/common/uploadImages.jsp" servletContext="<%=application %>">
			<portlet:param name="resourceNamespace" value="<%=themeDisplay.getPortletDisplay().getNamespace() %>"></portlet:param>
		</liferay-util:include>
	</aui:fieldset>
	
	<aui:fieldset label="">
		<aui:button type="submit" value="save"/>
	</aui:fieldset>
</aui:form>

<aui:script>
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
	
			var sliderName = A.one('#<portlet:namespace />sliderName');
			
			if(sliderName){
				sliderName.focus();
			}
			
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />fmUpdateSlider,
		
		        rules: {
		         	<portlet:namespace />sliderName: {
			                required: true,
			                rangeLength: ['3','64']
			        }
	
		        }
		    });
	});
</aui:script>