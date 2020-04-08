<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<script type ="text/javascript">

	function renderGoldPriceInfo() {
		$.ajax ({
			url:'/exchange-rate-portlet/html/view/getxml.jsp',
			dataType: 'text',
			data: {
				url: 'http://www.sjc.com.vn/xml/tygiavang.xml'
			},
			error: function (a,b,c)
			{
				console.log("error");
			},
			success:function (xml){
				var goldpriceHtml = "";
				var isEven = false;
				var xmlDoc = jQuery.parseXML(xml.substring(xml.indexOf('<root>'),xml.length));
				var DateTime = $(xmlDoc).find('ratelist').attr('updated');
				var Unit = $(xmlDoc).find('ratelist').attr('unit');
				
				$(xmlDoc).find('city').each(function(){
					if (isEven)
					{
						isEven = false;
						goldpriceHtml += '<tr style = "background:#f4f4f4;">';
					}
					else
					{
						isEven = true;
						goldpriceHtml += '<tr>';
						
					}
					goldpriceHtml +='<td>'+$(this).attr('name')+'</td>';
					goldpriceHtml += '<td>'+$(this).find('item').first().attr('type')+'</td>';
					goldpriceHtml += '<td>'+$(this).find('item').first().attr('buy')+'</td>';
					goldpriceHtml += '<td>'+$(this).find('item').first().attr('sell')+'</td>';
					goldpriceHtml += '</tr>';
					/*
					
					exrateHtml += '<td>'+CurrencyCode+'</td>';
					exrateHtml += '<td>'+(Buy=="0" ? "-" : Buy)+'</td>';
					exrateHtml += '<td>'+(Transfer=="0" ? "-" : Transfer)+'</td>';
					exrateHtml += '<td>'+(Sell=="0" ? "-" : Sell)+'</td>';
					exrateHtml += '</tr>';
					*/
				});
				
				$('.goldprice_content').html('');
				$('.goldprice_content').append(goldpriceHtml);
				
				$('.goldprice_info_date').html('Cập nhật: '+DateTime);
				$('.goldprice_info_unit').html('Đơn vị: '+Unit);
				
			}
		});
		}
	renderGoldPriceInfo();
	
</script>

<div id="gold_price" >
	<center><p style = "font-size:14px;color:#00528b;"><b>Tỷ giá vàng</b></p></center>
	<p style = "font-size:12px;margin:0px;margin-left:15px;" class = "goldprice_info_unit"></p>
	<table class = "goldprice_table">
		<thead>
			<tr>
				<td style = "width: 32%;">Thành phố</td>
				<td>Loại vàng</td>
				<td>Mua</td>
				<td>Bán</td>
			</tr>
		</thead>
		<tbody class = "goldprice_content">
			
		</tbody>
	</table>
	<p style = "font-size:11px;margin:0px;margin-left:15px;margin-top:5px;" class = "goldprice_info_date"></p>
	<p style = "font-size:11px;margin:0px;margin-left:15px;" class = "goldprice_info_source">Nguồn: Công ty TNHH SJC</p>
</div>          
