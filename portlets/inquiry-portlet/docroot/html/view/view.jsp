<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<div class="inquiry-form">
	
	<liferay-ui:success key="send-success" message="thank-you-for-your-inquiry-content" />
	
	<liferay-ui:error key="invalid-captcha" message="invalid-captcha"/>

	<liferay-portlet:resourceURL var="captchaURL"></liferay-portlet:resourceURL>

	<liferay-portlet:renderURL var="inquiryHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/view/view.jsp"/>
	</liferay-portlet:renderURL>
		
	<liferay-portlet:actionURL name="updateInquiryContent"  var="updateInquiryContentActionURL">
		<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>" />
	</liferay-portlet:actionURL>
	
	<div class="form-title" align="center">
		<liferay-ui:message key="online-inquiry"/>
	</div>
	
	<div class='form-content <%= SessionMessages.contains(renderRequest, "request_processed") ? "aui-helper-hidden" : "" %>' align="center">
		
		<aui:form name="fm" method="post" action="<%=updateInquiryContentActionURL %>">
			
			<table>
				<tr>
					<td><liferay-ui:message key="full-name"/> (*)</td>
					<td>
						<aui:input name="fullName" label=""/>
					</td>
				</tr>								
				<tr>
					<td><liferay-ui:message key="phone-numbers"/></td>
					
					<td>
						<aui:input  name="phoneNumbers"  label=""/>
					</td>
				</tr>
								
				<tr>
					<td><liferay-ui:message key="email"/> (*)</td>
					
					<td>
						<aui:input  name="emailAddress" label=""/>
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
						    <liferay-ui:captcha url="<%=captchaURL %>"/>
						  </aui:column>                            
						  <aui:column>
						    <span class="captcha_reload">
						      <img src="/legal-faq-portlet/images/reload_captcha_button.jpg" alt="Reload-Capcha" title="reload-captcha"/>
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

<script type="text/javascript">
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
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
	        	
	            <portlet:namespace />fullName: {
	                required: true,
	                rangeLength: ['3','75']
	            },
	            <portlet:namespace />phoneNumbers: {
	                required: false,
	                rangeLength: ['0','75']
	            },
	           	<portlet:namespace />emailAddress: {
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
</script>