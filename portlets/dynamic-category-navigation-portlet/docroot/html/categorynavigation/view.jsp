<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.bkav.portal.portlet.categorynavigation.util.CategoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/categorynavigation/init.jsp"%>

	
<div class="category-menu-wrapper">
	<c:choose>
		<c:when test="<%=selectedCategoryIds.length > 0 %>">
			<ul id="<portlet:namespace/>category-menu">
			<%
			for(int i = 0; i < selectedCategoryIds.length; i++){
			
				long categoryId = GetterUtil.getLong(selectedCategoryIds[i]);
				
				String categoryName = CategoryUtil.getCategoryName(categoryId);
				
				String categoryContentURL = CategoryUtil.getCategoryContentURL(request, categoryId);
			%>
					
				<li id="<%=categoryId%>" class="category-menu-item">
					<a id="<%=categoryId%>" href="<%=categoryContentURL%>"><%=categoryName %></a>
				</li>
			<%
			}
			%>
			</ul>
			
			<div id="<portlet:namespace/>sub-category" class="sub-category-wrapper aui-helper-hidden"></div>
		</c:when>
		
		<c:otherwise>
			<%
			renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
			%>
		
			<div class="portlet-configuration portlet-msg-info">
				<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
					label="please-config-this-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
			</div>
		</c:otherwise>
	</c:choose>
</div>
<liferay-portlet:renderURL var="rootCategoryInfoURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/categorynavigation/sub_category_list.jsp"/>
</liferay-portlet:renderURL>

<script type="text/javascript">

	AUI().ready('aui-base','aui-io-request',function(A){
		
		var timeOut = null;
		
		var categoryMenu = A.one('#<portlet:namespace/>category-menu');
		
		var categoryMenuHeight = categoryMenu.getComputedStyle('height');
		
		var categoryMenuWidth = categoryMenu.getComputedStyle('width');
		
		var categoryInfoWrapper = A.one('#<portlet:namespace/>sub-category');
		
		var categoryMenuItems = A.all('.category-menu-item');
		
		categoryMenuItems.on('mouseover',function(event){
			
			var target = event.target;
			
			var categoryMenuTop;
			
			if(target.hasClass('category-menu-item')){
				categoryMenuTop = event.target.get('offsetTop');
			}else{
				
				categoryMenuTop = event.target.get('offsetTop') - 9;
			}
			
			var categoryMenuLeft = event.target.get('offsetLeft');
			
			if(categoryMenuLeft > 200){
				
				categoryInfoWrapper.setStyles({
					top: categoryMenuTop,
				    right:   categoryMenuWidth,
				    display: 'block'
				});
				
			}else{
				
				categoryInfoWrapper.setStyles({
					top: categoryMenuTop,
				    left:   categoryMenuWidth,
				    display: 'block'
				});
			}

			
			if(timeOut != null){
				
				clearTimeout(timeOut);
			}
			
			categoryInfoWrapper.show();
			
			var rootCategoryId = event.target.get('id');
			
			A.io.request('<%=rootCategoryInfoURL%>',{   
				dataType: 'json',
				data:{
					rootCategoryId: rootCategoryId
				},
				on: {   
					success: function(){
						
						var rootCategoryInfo = this.get('responseData');
							
						categoryInfoWrapper.empty();
						
						categoryInfoWrapper.html(rootCategoryInfo);
					},
					failure:function(){
						
						var loadDataFailMsgTpl 	= '<div class="portlet-msg-info">'
												+ 	'<liferay-ui:message key="load-data-failure"/>'
												+ '</div>';
												
						categoryInfoWrapper.html(loadDataFailMsgTpl);
					}
				} 
			});
		});	
		
		categoryMenuItems.on('mouseout',function(){
			
			timeOut = setTimeout("_hideCategoryInfoWrapper()", 1000);
		});
		
		categoryInfoWrapper.on('mouseover',function(event){
			if(timeOut != null){
				
				clearTimeout(timeOut);
			}
		});	
		
		categoryInfoWrapper.on('mouseout',function(){
			
			timeOut = setTimeout("_hideCategoryInfoWrapper()", 500);
		});
		
	});
	
	function _hideCategoryInfoWrapper(){
		var A = AUI();
		
		A.one('#<portlet:namespace/>sub-category').hide();
	}
</script>