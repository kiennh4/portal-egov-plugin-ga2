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

/*jQuery(document).ready(function(){
	jQuery('#navigation-menu').superfish();
});*/

function getCurrentDateTime(){

	var day_of_week = new Array();
	day_of_week[0] = "Chủ nhật";
	day_of_week[1] = "Thứ hai";
	day_of_week[2] = "Thứ ba";
	day_of_week[3] = "Thứ tư";
	day_of_week[4] = "Thứ năm";
	day_of_week[5] = "Thứ sáu";
	day_of_week[6] = "Thứ bảy";
	
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
	
	var currentDateValue = day_of_week[currentDay] + ", Ngày " + currentDate + "/" + month_of_year[currentMonth] + "/" + currentYear + " | " ;
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
$(document).on("ready",function(event){
	event.preventDefault();
	$('.journal-content-article [style*="font-size"]').css('font-size', '');
	$('.journal-content-article [style*="line-height"]').css('line-height', '');
	$("#increaseText").on("click", function() {
       	current = parseInt($(".journal-content-article").css("font-size"));
        bc = current + parseInt(1); 
        $(".journal-content-article").css({"font-size" : bc});
	});

	$("#decreaseText").on("click", function() {
        current = parseInt($(".journal-content-article").css("font-size"));
        bc = current - parseInt(1); 
        $(".journal-content-article").css({"font-size" : bc});
	});
	$('input[name=_3_keywords]').attr("placeholder", "Tìm kiếm");
	$(".columns-max").addClass("main-content");
	
	var pageContent = $("#content");
	var isHomePage = pageContent.find(".PortalBRVT");
	if(isHomePage.length == 0){
		pageContent.addClass("main-content");
		pageContent.addClass("portal-page");
	}
	var mainNavigation = $(".main-navigation");
	
	var portalSlider7 = $(".banner-slider-style-7");
	
	var parrentBlock = portalSlider7.closest(".slider-portlet");
	console.log(parrentBlock);
	$(parrentBlock).after(mainNavigation);
});
$("#btnSpeak").on("click",function(){
	console.log("Start speaking article content......");
	var content = $(".journal-content-article").text();
	content = content.replace(/\n|\r/g, "");
	content = content.replace(/[^0-9a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ\s]/gi, ' ');
	content = content.replace(/\s+/g, ' ');
	content = content.trim();
	console.log(content);
	responsiveVoice.speak(content,'Vietnamese Female');
	
});

$(window).scroll(function(){
    if ($(window).scrollTop() >= 370) {
        $('.main-navigation').addClass('fixed-header');
    }
    else {
        $('.main-navigation').removeClass('fixed-header');
    }
});