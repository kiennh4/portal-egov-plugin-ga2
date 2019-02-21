<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Category"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/tthc_categories_portlet/init.jsp"%>

<%
	//Danh sach chueyn muc hien thi
	List<TTHC_Category> tthcCategoryList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(tthcCategoryTypeId, scopeGroupId, 0, numbersOfCategoriesDisplay);
%>

<div class="tthc-category-view">
	<ul>
		<%
			for(TTHC_Category tthcCategory : tthcCategoryList)
			{
				long tthcCategoryId = tthcCategory.getCategoryId();
				
				String categoryName = tthcCategory.getCategoryName();
		%>
				<liferay-portlet:renderURL var="viewTTHCCategoryURL">
					<liferay-portlet:param  name="tthcCategoryId" value="<%=String.valueOf(tthcCategoryId)%>"/>
				</liferay-portlet:renderURL>
											
				<li>	  		  
		  		    <a href="<%= viewTTHCCategoryURL%>"><%=categoryName%></a>
		  		    
		  		    <c:if test="<%=displayTTHCCount %>">
		  		    <%
		  		    	int tthcCounter = 0;
	  		  	
			  		  	if(tthcCategoryTypeId == TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID){		
			  		  		
			  		  		tthcCounter = TTHC_EntryLocalServiceUtil.countByLevelAndGroup(tthcCategoryId, scopeGroupId);
			  		  		
			  		  	}else if(tthcCategoryTypeId == TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID){
			  		  		
			  		  		tthcCounter = TTHC_EntryLocalServiceUtil.countByDepartment(tthcCategoryId, scopeGroupId);
			  		  		
			  		  	}else if(tthcCategoryTypeId == TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID){
			  		  		
			  		  		tthcCounter = TTHC_EntryLocalServiceUtil.countByCategoryAndGroup(tthcCategoryId, scopeGroupId);
			  		  		
			  		  	}else{
			  		  		tthcCounter = TTHC_EntryLocalServiceUtil.countByAudience(tthcCategoryId, scopeGroupId);
			  		  	}
			  		%>
			  		
			  		<span class="tthc-counter">(<%=tthcCounter %>)</span>
		  		    </c:if>
			    </li>
		<%
			}
		%>
	</ul>
</div>