<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQConstants"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Category"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/vbpq_dynamic_menu/init.jsp"%>

<%
	String firstDayOfYearExtension = "/01/01";

	List<VBPQ_Category> vbpqCategoryList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.DEPARTMENT_ID, groupId, 0, -1);
%>

<div class="vbpq-dynamic-menu">
	<ul>
		<%
			for(int i = 0; i < vbpqCategoryList.size(); i++)
			{
				VBPQ_Category vbpqCategory = vbpqCategoryList.get(i);
				
				long categoryId = vbpqCategory.getCategoryId();
				String categoryName = vbpqCategory.getCategoryName();
				
		%>
				<liferay-portlet:renderURL var="viewVBPQCategoryURL">
					<liferay-portlet:param  name="vbpqCategoryId" value="<%=String.valueOf(categoryId)%>"/>
				</liferay-portlet:renderURL>
											
				<li class="vbpq-categories-main-menu">	  		  
		  		    <a href="<%= viewVBPQCategoryURL%>"><%=categoryName%></a>
		  		    
	  		    	<div class="categories-sub-menu">
	  		    		<ul>
	  		    			<%
	  		    			
	  		    			for(int j = 0; j < yearRange; j++){
	  		    				
	  		    				int statisticYear = currentYear - j;
	  		    			%>
				  		    			
							<liferay-portlet:renderURL var="viewVBPQListURL">
								<liferay-portlet:param  name="vbpqCategoryId" value="<%=String.valueOf(categoryId)%>"/>
								<liferay-portlet:param  name="statisticStartDate" value="<%=String.valueOf(statisticYear) + firstDayOfYearExtension%>"/>
								<liferay-portlet:param  name="statisticEndDate" value="<%=String.valueOf(statisticYear + 1) + firstDayOfYearExtension %>"/>
							</liferay-portlet:renderURL>
				
	  		    			<li>
	  		    				<a href="<%=viewVBPQListURL%>"><liferay-ui:message key="vbpq-statistic-year"/> &nbsp;<%=statisticYear %></a>
	  		    			</li>
	  		    			<%
	  		    			}
	  		    			
	  		    			int olderStatisticYear = currentYear - yearRange;
	  		    			%>
	  		    			
	  		    							  		    			
							<liferay-portlet:renderURL var="viewOlderVBPQListURL">
								<liferay-portlet:param  name="vbpqCategoryId" value="<%=String.valueOf(categoryId)%>"/>
								<liferay-portlet:param  name="statisticStartDate" value="<%=StringPool.BLANK %>"/>
								<liferay-portlet:param  name="statisticEndDate" value="<%=String.valueOf(olderStatisticYear) + firstDayOfYearExtension%>"/>
							</liferay-portlet:renderURL>
							
	  		    			<li>
	  		    				<a href="<%=viewOlderVBPQListURL%>"><liferay-ui:message key="vbpq-older-statistic-years"/></a>
	  		    			</li>
	  		    		</ul>
	  		    	</div>
			    </li>
		<%
			}
		%>
	</ul>
</div>

<script type="text/javascript">

	var curPoint = null;

	jQuery('.vbpq-categories-main-menu').mouseover(function(){
		
		var subMenuRef = jQuery(this).children();
	
		if(subMenuRef != null){
			var menuTop = jQuery(this).position().top;
			var menuLeft = jQuery(this).position().left;
			var menuWidth = jQuery(this).width();
			
			var subMenuLeft = menuLeft + menuWidth + 5;
	
			jQuery(subMenuRef).css({top	: menuTop + 'px',left: subMenuLeft + 'px'});
			
			jQuery(subMenuRef).show();																	
		}		
	})
	
	.mouseout(function(){
		hideSubMenu();
	})
	
	jQuery('.categories-sub-menu').mouseover(function(){
		
		if(curPoint != null){
			
			clearTimeout(curPoint);
		}
	})
	
	.mouseout(function(){		
		curPoint = setTimeout("hideSubMenu()", 500);
	});
		
	function hideSubMenu(){
		jQuery('.categories-sub-menu').hide();
	}
</script>









