<%@page import="java.util.Date"%>
<%@page import="com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.model.Employee"%>
<%@page import="com.bkav.portal.portlet.employee.search.EmployeeSearch"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.bkav.portal.portlet.employee.service.PostLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.model.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.model.Department"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
  List<Department> listDep = DepartmentLocalServiceUtil.findByGroup(groupId);
  List<Post> listPost = PostLocalServiceUtil.findByGroup(groupId);
  long depId = ParamUtil.getLong(request, "department");
  long postId = ParamUtil.getLong(request, "post");
  String searchName = ParamUtil.getString(request, "name");
  int emplIndex = 0;
  
  int dayStart  = ParamUtil.getInteger(request, "dayStart", 11);
  int monthStart = ParamUtil.getInteger(request, "monthStart", 4);
  int yearStart = ParamUtil.getInteger(request, "yearStart", 1990);
  Calendar calendar = Calendar.getInstance();
  calendar.set(yearStart, monthStart, dayStart);
  calendar.getTime();
  int dayEnd  = ParamUtil.getInteger(request, "dayEnd", 11);
  int monthEnd = ParamUtil.getInteger(request, "monthEnd", 4);
  int yearEnd = ParamUtil.getInteger(request, "yearEnd", 1990);
  String createDate = yearStart+ "-" + monthStart + "-" + dayStart;
  monthEnd++;
  monthStart++;
  String endDate = yearEnd+ "-" + monthEnd + "-" + dayEnd;
%>

<liferay-portlet:renderURL var="statisticalAdminHomePageURL">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="tabs1" value="statistical"/>
</liferay-portlet:renderURL>



<div class="statiscals-form" align="left">
<aui:form method="post" action="<%=statisticalAdminHomePageURL %>" name="statistical">
<table>
   <tr>
       <td>Tên nhân viên</td>
       <td>
           <aui:input name="name" label=""></aui:input>
       </td>
   </tr>
   <tr>
       <td>Phòng ban</td>
       <td class="select">
          <aui:select label="" name="department">
              <aui:option label="" value="" />
			<%
			  for(Department dep : listDep){
			%>
			  <aui:option label="<%=dep.getDepName() %>" value="<%=dep.getDepId() %>" />
			<%
			  }
			%>  
	      </aui:select>
	    </td>  
	</tr>
	<tr>
	    <td>Chức vụ</td>
	    <td class="select"> 
	       <aui:select label="" name="post">
	          <aui:option label="" value="" />
			<%
			  for(Post post : listPost){
			%>
			  <aui:option label="<%=post.getPostName() %>" value="<%=post.getPostId() %>" />
			<%
			  }
			%>  
	       </aui:select>
	    </td>
	</tr>
	<tr>
	    <td></td>
	    <td>
	        <liferay-ui:input-date
                disabled="<%=false %>"
                dayValue="<%=dayStart %>"
                monthValue="<%=monthStart -1%>"
                yearValue="<%=yearStart %>"
                dayParam="dayStart"
                monthParam="monthStart"
                yearParam="yearStart"
                yearRangeStart="2000"
                yearRangeEnd="2020"
                firstDayOfWeek="0">
            </liferay-ui:input-date>
            </br>
            </br>
            <liferay-ui:input-date
                disabled="<%=false %>"
                dayValue="<%=dayEnd %>"
                monthValue="<%=monthEnd-1%>"
                yearValue="<%=yearEnd %>"
                dayParam="dayEnd"
                monthParam="monthEnd"
                yearParam="yearEnd"
                yearRangeStart="2000"
                yearRangeEnd="2020"
                firstDayOfWeek="<%=Calendar.MONDAY -1 %>">
            </liferay-ui:input-date>
	        
	        
	        <aui:input name="check" type="checkbox" label=""/>
	    </td>
	</tr>
	    <td></td>
	    <liferay-portlet:renderURL var="emploueeDelAdminHomePageURL">
	       <liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	       <liferay-portlet:param name="tabs1" value="statistical"/>
	       <liferay-portlet:param name="command" value="commandEmployeeDel"/>
        </liferay-portlet:renderURL>
	    <td>
	       <aui:button name="statistical" value="statistical" type="submit"></aui:button>
	       <aui:button name="cancle" value="cancle" type="button" href="<%=statisticalAdminHomePageURL %>"></aui:button>
	       <aui:button  value="employeeDel" name="employeeDel" type="button" href="<%=emploueeDelAdminHomePageURL %>"></aui:button>
	    </td>   
</table>	
</aui:form>
</div>
</br>
  <%
	PortletURL portletURL = renderResponse.createRenderURL();
	EmployeeSearch employeeSearch = new EmployeeSearch(renderRequest,portletURL);
	Boolean check = ParamUtil.getBoolean(request, "check");

    String command = ParamUtil.getString(request, "command");
%>

<c:choose>
<c:when test='<%=Validator.equals(command, "commandEmployeeDel")%>'>
    <liferay-ui:search-container searchContainer="<%=employeeSearch%>" emptyResultsMessage="no-entry-found" >
		    <%
		    List<Employee> listEmployeeSortAble = EmployeeLocalServiceUtil.findByKeyword(groupId, depId, postId, 
		    searchName, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator(), "false", "2000-10-10", "2015-10-10", command); 
	     	%>
			<liferay-ui:search-container-results
				results="<%=listEmployeeSortAble%>"
				total="<%=listEmployeeSortAble.size() %>"
			/>			
		    
			<liferay-ui:search-container-row className="Employee"  keyProperty="emplId" modelVar="employee" >
			    
			    <%
		          emplIndex++;
			    %>

				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(emplIndex) %>"/>
					
				<liferay-ui:search-container-column-text name="employee-name" value="<%=employee.getName()%>"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(employee.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=employee.getUserName()%>"/>

			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=true %>"/>
</liferay-ui:search-container>
</c:when>
<c:otherwise>
<liferay-ui:search-container searchContainer="<%=employeeSearch%>" emptyResultsMessage="no-entry-found" >
		    <%
		    List<Employee> listEmployeeSortAble = EmployeeLocalServiceUtil.findByKeyword(groupId, depId, postId, searchName, 
		    searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator(), String.valueOf(check), createDate, endDate, command); 
	     	%>
			<liferay-ui:search-container-results
				results="<%=listEmployeeSortAble%>"
				total="<%=listEmployeeSortAble.size() %>"
			/>			
		    
			<liferay-ui:search-container-row className="Employee"  keyProperty="emplId" modelVar="employee" >
			    
			    <%
		          emplIndex++;
			    %>

				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(emplIndex) %>"/>
					
				<liferay-ui:search-container-column-text name="employee-name" value="<%=employee.getName()%>"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(employee.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=employee.getUserName()%>"/>

			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=true %>"/>
</liferay-ui:search-container>
</c:otherwise>
</c:choose>

