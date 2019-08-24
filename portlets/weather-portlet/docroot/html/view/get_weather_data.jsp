<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String url = request.getParameter("url");
	System.out.println(url);
%>
<c:import url="<%=url %>" charEncoding = "UTF-8"/> 