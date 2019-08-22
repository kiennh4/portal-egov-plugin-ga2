
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

<div class="vungtau-dvc-portlet-config-form">
	<aui:form name="portletConfigForm" method="post" action="<%=portletConfigActionURL%>">
		
		<h3 class="config-title"><liferay-ui:message key="display-setting"/></h3>
		
		<div class="lfr-form-row">
			<div class="legend-title">
				<h3 class="tthc-legend"><liferay-ui:message key="tthc-title"/></h3>
			</div>
			<div class="form-detail">
				<div class="form-row">
					<div class="row-legend">
						<h4><liferay-ui:message key="category-1"/></h4>
					</div>
					<aui:input name="tthcCategoryFirst" type="text" label="category-title" value="<%=tthcCateNameFirst %>" />
					<aui:input name="tthcCateUrlFirst" type="text" label="category-url-title" value="<%=tthcCateUrlFist %>" />
				</div>
				<div class="form-row">
					<div class="row-legend">
						<h4><liferay-ui:message key="category-2"/></h4>
					</div>
					<aui:input name="tthcCategorySecond" type="text" label="category-title" value="<%=tthcCateNameSecond %>" />
					<aui:input name="tthcCateUrlSecond" type="text" label="category-url-title" value="<%=tthcCateUrlSecond %>" />
				</div>
				<div class="form-row">
					<div class="row-legend">
						<h4><liferay-ui:message key="category-3"/></h4>
					</div>
					<aui:input name="tthcCategoryThird" type="text" label="category-title" value="<%=tthcCateNameThird %>" />
					<aui:input name="tthcCateUrlThird" type="text" label="category-url-title" value="<%=tthcCateUrlThird %>" />
				</div>
				<div class="form-row">
					<div class="row-legend">
						<h4><liferay-ui:message key="category-4"/></h4>
					</div>
					<aui:input name="tthcReadMore" type="text" label="category-url-title" value="<%=tthcReadMore %>" />
				</div>
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="legend-title">
				<h3 class="tthc-legend"><liferay-ui:message key="dvc-title"/></h3>
			</div>
			<div class="form-detail">
				<div class="form-row">
					<div class="row-legend">
						<h4><liferay-ui:message key="category-5"/></h4>
					</div>
					<aui:input name="dvcNameFirst" type="text" label="dvc-cate-title" value="<%=dvcNameFirst %>" />
					<aui:input name="dvcUrlFirst" type="text" label="dvc-url" value="<%=dvcUrlFirst %>" />
				</div>
				<div class="form-row">
					<div class="row-legend">
						<h4><liferay-ui:message key="category-6"/></h4>
					</div>
					<aui:input name="dvcNameSecond" type="text" label="dvc-cate-title" value="<%=dvcNameSecond %>" />
					<aui:input name="dvcUrlSecond" type="text" label="dvc-url" value="<%=dvcUrlSecond %>" />
				</div>
				
			</div>
		</div>
		<div class="lfr-form-row">
			<div class="legend-title">
				<h3 class="tthc-legend"><liferay-ui:message key="tracuu-title"/></h3>
			</div>
			<div class="form-detail">
				<div class="form-row">
					<aui:input name="tcrName" type="text" label="category-title" value="<%= trcName%>" />
					<aui:input name="trcUrl" type="text" label="dvc-url" value="<%=trcUrl %>" />
				</div>
			</div>
		</div>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>