$(function() {

	$(".table").on("click", "#deleteTeacher", function() {
		var data = {
			"id" : $(this).next().val()
		}
		$.ajax({
			url : root + "/admin/deleteTeacherById",
			type : "post",
			data : data,
			dataType : 'json',
			success : function(data) {
				if (data == true) {
					location.reload();
				}
				if (data == false) {
					alert("有相关考试存在，无法删除")
				}

			},
			error : function(data) {
				alert("操作失败");
			}
		})
	})
})

function addTeacher() {
	if ($("#t_name").val() == "" || $("#t_password").val() == ""
			|| $("#t_fullname").val() == "") {
		alert("请填写完整信息")

		return false;
	}
	if ($("#admin_signal").prop('checked')) {
		$("#admin").val(1);
	} else {
		$("#admin").val(0);
	}
	var data = $(".addTeacher").serialize();
	$.ajax({
		url : root + "/admin/insertTeacher",
		type : "post",
		async : false,
		data : data,
		dataType : 'json',
		success : function(data) {
			if (data == true) {
				location.reload();
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
