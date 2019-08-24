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

<div class="vungtau-citizen-container">
	<div class="portlet-custom-title">
		<h3 class="title">
			<liferay-ui:message key="citizen-portlet-title"/>
		</h3>
		<div class="portlet-description">
			<span><liferay-ui:message key="citizen-portlet-description"/></span>
		</div>
	</div>
	<div class="content-container">
		<div class="chat-container citizen-column">
			<div class="image-desc">
				<img class="chat-image" alt="Doi thoai truc tuyen" src="/vungtau-citizen-portlet/images/Chat.png">
			</div>
			<div class="chat-content content-desc">
				<div class="title-desc">
					<h3><liferay-ui:message key="online-chat-title"/></h3>
				</div>
				<div class="desc-content">
					<%=onlineChatDesc %>
				</div>
				<div class="action-links">
					<select name="leaderInfo" class="leader-info">
						<option value="0"></option>
					</select>
					<div style="clear: both;"></div>
				</div>
			</div>
		</div>
		<div class="reflect-container citizen-column">
			<div class="image-desc">
				<img class="reflect-image" alt="Phan anh kien nghi" src="/vungtau-citizen-portlet/images/Speaker.png">
			</div>
			<div class="row">
				<div class="reflect-content content-desc">
					<div class="title-desc">
						<h3><liferay-ui:message key="reflect-title"/></h3>
					</div>
					<div class="desc-content">
						<%=reflectRequestDesc %>
					</div>
					<div class="action-links">
						<ul>
							<li>
								<a href="<%=reflectFristUrl %>" title="<%=reflectFirstName%>"><%= reflectFirstName %></a>
							</li>
							<li>
								<a href="<%=reflectSecondUrl %>" title="<%=reflectFirstName%>"><%= reflectSecondName %></a>
							</li>
						</ul>
						<div style="clear: both;"></div>
					</div>
				</div>
			</div>
			
		</div>
		<div class="legal-faq-container citizen-column">
			<div class="image-desc">
				<img class="search-image" alt="Khao sat y kien" src="/vungtau-citizen-portlet/images/legal-faq.png">
			</div>
			<div class="legal-faq-content content-desc">
				<div class="title-desc">
					<h3><liferay-ui:message key="legal-faq-title"/></h3>
				</div>
				<div class="desc-content">
					<%=legalFaqDesc %>
				</div>
				<div class="action-links">
					<ul>
							<li>
								<a href="<%=legalFaqFirstUrl %>" title="<%=legalFaqFirstName%>"><%= legalFaqFirstName %></a>
							</li>
							<li>
								<a href="<%=legalFaqSecondUrl %>" title="<%= legalFaqSecondName%>"><%= legalFaqSecondName %></a>
							</li>
						</ul>
					<div style="clear: both;"></div>
				</div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
</div>
