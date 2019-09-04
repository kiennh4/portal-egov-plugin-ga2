<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>


<%
	//Danh sach linh vuc hoi dap
	List<LegalFAQCategory> legalFAQCategoryList = LegalFAQCategoryLocalServiceUtil.findByCompany(companyId);
	
	String askContent = "";
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitGiveAskForm();";
%>

<div class="legal-faq-give-ask-form">
	
	<liferay-ui:error key="give-ask-unsuccess" message="error-when-send-ask-content" />
	
	<liferay-ui:success key="give-ask-success" message="thank-you-for-your-ask-content" />
	
	<liferay-ui:error key="invalid-captcha" message="invalid-captcha"/>

	<liferay-portlet:resourceURL var="captchaURL"/>
			
	<liferay-portlet:renderURL var="FAQHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/legal_faq_view/view.jsp" />
	</liferay-portlet:renderURL>
		
	<liferay-portlet:actionURL name="updateAskContent"  var="updateAskContentActionURL">
		<liferay-portlet:param name="entryCommand" value="updateAskContent" />
		<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>" />
	</liferay-portlet:actionURL>
	
	<div class="form-title" align="center">
		<liferay-ui:message key="receiving-feedback"/>
	</div>
	<div class="form-content">
		
		<aui:form name="legal_faq_give_ask_form" method="post" action="<%=updateAskContentActionURL %>" onSubmit="<%=taglibOnSubmit %>" enctype="multipart/form-data">
			
			<div>
				<aui:input type="text" name="citizenName" label="full-name" inlineLabel="left" placeholder="Nhập họ tên đầy đủ">
					<aui:validator name="required"/>
				</aui:input>
				
				<aui:input type="text" name="citizenEmail" label="email-address" inlineLabel="left" placeholder="Nhập địa chỉ thư điện tử"/>
					
				<aui:input type="text" name="citizenPhone" label="phone-number" inlineLabel="left" placeholder="Nhập số điện thoại liên hệ"/>
				
				<div class="form-group">
					<aui:input type="text" name="citizenAddress" label="address" inlineLabel="left" placeholder="Nhập địa liên hệ"/>
				</div>
				<aui:select name="categoryId" label="faq-category" >
					<aui:option label="other-faq-category" value="0"/>
					<%
					for(LegalFAQCategory faqCategory : legalFAQCategoryList){
					%>
						<aui:option label="<%=faqCategory.getCategoryName() %>" value="<%=faqCategory.getCategoryId()%>" />
					<%
					}
					%>
				</aui:select>
				
				<aui:input type="text" name="askTitle" inlineLabel="left" placeholder="Nhập tiêu đề phản ánh kiến nghị">
					<aui:validator name="required"/>
				</aui:input>
								
				<aui:input type="textarea" name="askContent" inlineLabel="left" placeholder="Nhập nội dung phản ánh kiến nghị">
					<aui:validator name="required"/>
				</aui:input>
				
				<aui:input type="file" name="legalFaqAttachment" inlineLabel="left"/>
			</div>
			<div class="captcha-holder">
				<div class="captcha-container">
					<liferay-ui:captcha url="<%=captchaURL %>"/>
					<div class="captcha_reload">
						<i class="fa fa-refresh" aria-hidden="true"></i>
					</div>   
					<div style="clear: both;"></div>   
				</div>					
			</div>
			
			<div class="aui-button-holder">
				<aui:button type="submit" value="give-ask"/>
				<aui:button value="cancel" href="<%=FAQHomePageURL %>"/>
			</div>
			
			<aui:input type="hidden" name="<%=LegalFAQConstants.FAQ_ENTRY_COMMAND %>" value="<%=LegalFAQConstants.UPDATE_ASK_CONTENT %>"/>
		</aui:form>
	</div>
</div>

<script type="text/javascript">
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
		
		Liferay.provide(
			window,
			'<portlet:namespace />submitGiveAskForm',
			function() {
				
				window.validator = new A.FormValidator({
					
			        boundingBox: document.<portlet:namespace />legal_faq_give_ask_form,
			
			        rules: {
			            <portlet:namespace />citizenName: {
			                required: true,
			                rangeLength: ['3','75']
			            },
			           	<portlet:namespace />citizenEmail: {
			                required: false,
			                email: true,
			                rangeLength: ['0','75']
			            },
			           	<portlet:namespace />askTitle: {
			                required: true,
			                rangeLength: ['3','300']
			            }
			        }
			    });
				
				document.<portlet:namespace />legal_faq_give_ask_form.submit();
			},
			['aui-base']
		);
	});
</script>
