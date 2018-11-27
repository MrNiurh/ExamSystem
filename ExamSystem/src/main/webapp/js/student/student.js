$(function() {
	$("#fileUpload").click(function() {
		fileUpload();
	});
})

function fileUpload() {
	var URL = root + "/student/studentUpload";
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