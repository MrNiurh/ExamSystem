$(function() {
	$("#endTest").click(function() {
		var data = {
			"testid" : $(this).attr("name"),
			"test_signal" : 2
		}
		endTest(data);

	})
})

function endTest(data) {
	var URL = root + "/teacher/updateSignal"
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