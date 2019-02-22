<%--
/**
Fluid width carousel with images
--%>

<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<%
	String customCss = "width:100%; height:" + sliderHeight + "px";
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
	#carousel img {
		display: block;
		float: left;
	}
	#carousel {
		width: 100% !important;
	}
	#pager {
		text-align: right;
		padding: 20px 0 20px 0;
		position: absolute;
		margin: 10px;
		bottom: 0;
		right:0;
	}
	#pager a {
		background-color: #356;
		display: inline-block;
		width: 15px;
		height: 15px;
		margin-right: 6px;
		border-radius: 10px;
		box-shadow: 0 1px 1px #cef;
	}
	#pager a.selected {
		background-color: #134;
	}
	#pager a span {
		display: none;
	}
	 
	#thumbs {
		display: none;
		border: 1px solid rgba(0, 0, 0, 0.8);
		background-color: rgba(0, 0, 0, 0.5);
		width: 150px;
		height: 75px;
		padding: 10px;
		position: absolute;
		top: 240px;
		right: 10px;
		z-index: 10;
	}
	#thumbs img {
		display: block;
		float: left;
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
							<img alt="" src="<%=imageURL%>" width="100%" height="<%=sliderHeight%>"/>
						<%
					}
				}
			}catch(Exception e){
				
			}
		}
	%>
	</div>
	<div id="thumbs">
		<div id="thumbscarousel">
			<%=imgThumbnails.toString() %>
		</div>
	</div>
	<div id="pager"></div>
</div>

<div style="clear: both;"></div>

<script type="text/javascript">
	var contentWidth = $('#slider-content').width();
	var contentHeight = $('#slider-content').height();

	$(function() {
		var thumbs = $('#thumbscarousel');
	 
		$('#carousel').carouFredSel({
			items: 1,
			scroll: {
				fx: 'crossfade'
			},
			auto: {
				duration: parseInt('<%=duration%>'),
				timeoutDuration: parseInt('<%=durationTimeout%>')
			},
			pagination: {
				container: '#pager',
				duration: 300
			}
		});
	 
		thumbs.carouFredSel({
			circular: false,
			auto: false,
			width: 150,
			height: 75,
			scroll: {
				duration: 200
			},
			items: {
				visible: 1,
				width: 150,
				height: 75
			}
		});
	 
		/* $('#pager').hover(function() {
			var current = $('#carousel').triggerHandler( 'currentPosition' );
			thumbs.trigger( 'slideTo', [ current, 0, true, { fx: 'none' } ] );
			$('#thumbs').stop().fadeTo(300, 1);
		}, function() {
			$('#thumbs').stop().fadeTo(300, 0);
		}); */
	 
		$('#pager a').mouseenter(function() {
			var index = $('#pager a').index( $(this) );
	 
			//	clear the queue
			thumbs.trigger( 'queue', [[]] );
	 
			//	scroll
			thumbs.trigger( 'slideTo', [index, { queue: true }] );
		});
	});
</script>

