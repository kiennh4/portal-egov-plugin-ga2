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
<div class="sub-navigation">
	<div class="top-notify main-content">
	    <div class="datetime">
	    	<span id="portal_egov_clock"></span>
	    </div>
	    <div class="main-slogan">
	    	<div class="slogan-content">
		    	<marquee width="100%" direction="left" height="100%">
		    		<%=slogan %>
		    	</marquee>
	    	</div>
	    </div>
	    <div style="clear:both;"></div>
	 </div>
</div>