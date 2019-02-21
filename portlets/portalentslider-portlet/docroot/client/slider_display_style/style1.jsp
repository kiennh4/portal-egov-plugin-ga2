<%--
/**
Fluid width carousel with images
--%>

<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp"%>

<%
	String customCss = "height:" + sliderHeight + "px";
%>

<style>
#slider-content {
	width: 100%;
	height: 100%;
	overflow: hidden;
	position: relative;
}

.slider {
	width: 100%;
	position: relative;
	overflow: hidden;
	margin: 0 auto;
}

.slider li {
	display: none;
	position: absolute;
	top: 0;
	width: 100%;
	height: 100%;
	left: 0;
}

.slider img {
	height: 100%;
	width: 100%;
}
</style>

<%-- <div id="slider-content" style="<%=customCss%>">
	<div id="carousel" >
	<%
		if(imageIds != null){
			
			for(String imagesId:imageIds){	
				
				String imageURL = SliderUtil.getImageURL(imagesId, themeDisplay, SliderUtil.imageViewType.LARGE.toString(), true);
				%>
					<img alt="" src="<%=imageURL%>" width="<%=sliderWidth%>" height="<%=sliderHeight%>">
				<%
			}
		}
	%>

	</div>
	
	<div id="pager"></div>

</div>

<div style="clear: both;"></div> --%>

<div id="slider-content">
	<ul id="slider" class="slider" style="<%=customCss%>">
		<%
			if(Validator.isNotNull(sliderItems)){
			
			try{
				JSONArray array = JSONFactoryUtil.createJSONArray(sliderItems);
				if(array != null){
					for(int i = 0; i < array.length(); i++){
						JSONObject object = array.getJSONObject(i);
						long imagesId = object.getLong("imageId");
						String url = object.getString("url");
						String imageURL = SliderUtil.getImageURL(imagesId, themeDisplay, SliderUtil.imageViewType.LARGE.toString(), true);
		%>
		<li><a href="<%=url%>" target="_blank"><img alt=""
				src="<%=imageURL%>" /></a></li>

		<%
			}
				}
			}catch(Exception e){
				
			}
				}
		%>

	</ul>


</div>

<div style="clear: both;"></div>

<script type="text/javascript">

$(function() {
	jQuery(function($) {
		  // settings
		var $slider = $('.slider'); // class or id of carousel slider
		var $slide = 'li'; // could also use 'img' if you're not using a ul
		var $transition_time = <%=duration%>; // 1 second
		var $time_between_slides = <%=durationTimeout%>; // 4 seconds
		// Get all slide item
		function slides(){
		  return $slider.find($slide);
		}
		
		slides().fadeOut();

		// set active classes
		slides().first().addClass('active');
		slides().first().fadeIn($transition_time);

		// auto scroll 
		$interval = setInterval(
		  function(){
		    var $i = $slider.find($slide + '.active').index();

		    slides().eq($i).removeClass('active');
		    slides().eq($i).fadeOut($transition_time);

		    if (slides().length == $i + 1) $i = -1; // loop to start

		    slides().eq($i + 1).fadeIn($transition_time);
		    slides().eq($i + 1).addClass('active');
		  }
		  ,$transition_time +  $time_between_slides 
		);

	});
});
</script>

