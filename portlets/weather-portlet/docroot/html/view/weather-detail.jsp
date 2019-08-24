<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/init.jsp"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<style>
	.weatherDetailTemp {
	font-size: 20pt;
	margin:5px;
	color:rgb(131, 131, 252);
	margin-left:50px;
}
</style>
<portlet:defineObjects />
<script type ="text/javascript">
	function initAllWeatherDetail(){
		var arrayCityViStr = '<%=arrayCityViStr%>';
		var arrayCityVi = arrayCityViStr.split(',');
		var arrayCityStr = '<%=arrayCityStr%>';
		arrayCityStr = arrayCityStr.replace("[",'');
		arrayCityStr = arrayCityStr.replace("]",'');
		var arrayCity = arrayCityStr.split(',');
		for (var i = 0;i<arrayCityVi.length;i++)
			{
				
				var cityCode = arrayCity[i]+'@'+i;
				renderWeatherDetail(cityCode);
			}
	};
	initAllWeatherDetail();
	function renderWeatherDetail(cityCode)
	{
		var locale = 'vi';
		locale = '<%=locale%>';
		var iconPath = '/weather-portlet/html/icon/';
		var reqData = {
				q: city,
				cnt: 3,
				units:"metric",
				lang: locale
		};
		var cityCode_ = cityCode.split('@');
		var city = cityCode_[0];
		var cityId = cityCode_[1];
		$.ajax ({
			url:'/weather-portlet/html/view/get_weather_data.jsp',
			data: {
	url: 'http://api.openweathermap.org/data/2.5/forecast/daily?q='+encodeURIComponent(city)+'&units=metric&cnt=3&lang='+locale+'&appid=936a9fc60a6809835a48b66a884f29b2'
			
			
			},
			dataType: 'json',
			success: function (data)
			{	
				var detailHtml = '';
				var today = new Date();
				var tomorrow = new Date(data.list[1].dt*1000);
				var ntomorrow = new Date(data.list[2].dt*1000);
				
				var arrayCityStr = '<%=arrayCityViStr%>';
				var arrayCity = arrayCityStr.split(',');
				detailHtml += '<tr>';
				detailHtml += '<td>'+arrayCity[cityId]+'</td>';
				detailHtml += '<td class = "weatherDetailTemp">'
							  +'<img src = "'+iconPath+getWeatherImg(data.list[0].weather[0].main)+'">&nbsp&nbsp&nbsp'
							  +Math.round(data.list[0].temp.min)
							  +' - '
							  +Math.round(data.list[0].temp.max)
							  +'°C </td>';
				detailHtml += '<td class = "weatherDetailTemp">'
							  +'<img src = "'+iconPath+getWeatherImg(data.list[1].weather[0].main)+'">&nbsp&nbsp&nbsp'
							  +Math.round(data.list[1].temp.min)
							  +' - '
							  +Math.round(data.list[1].temp.max)
							  +'°C </td>';
				detailHtml += '<td class = "weatherDetailTemp">'
							  +'<img src = "'+iconPath+getWeatherImg(data.list[2].weather[0].main)+'">&nbsp&nbsp&nbsp'
					 		  +Math.round(data.list[2].temp.min)
							  +' - '
							  +Math.round(data.list[2].temp.max)
							  +'°C </td>';
				$('.<portlet:namespace/>weatherDetailContent').append(detailHtml);
				
				

				$('.<portlet:namespace/>today').html(
							 getDayMsg(today.getDay())
							+ ', '
							+ today.getDate()
							+ ' - '
							+ today.getMonth()
							+ ' - '
							+ today.getFullYear()
							);
				
				$('.<portlet:namespace/>tomorrow').html(
							 getDayMsg(tomorrow.getDay())
							+ ', '
							+ tomorrow.getDate()
							+ ' - '
							+ tomorrow.getMonth()
							+ ' - '
							+ tomorrow.getFullYear()
							);
				
				$('.<portlet:namespace/>ntomorrow').html(
							getDayMsg(ntomorrow.getDay())
							+ ', '
							+ ntomorrow.getDate()
							+ ' - '
							+ ntomorrow.getMonth()
							+ ' - '
							+ ntomorrow.getFullYear()
							);
			}
		});
	}
	function cityChange(){
		var choosenCity = $('.<portlet:namespace/>chooseCityForm').find('select').first().val();
		if ((choosenCity!="")&&(choosenCity!=null))
		{
			
			$('.<portlet:namespace/>today').html('');
			$('.<portlet:namespace/>tomorrow').html('');
			$('.<portlet:namespace/>ntomorrow').html('');
			$('.<portlet:namespace/>weatherDetailContent').html('');
			
			if(choosenCity=="all")
			initAllWeatherDetail();
			else
			
			renderWeatherDetail(choosenCity);
		
		}
		else
			alert("<liferay-ui:message key="choose-city" />");
	};
	
	function getDayMsg (date)
	{
		var dayMsg = '';
		switch (date) {
	    case 0:
	    	dayMsg = '<liferay-ui:message key="day-0" />';
	        break;
	    case 1:
	    	dayMsg = '<liferay-ui:message key="day-1" />';
	        break;
	    case 2:
	    	dayMsg = '<liferay-ui:message key="day-2" />';
	        break;
	    case 3:
	    	dayMsg = '<liferay-ui:message key="day-3" />';
	        break;
	    case 4:
	    	dayMsg = '<liferay-ui:message key="day-4" />';
	        break;
	    case 5:
	    	dayMsg = '<liferay-ui:message key="day-5" />';
	        break;
	    case 6:
	    	dayMsg = '<liferay-ui:message key="day-6" />';
	        break;
		}
		return dayMsg;
	}
	
	function getWeatherImg (weather)
	{
		var img = 'sunsmall.gif';
		if (weather.indexOf('Rain')>=0)
			img = 'rainsmall.gif';
		else
			if (weather.indexOf('Cloud')>=0)
				img = "cloudsmall.gif";
		
		return img;
				
	}
	
</script>

<div class = "<portlet:namespace/>chooseCityForm" >
	<liferay-ui:message key="choose-city" />
	<aui:select name="displayCity" label="" class = "chooseCity" id = "<portlet:namespace/>chooseCity"  onchange = "cityChange();">
			<aui:option label="Tất cả" value="all" />
			<%
				for (int i = 0;i<arrayCity.length;i++)
				{
					String cityCode = arrayCity[i] + "@" + i;
			%>
				<aui:option name_vi = "<%=arrayCityVi[i] %>" label="<%=arrayCityVi[i] %>" value="<%=cityCode %>" />
			<%
				}
			%>
	</aui:select>
</div>
<hr>
<div style = "height:300px;overflow:auto;" class = "<portlet:namespace/>weatherDetailForm">
	<table width = "100%">
		<thead>
			<tr style = "background:rgb(160, 160, 236);color:white;">
				<td width = "10%" style = "text-align:center; border-right:1px solid white;"><liferay-ui:message key="city-name" /></td>
				<td width = "30%" style = "text-align:center; border-right:1px solid white;" class = "<portlet:namespace/>today"></td>
				<td width = "30%" style = "text-align:center; border-right:1px solid white;" class = "<portlet:namespace/>tomorrow"></td>
				<td width = "30%" style = "text-align:center; " class = "<portlet:namespace/>ntomorrow"></td>
			</tr>
		</thead>
		<tbody class = "<portlet:namespace/>weatherDetailContent">
		
		</tbody>
	</table>
</div>