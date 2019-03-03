<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp"%>
 <style>
	/*jssor slider loading skin spin css*/
    .jssorl-009-spin img {
     	animation-name: jssorl-009-spin;
        animation-duration: 1.6s;
        animation-iteration-count: infinite;
        animation-timing-function: linear;
    }

    @keyframes jssorl-009-spin {
        from { transform: rotate(0deg); }
        to { transform: rotate(360deg); }
    }
    </style>
<div class="banner-slider-style-7">
	<c:if test="<%=Validator.isNotNull(styleTitle)%>">
		<div class="style-title">
			<h3><%=styleTitle%></h3>
			<div class="sperator"></div>
		</div>
	</c:if>
	<div id="jssor_7" 
		style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 1024px; height: <%=sliderHeight %>px; overflow: hidden; visibility: hidden;">
		<!-- Loading Screen -->
		<div data-u="loading" class="jssorl-009-spin"
			style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; text-align: center; background-color: rgba(0, 0, 0, 0.7);">
		</div>
		<div data-u="slides"
			style="cursor: default; position: relative; top: 0px; left: 0px; width: 1024px; height: <%=sliderHeight %>px; overflow: hidden;">
			<%
				if (Validator.isNotNull(sliderItems)) {

					try {
						JSONArray array = JSONFactoryUtil
								.createJSONArray(sliderItems);

						if (array != null) {
							for (int i = 0; i < 10; i++) {
								JSONObject object = array.getJSONObject(i);
								long imagesId = object.getLong("imageId");
								String url = object.getString("url");
								String imageURL = SliderUtil.getImageURL(imagesId,
										themeDisplay,
										SliderUtil.imageViewType.MIDIUM.toString(),
										true);
			%>
			<div>
				<a href="<%=url%>">
					<img data-u="image" src="<%=imageURL%>" onclick="location.href = <%=url%>"/>
				</a>
			</div>
			<%
				}
						}
					} catch (Exception e) {

					}
				}
			%>
		</div>
	</div>
</div>
<div style="clear: both;"></div>
<script type="text/javascript">
	$(document).ready(function ($) {
	    var jssor_7_options = {
	      $AutoPlay: 1,
	      $Idle: 0,
	      $SlideDuration: <%=durationTimeout%>,
	      $SlideEasing: $Jease$.$Linear,
	      $PauseOnHover: 4,
	      $SlideWidth: <%=sliderWidth%>,
	      $Align: 0
	    };
	
	    var jssor_7_slider = new $JssorSlider$("jssor_7", jssor_7_options);
	
	    /*#region responsive code begin*/
	    var MAX_WIDTH = 1024;
	
	    function ScaleSlider() {
	        var containerElement = jssor_7_slider.$Elmt.parentNode;
	        var containerWidth = containerElement.clientWidth;
	
	        if (containerWidth) {
	
	            var expectedWidth = Math.min(MAX_WIDTH || containerWidth, containerWidth);
	
	            jssor_7_slider.$ScaleWidth(expectedWidth);
	        }
	        else {
	            window.setTimeout(ScaleSlider, 30);
	        }
	    }
	
	    ScaleSlider();
	
	    $(window).bind("load", ScaleSlider);
	    $(window).bind("resize", ScaleSlider);
	    $(window).bind("orientationchange", ScaleSlider);
	    /*#endregion responsive code end*/
	});
</script>

