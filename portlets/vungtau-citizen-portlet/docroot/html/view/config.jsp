<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="portletConfigActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<div class="vungtau-citizen-portlet-config-form">
	<aui:form name="portletConfigForm" method="post" action="<%=portletConfigActionURL%>">
		
		<h3 class="config-title"><liferay-ui:message key="display-setting-citizen"/></h3>
		
		<div class="lfr-form-row">
			<div class="form-row">
				<div class="row-legend">
					<h4><liferay-ui:message key="online-chat-desc"/></h4>
				</div>
				<liferay-ui:input-editor name="onlineChatDesc" height="400" toolbarSet="liferayArticle" initMethod="initOnlineChatContentEditor"/>
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="legend-title">
				<h3 class="relect-legend"><liferay-ui:message key="reflect-title"/></h3>
			</div>
			<div class="form-row">
				<div class="row-legend">
					<h4><liferay-ui:message key="reflect-desc-1"/></h4>
				</div>
				<liferay-ui:input-editor name="reflectRequestDesc" height="400" toolbarSet="liferayArticle" initMethod="initReflectContentEditor"/>
				<aui:input name="reflectFirstName" type="text" label="category-title" value="<%=reflectFirstName %>" />
				<aui:input name="reflectFristUrl" type="text" label="category-url-title" value="<%=reflectFristUrl %>" />
			</div>
			<div class="form-row">
				<div class="row-legend">
					<h4><liferay-ui:message key="reflect-desc-2"/></h4>
				</div>
				<aui:input name="reflectSecondName" type="text" label="category-title" value="<%=reflectSecondName %>" />
				<aui:input name="reflectSecondUrl" type="text" label="category-url-title" value="<%=reflectSecondUrl %>" />
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="legend-title">
				<h3 class="legal-legend"><liferay-ui:message key="legal-faq-title"/></h3>
			</div>
			<liferay-ui:input-editor name="legalFaqDesc" height="400" toolbarSet="liferayArticle" initMethod="initLegalFaqContentEditor"/>
			<div class="form-row">
				<div class="row-legend">
					<h4><liferay-ui:message key="legalFaq-desc-1"/></h4>
				</div>
				<aui:input name="legalFaqFirstName" type="text" label="category-title" value="<%=legalFaqFirstName %>" />
				<aui:input name="legalFaqFirstUrl" type="text" label="category-url-title" value="<%=legalFaqFirstUrl %>" />
			</div>
			<div class="form-row">
				<div class="row-legend">
					<h4><liferay-ui:message key="legalFaq-desc-2"/></h4>
				</div>
				<aui:input name="legalFaqSecondName" type="text" label="category-title" value="<%=legalFaqSecondName %>" />
				<aui:input name="legalFaqSecondUrl" type="text" label="category-url-title" value="<%=legalFaqSecondUrl %>" />
			</div>
		</div>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	function <portlet:namespace />initOnlineChatContentEditor() {
		return "<%= UnicodeFormatter.toString(onlineChatDesc)%>";
	}
	function <portlet:namespace />initLegalFaqContentEditor() {
		return "<%= UnicodeFormatter.toString(legalFaqDesc)%>";
	}
	function <portlet:namespace />initReflectContentEditor() {
		return "<%= UnicodeFormatter.toString(reflectRequestDesc)%>";
	}
</aui:script>
