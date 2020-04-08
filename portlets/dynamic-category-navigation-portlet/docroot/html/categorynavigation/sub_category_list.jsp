<%@page import="com.bkav.portal.portlet.categorynavigation.util.CategoryUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/categorynavigation/init.jsp"%>

<%
	long rootCategoryId = ParamUtil.getLong(request, "rootCategoryId");

	List<AssetCategory> subCategoryList = AssetCategoryLocalServiceUtil.getChildCategories(rootCategoryId);
%>

	<ul>
	<%
	for(AssetCategory subCategory : subCategoryList){
	
		long categoryId = subCategory.getCategoryId();
		
		String categoryName = subCategory.getName();
		
		String categoryContentURL = CategoryUtil.getCategoryContentURL(request, categoryId);
	%>
			
		<li class="category-menu-item">
			<a href="<%=categoryContentURL%>"><%=categoryName %></a>
		</li>
	<%
	}
	%>
	</ul>