<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.WeblinkCategory"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.Weblink"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks_admin/init.jsp"%>

<style type="text/css">

	.weblink-preview-container{
		font-size: 12px;
		font-weight: normal;
		color: #434343;
	}
	
	.weblink-preview-container table{
		border-collapse: collapse;
		width: 100%;
	}
		
	.weblink-preview-container table tr{
		height: 35px;
		border-bottom: 1px dotted #e8e8e8;
	}
		
	.weblink-preview-container table tr td{
		padding: 5px 0px;
	}
			
	.weblink-preview-container table tr td:first-child{
		min-width: 60px;
		padding-right: 10px;
		color: #00528b;
	}
			
	.weblink-preview-container table tr:hover td{
		background: #D3E8F1;
		border: 1px solid #D3E8F1;
	}
</style>

<%
	long weblinkId = ParamUtil.getLong(request, "weblinkId");

	Weblink weblink = null;
	
	if(weblinkId > 0){
		
		weblink = WeblinkLocalServiceUtil.getWeblink(weblinkId);
	}
%>

<c:choose>
	<c:when test='<%=Validator.isNotNull(weblink) %>'>
		<%
		String weblinkCategoryName = "-";
		
		if(weblink.getWeblinkCategoryId() > 0){
			
			WeblinkCategory weblinkCategory = WeblinkCategoryLocalServiceUtil.getWeblinkCategory(weblink.getWeblinkCategoryId());
			
			if(weblinkCategory != null){
				
				weblinkCategoryName = weblinkCategory.getCategoryName();
			}
		}
		%>
		<div class="weblink-preview-container">
			<table>
			
				<tr>
					<td><liferay-ui:message key="weblink-name"/></td>
					<td><span style="font-weight: bold;"><%=weblink.getWeblinkName() %></span></td>
				</tr>
			
				<tr>
					<td><liferay-ui:message key="weblink-category"/></td>
					<td><%=weblinkCategoryName %></td>
				</tr>
							
				<tr>
					<td><liferay-ui:message key="weblink-url"/></td>
					<td><a href="#"><%=weblink.getWeblinkURL() %></a></td>
				</tr>
				
				<c:if test='<%=Validator.isNotNull(weblink.getWeblinkDesc()) %>'>							
					<tr>
						<td><liferay-ui:message key="weblink-desc"/></td>
						<td><%=weblink.getWeblinkDesc() %></td>
					</tr>
				</c:if>	
														
				<tr>
					<td><liferay-ui:message key="created-date"/></td>
					<td><%=dateTimeFormat.format(weblink.getCreateDate())%></td>
				</tr>
																			
				<tr>
					<td><liferay-ui:message key="last-modified-date"/></td>
					<td><%=dateTimeFormat.format(weblink.getModifiedDate())%></td>
				</tr>
																							
				<tr>
					<td><liferay-ui:message key="last-modified-user"/></td>
					<td><%=weblink.getUserName()%></td>
				</tr>
			</table>
		</div>
		
		<div class="aui-button-holder">
			<aui:button name="openWeblinkUpdateFormBtn" value="update"/>
			<aui:button name="closeWeblinkPreviewDialogBtn" value="close"/>
		</div>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-info">
			<span><liferay-ui:message key="no-weblink-exist-with-primary-key"/> <%=weblinkId %></span>
		</div>
	</c:otherwise>
</c:choose>


<script type="text/javascript">

	AUI().ready('aui-base',function(A) {
		
		var openWeblinkUpdateFormBtn = A.one('#<portlet:namespace/>openWeblinkUpdateFormBtn');
				
		if(openWeblinkUpdateFormBtn){
			
			openWeblinkUpdateFormBtn.on('click',function(){

				Liferay.Util.getOpener().showWeblinkUpdateForm('<%=weblinkId %>');
				
			});
		}
		
		var closeWeblinkPreviewDialogBtn = A.one('#<portlet:namespace/>closeWeblinkPreviewDialogBtn');
		
		if(closeWeblinkPreviewDialogBtn){
			
			closeWeblinkPreviewDialogBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</script>