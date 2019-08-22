<%@page import="com.sun.org.apache.xpath.internal.operations.Div"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<div class="vungtau-dvc-container">
	<div class="tthc-container dvc-column">
		<div class="image-desc">
			<img class="tthc-image" alt="TTHC" src="/vungtau-dvc-portlet/images/Service.png">
		</div>
		<div class="tthc-content content-desc">
			<div class="title-desc">
				<h3><liferay-ui:message key="tthc"/></h3>
			</div>
			<div class="desc-content">
				<span><liferay-ui:message key="tthc-description"/></span>
			</div>
			<div class="action-links">
				<button class="btn-link" onclick='location.href = "<%=tthcCateUrlFist %>"'><%=tthcCateNameFirst%></button>
				<button class="btn-link" onclick='location.href = "<%=tthcCateUrlSecond %>"'><%=tthcCateNameSecond%></button>
				<button class="btn-link" onclick='location.href = "<%=tthcCateUrlThird %>"'><%=tthcCateNameThird%></button>
				<a class="tthc-link" href="<%= tthcReadMore%>" target="_blank"><liferay-ui:message key="read-more"/></a>
				<div style="clear: both;"></div>
			</div>
		</div>
	</div>
	<div class="dvc-container dvc-column">
		<div class="image-desc">
			<img class="dvc-image" alt="TTHC" src="/vungtau-dvc-portlet/images/icon_CCHC_tron.png">
		</div>
		<div class="row">
			<div class="dvc-content content-desc">
				<div class="title-desc">
					<h3><liferay-ui:message key="dvc-tt"/></h3>
				</div>
				<div class="desc-content">
					<span><liferay-ui:message key="dvc-description"/></span>
				</div>
				<div class="action-links">
					<button class="btn-link" onclick='location.href = "<%=dvcUrlFirst %>"'><%=dvcNameFirst%></button>
					<button class="btn-link" onclick='location.href = "<%=dvcUrlSecond %>"'><%=dvcNameSecond%></button>
					<div style="clear: both;"></div>
				</div>
			</div>
		</div>
		
	</div>
	<div class="search-container dvc-column">
		<div class="image-desc">
			<img class="search-image" alt="TTHC" src="/vungtau-dvc-portlet/images/folder_search.png">
		</div>
		<div class="search-content content-desc">
			<div class="title-desc">
				<h3><liferay-ui:message key="tra-cuu-tiendo"/></h3>
			</div>
			<div class="desc-content">
				<span><liferay-ui:message key="tracuc-description"/></span>
			</div>
			<div class="action-links">
				<button class="btn-link" onclick='location.href = "<%=trcUrl %>"'><%=trcName%></button>
				<div style="clear: both;"></div>
			</div>
		</div>
	</div>
	<div style="clear: both;"></div>
</div>
