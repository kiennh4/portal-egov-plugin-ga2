<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/categorynavigation/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="portletConfigURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<div>
	<aui:form name="fm" method="post" action="<%=portletConfigURL%>">
	
		<div style="padding:10px 0px;border-bottom:1px solid #f1f2f3;font-weight: bold;color: #00528b;">
			<span><liferay-ui:message key="categories"/></span>
		</div>	
			
		<div class="lfr-form-row">
			<div class="row-fields">
				<div class="aui-field-row query-row">
					<div class="aui-field categories-selector">
						<liferay-ui:asset-categories-selector
							hiddenInput="selectedCategoryIds"
							curCategoryIds='<%= selectedCategoryIdsStr %>'
							focus="<%= false %>"
						/>
					</div>	
				</div>					
			</div>
		</div>
		
		<aui:button type="submit" value="save" />
	</aui:form>
</div>
