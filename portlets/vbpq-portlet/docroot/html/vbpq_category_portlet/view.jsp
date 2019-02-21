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

<%@include file="/html/vbpq_category_portlet/init.jsp"%>

<style type="text/css">
	.vbpq-dynamic-menu{
		
	}

</style>

<%
	List<VBPQ_Category> vbpqCategoryList = new ArrayList<VBPQ_Category>();
	
	if(Validator.equals(categoryType, "department")){		
		vbpqCategoryList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.DEPARTMENT_ID, groupId, 0, numbersOfEntriesDisplay);
		
	}else if(Validator.equals(categoryType, "category")){
		vbpqCategoryList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.CATEGORY_ID, groupId, 0, numbersOfEntriesDisplay);
		
	}else{
		vbpqCategoryList = VBPQ_CategoryLocalServiceUtil.findByTypeAndGroup(VBPQConstants.DOCUMENT_TYPE_ID, groupId, 0, numbersOfEntriesDisplay);
	}
%>

<div class="vbpq-category-view">
	<ul>
		<%
			for(int i = 0; i < vbpqCategoryList.size(); i++)
			{
				VBPQ_Category vbpqCategory = vbpqCategoryList.get(i);
				
				long categoryId = vbpqCategory.getCategoryId();
				String categoryName = vbpqCategory.getCategoryName();
		%>
				<liferay-portlet:renderURL var="viewCategoryURL">
					<liferay-portlet:param  name="vbpqCategoryId" value="<%=String.valueOf(categoryId)%>"/>
				</liferay-portlet:renderURL>
											
				<li class="vbpq-categories-main-menu">	  		  
		  		    <a href="<%= viewCategoryURL%>"><%=categoryName%></a>
		  		    <c:if test="<%=displayVBPQCount %>">
	  		    	<%
	  		    		int vbpqCounter = 0;
	  		  	
			  		  	if(Validator.equals(categoryType, "department")){		
			  		  		vbpqCounter = VBPQ_EntryLocalServiceUtil.countByDepartmentAndGroup(groupId, categoryId);
			  		  		
			  		  	}else if(Validator.equals(categoryType, "category")){
			  		  		vbpqCounter = VBPQ_EntryLocalServiceUtil.countByCategoryAndGroup(groupId, categoryId);
			  		  		
			  		  	}else{
			  		  		vbpqCounter = VBPQ_EntryLocalServiceUtil.countByDocTypeAndGroup(groupId, categoryId);
			  		  	}
	  		    	%>
		  		    	<span class="vbpq-counter">(<%=vbpqCounter%>)</span>
		  		    </c:if>
			    </li>
		<%
			}
		%>
	</ul>
</div>









