<%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="https://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="https://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="https://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="https://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>


<div id="weather-forecast-wrapper"></div>

<script type="text/javascript">

	jQuery(document).ready(function () {
		
		//Tên Tỉnh/TP hiển thị trên bảng thời tiết lấy từ cấu hình
		var cityName = '<%=customCityName%>' ;
		
		//Câu lệnh truy vấn thông tin thời tiết
		var YQLQueryStr = 'select item from weather.forecast where u="c"';
			YQLQueryStr += 'and woeid="';
			YQLQueryStr += '<%=selectedCityVMCode%>';
			YQLQueryStr += '"';
		
		//URL trỏ đến csdl thời tiết của Yahoo 
		var weatherForecastURL = "https://query.yahooapis.com/v1/public/yql?q=" + YQLQueryStr + "&format=json&callback=?";
		
		jQuery.getJSON(weatherForecastURL, function(data) {
			
			if(data.query.results){
			  	
				//Thời tiết hiện tại
				var currentWeather = data.query.results.channel.item.condition;
				
				if(currentWeather){
					
					//Biến dùng để xác định thời điểm hiện tại là ngày hay đêm
					var dayNightDetermine = 'd';
					//Giờ hiện tại 
					var currentHour = (new Date()).getHours();
					
					if(currentHour > 17){//Sau 18h sẽ chuyển sang đêm
						dayNightDetermine = 'n';
					}
					
					//Đường dẫn đến ảnh nền tương ứng với thời tiết và thời điểm hiện tại(ngày/đêm)
					var backgroundImagePath = 'https://l.yimg.com/os/mit/media/m/weather/images/icons/bkgnd/' + currentWeather.code + dayNightDetermine + '-791140.jpg';
					
					//Đường dẫn đến ảnh mô tả tương ứng với thời tiết và thời điểm hiện tại(ngày/đêm)
					var weatherImagePath = 'https://l.yimg.com/os/mit/media/m/weather/images/icons/l/' + currentWeather.code + dayNightDetermine + '-100567.png';
					
					//Nhiệt độ hiện tại
					var currentTemperature = currentWeather.temp;
					
					//Trạng thái thời tiết (nhiều mây,mưa,nắng,...)
					var currentWeatherStatus = currentWeather.text.toLowerCase();
					
					//Dự báo thời tiết của ngày hiện tại
					var currentForeCast = data.query.results.channel.item.forecast[0];
					
					//Nhiệt độ cao nhất
					var lowestTemperature = currentForeCast.low + '°C - ';
					
					//Nhiệt độ thấp nhất
					var highestTemperature = currentForeCast.high + '°C';
					
					//Template hiển thị thông tin thời tiết trên site
					var weatherTemplate = '<div class="current-weather-panel" style="' + 'background:url(' + backgroundImagePath + ') no-repeat scroll -100px -50px transparent;' +'">';
					
						weatherTemplate+= 	'<div class="current-weather-status" style="' + 'background:url(' + weatherImagePath + ') no-repeat scroll 0% 0% transparent;' +'">';

						weatherTemplate+= 		'<div class="city-name">';
						weatherTemplate+= 			'<span>' + cityName + '</span>';
						weatherTemplate+= 		'</div>';
						
						weatherTemplate+= 		'<div class="current-temperature">';
						weatherTemplate+= 			'<span>' + currentTemperature + '</span>';
						weatherTemplate+= 			'<span class="temperature-unit">' + '°C' + '</span>';
						weatherTemplate+= 			'<div class="temperature-range">';
						weatherTemplate+= 				'<span>' + lowestTemperature + '</span>';
						weatherTemplate+= 				'<span class="highest-temperature">' + highestTemperature + '</span>';
						weatherTemplate+= 			'</div>';
						weatherTemplate+= 		'</div>';
						
						weatherTemplate+= 		'<div class="weather-status">';
						weatherTemplate+= 			Liferay.Language.get(currentWeatherStatus);
						weatherTemplate+= 		'</div>';
						weatherTemplate+= 	'</div>';
						weatherTemplate+= '</div>';

					jQuery('#weather-forecast-wrapper').html(weatherTemplate);
				}
		  }
		});
	});
</script>
