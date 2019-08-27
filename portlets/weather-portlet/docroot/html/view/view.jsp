<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<portlet:defineObjects />

<%@include file="/html/init.jsp"%>

<liferay-portlet:renderURL portletConfiguration="true" var="weatherDetailUrl" windowState="<%= LiferayWindowState.POP_UP.toString() %>" >
	<liferay-portlet:param name="jspPage" value="/html/view/weather-detail.jsp"/>
</liferay-portlet:renderURL>

<%-- <aui:script use="aui-dialog">
    Liferay.provide(
		window,
		'<portlet:namespace/>showWeatherDetail',
		function(){

			var weatherDetailUrl_ = '<%=weatherDetailUrl %>';
						
			var dialogWidow = {
				dialog: {
					centered: true,
					modal: true,
					width: 800,
					height:450,
					draggable: false,
        			resizable: false,
					cache: false
				},
				id: '<portlet:namespace/>weatherDetailForm',
				title: '<liferay-ui:message key="weather-info" />',
				uri: weatherDetailUrl_
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
	A.one('#weatherLeftForm').on('click',function(){
		<portlet:namespace/>showWeatherDetail();
	});
</aui:script> --%>
<div class="complex-portlet">
	<div class="weather-container">
		<div class="row">
			<div id="<portlet:namespace/>choose-city">
				<aui:select name="displayCity" label="" class = "chooseCity" id = "chooseCity"  onchange = "cityChange();">
					<%
						for (int i = 0;i<arrayCity.length;i++){
					%>
							<aui:option label="<%=arrayCityVi[i] %>" value="<%=arrayCity[i] %>" selected='<%=Validator.equals(displayCity, arrayCity[i]) %>'/>
					<%
						}
					%>
				</aui:select>
			</div>
			<div class="temperature-detail">
				<table class="tbl-info">
					<tr>
						<td id="<portlet:namespace/>temperature-info" class="temperature-info"></td>
						<td id="<portlet:namespace/>temperature-bigTemp" class="temperature-info"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="currency-rate">
		<div class="row">
			<table class="currency-rate-table">
			<tr>
				<td rowspan="2">
					<span><liferay-ui:message key="currency-rate"/></span>
				</td>
				<td>
					<aui:select name="displayCurrency" label="" class = "chooseCurrency" id = "chooseCurrency"  onchange = "currencyChange();">
					<%
						for (int i = 0;i<currencyType.length;i++){
					%>
						<aui:option label="<%=currencyType[i] %>" value="<%=currencyType[i] %>" selected='<%=Validator.equals(displayCurrency, currencyType[i]) %>'/>
					<%
						}
					%>
			</aui:select>
				</td>
				<td>Mua</td>
				<td>Bán</td>
			</tr>
			<tr>
				<td>USD</td>
				<td>300</td>
				<td>300</td>
			</tr>
		</table>
		</div>
	</div>
</div>
<script type="text/javascript">
var loadingImage = '/weather-portlet/html/icon/loading.gif';

var imageWeather = new Array();
	imageWeather[0] = '/weather-portlet/html/icon/rain.png';
	imageWeather[1] = '/weather-portlet/html/icon/cloud.png';
	imageWeather[2] = '/weather-portlet/html/icon/sun.png';
	
var locale = 'vi';
	locale = '<%=locale%>';
	function renderWeatherInfo(city)
	{
		$('#<portlet:namespace/>weatherInfoForm').html('<center><img width = "40px" src = "'+loadingImage+'"/></center>');
		$('#<portlet:namespace/>weatherTempForm').html('<center><img width = "40px" src = "'+loadingImage+'"/></center>');
		$('#<portlet:namespace/>imageWeather').attr('src',loadingImage);
		
		var weatherCodeDesc = {
				200: "Mưa bão", 201: "Mưa bão", 202: "Mưa bão", 210: "Mưa bão", 211: "Mưa bão", 212: "Mưa bão", 221: "Mưa bão",
				230: "Mưa bão", 231: "Mưa bão", 232: "Mưa bão", 300: "Mưa phùn", 300: "Mưa phùn", 301: "Mưa phùn", 302: "Mưa phùn",
				310: "Mưa phùn", 311: "Mưa phùn", 312: "Mưa phùn", 313: "Mưa phùn", 314: "Mưa phùn", 321: "Mưa phùn", 500: "Mưa nhẹ",
				501: "Mưa vừa", 502: "Mưa to", 503: "Mưa rất to", 504: "Mưa nặng hạt", 511: "Mưa đá", 300: "Mưa bóng mây", 
				521: "Mưa rào",
				522: "Mưa rào", 531: "Mưa rào",
				615: "Mưa nhẹ và tuyết rơi", 616: "Mưa và tuyết rơi", 620: "Tuyết rơi", 621: "Tuyết rơi", 622: "Tuyết rơi",
				701: "Sương mù", 711: "Sương khói", 721: "Sương mù", 731: "Bão cát, lốc xoáy", 741: "Sương mù",
				751: "Bão cáo", 761: "Bụi", 762: "Tro núi lửa", 771: "Gió giật", 781: "Vòi rồng",
				800: "Trời quang", 801: "Ít mây", 802: "Mây rải rác", 803: "Mây vừa", 804: "Mây xám",
				900: "Vòi rồng", 901: "Bão nhiệt đới", 902: "Bão", 903: "Trời lạnh", 904: "Trời nóng",
				905: "Gió", 906: "Mưa đá", 951: "Tĩnh lặng", 
				952: "Gió nhẹ", 953: "Gió nhẹ", 954: "Gió vừa", 955: "Gió nhẹ", 956: "Gió mạnh", 957: "Gió vừa",
				958: "Gió giật", 959: "Gió giật mạnh", 960: "Bão", 961: "Bão", 962: "Bão"
		};
		
		$.ajax ({
			url: 'http://api.openweathermap.org/data/2.5/forecast/daily?q='+city+'&units=metric&cnt=3&lang=vi&appid=936a9fc60a6809835a48b66a884f29b2',
			error: function (a,b,c)
			{
				//alert(c);
			},
			success: function (dataText)
			{	
				console.log(dataText);
				var data = dataText;
				$('#<portlet:namespace/>weatherInfoForm').html('');
				$('#<portlet:namespace/>weatherTempForm').html('');
				
				var currentDate = new Date();
				var currentHour = currentDate.getHours();
				var currentTemp = 0;
				var currentDay = '';
				var imageWeather_ = 2;
				
				if (data.list[0].weather[0].main.indexOf("Rain")>=0)
				{
					imageWeather_ = 0;
				}
				else
					if (data.list[0].weather[0].main.indexOf("Cloud")>=0)
						imageWeather_ = 1;
					else
						imageWeather_ = 2;
				
				if (currentHour>=12)
					currentTemp = Math.round(data.list[0].temp.eve);
				else
					currentTemp = Math.round(data.list[0].temp.day);
				
				currentDay = getDayMsg(currentDate.getDay());
				/*
				if (currentDate.getDay()==0)
					currentDay = '<liferay-ui:message key="day'+0+'" />';
				else
					currentDay = 'Thứ ' + (currentDate.getDay()+1);
				*/
				var tempHtml = '<p class = "bigTemp">'
								+ currentTemp
								+'°</p>';
				
				$('#<portlet:namespace/>weatherTempForm').append(tempHtml);
				
				var infoHtml = '';
				var weatherDesc = data.list[0].weather[0].description;
				if (locale=='vi')
				{
					weatherDesc  = weatherCodeDesc[""+data.list[0].weather[0].id];
				}
				
				
				infoHtml += '<p class = "weatherInfo">'
							+weatherDesc
							+'</p>';
				
				infoHtml += '<p class = "weatherInfo">'
							+Math.round(data.list[0].temp.min)
							+' - '
							+Math.round(data.list[0].temp.max)
							+'°</p>';
				
				
			/* 	infoHtml += '<p class = "weatherInfo weatherInfoDay"><strong>'
							+currentDay
							+'</strong></p>'; */
// 				infoHtml += '<p class = "weatherInfo weatherInfoDate">'
							
// 							+currentDate.getDate() + '/' 
// 							+(currentDate.getMonth()+1) + '/'
// 							+currentDate.getFullYear()+'</p>';
// 				infoHtml += '<p class = "weatherInfo weatherInfoDate"><strong>'
								
// 							+currentDate.getHours() + ':' 
// 							+(currentDate.getMinutes()) +'</strong></p>';
				
				$('#<portlet:namespace/>weatherInfoForm').append(infoHtml);
				
				$('#<portlet:namespace/>temperature-bigTemp').empty();
				$('#<portlet:namespace/>temperature-bigTemp').append(tempHtml);
				$('#<portlet:namespace/>temperature-info').empty();
				$('#<portlet:namespace/>temperature-info').append(infoHtml);
				$('#<portlet:namespace/>imageWeather').attr('src',imageWeather[imageWeather_]);
			}
		});
	}
	
	function cityChange(){
		var choosenCity = $('#<portlet:namespace/>choose-city').find('select').first().val();
		if ((choosenCity!="")&&(choosenCity!=null))
			renderWeatherInfo(choosenCity);
		else
			alert("<liferay-ui:message key="choose-city" />");
	};
	
	function showWeatherDetailPopup(city)
	{
		
	}
	
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
		return dayMsg
	}
	
</script>
<script type = "text/javascript">
	renderWeatherInfo('<%=displayCity%>');
</script>