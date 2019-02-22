<%@page
	import="com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.Weblink"%>
<%@page
	import="com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.WeblinkCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks/init.jsp"%>

<%
	//Danh sach tat ca cac chuyen muc lien ket
	List<WeblinkCategory> weblinkCategoryList = WeblinkCategoryLocalServiceUtil.findByGroup(groupId);
%>

<div class="default-style">
	<c:choose>
		<c:when test="<%=defaultCategoryId > 0%>">
			<%
				List<Weblink> weblinkList = WeblinkLocalServiceUtil.findByCategory(defaultCategoryId);
			%>

			<aui:select name="selectWeblink" label=""
				onChange='openSelectedWeblink(this.value);'>
				<aui:option label="select-weblink" value="#" />
				<%
					for(Weblink weblink : weblinkList){
						
						String weblinkName = weblink.getWeblinkName();
						String weblinkURL = weblink.getWeblinkURL();
				%>
				<aui:option label="<%=weblinkName%>" value="<%=weblinkURL%>" />
				<%
					}
				%>
			</aui:select>
		</c:when>
		<c:otherwise>
			<aui:select name="selectWeblink" label=""
				onChange='openSelectedWeblink(this.value);'>
				<aui:option label="select-weblink" value="#" />
				<%
					for(WeblinkCategory weblinkCategory : weblinkCategoryList){
						
						long categoryId = weblinkCategory.getCategoryId();
						
						String categoryName = weblinkCategory.getCategoryName();
						
						List<Weblink> weblinkList = WeblinkLocalServiceUtil.findByCategory(categoryId);
				%>
				<optgroup label="<%=categoryName%>">
					<%
						for(Weblink weblink : weblinkList){
								
								String weblinkName = weblink.getWeblinkName();
								String weblinkURL = weblink.getWeblinkURL();
					%>
					<aui:option label="<%=weblinkName%>" value="<%=weblinkURL%>" />
					<%
						}
					%>
				</optgroup>
				<%
					}
				%>
			</aui:select>
		</c:otherwise>
	</c:choose>
</div>

<aui:script>
	function openSelectedWeblink(weblinkURL) {
		if (weblinkURL == '#') {
			return;
		} else {
			window.open(weblinkURL, '_blank');
		}
	}

	
</aui:script>