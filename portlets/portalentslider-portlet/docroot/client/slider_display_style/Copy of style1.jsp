<%--
/**
Fluid width carousel with images
--%>

<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<%
	String customCss = "width:" + 100 + "%; height:" + sliderHeight + "px";
%>

<style>
	#slider-content {
		width: 100%;
		height: 100%;
		overflow: hidden;
		position: relative;
	}
	#carousel{
		width: 100% !important;
	}
	#carousel img {
		display: block;
		float: left;
		width: 100%;
	}
		
	#pager {
		background-color: #4D4D4D;
		bottom: 22px;
		height: 35px;
		position: absolute;
		right: 0;
	}
	
	#pager a {
		background-color: #C6C6C6;
		border: 2px solid #C6C6C6;
		border-radius: 10px;
		display: inline-block;
		height: 10px;
		margin: 10px 5px;
		width: 10px;
	}
	
	#pager a:hover {
		background-color: #FFF;
		border: 2px solid #FFF;
	}
	
	#pager a span {
		display: none;
	}
	
	#pager a.selected {
		background-color: #eaff00;
		border: 2px solid #eaff00;
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

<div id="slider-content" style="<%=customCss%>">
	<div id="carousel" >
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
						<a href="<%=url%>" target="_blank"><img alt="" src="<%=imageURL%>" width="<%=sliderWidth%>" height="<%=sliderHeight%>"/></a>
						<%
					}
				}
			}catch(Exception e){
				
			}
		}
	%>

	</div>
	
	<div id="pager"></div>

</div>

<div style="clear: both;"></div>

<script type="text/javascript">

$(function() {
	var contentWidth = $('#slider-content').width();
	var contentHeight = $('#slider-content').height();
	/* $('#carousel > img').each(function(e){
		$(this).attr('width', contentWidth);
	}); */
	// unit % or px
	var carouselHeight = '<%=sliderHeight + "px"%>';
	var carouselWidth = '100%';
	$('#carousel').carouFredSel({
		auto: true,
		width: carouselWidth,
		height: carouselHeight,
		items: {
			width: contentWidth,
			height: contentHeight,
			visible: 1,
			start: -1
		},
		scroll: {
			items: 1,
			duration: parseInt('<%=duration%>'),
			timeoutDuration: parseInt('<%=durationTimeout%>')
		},
		
		pagination: {
			container: '#pager',
			deviation: 1
		}
	});
});
</script>

