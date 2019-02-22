<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.Weblink"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks/init.jsp"%>

<%
	//selectedCategoryId = Chuyen muc lien ket duoc chon trong trang config
	//numbersOfWeblinkDisplayList = So luong lien ket hien thi chon trong trang config
	
	//Danh sach lien ket lay theo chuyen muc va so luong hien thi duoc chon trong trang config
	List<Weblink> weblinkList = new ArrayList<Weblink>();

	if(numbersOfWeblinkDisplayList <= 0){//Khong gioi han so luong lien ket hien thi
		
		weblinkList = WeblinkLocalServiceUtil.findByCategory(selectedCategoryId);
		
	}else{//Co gioi han so luong lien ket hien thi
		
		weblinkList = WeblinkLocalServiceUtil.findByCategory(selectedCategoryId,0,numbersOfWeblinkDisplayList);
	}
%>

<div class="weblink_list_title_display_style">
	<ul>
		<%
		for(Weblink weblink : weblinkList){
			
			String weblinkName = weblink.getWeblinkName();
			
			String weblinkURL = weblink.getWeblinkURL();
		%>
		<li>
			<a href="<%=weblinkURL%>" target="_blank"><%=weblinkName %></a>
		</li>
		<%
		}
		%>
	</ul>
</div>
