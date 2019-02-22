<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@include file = "/html/autoupdateadmin/updatesettings/init.jsp" %>
<div class = "update-config-form" style = "padding: 5px;">
<liferay-portlet:actionURL  name="saveUpdateConfig" var="saveUpdateConfigUrl">
	<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
</liferay-portlet:actionURL>
<c:choose>
	<c:when test='<%= SessionMessages.contains(renderRequest, "save-config-success") %>'>
		<div class = "portlet-msg-info" >
			<liferay-ui:message key = "save-success"  />
		</div>
	</c:when>
	<c:when test='<%= SessionErrors.contains(renderRequest, "save-config-error") %>'>
		<div class = "portlet-msg-error" >
			<liferay-ui:message key = "save-error"  />
		</div>
	</c:when>
</c:choose>
<aui:form action="<%=saveUpdateConfigUrl %>" method="post">
	<h4><liferay-ui:message key = "auto-update-type"/>:</h4>
	<input 
		type = "radio" 
		name = "isAutoUpdate"
		class = "<portlet:namespace/>isAutoUpdateRadio" 
		value = "true"
		<%=(isAutoUpdate) ? "checked" : StringPool.BLANK %>
	/><liferay-ui:message key = "auto-update"/>
	<br/>
	
	<input 
		type = "radio" 
		name = "isAutoUpdate"
		class = "<portlet:namespace/>isAutoUpdateRadio"  
		value = "false"
		<%=(!isAutoUpdate) ? "checked" : StringPool.BLANK %>
	/><liferay-ui:message key = "manual-update"/>
	
	<div id="<portlet:namespace />autoUpdateWrapper" style = 'display: <%=(!isAutoUpdate) ? "none" : "block"%>'>
	<hr>	
		<liferay-ui:message key="time-to-check-update"/>:
		<aui:input type = "number" name = "autoUpdateHour" value = "<%=autoUpdateHour %>" style = "width:30px;" label="" inlineField="true">
			<aui:validator name="number"/>
			<aui:validator name="max">23</aui:validator>
			<aui:validator name="min">-1</aui:validator>
		</aui:input>
		<liferay-ui:message key="hour"/>
		:
		<aui:input type = "number" name = "autoUpdateMinutes" value = "<%=autoUpdateMinutes %>" style = "width:30px;" label="" inlineField="true">
			<aui:validator name="number"/>
			<aui:validator name="max">59</aui:validator>
			<aui:validator name="min">-1</aui:validator>
		</aui:input>
		<liferay-ui:message key="minutes"/>
		<aui:input
			cssClass = "isUpdateByDayCheckBox" 
			type = "checkbox" 
			name = "isUpdateByDay" 
			value = "<%=isUpdateByDay %>" 
			
		/>
		<br>
		<div id = "<portlet:namespace />updateByDayWrapper">
		
			<aui:select name="autoUpdateDay" inlineLabel="true" value = "<%=autoUpdateDay %>">
				<aui:option value = "0" selected = '<%=(autoUpdateDay==0) ? true : false %>'><liferay-ui:message key = "monday"/></aui:option>
				<aui:option value = "1" selected = '<%=(autoUpdateDay==1) ? true : false %>'><liferay-ui:message key = "tuesday"/></aui:option>
				<aui:option value = "2" selected = '<%=(autoUpdateDay==2) ? true : false %>'><liferay-ui:message key = "wednesday"/></aui:option>
				<aui:option value = "3" selected = '<%=(autoUpdateDay==3) ? true : false %>'><liferay-ui:message key = "thursday"/></aui:option>
				<aui:option value = "4" selected = '<%=(autoUpdateDay==4) ? true : false %>'><liferay-ui:message key = "friday"/></aui:option>
				<aui:option value = "5" selected = '<%=(autoUpdateDay==5) ? true : false %>'><liferay-ui:message key = "saturday"/></aui:option>
				<aui:option value = "6" selected = '<%=(autoUpdateDay==6) ? true : false %>'><liferay-ui:message key = "sunday"/></aui:option>
			</aui:select>
		
		</div>
	</div>
	<hr>
	<aui:input name="serverUpdateDomain" value = "<%=serverUpdateDomain %>" inlineLabel="true">
		<aui:validator name="required" errorMessage="you-must-enter-domain" />
	</aui:input>
	<hr>
	<aui:button-row>
		<aui:button type = "submit" value = "save" name = "saveConfigBtn"/>
		<aui:button type = "button" value = "exit" />
	</aui:button-row>
<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />isUpdateByDayCheckbox','<portlet:namespace />updateByDayWrapper',false);
</aui:script>
</aui:form>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$('.<portlet:namespace/>isAutoUpdateRadio').click(function(){
			if($(this).attr('checked')=='checked')
			{
				if ($(this).val()=='true')
				{
					$('#<portlet:namespace />autoUpdateWrapper').show();
				}
				else
				{
					$('#<portlet:namespace />autoUpdateWrapper').hide();
				}
			}
		});
	});
</script>