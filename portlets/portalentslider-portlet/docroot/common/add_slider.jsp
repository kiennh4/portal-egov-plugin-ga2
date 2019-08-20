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



<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<%@ include file="/init.jsp" %>
<%
	boolean isAllowCloseDialog = false;
	
	String cmd = ParamUtil.getString(request, Constants.CMD, StringPool.BLANK);
	
	if(cmd.equals(Constants.REJECT)){
		isAllowCloseDialog = true;
	}
%>

<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="addURL" portletName="<%= SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>">
	<portlet:param name="mvcPath" value="/common/add_slider.jsp" />
</liferay-portlet:renderURL>
	
<liferay-portlet:actionURL var="updateSliderURL" name="updateSlider"  portletName="<%=SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>">
	<liferay-portlet:param name="redirect" value="<%=addURL %>"></liferay-portlet:param>
</liferay-portlet:actionURL>

<aui:form name="fmUpdateSlider" action="<%=updateSliderURL %>">

	<aui:field-wrapper label="add-slider" helpMessage="guide-upload-slider">
	<div class="taglib-header"></div>
	<aui:fieldset label="">
		<liferay-ui:error key="<%=SliderUtil._ERROR_MSG01_KEY %>" message="<%=SliderUtil._ERROR_MSG01 %>"/>
		<liferay-ui:error key="<%=SliderUtil._ERROR_MSG02_KEY %>" message="<%=SliderUtil._ERROR_MSG02 %>"/>
		<liferay-ui:error key="<%=SliderUtil._ERROR_MSG03_KEY %>" message="<%=SliderUtil._ERROR_MSG03 %>"/>
		<liferay-ui:success key="<%=SliderUtil._SUCCESS_MSG_KEY %>" message="<%=SliderUtil._SUCCESS_MSG %>"/>
		
	</aui:fieldset>
	
	<aui:fieldset label="">
		<liferay-util:include page="/common/uploadImages.jsp" servletContext="<%=application %>">
			<portlet:param name="resourceNamespace" value="<%=themeDisplay.getPortletDisplay().getNamespace() %>"></portlet:param>
			<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>"></portlet:param>
		</liferay-util:include>
	</aui:fieldset>
	<aui:fieldset>
		
	</aui:fieldset>
	<aui:fieldset label="">
		<aui:input name="<%=Constants.CMD %>" id="<%=Constants.CMD %>" type="hidden" value=""/>
		<aui:button name="saveBtn" value="save"/>
		<aui:button name="saveAndContinueBtn" value='save-and-continue'/>
	</aui:fieldset>
	</aui:field-wrapper>
</aui:form>

<aui:script>
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		var sliderName = A.one('#<portlet:namespace />sliderName');
		
		if(sliderName){
			sliderName.focus();
		}
		
		<%
			if(isAllowCloseDialog){
				%>
					closeDialog();
				<%
			}
		%>
				
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />fmUpdateSlider,
	
	        rules: {
	         	<portlet:namespace />sliderName: {
		                required: true,
		                rangeLength: ['3','64']
		        }
	        }
	    });
	    
	    var saveBtn = A.one('#<portlet:namespace />saveBtn');
		
		saveBtn.on('click',function(){
		
			var sliderNameInputText = A.one('#<portlet:namespace/>sliderName');
			var sliderName = sliderNameInputText.val();
			
			if(sliderName != '' && sliderName.length >= 3 && sliderName.length <= 64){
				A.one('#<portlet:namespace/>' + '<%=Constants.CMD %>').val('<%=Constants.REJECT %>');
				submitForm(document.<portlet:namespace />fmUpdateSlider);
				
			}else{
				sliderNameInputText.focus();
			}
		});
	    
	    var saveAndContinueBtn = A.one('#<portlet:namespace />saveAndContinueBtn');
		
		saveAndContinueBtn.on('click',function(){
		
			var sliderNameInputText = A.one('#<portlet:namespace/>sliderName');
			var sliderName = sliderNameInputText.val();
			
			if(sliderName != '' && sliderName.length >= 3 && sliderName.length <= 64){
				A.one('#<portlet:namespace/>' + '<%=Constants.CMD %>').val('');
				submitForm(document.<portlet:namespace />fmUpdateSlider);
			}else{
			
				sliderNameInputText.focus();
			}
		});
	});
	
	Liferay.provide(
        window,
        'closeDialog',function() {
		    Liferay.Util.getWindow().close();
        }     
    );
	
	Liferay.provide(
        window,
        'closeAndRefreshDialog',function() {
			Liferay.Util.getOpener().location.reload(true);
			Liferay.Util.getOpener().Liferay.Portlet.refresh('#p_p_id_86_');
		    Liferay.Util.getWindow().close();
        }     
    );
</aui:script>