/*
This function gets loaded when all the HTML, not including the portlets, is
loaded.
*/
AUI().ready(
	function(A){
		var currentDateTime = setInterval("getCurrentDateTime()", 1000);
	}
);

Liferay.Portlet.ready(

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',
	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);

AUI().ready(
		'liferay-hudcrumbs', 'liferay-navigation-interaction',
		function(A) {
			var navigation = A.one('#navigation');

			if (navigation) {
				navigation.plug(Liferay.NavigationInteraction);
			}

			var siteBreadcrumbs = A.one('.site-breadcrumbs');

			if (siteBreadcrumbs) {
				siteBreadcrumbs.plug(A.Hudcrumbs);
			}
		}
);

jQuery(document).ready(function(){
	jQuery('#navigation-menu').superfish();
});

function getCurrentDateTime(){

	var day_of_week = new Array();
	day_of_week[0] = "Sunday";
	day_of_week[1] = "Monday";
	day_of_week[2] = "Tuesday";
	day_of_week[3] = "Wenesday";
	day_of_week[4] = "Thursday";
	day_of_week[5] = "Friday";
	day_of_week[6] = "Saturday";
	
	var month_of_year = new Array();
	month_of_year[0] = "01";
	month_of_year[1] = "02";
	month_of_year[2] = "03";
	month_of_year[3] = "04";
	month_of_year[4] = "05";
	month_of_year[5] = "06";
	month_of_year[6] = "07";
	month_of_year[7] = "08";
	month_of_year[8] = "09";
	month_of_year[9] = "10";
	month_of_year[10] = "11";
	month_of_year[11] = "12";
	
	var now = new Date();   
	var currentYear= now.getYear();     
	var currentMonth = now.getMonth();  
	var currentDate = now.getDate();   
	var currentDay = now.getDay();
	var currentHour = now.getHours();
	var currentMinute = now.getMinutes();
	var currentSecond = now.getSeconds();
	
	if (currentYear < 1000) {
		currentYear = 1900  + currentYear;
	}
	
	if (currentDate < 10) {
		currentDate = "0" + currentDate;
	}  
			
	if (currentHour < 10) {
		currentHour = "0" + currentHour;
	} 
			
	if (currentMinute < 10) {
		currentMinute = "0" + currentMinute;
	} 
			
	if (currentSecond < 10) {
		currentSecond = "0" + currentSecond;
	} 
	
	var currentDateValue = day_of_week[currentDay] + ", " + currentDate + "/" + month_of_year[currentMonth] + "/" + currentYear + " | " ;
	var currentTimeValue = currentHour + ":" + currentMinute + ":" + currentSecond;
	
	var currentDateWrapper = document.getElementById("portal_egov_date");
	var currentTimeWrapper = document.getElementById("portal_egov_clock");
	
	if(currentDateWrapper){
		currentDateWrapper.innerHTML = currentDateValue;
	}
	
	if(currentTimeWrapper){
		currentTimeWrapper.innerHTML = currentTimeValue;
	}
}