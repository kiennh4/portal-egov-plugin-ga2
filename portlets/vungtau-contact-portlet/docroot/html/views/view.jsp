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

<div class="contact-vungtau-container">
	<ul class="group-contact">
		<li></li>
		<li></li>
	</ul>
	 <svg xmlns="http://www.w3.org/2000/svg" width="617" height="28" viewbox="0 0 617 28">
            <g id="Group_18" data-name="Group 18" transform="translate(-662 -563)">
                <text
                    id="Đường_dây_nóng"
                    data-name="Đường dây nóng"
                    transform="translate(663 585)"
                    fill="#282b3b"
                    font-size="16"
                    font-weight="700">
                    <tspan x="0" y="0">Đường dây nóng</tspan>
                </text>
                <text
                    id="Công_dân:_088_8800_247_Doanh_nghiệp:_088.8801.247"
                    data-name="Công dân: 088 8800 247    Doanh nghiệp: 088.8801.247"
                    transform="translate(819 586)"
                    fill="#282b3b"
                    font-size="16">
                    <tspan x="0" y="0">Công dân:</tspan>
                    <tspan y="0" fill="#f83030"  font-weight="700"></tspan>
                    <tspan y="0" fill="#f83030" font-size="20" font-weight="700"><%=citizenPhone %></tspan>
                    <tspan
                        y="0"
                        xml:space="preserve"
                        fill="#f83030"
                        font-size="25"
                   
                        font-weight="700"></tspan>
                    <tspan y="0">Doanh nghiệp:</tspan>
                    <tspan y="0" fill="#f83030"></tspan>
                    <tspan y="0" fill="#f83030" font-size="20" font-weight="700"><%=enterprisePhone %></tspan>
                </text>
            </g>
        </svg>
</div>