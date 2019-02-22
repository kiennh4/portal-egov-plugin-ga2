<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>


<liferay-portlet:actionURL portletConfiguration="true" var="weatherPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="weather-portlet-config-form" method="post" action="<%=weatherPortletConfigURL %>">
	<div class="weather_portlet_config_page">
		<table>
			<tr>
				<td><liferay-ui:message key="select-display-style"/></td>
				<td>						
					<aui:select name="displayStyle" label="">
						<aui:option label="default-style" value="default" selected='<%=Validator.equals(displayStyle, "default") %>'/>
					</aui:select>
				</td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="select-default-city"/></td>
				<td>						
					<aui:select id="citySelector" name="selectedCityVMCode" label="" onchange='getSelectedCityName();'>
					
						<aui:option label="ha-noi" value="<%=WeatherConstants.HA_NOI_CITY_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.HA_NOI_CITY_VM_CODE) %>'/>
																
						<aui:option label="lang-son" value="<%=WeatherConstants.LANG_SON_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.LANG_SON_VM_CODE) %>'/>
																						
						<aui:option label="ha-giang" value="<%=WeatherConstants.HA_GIANG_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.HA_GIANG_VM_CODE) %>'/>
																										
						<aui:option label="hai-phong" value="<%=WeatherConstants.HAI_PHONG_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.HAI_PHONG_VM_CODE) %>'/>
															
						<aui:option label="phu-yen" value="<%=WeatherConstants.PHU_YEN_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.PHU_YEN_VM_CODE) %>'/>
																																		
						<aui:option label="nghe-an" value="<%=WeatherConstants.NGHE_AN_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.NGHE_AN_VM_CODE) %>'/>
															
						<aui:option label="hue" value="<%=WeatherConstants.HUE_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.HUE_VM_CODE) %>'/>
															
						<aui:option label="da-nang" value="<%=WeatherConstants.DA_NANG_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.DA_NANG_VM_CODE) %>'/>
									
						<aui:option label="binh-dinh" value="<%=WeatherConstants.BINH_DINH_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.BINH_DINH_VM_CODE) %>'/>
																																	
						<aui:option label="vung-tau" value="<%=WeatherConstants.VUNG_TAU_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.VUNG_TAU_VM_CODE) %>'/>
																					
						<aui:option label="tp-hcm" value="<%=WeatherConstants.HCM_CITY_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.HCM_CITY_VM_CODE) %>'/>
						<aui:option label="quang-ngai" value="<%=WeatherConstants.QUANG_NGAI_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.QUANG_NGAI_VM_CODE) %>'/>
						<aui:option label="vinh-phuc" value="<%=WeatherConstants.VINH_PHUC_VM_CODE %>" 
									selected='<%=Validator.equals(selectedCityVMCode, WeatherConstants.VINH_PHUC_VM_CODE) %>'/>
					</aui:select>
				</td>
			</tr>
			
			<tr >
				<td><liferay-ui:message key="custom-city-name"/></td>
				<td>						
					<aui:input id="customCityName" name="customCityName" label="" value="<%= customCityName %>" />
				</td>
			</tr>
		</table>
	</div>
	<br/>
	<aui:button type="submit" value="save"/>
</aui:form>

<aui:script>
	function getSelectedCityName(){
		var A = AUI();
		
		var citySelector = A.one('#_86_citySelector');
		
		if(citySelector){
			citySelector.get("options").each(function(){
			
				if(this.get('selected')){
					var selectedCityName = this.get('text');
					
					var customCityNameInputText = A.one('#_86_customCityName');
					
					if(customCityNameInputText){
						customCityNameInputText.set('value', selectedCityName);
					}
				}
			});
		}
	}

</aui:script>