$(function() {
	$("#testClean").click(function() {
		var data = {
			"testid" : $(this).attr("name"),
			"test_signal" : 4
		}
		updateSignal(data);
	});
	$("#testDel").click(function() {
		var data = {
			"testid" : $(this).attr("name"),
			"test_signal" : 5
		}
		updateSignal(data);
	})
})

function updateSignal(data) {
	var URL = root + "/admin/updateSignal"
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