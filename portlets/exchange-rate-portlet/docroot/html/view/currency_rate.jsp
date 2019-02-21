<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>
<script type="text/javascript">
	function renderExchangeRateInfo() {
		$.ajax ({
			url:'/exchange-rate-portlet/html/view/getxml.jsp',
			dataType: 'text',
			
			data: {
				url: 'http://www.vietcombank.com.vn/ExchangeRates/ExrateXML.aspx'
			},
			success:function (xml){
				var exrateHtml = "";
				var isEven = false;
				var xmlDoc = jQuery.parseXML(xml.substring(xml.indexOf('<ExrateList>'),xml.length));
				var DateTime = $(xmlDoc).find('DateTime').text();
				var DateTime_ = DateTime.split('/');
				var CurrencyCodeCheck = "AUD,EUR,GBP,JPY,RUB,USD";
				
				$(xmlDoc).find('Exrate').each(function(){
					
					var CurrencyCode = $(this).attr('CurrencyCode');
					var CurrencyName = $(this).attr('CurrencyName');
					var Buy = $(this).attr('Buy');
					var Transfer = $(this).attr('Transfer');
					var Sell = $(this).attr('Sell');
					
					if (CurrencyCodeCheck.indexOf(CurrencyCode)>=0)
					{
					
						if (isEven)
						{
							isEven = false;
							exrateHtml += '<tr style = "background:#f4f4f4;">';
						}
						else
						{
							isEven = true;
							exrateHtml += '<tr>';
							
						}
						exrateHtml += '<td>'+CurrencyCode+'</td>';
						exrateHtml += '<td>'+(Buy=="0" ? "-" : Buy)+'</td>';
						exrateHtml += '<td>'+(Transfer=="0" ? "-" : Transfer)+'</td>';
						exrateHtml += '<td>'+(Sell=="0" ? "-" : Sell)+'</td>';
						exrateHtml += '</tr>';
					}
				});
				
				$('.exrate_content').html('');
				$('.exrate_content').append(exrateHtml);
				
				$('.exrate_info_date').html('Cập nhật: '+DateTime_[1]+'/'+DateTime_[0]+'/'+DateTime_[2]);
				
			}
		});
		}
	renderExchangeRateInfo();
</script>
<div id="foreign_currency_ex_rate">
	<center><p style = "font-size:14px;color:#00528b;"><b>Tỷ giá ngoại tệ</b></p></center>
	<p style = "font-size:12px;margin:0px;margin-left:15px;" class = "exrate_info_unit">Đơn vị: VNĐ</p>
	<table class = "exrate_table">
		<thead>
			<tr>
				<td>Mã ngoại tệ</td>
				<td>Mua tiền mặt</td>
				<td>Mua chuyển khoản</td>
				<td>Bán</td>
			</tr>
		</thead>
		<tbody class = "exrate_content">
			
		</tbody>
	</table>
	<p style = "font-size:11px;margin:0px;margin-left:15px;margin-top:5px;" class = "exrate_info_date"></p>
	<p style = "font-size:11px;margin:0px;margin-left:15px;" class = "exrate_info_source">Nguồn: Ngân hàng Ngoại thương Việt Nam</p>
</div>