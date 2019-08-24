<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String locale = LanguageUtil.getLanguageId(request).substring(0, 2);
	
	//Kieu hien thi mac dinh, hien thi thoi tiet Ha Noi
	String defaultCity = "Ha noi";
	
	String[] arrayCity = new String[]{"Ha noi", "Ho chi minh", "An giang", "Vung tau"
			 						  ,"Bac lieu", "Bac giang", "Bac kan"
			 						  ,"Bac ninh", "Ben tre", "Binh duong"
			 						  ,"Binh dinh", "Binh phuoc", "Binh thuan"
			 						  ,"Cao bang", "Ca mau", "Can tho"
			 						  ,"Hai phong", "Da nang", "Gia lai"
			 						  ,"Hoa binh", "Ha giang", "Ha nam"
			 						  ,"Ha tinh", "Hung yen", "Hai duong"
			 						  ,"Hau giang", "Dien bien", "Dak lak"
			 						  ,"Dak nong", "Dong nai", "Dong thap"
			 						  ,"Khanh hoa", "Kien giang", "Kon tum"
			 						  ,"Lai chau", "Long an", "Lao cai"
			 						  ,"Lam dong", "Lang son", "Nam dinh"
			 						  ,"Nghe an", "Ninh binh", "Ninh thuan"
			 						  ,"Phu tho", "Phu yen", "Quang binh"
			 						  ,"Quang nam", "Quang ngai", "Quang ninh"
			 						  ,"Quang tri", "Soc trang", "Son la"
			 						  ,"Thanh hoa", "Thai binh", "Thai nguyen"
			 						  ,"Hue", "Tien giang", "Tra vinh"
			 						  ,"Tuyen quang", "Tay ninh", "Vinh long"
			 						  ,"Vinh phuc", "Yen bai"
			 							};
	 
	String[] arrayCityVi = new String[]{"Hà Nội", "Hồ Chí Minh", "An Giang", "Bà Rịa - Vũng Tàu"
			  ,"Bạc Liêu", "Bắc Giang", "Bắc Kạn"
			  ,"Bắc Ninh", "Bến Tre", "Bình Dương"
			  ,"Bình Định", "Bình Phước", "Bình Thuận"
			  ,"Cao Bằng", "Cà Mau", "Cần Thơ"
			  ,"Hải Phòng", "Đà Nẵng", "Gia Lai"
			  ,"Hòa Bình", "Hà Giang", "Hà Nam"
			  ,"Hà Tĩnh", "Hưng Yên", "Hải Dương"
			  ,"Hậu Giang", "Điện Biên", "Đắk Lắk"
			  ,"Đắk Nông", "Đồng Nai", "Đồng Tháp"
			  ,"Khánh Hòa", "Kiên Giang", "Kon Tum"
			  ,"Lai Châu", "Long An", "Lào Cai"
			  ,"Lâm Đồng", "Lạng Son", "Nam Định"
			  ,"Nghệ An", "Ninh Bình", "Ninh Thuận"
			  ,"Phú Thọ", "Phú Yên", "Quảng Bình"
			  ,"Quảng Nam", "Quảng Ngãi", "Quảng Ninh"
			  ,"Quảng Trị", "Sóc Trăng", "Sơn La"
			  ,"Thanh Hóa", "Thái Bình", "Thái Nguyên"
			  ,"Huế", "Tiền Giang", "Trà Vinh"
			  ,"Tuyên Quang", "Tây Ninh", "Vĩnh Long"
			  ,"Vĩnh Phúc", "Yên Bái"
				};
	
	String displayCity = preferences.getValue("displayCity", defaultCity);
	
	String arrayCityViStr = "Hà Nội,Hồ Chí Minh,An Giang,Bà Rịa - Vũng Tàu"
			  +",Bạc Liêu,Bắc Giang,Bắc Kạn"
			  +",Bắc Ninh,Bến Tre,Bình Dương"
			  +",Bình Định,Bình Phước,Bình Thuận"
			  +",Cao Bằng,Cà Mau,Cần Thơ"
			  +",Hải Phòng,Đà Nẵng,Gia Lai"
			  +",Hòa Bình,Hà Giang,Hà Nam"
			  +",Ha Tĩnh,Hưng Yên,Hải Dương"
			  +",Hậu Giang,Điện Biên,Đắk Lắk"
			  +",Đắk Nông,Đồng Nai,Đồng Tháp"
			  +",Khánh Hòa,Kiên Giang,Kon Tum"
			  +",Lai Châu,Long An,Lào Cai"
			  +",Lâm Đồng,Lạng Son,Nam Định"
			  +",Nghệ An,Ninh Bình,Ninh Thuận"
			  +",Phú Thọ,Phú Yên,Quảng Bình"
			  +",Quảng Nam,Quảng Ngãi,Quảng Ninh"
			  +",Quảng Trị,Sóc Trăng,Sơn La"
			  +",Thanh Hóa,Thái Bình,Thái Nguyên"
			  +",Huế,Tiền Giang,Trà Vinh"
			  +",Tuyên Quang,Tây Ninh,Vĩnh Long"
			  +",Vĩnh Phúc,Yên Bái";
	
	String arrayCityStr = Arrays.toString(arrayCity);
	
%>