$(function() {
	$("#updateTeacher").click(function() {
		updateTeacher();
	})
})

function updateTeacher() {
	if ($("#tname").val() == "" || $("#fullname").val() == "") {
		alert("请填写完整信息")

		return false;
	}
	if ($("#admin_signal").prop('checked')) {
		$("#admin").val(1);
	} else {
		$("#admin").val(0);
	}
	var data = $("#updateForm").serialize();
	$.ajax({
		url : root + "/admin/updateTeacherById",
		type : "post",
		data : data,
		dataType : 'json',
		success : function(data) {
			alert("操作成功");
			location.reload();
		},
		error : function(data) {
			alert("用户名重复");
		}
	})
}