$(function() {
	$("#excelButton").click(function() {
		excelUpload();
	});
	$("#back").click(function() {
		history.go(-1);
	});
	$("#addStudent").click(function() {
		editInsertStudent();
	});
	$(".deleteOnrStuent").click(function() {
		var stuid = $(this).attr("name");
		var stuname = $(this).parent().prev().prev().text();
		var stuclass = $(this).parent().prev().text();
		var data = {
			"stuid" : stuid,
			"stuname" : stuname,
			"stuclass" : stuclass
		}
		deleteOnrStuent(data);
	})
	$("#setPage").click(function() {
		var page_record = $("#record").val();
		data = {
			"page_record" : page_record
		}
		var URL = root + "/teacher/page_record";
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
	})
})
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

function editInsertStudent() {
	if ($("#stuid").val() == "" || $("#stuname").val() == ""
			|| $("#stuclass").val() == "") {
		alert("请输入完整信息");
		return false;
	}
	var data = $("#insertStudent").serialize();
	var URL = root + "/teacher/editInsertStudent";
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
function deleteOnrStuent(data) {

	var URL = root + "/teacher/deleteOnrStuent";
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