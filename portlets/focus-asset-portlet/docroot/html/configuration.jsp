<%@page import="com.bkav.portal.portlet.focus_asset.util.FocusAssetConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String styleThumbnailImgPath = "/focus-asset-portlet/html/style/" + displayStyle.trim() + "/thumbnail.png";
%>

<liferay-portlet:actionURL portletConfiguration="true" var="portletConfigActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<div class="portlet-config-form">
	<aui:form name="portletConfigForm" method="post" action="<%=portletConfigActionURL%>">
		
		<h3 class="config-title"><liferay-ui:message key="display-setting"/></h3>
		
		<div class="lfr-form-row">
			<aui:select id="styleSelector" name="displayStyle" inlineLabel="left">
				<aui:option label="select" value="" selected='<%=Validator.isNull(displayStyle) %>'/>
				<aui:option label="<%=FocusAssetConstants.DISPLAY_STYLE_1 %>" value="<%=FocusAssetConstants.DISPLAY_STYLE_1 %>" 
							selected='<%=Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_1) %>'/>
				<aui:option label="<%=FocusAssetConstants.DISPLAY_STYLE_2 %>" value="<%=FocusAssetConstants.DISPLAY_STYLE_2 %>" 
							selected='<%=Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_2) %>'/>
				<aui:option label="<%=FocusAssetConstants.DISPLAY_STYLE_3 %>" value="<%=FocusAssetConstants.DISPLAY_STYLE_3 %>" 
							selected='<%=Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_3) %>'/>
				<aui:option label="<%=FocusAssetConstants.DISPLAY_STYLE_4 %>" value="<%=FocusAssetConstants.DISPLAY_STYLE_4 %>" 
							selected='<%=Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_4) %>'/>
				<aui:option label="<%=FocusAssetConstants.DISPLAY_STYLE_5 %>" value="<%=FocusAssetConstants.DISPLAY_STYLE_5 %>" 
							selected='<%=Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_5) %>'/>
			</aui:select> 
		</div>
		
		<div class='config-detail-wrapper <%=Validator.isNotNull(displayStyle) ? "" : "aui-helper-hidden"%>'>
			<div class="lfr-form-row style-thumbnail">
				<img 
					id="<portlet:namespace/>styleThumbnailImage"  
					src="<%=styleThumbnailImgPath %>"
					onerror="this.src='/focus-asset-portlet/images/default-asset-image.jpg'" 
				/>
			</div>
			
			
			<div id="<portlet:namespace/>styleConfigContainer">
			
				<h3 class="config-title"><liferay-ui:message key="asset-query-rules"/></h3>
				
				<div id="<portlet:namespace/><%=FocusAssetConstants.DISPLAY_STYLE_1 %>" 
					 class='style-setting <%=((Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_1))) ? "" : "aui-helper-hidden"%>'>
					<liferay-util:include page="/html/style/style-1/config.jsp" servletContext="<%=getServletContext() %>" />
				</div>
				<div id="<portlet:namespace/><%=FocusAssetConstants.DISPLAY_STYLE_2 %>" 
					 class='style-setting <%=((!Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_1)) && (!Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_5))) ? "" : "aui-helper-hidden"%>'>
					<liferay-util:include page="/html/style/style-2/config.jsp" servletContext="<%=getServletContext() %>" />
				</div>
				<div id="<portlet:namespace/><%=FocusAssetConstants.DISPLAY_STYLE_5 %>" 
					 class='style-setting <%=((Validator.equals(displayStyle, FocusAssetConstants.DISPLAY_STYLE_5))) ? "" : "aui-helper-hidden"%>'>
					<liferay-util:include page="/html/style/style-5/config.jsp" servletContext="<%=getServletContext() %>" />
				</div>
			</div>
		</div>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	AUI().ready('aui-loading-mask','aui-io-request','liferay-portlet-url',function(A){
		
		var displayStyleSelector = A.one('#<portlet:namespace/>styleSelector');
		
		if(displayStyleSelector){
			
			displayStyleSelector.on('change',function(){
				
				A.one('.config-detail-wrapper').show();
				
				A.all('#<portlet:namespace/>styleConfigContainer .style-setting').hide();
				
				var selectedStyle = this.val().trim();
				
				var styleThumbnailImg = A.one('#<portlet:namespace/>styleThumbnailImage');
				
				if(styleThumbnailImg){
					var selectedStyleThumbnailPath = '/focus-asset-portlet/html/style/' + selectedStyle + '/thumbnail.png';
					
					styleThumbnailImg.setAttribute('src',selectedStyleThumbnailPath);
				}
				if ((selectedStyle=='<%=FocusAssetConstants.DISPLAY_STYLE_1.trim() %>')){
					A.one('#<portlet:namespace/>' + '<%=FocusAssetConstants.DISPLAY_STYLE_1.trim() %>').show();
				}
				else {
					if((selectedStyle=='<%=FocusAssetConstants.DISPLAY_STYLE_5.trim() %>'))
						A.one('#<portlet:namespace/><%=FocusAssetConstants.DISPLAY_STYLE_5.trim() %>').show();
					else
						A.one('#<portlet:namespace/><%=FocusAssetConstants.DISPLAY_STYLE_2.trim() %>').show();
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