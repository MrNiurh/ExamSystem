$(function() {
	$("#addTest").click(function() {
		check();
	})
})

function check() {
	if ($("#testname").val() == '' || $("#time1").val() == '') {
		alert("请输入完整信息");
		return false;
	}
	if ($("#auto_begin").prop("checked")) {
		$("#begin").val('1');
		
	}else{
		$("#begin").val('0');
	}
	var data = $("#TestForm").serialize();
	var URL = root + "/teacher/insertTest"
	$.ajax({
		url : URL,
		type : "post",
		data : data,
		dataType : 'json',
		async : true,
		success : function(data) {
			location.reload();
		},
		error : function(data) {
			alert("请勿添加相同考试名");
		}
	});
	return false;
}