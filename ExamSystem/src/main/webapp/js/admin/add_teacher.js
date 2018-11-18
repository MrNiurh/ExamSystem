$(function() {
})

function addTeacher() {
	if ($("#t_name").val() == "" || $("#t_password").val() == ""
			|| $("#t_fullname").val() == "") {
		alert("请填写完整信息")

		return false;
	}
	if ($("#admin_signal").prop('checked')) {
		$("#admin").val(1);
	}else{
		$("#admin").val(0);
	}
	var data = $(".addTeacher").serialize();
	$.ajax({
		url : root + "/admin/insertTeacher",
		type : "post",
		data : data,
		dataType : 'json',
		success : function(data) {
			if (data == true) {
				alert("添加成功");
			} else {
				alert("用户名重复");
			}
		},
		error : function(data) {
			alert("用户名重复");
		}
	})

	return true;

}
