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
<style>
	.style-2-container{	
		margin: 0 auto;
  		overflow: hidden;
  		max-width: 1170px;
	}
	.style-2-container .light-slider {
		list-style: none;
  		margin: 0;
  		padding: 0;
  		width: 100%;
	}
	.style-2-container .light-slider li{
		display: block;
  		float: left;
  		margin: 0;
  		width: 100%;
	}
	.style-2-container img{
		display: block;
  		width: 100%;
	}
</style>
	
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
	  pauseOnHover: true,
	  responsive: [{
	    breakpoint: 600,
	    settings: {
	      item: 1
	    }
	  }]
	});
</script>

