$(function() {
	$("#update").click(function() {
		check();
	});
	$("#startTest").click(function() {
		var data = {
			"testid" : $(this).attr("name"),
			"test_signal" : 1
		}
		startTest(data);
	});
	$("#fileUpload").click(function() {
		fileUpload();
	});

})

function check() {
	if ($("#testname").val() == '' || $("#time1").val() == '') {
		alert("请输入完整信息");
		return false;
	}
	if ($("#auto_begin").prop("checked")) {
		$("#begin").val('1');

	} else {
		$("#begin").val('0');
	}
	var data = $("#updateForm").serialize();
	var URL = root + "/teacher/updateTest"
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
	return false;
}

function startTest(data) {
	var URL = root + "/teacher/updateSignal"
	$.ajax({
		url : URL,
		type : "post",
		data : data,
		dataType : 'json',
		async : true,
		success : function(data) {
			alert("考试已开启");
			location.reload();
		},
		error : function(data) {
			alert("操作失败");
		}
	});
}

function fileUpload() {
	var URL = root + "/teacher/teacherUpload";
	var data = new FormData($('#uploadForm')[0]);
	$.ajax({
		url : URL,
		type : "post",
		data : data,
		async : false,
		cache : false,
		processData : false,
		contentType : false,
		success : function(data) {
			if (data == "ok") {
				location.reload();
			}
			if (data == "min") {
				var min = $("#min").val();
				alert("文件必须大于" + min);
				location.reload();
			}
			if (data == "max") {
				alert("文件必须小于" + max);
				location.reload();
			}
		},
		error : function(data) {
			alert("操作失败");
		}
	});
}
