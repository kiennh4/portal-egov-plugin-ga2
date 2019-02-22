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
	jQuery('#navigation').superfish();
});

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
/*Custom javascript jquery*/
$(document).ready(function(){
	
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
	/*Event click of button scroll top*/
    $(window).scroll(function () {
        if ($(this).scrollTop() > 400) {
            $('.scroll-up-btn').fadeIn();
        } else {
            $('.scroll-up-btn').fadeOut();
        }
     });
    $('.scroll-up-btn').click(function () {
        $("html, body").animate({
            scrollTop: 0
        }, 600);
        return false;
    });
    /* Update content from theme to solgan portlet*/
    var sloganVal = $("#slogan").text();
    $("#sloganContent").html(sloganVal);
    
    /*Set height of tab-container of focus_asset_portlet to image*/ 
    var tabContainerHeight = $(".tab-content-container").height();
    $("#_focus_asset_WAR_focusassetportlet_INSTANCE_HyCOAaEnSiY0_focus-asset-img").css("height",tabContainerHeight );
});
$(function() {
    var pull = $('#pull');
        menu = $('.navigation #navigation-menu');
        menuHeight  = menu.height();
        
    $(pull).on('click', function(e) {
        e.preventDefault();
        menu.slideToggle();
    });
    $(window).resize(function(){
        var w = $(window).width();
        if(w > 320 && menu.is(':hidden')) {
            menu.removeAttr('style');
        }
    });
    var mouse_is_inside = false;
    
    $(document).ready(function()
    {
    	menu = $('.navigation #navigation-menu');
        $('#pull').hover(function(){ 
            mouse_is_inside=true; 
        }, function(){ 
            mouse_is_inside=false; 
        });

        $("body").mouseup(function(){ 
            if(! mouse_is_inside) menu.hide();
        });
    });
});
