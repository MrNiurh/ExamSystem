$(function() {

	$("#submit").click(function() {
		systemSubmit();
	})
})

function systemSubmit() {

	if ($("#teacher_c").prop("checked")) {
		$("#Sclear").val('1');
	} else {
		$("#Sclear").val('0');
	}
	var data = $(".settings").serialize();
	var URL = root + "/admin/updateSystem";
	$.ajax({
		url : URL,
		type : "post",
		data : data,
		dataType : 'json',
		success : function(data) {
			alert("修改成功");
			location.reload();
		},
		error : function(data) {
			alert("修改失败");
			location.reload();
		}
	})

}