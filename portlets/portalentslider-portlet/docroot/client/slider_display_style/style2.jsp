<%--
/**
Fluid width carousel with images
--%>

<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<%
	int count = 0; 
%>
<link rel="stylesheet" href="/portalentslider-portlet/css/lightslider.css"/>
<div class="style-2-container">
  <ul id="light-slider" class="light-slider">
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
								 <li>
								 	<a href="<%=url %>" title="<%=imagesId %>">
      									<img src="<%=imageURL%>" alt="" />
      								</a>
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
<div style="clear: both;"></div>
<script src="/portalentslider-portlet/js/lightslider.js"></script>
<script type="text/javascript">
$("#light-slider").lightSlider({
	  item: 6,
	  loop: true,
	  auto:true,
	  pager: false,
	  easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
	  pauseOnHover: true,
	  responsive: [{
	    breakpoint: 800,
	    settings: {
	      item: 2,
	      slideMove:1
	    }
	  }]
	});
</script>

