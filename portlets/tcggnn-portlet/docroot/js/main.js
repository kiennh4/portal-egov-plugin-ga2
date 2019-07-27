function submitForm() {
	var citizenName = $("#citizenName").val();
	var citizenCode = $("#citizenCode").val();
	var citizenEmail = $("#citizenEmail").val();
	var citizenPhone = $("#citizenPhone").val();
	var b = true;
	if(citizenName.length == 0){
		$("#errorCitizenName").text("Tên công dân/doanh nghiệp chưa khai báo hoặc độ dài quá ngắn");
		b= false;
	}
	if(citizenCode.length < 9 || citizenCode.length > 12){
		$("#errorCitizenCode").text("Số CMND/GPKD chưa khai báo hoặc độ dài không nằm trong khoảng 9 - 12 ký tự");
		b = false;
	}
	if(isEmail(citizenEmail) == true){
		$("#errorCitizenEmail").text("Địa chỉ thư điện tử chưa khai báo hoặc không đúng định dạng");
		b = false;
	}
	if(citizenPhone.length > 11){
		$("#errorCitizenPhone").text("Số điện thoại chưa khai báo, chứa chữ số hoặc đồ dài không hợp lệ");
		b = false;
	}
	return b;
}
function isEmail(email) {
	var regexStr = "/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/";
	var regex = new RegExp(regexStr);
	return regex.test(email);
}

$("#lookup-button").on("click",function(){
	var docCode = $("#documentId").val();
	if(docCode.length == 0){
		alert("Nhập mã số biên nhận");
	} else {
		var data = {"docCode" : docCode};
		$.ajax({
			url: "http://13.250.173.193:8280/services/Search",
			type: "post",
			data: data,
			dataType: "json",
			success: function (resp) {
				$("#documentId").val("");
				console.log(resp);
				var citizenName = resp.CitizenName;
				var Compendium = resp.Compendium;
				var CurrentDept = resp.CurrentDept;
				var DocCode = resp.DocCode;
				var Phone = resp.Phone;
				var tmp = '<table>' +
					'<tr> <th>Tên hồ sơ</th> <th>Người đăng kí</th> <th>Số điện thoại</th><th>Mã hồ sơ</th> <th>Phòng ban tiếp nhận</th> </tr>' 
					+'<tr> <td>' + Compendium +'</td>'+
					'<td>'+ citizenName +'</td> <td>'+Phone+'</td>' + '<td>'+DocCode+'</td>' + '<td>'+CurrentDept+'</td>' +'</tr>'
					'</table>';
				$("#result-search").empty();
				$("#result-search").append(tmp);
			},
			error: function (error) {
				console.log(error);
			}
		});
	}
});