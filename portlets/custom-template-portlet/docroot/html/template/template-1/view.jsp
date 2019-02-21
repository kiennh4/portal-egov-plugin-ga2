<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>
<div class="custom-template-1">
	<c:if test="<%=Validator.isNotNull(styleTitle)%>">
		<div class="style-title">
			<h3><%=styleTitle%></h3>
			<div class="sperator"></div>
		</div>
	</c:if>
	<div class="div_Nophoso">
		<b class="title_Nophoso">Nộp hồ sơ</b>
		<div class="div_dangky">
			<div class="dk_colfull">
				<div class="dk_colleft">
					<span class="nhap">*</span>Họ và tên
				</div>
				<div class="dk_colright">
					<input type="text" class="textbox_dk">
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">
					<span class="nhap">*</span>Học hàm, học vị
				</div>
				<div class="dk_colright">
					<input type="text" class="textbox_dk">
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">
					<span class="nhap">*</span>Số điện thoại
				</div>
				<div class="dk_colright">
					<input type="text" class="textbox_dk">
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">
					<span class="nhap">*</span>Cơ quan công tác
				</div>
				<div class="dk_colright">
					<input type="text" class="textbox_dk">
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">
					<span class="nhap">*</span>Lĩnh vực khoa học hồ sơ
				</div>
				<div class="dk_colright">
					<input type="text" class="textbox_dk">
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">Trích yếu nội dung</div>
				<div class="dk_colright">
					<textarea rows="3" cols="20" class="textbox_dk"></textarea>
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">Kết quả đào tạo bồi dưỡng</div>
				<div class="dk_colright">
					<textarea rows="3" cols="20" class="textbox_dk"></textarea>
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">Ghi chú</div>
				<div class="dk_colright">
					<textarea rows="3" cols="20" class="textbox_dk"></textarea>
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft">
					<span class="nhap">*</span>File đính kèm (cho phép đính kèm nhiều
					file)
				</div>
				<div class="dk_colright">
					<div id="main_file">
						<input type="file" onchange="AddFile(this)" style="width: 50%;">
					</div>
					<ul id="file_name" class="add_filehoso">

					</ul>
					<div style="display: none;">
						<input type="text">
					</div>
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft_no"></div>
				<div class="dk_colright_no">
					<span style="color: Red;"></span>
				</div>
			</div>
			<div class="dk_colfull">
				<div class="dk_colleft_no"></div>
				<div class="dk_colright_no">
					<input type="submit" value="Nộp hồ sơ" onclick="" class="button">
				</div>
			</div>
		</div>
	</div>
</div>