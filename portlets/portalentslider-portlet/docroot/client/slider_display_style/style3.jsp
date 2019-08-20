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
	int itemWidth = 50;
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
			
	#carousel div {
		cursor: pointer;
		float: left;
		position: relative;
		box-shadow: 0 0 10px #000;
	}
	#carousel div:last-child {
		cursor: default;
	}
	
	#carousel div span {
		background-color: #222;
		background-color: rgba(0,0,0, 0.8);
		color: #fff;
		font-size: 25px;
		text-align: center;
		display: inline-block;
		height: 25px;
		padding: 20px 0;
		overflow: hidden;
		position: absolute;
		left: 0;
		bottom: 0;
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
						int imageWidth = sliderWidth - (count -1) * itemWidth;
						if(imageWidth <= 0){
							imageWidth = sliderWidth;
						}
						int marginRight = count * itemWidth - sliderWidth;
						%>
						<div id="<%=i + 1%>" style="margin-right: <%=marginRight%>px"><img alt="" src="<%=imageURL%>" width="<%=imageWidth%>" height="<%=sliderHeight%>"/></div>
						<%
					}
				}
			}catch(Exception e){
				
			}
		}
	%>
	</div>
</div>
<div style="clear: both;"></div>

<script type="text/javascript">
var contentWidth = $('#slider-content').width();
var contentHeight = $('#slider-content').height();
$(function() {
	var itemWidth = parseInt('<%=itemWidth%>');
	var itemCount = parseInt('<%=count%>');
	var paddingRight = contentWidth - itemCount * itemWidth;
	
	$('#carousel').carouFredSel({
		width: contentWidth,
		height: contentHeight,
		align: false,
		padding: [0, paddingRight, 0, 0],
		items: {
			width: itemWidth,
			height: contentHeight,
			visible: itemCount,
			minimum: 1
		},
		scroll: {
			items: 1,
			duration: parseInt('<%=duration%>'),
			timeoutDuration: parseInt('<%=durationTimeout%>')
		},
		auto: false,
		onCreate: function() {
			$(this).children().each(function(index, item) {
				
			});
		}
	});
	$('#carousel').children().click(function() {
		$('#carousel').trigger( 'slideTo', [this, 1 - itemCount, 'prev'] );
	});
});
</script>

