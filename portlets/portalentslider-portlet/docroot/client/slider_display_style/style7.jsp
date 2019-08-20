<%--
/**
Fluid width carousel with images
--%>

<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>


<div class="banner-slider-style-7">
	<section class="slider">
        <div class="flexslider">
	          <ul class="slides">
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
										<li>
											<img alt="" src="<%=imageURL%>" style = "cursor:pointer" onclick = "javascript:location.href='<%=url %>'" >
										</li>
									<%
								}
							}
						}catch(Exception e){
							
						}
				}
		%>
	          </ul>
        </div>
     </section>
	<div style="clear: both;"></div>
</div>
<script type="text/javascript">
    $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
    });
  </script>

