<%--
/**
Fluid width carousel with images
--%>

<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<%
	String customCss = "width:" + sliderWidth + "px; height:" + sliderHeight + "px";
	int count = 0; 

%>


<style>
	#slider-content {
		width: 100%;
		height: 100%;
		overflow: hidden;
		position: relative;
	}
	
	#carousel img {
		display: block;
		float: left;
	}
</style>

<div id="slider-content" style="<%=customCss%>">
	<div id="carousel" >
	<div id="slides">
	<%
		if(Validator.isNotNull(sliderItems)){
			
			try{
				JSONArray array = JSONFactoryUtil.createJSONArray(sliderItems);
				
				if(array != null){
					count = array.length();
					
					for(int i = 0; i < array.length(); i++){
						JSONObject object = array.getJSONObject(i);
						long imagesId = object.getLong("imageId");
						String url = object.getString("url");
						String imageURL = SliderUtil.getImageURL(imagesId, themeDisplay, SliderUtil.imageViewType.LARGE.toString(), true);
										
						%>
							<img alt="" src="<%=imageURL%>" width="<%=sliderWidth%>" height="<%=sliderHeight%>"/>
						<%
					}
				}
			}catch(Exception e){
				
			}
		}
	%>
	</div>
	</div>
	<div id="billboard"></div>
	
</div>

<div style="clear: both;"></div>

<script type="text/javascript">
	var contentWidth = $('#slider-content').width();
	var contentHeight = $('#slider-content').height();

	$(function() {
		 
		//	you can change this number!
		var curtains = 10;
	 
		//	but not this one!
		var totalWidth = contentWidth;
	 
		//	set the width for the wrapper
		$('#slides').css({
			'width'		: totalWidth / curtains,
			'height'	: contentHeight,
			'float'		: 'left'
		});
	 
		$('#slides').children().each(function() {
	 
			//	wrap all images in a div
			$div = $(this).wrap( '<div />' ).parent();
			
			//	set the css for the div and image
			$div.css({
				'box-shadow': '0 0 5px rgba(0, 0, 0, 0.5)',
				'width'		: totalWidth / (curtains-1),
				'height'	: contentHeight,
				'overflow'	: 'hidden',
				'float'		: 'left',
				'position'	: 'relative'
			});
			$(this).css({
				'position'	: 'absolute',
				'top'		: 0
			});
		});
	 
		//	create 9 copies to function as the curtains
		for (var c = 1; c < curtains; c++) {
			var clone = $('#slides').clone();
			clone.addClass('slide').removeAttr('id');
			clone.appendTo( $("#carousel") );
			
			//	set the position of the image
			clone.find( 'img' ).css({
				'left'	: -(c * (totalWidth / curtains))
			});
		}
	 
		//	copies don't scroll automatically
		$('.slide').carouFredSel({
			items: 1,
			auto: false,
		});
	 
		//	original scrolls automatically and synchronises the copies
		$('#slides').carouFredSel({
			synchronise: '.slide',
			items: 1,
			auto: {
				duration: parseInt('<%=duration%>'),
				timeoutDuration: parseInt('<%=durationTimeout%>')
			}
		});
	});
</script>

