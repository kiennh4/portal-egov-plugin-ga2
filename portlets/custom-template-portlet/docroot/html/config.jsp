<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.bkav.portlet.custom.util.CustomTemplateConstrants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>
<%
	if (Validator.isNull(displayStyle)) {
		displayStyle = "template-1";
	}

	String styleThumbnailImgPath = "/custom-template-portlet/html/template/" + displayStyle.trim() + "/thumbnail.png";
%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="portletConfigActionURL">
	<liferay-portlet:param name="portletResource"
		value="<%=portletResource%>" />
</liferay-portlet:actionURL>
<div class="portlet-config-form">
	<aui:form name="portletConfigForm" method="post"
		action="<%=portletConfigActionURL%>">
		<h3 class="config-title">
			<liferay-ui:message key="display-setting" />
		</h3>
		<div class="lfr-form-row">
			<aui:select id="styleSelector" name="displayStyle" inlineLabel="left">
				<aui:option label="<%=CustomTemplateConstrants.TEMPLATE_1%>"
					value="<%=CustomTemplateConstrants.TEMPLATE_1%>"
					selected='<%=Validator.equals(displayStyle,
							CustomTemplateConstrants.TEMPLATE_1)%>' />
				<aui:option label="<%=CustomTemplateConstrants.TEMPLATE_2%>"
					value="<%=CustomTemplateConstrants.TEMPLATE_2%>"
					selected='<%=Validator.equals(displayStyle,
							CustomTemplateConstrants.TEMPLATE_2)%>' />
				<aui:option label="<%=CustomTemplateConstrants.TEMPLATE_3%>"
					value="<%=CustomTemplateConstrants.TEMPLATE_3%>"
					selected='<%=Validator.equals(displayStyle,
							CustomTemplateConstrants.TEMPLATE_3)%>' />
				<aui:option label="<%=CustomTemplateConstrants.TEMPLATE_4%>"
					value="<%=CustomTemplateConstrants.TEMPLATE_4%>"
					selected='<%=Validator.equals(displayStyle,
							CustomTemplateConstrants.TEMPLATE_4)%>' />
			</aui:select>
		</div>
		<div class="lfr-form-row style-thumbnail">
			<img 
				id="<portlet:namespace/>styleThumbnailImage"  
				src="<%=styleThumbnailImgPath %>"
				onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'" 
			/>
		</div>
		<h3 class="config-title">
			<liferay-ui:message key="asset-query-rules" />
		</h3>

		<div class="lfr-form-row">
			<div class="row-fields">

				<div class="aui-field-row query-row">
					<aui:input label="style-title" cssClass="tab-name-input"
						name="styleTitle" value="<%=styleTitle%>" />
				</div>
			</div>
		</div>

		<aui:button-row>
			<aui:button type="submit" value="save" />
			<aui:button name="cancelBtn" value="cancel" />
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	AUI().ready('aui-loading-mask','aui-io-request','liferay-portlet-url',function(A){
		
		var displayStyleSelector = A.one('#<portlet:namespace/>styleSelector');
		
		if(displayStyleSelector){
			
			displayStyleSelector.on('change',function(){
				
				var selectedStyle = this.val().trim();
				
				var styleThumbnailImg = A.one('#<portlet:namespace/>styleThumbnailImage');
				
				if(styleThumbnailImg){
					var selectedStyleThumbnailPath = '/custom-template-portlet/html/template/' + selectedStyle + '/thumbnail.png';
					
					styleThumbnailImg.setAttribute('src',selectedStyleThumbnailPath);
				}
			});
		}
				
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>