<%@page import="java.util.Calendar"%>
<%@page import="com.portal_egov.portlet.landprice.service.LandPriceLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandPrice"%>
<%@page import="com.portal_egov.portlet.landprice.permission.LandPricePermission"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandLocation"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.portal_egov.portlet.landprice.permission.LandLocationPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int landPriceIndex = 0;

	int statisticYear = ParamUtil.getInteger(request, "statisticYear");
	
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	String landPriceSearchKeyword = ParamUtil.getString(request, "landPriceSearchKeyword");

	List<LandPrice> landPriceList = LandPriceLocalServiceUtil.findByKeyword(groupId, 0L, landPriceSearchKeyword, statisticYear, 0, -1, null);
%>

<div class="landprice-admin">
	
	<liferay-portlet:renderURL var="landPriceAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="LandPrice"/>
	</liferay-portlet:renderURL>
		
	<liferay-portlet:renderURL var="landPriceUpdateFormURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/land_price/land_price_update_form.jsp"/>
	</liferay-portlet:renderURL>
		
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="permission-btn-row" align="left">
				
				<c:if test="<%=LandPricePermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">
					<aui:button value="add-new" href="<%=landPriceUpdateFormURL %>"/>
				</c:if>
				
				<c:if test="<%=LandPricePermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=LandPrice.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>	
						
			<div class="landprice-search-form" align="right">
				<aui:form name="fm" method="post" action="<%=landPriceAdminURL %>">
				
					<input type="text" id="<portlet:namespace/>landPriceSearchKeyword" size="40" 
							name="landPriceSearchKeyword" value='<%= landPriceSearchKeyword%>'/>
					
					<select name="statisticYear">
						<option value="0" <%=statisticYear == 0 ? "selected" : "" %>><liferay-ui:message key="statistic-year"/></option>
						<option value="<%=currentYear %>" <%=statisticYear == currentYear ? "selected" : "" %>><%=currentYear %></option>
						<option value="<%=currentYear-1 %>" <%=statisticYear == currentYear-1 ? "selected" : "" %>><%=currentYear-1 %></option>
						<option value="<%=currentYear-2 %>" <%=statisticYear == currentYear-2 ? "selected" : "" %>><%=currentYear-2 %></option>
					</select>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=landPriceAdminURL %>"/>
				</aui:form>	
			</div>		
		</div>
	</div>
	
	<div class="landprice-list">
	
		<liferay-portlet:renderURL varImpl="landPriceAdminImplURL">
			<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
			<liferay-portlet:param name="tabs1" value="LandPrice"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container iteratorURL="<%=landPriceAdminImplURL %>">
			
			<liferay-ui:search-container-results 
				results="<%=ListUtil.subList(landPriceList, searchContainer.getStart(), searchContainer.getEnd()) %>" 
				total="<%=landPriceList.size() %>"/>
			
			<liferay-ui:search-container-row className="LandPrice" keyProperty="priceId" modelVar="landPrice" escapedModel="<%=true %>">
				<%
				
				landPriceIndex ++;
				
				String landLocationName = "";
				
				if(landPrice.getLocationId() > 0){
					
					LandLocation landLocation = LandLocationLocalServiceUtil.getLandLocation(landPrice.getLocationId());
					
					if(landLocation != null){
						
						landLocationName = landLocation.getLocationName();
					}
				}

				%>
						
				<liferay-portlet:renderURL var="updateLandPriceURL">
					<liferay-portlet:param name="jspPage" value="/html/admin/land_price/land_price_update_form.jsp"/>
					<liferay-portlet:param name="priceId" value="<%=String.valueOf(landPrice.getPriceId()) %>"/>
				</liferay-portlet:renderURL>
		
				<liferay-ui:search-container-column-text 
					name="#" value="<%=String.valueOf(landPriceIndex)%>" 
					title="view"
				/>
								
				<liferay-ui:search-container-column-text 
					name="title" 
					value="<%=StringUtil.shorten(landPrice.getTitle(), 80)%>" 
					href="<%=updateLandPriceURL %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="land-location" 
					value="<%=landLocationName%>" 
					href="<%=updateLandPriceURL %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="create-date" 
					value="<%=dateFormat.format(landPrice.getCreateDate())%>"
				/>
																
				<liferay-ui:search-container-column-text 
					name="modified-date" 
					value="<%=dateFormat.format(landPrice.getModifiedDate())%>"
				/>
																				
				<liferay-ui:search-container-column-text 
					name="modified-user" 
					value="<%=landPrice.getUserName()%>"
				/>
												
				<liferay-ui:search-container-column-text name="edit"  >
					<c:if test="<%=LandPricePermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">		
						<liferay-ui:icon image="edit" message="edit" url="<%= updateLandPriceURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete" >
					<c:if test="<%=LandPricePermission.contains(permissionChecker, groupId, ActionKeys.DELETE)%>">		
																		
						<liferay-portlet:actionURL  name="deleteLandPrice" var="deleteLandPriceActionURL">
							<liferay-portlet:param name="priceId" value="<%=String.valueOf(landPrice.getPriceId()) %>"/>
							<liferay-portlet:param name="redirectURL" value="<%=landPriceAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteLandPriceActionURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
