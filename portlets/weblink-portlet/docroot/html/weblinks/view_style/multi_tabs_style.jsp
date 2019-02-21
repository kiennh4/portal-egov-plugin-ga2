<%@page import="java.util.ArrayList"%>
<%@page
	import="com.portal_egov.portlet.weblinks.service.WeblinkLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.Weblink"%>
<%@page import="com.portal_egov.portlet.weblinks.util.WeblinkUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.WeblinkCategory"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks/init.jsp"%>

<%
	List<WeblinkCategory> selectedCategoryList = WeblinkUtil.getCategoryTabs(selectedWeblinkTabIds);
%>

<div class="weblink_multi_tabs_display_style">
	<div class="weblink_tab_names">
		<ul>
			<%
				for(WeblinkCategory selectedCategory : selectedCategoryList){
					
						long tabId = selectedCategory.getCategoryId();
						String tabName = selectedCategory.getCategoryName();
			%>
			<li id="<%=tabId%>" class="weblink_tab_name"><a
				href="javascript:;"><%=tabName%></a></li>
			<%
				}
			%>
		</ul>
	</div>

	<div class="weblink_tab_contents">
		<%
			for(WeblinkCategory selectedCategory : selectedCategoryList){
			
				long selectedCategoryTabId = selectedCategory.getCategoryId();
			
				List<Weblink> weblinkList = new ArrayList<Weblink>();
			
				if(numbersOfWeblinkPerTab <= 0){
				
					weblinkList = WeblinkLocalServiceUtil.findByCategory(selectedCategoryTabId);
				} else{
				
					weblinkList = WeblinkLocalServiceUtil.findByCategory(selectedCategoryTabId,0,numbersOfWeblinkPerTab);
				}
				int size = weblinkList.size();
				int d = size/3;
				int t = size %3;
				int index = d+t;
		%>
		<div id="tab<%=String.valueOf(selectedCategoryTabId)%>"
			class="<%="tabContent" + String.valueOf(selectedCategoryTabId)%> weblink-tab-content">
			<%
				if(size < 6){
			%>
			<ul>
				<%
					for(Weblink weblink : weblinkList){					
									String weblinkName = weblink.getWeblinkName();
									String weblinkURL = weblink.getWeblinkURL();
				%>
				<li><a href="<%=weblinkURL%>" target="_blank"><%=weblinkName%></a>
				</li>
				<%
					}
				%>
			</ul>
			<%
				} else{
			%>
			<ul>
				<%
					for(Weblink weblink : weblinkList.subList(0, index)){					
									String weblinkName = weblink.getWeblinkName();
									String weblinkURL = weblink.getWeblinkURL();
				%>
				<li><a href="<%=weblinkURL%>" target="_blank"><%=weblinkName%></a>
				</li>
				<%
					}
				%>
			</ul>
			<ul>
				<%
					for(Weblink weblink : weblinkList.subList(index, index+d)){					
									String weblinkName = weblink.getWeblinkName();
									String weblinkURL = weblink.getWeblinkURL();
				%>
				<li><a href="<%=weblinkURL%>" target="_blank"><%=weblinkName%></a>
				</li>
				<%
					}
				%>
			</ul>
			<ul>
				<%
					for(Weblink weblink : weblinkList.subList(index + d, size)){					
									String weblinkName = weblink.getWeblinkName();
									String weblinkURL = weblink.getWeblinkURL();
				%>
				<li><a href="<%=weblinkURL%>" target="_blank"><%=weblinkName%></a>
				</li>
				<%
					}
				%>
			</ul>
			<%
				}
			%>
			<div style="clear: both;"></div>
		</div>
		<%
			}
		%>
	</div>
</div>
<script>
	$(document).ready(function() {
		// Hàm active tab nào đó
		function activeTab(obj) {
			// Xóa class active tất cả các tab
			$('.weblink_tab_names ul li').removeClass('weblink-active-tab');

			// Thêm class active vòa tab đang click
			$(obj).addClass('weblink-active-tab');

			// Lấy href của tab để show content tương ứng
			var id = $(obj).attr('id');
			console.log(id);
			// Ẩn hết nội dung các tab đang hiển thị
			$('.weblink-tab-content').hide();

			// Hiển thị nội dung của tab hiện tại
			var idTab = "#tab" + id;

			$(idTab).show();
		}

		// Sự kiện click đổi tab
		$('.weblink_tab_names li').click(function() {
			activeTab(this);
			return false;
		});

		// Active tab đầu tiên khi trang web được chạy
		activeTab($('.weblink_tab_names li:first-child'));
	});
</script>





















