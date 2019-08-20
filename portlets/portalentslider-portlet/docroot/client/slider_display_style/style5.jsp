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
	StringBuffer imgThumbnails = new StringBuffer();
	
	int ratio = sliderWidth/sliderHeight;
	int midiumImageHeight = sliderHeight/4;
	int midiumImageWidth = midiumImageHeight * ratio;
%>


<style>

	#slider-content {
		width: 100%;
		height: 100%;
		overflow: hidden;
		position: relative;
	}
	
	#thumbnails {
		width: 956px;
		height: 120px;
		overflow: hidden;
		position: absolute;
		top: 375px;
		left: 0;
		z-index: 2;
	}
	#thumbnails img {
		display: block;
		float: left;
		margin: 10px;
		box-shadow: 0 0 10px #000;
		opacity : 0.6;
		filter:alpha(opacity=60);
	}
	#thumbnails img:hover {
		margin: 5px;
		opacity : 1;
		filter:alpha(opacity=100);
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
						
						String midiumImageURL = SliderUtil.getImageURL(imagesId, themeDisplay, SliderUtil.imageViewType.MIDIUM.toString(), true);
						imgThumbnails.append("<img src=\"");
						imgThumbnails.append(midiumImageURL + "\"");
						imgThumbnails.append(" width = \"");
						imgThumbnails.append(midiumImageWidth + "\"");
						imgThumbnails.append(" height = \"");
						imgThumbnails.append(midiumImageHeight + "\"");
						imgThumbnails.append(" alt = \"image" + (i + 1) + "\"/>");
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
	<div id="thumbnails">
		<%=imgThumbnails.toString() %>
	</div>
</div>

<div style="clear: both;"></div>

<script type="text/javascript">
	var contentWidth = $('#slider-content').width();
	var contentHeight = $('#slider-content').height();

	var midiumImageHeight = parseInt('<%=midiumImageHeight%>');
	var midiumImageWidth = parseInt('<%=midiumImageWidth%>');
	
	$(function() {
		$('#slider-content').hover(
			function() {
				$('#carousel').trigger( 'pause' );
				$('#thumbnails').parent().animate({
					top: 280
				});
			}, function() {
				
				$('#carousel').trigger( 'play' );
				$('#thumbnails').parent().animate({
					top: 375
				});
			}
		);
	 
		$('#carousel').carouFredSel({
			scroll: {
				fx: 'crossfade',
				onBefore: function( data ) {
					$('#thumbnails').trigger( 'slideTo', [ $('#thumbnails img[alt='+ data.items.visible.attr( 'alt' ) +']'), -2 ] );
				},
				auto: {
					duration: parseInt('<%=duration%>'),
					timeoutDuration: parseInt('<%=durationTimeout%>')
				}
		
			}
		});
	 
		$('#thumbnails').carouFredSel({
			auto: false,
			width:contentWidth,
			items: {
				start: -2
			}
		});
	 
		$('#thumbnails img').click(function() {
			$('#carousel').trigger( 'slideTo', [ $('#carousel img[alt='+ $(this).attr( 'alt' ) +']') ] );
	 
		}).css( 'cursor', 'pointer' );
		
		$('#thumbnails').children().each(function(index, item) {
			$(item).hover(function(){
			  $(item).css({"width":midiumImageWidth + 10 , "height":midiumImageHeight + 10});
			  },function(){
			  $(item).css({"width":midiumImageWidth , "height":midiumImageHeight});
			});
		});
	});
</script>

