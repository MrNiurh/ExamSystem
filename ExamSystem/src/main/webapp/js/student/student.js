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
			alert("操作成功");
			location.reload();
		},
		error : function(data) {
			alert("操作失败");
		}
	});
}