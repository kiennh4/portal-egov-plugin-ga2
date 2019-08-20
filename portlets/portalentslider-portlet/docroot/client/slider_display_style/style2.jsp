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
			
	#prev, #next {
		display: block;
		min-width:50px;
		height: 100%;
		position: absolute;
		top: 0;
	}
	
	#prev:hover img, #next:hover img {
		display: block;
	}
	#prev {
		left: 20px;
	}
	#next {
		right: 20px;
	}
	#prev img {
		background-position: 0 -230px;
		padding-left: 25px;
		left: 0;
	}
	#next img {
		background-position: 0 -115px;
		padding-right: 25px;
		right: 0;
	}
	#wrapper:hover #prev, #wrapper:hover #next {
		display: block !important;
	}
	#navi {
		background-color: #FFFFFF;
	    bottom: 0;
	    height: 40px;
	    opacity: 0.7;
		filter:alpha(opacity=70); 
	    position: absolute;
	    width: 100%;
	}
	#pagenumber, #title, #pager {
		margin: 0;
		padding: 0;
	}
	#pagenumber {
		display: none;
	    float: left;
	    margin: 10px;
	    width: 200px;
	}
	#title {
		font-size: 18px;
		text-align: center;
		width: 260px;
		float: left;
	}
	#pager {
		float: left;
	    margin: 10px;
	    position: relative;
	    text-align: right;
	}
	#pager a {
		text-decoration: none;
		text-align: center;
		line-height: 20px;
		display: inline-block;
		width: 18px;
		height: 20px;
		position: relative;
	}
	#pager a.selected {
		background-color: #666;
		color: #fff;
	}
	
	#pager a:hover img {
		display: block;
	}
</style>

<div id="slider-content" style="<%=customCss%>">
	<div id="carousel" >
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
						<img alt="" src="<%=imageURL%>" width="<%=sliderWidth%>" height="<%=sliderHeight%>">
						<%
					}
				}
			}catch(Exception e){
				
			}
		}
	%>
	</div>
	
	<a href="#" title="Go to the previous image." id="prev"></a>
	<a href="#" title="Go to the next image." id="next"></a>
	<div id="navi">
		<p id="pagenumber">Now showing image <span></span> of <%=count%>.</p> 
		<p id="title"></p> 
		<p id="pager">Go to image <span></span></p>
	</div>
</div>
<div style="clear: both;"></div>

<script type="text/javascript">
var contentWidth = $('#slider-content').width();
var contentHeight = $('#slider-content').height();
function setNavi( $c, $i ) {
	var title = $i.attr( 'alt' );
	$('#title').text( title );
	var nextWidth = contentWidth/2 + "px";
	var prevWidth = nextWidth;
	var current = $c.triggerHandler( 'currentPosition' );
	$('#pagenumber span').text( current+1 );
 
	var $prev = ($i.is(':first-child')) ? $c.children().last() : $i.prev();
	var small = $prev.attr('src').split('?imageThumbnail=4').join('?imageThumbnail=3');
	var prevImage = '<img src="'+small+'" />';
	
	$('#prev').html(prevImage);
	var prevImageHeight = $('#prev').find('img').first().height();
	var prevImageTopPos = (contentHeight - prevImageHeight)/2 + "px";
	$('#prev').find('img').first().css("top", prevImageTopPos);
	$('#prev').css({"width":prevWidth});
	
	var $next = $i.next();
	var small = $next.attr('src').split('?imageThumbnail=4').join('?imageThumbnail=3');
	var nextImage = '<img src="'+small+'" />';
	$('#next').html(nextImage);
	var nextImageHeight = $('#next').find('img').first().height();
	var nextImageTopPos = (contentHeight - nextImageHeight)/2 + "px";
	$('#next').find('img').first().css("top", nextImageTopPos);
	$('#next').css({"width":nextWidth});
}
$(function() {
	
	
	var carouselHeight = '<%=sliderHeight + "px"%>';
	var carouselWidth = '<%=sliderWidth + "px"%>';
	
	$("#carousel").carouFredSel({
		auto: true,
		width: carouselWidth,
		height: carouselHeight,
		items: {
			width: contentWidth,
			height: contentHeight,
			visible: 1,
			start: -1
		},
		
		prev: '#prev',
		next: '#next',
		pagination: {
			container: '#pager span',
			anchorBuilder: function( nr ) {
				
				var small = $(this).attr('src').split('?imageThumbnail=4').join('?imageThumbnail=3');
				
				return '<a href="#" title="Go to image '+nr+'.">'+nr+'<img src="'+small+'" /></a>';
			}
		},
		scroll: {
			items: 1,
			duration: parseInt('<%=duration%>'),
			timeoutDuration: parseInt('<%=durationTimeout%>'),
			onBefore: function( data ) {
				setNavi( $(this), data.items.visible );
			}
		},
		onCreate: function( data ) {
			setNavi( $(this), data.items );
		}
	});
});

</script>

