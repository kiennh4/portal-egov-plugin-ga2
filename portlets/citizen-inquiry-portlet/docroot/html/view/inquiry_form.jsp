<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<liferay-portlet:resourceURL var="captchaURL"/>

<div class="inquiry-form">
	
	<liferay-ui:success key="send-success" message="thank-you-for-your-inquiry-content" />
	
	<liferay-ui:error key="invalid-captcha" message="invalid-captcha"/>

	<liferay-portlet:renderURL var="inquiryHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/view/view.jsp"/>
	</liferay-portlet:renderURL>
		
	<liferay-portlet:actionURL name="updateInquiryContent"  var="updateInquiryContentActionURL">
		<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>" />
	</liferay-portlet:actionURL>
	
	<div class="form-title" align="center">
		<liferay-ui:message key="please-enter-valid-information-into-this-application-form"/>
	</div>
	
	<div class="form-content" align="center">
		
		<aui:form name="fm" method="post" action="<%=updateInquiryContentActionURL %>">
			
			<table>
				<tr>
					<td><liferay-ui:message key="full-name"/> (*)</td>
					<td>
						<aui:input name="citizenName" label=""/>
					</td>
				</tr>								
				<tr>
					<td><liferay-ui:message key="citizen-address-content"/></td>
					
					<td>
						<aui:input  name="citizenAddress"  label=""/>
					</td>
				</tr>
								
				<tr>
					<td><liferay-ui:message key="inquiry-title-content"/> (*)</td>
					
					<td>
						<aui:input  name="inquiryTitle" label=""/>
					</td>
				</tr>
								
				<tr>
					<td><liferay-ui:message key="inquiry-content"/> (*)</td>
					
					<td>
						<aui:input  name="inquiryContent" type="textarea" label=""/>
					</td>
				</tr>
												
				<tr>
					<td><liferay-ui:message key="captcha"/></td>
					
					<td>
						<aui:layout> 
						  <aui:column>
						    <liferay-ui:captcha url="<%=captchaURL %>" />
						  </aui:column>                            
						  <aui:column>
						    <span class="captcha_reload">
						      <img src="/citizen-inquiry-portlet/images/reload_captcha_button.jpg" alt="Reload-Capcha" title="reload-captcha"/>
						    </span>
						  </aui:column>
						</aui:layout>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key=""/>
					</td>
					
					<td>			
						<div class="aui-button-holder">												
							<aui:button type="submit" value="send-inquiry" />
							<aui:button type="button" value="cancel" href="<%=inquiryHomePageURL %>"/>
						</div>
					</td>
				</tr>
			</table>
			
		</aui:form>
	</div>
</div>

<aui:script>
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var citizenNameInput = A.one('#<portlet:namespace/>citizenName');
		
		if(citizenNameInput){
			citizenNameInput.focus();
		}
		
		var reloadCaptchaBtn = A.one(".captcha_reload");
		
		if(reloadCaptchaBtn){
		
			reloadCaptchaBtn.on('click', function(){
				
				var captchaValue = A.one(".captcha");
				
				captchaValue.setAttribute("src", "<%= captchaURL %>&force=" + new Date().getMilliseconds());
			});
		}
		
		window.validator = new A.FormValidator({
			
	        boundingBox: document.<portlet:namespace />fm,
	
	        rules: {
	            <portlet:namespace />citizenName: {
	                required: true,
	                rangeLength: ['3','75']
	            },
	            <portlet:namespace />citizenAddress: {
	                required: false,
	                rangeLength: ['0','75']
	            },
	           	<portlet:namespace />inquiryTitle: {
	                required: true,
	                rangeLength: ['3','1000']
	            },
	           	<portlet:namespace />inquiryContent: {
	                required: true,
	                rangeLength: ['3','5000']
	            }
	        }
	    });
		
		window.validator.validate();
	});
</aui:script>
