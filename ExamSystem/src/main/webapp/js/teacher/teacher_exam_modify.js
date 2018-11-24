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
	$("#excelButton").click(function() {
		excelUpload();
	})
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
			alert("操作成功");
			location.reload();
		},
		error : function(data) {
			alert("操作失败");
		}
	});
}
/*
 * 导入名单
 */
function excelUpload() {
	var data = new FormData($("#excelForm")[0]);
	var URL = root + "/teacher/excelUpload";
	$.ajax({
		url : URL,
		type : "post",
		data : data,
		async : false,
		cache : false,
		processData : false,
		contentType : false,
		success : function(data) {
			if (data == "true") {
				alert("操作成功");
				location.reload();
			}
			if (data == "false") {
				alert("请检查文件格式");
			}
			
		},
		error : function(data) {
			alert("操作失败");
		}
	});
}
