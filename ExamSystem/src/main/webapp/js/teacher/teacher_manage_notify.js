$(function() {
	$("#addInfo").click(function() {
		insertNotify();
	});
	$("#deleteInfo").click(function() {
		deleteInfo($(this).parent().prev().text());

	})
})
function insertNotify() {
	if ($("#info").val() == "") {
		alert("通知不能为空");
		return false;
	}
	var URL = root + "/teacher/insertNotify";
	var data = $("#notify").serialize();
	$("#info").val("");
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
			alert("操作失败");
		}
	});
}

function deleteInfo(info) {
	var URL = root + "/teacher/deleteInfo";
	var data = {
		"info" : info
	}
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
			alert("操作失败");
		}
	});
}